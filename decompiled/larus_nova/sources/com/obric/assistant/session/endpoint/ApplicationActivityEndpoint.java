package com.obric.assistant.session.endpoint;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.IObricPluginActivityRecordHelper;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.model.IApplicationActivityOperation;
import com.obric.assistant.session.model.ISessionEndPoint;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\u0012\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/session/endpoint/ApplicationActivityEndpoint;", "Lcom/obric/assistant/session/model/ISessionEndPoint;", "Lcom/obric/assistant/session/model/IApplicationActivityOperation;", "<init>", "()V", "foregroundAppPackageNameAtWakeUp", "", "foregroundActivityNameAtWakeUp", "prepareOrder", "", "getPrepareOrder", "()I", "processOrder", "getProcessOrder", "onSessionPrepared", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "args", "Landroid/os/Bundle;", "onSessionProcess", "Lkotlin/Pair;", "Lcom/obric/assistant/session/bean/ErrorCode;", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foregroundAppPackage", "foregroundActivity", "parseArgs", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApplicationActivityEndpoint implements ISessionEndPoint, IApplicationActivityOperation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f391519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f391520b;

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int f() {
        return 90;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int h() {
        return 70;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTagName() {
        return "ApplicationActivityEndpoint";
    }

    public ApplicationActivityEndpoint() {
        this.f391519a = "";
        this.f391520b = "";
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public Context getContext() {
        return ISessionEndPoint.a.getContext(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTAG() {
        return ISessionEndPoint.a.b(this);
    }

    @Override // com.obric.assistant.session.model.IApplicationActivityOperation
    public final String a() {
        return this.f391520b;
    }

    @Override // com.obric.assistant.session.model.IApplicationActivityOperation
    public final String c() {
        return this.f391519a;
    }

    @Override // com.obric.assistant.session.model.IApplicationActivityOperation
    public final void b(Bundle r100) {
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "parseArgs " + r100);
        if (r100 == null) goto L6;
        p(getContext(), r100);
        return;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void n(ErrorCode r100) {
        ISessionEndPoint.a.c(this, r100);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final Object d(Bundle r100, Continuation<? super Pair<? extends ErrorCode, String>> r101) {
        if ((r101 instanceof ApplicationActivityEndpoint$onSessionProcess$1) == false) goto L7;
        ApplicationActivityEndpoint$onSessionProcess$1 r102 = (ApplicationActivityEndpoint$onSessionProcess$1) r101;
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
    L17:
        IAssistantInteractionServiceKt.getInteractionStateService().setWakeUpAppPkg(this.f391519a, "ApplicationActivityEndpoint onSessionProcess");
        return TuplesKt.to(ErrorCode.CONTINUE, "");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.label = 1;
        if (ISessionEndPoint.a.e(this) != r105) goto L17;
        return r105;
    L7:
        r102 = new ApplicationActivityEndpoint$onSessionProcess$1(this, r101);
        goto L8
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void p(Context r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "args");
        ISessionEndPoint.a.d(this, r100, r101);
        int r102 = Build.VERSION.SDK_INT;
        String r103 = "";
        if (r102 < 33) goto L5;
        String r104 = v0.a(r101);
    L6:
        if (r102 < 33) goto L32;
        if (r101 == null) goto L32;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L19
        ArrayList r106 = r101.getParcelableArrayList("android.service.voice.FOREGROUND_ACTIVITIES", ComponentName.class);     // Catch: Throwable -> L19
        if (r106 == null) goto L14;
        ComponentName r107 = (ComponentName) CollectionsKt.firstOrNull(r106);     // Catch: Throwable -> L19
        if (r107 == null) goto L14;
        String r108 = r107.getClassName();     // Catch: Throwable -> L19
    L15:
        if (r108 != null) goto L17;
        r108 = "";
    L17:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L19
    L21:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L25;
        FLogger.f375446a.e("EndpointUtil", "getForeGroundActivityName error: " + r110);
    L25:
        if (Result.m9456isSuccessimpl(r109) == false) goto L27;
        FLogger.f375446a.i("EndpointUtil", "getForeGroundActivityName className: " + ((String) r109));
    L27:
        Object r111 = r103;
        if (Result.m9455isFailureimpl(r109) == true) goto L31;
        r111 = r109;
    L31:
        r103 = (String) r111;
    L14:
        r108 = null;
    L19:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L32:
        this.f391519a = r104;
        this.f391520b = r103;
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "pkg: " + r104 + " act: " + r103);
        IObricPluginActivityRecordHelper.f385120a.getClass();
        IObricPluginActivityRecordHelper r113 = IObricPluginActivityRecordHelper.a.a();
        if (r113 == null) goto L38;
        r113.b();
        return;
    L38:
        return;
    L5:
        r104 = "";
        goto L6
    }
}
