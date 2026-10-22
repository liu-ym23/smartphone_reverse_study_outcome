package lx5;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.retrofit2.RetrofitMetrics;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements RetrofitMetrics.IRequestLogReporterBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f511218a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f511219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f511220c;

    public f() {
    }

    static {
        f511218a = new f();
        f511219b = false;
        f511220c = false;
    }

    @Override // com.bytedance.retrofit2.RetrofitMetrics.IRequestLogReporterBridge
    public final boolean isAllErrorReport() {
        return NetworkParams.isAllErrorReport();
    }

    public static void a(Object r100) {
        BaseHttpRequestInfo r101 = (BaseHttpRequestInfo) r100;
        if (r101.url == null) goto L6;
        Logger.e("TTNetCallMonitor", "monitor cast error" + r101.url.getPath());
        return;
    }

    @Override // com.bytedance.retrofit2.RetrofitMetrics.IRequestLogReporterBridge
    public final void monitorApiOk(String r100, Object r101) {
        BaseHttpRequestInfo r102 = (BaseHttpRequestInfo) r101;     // Catch: ClassCastException -> L12
        if (f511220c == false) goto L8;
        if (r102.reported.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        if (f511219b == false) goto L10;
        NetworkParams.monitorApiOkV2(r100, r102);     // Catch: ClassCastException -> L12
        return;
    L10:
        NetworkParams.monitorApiOk(r100, r102);     // Catch: ClassCastException -> L12
        return;
    L12:
        a(r101);
    }

    @Override // com.bytedance.retrofit2.RetrofitMetrics.IRequestLogReporterBridge
    public final void monitorApiError(String r100, Object r101, Throwable r102) {
        BaseHttpRequestInfo r103 = (BaseHttpRequestInfo) r101;     // Catch: ClassCastException -> L12
        if (f511220c == false) goto L8;
        if (r103.reported.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        if (f511219b == false) goto L10;
        NetworkParams.monitorApiErrorV2(r100, r103, r102);     // Catch: ClassCastException -> L12
        return;
    L10:
        NetworkParams.monitorApiError(r100, r103, r102);     // Catch: ClassCastException -> L12
        return;
    L12:
        a(r101);
    }
}
