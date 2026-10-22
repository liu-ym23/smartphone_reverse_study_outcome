package l5;

import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.ai.monitor.bridge.BridgeType;
import com.bytedance.ai.resource.AIManager;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class y implements k5.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f507428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BridgeType f507429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f507430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.ivy.ivykit.api.bridge.c f507431d;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.f("name", this.f507428a);
        r100.f("bridge_type", this.f507429b.getValue());
        String r101 = this.f507430c;
        Object r102 = null;
        if (r101 == null) goto L19;
        r100.f("packageId", r101);
        AIManager r103 = AIManager.f37211a;
        Intrinsics.checkNotNullParameter(r101, "packageId");
        com.bytedance.ai.resource.d0 r104 = IAISDKDebugService.f36186a.v(r101);
        if (r104 == null) goto L9;
        String r105 = r104.f37490j;
        if (r105 == null) goto L9;
    L17:
        if (r105 == null) goto L19;
        r100.f("scmVersion", r105);
    L9:
        if (AIManager.g(r101) == false) goto L13;
        com.bytedance.ai.resource.d0 r106 = AIManager.f37216f.get(r101);
        if (r106 == null) goto L16;
        r105 = r106.f37490j;
    L16:
        r105 = null;
        goto L17
    L13:
        com.bytedance.ai.resource.d0 r107 = AIManager.f37217g.get(r101);
        if (r107 == null) goto L16;
        r105 = r107.f37490j;
    L19:
        com.ivy.ivykit.api.bridge.c r108 = this.f507431d;
        if (r108 == null) goto L46;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L27
        Map<String, Object> r110 = r108.f278305d;     // Catch: Throwable -> L27
        if (r110 == null) goto L24;
        String r111 = com.bytedance.ai.applet.base.gson.e.c(r110);     // Catch: Throwable -> L27
    L25:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L27
    L30:
        if (Result.m9455isFailureimpl(r112) == true) goto L33;
        r102 = r112;
    L33:
        String r113 = (String) r102;
        if (r113 == null) goto L36;
        r100.f("params", r113);
    L36:
        String r114 = r108.f278309h;
        if (r114 == null) goto L39;
        r100.f("url", r114);
    L39:
        r100.e("timestamp", r108.f278310i);
        String r115 = r108.f278307f;
        if (r115 == null) goto L42;
        r100.f("message", r115);
    L42:
        r100.f(Keys.API_PARAM_KEY_PLATFORM_TYPE, r108.f278311j);
        return;
    L24:
        r111 = null;
    L27:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    }

    public y(String r100, BridgeType r101, String r102, com.ivy.ivykit.api.bridge.c r103) {
        this.f507428a = r100;
        this.f507429b = r101;
        this.f507430c = r102;
        this.f507431d = r103;
    }
}
