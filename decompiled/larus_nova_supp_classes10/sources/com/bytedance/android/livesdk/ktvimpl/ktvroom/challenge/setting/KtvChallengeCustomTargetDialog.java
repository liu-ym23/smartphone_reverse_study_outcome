package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.setting;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.x0;
import com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment;
import com.bytedance.android.livesdk.message.model.KtvChallengeType;
import com.bytedance.crash.d;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/setting/KtvChallengeCustomTargetDialog;", "Lcom/bytedance/android/live/ktv/common/view/BaseKtvDialogFragment;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvChallengeCustomTargetDialog extends BaseKtvDialogFragment implements View.OnClickListener {
    public static final /* synthetic */ int n = 0;
    public EditText g;
    public TextView h;
    public TextView i;
    public TextView j;
    public Pair<Long, Long> k;
    public int l;
    public Function2<? super Integer, ? super Long, Unit> m;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ KtvChallengeCustomTargetDialog a;

        public b(KtvChallengeCustomTargetDialog r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            EditText r0 = this.a.g;     // Catch: Throwable -> L13
            if (r0 == null) goto L5;
            r0.setFocusable(true);     // Catch: Throwable -> L13
        L5:
            EditText r1 = this.a.g;     // Catch: Throwable -> L13
            if (r1 == null) goto L8;
            r1.setFocusableInTouchMode(true);     // Catch: Throwable -> L13
        L8:
            EditText r2 = this.a.g;     // Catch: Throwable -> L13
            if (r2 == null) goto L11;
            r2.requestFocus();     // Catch: Throwable -> L13
        L11:
            x0.b(this.a.g);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L17;
            return;
        L17:
            throw th;
        }
    }

    static {
    }

    public final String S90() {
        return "KtvChallengeCustomTargetDialog";
    }

    public final int getLayoutId() {
        return 2131565569;
    }

    public KtvChallengeCustomTargetDialog() {
        this.k = new Pair(1L, 100L);
        this.l = KtvChallengeType.KTV_CHALLENGE_TYPE_GIFT.getValue();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        EditText r0 = this.g;
        if (r0 == null) goto L6;
        r0.post(new b(this));
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        String r0 = null;
        if (r9 == null) goto L5;
        Integer r10 = Integer.valueOf(r9.getId());
    L7:
        if (r10 != null) goto L10;
    L19:
        if (r10 != null) goto L22;
        return;
    L22:
        if (r10.intValue() != 2131388190) goto L67;
        EditText r11 = this.g;
        if (r11 == null) goto L28;
        Editable r12 = r11.getText();
        if (r12 == null) goto L28;
        r0 = r12.toString();
    L28:
        boolean r3 = false;
        if (TextUtils.isEmpty(r0) == false) goto L31;
        f2.b(2131918266, 0);
    L42:
        if (r3 == false) goto L68;
        if (r0 == null) goto L45;
        long r4 = CastLongProtector.parseLong(r0);
    L46:
        Function2<? super Integer, ? super Long, Unit> r13 = this.m;
        if (r13 == null) goto L50;
        Unit r14 = (Unit) r13.invoke(Integer.valueOf(this.l), Long.valueOf(r4));
    L50:
        if (isShowing() == false) goto L69;
        dismiss();     // Catch: Exception -> L53
        return;
    L53:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r15 = DialogFragmentLancet.sLastShowStack;
        if (r15 == null) goto L70;
        d.d(r15, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L70:
        return;
    L69:
        return;
    L45:
        r4 = 0;
        goto L46
    L68:
        return;
    L31:
        if (r0 != null) goto L62;
    L35:
        int r16 = 0;
    L36:
        long r5 = r16;
        if (r5 >= ((Number) this.k.getFirst()).longValue()) goto L39;
    L41:
        f2.b(2131918265, 0);
        goto L42
    L39:
        if (r5 > ((Number) this.k.getSecond()).longValue()) goto L41;
        r3 = true;
        goto L42
    L62:
        r16 = CastIntegerProtector.parseInt(r0);     // Catch: Exception -> L34
    L34:
        f2.b(2131918268, 0);
        goto L35
    L67:
        return;
    L10:
        if (r10.intValue() != 2131388189) goto L19;
        if (isShowing() == false) goto L64;
        dismiss();     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r17 = DialogFragmentLancet.sLastShowStack;
        if (r17 == null) goto L65;
        d.d(r17, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L65:
        return;
    L64:
        return;
    L5:
        r10 = null;
        goto L7
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*com.bytedance.android.livesdk.LiveDialogFragment*/.onViewCreated(r3, r4);
        View r5 = ((BaseKtvDialogFragment) this).f;
        TextView r6 = null;
        if (r5 == null) goto L5;
        EditText r7 = (EditText) r5.findViewById(2131388192);
    L6:
        this.g = r7;
        View r8 = ((BaseKtvDialogFragment) this).f;
        if (r8 == null) goto L9;
        TextView r9 = (TextView) r8.findViewById(2131388189);
    L10:
        this.h = r9;
        View r10 = ((BaseKtvDialogFragment) this).f;
        if (r10 == null) goto L13;
        TextView r11 = (TextView) r10.findViewById(2131388190);
    L14:
        this.i = r11;
        View r12 = ((BaseKtvDialogFragment) this).f;
        if (r12 == null) goto L17;
        r6 = (TextView) r12.findViewById(2131388194);
    L17:
        this.j = r6;
        TextView r13 = this.h;
        if (r13 == null) goto L20;
        r13.setOnClickListener(this);
    L20:
        TextView r14 = this.i;
        if (r14 == null) goto L23;
        r14.setOnClickListener(this);
    L23:
        TextView r15 = this.j;
        if (r15 == null) goto L27;
        r15.setText(s1.C(2131918263, new Object[]{this.k.getFirst(), this.k.getSecond()}));
        return;
    L27:
        return;
    L13:
        r11 = null;
        goto L14
    L9:
        r9 = null;
        goto L10
    L5:
        r7 = null;
        goto L6
    }
}
