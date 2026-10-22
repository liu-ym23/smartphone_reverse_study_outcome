package pf4;

import android.content.Context;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.PlugInContainerService;
import com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
@XBridgeMethod(name = "ttcjpay.closeWebview")
public final class e extends com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f528849k;

    public static final class a {
    }

    static {
    }

    public e() {
        this.f528849k = "ttcjpay.closeWebview";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f528849k;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.a, com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod
    public final void e(Context r100, JSONObject r101, IXPayBaseMethod.c r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L20
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L20
        JSONArray r105 = new JSONArray(r101.get("id").toString());     // Catch: Throwable -> L20
        int r106 = r105.length();     // Catch: Exception -> L8 Throwable -> L20
        int r107 = 0;
    L5:
        if (r107 >= r106) goto L10;
        r104.add(r105.optString(r107));     // Catch: Exception -> L8 Throwable -> L20
        r107 = r107 + 1;
        goto L5
    L10:
        Iterator r108 = r104.iterator();     // Catch: Throwable -> L20
    L12:
        if (r108.hasNext() == false) goto L18;
        String r109 = (String) r108.next();     // Catch: Throwable -> L20
        ve4.a.f554342a.getClass();     // Catch: Throwable -> L20
        PlugInContainerService r110 = (PlugInContainerService) ve4.a.a(PlugInContainerService.class);     // Catch: Throwable -> L20
        if (r110 == null) goto L12;
        ee4.b r111 = r110.getH5ActivityStackHelper();     // Catch: Throwable -> L20
        if (r111 == null) goto L12;
        r111.removeActivity(r109);     // Catch: Throwable -> L20
        goto L12
    L18:
        IXPayBaseMethod.g(this, r102).onSuccess(new JSONObject());     // Catch: Throwable -> L20
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
        return;
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
