package com.obric.assistant.obric_action.handler.router;

import android.content.Context;
import com.bytedance.router.SmartRouter;
import com.larus.utils.logger.FLogger;
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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/router/DeepLinkActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeepLinkActionHandler implements IObricActionHandler<String, Unit> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<String> f390517b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r100 = d.i.f390435a;
        return d.i.f390435a;
    }

    public DeepLinkActionHandler() {
        this.f390517b = String.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<String> b() {
        return this.f390517b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final String a(Context r100, String r101) {
        return (String) IObricActionHandler.b.a(this, r100, r101);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r100, String r101, Continuation<? super h<? extends Unit>> r110) {
        String r102 = r101;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        boolean r103 = true;
        if (r102.length() != 0) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L30;
        FLogger r105 = FLogger.f375446a;
        r105.i("DeepLinkActionHandler", "handle: deeplink = ".concat(r102));
        h.a r106 = h.f390443d;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L18
        if (SmartRouter.canOpen(r102) == false) goto L15;
        SmartRouter.buildRoute(r100, r102).d();     // Catch: Throwable -> L18
    L16:
        Object r108 = Result.m9449constructorimpl(Boxing.boxBoolean(r103));     // Catch: Throwable -> L18
    L20:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r108);
        if (r111 == null) goto L23;
        FLogger.f375446a.e("DeepLinkActionHandler", "handle: deeplink = ".concat(r102), r111);
    L23:
        Boolean r109 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r108) == false) goto L27;
        r108 = r109;
    L27:
        return r106.b(((Boolean) r108).booleanValue());
    L15:
        r105.w("DeepLinkActionHandler", "can not open deeplink: ".concat(r102));     // Catch: Throwable -> L18
        r103 = false;
    L18:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L30:
        return h.a.a(h.f390443d, "deeplink is empty", 2);
    L8:
        r104 = false;
        goto L9
    }
}
