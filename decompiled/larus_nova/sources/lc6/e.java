package lc6;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Llc6/e;", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", SocialConstants.PARAM_RECEIVER, "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getReceiver", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "", "receiverType", "Ljava/lang/Integer;", "getReceiverType", "()Ljava/lang/Integer;", "b", "(Ljava/lang/Integer;)V", "<init>", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.ObserveCurrentReceiverResponse")
public final class e {

    @SerializedName(SocialConstants.PARAM_RECEIVER)
    private IBaseUser receiver;

    @SerializedName("receiver_type")
    private Integer receiverType;

    public e() {
    }

    public final void a(IBaseUser r100) {
        this.receiver = r100;
    }

    public final void b(Integer r100) {
        this.receiverType = r100;
    }
}
