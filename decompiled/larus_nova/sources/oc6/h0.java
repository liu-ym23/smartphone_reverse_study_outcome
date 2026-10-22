package oc6;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Loc6/h0;", "", "", "Loc6/o0;", "tabList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "d", "(Ljava/util/List;)V", "Loc6/n0;", "searchConfig", "Loc6/n0;", "getSearchConfig", "()Loc6/n0;", "c", "(Loc6/n0;)V", "Loc6/a;", "aiAgentConfig", "Loc6/a;", "getAiAgentConfig", "()Loc6/a;", "b", "(Loc6/a;)V", "<init>", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.dialog.tab.ObserveTabListResponse")
public final class h0 {

    @SerializedName("ai_agent_config")
    private a aiAgentConfig;

    @SerializedName("search_config")
    private n0 searchConfig;

    @SerializedName("tab_list")
    private List<o0> tabList;

    public h0() {
    }

    public final List<o0> a() {
        return this.tabList;
    }

    public final void b(a r100) {
        this.aiAgentConfig = r100;
    }

    public final void c(n0 r100) {
        this.searchConfig = r100;
    }

    public final void d(List<o0> r100) {
        this.tabList = r100;
    }
}
