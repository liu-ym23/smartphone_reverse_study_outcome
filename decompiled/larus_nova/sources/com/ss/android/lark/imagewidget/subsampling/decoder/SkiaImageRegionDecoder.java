package com.ss.android.lark.imagewidget.subsampling.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.lark.log.Log;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import rlb.d;

/* JADX INFO: loaded from: classes36.dex */
public class SkiaImageRegionDecoder implements d {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";
    private static final String TAG = "SkiaImageRegionDecoder";
    private final Bitmap.Config bitmapConfig;
    private BitmapRegionDecoder decoder;
    private final ReadWriteLock decoderLock;

    public SkiaImageRegionDecoder() {
        this(null);
    }

    @Override // rlb.d
    public synchronized boolean isReady() {
        monitor-enter(this);
        BitmapRegionDecoder r100 = this.decoder;     // Catch: Throwable -> L11
        if (r100 == null) goto L8;
        if (r100.isRecycled() == true) goto L8;
        boolean r101 = true;
    L9:
        monitor-exit(this);
        return r101;
    L8:
        r101 = false;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // rlb.d
    public synchronized void recycle() {
        monitor-enter(this);
        this.decoderLock.writeLock().lock();     // Catch: Throwable -> L11
        this.decoder.recycle();     // Catch: Throwable -> L8
        this.decoder = null;     // Catch: Throwable -> L8
        this.decoderLock.writeLock().unlock();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        this.decoderLock.writeLock().unlock();     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private Lock getDecodeLock() {
        return this.decoderLock.readLock();
    }

    public SkiaImageRegionDecoder(Bitmap.Config r100) {
        this.decoderLock = new ReentrantReadWriteLock(true);
        Bitmap.Config r101 = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (r100 == null) goto L5;
        this.bitmapConfig = r100;
        return;
    L5:
        if (r101 == null) goto L7;
        this.bitmapConfig = r101;
        return;
    L7:
        this.bitmapConfig = Bitmap.Config.RGB_565;
    }

    @Override // rlb.d
    public Bitmap decodeRegion(Rect r100, int r101) {
        getDecodeLock().lock();
        BitmapRegionDecoder r102 = this.decoder;     // Catch: Throwable -> L16
        if (r102 != null) goto L7;
    L14:
        Log.e(TAG, "Cannot decode region after decoder has been recycled");     // Catch: Throwable -> L16
        throw new IllegalStateException(TAG);     // Catch: Throwable -> L16
    L7:
        if (r102.isRecycled() == true) goto L14;
        BitmapFactory.Options r103 = new BitmapFactory.Options();     // Catch: Throwable -> L16
        r103.inSampleSize = r101;     // Catch: Throwable -> L16
        r103.inPreferredConfig = this.bitmapConfig;     // Catch: Throwable -> L16
        Bitmap r104 = this.decoder.decodeRegion(r100, r103);     // Catch: Throwable -> L16
        if (r104 == null) goto L12;
        getDecodeLock().unlock();
        return r104;
    L12:
        Log.e(TAG, "Skia image decoder returned null bitmap - image format may not be supported");     // Catch: Throwable -> L16
        throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        getDecodeLock().unlock();
        throw th;
    }

    @Override // rlb.d
    public Point init(Context r100, Uri r101) throws Exception {
        String r102 = r101.toString();
        if (r102.startsWith(RESOURCE_PREFIX) == false) goto L21;
        String r103 = r101.getAuthority();
        if (r100.getPackageName().equals(r103) == false) goto L7;
        Resources r104 = r100.getResources();
    L8:
        List<String> r105 = r101.getPathSegments();
        int r106 = r105.size();
        if (r106 == 2) goto L11;
    L13:
        if (r106 == 1) goto L15;
    L18:
        int r107 = 0;
    L19:
        this.decoder = BitmapRegionDecoder.newInstance(r100.getResources().openRawResource(r107), false);
    L32:
        return new Point(this.decoder.getWidth(), this.decoder.getHeight());
    L15:
        if (TextUtils.isDigitsOnly((CharSequence) ListProtector.get(r105, 0)) == false) goto L18;
        r107 = CastIntegerProtector.parseInt((String) ListProtector.get(r105, 0));     // Catch: NumberFormatException -> L40
    L11:
        if (((String) ListProtector.get(r105, 0)).equals("drawable") == false) goto L13;
        r107 = r104.getIdentifier((String) ListProtector.get(r105, 1), "drawable", r103);
        goto L19
    L7:
        r104 = r100.getPackageManager().getResourcesForApplication(r103);
        goto L8
    L21:
        if (r102.startsWith(ASSET_PREFIX) == false) goto L24;
        String r108 = r102.substring(22);
        this.decoder = BitmapRegionDecoder.newInstance(r100.getAssets().open(r108, 1), false);
        goto L32
    L24:
        if (r102.startsWith("file://") == false) goto L26;
        this.decoder = BitmapRegionDecoder.newInstance(r102.substring(7), false);
        goto L32
    L26:
        InputStream r109 = null;
        InputStream r110 = ContentResolverWrapper.openInputStream(r100.getContentResolver(), r101);     // Catch: Throwable -> L35
        if (r110 == null) goto L33;
        this.decoder = BitmapRegionDecoder.newInstance(r110, false);     // Catch: Throwable -> L35
        r110.close();     // Catch: Exception -> L39
        goto L32
    L33:
        Log.e(TAG, "Content resolver returned null stream. Unable to initialise with uri.");     // Catch: Throwable -> L35
        throw new Exception("Content resolver returned null stream. Unable to initialise with uri.");     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        if (0 != 0) goto L42;
    L38:
        throw th;
    L42:
        r109.close();     // Catch: Exception -> L41
        goto L38
    }
}
