package com.obric.assistant.obric_action.handler.chat_page;

import android.content.Context;
import cfa.k;
import cfa.l;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/chat_page/StashWindowActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/chat_page/WindowVisibilityActionParams;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/chat_page/WindowVisibilityActionParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StashWindowActionHandler implements IObricActionHandler<l, Unit> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<l> f390478b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r100 = d.C4614d.f390416a;
        return d.C4614d.f390418c;
    }

    public StashWindowActionHandler() {
        this.f390478b = l.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<l> b() {
        return this.f390478b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final l a(Context r100, String r101) {
        return (l) IObricActionHandler.b.a(this, r100, r101);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r100, l r101, Continuation<? super h<? extends Unit>> r102) {
        l r103 = r101;
        if (r103 == null) goto L5;
        String r104 = r103.a();
    L6:
        WindowAnimationType r105 = k.a(r104);
        IAssistantChatWindow r106 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r106 != null) goto L10;
        FLogger.f375446a.w("StashWindowActionHandler", "handle: AssistantChatWindow service is null");
        return h.a.a(h.f390443d, "AssistantChatWindow service is null", 2);
    L10:
        if (r106.isWindowMode() == true) goto L13;
        FLogger.f375446a.w("StashWindowActionHandler", "handle: stash window ignored, window mode disabled");
        return h.a.c(h.f390443d, null, null, 3);
    L13:
        if (r106.isShowing() == true) goto L15;
        FLogger.f375446a.w("StashWindowActionHandler", "handle: stash window ignored, window is not showing");
        return h.a.c(h.f390443d, null, null, 3);
    L15:
        FLogger.f375446a.i("StashWindowActionHandler", "handle: stash window, animation=" + r105);
        r106.stash(r105);
        return h.a.c(h.f390443d, null, null, 3);
    L5:
        r104 = null;
        goto L6
    }
}
