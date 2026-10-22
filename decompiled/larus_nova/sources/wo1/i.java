package wo1;

import com.bytedance.android.live.browser.jsbridge.base.LoadShortTouchResultModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.p;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import w20.w3;

/* JADX INFO: loaded from: classes8.dex */
public final class i extends w3<JsonObject, LoadShortTouchResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f560509a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public i(p r100) {
        Intrinsics.checkNotNullParameter(r100, "commonIconModel");
        this.f560509a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        p r102 = this.f560509a;
        if (r102.f115578t == true) goto L5;
        r102.f115578t = true;
        r102.moveToState(0);
    L5:
        finishWithSuccess();
    }
}
