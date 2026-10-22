package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.widget.x0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ KtvComponentAnchorLogicWidget a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ long c;
    public final /* synthetic */ String d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ String f;
    public final /* synthetic */ MusicPanel g;
    public final /* synthetic */ Boolean h;
    public final /* synthetic */ long i;

    public h(KtvComponentAnchorLogicWidget r1, Ref.ObjectRef r2, long r3, String r5, boolean r6, String r7, MusicPanel r8, Boolean r9, long r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }

    public final void accept(Object r18) {
        final com.bytedance.android.live.network.response.e r2 = (com.bytedance.android.live.network.response.e) r18;
        if (com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.c == true) goto L24;
        x0 r3 = (x0) this.b.element;
        if (r3 == null) goto L24;
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L21:
        DialogLancet.afterDialogDismiss(r3);
        goto L24
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r1 == null) goto L21;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        goto L21
    L9:
        if (Looper.myLooper() == r0.getLooper()) goto L11;
        r0.post(DialogLancet.createDismissRunnable(r3));
    L24:
        this.a.i = true;
        mb0.c.a.b(pd2.d.n, LinkMonitorData.ApiOpenKtvComponent, System.currentTimeMillis() - this.c, ((ExtraResponse) r2).logId);
        int r4 = mb0.f.a;
        String r5 = ((ExtraResponse) r2).logId;
        Boolean r6 = ((com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.j) ((ExtraResponse) r2).data).a();
        if (r6 == null) goto L27;
        boolean r7 = r6.booleanValue();
    L28:
        String r8 = this.d;
        boolean r9 = this.e;
        Boolean r10 = ((com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.j) ((ExtraResponse) r2).data).c();
        Boolean r11 = ((com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.j) ((ExtraResponse) r2).data).b();
        Intrinsics.checkNotNullParameter(r5, "logId");
        JSONObject r15 = new JSONObject();
        r15.put("audienceSingEnable", r7);
        r15.put("logId", r5);
        r15.put("showMainDialog", r9);
        if (r8 == null) goto L31;
        r15.put("source", r8);
    L31:
        if (r10 == null) goto L33;
        r15.put("chorusEnable", r10.booleanValue());
    L33:
        if (r11 == null) goto L35;
        r15.put("challengeEnable", r11.booleanValue());
    L35:
        int r12 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.KtvFeatureSwitch, "ktvComponentOpen", 0, null, r15, 88);
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r13 = KtvComponentContext.Companion.a();
        if (r13 == null) goto L38;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r13, new KtvComponentAnchorLogicWidget$openKtvComponent$1$1(r2));
    L38:
        this.a.Cq(this.d, ((com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.j) ((ExtraResponse) r2).data).a(), this.e, this.f, this.g, this.h);
        this.a.n = false;
        ALogger.w("KtvComponent_MergeMode", "openKtvComponent success， success=" + this.d + ", audienceSingEnable=" + this.i + ", showMainDialog=" + this.e + ", mainDialogEnterFrom=" + this.f + ", logId=" + ((ExtraResponse) r2).logId);
        return;
    L27:
        r7 = false;
        goto L28
    }
}
