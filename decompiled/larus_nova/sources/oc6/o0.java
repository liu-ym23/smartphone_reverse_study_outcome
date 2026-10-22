package oc6;

import com.amap.api.col.s.ce;
import com.bytedance.android.livesdk.gift.model.b3;
import com.bytedance.android.livesdk.gift.model.o2;
import com.bytedance.android.livesdk.gift.model.z2;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b0\u00101R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00062"}, d2 = {"Loc6/o0;", "", "", "tabName", "Ljava/lang/String;", "getTabName", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "", "type", "I", "getType", "()I", ce.f26391f, "(I)V", "", "redDot", "Z", "getRedDot", "()Z", "d", "(Z)V", "hasNewGift", "getHasNewGift", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "Lcom/bytedance/android/livesdk/gift/model/o2;", "scrollPageInfo", "Ljava/util/List;", "getScrollPageInfo", "()Ljava/util/List;", "e", "(Ljava/util/List;)V", "Lcom/bytedance/android/livesdk/gift/model/b3;", "pageNameStyleInfo", "Lcom/bytedance/android/livesdk/gift/model/b3;", "getPageNameStyleInfo", "()Lcom/bytedance/android/livesdk/gift/model/b3;", "c", "(Lcom/bytedance/android/livesdk/gift/model/b3;)V", "Lcom/bytedance/android/livesdk/gift/model/z2;", "lynxConfig", "Lcom/bytedance/android/livesdk/gift/model/z2;", "getLynxConfig", "()Lcom/bytedance/android/livesdk/gift/model/z2;", "b", "(Lcom/bytedance/android/livesdk/gift/model/z2;)V", "<init>", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.dialog.tab.TabItem")
public final class o0 {

    @SerializedName("has_new_gift")
    private boolean hasNewGift;

    @SerializedName("lynx_config")
    private z2 lynxConfig;

    @SerializedName("page_name_style_info")
    private b3 pageNameStyleInfo;

    @SerializedName("red_dot")
    private boolean redDot;

    @SerializedName("scroll_page_info")
    private List<? extends o2> scrollPageInfo;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME)
    private String tabName;

    @SerializedName("type")
    private int type;

    public o0() {
    }

    public final void a() {
        this.hasNewGift = false;
    }

    public final int getType() {
        return this.type;
    }

    public final void b(z2 r100) {
        this.lynxConfig = r100;
    }

    public final void c(b3 r100) {
        this.pageNameStyleInfo = r100;
    }

    public final void d(boolean r100) {
        this.redDot = r100;
    }

    public final void e(List<? extends o2> r100) {
        this.scrollPageInfo = r100;
    }

    public final void f(String r100) {
        this.tabName = r100;
    }

    public final void g(int r100) {
        this.type = r100;
    }
}
