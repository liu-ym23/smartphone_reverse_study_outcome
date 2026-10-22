package rw;

import com.bytedance.android.gamecp.live_impl.toolbar.jsb.GameCpAnchorPromoteResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends rw.a<c, GameCpAnchorPromoteResultModel> {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((c) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        GameCpAnchorPromoteResultModel r102 = new GameCpAnchorPromoteResultModel();
        r102.a(GameCpAnchorPromoteResultModel.Code.Success);
        Unit r103 = Unit.INSTANCE;
        finishWithResult(r102);
    }
}
