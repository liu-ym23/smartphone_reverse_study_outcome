package com.obric.assistant.session.endpoint;

import android.content.Context;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.model.ILostModeOperation;
import com.obric.assistant.session.model.ISessionEndPoint;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/session/endpoint/LostModeEndpoint;", "Lcom/obric/assistant/session/model/ISessionEndPoint;", "Lcom/obric/assistant/session/model/ILostModeOperation;", "<init>", "()V", "processOrder", "", "getProcessOrder", "()I", "onSessionProcess", "Lkotlin/Pair;", "Lcom/obric/assistant/session/bean/ErrorCode;", "", "args", "Landroid/os/Bundle;", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LostModeEndpoint implements ISessionEndPoint, ILostModeOperation {
    public LostModeEndpoint() {
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int f() {
        return 0;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int h() {
        return 100;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTagName() {
        return "LostModeEndpoint";
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public Context getContext() {
        return ISessionEndPoint.a.getContext(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTAG() {
        return ISessionEndPoint.a.b(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void n(ErrorCode r100) {
        ISessionEndPoint.a.c(this, r100);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final Object d(Bundle r100, Continuation<? super Pair<? extends ErrorCode, String>> r101) {
        if ((r101 instanceof LostModeEndpoint$onSessionProcess$1) == false) goto L7;
        LostModeEndpoint$onSessionProcess$1 r102 = (LostModeEndpoint$onSessionProcess$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (Bundle) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L17:
        String r107 = bga.j.a();
        if (com.obric.assistant.session.singleton.e.f391669a == false) goto L25;
        if (Intrinsics.areEqual(r107, "WAKEUP_SOURCE_VOICE_ASSIST") == false) goto L22;
        wna.a.c(r100);
    L22:
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "ignore in lost mode");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "LostMode is ACTIVE");
    L25:
        return TuplesKt.to(ErrorCode.CONTINUE, "");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = r100;
        r102.label = 1;
        if (ISessionEndPoint.a.e(this) != r105) goto L17;
        return r105;
    L7:
        r102 = new LostModeEndpoint$onSessionProcess$1(this, r101);
        goto L8
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void p(Context r100, Bundle r101) {
        ISessionEndPoint.a.d(this, r100, r101);
    }
}
