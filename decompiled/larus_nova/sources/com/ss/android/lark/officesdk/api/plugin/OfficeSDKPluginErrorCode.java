package com.ss.android.lark.officesdk.api.plugin;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/officesdk/api/plugin/OfficeSDKPluginErrorCode;", "", "<init>", "()V", "INVALID_PLUGIN_ID", "", "SERVICE_NOT_REGISTERED", "PLUGIN_UNSUPPORTED", "OPERATION_EXCEPTION", "OPERATION_TIMEOUT", "PLUGIN_STATE_UNAVAILABLE", "DOWNLOAD_FAILED", "INSTALL_FAILED", "LOAD_FAILED", "OPERATION_CANCELED", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSDKPluginErrorCode {
    public static final int DOWNLOAD_FAILED = -10100;
    public static final int INSTALL_FAILED = -10101;
    public static final OfficeSDKPluginErrorCode INSTANCE = null;
    public static final int INVALID_PLUGIN_ID = -10000;
    public static final int LOAD_FAILED = -10102;
    public static final int OPERATION_CANCELED = -10103;
    public static final int OPERATION_EXCEPTION = -10004;
    public static final int OPERATION_TIMEOUT = -10005;
    public static final int PLUGIN_STATE_UNAVAILABLE = -10006;
    public static final int PLUGIN_UNSUPPORTED = -10002;
    public static final int SERVICE_NOT_REGISTERED = -10001;

    static {
        INSTANCE = new OfficeSDKPluginErrorCode();
    }

    private OfficeSDKPluginErrorCode() {
    }
}
