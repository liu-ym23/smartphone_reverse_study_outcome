package com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.ktv.common.tuningpanel.view.TuningPanelDialog;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.ConcertTuningVolumeOuterCallback;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.KSongTuningPanelOuterCallback;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.manager.KtvModeTuningDataContext;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ConcertTuner implements ld2.a {
    public Disposable a;
    public final Context b;
    public final ld2.b c;

    public final void c() {
        KtvModeTuningDataContext.Companion.getClass();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = KtvModeTuningDataContext.b.a();
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    public final void destroy() {
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        r0.dispose();
        return;
    }

    public final void a(com.bytedance.android.live.pushstream.d r6) {
        Pair r0 = com.bytedance.live.datacontext.d.a(ConcertTuner$initTuningContext$1.INSTANCE);
        KtvModeTuningDataContext r1 = (KtvModeTuningDataContext) r0.component1();
        Disposable r2 = (Disposable) r0.component2();
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.b r3 = new com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.b(r6, null, new WeakReference(this.b));
        r3.j0();
        r1.setMTuningCore(r3);
        com.bytedance.live.datacontext.b.a(r1, KtvModeTuningDataContext.class);
        this.a = r2;
    }

    public ConcertTuner(Context r2, ld2.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.b = r2;
        this.c = r3;
    }

    public final void b(String r19, int r20, boolean r21) {
        Intrinsics.checkNotNullParameter(r19, "source");
        FragmentActivity r0 = ContextUtil.contextToFragmentActivity(this.b);
        if (r0 == null) goto L32;
        FragmentManager r4 = r0.getSupportFragmentManager();
        if (r4 == null) goto L34;
        Fragment r1 = r4.findFragmentByTag("TuningPanelDialog");
        if ((r1 instanceof DialogFragment) == true) goto L10;
        r1 = null;
    L10:
        DialogFragment r2 = (DialogFragment) r1;
        if (r2 == null) goto L19;
        r2.dismissAllowingStateLoss();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L19;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L19:
        if (r4.findFragmentByTag("TuningPanelDialog") != null) goto L33;
        int r5 = TuningPanelDialog.m;
        KtvModeTuningDataContext.Companion.getClass();
        final com.bytedance.android.live.ktv.common.tuningpanel.ability.a r14 = KtvModeTuningDataContext.b.a();
        KSongTuningPanelOuterCallback r8 = new KSongTuningPanelOuterCallback();
        ConcertTuningVolumeOuterCallback r10 = new ConcertTuningVolumeOuterCallback(r14, this.c, r21, r20);
        ac0.b r6 = new ac0.b(false, r8, new com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.a(), r10, null, new ConcertTuner$buildTuningPanelConfig$1(r14), null, r14, null, false, 13706);
        Intrinsics.checkNotNullParameter(r6, "config");
        TuningPanelDialog r7 = new TuningPanelDialog(r6);
        LandscapeRestrictionOperation r9 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r7, "TuningPanelDialog", r9);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r7, r9) == false) goto L30;
    L25:
        pd2.d.n.getClass();
        Intrinsics.checkNotNullParameter(r19, "source");
        JSONObject r11 = new JSONObject().put("source", r19);
        pd2.d.w(LinkMonitorData.BusinessAdjustTonePanelShow, r11);
        return;
    L30:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
    L24:
        r7.show(r4, "TuningPanelDialog");
        goto L25
    L33:
        return;
    L34:
        return;
    }
}
