package pf4;

import android.content.Context;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.PlugInContainerService;
import com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
@XBridgeMethod(name = "ttcjpay.setWebviewInfo")
public final class w extends com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f528867k;

    public static final class a {
    }

    static {
    }

    public w() {
        this.f528867k = "ttcjpay.setWebviewInfo";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f528867k;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.a, com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod
    public final void e(Context r100, JSONObject r101, IXPayBaseMethod.c r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L17
        String r104 = r101.optString("id");     // Catch: Throwable -> L17
        if (r104 != null) goto L7;
        r104 = "";
    L7:
        if (StringsKt.isBlank(r104) == false) goto L9;
        r102.a(new HashMap(), "id is empty");     // Catch: Throwable -> L17
    L15:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
        return;
    L9:
        ve4.a.f554342a.getClass();     // Catch: Throwable -> L17
        PlugInContainerService r105 = (PlugInContainerService) ve4.a.a(PlugInContainerService.class);     // Catch: Throwable -> L17
        if (r105 == null) goto L14;
        ee4.b r106 = r105.getH5ActivityStackHelper();     // Catch: Throwable -> L17
        if (r106 == null) goto L14;
        r106.addBulletActivity(r104, new x(this));     // Catch: Throwable -> L17
    L14:
        r102.success(new HashMap());     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
