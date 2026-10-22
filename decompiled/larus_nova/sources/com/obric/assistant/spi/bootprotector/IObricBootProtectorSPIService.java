package com.obric.assistant.spi.bootprotector;

import com.larus.bootprotector.activity.BootProtectorLandingActivity;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\b\u0010\f\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/spi/bootprotector/IObricBootProtectorSPIService;", "", "isObricHandler", "", "prefetchLatestAppApkUrl", "", "tryStartDownloadLatestApk", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "downloadButtonText", "", "dialogMessage", "startNetworkRetry", "stopNetworkRetry", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricBootProtectorSPIService {
    void a();

    boolean b();

    void c();

    String d();

    String e();

    boolean f(BootProtectorLandingActivity r100);

    void g();
}
