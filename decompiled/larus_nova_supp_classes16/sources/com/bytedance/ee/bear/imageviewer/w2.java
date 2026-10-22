package com.bytedance.ee.bear.imageviewer;

import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.functions.Function;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class w2 implements Function {
    public final /* synthetic */ c3 a;
    public final /* synthetic */ String b;

    public /* synthetic */ w2(c3 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r7) {
        c3 r0 = this.a;
        String r1 = this.b;
        Boolean r8 = (Boolean) r7;
        r0.getClass();
        byte[] r9 = c3.o(r1);
        if (r9 == null) goto L29;
        if (r9.length == 0) goto L29;
        if (r1.startsWith("data:") == false) goto L11;
        int r2 = r1.indexOf(59);
        if (r2 == (-1)) goto L11;
        String r3 = r1.substring(5, r2);
    L12:
        OutputStream r4 = null;
        String r5 = System.currentTimeMillis() + c3.y(r3);     // Catch: Throwable -> L20 Exception -> L22
        VFSPath r6 = c3.n(r5);     // Catch: Throwable -> L20 Exception -> L22
        OutputStream r10 = ContentResolverWrapper.openOutputStream(eu5.b.a.getContentResolver(), com.bytedance.ee.util.io.e.b(eu5.b.a, r6));     // Catch: Throwable -> L20 Exception -> L22
        if (r10 == null) goto L19;
        r10.write(r9);     // Catch: Throwable -> L20 Exception -> L22
        tt5.a.h("ImageViewer", "saveImageBytesToVfsPath success, file = " + r5);     // Catch: Throwable -> L20 Exception -> L22
        r10.close();
        return r6;
    L19:
        throw new IOException("openOutputStream returned null");     // Catch: Throwable -> L20 Exception -> L22
    L22:
        e = move-exception;
        throw new Exception("saveImageBytesToVfsPath failed", e);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        if (0 == 0) goto L27;
        r4.close();
    L27:
        throw th;
    L11:
        r3 = "image/png";
    L29:
        throw new IllegalArgumentException("base64 data is empty");
    }
}
