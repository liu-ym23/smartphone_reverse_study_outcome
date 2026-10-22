package uh4;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import zg4.f;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f550093h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PolarisFileWrapper f550094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PolarisFileWrapper f550095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PolarisFileWrapper f550096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PolarisFileWrapper f550097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PolarisFileWrapper f550098e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PolarisFileWrapper f550099f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PolarisFileWrapper f550100g;

    static {
        f550093h = new b();
    }

    public b() {
        PolarisFileWrapper r100 = f.f572067e.f572068a;
        this.f550094a = new PolarisFileWrapper(r100, "xasanReport");
        this.f550095b = new PolarisFileWrapper(r100, "NativeHeapReport");
        this.f550096c = new PolarisFileWrapper(r100, "VmMonitor");
        this.f550097d = new PolarisFileWrapper(r100, "FdTrack");
        this.f550098e = new PolarisFileWrapper(r100, "RefMonitor");
        this.f550099f = new PolarisFileWrapper(r100, "TLSMonitor");
        this.f550100g = new PolarisFileWrapper(r100, "PriorityMonitor");
    }
}
