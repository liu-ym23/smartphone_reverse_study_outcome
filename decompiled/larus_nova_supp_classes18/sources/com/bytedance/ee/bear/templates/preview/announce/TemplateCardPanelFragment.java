package com.bytedance.ee.bear.templates.preview.announce;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseDialogFragment;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.loadstateview.LoadingCategory;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0002()B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0014H\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00060\u0010R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/announce/TemplateCardPanelFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseDialogFragment;", "<init>", "()V", "panelTitle", "Landroid/widget/TextView;", "hideTemplates", "templatesRv", "Landroidx/recyclerview/widget/RecyclerView;", "cardPanel", "Landroidx/constraintlayout/widget/ConstraintLayout;", "templateViewModel", "Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateViewModel;", "templateAdapter", "Lcom/bytedance/ee/bear/templates/preview/announce/PanelTemplateAdapter;", "panelViewDelegate", "Lcom/bytedance/ee/bear/templates/preview/announce/TemplateCardPanelFragment$PanelViewDelegate;", "loadStateViewWrapper", "Lcom/bytedance/ee/bear/list/loadstateview/LoadStateViewWrapper;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initView", "rootView", "observe", "initAdapter", "startAnimatorSet", "getStatusBarHeight", "", "getInternalDimensionSize", "res", "Landroid/content/res/Resources;", "Companion", "PanelViewDelegate", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateCardPanelFragment extends BaseDialogFragment {
    public TextView h;
    public RecyclerView i;
    public ConstraintLayout j;
    public AnnounceTemplateViewModel k;
    public PanelTemplateAdapter l;
    public final b m;
    public com.bytedance.ee.bear.list.loadstateview.h n;

    public static final class a {
    }

    public final class b implements AnnounceTemplateViewModel.c {
        public final /* synthetic */ TemplateCardPanelFragment a;

        @Override // com.bytedance.ee.bear.templates.preview.announce.AnnounceTemplateViewModel.c
        public final void a() {
            TemplateCardPanelFragment.ba0(this.a);
        }

        public b(TemplateCardPanelFragment r1) {
            this.a = r1;
        }
    }

    static {
    }

    public TemplateCardPanelFragment() {
        this.m = new b(this);
    }

    public static final void ba0(TemplateCardPanelFragment r17) {
        AnnounceTemplateViewModel r1 = r17.k;
        if (r1 == null) goto L5;
        TemplateData r2 = r1.getTemplateData();
    L6:
        Intrinsics.checkNotNull(r2);
        boolean r3 = Intrinsics.areEqual(r2.getVisible(), Boolean.TRUE);
        float r5 = 0.0f;
        if (r2.getX() != null) goto L9;
        Float r4 = Float.valueOf(0.0f);
    L11:
        if (r2.getY() != null) goto L13;
        float r6 = 0.0f;
    L14:
        AnnounceTemplateViewModel r7 = r17.k;
        if (r7 == null) goto L17;
        Float r8 = Float.valueOf(r7.getTitleBarHeight());
    L19:
        if (Intrinsics.areEqual(r8, 0.0f) == false) goto L21;
        r8 = Float.valueOf(50.0f);
    L21:
        Resources r9 = Resources.getSystem();
        int r10 = r9.getIdentifier("status_bar_height", "dimen", "android");
        if (r10 <= 0) goto L24;
        int r11 = r9.getDimensionPixelSize(r10);
    L25:
        float r12 = r11;
        Intrinsics.checkNotNull(r8);
        float r13 = (r8.floatValue() + r12) + r6;
        if (r3 == false) goto L28;
        Intrinsics.checkNotNull(r4);
        float r14 = r4.floatValue();
    L29:
        if (r3 == false) goto L31;
        float r15 = 0.0f;
    L32:
        AnnounceTemplateViewModel r16 = r17.k;
        if (r16 == null) goto L35;
        int[] r18 = r16.getPanelLocOnScreen();
    L37:
        if (r3 == false) goto L39;
        float r19 = r13;
    L40:
        if (r3 == false) goto L43;
        Intrinsics.checkNotNull(r18);
        r13 = (r18[1] - r6) - r12;
    L43:
        if (r3 == false) goto L45;
        float r110 = 0.0f;
    L46:
        if (r3 == false) goto L48;
        r5 = 1.0f;
    L48:
        AnimatorSet r20 = new AnimatorSet();
        ConstraintLayout r111 = r17.j;
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type android.view.View");
        TemplateData r112 = r2;
        ObjectAnimator r21 = ObjectAnimator.ofFloat(r111, "scaleX", new float[]{r110, r5});
        ConstraintLayout r113 = r17.j;
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type android.view.View");
        ObjectAnimator r22 = ObjectAnimator.ofFloat(r113, "scaleY", new float[]{r110, r5});
        ConstraintLayout r114 = r17.j;
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type android.view.View");
        ObjectAnimator r23 = ObjectAnimator.ofFloat(r114, "translationX", new float[]{r14, r15});
        ConstraintLayout r24 = r17.j;
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type android.view.View");
        ObjectAnimator r25 = ObjectAnimator.ofFloat(r24, "translationY", new float[]{r19, r13});
        ConstraintLayout r26 = r17.j;
        if (r26 == null) goto L51;
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
    L52:
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r28 = (FrameLayout.LayoutParams) r27;
        if (r3 == false) goto L62;
        r28.topMargin = MathKt.roundToInt(r6);
        r28.gravity = 48;
        ConstraintLayout r29 = r17.j;
        if (r29 == null) goto L57;
        r29.setLayoutParams(r28);
    L57:
        ConstraintLayout r30 = r17.j;
        if (r30 == null) goto L62;
        ViewParent r31 = r30.getParent();
        if (r31 == null) goto L62;
        r31.requestLayout();
    L62:
        r20.setDuration(300);
        r20.playTogether(new Animator[]{r21, r22, r23, r25});
        r20.setInterpolator(new AccelerateInterpolator());
        r20.addListener(new j(r17, r112));
        r20.start();
        return;
    L51:
        r27 = null;
        goto L52
    L45:
        r110 = 1.0f;
        goto L46
    L39:
        Intrinsics.checkNotNull(r18);
        r19 = r18[1] - r6;
        goto L40
    L35:
        r18 = null;
        goto L37
    L31:
        Intrinsics.checkNotNull(r4);
        r15 = r4.floatValue();
        goto L32
    L28:
        r14 = 0.0f;
        goto L29
    L24:
        r11 = 0;
        goto L25
    L17:
        r8 = null;
        goto L19
    L13:
        Float r32 = r2.getY();
        Intrinsics.checkNotNull(r32);
        r6 = r32.floatValue();
        goto L14
    L9:
        r4 = r2.getX();
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r3, r4);
        AnnounceTemplateViewModel r5 = (AnnounceTemplateViewModel) new ViewModelProvider(requireActivity()).get(AnnounceTemplateViewModel.class);
        this.k = r5;
        if (r5 == null) goto L5;
        r5.setViewDelegate(this.m);
    L5:
        TextView r6 = (TextView) r3.findViewById(2131381849);
        this.h = (TextView) r3.findViewById(2131374334);
        this.j = r3.findViewById(2131377418);
        com.bytedance.ee.bear.list.loadstateview.h r0 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) r3.findViewById(2131378939));
        this.n = r0;
        EmptyCategory r7 = EmptyCategory.TEMPLATE;
        LoadingCategory r1 = LoadingCategory.CATEGORY_TEMPLATE;
        r0.b = r7;
        r0.c = r1;
        r0.j();
        ConstraintLayout r8 = this.j;
        if (r8 == null) goto L8;
        r8.post(new f(this));
    L8:
        TextView r9 = this.h;
        if (r9 == null) goto L11;
        r9.setOnClickListener(new g(this));
    L11:
        RecyclerView r10 = r3.findViewById(2131385020);
        this.i = r10;
        if (r10 == null) goto L15;
        r10.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    L15:
        if (this.l != null) goto L17;
        this.l = new PanelTemplateAdapter();
    L17:
        PanelTemplateAdapter r11 = this.l;
        if (r11 == null) goto L20;
        h r12 = new h(this);
        Intrinsics.checkNotNullParameter(r12, "templateClickListener");
        r11.c = r12;
    L20:
        RecyclerView r13 = this.i;
        if (r13 == null) goto L23;
        r13.setAdapter(this.l);
    L23:
        AnnounceTemplateViewModel r14 = this.k;
        if (r14 == null) goto L29;
        MutableLiveData<ArrayList<AnnounceTemplate>> r15 = r14.getTemplates();
        if (r15 == null) goto L30;
        r15.observe(this, new i(this));
        return;
    L30:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131558572, r3, false);
    }
}
