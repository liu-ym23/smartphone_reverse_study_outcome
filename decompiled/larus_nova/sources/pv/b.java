package pv;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lpv/b;", "", "", "authId", "Ljava/lang/String;", "getAuthId", "()Ljava/lang/String;", "setAuthId", "(Ljava/lang/String;)V", "authCode", "getAuthCode", "setAuthCode", "", "errorCode", "I", "getErrorCode", "()I", "setErrorCode", "(I)V", "errorMsg", "getErrorMsg", "setErrorMsg", "grantedPermissions", "getGrantedPermissions", "setGrantedPermissions", "Lcom/google/gson/JsonObject;", "extraInfo", "Lcom/google/gson/JsonObject;", "getExtraInfo", "()Lcom/google/gson/JsonObject;", "setExtraInfo", "(Lcom/google/gson/JsonObject;)V", "<init>", "()V", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("auth_code")
    private String authCode;

    @SerializedName("cloud_authorize_id")
    private String authId;

    @SerializedName("error_code")
    private int errorCode;

    @SerializedName("error_msg")
    private String errorMsg;

    @SerializedName("extra_info")
    private JsonObject extraInfo;

    @SerializedName("granted_permissions")
    private String grantedPermissions;

    public b() {
        this.authId = "";
        this.errorMsg = "";
        this.grantedPermissions = "";
    }
}
