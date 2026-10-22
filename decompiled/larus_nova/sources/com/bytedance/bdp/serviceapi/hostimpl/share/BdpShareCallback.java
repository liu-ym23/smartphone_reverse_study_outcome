package com.bytedance.bdp.serviceapi.hostimpl.share;

import org.json.JSONArray;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
public interface BdpShareCallback {

    public static final enum ProcessResult extends Enum<ProcessResult> {
        public static final ProcessResult CUT_TEMPLATE_PROCESS_FAIL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ProcessResult[] f201614a = null;

        static {
            ProcessResult r100 = new ProcessResult();
            CUT_TEMPLATE_PROCESS_FAIL = r100;
            f201614a = new ProcessResult[]{r100};
        }

        public ProcessResult() {
            super("CUT_TEMPLATE_PROCESS_FAIL", 0);
        }

        public static ProcessResult[] values() {
            return (ProcessResult[]) f201614a.clone();
        }

        public static ProcessResult valueOf(String r100) {
            return (ProcessResult) a.a(ProcessResult.class, r100);
        }
    }

    void onCancel(String r100);

    void onFail(String r100, JSONArray r101);

    void onProcess(ProcessResult r100);

    void onProcessEvent(String r100, String r101);

    void onPublishResponseFinish(boolean r100, String r101, boolean r102, String r103, String r104);

    void onSuccess(String r100, JSONArray r101);
}
