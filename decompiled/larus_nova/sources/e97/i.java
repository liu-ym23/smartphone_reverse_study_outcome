package e97;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes21.dex */
public class i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f471528e = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PolarisFileWrapper f471529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f471530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f471531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Runnable f471532d;

    public final void b() {
        this.f471529a.delete();
    }

    public final int c() {
        int r100 = this.f471531c;
        if (r100 < 0) goto L6;
        return r100;
    L6:
        if (this.f471529a.exists() == true) goto L16;
        return 0;
    L16:
        this.f471531c = CastIntegerProtector.parseInt(w87.b.h(this.f471529a));     // Catch: Throwable -> L10
    L12:
        if (this.f471531c >= 0) goto L15;
        this.f471531c = 0;
    L15:
        return this.f471531c;
    }

    public final boolean a() {
        boolean r100 = true;
        if (c() < this.f471530b) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return true;
    L8:
        int r102 = c() + 1;
        this.f471531c = r102;
        w87.b.j(this.f471529a, String.valueOf(r102));     // Catch: IOException -> L19
    L11:
        if (c() >= this.f471530b) goto L14;
        r100 = false;
    L14:
        if (r100 == false) goto L18;
        Runnable r103 = this.f471532d;
        if (r103 == null) goto L18;
        r103.run();
    L18:
        return false;
    L5:
        r101 = false;
        goto L6
    }

    public i(File r100, String r101) {
        this(r100, "_init.info", 2, r101, null);
        this.f471529a = new PolarisFileWrapper(r100, "_init.info@" + r101.hashCode());
        this.f471530b = 2;
    }

    public i(File r100, String r101, int r102, String r103, a.RunnableC5758a r104) {
        this.f471531c = -1;
        this.f471532d = null;
        this.f471529a = new PolarisFileWrapper(r100, r101 + "@" + r103.hashCode());
        this.f471530b = r102;
        this.f471532d = r104;
    }
}
