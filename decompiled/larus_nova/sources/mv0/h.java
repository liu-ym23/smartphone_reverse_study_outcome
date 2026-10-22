package mv0;

import com.bytedance.android.livehostapi.business.IHostGameCP;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h extends qs0.a<IHostGameCP> implements qs0.f {
    public h() {
        super(jc1.k.n(IHostGameCP.class));
    }

    @Override // qs0.f
    public final void a(Map r100) {
        Intrinsics.checkNotNullParameter("douyin_game_content_consume_click_monitor", "eventName");
        Intrinsics.checkNotNullParameter(r100, "params");
        ((IHostGameCP) this.f534640a).dataChannelLinkEvent("douyin_game_content_consume_click_monitor", r100);
    }
}
