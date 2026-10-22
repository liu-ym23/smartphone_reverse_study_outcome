package lc6;

import com.bytedance.android.livesdk.gift.model.x2;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR$\u0010 \u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000f¨\u0006%"}, d2 = {"Llc6/l;", "", "", "pageType", "J", "getPageType", "()J", "d", "(J)V", "", "pageName", "Ljava/lang/String;", "getPageName", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdk/gift/model/x2;", "pageInfo", "Lcom/bytedance/android/livesdk/gift/model/x2;", "getPageInfo", "()Lcom/bytedance/android/livesdk/gift/model/x2;", "b", "(Lcom/bytedance/android/livesdk/gift/model/x2;)V", "pageExtra", "Ljava/lang/Object;", "getPageExtra", "()Ljava/lang/Object;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/lang/Object;)V", "receiverBackGroundUrl", "getReceiverBackGroundUrl", "e", "receiverLongBackgroundUrl", "getReceiverLongBackgroundUrl", "f", "<init>", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.dialog.ObserveSelectedPageResponse")
public final class l {

    @SerializedName("page_extra")
    private Object pageExtra;

    @SerializedName("page_info")
    private x2 pageInfo;

    @SerializedName("page_name")
    private String pageName;

    @SerializedName("page_type")
    private long pageType;

    @SerializedName("receiver_background_url")
    private String receiverBackGroundUrl;

    @SerializedName("receiver_long_background_url")
    private String receiverLongBackgroundUrl;

    public l() {
    }

    public final void a(JsonObject r100) {
        this.pageExtra = r100;
    }

    public final void b(x2 r100) {
        this.pageInfo = r100;
    }

    public final void c(String r100) {
        this.pageName = r100;
    }

    public final void d(long r100) {
        this.pageType = r100;
    }

    public final void e(String r100) {
        this.receiverBackGroundUrl = r100;
    }

    public final void f(String r100) {
        this.receiverLongBackgroundUrl = r100;
    }
}
