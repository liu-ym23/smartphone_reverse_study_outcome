package jx4;

import com.bytedance.ee.bear.doc.resupdate.d0;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.vfs.VFSPath;
import java.io.IOException;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f500818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f500819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.doc.resupdate.f f500820c;

    public /* synthetic */ c(e r100, String r101, com.bytedance.ee.bear.doc.resupdate.f r102) {
        this.f500818a = r100;
        this.f500819b = r101;
        this.f500820c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e r100 = this.f500818a;
        String r101 = this.f500819b;
        com.bytedance.ee.bear.doc.resupdate.f r102 = this.f500820c;
        r100.getClass();
        if (r101.contains(".") == false) goto L5;
        String r103 = r101.replace(".", "_");
    L6:
        String r104 = String.format("https://tosv.byted.org/obj/bytedance-oss-bear-web-test/scm_zip/%s/android/docs_channel.zip", new Object[]{r103});
        tt5.a.h("DownloadScm", "download url: " + r104);
        VFSPath r105 = ay4.d.a().H(d0.c(), "specific_temp");     // Catch: IOException -> L12
        FileUtils.m(r105);     // Catch: IOException -> L12
        if (r105.toFile().mkdirs() == false) goto L11;
        new u45.b().b(r104, r105.subPath(r101.concat(".zip")), new d(r100, r101, r102));     // Catch: IOException -> L12
        return;
    L11:
        throw new IOException("mkdir fail");     // Catch: IOException -> L12
    L12:
        e = move-exception;
        tt5.a.e("DownloadScm", "download", e, false);
        if (r102 == null) goto L19;
        r102.c(e);
        return;
    L19:
        return;
    L5:
        r103 = r101;
        goto L6
    }
}
