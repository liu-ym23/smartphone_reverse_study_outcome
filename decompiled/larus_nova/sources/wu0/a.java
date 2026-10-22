package wu0;

import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateFansclubInfoResultModel;
import com.bytedance.android.live.profit.fansclub.o;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import w20.lb;
import w20.r3;
import yt0.c;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends r3<lb, LiveUpdateFansclubInfoResultModel> {
    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((lb) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        o r102 = c.c();
        if (r102 == null) goto L5;
        r102.Gd(11);
        finishWithSuccess();
        return;
    L5:
        finishWithFailure();
    }
}
