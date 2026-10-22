package com.obric.assistant.obric_action.handler.feedback;

import android.content.Context;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import dfa.c;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t19.j;
import t19.s;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/feedback/FeedbackToastActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/feedback/FeedbackToastActionParams;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/feedback/FeedbackToastActionParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedbackToastActionHandler implements IObricActionHandler<c, Unit> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<c> f390481b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r100 = d.e.f390424a;
        return d.e.f390424a;
    }

    public FeedbackToastActionHandler() {
        this.f390481b = c.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<c> b() {
        return this.f390481b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final c a(Context r100, String r101) {
        return (c) IObricActionHandler.b.a(this, r100, r101);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r100, c r110, Continuation<? super h<? extends Unit>> r111) {
        c r112 = r110;
        if (r112 == null) goto L71;
        String r101 = r112.c();
        String r102 = "";
        if (r101 != null) goto L8;
        String r103 = "";
    L9:
        boolean r104 = true;
        if (r103.length() != 0) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L15;
        FLogger.f375446a.w("FeedbackToastActionHandler", "handle: text is empty");
        return h.a.a(h.f390443d, "text is empty", 2);
    L15:
        Integer r113 = r112.a();
        if (r113 != null) goto L18;
    L23:
        Integer r106 = null;
    L24:
        String r114 = r112.b();
        if (r114 == null) goto L28;
        r102 = r114;
    L28:
        String r115 = StringsKt.trim(r102).toString().toLowerCase(Locale.ROOT);
        if (r115.length() == 0) goto L32;
        r104 = false;
    L32:
        if (r104 == false) goto L35;
        r115 = "default";
    L35:
        switch(r115.hashCode()) {
            case -1867169789: goto L63;
            case -1086574198: goto L57;
            case 3237038: goto L54;
            case 96784904: goto L51;
            case 97618667: goto L44;
            case 1124446108: goto L38;
            default: goto L68;
        };
    L68:
        s.j(s.f544207a, r100, r103, r106, false, 24);
    L70:
        return h.a.c(h.f390443d, null, null, 3);
    L38:
        if (r115.equals("warning") == false) goto L68;
        if (r106 != null) goto L42;
        s.f544207a.getClass();
        s.t(r100, r103);
        goto L70
    L42:
        s r116 = s.f544207a;
        int r117 = r106.intValue();
        r116.getClass();
        s.u(r100, r103, r117);
        goto L70
    L44:
        if (r115.equals("force") == false) goto L68;
        s.f544207a.getClass();
        Intrinsics.checkNotNullParameter(r103, "text");
        Context r107 = s.f(r100);
        if (r107 == null) goto L70;
        t0.e(new j(r103, r107, r106));
        goto L70
    L51:
        if (r115.equals("error") == false) goto L68;
    L59:
        if (r106 != null) goto L61;
        s.f544207a.getClass();
        s.c(r100, r103);
        goto L70
    L61:
        s r118 = s.f544207a;
        int r119 = r106.intValue();
        r118.getClass();
        Intrinsics.checkNotNullParameter(r103, "text");
        Intrinsics.checkNotNullParameter(r103, "text");
        s.l(r100, R.drawable.larus_toast_failure_icon, r103, Integer.valueOf(r119), null, false);
        goto L70
    L54:
        if (r115.equals("info") == false) goto L68;
        s.f544207a.getClass();
        Intrinsics.checkNotNullParameter(r103, "text");
        Intrinsics.checkNotNullParameter(r103, "text");
        s.i(r100, r103, r106, false, false, null);
        goto L70
    L57:
        if (r115.equals("failure") == true) goto L59;
    L63:
        if (r115.equals("success") == false) goto L68;
        if (r106 != null) goto L67;
        s.f544207a.getClass();
        s.p(r100, r103);
        goto L70
    L67:
        s r120 = s.f544207a;
        int r121 = r106.intValue();
        r120.getClass();
        s.q(r100, r103, r121);
        goto L70
    L18:
        if (r113.intValue() <= 0) goto L20;
        boolean r108 = true;
    L21:
        if (r108 == false) goto L23;
        r106 = r113;
        goto L24
    L20:
        r108 = false;
        goto L21
    L12:
        r105 = false;
        goto L13
    L8:
        r103 = r101;
        goto L9
    L71:
        return h.a.a(h.f390443d, "params is null", 2);
    }
}
