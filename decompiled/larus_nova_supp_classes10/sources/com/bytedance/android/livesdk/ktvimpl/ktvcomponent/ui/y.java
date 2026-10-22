package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.model.CloseOrderSongDialogSource;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y<T> implements Consumer {
    public final /* synthetic */ KtvComponentUIWidget a;

    public y(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.a r5 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.a) sh6.c.b((sh6.b) r4);
        if (r5 == null) goto L5;
        boolean r6 = r5.a;
    L6:
        KtvComponentUIWidget r0 = this.a;
        TokenCert r1 = KtvComponentUIWidget.y1;
        FragmentActivity r2 = ContextUtil.contextToFragmentActivity(((Widget) r0).context);
        if (r6 == false) goto L18;
        CloseOrderSongDialogSource r7 = CloseOrderSongDialogSource.OPEN_TUNING_DIALOG;
        Intrinsics.checkNotNullParameter(r7, "source");
        if (c.a[r7.ordinal()] == 1) goto L11;
        KSongOrderSongUtilKt.b(((Widget) r0).context, r7);
    L12:
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().getKtvCoreController().getValue() != null) goto L17;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r8 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) KtvContext.a.g().getKtvSingerViewModel().getValue();
        if (r8 == null) goto L17;
        r8.lazyInitKtvCoreController();
    L17:
        KSongTuningPanelHelperKt.a(((Widget) r0).context, "ktv_component");
        return;
    L11:
        KSongOrderSongUtilKt.i(((Widget) r0).context, r7);
        goto L12
    L18:
        Fragment r9 = null;
        if (r2 == null) goto L23;
        FragmentManager r3 = r2.getSupportFragmentManager();
        if (r3 == null) goto L23;
        Fragment r10 = r3.findFragmentByTag("TuningPanelDialog");
    L25:
        if ((r10 instanceof DialogFragment) == false) goto L28;
        r9 = r10;
    L28:
        DialogFragment r11 = (DialogFragment) r9;
        if (r11 == null) goto L40;
        r11.dismiss();     // Catch: Exception -> L32
        return;
    L32:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r12 = DialogFragmentLancet.sLastShowStack;
        if (r12 == null) goto L41;
        com.bytedance.crash.d.d(r12, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L41:
        return;
    L40:
        return;
    L23:
        r10 = null;
        goto L25
    L5:
        r6 = false;
        goto L6
    }
}
