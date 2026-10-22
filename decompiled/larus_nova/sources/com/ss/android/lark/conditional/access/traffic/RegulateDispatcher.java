package com.ss.android.lark.conditional.access.traffic;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.handler.policy.center.PolicyCenterDisplayIdActionGate;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import io.reactivex.subjects.PublishSubject;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class RegulateDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PublishSubject<InternalSecurityAction> f418428a = null;

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/conditional/access/traffic/RegulateDispatcher$ActionFrom;", "", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public @interface ActionFrom {
    }

    static {
        new String[]{"DLP_CONTENT_DETECTING", "DLP_CONTENT_SENSITIVE"};
        new String[]{"ACCESS_MFA", "BLOCKED_BY_IP_RULE", "BLOCKED_BY_DEVICE_CREDIBILITY", "BLOCKED_BY_DEVICE_OWNERSHIP"};
        f418428a = PublishSubject.create();
    }

    public static void a(InternalSecurityAction r110, @ActionFrom String r111) {
        Intrinsics.checkNotNullParameter(r110, "action");
        Intrinsics.checkNotNullParameter(r111, "comeFrom");
        int r100 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_RegulateDispatcher", "[start handle action], handleSecurityAction(), [actionSource:" + r111 + "], [rawDecision:" + r110.getRawActions() + ']');
        Lazy r101 = PolicyCenterDisplayIdActionGate.f418440a;
        Intrinsics.checkNotNullParameter(r110, "action");
        if (((com.ss.android.lark.conditional.access.traffic.handler.policy.center.a) PolicyCenterDisplayIdActionGate.f418440a.getValue()).C5(r110) == false) goto L5;
        return;
    L5:
        int r102 = g8b.b.f480460a;
        if (g8b.b.a.a().j() == true) goto L58;
        r110.getInternalParams().put("comeFrom", r111);
        if (r110.getCurrentAction().getParams().get("style") != null) goto L48;
        Lazy r103 = ActionDispatcher.f418424a;
        Intrinsics.checkNotNullParameter(r110, "action");
        Intrinsics.checkNotNullParameter(r111, "comeFrom");
        boolean r104 = false;
        Object r105 = null;
        if (w4c.c.a().A() == false) goto L27;
        Iterator<T> r106 = r110.getActions().iterator();
    L14:
        if (r106.hasNext() == false) goto L23;
        Object r107 = r106.next();
        DecisionData.Action r108 = (DecisionData.Action) r107;
        if (Intrinsics.areEqual(r108.getName(), "ACCESS_CONTROL_ACTION_COMMON") == true) goto L18;
    L20:
        boolean r109 = false;
    L21:
        if (r109 == false) goto L14;
    L24:
        DecisionData.Action r112 = (DecisionData.Action) r107;
        if (r112 == null) goto L27;
        String r113 = r112.getParams().get("logID");
        int r114 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_ActionDispatcher", "tryPickCustomAction, [logId:" + r113 + ']');
        r110.setCurrentAction(r112);
        goto L27
    L18:
        if (ArraysKt.contains(new String[]{"FILE_PROTECT", "POLICY_CENTER", "DEFAULT_PLATFORM_POLICY_SET"}, r108.getParams().get("policyType")) == false) goto L20;
        r109 = true;
        goto L21
    L23:
        r107 = null;
    L27:
        Iterator r115 = ((List) ActionDispatcher.f418427d.getValue()).iterator();
    L29:
        if (r115.hasNext() == false) goto L33;
        Object r116 = r115.next();
        if (((q8b.c) r116).b(r110.getCurrentAction()) == false) goto L29;
        r105 = r116;
    L33:
        q8b.c r117 = (q8b.c) r105;
        if (r117 == null) goto L59;
        int r118 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_ActionDispatcher", "pick actionHandler is " + r117.c() + ", [selectedAction:" + r110.getCurrentAction() + ']');
        Lazy r119 = ActionDispatcher.f418424a;
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L39;
    L45:
        if (r104 == false) goto L47;
        ScsLogger.d("SecurityPolicy_ActionDispatcher", "skip officeSDK access control actionHandler " + r117.c() + ", [selectedAction:" + r110.getCurrentAction() + ']');
        FileAuthMonitor.UpdateTrigger[] r120 = FileAuthMonitor.f418450a;
        FileAuthMonitor.n(r111, r110);
        return;
    L47:
        r117.a(r110);
        FileAuthMonitor.UpdateTrigger[] r121 = FileAuthMonitor.f418450a;
        FileAuthMonitor.n(r111, r110);
        return;
    L39:
        if (((List) ActionDispatcher.f418424a.getValue()).contains(r117) == false) goto L45;
        if (w4c.c.a().v0() == false) goto L44;
        r104 = true;
        goto L45
    L44:
        r104 = !ActionDispatcher.f418425b.contains(r117.getClass());
        goto L45
    L59:
        return;
    L48:
        f418428a.onNext(r110);
        return;
    }
}
