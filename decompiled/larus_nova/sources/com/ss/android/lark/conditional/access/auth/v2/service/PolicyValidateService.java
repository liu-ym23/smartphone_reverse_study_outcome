package com.ss.android.lark.conditional.access.auth.v2.service;

import com.bytedance.lark.policy.decision.PolicyDecision;
import com.bytedance.lark.policy.model.ValidateRequest;
import com.bytedance.lark.policy.model.b0;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import i8b.q;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class PolicyValidateService extends i8b.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f417857c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f417858b;

    public static final class a {
    }

    static {
    }

    @Override // i8b.a
    public final void a() {
        CompositeDisposable r100 = j8b.d.f497742a;
        j8b.d.f497742a.clear();
    }

    public PolicyValidateService(q r100) {
        Intrinsics.checkNotNullParameter(r100, "mManager");
        super(r100);
        this.f417858b = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i8b.a
    public final void b(com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof i8b.c) == false) goto L10;
        ScsLogger.d("SecurityPolicy_PolicyValidateService", "[start update auth result] BatchValidateEvent.");
        i8b.b r101 = (i8b.b) ((i8b.c) r100).f440413a;
        if (r101.f488727b.isEmpty() == false) goto L8;
        ScsLogger.d("SecurityPolicy_PolicyValidateService", "data.validateModels isEmpty.");
        return;
    L8:
        String r102 = qqb.a.d();
        BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.f440424a, Dispatchers.getIO(), null, new PolicyValidateService$handleEvent$1(r102, this, r101, null), 2, null);
        return;
    L10:
        if ((r100 instanceof i8b.e) == false) goto L13;
        ScsLogger.d("SecurityPolicy_PolicyValidateService", "[start update auth result] CCMDLPUpdateEvent.");
        String r103 = qqb.a.d();
        BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.f440424a, Dispatchers.getIO(), null, new PolicyValidateService$handleEvent$2(r103, this, r100, null), 2, null);
        return;
    L13:
        if ((r100 instanceof i8b.g) == false) goto L18;
        ScsLogger.d("SecurityPolicy_PolicyValidateService", "[start update auth result] CCMFileProtectUpdateEvent.");
        String r104 = qqb.a.d();
        BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.f440424a, Dispatchers.getIO(), null, new PolicyValidateService$handleEvent$3(r104, this, r100, null), 2, null);
        return;
    }

    @Override // i8b.a
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "tenantId");
        this.f417858b = r100;
    }

    public final Object e(List<PolicyModel> r210, final FileAuthMonitor.a r211, Continuation<? super Map<String, b0>> r212) {
        List<PolicyModel> r100 = r210;
        if ((r212 instanceof PolicyValidateService$policyValidateWithCoroutine$1) == false) goto L7;
        PolicyValidateService$policyValidateWithCoroutine$1 r101 = (PolicyValidateService$policyValidateWithCoroutine$1) r212;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        PolicyValidateService$policyValidateWithCoroutine$1 r103 = r101;
        Object r104 = r103.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        String r111 = "";
        String r112 = "SecurityPolicy_PolicyValidateService";
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        Map r106 = (Map) r103.L$1;
        String r107 = (String) r103.L$0;
        ResultKt.throwOnFailure(r104);
        String r113 = "";
        String r114 = "SecurityPolicy_PolicyValidateService";
    L84:
        String r115 = qqb.a.d();     // Catch: Throwable -> L69
        qqb.a.f(r107);     // Catch: Throwable -> L67
        ScsLogger.d(r114, "end policyValidateWithCoroutine.");     // Catch: Throwable -> L67
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r115, "traceId");
        qqb.a.g(r115);
        return r106;
    L67:
        th = th;
    L71:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r115, "traceId");
        qqb.a.g(r115);
        throw th;
    L69:
        th = th;
        r115 = r113;
        goto L71
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r108 = (String) r103.L$4;
        Map r109 = (Map) r103.L$3;
        String r116 = (String) r103.L$2;
        FileAuthMonitor.a r117 = (FileAuthMonitor.a) r103.L$1;
        List<PolicyModel> r118 = (List) r103.L$0;
        ResultKt.throwOnFailure(r104);
        String r119 = r108;
        String r120 = r116;
        FileAuthMonitor.a r121 = r117;
        r100 = r118;
        r113 = "";
        r114 = "SecurityPolicy_PolicyValidateService";
    L43:
        Map r122 = (Map) r104;
        if (Intrinsics.areEqual(r119, this.f417858b) == true) goto L47;
        ArrayList<String> r123 = com.ss.android.lark.conditional.access.utils.c.f418483a;
        com.ss.android.lark.conditional.access.utils.c.b(r114, "asyncValidate return result, but validateUid != userId", false);
        return MapsKt.emptyMap();
    L47:
        ArrayList r124 = new ArrayList();
        Iterator<T> r125 = r100.iterator();
    L49:
        if (r125.hasNext() == false) goto L53;
        Object r126 = r125.next();
        if ((!com.ss.android.lark.conditional.access.auth.v2.b.f417779a.contains(((PolicyModel) r126).getPointKey())) == false) goto L49;
        r124.add(r126);
        goto L49
    L53:
        LinkedHashMap r127 = new LinkedHashMap();
        Iterator r128 = r124.iterator();
    L55:
        if (r128.hasNext() == false) goto L59;
        PolicyModel r129 = (PolicyModel) r128.next();
        b0 r130 = (b0) r122.get(r129.getTaskId());
        if (r130 == null) goto L55;
        r127.put(r129.getTaskId(), r130);
        goto L55
    L59:
        PolicyValidateService$policyValidateWithCoroutine$4 r131 = new PolicyValidateService$policyValidateWithCoroutine$4(r120, this, r124, r127, r121, null);
        r103.L$0 = r120;
        r103.L$1 = r122;
        r103.L$2 = null;
        r103.L$3 = null;
        r103.L$4 = null;
        r103.label = 2;
        if (CoroutineScopeKt.coroutineScope(r131, r103) != r110) goto L62;
        return r110;
    L62:
        r107 = r120;
        r106 = r122;
        goto L84
    L16:
        ResultKt.throwOnFailure(r104);
        int r132 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_PolicyValidateService", "start policyValidateWithCoroutine, [updateTrigger:" + r211.f418459a.name() + ']');
        String r133 = qqb.a.d();
        final long r134 = System.currentTimeMillis();
        LinkedHashMap r135 = new LinkedHashMap();
        Iterator r136 = r100.iterator();
    L18:
        if (r136.hasNext() == false) goto L24;
        PolicyModel r137 = (PolicyModel) r136.next();
        String r138 = r137.getTaskId();
        boolean r139 = this.f488725a.h(r137);
        Iterator r140 = r136;
        String r141 = r111;
        JSONObject r142 = new JSONObject(com.ss.android.lark.security.compliance.infra.util.f.c(r137.getEntity()));
        if (w4c.c.a().E() == false) goto L23;
        r142.put("base", new JSONObject().put("GUARDIAN_EVALUATOR_OPTION", new JSONObject().put("IS_PRE_EVALUATE", true)));
    L23:
        r135.put(r138, new ValidateRequest("PC:CLIENT:android:" + r137.getPointKey(), r142, r139));
        r136 = r140;
        r110 = r110;
        r111 = r141;
        r112 = r112;
        goto L18
    L24:
        Object r143 = r110;
        r113 = r111;
        String r213 = r112;
        this.f488725a.g(r100, r211.f418459a);
        r119 = this.f417858b;
        r103.L$0 = r100;
        r103.L$1 = r211;
        r103.L$2 = r133;
        r103.L$3 = r135;
        r103.L$4 = r119;
        r103.J$0 = r134;
        r103.label = 1;
        final SafeContinuation r144 = new SafeContinuation(IntrinsicsKt.intercepted(r103));
        String r145 = qqb.a.d();     // Catch: Throwable -> L75
        Intrinsics.checkNotNullParameter(r133, "traceId");     // Catch: Throwable -> L73
        qqb.a.g(r133);     // Catch: Throwable -> L73
        Iterator<T> r146 = r100.iterator();     // Catch: Throwable -> L73
    L28:
        if (r146.hasNext() == false) goto L32;
        Object r147 = r146.next();     // Catch: Throwable -> L73
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.f.f440407a.values().contains(((PolicyModel) r147).getPointKey()) == false) goto L28;
    L33:
        if (r147 == null) goto L35;
        r114 = r213;
        ScsLogger.d(r114, "start invoke DLPEngine.getDLPResult");     // Catch: Throwable -> L73
        CompositeDisposable r148 = j8b.d.f497742a;     // Catch: Throwable -> L73
        j8b.d.a(r100, new PolicyValidateService$policyValidateWithCoroutine$resultMap$1$1$2(r134, r211, r144));     // Catch: Throwable -> L73
    L36:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r145, "traceId");
        qqb.a.g(r145);
        Object r149 = r144.getOrThrow();
        if (r149 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L39;
        DebugProbesKt.probeCoroutineSuspended(r103);
    L39:
        r110 = r143;
        if (r149 != r110) goto L42;
        return r110;
    L42:
        r121 = r211;
        r120 = r133;
        r104 = r149;
        goto L43
    L35:
        r114 = r213;
        ScsLogger.d(r114, "start invoke PolicyEngine.asyncValidate");     // Catch: Throwable -> L73
        Function1<Map<String, ? extends b0>, Unit> r150 = new PolicyValidateService$policyValidateWithCoroutine$resultMap$1$1$3(r134, r211, r144);     // Catch: Throwable -> L73
        ke6.d r151 = ke6.d.f503032a;     // Catch: Throwable -> L73
        Intrinsics.checkNotNullParameter(r135, "requestMap");     // Catch: Throwable -> L73
        Intrinsics.checkNotNullParameter(r150, "callback");     // Catch: Throwable -> L73
        int r152 = PolicyDecision.f253787a;     // Catch: Throwable -> L73
        PolicyDecision.c(r135, r150);     // Catch: Throwable -> L73
        goto L36
    L32:
        r147 = null;
    L73:
        th = th;
        String r153 = r145;
    L77:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r153, "traceId");
        qqb.a.g(r153);
        throw th;
    L75:
        th = th;
        r153 = r113;
    L7:
        r101 = new PolicyValidateService$policyValidateWithCoroutine$1(this, r212);
        goto L8
    }
}
