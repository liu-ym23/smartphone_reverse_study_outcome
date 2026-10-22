package com.obric.assistant.obric_action.handler.auth;

import afa.j;
import android.content.Context;
import bfa.c;
import com.obric.assistant.AuthenticationType;
import com.obric.assistant.ISessionAuthenticationService;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/auth/SessionAuthStatusActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "", "Lcom/obric/assistant/obric_action/handler/auth/result/SessionAuthStatusResult;", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SessionAuthStatusActionHandler implements IObricActionHandler<String, c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<String> f390467b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r100 = d.c.f390410a;
        return d.c.f390411b;
    }

    public SessionAuthStatusActionHandler() {
        this.f390467b = String.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<String> b() {
        return this.f390467b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final String a(Context r100, String r101) {
        return (String) IObricActionHandler.b.a(this, r100, r101);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r110, String r111, Continuation<? super h<? extends c>> r112) {
        ISessionAuthenticationService r113 = j.d("SessionAuthStatusActionHandler");
        if (r113 == null) goto L7;
        Pair<Boolean, AuthenticationType> r114 = r113.i();
        boolean r100 = r114.component1().booleanValue();
        AuthenticationType r115 = r114.component2();
        return h.a.c(h.f390443d, new c(r113.getSessionId(), r100, r115.getType(), r113.k().getValue().booleanValue(), r113.o().getValue().booleanValue(), IKeyguardStateKt.getKeyguardState().isKeyguardLocked(), IKeyguardStateKt.getKeyguardState().isDeviceLocked(), IKeyguardStateKt.getKeyguardState().isDeviceSecure()), null, 2);
    L7:
        return h.a.a(h.f390443d, "ISessionAuthenticationService is null", 2);
    }
}
