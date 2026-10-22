package com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.adapter.KtvRoomSeatListAdapter;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomInteractViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvInteractElementWidget;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.MvStageWidget;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.VoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import fd2.k;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends KtvRoomViewManager {
    @Override // qe2.a
    public final void g(Bitmap r1) {
    }

    @Override // qe2.a
    public final void o(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm.KtvRoomViewManager
    public final void D() {
        View r0 = this.e.findViewById(2131377060);
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        this.K = (ViewGroup) r0;
        if (this.j != null) goto L8;
        this.j = new MvStageWidget(this.g1, this.P0);
    L8:
        k r1 = this.j;
        if (r1 == null) goto L23;
        View r2 = this.e.findViewById(2131377060);
        if ((r2 instanceof ViewGroup) == true) goto L13;
        r2 = null;
    L13:
        ViewGroup r3 = (ViewGroup) r2;
        this.K = r3;
        if (r3 == null) goto L17;
        UtilityKotlinExtentionsKt.w(r3);
    L17:
        if (this.k != null) goto L21;
        this.k = r1.getWidget();
        boolean r4 = !((Boolean) vm2.h.f1.getValue(null, vm2.h.a[108(0x6c, float:1.51E-43)])).booleanValue();
        WidgetManager r5 = z();
        if (r5 == null) goto L21;
        r5.load(2131377060, this.k, r4);
    L21:
        KtvRoomViewManager.L(this);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm.KtvRoomViewManager
    public final void E() {
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) this.g1.getKtvCoreViewModel().getValue();
        this.T = r0;
        if (r0 == null) goto L6;
        r0.registerKtvCoreListener(CollectionsKt.arrayListOf(new String[]{BaseCoreViewModel.CORE_TAG_STATE}), this.V, false);
        return;
    }

    public final boolean O() {
        if (this.j != null) goto L5;
    L13:
        return false;
    L5:
        if (this.k == null) goto L13;
        WidgetManager r0 = z();
        if (r0 == null) goto L13;
        List r1 = r0.widgets;
        if (r1 == null) goto L13;
        if (r1.contains(this.k) != true) goto L13;
        return true;
    }

    @Override // qe2.a
    public final void m() {
        K(s1.f(195.0f) + ((int) (s1.y() * 0.6933333f)));
    }

    public final void onBizLeaveRoom() {
        ALogger.i("logKtvMainPath", "onBizLeaveRoom, invoke class :".concat(a.class.getSimpleName()));
        KtvRoomSeatManager r0 = this.F;
        if (r0 == null) goto L6;
        r0.b(false);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm.KtvRoomViewManager
    public final void C() {
        if (O() == true) goto L6;
        super.C();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm.KtvRoomViewManager
    public final void onBizEnterRoom() {
        super.onBizEnterRoom();
        KtvRoomSeatManager r0 = this.F;
        if (r0 == null) goto L5;
        r0.b(true);
    L5:
        KtvRoomViewManager.L(this);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm.KtvRoomViewManager, qe2.a
    public final void h(boolean r3) {
        if (O() == true) goto L6;
        ALogger.i("logKtvMainPath", "loadKtvView, invoke class :".concat(a.class.getSimpleName()));
        super.h(r3);
        return;
    }

    @Override // qe2.a
    public final void n(IVoiceLiveTheme r4) {
        Intrinsics.checkNotNullParameter(r4, "theme");
        if (q() == false) goto L5;
        return;
    L5:
        this.O = r4;
        KtvRoomViewManager.L(this);
        com.bytedance.android.livesdk.ktvimpl.ktvroom.theme.c r1 = this.I;
        if (r1 == null) goto L8;
        r1.c(r4);
    L8:
        KtvRoomSeatManager r2 = this.F;
        if (r2 == null) goto L16;
        Intrinsics.checkNotNullParameter(r4, "theme");
        VoiceLiveTheme r5 = (VoiceLiveTheme) r4;
        r2.o = r5;
        if (r2.f == null) goto L14;
        int r3 = KtvRoomSeatListAdapter.f;
        Intrinsics.checkNotNullParameter(r5, "theme");
    L14:
        if (r2.e == null) goto L16;
        int r6 = KtvRoomSeatListAdapter.f;
        Intrinsics.checkNotNullParameter(r5, "theme");
    L16:
        KtvRoomViewManager.L(this);
    }

    @Override // qe2.a
    public final void k(String r5, Object r6) {
        Intrinsics.checkNotNullParameter(r5, "syncKey");
        k r1 = this.j;
        Widget r2 = null;
        if (r1 == null) goto L5;
        Widget r3 = r1.getWidget();
    L7:
        if ((r3 instanceof MvStageWidget) == false) goto L10;
        r2 = r3;
    L10:
        MvStageWidget r4 = (MvStageWidget) r2;
        if (r4 == null) goto L15;
        Intrinsics.checkNotNullParameter(r5, "syncKey");
        KtvRoomViewModel r7 = (KtvRoomViewModel) r4.d;
        if (r7 == null) goto L15;
        r7.consumeWrdsData(r5, r6);
    L15:
        KtvInteractElementWidget r8 = this.N;
        if (r8 == null) goto L21;
        Intrinsics.checkNotNullParameter(r5, "syncKey");
        KtvRoomInteractViewModel r0 = r8.d;
        if (r0 == null) goto L22;
        r0.consumeWrdsData(r5, r6);
        return;
    L22:
        return;
    L21:
        return;
    L5:
        r3 = null;
        goto L7
    }

    public a(Context r2, ViewGroup r3, sb0.b r4, Function0<? extends WidgetManager> r5, com.bytedance.android.live.pushstream.d r6, KtvContext r7, GLSurfaceView r8, qe2.c r9) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "ktvLayout");
        Intrinsics.checkNotNullParameter(r4, "dataEntity");
        Intrinsics.checkNotNullParameter(r5, "widgetProvider");
        Intrinsics.checkNotNullParameter(r7, "ktvContext");
        Intrinsics.checkNotNullParameter(r9, "mDataDispatcher");
        super(r2, r3, r4, r5, r6, r7, r8, r9);
    }
}
