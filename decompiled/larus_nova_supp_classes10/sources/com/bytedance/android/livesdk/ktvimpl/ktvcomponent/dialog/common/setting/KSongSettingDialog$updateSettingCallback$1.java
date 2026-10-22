package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting;

import android.content.Context;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.model.bean.ChallengeChangeType;
import com.bytedance.android.live.ktv.common.model.bean.SwitchStatus;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeDataContext;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", LocationMonitorConst.TYPE, "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/setting/SwitchItemType;", "checked", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final class KSongSettingDialog$updateSettingCallback$1 extends Lambda implements Function2<SwitchItemType, Boolean, Unit> {
    final /* synthetic */ KSongSettingDialog this$0;

    public KSongSettingDialog$updateSettingCallback$1(KSongSettingDialog r1) {
        this.this$0 = r1;
        super(2);
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_livesdk_ktvimpl_ktvcomponent_dialog_common_setting_KSongSettingDialog$updateSettingCallback$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(KSongSettingDialog r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_livesdk_ktvimpl_ktvcomponent_dialog_common_setting_KSongSettingDialog$updateSettingCallback$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(x0 r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public final void invoke(SwitchItemType r14, final boolean r15) {
        Intrinsics.checkNotNullParameter(r14, LocationMonitorConst.TYPE);
        SwitchItemType r0 = SwitchItemType.AUDIENCE_SING;
        if (r14 != r0) goto L21;
        final String r16 = KSongSettingDialog.access$obtainActionType(this.this$0, r15);
        if (r15 == false) goto L13;
        com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.c.p0;
        if (((Boolean) r1.getValue()).booleanValue() == true) goto L11;
        f.d(r1, Boolean.TRUE);
        x0 r17 = com.bytedance.android.livesdk.ktvimpl.multichorus.c.f(this.this$0.getContext(), s1.B(2131918284), s1.B(2131918283), new KSongSettingDialog$updateSettingCallback$1$$special$$inlined$run$lambda$1(r16, this, r15), new KSongSettingDialog$updateSettingCallback$1$$special$$inlined$run$lambda$2(this, r15));
        if (r17 == null) goto L48;
        INVOKEVIRTUAL_com_bytedance_android_livesdk_ktvimpl_ktvcomponent_dialog_common_setting_KSongSettingDialog$updateSettingCallback$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r17);
        return;
    L48:
        return;
    L11:
        KSongSettingDialog.access$getUpdateSettingByType$p(this.this$0).invoke(r0, Boolean.valueOf(r15), r16);
        return;
    L13:
        if (KSongSettingDialog.access$closeAudienceSingSwitchPreCheck(this.this$0) == true) goto L16;
        KSongSettingDialog.access$reversalSwitchCheckedState(this.this$0, r0);
        return;
    L16:
        if (KSongSettingDialog.access$hasApplyUser(this.this$0) == false) goto L20;
        x0 r18 = com.bytedance.android.livesdk.ktvimpl.multichorus.c.f(this.this$0.getContext(), s1.B(2131918278), s1.B(2131918277), new KSongSettingDialog$updateSettingCallback$1$$special$$inlined$run$lambda$3(r16, this, r15), new KSongSettingDialog$updateSettingCallback$1$$special$$inlined$run$lambda$4(this, r15));
        if (r18 == null) goto L52;
        INVOKEVIRTUAL_com_bytedance_android_livesdk_ktvimpl_ktvcomponent_dialog_common_setting_KSongSettingDialog$updateSettingCallback$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r18);
        return;
    L52:
        return;
    L20:
        KSongSettingDialog.access$getUpdateSettingByType$p(this.this$0).invoke(r0, Boolean.valueOf(r15), r16);
        return;
    L21:
        SwitchItemType r2 = SwitchItemType.MULTI_CHORUS;
        if (r14 != r2) goto L32;
        final String r19 = KSongSettingDialog.access$obtainActionType(this.this$0, r15);
        if (r15 == true) goto L26;
    L30:
        Unit r110 = (Unit) KSongSettingDialog.access$getUpdateSettingByType$p(this.this$0).invoke(r2, Boolean.valueOf(r15), r19);
        return;
    L26:
        if (ne2.a.a() == false) goto L30;
        x0 r111 = com.bytedance.android.livesdk.ktvimpl.multichorus.c.f(this.this$0.getContext(), s1.B(2131920870), s1.B(2131920869), new KSongSettingDialog$updateSettingCallback$1$$special$$inlined$run$lambda$5(r19, this, r15), new KSongSettingDialog$updateSettingCallback$1$$special$$inlined$run$lambda$6(this, r15));
        if (r111 == null) goto L55;
        INVOKEVIRTUAL_com_bytedance_android_livesdk_ktvimpl_ktvcomponent_dialog_common_setting_KSongSettingDialog$updateSettingCallback$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r111);
        return;
    L55:
        return;
    L32:
        if (r14 != SwitchItemType.KTV_CHALLENGE) goto L44;
        int r3 = ke2.b.a;
        ke2.b.b(KSongSettingDialog.access$obtainActionType(this.this$0, r15), r14);
        if (r15 == true) goto L39;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r112 = KtvChallengeDataContext.Companion.a();
        if (r112 == null) goto L60;
        me2.a r113 = r112.getChallengeConfig();
        KtvContext.Companion.getClass();
        KtvContext.a.g().getPrepareChallengeEvent().post(new me2.b(r113.c, r113.d, ChallengeChangeType.SWITCH_TURN_OFF, SwitchStatus.CLOSE.getValue(), "ksong_setting_page", "", r113.f, DeviceStatus$DiffDimension.DIFF_LOCATION_MODE));
    L43:
        INVOKEVIRTUAL_com_bytedance_android_livesdk_ktvimpl_ktvcomponent_dialog_common_setting_KSongSettingDialog$updateSettingCallback$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(this.this$0);
        return;
    L60:
        return;
    L39:
        Context r114 = this.this$0.getContext();
        if (r114 == null) goto L42;
        ne2.a.e(r114, "ksong_setting_page");
    L42:
        KSongSettingDialog r115 = this.this$0;
        KSongSettingDialog.access$dismissMainDialog(r115, r115.getContext());
        goto L43
    L44:
        SwitchItemType r4 = SwitchItemType.HIDE_LYRICS_FOR_SUBTITLE;
        if (r14 != r4) goto L59;
        String r116 = KSongSettingDialog.access$obtainActionType(this.this$0, r15);
        KSongSettingDialog.access$getUpdateSettingByType$p(this.this$0).invoke(r4, Boolean.valueOf(r15), r116);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((SwitchItemType) r1, ((Boolean) r2).booleanValue());
        return Unit.INSTANCE;
    }
}
