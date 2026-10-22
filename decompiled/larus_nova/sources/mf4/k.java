package mf4;

import android.content.Context;
import com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
@XBridgeMethod(name = "ttcjpay.dypay")
public final class k extends com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f513610k;

    public static final class a {
    }

    static {
    }

    public k() {
        this.f513610k = "ttcjpay.dypay";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f513610k;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.a, com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod
    public final void e(Context r100, JSONObject r101, IXPayBaseMethod.c r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L19
        cd4.e r104 = f();     // Catch: Throwable -> L22
        if (r104 == null) goto L8;
        String r105 = r104.a();     // Catch: Throwable -> L22
        if (r105 == null) goto L8;
    L15:
        if (r105 != null) goto L17;
        r105 = "";
    L17:
        super.e(r100, r101.put("cur_page_url", r105), r102);     // Catch: Throwable -> L19
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
        return;
    L8:
        g66.c r106 = getContextProviderFactory();     // Catch: Throwable -> L22
        if (r106 == null) goto L14;
        CallContext r107 = (CallContext) r106.c(CallContext.class);     // Catch: Throwable -> L22
        if (r107 == null) goto L14;
        r105 = r107.f249267b;     // Catch: Throwable -> L22
    L14:
        r105 = null;
    L19:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
