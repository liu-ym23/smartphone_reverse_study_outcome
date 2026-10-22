package mv0;

import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i extends qs0.a<IHostLiveLocalLife> implements qs0.g {
    public i() {
        super(jc1.k.n(IHostLiveLocalLife.class));
    }

    @Override // qs0.g
    public final void d(Map r100) {
        Intrinsics.checkNotNullParameter("life_live_author_card_gold_business_info_show", "eventName");
        Intrinsics.checkNotNullParameter(r100, "params");
        ((IHostLiveLocalLife) this.f534640a).sendPoiLog("life_live_author_card_gold_business_info_show", r100, null, null, null, null);
    }
}
