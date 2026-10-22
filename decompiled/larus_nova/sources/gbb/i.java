package gbb;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.framework.assembly.diskmange.DiskManageModuleDependencyInitor;

/* JADX INFO: loaded from: classes35.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f480806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f480807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f480808c;

    public interface a {
    }

    public final c a() {
        h r100 = (h) this.f480808c;
        r100.getClass();
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.f480805a);
        if (r101.mkdirs() == true) goto L11;
        if (r101.exists() == true) goto L7;
    L9:
        return null;
    L7:
        if (r101.isDirectory() == false) goto L9;
    L11:
        return new c(r101, this.f480807b, this.f480806a);
    }

    public i(String r100, long r101) {
        h r102 = new h(r100);
        dbb.a.InterfaceC5651a r103 = dbb.a.b();
        boolean r104 = false;
        if (r103 == null) goto L5;
        r104 = eac.a.a().getBoolean("small_disk_on", false);
    L5:
        if (r104 == false) goto L7;
        ((DiskManageModuleDependencyInitor.a) r103).getClass();
        this.f480806a = (long) (r101 * eac.a.a().getFloat("disk_factor", 1.0f));
    L8:
        this.f480807b = 1;
        this.f480808c = r102;
        return;
    L7:
        this.f480806a = r101;
        goto L8
    }
}
