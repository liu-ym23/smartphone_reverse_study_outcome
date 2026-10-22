package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2BarrageBuyInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2InteractionData;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("live.LiveInteractionMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lsi2/y;", "Lsg2/a;", "", "msgType", "I", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2BarrageBuyInfo;", "barrageBuyInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2BarrageBuyInfo;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData;", "interactionData", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2InteractionData;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y extends sg2.a {

    @SerializedName("barrage_buy_info")
    public ECV2BarrageBuyInfo barrageBuyInfo;

    @SerializedName("interaction_data")
    public ECV2InteractionData interactionData;

    @SerializedName(SeiMessageConst.MSG_TYPE)
    public int msgType;

    @Override // sg2.a
    public final String toJsonString() {
        return new Gson().toJson(this);
    L5:
        return toString();
    }

    public y() {
    }
}
