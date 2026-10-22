package y52;

import com.bytedance.android.livesdk.interactivity.jsb.ShowCarnivalTrayContentResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import q82.c;
import q82.f;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "showCarnivalTrayContent")
public final class b extends c<f, ShowCarnivalTrayContentResultModel> {
    public b() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        f r102 = (f) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        xs2.b.a().post(new o22.f(Intrinsics.areEqual(r102.a(), Boolean.TRUE)));
        finishWithSuccess();
    }
}
