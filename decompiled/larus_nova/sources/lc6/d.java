package lc6;

import com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0015"}, d2 = {"Llc6/d;", "", "", "giftSceneMarketingInfo", "Ljava/lang/String;", "getGiftSceneMarketingInfo", "()Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfo;", "sceneMarketingInfo", "Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfo;", "getSceneMarketingInfo", "()Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfo;", "c", "(Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfo;)V", "giftSortScene", "getGiftSortScene", "b", "<init>", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.dialog.ObserveClientAIInfoResponse")
public final class d {

    @SerializedName("gift_scene_marketing_info")
    private String giftSceneMarketingInfo;

    @SerializedName("gift_sort_scene")
    private String giftSortScene;

    @SerializedName("scene_marketing_info")
    private IGiftMarketingInfo sceneMarketingInfo;

    public d() {
    }

    public final void a() {
        this.giftSceneMarketingInfo = null;
    }

    public final void b() {
        this.giftSortScene = null;
    }

    public final void c(IGiftMarketingInfo r100) {
        this.sceneMarketingInfo = r100;
    }
}
