package com.bytedance.android.livesdk.ktvimpl.realtimechorus.dialog;

import am2.x;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.config.lf1;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.crash.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/dialog/RealTimeChrousCellularDialog;", "Lcom/bytedance/android/live/ktv/common/view/BaseKtvDialogFragment;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChrousCellularDialog extends BaseKtvDialogFragment {
    public Map<Integer, View> g;
    public final int h;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ RealTimeChrousCellularDialog a;

        public b(RealTimeChrousCellularDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ RealTimeChrousCellularDialog a;

        public c(RealTimeChrousCellularDialog r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        L20:
            return;
        L18:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5 Throwable -> L10
        L15:
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r0 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r0 == null) goto L15;
            d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L15
        }
    }

    static {
    }

    public final String S90() {
        return "RealTimeChrousCellularDialog";
    }

    public final int getLayoutId() {
        return 2131565713;
    }

    public RealTimeChrousCellularDialog() {
        this.g = new LinkedHashMap();
        this.h = ((lf1) KtvSettingHelper.F.getValue()).a() * 1000;
    }

    public final View X90(int r3) {
        if (this.g != null) goto L5;
        this.g = new LinkedHashMap();
    L5:
        View r0 = this.g.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.g.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*com.bytedance.android.livesdk.LiveDialogFragment*/.onViewCreated(r4, r5);
        ((TextView) X90(2131389498)).setOnClickListener(x0.a(new AnonymousClass1(this)));
        X90(2131367001).setOnClickListener(new b(this));
        View r6 = X90(2131389498);
        if (r6 == null) goto L5;
        r6.postDelayed(new c(this), this.h);
    L5:
        Long r7 = KtvLoggerHelper.a;
        HashMap r8 = new HashMap();
        r8.put("live_type", j.d());
        r8.put("function_type2", k.n(IInteractService.class).getFunctionType2());
        j0.l().sendLog("livesdk_chorus_weak_network_notification_show", r8, new Object[]{IRoom.class, x.class});
    }
}
