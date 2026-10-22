package y52;

import com.bytedance.android.livesdk.interactivity.jsb.ShowCarnivalRedPacketEggResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import q82.e;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "showCarnivalRedPacketEgg")
public final class a extends q82.b<e, ShowCarnivalRedPacketEggResultModel> {
    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        e r102 = (e) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r102.b() == null) goto L5;
        xs2.b.a().post(new o22.e(r102.b(), r102.a()));
        finishWithSuccess();
        return;
    L5:
        finishWithFailure();
    }
}
