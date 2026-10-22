package dr2;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.model.push.LivePushInfo;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class m implements com.bytedance.android.scope.o, b {
    public m() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // dr2.b
    public final void showLiveCommonInnerPush(LivePushInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "pushInfo");
        ((IHostAction) jc1.k.n(IHostAction.class)).showLiveCommonInnerPush(r100);
    }

    @Override // dr2.b
    public final void startLive(Context r100, long r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ((IHostAction) jc1.k.n(IHostAction.class)).startLive(r100, r101, r102);
    }
}
