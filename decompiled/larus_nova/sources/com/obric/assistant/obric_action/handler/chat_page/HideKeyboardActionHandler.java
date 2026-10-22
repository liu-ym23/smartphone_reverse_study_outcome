package com.obric.assistant.obric_action.handler.chat_page;

import android.content.Context;
import cfa.b;
import cfa.c;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/chat_page/HideKeyboardActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/chat_page/HideKeyboardActionParams;", "Lcom/obric/assistant/obric_action/handler/chat_page/KeyboardActionResult;", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/chat_page/HideKeyboardActionParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HideKeyboardActionHandler implements IObricActionHandler<cfa.a, c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<cfa.a> f390470b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r100 = d.C4614d.f390416a;
        return d.C4614d.f390423h;
    }

    public HideKeyboardActionHandler() {
        this.f390470b = cfa.a.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<cfa.a> b() {
        return this.f390470b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final cfa.a a(Context r100, String r101) {
        return (cfa.a) IObricActionHandler.b.a(this, r100, r101);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r100, cfa.a r101, Continuation<? super h<? extends c>> r102) {
        cfa.a r103 = r101;
        ICoreInputAbility r104 = b.a();
        if (r104 != null) goto L6;
        FLogger.f375446a.w("HideKeyboardActionHandler", "handle: no available chat input ability");
        return h.a.a(h.f390443d, "no available chat input ability", 2);
    L6:
        if (r103 == null) goto L8;
        boolean r105 = Intrinsics.areEqual(r103.a(), Boxing.boxBoolean(true));
    L9:
        r104.qp(r105);
        return h.a.c(h.f390443d, new c(true), null, 2);
    L8:
        r105 = false;
        goto L9
    }
}
