package lc6;

import com.bytedance.android.livesdk.gift.model.d2;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR6\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Llc6/n;", "", "", "Lcom/bytedance/android/livesdk/gift/model/d2;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", Constants.EXTRA_KEY_TOPICS, "Ljava/util/List;", "getTopics", "()Ljava/util/List;", "e", "(Ljava/util/List;)V", "", "pageType", "J", "getPageType", "()J", "b", "(J)V", "selectedTopicId", "getSelectedTopicId", "c", "", "showFrom", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "<init>", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.operation.OperationTopicObserveUpdateAllTopicResponse")
public final class n {

    @SerializedName("page_type")
    private long pageType;

    @SerializedName("selected_topic_id")
    private long selectedTopicId;

    @SerializedName("show_from")
    private String showFrom;

    @SerializedName(Constants.EXTRA_KEY_TOPICS)
    private List<? extends d2> topics;

    public n() {
        this.topics = com.bytedance.revenue.platform.api.core.c.a(new d2[0]);
        this.selectedTopicId = -1;
        this.showFrom = "";
    }

    public final String a() {
        return this.showFrom;
    }

    public final void b(long r100) {
        this.pageType = r100;
    }

    public final void c(long r100) {
        this.selectedTopicId = r100;
    }

    public final void d(String r100) {
        this.showFrom = r100;
    }

    public final void e(List<? extends d2> r100) {
        this.topics = r100;
    }
}
