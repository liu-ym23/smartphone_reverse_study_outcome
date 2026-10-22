package com.obric.assistant.session.endpoint;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.model.IAutoMicOperation;
import com.obric.assistant.session.model.ISessionEndPoint;
import com.obric.assistant.trace.IObricTraceParam;
import com.obric.assistant.voice.ContentScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0017J\n\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/session/endpoint/AutoMicEndpoint;", "Lcom/obric/assistant/session/model/ISessionEndPoint;", "Lcom/obric/assistant/session/model/IAutoMicOperation;", "<init>", "()V", "prepareOrder", "", "getPrepareOrder", "()I", "autoMicToken", "Lcom/obric/assistant/session/bean/AutoMicToken;", "mLock", "Ljava/util/concurrent/locks/ReentrantLock;", "onSessionPrepared", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "args", "Landroid/os/Bundle;", "onSessionProcess", "Lkotlin/Pair;", "Lcom/obric/assistant/session/bean/ErrorCode;", "", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getToken", "setToken", "source", "Lcom/obric/assistant/voice/ContentScene;", "data", "Landroid/os/Parcelable;", BasicTestActionHandler.TEST_ACTION_RESET, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoMicEndpoint implements ISessionEndPoint, IAutoMicOperation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zfa.a f391529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f391530b;

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int f() {
        return -50;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int h() {
        return 0;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTagName() {
        return "AutoMicEndpoint";
    }

    @Override // com.obric.assistant.session.model.IAutoMicOperation
    public final zfa.a getToken() {
        ReentrantLock r100 = this.f391530b;
        r100.lock();
        zfa.a r101 = this.f391529a;     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    @Override // com.obric.assistant.session.model.IAutoMicOperation
    public final void reset() {
        ReentrantLock r100 = this.f391530b;
        r100.lock();
        this.f391529a = null;     // Catch: Throwable -> L6
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r100.unlock();
        return;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public AutoMicEndpoint() {
        this.f391530b = new ReentrantLock();
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

    @Override // com.obric.assistant.session.model.IAutoMicOperation
    public final void a(ContentScene r100, Parcelable r101) {
        ReentrantLock r102 = this.f391530b;
        r102.lock();
        this.f391529a = new zfa.a(r100, r101);     // Catch: Throwable -> L6
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r102.unlock();
        return;
    L6:
        th = move-exception;
        r102.unlock();
        throw th;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final Object d(Bundle r100, Continuation<? super Pair<? extends ErrorCode, String>> r101) {
        if ((r101 instanceof AutoMicEndpoint$onSessionProcess$1) == false) goto L7;
        AutoMicEndpoint$onSessionProcess$1 r102 = (AutoMicEndpoint$onSessionProcess$1) r101;
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
        r102 = new AutoMicEndpoint$onSessionProcess$1(this, r101);
        goto L8
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void p(Context r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "args");
        ISessionEndPoint.a.d(this, r100, r101);
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_AUTO_MIC") == false) goto L10;
        zfa.a r102 = this.f391529a;
        if (r102 == null) goto L11;
        ContentScene r103 = r102.f571784a;
        if (r103 == null) goto L12;
        IInteractionStateService r104 = IAssistantInteractionServiceKt.getInteractionStateService();
        IObricTraceParam.f393539a.getClass();
        int r105 = com.obric.assistant.automic.i.f385863a;
        r104.setWakeUpData(0, com.obric.assistant.automic.a.a(r103));
        return;
    L12:
        return;
    L11:
        return;
    }
}
