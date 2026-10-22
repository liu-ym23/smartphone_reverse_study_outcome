package com.obric.assistant.login;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentPrivacyIDL;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.assistant.reporter.IObricSystemReporter;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.login.LoginReportImpl$report$1", f = "LoginReportImpl.kt", i = {}, l = {129, 90}, m = "invokeSuspend", n = {}, s = {})
final class LoginReportImpl$report$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ LoginReportImpl this$0;

    public static final class a implements Function1<String, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<String> f390240a;

        public a(kotlinx.coroutines.j r100) {
            this.f390240a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(String r100) {
            String r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "deviceId");
            this.f390240a.resumeWith(Result.m9449constructorimpl(r101));
            return Unit.INSTANCE;
        }
    }

    public LoginReportImpl$report$1(LoginReportImpl r100, Continuation<? super LoginReportImpl$report$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LoginReportImpl$report$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((LoginReportImpl$report$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        boolean r102 = false;
        if (r101 == 0) goto L10;
        if (r101 == 1) goto L9;
        if (r101 != 2) goto L8;
        ResultKt.throwOnFailure(r110);
    L55:
        Boolean r103 = (Boolean) r110;
    L56:
        FLogger.f375446a.i("LoginReportImpl", "report: called, reportODidRelation response: " + r103);
    L58:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        LoginReportImpl r104 = (LoginReportImpl) this.L$0;
        ResultKt.throwOnFailure(r110);
    L33:
        String r111 = (String) r110;
        LoginReportImpl r105 = this.this$0;
        int r106 = LoginReportImpl.f390237b;
        r105.getClass();
        String r107 = com.larus.platform.service.o.f365780a.getDeviceId();
        FLogger r108 = FLogger.f375446a;
        r108.i("LoginReportImpl", "report: called, oMatrixDid = " + r111 + ", doubaoDid = " + r107);
        if (r111 != null) goto L36;
    L39:
        boolean r109 = true;
    L40:
        if (r109 == false) goto L42;
    L59:
        r108.e("LoginReportImpl", "report: called, oMatrixDid or doubaoDid isNullOrEmpty!!");
        return Unit.INSTANCE;
    L42:
        if (r107.length() != 0) goto L44;
        r102 = true;
    L44:
        if (r102 == true) goto L59;
        JSONObject r112 = new JSONObject();
        r112.put("o_system_did", r111);
        r112.put("o_assistant_did", r107);
        KClass r113 = Reflection.getOrCreateKotlinClass(IAgentPrivacyIDL.class);
        int r114 = com.obric.aiagent.assistant.idl.k.f384541a;
        Intrinsics.checkNotNullParameter(r113, "<this>");
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();
        IAgentPrivacyIDL r115 = (IAgentPrivacyIDL) com.obric.aiagent.ipc.utils.g.b(IAgentPrivacyIDL.class);
        if (r115 == null) goto L58;
        String r116 = r115.getPemCertChain("o_did_relation", r112.toString());
        if (r116 == null) goto L58;
        r108.i("LoginReportImpl", "report: called, getPemCertChain result: ".concat(r116));
        IObricNetworkService r117 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        r103 = null;
        if (r117 == null) goto L56;
        this.L$0 = null;
        this.label = 2;
        r110 = r117.k("obric_assistant_aiagent", r116, this);
        if (r110 != r100) goto L55;
        return r100;
    L36:
        if (r111.length() == 0) goto L39;
        r109 = false;
        goto L40
    L10:
        ResultKt.throwOnFailure(r110);
        LoginReportImpl r118 = this.this$0;
        this.L$0 = r118;
        this.label = 1;
        kotlinx.coroutines.j r119 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r119.C();
        a r120 = new a(r119);
        int r121 = LoginReportImpl.f390237b;
        r118.getClass();
        com.obric.assistant.common.utils.m.f387884a.getClass();
        if (com.obric.assistant.common.utils.m.a() == false) goto L16;
        IObricSystemReporter.f391337a.getClass();
        IObricSystemReporter r122 = IObricSystemReporter.a.a();
        if (r122 != null) goto L15;
        FLogger.f375446a.e("LoginReportImpl", "acquireOMatrixDeviceId failed, IObricSystemReporter is null");
        r120.invoke("");
    L28:
        r110 = r119.B();
        if (r110 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L31;
        DebugProbesKt.probeCoroutineSuspended(this);
    L31:
        if (r110 != r100) goto L33;
        return r100;
    L15:
        r122.a(r120);
        goto L28
    L16:
        MatrixTeaManager r123 = MatrixTeaManager.f396960o;
        String r124 = MatrixTeaManager.a.a().e();
        if (r124 != null) goto L19;
    L22:
        boolean r125 = true;
    L23:
        if (r125 == false) goto L25;
    L27:
        MatrixTeaManager.a.a().b(new d(r120));
        goto L28
    L25:
        if (Intrinsics.areEqual(r124, "0") == true) goto L27;
        r120.invoke(r124);
        goto L28
    L19:
        if (StringsKt.isBlank(r124) == true) goto L22;
        r125 = false;
        goto L23
    }
}
