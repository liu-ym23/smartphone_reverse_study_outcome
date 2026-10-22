package com.obric.assistant.obric_action.handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.obric.assistant.obric_action.j;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/OpenSkillDetailActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/ObricSkillDetailActionUtils$Params;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/ObricSkillDetailActionUtils$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenSkillDetailActionHandler implements IObricActionHandler<j.a, Unit> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<j.a> f390448b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r100 = d.l.f390438a;
        return d.l.f390438a;
    }

    public OpenSkillDetailActionHandler() {
        this.f390448b = j.a.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<j.a> b() {
        return this.f390448b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final j.a a(Context r100, String r101) {
        return (j.a) IObricActionHandler.b.a(this, r100, r101);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r100, j.a r110, Continuation<? super h<? extends Unit>> r111) {
        j.a r112 = r110;
        FLogger r113 = FLogger.f375446a;
        r113.i("OpenSkillDetailActionHandler", "execute: params = " + r112);
        String r101 = null;
        if (r112 == null) goto L9;
        String r102 = r112.b();
        if (r102 == null) goto L9;
        if ((!StringsKt.isBlank(r102)) == false) goto L9;
    L11:
        if (r102 != null) goto L13;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == false) goto L19;
        r113.w("OpenSkillDetailActionHandler", "execute: skill_id is empty");
        return h.a.a(h.f390443d, "skill_id is empty", 2);
    L19:
        h.a r114 = h.f390443d;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L34
        Intent r105 = new Intent().setClassName(r100.getPackageName(), "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewStarterActivity").putExtra("slug", r102).putExtra("prefer_shop_detail", true);     // Catch: Throwable -> L34
        if (r112 == null) goto L30;
        String r115 = r112.a();     // Catch: Throwable -> L34
        if (r115 == null) goto L30;
        if ((!StringsKt.isBlank(r115)) == false) goto L27;
        r101 = r115;
    L27:
        if (r101 == null) goto L30;
        r105.putExtra("log_extras", r101);     // Catch: Throwable -> L34
    L30:
        if ((r100 instanceof Activity) == true) goto L32;
        r105.addFlags(268435456);     // Catch: Throwable -> L34
    L32:
        r100.startActivity(r105);     // Catch: Throwable -> L34
        Object r106 = Result.m9449constructorimpl(Boxing.boxBoolean(true));     // Catch: Throwable -> L34
    L36:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r106);
        if (r116 == null) goto L39;
        FLogger.f375446a.w("OpenSkillDetailActionHandler", "startActivity failed. " + r116.getMessage(), r116);
    L39:
        Boolean r117 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r106) == false) goto L43;
        r106 = r117;
    L43:
        return r114.b(((Boolean) r106).booleanValue());
    L34:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    L13:
        if (StringsKt.isBlank(r102) == true) goto L16;
        r103 = false;
    L9:
        r102 = null;
        goto L11
    }
}
