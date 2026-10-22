package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ KtvComponentAnchorLogicWidget a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ String g;

    public i(KtvComponentAnchorLogicWidget r1, Ref.ObjectRef r2, long r3, long r5, String r7, boolean r8, String r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }

    public final void accept(Object r14) {
        Throwable r15 = (Throwable) r14;
        KtvComponentAnchorLogicWidget r0 = this.a;
        r0.i = false;
        KtvComponentContext r1 = r0.f;
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.n<Integer> r2 = r1.getKtvComponentStatus();
        if (r2 == null) goto L7;
        r2.setValue(0);
    L7:
        KtvContext.Companion.getClass();
        KtvContext r3 = KtvContext.a.g();
        if (r3 == null) goto L13;
        com.bytedance.live.datacontext.m<Integer> r4 = r3.getKtvComponentStatus();
        if (r4 == null) goto L13;
        r4.setValue(0);
    L13:
        if (com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.c == true) goto L33;
        x0 r5 = (x0) this.b.element;
        if (r5 == null) goto L33;
        Handler r6 = DialogLancet.resolveDialogHandler(r5);
        if (r6 != null) goto L19;
    L21:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L24 Exception -> L26
    L30:
        DialogLancet.afterDialogDismiss(r5);
        goto L33
    L26:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L24
        Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L24
        if (r7 == null) goto L30;
        com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L19:
        if (Looper.myLooper() == r6.getLooper()) goto L21;
        r6.post(DialogLancet.createDismissRunnable(r5));
    L33:
        mb0.c.a.a(pd2.d.n, LinkMonitorData.ApiOpenKtvComponent, System.currentTimeMillis() - this.c, r15);
        int r8 = mb0.f.a;
        long r9 = this.d;
        String r10 = this.e;
        boolean r11 = this.f;
        Intrinsics.checkNotNullParameter(r15, "throwable");
        JSONObject r12 = new JSONObject();
        r12.put("audienceSingEnable", r9);
        r12.put("showMainDialog", r11);
        if (r10 == null) goto L36;
        r12.put("source", r10);
    L36:
        nd0.c.a.getClass();
        Pair r13 = nd0.c.t(r15, r12);
        int r16 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.KtvFeatureSwitch, "ktvComponentOpen", ((Number) r13.getFirst()).intValue(), (String) r13.getSecond(), r12, 64);
        ExceptionUtils.handleException(((Widget) this.a).context, r15);
        this.a.n = false;
        ALogger.w("KtvComponent_MergeMode", "openKtvComponent failure， source=" + this.e + ", audienceSingEnable=" + this.d + ", showMainDialog=" + this.f + ", mainDialogEnterFrom=" + this.g + ", logId=" + ke2.a.c(r15));
    }
}
