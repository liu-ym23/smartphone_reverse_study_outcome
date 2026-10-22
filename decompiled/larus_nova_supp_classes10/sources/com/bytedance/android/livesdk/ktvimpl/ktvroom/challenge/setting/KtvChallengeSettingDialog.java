package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.model.bean.ChallengeChangeType;
import com.bytedance.android.live.ktv.common.model.bean.SwitchStatus;
import com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment;
import com.bytedance.android.live.liveinteract.e;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeSettingViewModel;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.ktvimpl.multichorus.c;
import com.bytedance.android.livesdk.message.model.KtvChallengeType;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/setting/KtvChallengeSettingDialog;", "Lcom/bytedance/android/live/ktv/common/view/BaseKtvDialogFragment;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvChallengeSettingDialog extends BaseKtvDialogFragment implements View.OnClickListener {
    public static final /* synthetic */ int o = 0;
    public View g;
    public RecyclerView h;
    public TextView i;
    public final MultiTypeAdapter j;
    public RecyclerView k;
    public final MultiTypeAdapter l;
    public KtvChallengeSettingViewModel m;
    public String n;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ KtvChallengeSettingDialog a;

        public b(KtvChallengeSettingDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Pair r3 = (Pair) r2;
            KtvChallengeSettingDialog r4 = this.a;
            int r0 = KtvChallengeSettingDialog.o;
            r4.Y90();
        }
    }

    static {
    }

    public final String S90() {
        return "KtvChallengeSettingDialog";
    }

    public final int getLayoutId() {
        return 2131565570;
    }

    public final void X90() {
        KtvChallengeSettingViewModel r0 = this.m;
        Integer r2 = null;
        if (r0 == null) goto L5;
        Long r1 = Long.valueOf(r0.currentChallengeTarget());
    L6:
        KtvChallengeSettingViewModel r3 = this.m;
        if (r3 == null) goto L9;
        Long r4 = Long.valueOf(r3.getChallengeDuration());
    L10:
        KtvChallengeSettingViewModel r5 = this.m;
        if (r5 == null) goto L13;
        r2 = Integer.valueOf(r5.currentChallengeType());
    L13:
        ALogger.i("KtvChallengeSettingDialog", "score: " + r1 + ", duration: " + r4 + ", type: " + r2);
        if (r1 == null) goto L25;
        if (r4 == null) goto L25;
        if (r2 == null) goto L25;
        int r16 = r2.intValue();
        long r9 = r4.longValue();
        long r7 = r1.longValue();
        KtvContext.Companion.getClass();
        KtvContext.a.g().getPrepareChallengeEvent().post(new me2.b(r7, r9, ChallengeChangeType.SWITCH_TURN_ON, SwitchStatus.OPEN.getValue(), "sing_challenge_setting_panel", this.n, r16, DeviceStatus$DiffDimension.DIFF_LOCATION_MODE));
    L25:
        dismiss();     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L27;
        d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L27:
        return;
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final void Y90() {
        MultiTypeAdapter r0 = this.j;
        KtvChallengeSettingViewModel r1 = this.m;
        if (r1 == null) goto L6;
        List<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a> r2 = r1.getChallengeTypeList();
        if (r2 == null) goto L6;
    L7:
        r0.a = r2;
        this.j.notifyDataSetChanged();
        KtvChallengeSettingViewModel r3 = this.m;
        if (r3 == null) goto L11;
        List<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a> r4 = r3.getChallengeTargetList();
        if (r4 == null) goto L11;
    L12:
        MultiTypeAdapter r5 = this.l;
        r5.a = r4;
        r5.notifyDataSetChanged();
        KtvChallengeSettingViewModel r6 = this.m;
        if (r6 == null) goto L15;
        int r7 = r6.currentChallengeType();
    L16:
        TextView r8 = this.i;
        if (r8 != null) goto L19;
        return;
    L19:
        if (r7 != KtvChallengeType.KTV_CHALLENGE_TYPE_GIFT.getValue()) goto L22;
        String r9 = s1.B(2131918256);
    L28:
        r8.setText(r9);
        return;
    L22:
        if (r7 != KtvChallengeType.KTV_CHALLENGE_TYPE_MIDI.getValue()) goto L25;
        r9 = s1.B(2131918259);
        goto L28
    L25:
        if (r7 != KtvChallengeType.KTV_CHALLENGE_TYPE_LIKE.getValue()) goto L27;
        r9 = s1.B(2131918258);
        goto L28
    L27:
        r9 = s1.B(2131918256);
        goto L28
    L15:
        r7 = 0;
    L11:
        r4 = new ArrayList();
    L6:
        r2 = new ArrayList();
        goto L7
    }

    public KtvChallengeSettingDialog() {
        this.j = new MultiTypeAdapter();
        this.l = new MultiTypeAdapter();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        if (r5 == null) goto L5;
        Integer r6 = Integer.valueOf(r5.getId());
    L6:
        if (r6 != null) goto L9;
    L13:
        if (r6 != null) goto L16;
        return;
    L16:
        if (r6.intValue() == 2131376876) goto L18;
        return;
    L18:
        if (MultiChorusContext.Companion.c() == true) goto L20;
    L28:
        X90();
        return;
    L20:
        if (ne2.a.a() == true) goto L28;
        x0 r7 = c.f(getContext(), s1.B(2131920820), s1.B(2131920819), new KtvChallengeSettingDialog$tryOpenChallenge$1(this), KtvChallengeSettingDialog$tryOpenChallenge$2.INSTANCE);
        if (r7 != null) goto L24;
        return;
    L24:
        if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L31;
        DialogLancet.handleBlockedDialogShow(r7);
        return;
    L31:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L30
    L27:
        DialogLancet.beforeDialogShow(r7);
        r7.show();
        DialogLancet.afterDialogShow(r7);
        return;
    L9:
        if (r6.intValue() != 2131376881) goto L13;
        Context r8 = getContext();
        if (r8 == null) goto L33;
        int r1 = e.a;
        e.d(r8, 4, null);
        return;
    L33:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        KtvChallengeSettingViewModel r3 = (KtvChallengeSettingViewModel) ViewModelProviders.of(this).get(KtvChallengeSettingViewModel.class);
        this.m = r3;
        if (r3 == null) goto L5;
        r3.getSingingChallengeOption();
    L5:
        KtvChallengeSettingViewModel r4 = this.m;
        if (r4 == null) goto L11;
        MutableLiveData<Pair<Integer, Integer>> r5 = r4.getChallengeConfigIndexPair();
        if (r5 == null) goto L12;
        r5.observe(this, new b(this));
        return;
    L12:
        return;
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*com.bytedance.android.livesdk.LiveDialogFragment*/.onViewCreated(r5, r6);
        View r7 = ((BaseKtvDialogFragment) this).f;
        TextView r8 = null;
        if (r7 == null) goto L5;
        View r9 = r7.findViewById(2131376881);
    L6:
        this.g = r9;
        if (r9 == null) goto L9;
        r9.setOnClickListener(this);
    L9:
        View r10 = ((BaseKtvDialogFragment) this).f;
        if (r10 == null) goto L12;
        TextView r11 = (TextView) r10.findViewById(2131376876);
    L13:
        if (r11 == null) goto L15;
        r11.setOnClickListener(this);
    L15:
        View r12 = ((BaseKtvDialogFragment) this).f;
        if (r12 == null) goto L18;
        RecyclerView r13 = (RecyclerView) r12.findViewById(2131376889);
    L19:
        this.h = r13;
        View r14 = ((BaseKtvDialogFragment) this).f;
        if (r14 == null) goto L22;
        RecyclerView r15 = (RecyclerView) r14.findViewById(2131376886);
    L23:
        this.k = r15;
        RecyclerView r16 = this.h;
        if (r16 == null) goto L26;
        r16.setLayoutManager(new SSLinearLayoutManager(getContext(), 0));
    L26:
        this.j.z2(com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a.class, new KtvChallengeSettingViewBinder(this.m));
        RecyclerView r17 = this.h;
        if (r17 == null) goto L29;
        r17.setAdapter(this.j);
    L29:
        RecyclerView r18 = this.k;
        if (r18 == null) goto L32;
        r18.setLayoutManager(new SSLinearLayoutManager(getContext(), 0));
    L32:
        this.l.z2(com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a.class, new KtvChallengeSettingViewBinder(this.m));
        RecyclerView r19 = this.k;
        if (r19 == null) goto L35;
        r19.setAdapter(this.l);
    L35:
        View r20 = ((BaseKtvDialogFragment) this).f;
        if (r20 == null) goto L38;
        r8 = (TextView) r20.findViewById(2131376872);
    L38:
        this.i = r8;
        Y90();
        return;
    L22:
        r15 = null;
        goto L23
    L18:
        r13 = null;
        goto L19
    L12:
        r11 = null;
        goto L13
    L5:
        r9 = null;
        goto L6
    }
}
