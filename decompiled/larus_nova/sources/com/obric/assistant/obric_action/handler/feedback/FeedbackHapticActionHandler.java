package com.obric.assistant.obric_action.handler.feedback;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/obric_action/handler/feedback/FeedbackHapticActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/feedback/FeedbackHapticActionParams;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/feedback/FeedbackHapticActionParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveEffect", "Lcom/obric/assistant/interaction/base/feedback/VibratorSmtFeedbackEffect;", "effect", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedbackHapticActionHandler implements IObricActionHandler<dfa.a, Unit> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<dfa.a> f390479b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r100 = d.e.f390424a;
        return d.e.f390425b;
    }

    public FeedbackHapticActionHandler() {
        this.f390479b = dfa.a.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<dfa.a> b() {
        return this.f390479b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final dfa.a a(Context r100, String r101) {
        return (dfa.a) IObricActionHandler.b.a(this, r100, r101);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r100, dfa.a r101, Continuation<? super h<? extends Unit>> r102) {
        dfa.a r103 = r101;
        String r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.a();
    L6:
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        String r106 = StringsKt.trim(r105).toString().toLowerCase(Locale.ROOT);
        if (r106.length() != 0) goto L11;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L16;
        r106 = "tick";
    L16:
        switch(r106.hashCode()) {
            case -326696768: goto L43;
            case 3535914: goto L39;
            case 3559837: goto L35;
            case 108511787: goto L31;
            case 951117504: goto L27;
            case 1117703958: goto L23;
            case 1124446108: goto L19;
            default: goto L46;
        };
    L46:
        VibratorSmtFeedbackEffect r108 = null;
    L47:
        if (r108 != null) goto L52;
        FLogger r109 = FLogger.f375446a;
        StringBuilder r110 = new StringBuilder("handle: unsupported effect=");
        if (r103 == null) goto L51;
        r104 = r103.a();
    L51:
        r110.append(r104);
        r109.w("FeedbackHapticActionHandler", r110.toString());
        return h.a.a(h.f390443d, "unsupported haptic effect", 2);
    L52:
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(r108);
        return h.a.c(h.f390443d, null, null, 3);
    L19:
        if (r106.equals("warning") == false) goto L54;
        r108 = VibratorSmtFeedbackEffect.EFFECT_WARNING;
        goto L47
    L54:
        r108 = null;
        goto L47
    L23:
        if (r106.equals("wake_up") == false) goto L55;
        r108 = VibratorSmtFeedbackEffect.EFFECT_WAKE_UP;
        goto L47
    L55:
        r108 = null;
        goto L47
    L27:
        if (r106.equals("confirm") == false) goto L56;
        r108 = VibratorSmtFeedbackEffect.EFFECT_CONFIRM;
        goto L47
    L56:
        r108 = null;
        goto L47
    L31:
        if (r106.equals("rigid") == false) goto L57;
        r108 = VibratorSmtFeedbackEffect.EFFECT_RIGID;
        goto L47
    L57:
        r108 = null;
        goto L47
    L35:
        if (r106.equals("tick") == false) goto L58;
        r108 = VibratorSmtFeedbackEffect.EFFECT_TICK;
        goto L47
    L58:
        r108 = null;
        goto L47
    L39:
        if (r106.equals("soft") == false) goto L59;
        r108 = VibratorSmtFeedbackEffect.EFFECT_SOFT;
        goto L47
    L59:
        r108 = null;
        goto L47
    L43:
        if (r106.equals(com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK) == false) goto L60;
        r108 = VibratorSmtFeedbackEffect.EFFECT_LONG_PRESS;
        goto L47
    L60:
        r108 = null;
        goto L47
    L11:
        r107 = false;
        goto L13
    L5:
        r105 = null;
        goto L6
    }
}
