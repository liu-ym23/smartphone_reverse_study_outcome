package com.bytedance.android.livesdk.ktvimpl.mv.opus;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdk.ktvimpl.mv.KtvMvPlayer;
import com.bytedance.android.livesdk.message.model.od;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import fd2.f0;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ OpusPreviewDialog a;

    public a(OpusPreviewDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        OpusPreviewDialog r12 = this.a;
        if (r12.z == false) goto L5;
        return;
    L5:
        Pair<Integer, od> r13 = r12.p;
        if (r13 == null) goto L34;
        od r14 = (od) r13.getSecond();
        if (r14 == null) goto L35;
        final OpusPreviewDialog r0 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r14, LocationMonitorConst.INFO);
        Context r1 = r0.getContext();
        if (r1 == null) goto L37;
        String r2 = r14.d();
        if (r2 == null) goto L38;
        f0 r3 = new f0(r14.c(), r2);
        Intrinsics.checkNotNullParameter(r3, "i");
        KtvMvPlayer r4 = r0.g;
        Intrinsics.checkNotNullParameter(r4, "playerClient");
        Function0<Unit> r8 = new OpusPreviewDialog$onPreview$1(r0);
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r8, "selectedListener");
        String r5 = r3.a;
        String r6 = r3.b;
        FragmentManager r9 = null;
        if (r4 != null) goto L18;
        r4 = new KtvMvPlayer(r1, null);
        r4.o().setIsMute(true);
        Unit r7 = Unit.INSTANCE;
    L18:
        MVPreViewDialog r10 = new MVPreViewDialog(r5, r6, null, r4, r8);
        r10.h = null;
        r10.f = null;
        FragmentActivity r15 = ContextUtil.contextToFragmentActivity(r1);
        if (r15 == null) goto L21;
        r9 = r15.getSupportFragmentManager();
    L21:
        if (r9 == null) goto L27;
        LandscapeRestrictionOperation r16 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r10, "", r16);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r9, r10, r16) == true) goto L27;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L31
    L26:
        r10.show(r9, "");
    L27:
        Function2<? super String, ? super Boolean, Unit> r17 = r0.j;
        if (r17 == null) goto L36;
        Unit r18 = (Unit) r17.invoke(r14.f(), Boolean.valueOf(r14.g()));
        return;
    L36:
        return;
    L38:
        return;
    L37:
        return;
    L35:
        return;
    }
}
