package com.ss.android.lark.imagewidget.subsampling.decoder.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import com.bumptech.glide.integration.heif.bean.Heif;
import com.bumptech.glide.integration.heif.bean.HeifData;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFiles;
import java.io.Closeable;
import java.io.InputStream;
import rlb.d;
import skb.a;

/* JADX INFO: loaded from: classes36.dex */
public class HeifImageRegionDecoder implements d {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String TAG = "HeifImageRegionDecoder";
    private byte[] data;

    public HeifImageRegionDecoder() {
    }

    @Override // rlb.d
    public void recycle() {
        this.data = null;
    }

    @Override // rlb.d
    public boolean isReady() {
        if (this.data == null) goto L5;
        return true;
    L5:
        return false;
    }

    private byte[] readUri(String r100) {
        Closeable r101 = null;
        byte[] r102 = null;
        if (r100 != null) goto L33;
        return null;
    L33:
    L22:
        e = e;
        Closeable r103 = null;
    L31:
        Log.e(TAG, "readUri failed:" + e.toString());     // Catch: Throwable -> L27
        com.larksuite.framework.utils.d.b(new Closeable[]{r103});
    L26:
        return r102;
    L27:
        th = th;
        r101 = r103;
    L29:
        com.larksuite.framework.utils.d.b(new Closeable[]{r101});
        throw th;
    L20:
        th = th;
        goto L29
    L7:
        if (r100.startsWith(ASSET_PREFIX) == false) goto L10;
        InputStream r104 = LarkContext.getApplication().getAssets().open(r100.substring(22), 1);     // Catch: Throwable -> L20 Exception -> L22
    L34:
        r102 = a.b(r104);     // Catch: Throwable -> L16 Exception -> L18
        com.larksuite.framework.utils.d.b(new Closeable[]{r104});
        goto L26
    L18:
        e = move-exception;
        r103 = r104;
        e = e;
    L16:
        th = move-exception;
        r101 = r104;
        th = th;
        goto L29
    L10:
        if (r100.startsWith("file://") == false) goto L13;
        r104 = VFSFiles.f444819b.k(r100.substring(7));     // Catch: Throwable -> L20 Exception -> L22
        goto L34
    L13:
        r104 = null;
        goto L34
    }

    @Override // rlb.d
    public Bitmap decodeRegion(Rect r110, int r111) {
        Log.i(TAG, "decodeRegion" + r111);
        byte[] r100 = this.data;
        Bitmap r101 = null;
        if (r100 != null) goto L5;
    L11:
        if (r101 == null) goto L15;
        Log.i(TAG, "size:" + ((r101.getByteCount() / 1024) / 1024));
        return r101;
    L15:
        throw new RuntimeException("decode heif region failed");
    L5:
        if (r111 >= 1) goto L7;
        int r102 = 1;
    L8:
        HeifData r112 = Heif.toRgba(r100, r100.length, false, r102, r110.left, r110.top, r110.height(), r110.width());
        if (r112 == null) goto L11;
        r101 = r112.newBitmap(null);
        goto L11
    L7:
        r102 = r111;
        goto L8
    }

    @Override // rlb.d
    public Point init(Context r100, Uri r101) throws Exception {
        byte[] r102 = readUri(r101.toString());
        this.data = r102;
        if (r102 == null) goto L11;
        int[] r103 = Heif.parseSimpleMeta(r102, r102.length);
        if (r103 == null) goto L11;
        if (r103.length < 2) goto L11;
        return new Point(r103[0], r103[1]);
    L11:
        throw new RuntimeException("parse heif meta failed");
    }
}
