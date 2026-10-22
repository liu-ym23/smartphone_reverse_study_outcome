package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.model.bean.ChallengeChangeType;
import com.bytedance.android.live.ktv.common.model.bean.SwitchStatus;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.model.CloseOrderSongDialogSource;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.model.MusicOperateType;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KSongChallengeItemView;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/MusicOperateView;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/b;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KSongChallengeItemView extends MusicOperateView implements com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b {
    public final CompositeDisposable f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ KSongChallengeItemView a;

        public a(KSongChallengeItemView r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            this.a.k();
        }
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b
    public final void a(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r1) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b
    public final void b(int r1) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.MusicOperateView
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b
    public final void i(long r1) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b
    public final void j(int r1, int r2) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.MusicOperateView, com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b
    public final void onRelease() {
        this.f.clear();
        if (vm2.h.q() == false) goto L8;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r0 = KtvChallengeDataContext.Companion.a();
        if (r0 == null) goto L9;
        r0.removeKtvChallengeStatusChangedListener(this);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b
    public final void e(MusicOperateType r17) {
        Intrinsics.checkNotNullParameter(r17, "musicOperateType");
        KtvChallengeDataContext.a r0 = KtvChallengeDataContext.Companion;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r1 = r0.a();
        if (r1 != null) goto L5;
    L7:
        Context r2 = getContext();
        int r3 = ne2.a.a;
        ne2.a.e(r2, getRequestPage());
        KSongOrderSongUtilKt.i(r2, CloseOrderSongDialogSource.OPEN_KTV_CHALLENGE_SETTING_DIALOG);
    L8:
        KtvChallengeDataContext r4 = r0.getContext();
        if (r4 == null) goto L14;
        com.bytedance.live.datacontext.m<Object> r5 = r4.getChallengeYellowStatus();
        if (r5 == null) goto L15;
        r5.setValue(new Object());
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (r1.isKtvChallengeOpen() != true) goto L7;
        me2.a r6 = r1.getChallengeConfig();
        KtvContext.Companion.getClass();
        KtvContext.a.g().getPrepareChallengeEvent().post(new me2.b(r6.c, r6.d, ChallengeChangeType.SWITCH_TURN_OFF, SwitchStatus.CLOSE.getValue(), getRequestPage(), "", r6.f, DeviceStatus$DiffDimension.DIFF_LOCATION_MODE));
        goto L8
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.MusicOperateView, com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b
    public final void g(int r2) {
        if (ne2.a.c() == false) goto L5;
        super.g(r2);
        return;
    L5:
        setVisibility(8);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.MusicOperateView
    public final void h(MusicOperateType r7) {
        Intrinsics.checkNotNullParameter(r7, "musicOperateType");
        Intrinsics.checkNotNullParameter(r7, "musicOperateType");
        UtilityKotlinExtentionsKt.f(this);
        Long r8 = KtvLoggerHelper.a;
        KtvLoggerHelper.b0(getRequestPage());
        KtvChallengeDataContext.a r9 = KtvChallengeDataContext.Companion;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r0 = r9.a();
        if (r0 == null) goto L5;
        r0.addKtvChallengeStatusChangedListener(this);
    L5:
        boolean r1 = false;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.x.getValue()).booleanValue() == false) goto L13;
        LinearLayout r2 = this.c;
        if (r2 == null) goto L10;
        r2.setPadding(s1.f(3.0f), s1.f(3.0f), s1.f(3.0f), s1.f(3.0f));
    L10:
        View r3 = this.e;
        if (r3 == null) goto L14;
        r3.setVisibility(0);
    L14:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r4 = r9.a();
        if (r4 != null) goto L17;
    L19:
        l(r1);
        KtvChallengeDataContext r10 = r9.getContext();
        if (r10 == null) goto L29;
        com.bytedance.live.datacontext.m<Object> r11 = r10.getChallengeYellowStatus();
        if (r11 == null) goto L30;
        Observable r12 = r11.a();
        if (r12 == null) goto L31;
        Disposable r13 = r12.subscribe(new a(this));
        if (r13 == null) goto L32;
        RxUtilKt.c(r13, this.f);
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L17:
        if (r4.isKtvChallengeOpen() != true) goto L19;
        r1 = true;
        goto L19
    L13:
        k();
        goto L14
    }

    public final void l(boolean r2) {
        if (r2 == false) goto L4;
        int r3 = 2131252023;
    L5:
        HSImageView r0 = getMusicOperateIv();
        if (r0 == null) goto L8;
        r0.setBackgroundResource(r3);
    L8:
        HSImageView r4 = getMusicOperateIv();
        if (r4 == null) goto L12;
        r4.setContentDescription(s1.B(2131918476));
        return;
    L12:
        return;
    L4:
        r3 = 2131252019;
        goto L5
    }

    public KSongChallengeItemView(MusicOperateType r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "musicOperateType");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3);
        this.f = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b
    public final void f(boolean r1, int r2) {
        l(r1);
    }
}
