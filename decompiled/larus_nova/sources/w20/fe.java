package w20;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lw20/fe;", "", "", RemoteMessageConst.MessageBody.MSG_CONTENT, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setMsgContent", "(Ljava/lang/String;)V", "pushDetail", "getPushDetail", "setPushDetail", "inviteToken", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setInviteToken", "userId", "c", "setUserId", "secUid", "getSecUid", "setSecUid", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class fe {

    @SerializedName("inviteToken")
    private String inviteToken;

    @SerializedName(RemoteMessageConst.MessageBody.MSG_CONTENT)
    private String msgContent;

    @SerializedName("pushDetail")
    private String pushDetail;

    @SerializedName("secUid")
    private String secUid;

    @SerializedName("userId")
    private String userId;

    public fe() {
    }

    public final String a() {
        return this.inviteToken;
    }

    public final String b() {
        return this.msgContent;
    }

    public final String c() {
        return this.userId;
    }
}
