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
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseDialogFragment;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.loadstateview.LoadingCategory;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0002()B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0014H\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00060\u0010R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/announce/TemplateCardPanelFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseDialogFragment;", "<init>", "()V", "panelTitle", "Landroid/widget/TextView;", "hideTemplates", "templatesRv", "Landroidx/recyclerview/widget/RecyclerView;", "cardPanel", "Landroidx/constraintlayout/widget/ConstraintLayout;", "templateViewModel", "Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateViewModel;", "templateAdapter", "Lcom/bytedance/ee/bear/templates/preview/announce/PanelTemplateAdapter;", "panelViewDelegate", "Lcom/bytedance/ee/bear/templates/preview/announce/TemplateCardPanelFragment$PanelViewDelegate;", "loadStateViewWrapper", "Lcom/bytedance/ee/bear/list/loadstateview/LoadStateViewWrapper;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initView", "rootView", "observe", "initAdapter", "startAnimatorSet", "getStatusBarHeight", "", "getInternalDimensionSize", "res", "Landroid/content/res/Resources;", "Companion", "PanelViewDelegate", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateCardPanelFragment extends BaseDialogFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f239159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RecyclerView f239160i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ConstraintLayout f239161j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AnnounceTemplateViewModel f239162k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PanelTemplateAdapter f239163l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f239164m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.ee.bear.list.loadstateview.h f239165n;

    public static final class a {
    }

    public final class b implements AnnounceTemplateViewModel.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TemplateCardPanelFragment f239166a;

        @Override // com.bytedance.ee.bear.templates.preview.announce.AnnounceTemplateViewModel.c
        public final void a() {
            TemplateCardPanelFragment.ba0(this.f239166a);
        }

        public b(TemplateCardPanelFragment r100) {
            this.f239166a = r100;
        }
    }

    static {
    }

    public TemplateCardPanelFragment() {
        this.f239164m = new b(this);
    }

    public static final void ba0(TemplateCardPanelFragment r110) {
        AnnounceTemplateViewModel r100 = r110.f239162k;
        if (r100 == null) goto L5;
        TemplateData r101 = r100.getTemplateData();
    L6:
        Intrinsics.checkNotNull(r101);
        boolean r102 = Intrinsics.areEqual(r101.getVisible(), Boolean.TRUE);
        float r103 = 0.0f;
        if (r101.getX() != null) goto L9;
        Float r104 = Float.valueOf(0.0f);
    L11:
        if (r101.getY() != null) goto L13;
        float r105 = 0.0f;
    L14:
        AnnounceTemplateViewModel r106 = r110.f239162k;
        if (r106 == null) goto L17;
        Float r107 = Float.valueOf(r106.getTitleBarHeight());
    L19:
        if (Intrinsics.areEqual(r107, 0.0f) == false) goto L21;
        r107 = Float.valueOf(50.0f);
    L21:
        Resources r108 = Resources.getSystem();
        int r109 = r108.getIdentifier("status_bar_height", "dimen", "android");
        if (r109 <= 0) goto L24;
        int r111 = r108.getDimensionPixelSize(r109);
    L25:
        float r112 = r111;
        Intrinsics.checkNotNull(r107);
        float r113 = (r107.floatValue() + r112) + r105;
        if (r102 == false) goto L28;
        Intrinsics.checkNotNull(r104);
        float r114 = r104.floatValue();
    L29:
        if (r102 == false) goto L31;
        float r115 = 0.0f;
    L32:
        AnnounceTemplateViewModel r116 = r110.f239162k;
        if (r116 == null) goto L35;
        int[] r117 = r116.getPanelLocOnScreen();
    L37:
        if (r102 == false) goto L39;
        float r118 = r113;
    L40:
        if (r102 == false) goto L43;
        Intrinsics.checkNotNull(r117);
        r113 = (r117[1] - r105) - r112;
    L43:
        if (r102 == false) goto L45;
        float r119 = 0.0f;
    L46:
        if (r102 == false) goto L48;
        r103 = 1.0f;
    L48:
        AnimatorSet r120 = new AnimatorSet();
        ConstraintLayout r121 = r110.f239161j;
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type android.view.View");
        TemplateData r122 = r101;
        ObjectAnimator r123 = ObjectAnimator.ofFloat(r121, LiveDegradeFpsAnimator.SCALE_X, new float[]{r119, r103});
        ConstraintLayout r124 = r110.f239161j;
        Intrinsics.checkNotNull(r124, "null cannot be cast to non-null type android.view.View");
        ObjectAnimator r125 = ObjectAnimator.ofFloat(r124, LiveDegradeFpsAnimator.SCALE_Y, new float[]{r119, r103});
        ConstraintLayout r126 = r110.f239161j;
        Intrinsics.checkNotNull(r126, "null cannot be cast to non-null type android.view.View");
        ObjectAnimator r127 = ObjectAnimator.ofFloat(r126, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r114, r115});
        ConstraintLayout r128 = r110.f239161j;
        Intrinsics.checkNotNull(r128, "null cannot be cast to non-null type android.view.View");
        ObjectAnimator r129 = ObjectAnimator.ofFloat(r128, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r118, r113});
        ConstraintLayout r130 = r110.f239161j;
        if (r130 == null) goto L51;
        ViewGroup.LayoutParams r131 = r130.getLayoutParams();
    L52:
        Intrinsics.checkNotNull(r131, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r132 = (FrameLayout.LayoutParams) r131;
        if (r102 == false) goto L62;
        r132.topMargin = MathKt.roundToInt(r105);
        r132.gravity = 48;
        ConstraintLayout r133 = r110.f239161j;
        if (r133 == null) goto L57;
        r133.setLayoutParams(r132);
    L57:
        ConstraintLayout r134 = r110.f239161j;
        if (r134 == null) goto L62;
        ViewParent r135 = r134.getParent();
        if (r135 == null) goto L62;
        r135.requestLayout();
    L62:
        r120.setDuration(300);
        r120.playTogether(new Animator[]{r123, r125, r127, r129});
        r120.setInterpolator(new AccelerateInterpolator());
        r120.addListener(new j(r110, r122));
        r120.start();
        return;
    L51:
        r131 = null;
        goto L52
    L45:
        r119 = 1.0f;
        goto L46
    L39:
        Intrinsics.checkNotNull(r117);
        r118 = r117[1] - r105;
        goto L40
    L35:
        r117 = null;
        goto L37
    L31:
        Intrinsics.checkNotNull(r104);
        r115 = r104.floatValue();
        goto L32
    L28:
        r114 = 0.0f;
        goto L29
    L24:
        r111 = 0;
        goto L25
    L17:
        r107 = null;
        goto L19
    L13:
        Float r136 = r101.getY();
        Intrinsics.checkNotNull(r136);
        r105 = r136.floatValue();
        goto L14
    L9:
        r104 = r101.getX();
        goto L11
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        AnnounceTemplateViewModel r102 = (AnnounceTemplateViewModel) new ViewModelProvider(requireActivity()).get(AnnounceTemplateViewModel.class);
        this.f239162k = r102;
        if (r102 == null) goto L5;
        r102.setViewDelegate(this.f239164m);
    L5:
        TextView r103 = (TextView) r100.findViewById(R.id.panelTitle);
        this.f239159h = (TextView) r100.findViewById(R.id.hideTemplates);
        this.f239161j = (ConstraintLayout) r100.findViewById(R.id.layout_announce_car_panel);
        com.bytedance.ee.bear.list.loadstateview.h r104 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) r100.findViewById(R.id.loadStateView));
        this.f239165n = r104;
        EmptyCategory r105 = EmptyCategory.TEMPLATE;
        LoadingCategory r106 = LoadingCategory.CATEGORY_TEMPLATE;
        r104.f228648b = r105;
        r104.f228649c = r106;
        r104.j();
        ConstraintLayout r107 = this.f239161j;
        if (r107 == null) goto L8;
        r107.post(new f(this));
    L8:
        TextView r108 = this.f239159h;
        if (r108 == null) goto L11;
        r108.setOnClickListener(new g(this));
    L11:
        RecyclerView r109 = (RecyclerView) r100.findViewById(R.id.rv_templates);
        this.f239160i = r109;
        if (r109 == null) goto L15;
        r109.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    L15:
        if (this.f239163l != null) goto L17;
        this.f239163l = new PanelTemplateAdapter();
    L17:
        PanelTemplateAdapter r110 = this.f239163l;
        if (r110 == null) goto L20;
        h r111 = new h(this);
        Intrinsics.checkNotNullParameter(r111, "templateClickListener");
        r110.f239156c = r111;
    L20:
        RecyclerView r112 = this.f239160i;
        if (r112 == null) goto L23;
        r112.setAdapter(this.f239163l);
    L23:
        AnnounceTemplateViewModel r113 = this.f239162k;
        if (r113 == null) goto L29;
        MutableLiveData<ArrayList<AnnounceTemplate>> r114 = r113.getTemplates();
        if (r114 == null) goto L30;
        r114.observe(this, new i(this));
        return;
    L30:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.announce_template_card_panel_fragment, r101, false);
    }
}
