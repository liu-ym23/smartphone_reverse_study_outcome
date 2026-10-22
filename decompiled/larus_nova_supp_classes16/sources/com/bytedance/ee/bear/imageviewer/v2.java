package com.bytedance.ee.bear.imageviewer;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.larksuite.framework.utils.MediaStoreUtil;
import io.reactivex.functions.Function;
import java.io.OutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class v2 implements Function {
    public final /* synthetic */ c3 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ v2(c3 r1, String r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r10) {
        c3 r0 = this.a;
        String r1 = this.b;
        boolean r2 = this.c;
        Boolean r11 = (Boolean) r10;
        r0.getClass();
        byte[] r12 = c3.o(r1);
        if (r12 == null) goto L38;
        if (r12.length == 0) goto L38;
        tt5.a.h("ImageViewer", "saveBase64Image, [image export], base64 length = " + r1.length() + ", decoded bytes = " + r12.length);
        if (r1.startsWith("data:") == false) goto L11;
        int r3 = r1.indexOf(59);
        if (r3 == (-1)) goto L11;
        String r4 = r1.substring(5, r3);
    L12:
        OutputStream r5 = null;
        String r6 = System.currentTimeMillis() + c3.y(r4);     // Catch: Throwable -> L16 Exception -> L18
        if (r2 == false) goto L20;
        Uri r7 = com.bytedance.ee.util.io.e.b(eu5.b.a, c3.n(r6));     // Catch: Throwable -> L16 Exception -> L18
        OutputStream r8 = ContentResolverWrapper.openOutputStream(r0.b.getContentResolver(), r7);     // Catch: Throwable -> L16 Exception -> L18
    L24:
        r5 = r8;
        if (r5 == null) goto L27;
        r5.write(r12);     // Catch: Throwable -> L16 Exception -> L18
    L27:
        tt5.a.h("ImageViewer", "saveImageBytes, [image export] success, path = " + r6 + ", size = " + (r12.length / 1024) + " KB");     // Catch: Throwable -> L16 Exception -> L18
        if (r5 == null) goto L30;
        r5.close();
    L30:
        tt5.a.h("ImageViewer", "saveImageBytes, [image export] success, uri = " + r7);
        return r7;
    L20:
        r7 = com.larksuite.framework.utils.i.e(r0.getContext(), r6, null, MediaStoreUtil.DirType.PICTURES, null);     // Catch: Throwable -> L16 Exception -> L18
        Context r9 = r0.getContext();     // Catch: Throwable -> L16 Exception -> L18
        if (Build.VERSION.SDK_INT >= 29) goto L23;
        r8 = new PolarisFileOutputStreamWrapper(r7.getPath());     // Catch: Throwable -> L16 Exception -> L18
        goto L24
    L23:
        r8 = ContentResolverWrapper.openOutputStream(r9.getContentResolver(), r7);     // Catch: Throwable -> L16 Exception -> L18
    L18:
        e = move-exception;
        throw new Exception("saveImageBytes, [image export] failed", e);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (r5 == null) goto L36;
        r5.close();
    L36:
        throw th;
    L11:
        r4 = "image/png";
    L38:
        throw new IllegalArgumentException("base64 data is empty");
    }
}
