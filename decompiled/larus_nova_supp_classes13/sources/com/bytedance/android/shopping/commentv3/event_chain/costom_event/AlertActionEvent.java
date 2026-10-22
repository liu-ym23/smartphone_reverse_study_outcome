package com.bytedance.android.shopping.commentv3.event_chain.costom_event;

import android.content.Context;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.shopping.commentv3.action.ActionType;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EventName;
import com.bytedance.android.shopping.commentv3.view.CommonAlertDialog;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AlertActionEvent extends com.bytedance.android.shopping.commentv3.event_chain.a {
    public final Context d;

    public AlertActionEvent(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(ActionType.ALERT.getType());
        this.d = r2;
    }

    @Override // com.bytedance.android.shopping.commentv3.event_chain.a
    public final void c(EventContext r17, fc3.a r18, fc3.c r19, final Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r20) {
        Intrinsics.checkNotNullParameter(r17, "eventContext");
        Intrinsics.checkNotNullParameter(r18, "actionContext");
        Intrinsics.checkNotNullParameter(r19, "handleActionParams");
        Intrinsics.checkNotNullParameter(r20, "completion");
        Map r0 = r17.k;
        if (r0 != null) goto L5;
    L63:
        int r1 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r20.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "AlertActionEvent fields is empty", null, null, 57));
        return;
    L5:
        if ((!r0.isEmpty()) == false) goto L7;
        Map r5 = r0;
    L8:
        if (r5 == null) goto L63;
        List r2 = r19.a.getActions();
        if (r2 == null) goto L61;
        Iterator r3 = r2.iterator();
    L14:
        if (r3.hasNext() == false) goto L18;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(((IAction) r4).getType(), ((t96.a) this).a) == false) goto L14;
    L19:
        SlcCommonAction r6 = (IAction) r4;
        if (r6 == null) goto L61;
        Intrinsics.checkNotNullParameter(r6, "$this$getNext");
        if ((r6 instanceof SlcCommonAction) == true) goto L25;
        Map r7 = null;
    L29:
        if (r7 != null) goto L31;
    L51:
        Map r8 = null;
    L52:
        if (r8 != null) goto L55;
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r20.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "AlertActionEvent nextActions is empty", null, null, 57));
        return;
    L55:
        Context r10 = this.d;
        fc3.a.C0195a r11 = r18.b;
        AppCompatDialog r12 = new CommonAlertDialog(r10, r18, r5, r8, r11.e, r11.f, AlertActionEvent$onHandle$1.INSTANCE, new AlertActionEvent$onHandle$2(r20));
        if (DialogLancet.shouldBlockDialogShow(r12) == false) goto L66;
        DialogLancet.handleBlockedDialogShow(r12);
        return;
    L66:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L65
    L59:
        DialogLancet.beforeDialogShow(r12);
        r12.show();
        DialogLancet.afterDialogShow(r12);
        return;
    L31:
        if ((!r7.isEmpty()) == true) goto L34;
        r7 = null;
    L34:
        if (r7 == null) goto L51;
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator r14 = r7.entrySet().iterator();
    L38:
        if (r14.hasNext() == false) goto L50;
        Map.Entry r15 = (Map.Entry) r14.next();
        Object r16 = r15.getKey();
        if ((r16 instanceof String) == false) goto L38;
        Object r21 = r15.getValue();
        if ((r21 instanceof Map) == false) goto L38;
        if (((Map) r21).isEmpty() == true) goto L38;
        r13.put(r16, u0.b(u0.d(r21), SlcCommonAction.class));     // Catch: JSONException -> L48
    L48:
        e = move-exception;
        ECExceptionMonitor.e(e);
        dm.a.a("CommentAbsCommonChainEventImpl").b("getNextActions", e);
        int r22 = ic3.e.a;
        ic3.e.a.a(this.c, EventName.ERROR.getEvent(), "", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("message", "class: CommentAbsCommonChainEventImpl, method: parseNext, exception: " + e.getMessage())}), null, null, 240);
        goto L38
    L50:
        r8 = MapsKt.toMap(r13);
        goto L52
    L25:
        Object r23 = r6.getData().get("next");
        if ((r23 instanceof Map) == true) goto L28;
        r23 = null;
    L28:
        r7 = (Map) r23;
        goto L29
    L18:
        r4 = null;
    L61:
        int r24 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r20.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "AlertActionEvent alertAction is empty", null, null, 57));
        return;
    L7:
        r5 = null;
        goto L8
    }
}
