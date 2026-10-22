package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.setting;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeSettingViewModel;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ KtvChallengeSettingViewBinder.KtvChallengeSettingHolder a;
    public final /* synthetic */ com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a b;

    public a(KtvChallengeSettingViewBinder.KtvChallengeSettingHolder r1, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        KtvChallengeSettingViewBinder.KtvChallengeSettingHolder r8 = this.a;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a r0 = this.b;
        KtvChallengeSettingViewBinder r1 = r8.b;
        int r2 = KtvChallengeSettingViewBinder.c;
        MultiTypeAdapter r3 = ((me.drakeet.multitype.b) r1).a;
        int r4 = r8.getAdapterPosition();
        r8.getClass();
        ALogger.i("KtvChallenge", "handleClickEvent, position: " + r4);
        int r5 = r0.c;
        if (r5 != 1) goto L5;
        KtvChallengeSettingViewModel r9 = r8.b.b;
        if (r9 == null) goto L27;
        r9.updateChallengeConfigIndex(r4, 1);
        return;
    L27:
        return;
    L5:
        if (r5 == 2) goto L8;
        return;
    L8:
        if (r0.d == false) goto L17;
        int r6 = KtvChallengeCustomTargetDialog.n;
        int r10 = r0.a;
        KtvChallengeSettingViewModel r11 = r8.b.b;
        if (r11 == null) goto L12;
        Pair<Long, Long> r12 = r11.currentTargetRange();
    L13:
        KtvChallengeSettingViewBinder$KtvChallengeSettingHolder$handleClickEvent$1 r13 = new KtvChallengeSettingViewBinder$KtvChallengeSettingHolder$handleClickEvent$1(r8);
        Intrinsics.checkNotNullParameter(r13, "confirmCallback");
        KtvChallengeCustomTargetDialog r14 = new KtvChallengeCustomTargetDialog();
        r14.l = r10;
        if (r12 != null) goto L16;
        r12 = new Pair(1L, 100L);
    L16:
        r14.k = r12;
        r14.m = r13;
        r14.U90(ContextUtil.contextToFragmentActivity(((RecyclerView.ViewHolder) r8).itemView.getContext()));
        return;
    L12:
        r12 = null;
        goto L13
    L17:
        KtvChallengeSettingViewModel r15 = r8.b.b;
        if (r15 == null) goto L25;
        r15.updateChallengeConfigIndex(r4, 2);
        return;
    }
}
