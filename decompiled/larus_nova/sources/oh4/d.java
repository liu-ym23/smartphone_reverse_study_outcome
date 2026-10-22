package oh4;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes15.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f523294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f523295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f523296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f523297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f523298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f523299f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PolarisFileWrapper f523300g;

    public String toString() {
        throw null;
    }

    public final String a() {
        if (this.f523297d != null) goto L16;
        switch(this.f523299f) {
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L6:
        String r100 = "unknown";
    L14:
        this.f523297d = r100;
        goto L16
    L7:
        r100 = "npth_setpriority";
        goto L14
    L8:
        r100 = "npth_ref_monitor";
        goto L14
    L9:
        r100 = "npth_tls_monitor";
        goto L14
    L10:
        r100 = "npth_vm_monitor";
        goto L14
    L11:
        r100 = "npth_fd_tracker";
        goto L14
    L12:
        r100 = "npth_heap_tracker";
        goto L14
    L13:
        r100 = "npth_xasan";
    L16:
        return this.f523297d;
    }

    public final File b() {
        if (this.f523300g != null) goto L16;
        switch(this.f523299f) {
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L6:
        PolarisFileWrapper r100 = null;
    L14:
        this.f523300g = r100;
        goto L16
    L7:
        r100 = uh4.b.f550093h.f550100g;
        goto L14
    L8:
        r100 = uh4.b.f550093h.f550098e;
        goto L14
    L9:
        r100 = uh4.b.f550093h.f550099f;
        goto L14
    L10:
        r100 = uh4.b.f550093h.f550096c;
        goto L14
    L11:
        r100 = uh4.b.f550093h.f550097d;
        goto L14
    L12:
        r100 = uh4.b.f550093h.f550095b;
        goto L14
    L13:
        r100 = uh4.b.f550093h.f550094a;
    L16:
        return this.f523300g;
    }

    public d(int r100, int r101, int r102) {
        this.f523296c = null;
        this.f523297d = null;
        this.f523298e = null;
        this.f523300g = null;
        this.f523295b = r101;
        this.f523294a = r100;
        this.f523299f = r102;
    }
}
