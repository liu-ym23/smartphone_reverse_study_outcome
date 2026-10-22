package com.lynx.debugrouter.base.report;

import com.lynx.debugrouter.base.service.DebugRouterServiceCenter;
import com.lynx.debugrouter.log.LLog;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class DebugRouterReportServiceUtil {
    private static final String TAG = "DebugRouterReportServiceUtil";

    public static class InnerClass {
        private static final IDebugRouterReportService service = null;

        private InnerClass() {
        }

        static {
            service = (IDebugRouterReportService) DebugRouterServiceCenter.instance().getService(IDebugRouterReportService.class);
        }

        public static /* synthetic */ IDebugRouterReportService access$000() {
            return service;
        }
    }

    public DebugRouterReportServiceUtil() {
    }

    public static void init(DebugRouterMetaInfo r100) {
        if (InnerClass.access$000() != null) goto L6;
        LLog.i(TAG, "init: DebugRouterReportService == null");
        return;
    L6:
        InnerClass.access$000().init(r100);
    }

    public static void report(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        if (InnerClass.access$000() != null) goto L6;
        LLog.i(TAG, "report: DebugRouterReportService == null");
        return;
    L6:
        if (r101 != null) goto L8;
        r101 = new JSONObject();
    L8:
        if (r102 != null) goto L10;
        r102 = new JSONObject();
    L10:
        if (r103 != null) goto L12;
        r103 = new JSONObject();
    L12:
        InnerClass.access$000().report("New" + r100, r101, r102, r103);
    }
}
