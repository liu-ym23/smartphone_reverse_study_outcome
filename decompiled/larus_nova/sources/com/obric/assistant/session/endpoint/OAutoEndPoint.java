package com.obric.assistant.session.endpoint;

import android.content.Context;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.oauto.IOAutoApi;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.model.IApplicationActivityOperation;
import com.obric.assistant.session.model.IOAutoOperation;
import com.obric.assistant.session.model.ISessionEndPoint;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/session/endpoint/OAutoEndPoint;", "Lcom/obric/assistant/session/model/ISessionEndPoint;", "Lcom/obric/assistant/session/model/IOAutoOperation;", "<init>", "()V", "prepareOrder", "", "getPrepareOrder", "()I", "onSessionPrepared", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "args", "Landroid/os/Bundle;", "onSessionProcess", "Lkotlin/Pair;", "Lcom/obric/assistant/session/bean/ErrorCode;", "", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleInterWithOAuto", "isBackgroundInOAuto", "", "isDisplayInOAuto", "exitBackgroundOAuto", "delayMS", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OAutoEndPoint implements ISessionEndPoint, IOAutoOperation {
    public OAutoEndPoint() {
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int f() {
        return 0;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int h() {
        return 0;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTagName() {
        return "OAutoEndPoint";
    }

    @Override // com.obric.assistant.session.model.IOAutoOperation
    public final void a() {
        IOAutoApi r100 = com.obric.assistant.oauto.b.a();
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.b() != true) goto L7;
    L8:
        if (r101 == false) goto L13;
        IOAutoApi r102 = com.obric.assistant.oauto.b.a();
        if (r102 == null) goto L14;
        r102.f();
        return;
    L14:
        return;
    L13:
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.obric.assistant.session.model.IOAutoOperation
    public final boolean c() {
        IOAutoApi r100 = com.obric.assistant.oauto.b.a();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        IApplicationActivityOperation r102 = bga.c.a();
        if (r102 == null) goto L11;
        String r103 = r102.c();
    L12:
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "isBackgroundInOAuto: isDisplayInOAuto = " + r101 + ", foregroundAppPackage = " + r103);
        if (r101 == true) goto L15;
    L17:
        return false;
    L15:
        if (Intrinsics.areEqual(r103, "com.obric.autoaction") == true) goto L17;
        return true;
    L11:
        r103 = null;
        goto L12
    L5:
        if (r100.b() != true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public Context getContext() {
        return ISessionEndPoint.a.getContext(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTAG() {
        return ISessionEndPoint.a.b(this);
    }

    @Override // com.obric.assistant.session.model.IOAutoOperation
    public final void b(long r100) {
        boolean r101 = c();
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "exitBackgroundOAuto: isBackgroundInOAuto: " + r101);
        if (r101 == false) goto L8;
        IAssistantChatWindow r102 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r102 == null) goto L9;
        r102.exitVirtualDisplay(r100);
        return;
    L9:
        return;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void n(ErrorCode r100) {
        ISessionEndPoint.a.c(this, r100);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final Object d(Bundle r100, Continuation<? super Pair<? extends ErrorCode, String>> r101) {
        if ((r101 instanceof OAutoEndPoint$onSessionProcess$1) == false) goto L7;
        OAutoEndPoint$onSessionProcess$1 r102 = (OAutoEndPoint$onSessionProcess$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L18:
        return TuplesKt.to(ErrorCode.CONTINUE, "");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.label = 1;
        if (ISessionEndPoint.a.e(this) != r105) goto L18;
        return r105;
    L7:
        r102 = new OAutoEndPoint$onSessionProcess$1(this, r101);
        goto L8
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void p(Context r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "args");
        ISessionEndPoint.a.d(this, r100, r101);
        a();
    }
}
