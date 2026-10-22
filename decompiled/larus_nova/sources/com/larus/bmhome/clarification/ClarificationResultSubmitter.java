package com.larus.bmhome.clarification;

import com.larus.bmhome.taskskill.service.SkillServiceDelegate;
import com.larus.im.internal.jni.bean.AskResultV2;
import com.larus.im.internal.jni.bean.DispatchCommand;
import com.larus.im.internal.jni.bean.DispatchCommandBody;
import com.larus.im.internal.jni.bean.DispatchCommandPayload;
import com.larus.im.internal.jni.bean.InteractionAskResultV2Payload;
import com.larus.im.internal.jni.bean.OmniDispatchCommandRequest;
import com.larus.network.FlowHttpConnection;
import com.larus.network.http.ServiceType;
import com.larus.utils.logger.FLogger;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ClarificationResultSubmitter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f310476b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<com.larus.bmhome.chat.component.cvs.y> f310477a;

    public static final class a {
    }

    static {
    }

    public ClarificationResultSubmitter(n1 r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationProvider");
        this.f310477a = r100;
    }

    public final Object a(f2 r310, Continuation<? super h2> r311) {
        com.larus.bmhome.chat.component.cvs.y r100 = this.f310477a.invoke();
        String r101 = null;
        if (r100 == null) goto L5;
        wc9.e r102 = r100.h();
    L7:
        if (ic8.n.t(r102) == false) goto L32;
        String r103 = r310.f310517d;
        SkillServiceDelegate r104 = SkillServiceDelegate.f314414a;
        bs8.a.C0354a r105 = bs8.a.f20295h;
        if (r102 == null) goto L11;
        String r106 = r102.f559215r;
    L12:
        r105.getClass();
        String r107 = r104.j(bs8.a.C0354a.a(r106));
        int r108 = 0;
        if (r107 != null) goto L15;
    L18:
        boolean r109 = true;
    L19:
        if (r109 == false) goto L24;
        FLogger r110 = FLogger.f375446a;
        StringBuilder r111 = new StringBuilder("pc dispatch target device id is empty, conversationId=");
        if (r102 == null) goto L23;
        r101 = r102.f559198a;
    L23:
        r111.append(r101);
        r110.e("ClarificationSubmitter", r111.toString());
        return new h2.a("pc_dispatch_target_device_empty");
    L24:
        Integer r112 = r104.f(r107);
        if (r112 == null) goto L27;
        r108 = r112.intValue();
    L27:
        DispatchCommandPayload r113 = new DispatchCommandPayload(DispatchCommand.INTERACTION_ASK_V2, UUID.randomUUID().toString(), new DispatchCommandBody(null, null, null, null, null, null, null, new InteractionAskResultV2Payload(r103, new AskResultV2(r310.f310519f)), null, null, null, null, null, null, 16255, null), null, com.larus.platform.service.o.f365780a.getDeviceId(), null, 0, null, null, TTVideoEngineInterface.PLAYER_OPTION_DISABLE_MC_REUSE, null);
        kotlinx.coroutines.j r114 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r311), 1);
        r114.C();
        com.larus.im.d.b().sendDispatchCommand(new OmniDispatchCommandRequest(r107, r108, r113), new c2(r113, r102, r114));
        Object r115 = r114.B();
        if (r115 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L34;
        DebugProbesKt.probeCoroutineSuspended(r311);
        return r115;
    L34:
        return r115;
    L15:
        if (StringsKt.isBlank(r107) == true) goto L18;
        r109 = false;
        goto L19
    L11:
        r106 = null;
        goto L12
    L32:
        return b(r310, r311);
    L5:
        r102 = null;
        goto L7
    }

    public final Object b(f2 r110, Continuation<? super h2> r111) {
        if ((r111 instanceof ClarificationResultSubmitter$submitByAskHumanResult$1) == false) goto L7;
        ClarificationResultSubmitter$submitByAskHumanResult$1 r100 = (ClarificationResultSubmitter$submitByAskHumanResult$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ClarificationResultSubmitter$submitByAskHumanResult$1 r102 = r100;
        Object r112 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r112);
    L17:
        dm9.a r113 = (dm9.a) r112;
        if ((r113 instanceof dm9.a.b) == false) goto L24;
        dm9.a.b r114 = (dm9.a.b) r113;
        if (r114.f469231a.isSuccess() == false) goto L30;
        return h2.c.f310539a;
    L30:
        return new h2.a("ask_human_result_biz_error:" + r114.f469231a.getCode() + ':' + r114.f469231a.getMsg());
    L24:
        if ((r113 instanceof dm9.a.C5690a) == false) goto L28;
        StringBuilder r105 = new StringBuilder("ask_human_result_http_error:");
        dm9.a.C5690a r115 = (dm9.a.C5690a) r113;
        r105.append(r115.f469228a);
        r105.append(':');
        r105.append(r115.f469229b);
        return new h2.a(r105.toString());
    L28:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        AskHumanResultRequest r106 = new AskHumanResultRequest(new AskHumanResult(r110.f310517d, new AskHumanResultInteractionAsk(r110.f310519f)));
        AskHumanResultApi.a r116 = AskHumanResultApi.f310432a;
        ClarificationResultSubmitter$submitByAskHumanResult$result$1 r107 = new ClarificationResultSubmitter$submitByAskHumanResult$result$1(r106, null);
        r102.label = 1;
        r116.getClass();
        FlowHttpConnection r117 = FlowHttpConnection.f359975a;
        r112 = FlowHttpConnection.g(ServiceType.MAIN_BOT, AskHumanResultApi.class, r107, true, null, null, null, r102, 240);
        if (r112 != r103) goto L17;
        return r103;
    L7:
        r100 = new ClarificationResultSubmitter$submitByAskHumanResult$1(this, r111);
        goto L8
    }
}
