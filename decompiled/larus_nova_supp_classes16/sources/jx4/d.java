package jx4;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.doc.resupdate.d0;
import com.bytedance.ee.bear.doc.resupdate.g0;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.IOException;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends b {
    public final /* synthetic */ String b;
    public final /* synthetic */ com.bytedance.ee.bear.doc.resupdate.f c;
    public final /* synthetic */ e d;

    public class a extends b {
        public final /* synthetic */ VFSFile b;

        @Override // jx4.b, u45.a
        public final void b(VFSPath r5) {
            FileUtils.m(this.b.getVfsPath());     // Catch: IOException -> L4
        L6:
            super.b(r5);
            return;
        L4:
            e = move-exception;
            tt5.a.e("DownloadScm", "onDownloadComplete", e, false);
            goto L6
        }

        public a(com.bytedance.ee.bear.doc.resupdate.f r1, VFSFile r2) {
            this.b = r2;
            super(r1);
        }
    }

    @Override // jx4.b, u45.a
    public final void onStart() {
        tt5.a.h("DownloadScm", "onStart, version: " + this.b);
        com.bytedance.ee.bear.doc.resupdate.f r0 = this.c;
        if (r0 == null) goto L6;
        r0.onStart();
        return;
    }

    @Override // jx4.b, u45.a
    public final void a(int r2) {
        com.bytedance.ee.bear.doc.resupdate.f r0 = this.c;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    @Override // jx4.b, u45.a
    public final void b(VFSPath r11) {
        tt5.a.h("DownloadScm", "onDownloadComplete");
        ZipInputStream r3 = null;
        Context r4 = this.d.a;     // Catch: Exception -> L34 Throwable -> L36
        VFSFile r5 = d0.j("specific");     // Catch: Exception -> L34 Throwable -> L36
        FileUtils.m(r5.getVfsPath());     // Catch: Exception -> L34 Throwable -> L36
        VFSPath r6 = ay4.d.a().H(r5, this.b + "_temp");     // Catch: Exception -> L34 Throwable -> L36
        ZipInputStream r7 = new ZipInputStream(ay4.d.a().l(r11));     // Catch: Exception -> L34 Throwable -> L36
        com.bytedance.ee.util.io.f.a(r7, r6.getRealPath());     // Catch: Throwable -> L19 Exception -> L32
        FileUtils.m(r11);     // Catch: Throwable -> L19 Exception -> L32
        VFSFile r8 = r6.subPath(EChannel.DOCS_CHANNEL.toString()).toFile();     // Catch: Throwable -> L19 Exception -> L32
        g0 r9 = d0.i(ay4.d.a().D(r8, "eesz"));     // Catch: Throwable -> L19 Exception -> L32
        if (r9.c == false) goto L7;
        String r10 = this.b + "_sim";     // Catch: Throwable -> L19 Exception -> L32
    L8:
        VFSFile r12 = ay4.d.a().D(r5, r10);     // Catch: Throwable -> L19 Exception -> L32
        boolean r13 = r8.renameTo(r12);     // Catch: Throwable -> L19 Exception -> L32
        FileUtils.m(r6);     // Catch: Throwable -> L19 Exception -> L32
        if (r13 == false) goto L31;
        if (new com.bytedance.ee.bear.doc.resupdate.a(r10, "").b(r12.getVfsPath().subPath("eesz")) == false) goto L28;
        tt5.a.h("DownloadScm", "onDownloadComplete, unZip success");     // Catch: Throwable -> L19 Exception -> L32
        if (this.d.b == true) goto L15;
    L24:
        com.bytedance.ee.bear.doc.resupdate.f r0 = this.c;     // Catch: Throwable -> L19 Exception -> L32
        if (r0 == null) goto L27;
        r0.b(r11);     // Catch: Throwable -> L19 Exception -> L32
    L27:
        FileUtils.d(r7);
        return;
    L15:
        if (r9.c == false) goto L24;
        tt5.a.h("DownloadScm", "onDownloadComplete, is slim, download: " + r9.f);     // Catch: Throwable -> L19 Exception -> L32
        final e r14 = this.d;     // Catch: Throwable -> L19 Exception -> L32
        final String r1 = r9.f;     // Catch: Throwable -> L19 Exception -> L32
        final a r2 = new a(this.c, r12);     // Catch: Throwable -> L19 Exception -> L32
        r14.getClass();     // Catch: Throwable -> L19 Exception -> L32
        if (TextUtils.isEmpty(r1) == true) goto L21;
        fo5.d.c().scheduleDirect(new c(r14, r1, r2));     // Catch: Throwable -> L19 Exception -> L32
    L21:
        com.bytedance.ee.bear.doc.resupdate.f r16 = this.c;     // Catch: Throwable -> L19 Exception -> L32
        if (r16 == null) goto L27;
        r16.d(r9.f);     // Catch: Throwable -> L19 Exception -> L32
        goto L27
    L28:
        FileUtils.m(r12.getVfsPath());     // Catch: Throwable -> L19 Exception -> L32
        throw new IOException("checkResourceIsValid fail");     // Catch: Throwable -> L19 Exception -> L32
    L31:
        throw new IOException("rename fail");     // Catch: Throwable -> L19 Exception -> L32
    L7:
        r10 = this.b;     // Catch: Throwable -> L19 Exception -> L32
    L32:
        e = e;
        r3 = r7;
    L38:
        tt5.a.e("DownloadScm", "onDownloadComplete, unZip fail", e, false);     // Catch: Throwable -> L36
        com.bytedance.ee.bear.doc.resupdate.f r17 = this.c;     // Catch: Throwable -> L36
        if (r17 == null) goto L41;
        r17.c(e);     // Catch: Throwable -> L36
    L41:
        FileUtils.d(r3);
        return;
    L19:
        th = th;
    L44:
        FileUtils.d(r7);
        throw th;
    L34:
        e = e;
    L36:
        th = th;
        r7 = r3;
        goto L44
    }

    @Override // jx4.b, u45.a
    public final void c(Exception r6) {
        tt5.a.e("DownloadScm", "onDownloadError", r6, false);
        Context r3 = this.d.a;     // Catch: IOException -> L5
        FileUtils.m(d0.c().getVfsPath().subPath("specific_temp"));     // Catch: IOException -> L5
    L6:
        com.bytedance.ee.bear.doc.resupdate.f r0 = this.c;
        if (r0 == null) goto L12;
        r0.c(r6);
        return;
    L12:
        return;
    L5:
        tt5.a.e("DownloadScm", "onDownloadError", r6, false);
        goto L6
    }

    public d(e r1, String r2, com.bytedance.ee.bear.doc.resupdate.f r3) {
        this.d = r1;
        this.b = r2;
        this.c = r3;
    }
}
