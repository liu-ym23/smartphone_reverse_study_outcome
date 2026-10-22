package com.bytedance.security.android.aopcheck.reporter;

import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/security/android/aopcheck/reporter/SlardarReporter;", "Lcom/bytedance/security/android/aopcheck/reporter/IReporter;", "()V", "mMonitor", "Lcom/bytedance/framwork/core/sdkmonitor/SDKMonitor;", "doReport", "", "event", "Lcom/bytedance/security/android/aopcheck/reporter/IEvent;", "doReportInitEvnt", "duration", "", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
public final class SlardarReporter implements IReporter {
    private SDKMonitor mMonitor;

    public SlardarReporter() {
    }

    @Override // com.bytedance.security.android.aopcheck.reporter.IReporter
    public void doReport(IEvent r100) {
        if ((r100 instanceof AOPReportEvent) == false) goto L11;
        JSONObject r101 = new JSONObject();
        AOPReportEvent r102 = (AOPReportEvent) r100;
        r101.put(ReportConstant.COMMON_ACTION_TYPE, r102.getActionType());
        r101.put("content", r102.getContent());
        r101.put(ReportConstant.COMMON_BACKTRACE, r102.getBacktrace());
        if (this.mMonitor != null) goto L7;
        this.mMonitor = SDKMonitorUtils.getInstance(ReportConstant.AID);
    L7:
        SDKMonitor r103 = this.mMonitor;
        if (r103 == null) goto L12;
        r103.monitorEvent(ReportConstant.AOP_REPORT_PATH_TRAVERSAL, r101, null, null);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.security.android.aopcheck.reporter.IReporter
    public void doReportInitEvnt(long r100) {
        JSONObject r101 = new JSONObject();
        r101.put("duration", r100);
        if (this.mMonitor != null) goto L5;
        this.mMonitor = SDKMonitorUtils.getInstance(ReportConstant.AID);
    L5:
        SDKMonitor r102 = this.mMonitor;
        if (r102 == null) goto L9;
        r102.monitorEvent(ReportConstant.AOP_REPORT_INIT_DURATION, null, r101, null);
        return;
    }
}
