package g30;

import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.f;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends f<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ILiveHybridContainer f479783a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public a(ILiveHybridContainer r100) {
        this.f479783a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.optString("title");
        ILiveHybridContainer r104 = this.f479783a;
        if (r104 == null) goto L5;
        r104.setHybridTitle(r103);
    L5:
        finishWithResult(null);
    }
}
