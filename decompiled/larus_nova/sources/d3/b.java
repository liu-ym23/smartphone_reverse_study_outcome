package d3;

import com.bytedance.ai.bridge.core.AIBridgeMethod;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class b implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f466590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f466591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f466592c;

    public /* synthetic */ b(w r100, x r101, AtomicBoolean r102) {
        this.f466590a = r100;
        this.f466591b = r101;
        this.f466592c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        final w r101 = this.f466590a;
        final x r102 = this.f466591b;
        final AtomicBoolean r103 = this.f466592c;
        b0 r104 = (b0) r100;
        r101.getClass();
        String r105 = r101.e(r102.f466659a);
        if (r104 == null) goto L5;
        r104.c(r102.f466659a, new c(r101, r102, r103), new d(r101, r102, r103), r105);
    L10:
        return Unit.INSTANCE;
    L5:
        j4.a.f497160a.getClass();
        j4.a r106 = j4.a.C6391a.a();
        if (r106 == null) goto L8;
        r106.markError(r105);
    L8:
        r101.h(r102, new AIBridgeMethod.Error("can not find target runtime", null, 2, 0 == true ? 1 : 0), r103);
        com.bytedance.ai.applet.base.log.b r107 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[AIBridge] can not find target runtime with target: " + r102.f466659a.g(), null);
        goto L10
    }
}
