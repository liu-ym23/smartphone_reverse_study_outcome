package com.ss.android.lark.imagewidget.subsampling.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.lark.log.Log;
import java.io.InputStream;
import java.util.List;
import rlb.c;

/* JADX INFO: loaded from: classes36.dex */
public class SkiaImageDecoder implements c {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";
    private static final String TAG = "SkiaImageDecoder";
    private final Bitmap.Config bitmapConfig;

    public SkiaImageDecoder() {
        this(null);
    }

    public SkiaImageDecoder(Bitmap.Config r100) {
        Bitmap.Config r101 = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (r100 == null) goto L5;
        this.bitmapConfig = r100;
        return;
    L5:
        if (r101 == null) goto L7;
        this.bitmapConfig = r101;
        return;
    L7:
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
    }

    @Override // rlb.c
    public Bitmap decode(Context r100, Uri r110) throws Exception {
        String r101 = r110.toString();
        BitmapFactory.Options r102 = new BitmapFactory.Options();
        r102.inPreferredConfig = this.bitmapConfig;
        if (r101.startsWith(RESOURCE_PREFIX) == false) goto L18;
        String r103 = r110.getAuthority();
        if (r100.getPackageName().equals(r103) == false) goto L7;
        Resources r104 = r100.getResources();
    L8:
        List<String> r111 = r110.getPathSegments();
        int r105 = r111.size();
        int r106 = 0;
        if (r105 == 2) goto L11;
    L13:
        if (r105 == 1) goto L15;
    L17:
        Bitmap r107 = BitmapFactory.decodeResource(r100.getResources(), r106, r102);
    L31:
        if (r107 == null) goto L33;
        return r107;
    L33:
        Log.e(TAG, "Skia image region decoder returned null bitmap - image format may not be supported");
        throw new RuntimeException("Skia image region decoder returned null bitmap - image format may not be supported");
    L15:
        if (TextUtils.isDigitsOnly((CharSequence) ListProtector.get(r111, 0)) == false) goto L17;
        r106 = CastIntegerProtector.parseInt((String) ListProtector.get(r111, 0));     // Catch: NumberFormatException -> L41
        goto L17
    L11:
        if (((String) ListProtector.get(r111, 0)).equals("drawable") == false) goto L13;
        r106 = r104.getIdentifier((String) ListProtector.get(r111, 1), "drawable", r103);
        goto L17
    L7:
        r104 = r100.getPackageManager().getResourcesForApplication(r103);
        goto L8
    L18:
        InputStream r108 = null;
        if (r101.startsWith(ASSET_PREFIX) == false) goto L22;
        String r112 = r101.substring(22);
        r107 = BitmapFactory.decodeStream(r100.getAssets().open(r112), null, r102);
        goto L31
    L22:
        if (r101.startsWith("file://") == false) goto L49;
        r107 = BitmapFactory.decodeFile(r101.substring(7), r102);
        goto L31
    L49:
        InputStream r109 = ContentResolverWrapper.openInputStream(r100.getContentResolver(), r110);     // Catch: Throwable -> L37
        Bitmap r113 = BitmapFactory.decodeStream(r109, null, r102);     // Catch: Throwable -> L35
        if (r109 != null) goto L43;
    L30:
        r107 = r113;
        goto L31
    L43:
        r109.close();     // Catch: Exception -> L29
    L35:
        th = th;
        r108 = r109;
    L38:
        if (r108 != null) goto L51;
    L40:
        throw th;
    L51:
        r108.close();     // Catch: Exception -> L42
    L37:
        th = th;
        goto L38
    }
}
