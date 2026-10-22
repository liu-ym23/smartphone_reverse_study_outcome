package zd2;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.interact.model.y;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e;
import com.bytedance.android.livesdk.ktvapi.HolderRoomWidget;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.view.KtvGroupCreateDialogFragment;
import com.bytedance.android.livesdk.ktvimpl.base.view.KtvGroupJoinDialogFragment;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvGroupViewModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import pp1.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements c0.b {
    public DataCenter a;
    public final HolderRoomWidget b;
    public final ToolbarButton c;

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final /* synthetic */ void R9(View r1, DataCenter r2) {
    }

    public final /* synthetic */ void SY(s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final ToolbarButton getType() {
        return this.c;
    }

    public final void dv(e r3) {
        Intrinsics.checkNotNullParameter(r3, "command");
        ToolbarButton r0 = this.c;
        if (a.b[r0.ordinal()] != 1) goto L13;
        boolean r1 = j.i();
        if ((r3 instanceof m) == false) goto L11;
        if (r1 != true) goto L9;
        Long r4 = KtvLoggerHelper.a;
        KtvLoggerHelper.X("livesdk_ktv_friends_group_interact_panel_icon_show", null);
        return;
    L9:
        Long r5 = KtvLoggerHelper.a;
        KtvLoggerHelper.X("livesdk_ktv_friends_group_more_function_icon_show", MapsKt.mapOf(TuplesKt.to("user_type", KtvLoggerHelper.I())));
        return;
    L11:
        return;
    }

    public final void onClick(View r8) {
        Intrinsics.checkNotNullParameter(r8, "v");
        boolean r0 = true;
        if (a.a[this.c.ordinal()] == 1) goto L6;
        return;
    L6:
        if (this.b != null) goto L8;
        return;
    L8:
        DataCenter r9 = this.a;
        KtvGroupViewModel r2 = null;
        if (r9 == null) goto L11;
        Boolean r10 = Boolean.valueOf(a0.d(r9, false));
    L13:
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == false) goto L49;
        Lazy r11 = KtvUtilsKt.a;
        List r12 = (List) IInteractService.linkMicSettings.getValue();
        if (r12 == null) goto L31;
        Iterator r13 = r12.iterator();
    L18:
        if (r13.hasNext() == false) goto L25;
        Object r4 = r13.next();
        if (((y) r4).getKey() != 56) goto L22;
        boolean r5 = true;
    L23:
        if (r5 == false) goto L18;
    L26:
        y r6 = (y) r4;
        if (r6 == null) goto L31;
        if (r6.getValue() != 1) goto L31;
    L32:
        if (r0 == false) goto L40;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r14 = KtvRoomContext.a.a();
        if (r14 == null) goto L38;
        com.bytedance.live.datacontext.j<KtvGroupViewModel> r15 = r14.getKtvGroupViewModel();
        if (r15 == null) goto L38;
        r2 = (KtvGroupViewModel) r15.getValue();
    L38:
        if (r2 == null) goto L70;
        r2.startGroupManagerFragment(((Widget) this.b).context, "interact_function");
        return;
    L70:
        return;
    L40:
        FragmentActivity r16 = ((Widget) this.b).context;
        KtvGroupCreateDialogFragment r1 = new KtvGroupCreateDialogFragment();
        if (r16 == null) goto L48;
        FragmentManager r17 = r16.getSupportFragmentManager();
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "KtvGroupCreateDialogFragment", r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r17, r1, r3) == true) goto L74;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L59
    L46:
        r1.show(r17, "KtvGroupCreateDialogFragment");
        return;
    L74:
        return;
    L48:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L22:
        r5 = false;
        goto L23
    L25:
        r4 = null;
    L31:
        r0 = false;
        goto L32
    L49:
        FragmentActivity r18 = ((Widget) this.b).context;
        KtvGroupJoinDialogFragment.l = 23;
        KtvGroupJoinDialogFragment.m = 1;
        KtvGroupJoinDialogFragment r7 = new KtvGroupJoinDialogFragment();
        if (r18 == null) goto L58;
        FragmentManager r19 = r18.getSupportFragmentManager();
        LandscapeRestrictionOperation r20 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r7, "KtvGroupJoinDialogFragment", r20);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r19, r7, r20) == true) goto L75;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L60
    L55:
        r7.show(r19, "KtvGroupJoinDialogFragment");
        return;
    L75:
        return;
    L58:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L11:
        r10 = null;
        goto L13
    }

    public b(HolderRoomWidget r3, ToolbarButton r4) {
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TYPE);
        Intrinsics.checkNotNullParameter("more", "enterFrom");
        Intrinsics.checkNotNullParameter("", "function");
        this.b = r3;
        this.c = r4;
    }

    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r3;
    }
}
