package zg4;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f572067e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PolarisFileWrapper f572068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PolarisFileWrapper f572069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PolarisFileWrapper f572070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PolarisFileWrapper f572071d;

    static {
        f572067e = new f();
    }

    public f() {
        Context r100 = com.bytedance.crash.i.getContext();     // Catch: Throwable -> L12
        if (r100 == null) goto L7;
        String r101 = r100.getFilesDir().getAbsolutePath();     // Catch: Throwable -> L12
    L8:
        this.f572068a = new PolarisFileWrapper(r101, "npth");
        this.f572069b = new PolarisFileWrapper(this.f572068a, "asdawd");
        this.f572070c = new PolarisFileWrapper(this.f572068a, "selflib");
        this.f572071d = new PolarisFileWrapper(this.f572068a, "PriorityMonitor");
        if (this.f572068a.exists() == true) goto L15;
        this.f572068a.mkdirs();
        return;
    L15:
        return;
    L7:
        r101 = "";
        goto L8
    }
}
