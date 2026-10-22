package zc2;

import com.bytedance.android.live.browser.jsbridge.base.LiveOpenStickerListResultModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.v2;
import com.bytedance.android.livesdk.chatroom.viewmodule.w2;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import w20.d3;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends d3<JsonObject, LiveOpenStickerListResultModel> {
    public c() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        w2 r102 = v2.a();
        if (r102 != null) goto L5;
        finishWithFailure();
        return;
    L5:
        r102.ve();
        finishWithSuccess();
    }
}
