package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.setting;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeSettingViewModel;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvChallengeSettingViewBinder extends me.drakeet.multitype.b<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a, KtvChallengeSettingHolder> {
    public static final /* synthetic */ int c = 0;
    public final KtvChallengeSettingViewModel b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/setting/KtvChallengeSettingViewBinder$KtvChallengeSettingHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class KtvChallengeSettingHolder extends RecyclerView.ViewHolder {
        public final Lazy a;
        public final /* synthetic */ KtvChallengeSettingViewBinder b;

        public KtvChallengeSettingHolder(KtvChallengeSettingViewBinder r2, final View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.b = r2;
            super(r3);
            this.a = LazyKt.lazy(new KtvChallengeSettingViewBinder$KtvChallengeSettingHolder$content$2(r3));
        }
    }

    public static final class a {
    }

    static {
    }

    public KtvChallengeSettingViewBinder(KtvChallengeSettingViewModel r1) {
        this.b = r1;
    }

    public final void b(RecyclerView.ViewHolder r6, Object r7) {
        KtvChallengeSettingHolder r8 = (KtvChallengeSettingHolder) r6;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a r9 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a) r7;
        Intrinsics.checkNotNullParameter(r8, "viewHolder");
        Intrinsics.checkNotNullParameter(r9, "data");
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "data");
        int r0 = r8.getAdapterPosition();
        int r1 = r9.c;
        boolean r4 = true;
        if (r1 != 1) goto L11;
        KtvChallengeSettingViewModel r2 = r8.b.b;
        if (r2 == null) goto L19;
        Pair<Integer, Integer> r3 = r2.getCurrentChallengeConfigIndex();
        if (r3 == null) goto L19;
        if (r0 != ((Number) r3.getFirst()).intValue()) goto L19;
    L20:
        if (r4 == false) goto L22;
        int r5 = 2131249296;
    L23:
        ((RecyclerView.ViewHolder) r8).itemView.setBackgroundResource(r5);
        ((RecyclerView.ViewHolder) r8).itemView.post(new b(r8, r9));
        ((TextView) r8.a.getValue()).setText(r9.b);
        if (r4 == false) goto L26;
        String r10 = "#FE2C55";
    L27:
        ((TextView) r8.a.getValue()).setTextColor(ColorProtector.parseColor(r10));
        if (r9.c != 2) goto L33;
        if (r4 == false) goto L33;
        if (r9.d == false) goto L33;
        Drawable r11 = s1.m(2131252022);
        r11.setBounds(0, 0, UtilityKotlinExtentionsKt.i(12), UtilityKotlinExtentionsKt.i(12));
        ((TextView) r8.a.getValue()).setCompoundDrawables(null, null, r11, null);
    L34:
        ((RecyclerView.ViewHolder) r8).itemView.setOnClickListener(new com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.setting.a(r8, r9));
        return;
    L33:
        ((TextView) r8.a.getValue()).setCompoundDrawables(null, null, null, null);
        goto L34
    L26:
        r10 = "#161823";
        goto L27
    L22:
        r5 = 2131249297;
    L19:
        r4 = false;
        goto L20
    L11:
        if (r1 != 2) goto L19;
        KtvChallengeSettingViewModel r12 = r8.b.b;
        if (r12 == null) goto L19;
        Pair<Integer, Integer> r13 = r12.getCurrentChallengeConfigIndex();
        if (r13 == null) goto L19;
        if (r0 != ((Number) r13.getSecond()).intValue()) goto L19;
        goto L19
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new KtvChallengeSettingHolder(this, r4.inflate(2131566449, r5, false));
    }
}
