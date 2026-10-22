package com.bytedance.bdp.appbase.network;

import com.bytedance.ai.file.AppletFileError;
import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/bdp/appbase/network/BdpNetCode;", "", "()V", "CREATE_TEMP_FILE_FAILED", "", AppletFileError.CODE_IO_ERROR, "MD5_VERIFY_FAILED", "MOVE_TARGET_FILE_FAILED", "NATIVE_EXCEED_MAX_SIZE", "NATIVE_OOM_ERROR", "NATIVE_REQUEST_EXECUTED", "NETWORK_ABORTED", "NETWORK_CANCEL", "NETWORK_CERT_ERROR", "NETWORK_CHANGED", "NETWORK_CONNECTION_ERROR", "NETWORK_DNS_ERROR", "NETWORK_NOT_AVAILABLE", "NETWORK_NO_BODY", "NETWORK_PARAMS_ERROR", "NETWORK_SSL_ERROR", "NETWORK_TIMEOUT", "NETWORK_ULR_ERROR", FlowDoraWifiScene.OTHER, "TEMP_FILE_NOT_EXIST", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
public final class BdpNetCode {
    public static final int CREATE_TEMP_FILE_FAILED = -96;
    public static final BdpNetCode INSTANCE = null;
    public static final int IO_ERROR = -95;
    public static final int MD5_VERIFY_FAILED = -97;
    public static final int MOVE_TARGET_FILE_FAILED = -99;
    public static final int NATIVE_EXCEED_MAX_SIZE = -202;
    public static final int NATIVE_OOM_ERROR = -200;
    public static final int NATIVE_REQUEST_EXECUTED = -201;
    public static final int NETWORK_ABORTED = -108;
    public static final int NETWORK_CANCEL = -110;
    public static final int NETWORK_CERT_ERROR = -109;
    public static final int NETWORK_CHANGED = -107;
    public static final int NETWORK_CONNECTION_ERROR = -106;
    public static final int NETWORK_DNS_ERROR = -102;
    public static final int NETWORK_NOT_AVAILABLE = -101;
    public static final int NETWORK_NO_BODY = -105;
    public static final int NETWORK_PARAMS_ERROR = -100;
    public static final int NETWORK_SSL_ERROR = -103;
    public static final int NETWORK_TIMEOUT = -104;
    public static final int NETWORK_ULR_ERROR = -111;
    public static final int OTHER = -1;
    public static final int TEMP_FILE_NOT_EXIST = -98;

    private BdpNetCode() {
    }

    static {
        INSTANCE = new BdpNetCode();
    }
}
