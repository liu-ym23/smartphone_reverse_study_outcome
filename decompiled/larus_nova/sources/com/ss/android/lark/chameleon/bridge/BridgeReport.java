package com.ss.android.lark.chameleon.bridge;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/chameleon/bridge/BridgeReport;", "", "()V", "CODE_API_AUTH_FAILED", "", "CODE_BRIDGE_IS_BAN", "CODE_BUILD_APIMESSAGE_FAILED", "CODE_CALLBACKID_IS_NULL_OR_EMPTY", "CODE_DATA_MORE_THAN_2M", "CODE_JS_METHOD_EMPTY", "CODE_NO_API_HANDLER", "EVENT_BRIDGE_CALL", "", "EVENT_BRIDGE_ERROR", "EVENT_WB_CALLBACK_JS", "TAG", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BridgeReport {
    public static final int CODE_API_AUTH_FAILED = 10003;
    public static final int CODE_BRIDGE_IS_BAN = 10006;
    public static final int CODE_BUILD_APIMESSAGE_FAILED = 10002;
    public static final int CODE_CALLBACKID_IS_NULL_OR_EMPTY = 10005;
    public static final int CODE_DATA_MORE_THAN_2M = 10007;
    public static final int CODE_JS_METHOD_EMPTY = 10001;
    public static final int CODE_NO_API_HANDLER = 10004;
    public static final String EVENT_BRIDGE_CALL = "wb_lark_webview_bridge_call";
    public static final String EVENT_BRIDGE_ERROR = "wb_lark_webview_bridge_error";
    public static final String EVENT_WB_CALLBACK_JS = "wb_api_invoke_result";
    public static final BridgeReport INSTANCE = null;
    public static final String TAG = "JSBridge";

    static {
        INSTANCE = new BridgeReport();
    }

    private BridgeReport() {
    }
}
