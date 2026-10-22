package dr2;

import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPTrackService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class r implements com.bytedance.android.scope.o, e {
    public r() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // dr2.e
    public final bq2.c getTrackService() {
        IHostGameCP r100 = (IHostGameCP) jc1.k.f(IHostGameCP.class);
        if (r100 == null) goto L5;
        IGameCPTrackService r101 = r100.getTrackService();
    L7:
        return new bq2.c(r101);
    L5:
        r101 = null;
        goto L7
    }

    @Override // dr2.e
    public final void dataChannelLinkEvent(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter("douyin_game_content_consume_click_monitor", "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        IHostGameCP r102 = (IHostGameCP) jc1.k.f(IHostGameCP.class);
        if (r102 == null) goto L6;
        r102.dataChannelLinkEvent("douyin_game_content_consume_click_monitor", r101);
        return;
    }
}
