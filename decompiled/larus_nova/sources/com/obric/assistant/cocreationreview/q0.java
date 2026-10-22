package com.obric.assistant.cocreationreview;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f387660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f387661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f387662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PopupWindow f387663d;

    public final void b() {
        PopupWindow r100 = this.f387663d;
        if (r100 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
    L5:
        this.f387663d = null;
    }

    public final RippleDrawable a(int r100) {
        Context r101 = this.f387660a;
        StateListDrawable r102 = new StateListDrawable();
        r102.addState(new int[]{R.attr.state_selected}, c4.h(r101, 268435456, r100, 0, 0));
        r102.addState(new int[]{R.attr.state_focused}, c4.h(r101, 234881024, r100, 0, 0));
        r102.addState(new int[0], c4.h(r101, 0, r100, 0, 0));
        return new RippleDrawable(ColorStateList.valueOf(MediaPlayer.MEDIA_INFO_SOCKET_CONNECTRED), r102, c4.h(r101, -1, r100, 0, 0));
    }

    public q0(CocreationReviewActivity r100, String r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "shortcutLabel");
        Intrinsics.checkNotNullParameter(r102, "onAddShortcut");
        this.f387660a = r100;
        this.f387661b = r101;
        this.f387662c = r102;
    }
}
