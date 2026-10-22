package rr;

import com.bytedance.android.format.model.message.ws.LiveMsgChatRespType;
import com.bytedance.android.live.base.model.user.User;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00008\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lrr/a;", "", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "", "extra", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "Lcom/bytedance/android/live/base/model/user/User;", "user", "Lcom/bytedance/android/live/base/model/user/User;", "getUser", "()Lcom/bytedance/android/live/base/model/user/User;", "refMsg", "Lrr/a;", "getRefMsg", "()Lrr/a;", "", "chatType", "I", "getChatType", "()I", "", RemoteMessageConst.MSGID, "Ljava/lang/Long;", "getMsgId", "()Ljava/lang/Long;", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("chat_type")
    private final int chatType;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("msg_id")
    private final Long msgId;

    @SerializedName("ref_msg")
    private final a refMsg;

    @SerializedName("text")
    private final String text;

    @SerializedName("user")
    private final User user;

    public a() {
        this.chatType = LiveMsgChatRespType.AIReplyDefault.getType();
    }
}
