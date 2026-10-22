package z87;

import android.app.Application;
import c97.g;
import c97.h;
import c97.j;
import com.bytedance.reparo.core.PatchEventReporter;
import com.bytedance.reparo.core.common.event.Event;
import com.bytedance.reparo.core.exception.PatchInstallException;
import com.bytedance.reparo.core.i;
import com.bytedance.reparo.core.k;
import com.bytedance.reparo.core.l;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.bytedance.thanos.hdiff.HDifferHelper;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import w87.b;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f570943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f570944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f570945c;

    /* JADX INFO: renamed from: z87.a$a, reason: collision with other inner class name */
    public static class C8429a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public File f570946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f570947b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public PolarisFileWrapper f570948c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f570949d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f570950e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public PolarisFileWrapper f570951f;

        public C8429a() {
        }
    }

    public final void a(c97.i r100) {
        i r101 = this.f570945c;
        File r102 = this.f570944b;
        r101.getClass();
        PolarisFileWrapper r103 = new PolarisFileWrapper(new PolarisFileWrapper(r102, "c"), r100.f22897c);
        b.b(r100.f22898d, r103);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new PatchInstallException(String.format("copy so file %s to %s failed.", new Object[]{r100.f22897c, r103.getAbsolutePath()}), e);
    }

    public final void d(l.a r100, PatchInstallException r101) {
        b.delete(this.f570944b);
        r100.f267397d.f267390i.remove(r100.f267396c);
        h r102 = r100.f267394a.b();
        k.b("PatchManager", "install patch failed. " + r102.toString(), r101);
        long r103 = r100.f267395b;
        Event r104 = PatchEventReporter.a(r102, 0);
        r104.f267345d = r103;
        r104.e(r101);
        r104.j();
        long r105 = r100.f267395b;
        Event r106 = PatchEventReporter.d(r102, 0);
        r106.f267345d = r105;
        r106.e(r101);
        r106.j();
    }

    public final void b(c97.i r100, PolarisZipFileWrapper r101, ZipEntry r102) {
        i r103 = this.f570945c;
        File r104 = this.f570944b;
        String r105 = r102.getName();
        r103.getClass();
        PolarisFileWrapper r106 = new PolarisFileWrapper(new PolarisFileWrapper(r104, "source"), r105);
        b.i(r101.getInputStream(r102), r106);     // Catch: IOException -> L9
        i r107 = this.f570945c;
        File r108 = this.f570944b;
        r107.getClass();
        PolarisFileWrapper r109 = new PolarisFileWrapper(new PolarisFileWrapper(r108, "c"), r100.f22897c);
        b.delete(r109);
        b.d(r109);
        if (HDifferHelper.a(r106.getAbsolutePath(), r100.f22898d.getAbsolutePath(), r109.getAbsolutePath()) != 0) goto L8;
        return;
    L8:
        throw new PatchInstallException(String.format("patch source so %s and diff so %s failed.", new Object[]{r106.getAbsolutePath(), r100.f22898d.getAbsolutePath()}));
    L9:
        e = move-exception;
        throw new PatchInstallException(String.format("write source %s so file failed. ", new Object[]{r102.getName()}), e);
    }

    public final void c(Application r100, g r101, com.bytedance.reparo.core.g r102) {
        r102.getClass();
        if ((!((HashMap) r101.f22880g).isEmpty()) == true) goto L6;
        k.c("PatchInstaller", String.format("patch %s don't have any so libraries, install so libraries skipped.", new Object[]{this.f570943a.getName()}));
        return;
    L6:
        j r103 = (j) ((HashMap) r101.f22880g).get(((c97.b) r101.f22876c).b());
        if (r103 != null) goto L9;
    L47:
        k.e("PatchInstaller", String.format("target abi %s so list is empty, install so libraries failed.", new Object[]{((c97.b) r101.f22876c).b()}));
        return;
    L9:
        if (((ArrayList) r103.f22901a).size() == 0) goto L47;
        if (b.g(r101.f22878e) == true) goto L15;
        k.e("PatchInstaller", "so-info.txt not exit, install so libraries failed.");
        return;
    L15:
        HashMap r104 = new HashMap();
        Iterator r105 = ((ArrayList) r103.f22901a).iterator();
    L17:
        if (r105.hasNext() == false) goto L49;
        c97.i r106 = (c97.i) r105.next();
        r104.put(r106.f22897c, r106);
        goto L17
    L49:
        PolarisZipFileWrapper r107 = new PolarisZipFileWrapper(new PolarisFileWrapper(r100.getApplicationInfo().sourceDir));     // Catch: IOException -> L44
        Enumeration<? extends ZipEntry> r108 = r107.entries();     // Catch: IOException -> L44
    L22:
        if (r108.hasMoreElements() == false) goto L36;
        ZipEntry r109 = r108.nextElement();     // Catch: IOException -> L44
        if (r109.getName().contains(DownloadConstants.VULNERABILITY_PATH) == true) goto L22;
        if (r109.getName().endsWith(".so") == false) goto L22;
        c97.i r110 = (c97.i) r104.get(r109.getName());     // Catch: IOException -> L44
        if (r110 == null) goto L22;
        r104.remove(r109.getName());     // Catch: IOException -> L44
        if (r110.f22899e == true) goto L34;
        a(r110);     // Catch: IOException -> L44
        goto L22
    L34:
        b(r110, r107, r109);     // Catch: IOException -> L44
        goto L22
    L36:
        r107.close();     // Catch: IOException -> L44
        if (r104.isEmpty() == true) goto L43;
        Iterator r111 = r104.values().iterator();     // Catch: IOException -> L44
    L39:
        if (r111.hasNext() == false) goto L68;
        a((c97.i) r111.next());     // Catch: IOException -> L44
        goto L39
    L68:
        return;
    L43:
        return;
    L44:
        e = move-exception;
        throw new PatchInstallException("install so libraries failed.", e);
    }

    public a(Application r100, File r101, PolarisFileWrapper r102, com.bytedance.reparo.core.g r103, c97.a r104, i r105) {
        this.f570943a = r101;
        this.f570944b = r102;
        this.f570945c = r105;
    }
}
