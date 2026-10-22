package qr;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010,R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\r8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u001a8\u0006X\u0087D¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010%\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b*\u0010(¨\u0006-"}, d2 = {"Lqr/e;", "", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", RemoteMessageConst.MSGID, "getMsgId", "respForMsgId", "getRespForMsgId", "respForText", "getRespForText", "", "user_id", "J", "getUser_id", "()J", "setUser_id", "(J)V", "respForUserId", "getRespForUserId", "nickName", "getNickName", "respForNickName", "getRespForNickName", "", "respType", "I", "getRespType", "()I", "Lqr/a;", "err", "Lqr/a;", "getErr", "()Lqr/a;", "Lqr/b;", "avatarThumb", "Lqr/b;", "getAvatarThumb", "()Lqr/b;", "respForAvatarThumb", "getRespForAvatarThumb", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("avatar_thumb")
    private final b avatarThumb;

    @SerializedName("err")
    private final a err;

    @SerializedName("msg_id")
    private final String msgId;

    @SerializedName("nick_name")
    private final String nickName;

    @SerializedName("resp_for_avatar_thumb")
    private final b respForAvatarThumb;

    @SerializedName("resp_for_msg_id")
    private final String respForMsgId;

    @SerializedName("resp_for_nick_name")
    private final String respForNickName;

    @SerializedName("resp_for_text")
    private final String respForText;

    @SerializedName("resp_for_user_id")
    private final long respForUserId;

    @SerializedName("chat_type")
    private final int respType;

    @SerializedName("text")
    private final String text;

    @SerializedName("user_id")
    private long user_id;

    public e() {
    }
}
