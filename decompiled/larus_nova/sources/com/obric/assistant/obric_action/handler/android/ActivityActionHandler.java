package com.obric.assistant.obric_action.handler.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.oauto.IOAutoApi;
import com.obric.assistant.oauto.b;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/android/ActivityActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Landroid/content/Intent;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "(Landroid/content/Context;Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityActionHandler implements IObricActionHandler<Intent, Unit> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<Intent> f390456b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        return d.b.f390406a.getActivity();
    }

    public ActivityActionHandler() {
        this.f390456b = Intent.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<Intent> b() {
        return this.f390456b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Intent a(Context r100, String r101) {
        return (Intent) IObricActionHandler.b.a(this, r100, r101);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r100, Intent r101, Continuation<? super h<? extends Unit>> r102) {
        Intent r103 = r101;
        if (r103 == null) goto L37;
        FLogger.f375446a.i("ActivityActionHandler", "handle: intent = " + r103);
        h.a r104 = h.f390443d;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L25
        r103.setPackage(r100.getPackageName());     // Catch: Throwable -> L25
        IOAutoApi r106 = b.a();     // Catch: Throwable -> L25
        boolean r107 = true;
        if (r106 != null) goto L9;
    L11:
        boolean r108 = false;
    L12:
        if (r108 == false) goto L20;
        IOAutoApi r109 = b.a();     // Catch: Throwable -> L25
        if (r109 != null) goto L16;
    L18:
        r107 = false;
    L23:
        Object r110 = Result.m9449constructorimpl(Boxing.boxBoolean(r107));     // Catch: Throwable -> L25
    L27:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L30;
        FLogger.f375446a.w("ActivityActionHandler", "startActivity failed. " + r111.getMessage(), r111);
    L30:
        Boolean r112 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r110) == false) goto L34;
        r110 = r112;
    L34:
        return r104.b(((Boolean) r110).booleanValue());
    L16:
        if (r109.g(r100, r103, false) != true) goto L18;
    L20:
        if ((r100 instanceof Activity) == true) goto L22;
        r103.addFlags(268435456);     // Catch: Throwable -> L25
    L22:
        r100.startActivity(r103);     // Catch: Throwable -> L25
        goto L23
    L9:
        if (r106.c(r103) != true) goto L11;
        r108 = true;
    L25:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    L37:
        return h.a.a(h.f390443d, "intent is null", 2);
    }
}
