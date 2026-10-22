package com.obric.assistant.obric_action.handler.chat_page;

import android.content.Context;
import cfa.f;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.obric.assistant.special_input.ISpecialInputTask;
import com.obric.assistant.special_input.ObricComplexTaskPanelType;
import com.obric.assistant.special_input.c;
import com.obric.assistant.special_input.util.j;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/chat_page/OpenNewTaskPanelHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/chat_page/OpenNewTaskPanelActionParams;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/chat_page/OpenNewTaskPanelActionParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenNewTaskPanelHandler implements IObricActionHandler<f, Unit> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<f> f390473b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r100 = d.C4614d.f390416a;
        return d.C4614d.f390419d;
    }

    public OpenNewTaskPanelHandler() {
        this.f390473b = f.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<f> b() {
        return this.f390473b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final f a(Context r100, String r101) {
        return (f) IObricActionHandler.b.a(this, r100, r101);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r110, f r111, Continuation<? super h<? extends Unit>> r112) {
        f r113 = r111;
        if (r113 != null) goto L5;
        r113 = new f(0);
    L5:
        FLogger.f375446a.i("OpenNewTaskPanelHandler", "handle: params = " + r113);
        String r114 = r113.c();
        if (r114 != null) goto L8;
    L15:
        r114 = "bot_chat_card";
    L16:
        ISpecialInputTask r100 = c.a();
        if (r100 == null) goto L41;
        int r101 = ObricComplexTaskPanelType.IDLE.getValue();
        boolean r102 = f.f(r113);
        String r103 = r113.a();
        if (r103 != null) goto L21;
    L26:
        String r104 = null;
    L27:
        StateInfo r105 = j.c(r101, r102, r104, null, MapsKt.mapOf(TuplesKt.to("source_from", r114)), 24);
        Boolean r115 = r113.b();
        if (r115 == null) goto L30;
        boolean r106 = r115.booleanValue();
    L31:
        Boolean r116 = r113.d();
        if (r116 == null) goto L34;
        boolean r107 = r116.booleanValue();
    L35:
        Boolean r117 = r113.e();
        if (r117 == null) goto L38;
        boolean r108 = r117.booleanValue();
    L39:
        ISpecialInputTask.a.a(r100, r105, r106, r107, r108, null, 16);
        goto L41
    L38:
        r108 = false;
        goto L39
    L34:
        r107 = true;
        goto L35
    L30:
        r106 = true;
        goto L31
    L21:
        if (r103.length() <= 0) goto L23;
        boolean r109 = true;
    L24:
        if (r109 == false) goto L26;
        r104 = r103;
        goto L27
    L23:
        r109 = false;
    L41:
        return h.a.c(h.f390443d, null, null, 3);
    L8:
        if (r114.length() <= 0) goto L10;
        boolean r118 = true;
    L11:
        if (r118 == true) goto L14;
        r114 = null;
    L14:
        if (r114 != null) goto L16;
    L10:
        r118 = false;
        goto L11
    }
}
