package com.bytedance.android.shopping.feedbackpanel;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.shopping.feedbackpanel.adapter.PanelRVAdapter;
import com.bytedance.android.shopping.feedbackpanel.enums.OperatePanelType;
import com.bytedance.android.shopping.feedbackpanel.enums.WhereType;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.crash.d;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/feedbackpanel/FeedbackPanelDialog;", "Landroidx/fragment/app/DialogFragment;", "Lce3/b;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedbackPanelDialog extends DialogFragment implements ce3.b {
    public de3.a d;
    public ce3.c e;
    public ConstraintLayout f;
    public FrameLayout g;
    public LinearLayout h;
    public final Lazy i;
    public final Lazy j;
    public boolean k;
    public int l;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ FeedbackPanelDialog a;

        public b(FeedbackPanelDialog r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Object r5 = r4.getAnimatedValue();
            Object r1 = null;
            if ((r5 instanceof Float) == true) goto L5;
            r5 = null;
        L5:
            Float r6 = (Float) r5;
            if (r6 == null) goto L34;
            float r7 = r6.floatValue();
            LinearLayout r0 = this.a.h;
            if (r0 == null) goto L10;
            ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        L11:
            if (r2 == null) goto L13;
            r2.height = (int) r7;
        L13:
            LinearLayout r3 = this.a.h;
            if (r3 == null) goto L32;
            r3.setLayoutParams(r2);
        L32:
            Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L18
            Object r9 = Result.constructor-impl(Float.valueOf(r7 / this.a.l));     // Catch: Throwable -> L18
        L21:
            if (Result.isFailure-impl(r9) == true) goto L24;
            r1 = r9;
        L24:
            Float r10 = (Float) r1;
            if (r10 == null) goto L27;
            float r11 = r10.floatValue();
        L28:
            ce3.c r12 = this.a.e;
            if (r12 == null) goto L35;
            r12.f(r11);
            return;
        L35:
            return;
        L27:
            r11 = 0.0f;
        L18:
            th = move-exception;
            Result.Companion r13 = Result.Companion;
            r9 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L21
        L10:
            r2 = null;
            goto L11
        }
    }

    public static final class c implements Animator.AnimatorListener {
        public final /* synthetic */ FeedbackPanelDialog a;
        public final /* synthetic */ OperatePanelType b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            ConstraintLayout r3 = this.a.f;
            if (r3 == null) goto L6;
            r3.setOnTouchListener(com.bytedance.android.shopping.feedbackpanel.a.a);
        L6:
            if (this.b != OperatePanelType.SHOW) goto L10;
            ce3.c r4 = this.a.e;
            if (r4 == null) goto L20;
            r4.d();
            return;
        L20:
            return;
        L10:
            ce3.c r5 = this.a.e;
            if (r5 == null) goto L18;
            r5.e(false);
        L18:
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L15
            FeedbackPanelDialog.S90(this.a);     // Catch: Throwable -> L15
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            Result.Companion r0 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            ConstraintLayout r3 = this.a.f;
            if (r3 == null) goto L6;
            r3.setOnTouchListener(com.bytedance.android.shopping.feedbackpanel.b.a);
            return;
        }

        public c(FeedbackPanelDialog r1, OperatePanelType r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    @Override // ce3.b
    public final void qa() {
        if (this.k == true) goto L5;
        return;
    L5:
        this.k = false;
        T90(OperatePanelType.CLOSE);
    }

    public FeedbackPanelDialog() {
        this.i = LazyKt.lazy(FeedbackPanelDialog$panelRVAdapter$2.INSTANCE);
        this.j = LazyKt.lazy(new FeedbackPanelDialog$linearLayoutManager$2(this));
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        ce3.c r0 = this.e;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    public static final void S90(FeedbackPanelDialog r1) {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void T90(OperatePanelType r8) {
        if (r8 != OperatePanelType.CLOSE) goto L7;
        ce3.c r0 = this.e;
        if (r0 == null) goto L7;
        r0.e(true);
    L7:
        float[] r1 = new float[2];
        OperatePanelType r2 = OperatePanelType.SHOW;
        float r3 = 0.0f;
        if (r8 != r2) goto L10;
        float r5 = 0.0f;
    L11:
        r1[0] = r5;
        if (r8 != r2) goto L14;
        r3 = this.l * 1.0f;
    L14:
        r1[1] = r3;
        ValueAnimator r4 = ValueAnimator.ofFloat(r1);
        r4.addUpdateListener(new b(this));
        r4.addListener(new c(this, r8));
        r4.setDuration(260);
        r4.start();
        return;
    L10:
        r5 = this.l * 1.0f;
        goto L11
    }

    public final void U90(FragmentManager r3) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        if (this.k == false) goto L5;
        return;
    L5:
        if (this.l <= 0) goto L17;
        this.k = true;
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, "", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r0) == true) goto L18;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        super.show(r3, "");
        return;
    L18:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(0, 2131952392);
    }

    public final Dialog onCreateDialog(Bundle r4) {
        Dialog r5 = super.onCreateDialog(r4);
        Window r0 = r5.getWindow();
        if (r0 == null) goto L5;
        r0.setLayout(-1, -1);
        r0.setBackgroundDrawable(new ColorDrawable(0));
        r0.setDimAmount(0.0f);
        r0.addFlags(67108864);
    L5:
        return r5;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, FreqActions.ACTION_VIEW);
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        ConstraintLayout r10 = r8.findViewById(2131384822);
        this.f = r10;
        ce3.c r0 = this.e;
        if (r0 == null) goto L5;
        r0.c(r10);
    L5:
        FrameLayout r11 = (FrameLayout) r8.findViewById(2131389241);
        this.g = r11;
        if (r11 == null) goto L16;
        ce3.c r2 = this.e;
        if (r2 == null) goto L10;
        r2.b(r11);
    L10:
        f.c(r11, null, null, new FeedbackPanelDialog$initView$$inlined$apply$lambda$1(this), 3);
        ViewGroup.LayoutParams r3 = r11.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == true) goto L13;
        r3 = null;
    L13:
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        if (r4 == null) goto L16;
        r4.bottomMargin = this.l;
        r11.setLayoutParams(r4);
    L16:
        this.h = (LinearLayout) r8.findViewById(2131364549);
        TextView r12 = (TextView) r8.findViewById(2131381895);
        if (r12 == null) goto L25;
        de3.a r5 = this.d;
        if (r5 == null) goto L23;
        String r6 = r5.a;
        if (r6 == null) goto L23;
    L24:
        r12.setText(r6);
    L23:
        r6 = "";
    L25:
        ImageView r13 = (ImageView) r8.findViewById(2131381865);
        if (r13 == null) goto L28;
        f.c(r13, null, null, new FeedbackPanelDialog$initView$2(this), 3);
    L28:
        RecyclerView r14 = r8.findViewById(2131381881);
        if (r14 == null) goto L50;
        r14.setAdapter((PanelRVAdapter) this.i.getValue());
        r14.setLayoutManager((LinearLayoutManager) this.j.getValue());
        ArrayList r15 = new ArrayList();
        de3.a r1 = this.d;
        if (r1 == null) goto L49;
        List<de3.b> r7 = r1.c;
        if (r7 == null) goto L49;
        Iterator<T> r16 = r7.iterator();
    L36:
        if (r16.hasNext() == false) goto L49;
        List<de3.c> r17 = ((de3.b) r16.next()).a;
        int r18 = r17.size();
        int r19 = r17.size();
        int r20 = 0;
    L38:
        if (r20 >= r19) goto L36;
        if (r18 != 1) goto L42;
        ((de3.c) ListProtector.get(r17, r20)).d = WhereType.GROUP_ONLY_ONE;
    L48:
        r15.add(ListProtector.get(r17, r20));
        r20 = r20 + 1;
        goto L38
    L42:
        if (r20 != 0) goto L45;
        ((de3.c) ListProtector.get(r17, r20)).d = WhereType.GROUP_TOP;
        goto L48
    L45:
        if (r20 != (r18 - 1)) goto L47;
        ((de3.c) ListProtector.get(r17, r20)).d = WhereType.GROUP_BOTTOM;
        goto L48
    L47:
        ((de3.c) ListProtector.get(r17, r20)).d = WhereType.GROUP_MID;
    L49:
        r14.addItemDecoration(new FeedbackPanelDecoration(r15));
        ((PanelRVAdapter) this.i.getValue()).b = this.e;
        PanelRVAdapter r21 = (PanelRVAdapter) this.i.getValue();
        r21.getClass();
        Intrinsics.checkNotNullParameter(r15, "itemDataList");
        ((ArrayList) r21.a).addAll(r15);
        ((PanelRVAdapter) this.i.getValue()).notifyDataSetChanged();
    L50:
        T90(OperatePanelType.SHOW);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131560571, r3, false);
    }
}
