package com.suite.lark.platform.component.cta.newstyle;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.cta.databinding.FragmentCtaDialogBinding;
import com.suite.lark.platform.component.cta.newstyle.adapter.BenefitListAdapter;
import com.suite.lark.platform.component.cta.newstyle.adapter.VersionInfoAdapter;
import com.suite.lark.platform.component.cta.newstyle.entity.CTAParams;
import com.suite.lark.platform.component.cta.newstyle.widgets.CustomButtonGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import z5c.e4;
import z5c.j3;
import z5c.p2;
import z5c.r;
import z5c.v1;
import z5c.w0;
import z5c.x0;
import z5c.y0;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0017J\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020&H\u0002J\b\u0010+\u001a\u00020&H\u0002J\b\u0010,\u001a\u00020&H\u0002J\b\u0010-\u001a\u00020&H\u0002J\b\u0010.\u001a\u00020&H\u0002J\b\u0010/\u001a\u00020&H\u0002J\b\u00100\u001a\u00020&H\u0002J\b\u00101\u001a\u00020&H\u0002J\b\u00102\u001a\u00020&H\u0002J\b\u00103\u001a\u00020&H\u0002J\b\u00104\u001a\u00020&H\u0016J\b\u00105\u001a\u00020&H\u0016J\u0010\u00106\u001a\u00020&2\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020&H\u0002J\b\u0010:\u001a\u00020&H\u0002J\b\u0010;\u001a\u00020&H\u0002J\u0010\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u00020)H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/suite/lark/platform/component/cta/newstyle/CTADialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "viewBinding", "Lcom/suite/lark/platform/component/cta/databinding/FragmentCtaDialogBinding;", "ctaDialogCallback", "Lcom/suite/lark/platform/component/cta/entity/CTADialogCallback;", "getCtaDialogCallback", "()Lcom/suite/lark/platform/component/cta/entity/CTADialogCallback;", "setCtaDialogCallback", "(Lcom/suite/lark/platform/component/cta/entity/CTADialogCallback;)V", "stuckSpotResponse", "Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse;", "ctaParams", "Lcom/suite/lark/platform/component/cta/newstyle/entity/CTAParams;", "featureKey", "", "scene", "benefitListAdapter", "Lcom/suite/lark/platform/component/cta/newstyle/adapter/BenefitListAdapter;", "cards", "", "Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Card;", "getCards", "()Ljava/util/List;", "currentCard", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onViewCreated", "", "view", "initData", "", "initView", "initListeners", "initBottomSheet", "initTitleBar", "initTitleView", "initBenefitList", "initVersionInfo", "intBodyImageView", "initBodyView", "initFooterView", LiveCommonConstants.REASON_ON_DEDTROY, "dismiss", "onCancel", "dialog", "Landroid/content/DialogInterface;", "callbackOnShow", "callbackOnCancel", "callbackOnDismiss", "updateButtonListConstraint", "isCardsEmpty", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CTADialogFragment extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FragmentCtaDialogBinding f460527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public goc.a f460528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public goc.b f460529f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CTAParams f460530g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f460531h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f460532i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BenefitListAdapter f460533j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public goc.b.e f460534k;

    public static final class a extends BottomSheetBehavior.BottomSheetCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CTADialogFragment f460535a;

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onSlide(View r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        }

        public a(CTADialogFragment r100) {
            this.f460535a = r100;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onStateChanged(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
            if (r101 == 5) goto L13;
            return;
        L13:
            this.f460535a.dismiss();     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r102 = DialogFragmentLancet.sLastShowStack;
            if (r102 == null) goto L15;
            com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class b implements DialogInterface.OnShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CTADialogFragment f460536a;

        public b(CTADialogFragment r100) {
            this.f460536a = r100;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r100) {
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
            View r101 = ((BottomSheetDialog) r100).findViewById(R.id.design_bottom_sheet);
            if (r101 == null) goto L5;
            r101.setBackgroundColor(UIUtils.getColor(this.f460536a.requireContext(), R.color.transparent));
        L5:
            CTADialogFragment r102 = this.f460536a;
            goc.a r103 = r102.f460528e;
            if (r103 == null) goto L8;
            r103.onShow();
        L8:
            goc.b r104 = r102.f460529f;
            if (r104 == null) goto L14;
            goc.b.g r105 = r104.b();
            if (r105 == null) goto L14;
            goc.b.h r106 = r105.b();
            if (r106 == null) goto L14;
        L15:
            int r107 = g.f460566a;
            String r108 = r102.f460531h;
            String r109 = r102.f460532i;
            String r110 = r106.b();
            String r111 = "";
            if (r110 != null) goto L18;
            r110 = "";
        L18:
            boolean r112 = r106.a();
            boolean r113 = r106.d();
            goc.b.e r114 = r102.f460534k;
            if (r114 == null) goto L21;
            String r115 = r114.d();
        L22:
            if (r115 != null) goto L24;
            r115 = "";
        L24:
            String r116 = r106.c();
            if (r116 == null) goto L28;
            r111 = r116;
        L28:
            Intrinsics.checkNotNullParameter(r108, "functionKey");
            Intrinsics.checkNotNullParameter(r109, "functionScene");
            Intrinsics.checkNotNullParameter(r110, "functionCategory");
            Intrinsics.checkNotNullParameter(r115, "skuKey");
            Intrinsics.checkNotNullParameter(r111, "viewType");
            s5c.d r117 = s5c.d.b.b(y0.f570408c.a(r108), x0.f570400d.a(r109)).plus(w0.f570393c.a(r110)).plus(j3.f570229c.a(r115)).plus(e4.f570195e.a(r111));
            if (r112 == false) goto L31;
            s5c.a r118 = z5c.e.f570186c;
        L32:
            s5c.d r119 = r117.plus(r118);
            if (r113 == false) goto L35;
            s5c.a r120 = v1.f570389d;
        L36:
            Statistics.sendEvent("common_pricing_popup_view", r119.plus(r120).plus(p2.f570281c).toJson());
            return;
        L35:
            r120 = v1.f570388c;
            goto L36
        L31:
            r118 = z5c.e.f570187d;
            goto L32
        L21:
            r115 = null;
        L14:
            r106 = new goc.b.h(0);
            goto L15
        }
    }

    public final List<goc.b.e> S90() {
        goc.b r100 = this.f460529f;
        if (r100 == null) goto L11;
        goc.b.g r101 = r100.b();
        if (r101 == null) goto L11;
        goc.b.f r102 = r101.a();
        if (r102 == null) goto L11;
        goc.b.c r103 = r102.a();
        if (r103 == null) goto L11;
        List<goc.b.e> r104 = r103.a();
    L12:
        if (r104 != null) goto L15;
        r104 = CollectionsKt.emptyList();
    L15:
        return CollectionsKt.filterNotNull(r104);
    L11:
        r104 = null;
        goto L12
    }

    public CTADialogFragment() {
        this.f460531h = "";
        this.f460532i = "";
    }

    public final void T90() {
        Dialog r100 = getDialog();
        BottomSheetBehavior r101 = null;
        if ((r100 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r102 = (BottomSheetDialog) r100;
    L6:
        if (r102 == null) goto L8;
        r101 = r102.getBehavior();
    L8:
        if (r101 == null) goto L10;
        r101.setPeekHeight(UIUtils.getScreenHeight(getContext()));
    L10:
        if (r101 == null) goto L12;
        r101.setDraggable(true);
    L12:
        if (r101 == null) goto L15;
        r101.addBottomSheetCallback(new a(this));
        return;
    L15:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismiss() {
        super.dismiss();     // Catch: Exception -> L4
    L8:
        Context r100 = getContext();
        if (r100 == null) goto L13;
        Activity r101 = ContextsKt.findActivity(r100);
        if (r101 == null) goto L13;
        r101.finish();
    L13:
        goc.a r102 = this.f460528e;
        if (r102 == null) goto L19;
        r102.onDismiss();
        return;
    L19:
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r103 = DialogFragmentLancet.sLastShowStack;
        if (r103 == null) goto L8;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f460528e = null;
        loc.e.f510168a = null;
        loc.e.f510169b = null;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r110) {
        Intrinsics.checkNotNullParameter(r110, "dialog");
        super.onCancel(r110);
        Context r111 = getContext();
        if (r111 == null) goto L7;
        Activity r112 = ContextsKt.findActivity(r111);
        if (r112 == null) goto L7;
        r112.finish();
    L7:
        goc.b r113 = this.f460529f;
        if (r113 == null) goto L13;
        goc.b.g r114 = r113.b();
        if (r114 == null) goto L13;
        goc.b.h r115 = r114.b();
        if (r115 == null) goto L13;
    L14:
        int r100 = g.f460566a;
        String r101 = this.f460531h;
        String r102 = this.f460532i;
        String r103 = r115.b();
        if (r103 != null) goto L17;
        r103 = "";
    L17:
        boolean r104 = r115.a();
        boolean r105 = r115.d();
        goc.b.e r106 = this.f460534k;
        if (r106 == null) goto L20;
        String r107 = r106.d();
    L21:
        if (r107 != null) goto L23;
        r107 = "";
    L23:
        String r116 = r115.c();
        if (r116 != null) goto L26;
        String r108 = "";
    L27:
        String r109 = r103;
        g.a(r101, r102, r109, r104, r105, r107, r108, r.f570325h);
        return;
    L26:
        r108 = r116;
        goto L27
    L20:
        r107 = null;
    L13:
        r115 = new goc.b.h(0);
        goto L14
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        BottomSheetDialog r101 = new BottomSheetDialog(requireContext());
        r101.setCancelable(true);
        r101.setCanceledOnTouchOutside(true);
        r101.setOnShowListener(new b(this));
        return r101;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        super.onViewCreated(r210, r211);
        this.f460529f = h.f460567a;
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        Object r101 = r100.get("intent_cta_params");
    L7:
        if ((r101 instanceof CTAParams) == false) goto L9;
        CTAParams r102 = (CTAParams) r101;
    L10:
        if (r102 != null) goto L12;
        boolean r103 = false;
    L16:
        if (r103 == false) goto L242;
        T90();
        FragmentCtaDialogBinding r104 = this.f460527d;
        String r105 = "viewBinding";
        if (r104 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r104 = null;
    L30:
        r104.f460496h.setLeftClickListener(new e(this));
        goc.b r106 = this.f460529f;
        if (r106 == null) goto L40;
        goc.b.g r107 = r106.b();
        if (r107 == null) goto L40;
        goc.b.f r108 = r107.a();
        if (r108 == null) goto L40;
        goc.b.l r109 = r108.c();
        if (r109 == null) goto L40;
        String r110 = r109.a();
        if (r110 == null) goto L40;
    L41:
        goc.b r111 = this.f460529f;
        if (r111 == null) goto L50;
        goc.b.g r112 = r111.b();
        if (r112 == null) goto L50;
        goc.b.f r113 = r112.a();
        if (r113 == null) goto L50;
        goc.b.c r114 = r113.a();
        if (r114 == null) goto L50;
        List<goc.b.l> r115 = r114.c();
    L51:
        if (r115 != null) goto L53;
        r115 = CollectionsKt.emptyList();
    L53:
        List r116 = CollectionsKt.filterNotNull(r115);
        FragmentCtaDialogBinding r117 = this.f460527d;
        if (r117 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r117 = null;
    L56:
        r117.f460495g.setText(r110);
        FragmentCtaDialogBinding r118 = this.f460527d;
        if (r118 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r118 = null;
    L59:
        TextView r119 = r118.f460494f;
        Context r120 = requireContext();
        joc.c r121 = loc.e.f510168a;
        Intrinsics.checkNotNullParameter(r116, "<this>");
        Intrinsics.checkNotNullParameter(r120, PerfLog.PARAM_KEY_CONTEXT_ID);
        SpannableStringBuilder r122 = new SpannableStringBuilder();
        Iterator r123 = r116.iterator();
        int r124 = 0;
    L61:
        if (r123.hasNext() == false) goto L129;
        Object r125 = r123.next();
        int r126 = r124 + 1;
        if (r124 >= 0) goto L65;
        CollectionsKt.throwIndexOverflow();
    L65:
        goc.b.l r127 = (goc.b.l) r125;
        String r128 = r127.a();
        if (r128 != null) goto L68;
        r128 = "";
    L68:
        SpannableStringBuilder r129 = new SpannableStringBuilder(foc.d.a(r128));
        List<goc.b.i> r130 = r127.b();
        if (r130 != null) goto L71;
        r130 = CollectionsKt.emptyList();
    L71:
        Iterator r131 = CollectionsKt.filterNotNull(r130).iterator();
    L73:
        if (r131.hasNext() == false) goto L128;
        goc.b.i r132 = (goc.b.i) r131.next();
        String r133 = r132.getType();
        if (r133 == null) goto L73;
        int r134 = r133.hashCode();
        Iterator r135 = r123;
        if (r134 == 3321850) goto L109;
        if (r134 == 3599307) goto L97;
        if (r134 == 1021751938) goto L84;
    L127:
        r123 = r135;
        goto L73
    L84:
        if (r133.equals("plain_text") == false) goto L127;
        String r136 = r132.c();
        if (r136 != null) goto L89;
        r136 = "";
    L89:
        MatchResult r137 = Regex.find$default(new Regex("\\{\\{" + r136 + "\\}\\}"), r129, 0, 2, null);
        if (r137 == null) goto L127;
        int r138 = r137.getRange().getFirst();
        int r139 = r137.getRange().getLast() + 1;
        String r140 = r132.b();
        if (r140 != null) goto L95;
        r140 = "";
    L95:
        r129.replace(r138, r139, r140);
        goto L127
    L97:
        if (r133.equals("user") == false) goto L127;
        String r141 = r132.c();
        if (r141 != null) goto L101;
        r141 = "";
    L101:
        MatchResult r142 = Regex.find$default(new Regex("\\{\\{" + r141 + "\\}\\}"), r129, 0, 2, null);
        if (r142 == null) goto L127;
        String r143 = r132.b();
        if (r143 != null) goto L107;
        r143 = "";
    L107:
        String r144 = "@".concat(r143);
        r129.replace(r142.getRange().getFirst(), r142.getRange().getLast() + 1, r144);
        r129.setSpan(new b18.a(UDColorUtils.getColor(r120, R.color.text_link_normal), new loc.b(r141)), r142.getRange().getFirst(), r142.getRange().getFirst() + r144.length(), 17);
        goto L127
    L109:
        if (r133.equals("link") == false) goto L127;
        String r145 = r132.c();
        if (r145 != null) goto L114;
        r145 = "";
    L114:
        String r146 = r132.a();
        if (r146 != null) goto L118;
        r146 = "";
    L118:
        if (StringsKt.isBlank(r146) == true) goto L127;
        MatchResult r147 = Regex.find$default(new Regex("\\{\\{" + r145 + "\\}\\}"), r129, 0, 2, null);
        if (r147 == null) goto L127;
        String r148 = r132.b();
        if (r148 != null) goto L126;
        r148 = "";
    L126:
        r129.replace(r147.getRange().getFirst(), r147.getRange().getLast() + 1, r148);
        r129.setSpan(new b18.a(UDColorUtils.getColor(r120, R.color.text_link_normal), new loc.a(r146)), r147.getRange().getFirst(), r147.getRange().getFirst() + r148.length(), 17);
        goto L127
    L128:
        r122.append(r129);
        r124 = r126;
        goto L61
    L129:
        r119.setText(r122);
        r119.setMovementMethod(LinkMovementMethod.getInstance());
        if ((!S90().isEmpty()) == false) goto L172;
        FragmentCtaDialogBinding r149 = this.f460527d;
        if (r149 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r149 = null;
    L134:
        RecyclerView r150 = r149.f460490b;
        BenefitListAdapter r151 = new BenefitListAdapter(requireContext());
        this.f460533j = r151;
        r150.setAdapter(r151);
        r150.setLayoutManager(new LinearLayoutManager(requireContext()));
        r150.setItemAnimator(null);
        r150.setVisibility(0);
        if (S90().isEmpty() == false) goto L137;
        r150.setVisibility(8);
    L158:
        f r152 = new f(this);
        FragmentCtaDialogBinding r153 = this.f460527d;
        if (r153 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r153 = null;
    L161:
        LKUIRoundableLayout r154 = r153.f460498j;
        FragmentCtaDialogBinding r155 = this.f460527d;
        if (r155 != null) goto L164;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r155 = null;
    L164:
        RecyclerView r156 = r155.f460497i;
        VersionInfoAdapter r157 = new VersionInfoAdapter(requireContext(), r152);
        r156.setAdapter(r157);
        r156.setLayoutManager(new LinearLayoutManager(requireContext()));
        FragmentCtaDialogBinding r158 = null;
        r156.setItemAnimator(null);
        r154.setVisibility(0);
        if (S90().isEmpty() == false) goto L167;
        r154.setVisibility(8);
    L199:
        boolean r159 = S90().isEmpty();
        FragmentCtaDialogBinding r160 = this.f460527d;
        if (r160 != null) goto L202;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r160 = r158;
    L202:
        ConstraintLayout r161 = r160.f460493e;
        ConstraintSet r162 = new ConstraintSet();
        r162.clone(r161);
        if (r159 == false) goto L205;
        r162.connect(R.id.button_list, 3, R.id.cta_image, 4, UIUtils.dp2px(requireContext(), 4.0f));
    L206:
        r162.applyTo(r161);
        goc.b r163 = this.f460529f;
        if (r163 == null) goto L213;
        goc.b.g r164 = r163.b();
        if (r164 == null) goto L213;
        goc.b.f r165 = r164.a();
        if (r165 == null) goto L213;
        Object r166 = r165.b();
    L214:
        if (r166 != null) goto L216;
        r166 = CollectionsKt.emptyList();
    L216:
        Iterator r167 = CollectionsKt.filterNotNull((Iterable) r166).iterator();
    L218:
        if (r167.hasNext() == false) goto L240;
        goc.b.d r168 = (goc.b.d) r167.next();
        FragmentCtaDialogBinding r169 = this.f460527d;
        if (r169 != null) goto L222;
        Intrinsics.throwUninitializedPropertyAccessException(r105);
        r169 = r158;
    L222:
        CustomButtonGroup r170 = r169.f460491c;
        Context r171 = requireContext();
        joc.c r172 = loc.e.f510168a;
        Intrinsics.checkNotNullParameter(r171, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r168, "button");
        if (Intrinsics.areEqual(r168.d(), "primary") == false) goto L225;
        UDButton r173 = new UDButton(r171, null, 0, 6, null);
        r173.setClickable(true);
        r173.setMaxLines(1);
        r173.setEllipsize(TextUtils.TruncateAt.END);
        r173.setSingleLine(true);
        int r174 = UIUtils.dp2px(r171, 16.0f);
        int r175 = UIUtils.dp2px(r171, 9.0f);
        r173.setPadding(r174, r175, r174, r175);
        r173.setTextSize(17.0f);
        r173.setGravity(17);
        r173.setTextColor(UIUtils.getColor(r171, R.color.primary_on_primary_fill));
        int r176 = UIUtils.getColor(r171, R.color.primary_fill_default);
        r173.setBackgroundColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{UIUtils.getColor(r171, R.color.udtoken_btn_se_bg_pri_pressed), r176}));
        r173.setCornerRadius(UIUtils.getDimens(r171, R.dimen.ud_radius_m));
    L226:
        r173.setOnClickListener(new com.suite.lark.platform.component.cta.newstyle.b(r173, this, r168));
        String r177 = r168.c();
        if (r177 != null) goto L229;
    L232:
        boolean r178 = true;
    L233:
        if (r178 == false) goto L238;
        String r179 = r168.b();
        if (r179 != null) goto L237;
        r179 = "";
    L237:
        r173.setText(r179);
    L239:
        r170.addView(r173);
        r105 = r105;
        r167 = r167;
        r158 = null;
        goto L218
    L238:
        Context r180 = r173.getContext();
        String r181 = r168.c();
        int r182 = UIUtils.dp2px(r173.getContext(), 20.0f);
        com.suite.lark.platform.component.cta.newstyle.a r183 = new com.suite.lark.platform.component.cta.newstyle.a(r173, r168);
        Intrinsics.checkNotNullParameter(r173, "<this>");
        Intrinsics.checkNotNullParameter(r180, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r181, "url");
        Intrinsics.checkNotNullParameter(r183, "simpleTarget");
        ImageLoader.with(r180).asDrawable().load(r181).override(r182, r182).into(new loc.c(r183));
        goto L239
    L229:
        if (r177.length() == 0) goto L232;
        r178 = false;
        goto L233
    L225:
        r173 = new UDButton(r171, null, 0, 6, null);
        r173.setClickable(true);
        r173.setMaxLines(1);
        r173.setEllipsize(TextUtils.TruncateAt.END);
        r173.setSingleLine(true);
        int r184 = UIUtils.dp2px(r171, 16.0f);
        int r185 = UIUtils.dp2px(r171, 9.0f);
        r173.setPadding(r184, r185, r184, r185);
        r173.setTextSize(17.0f);
        r173.setGravity(17);
        r173.setTextColor(UIUtils.getColor(r171, R.color.primary_content_default));
        int r186 = UIUtils.getColor(r171, R.color.udtoken_component_outlined_bg);
        r173.setBackgroundColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{UIUtils.getColor(r171, R.color.udtoken_btn_se_bg_neutral_pressed), r186}));
        r173.setCornerRadius(UIUtils.getDimens(r171, R.dimen.ud_radius_m));
        r173.setStrokeWidth(UIUtils.getDimens(r171, R.dimen.ud_border_size));
        r173.setStrokeColor(UIUtils.getColor(r171, R.color.primary_content_default));
        goto L226
    L240:
        loc.e.f510168a = new c(this);
        loc.e.f510169b = new d(this);
        return;
    L213:
        r166 = r158;
        goto L214
    L205:
        r162.connect(R.id.button_list, 3, R.id.version_info_wrapper, 4, UIUtils.dp2px(requireContext(), 24.0f));
        goto L206
    L167:
        List<goc.b.e> r187 = S90();
        Intrinsics.checkNotNullParameter(r187, "items");
        List<goc.b.e> r188 = r187;
        ArrayList r189 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r188, 10));
        Iterator<T> r190 = r188.iterator();
    L169:
        if (r190.hasNext() == false) goto L171;
        goc.b.e r191 = (goc.b.e) r190.next();
        r189.add(new joc.a(r191, r191.g()));
        goto L169
    L171:
        r157.f460547c.submitList(r189);
        goto L199
    L137:
        Iterator<T> r192 = S90().iterator();
    L139:
        if (r192.hasNext() == false) goto L158;
        goc.b.e r193 = (goc.b.e) r192.next();
        List<goc.b.C6046b> r194 = r193.a();
        if (r194 != null) goto L143;
    L146:
        boolean r195 = true;
    L147:
        if (r195 == true) goto L148;
        if (r193.g() == false) goto L139;
        this.f460534k = r193;
        BenefitListAdapter r196 = this.f460533j;
        if (r196 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("benefitListAdapter");
        r196 = null;
    L154:
        List<goc.b.C6046b> r197 = r193.a();
        if (r197 != null) goto L157;
        r197 = CollectionsKt.emptyList();
    L157:
        List<goc.b.C6046b> r198 = CollectionsKt.filterNotNull(r197);
        r196.getClass();
        Intrinsics.checkNotNullParameter(r198, "items");
        r196.f460540b.submitList(r198);
        goto L139
    L148:
        r150.setVisibility(8);
        goto L139
    L143:
        if (r194.isEmpty() == true) goto L146;
        r195 = false;
        goto L147
    L172:
        r158 = null;
        FragmentCtaDialogBinding r199 = this.f460527d;
        if (r199 != null) goto L175;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r199 = null;
    L175:
        r199.f460492d.setVisibility(0);
        int r200 = UIHelper.getWindowWidth(getContext());
        Drawable r201 = UIUtils.getDrawable(getContext(), R.drawable.illustration_specialized_cta_banner2_mobile);
        if (r201 == null) goto L178;
        int r202 = r201.getIntrinsicWidth();
    L179:
        if (r201 == null) goto L181;
        int r203 = r201.getIntrinsicHeight();
    L182:
        int r204 = (r203 * r200) / r202;
        FragmentCtaDialogBinding r205 = this.f460527d;
        if (r205 != null) goto L185;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r205 = null;
    L185:
        ImageView r206 = r205.f460492d;
        Context r1100 = requireContext();
        goc.b r1101 = this.f460529f;
        if (r1101 == null) goto L197;
        goc.b.g r1102 = r1101.b();
        if (r1102 == null) goto L197;
        goc.b.f r1103 = r1102.a();
        if (r1103 == null) goto L197;
        goc.b.c r1104 = r1103.a();
        if (r1104 == null) goto L197;
        goc.b.j r1105 = r1104.b();
        if (r1105 == null) goto L197;
        String r1106 = r1105.a();
        if (r1106 == null) goto L197;
    L198:
        joc.c r1107 = loc.e.f510168a;
        Intrinsics.checkNotNullParameter(r206, "<this>");
        Intrinsics.checkNotNullParameter(r1100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r1106, "url");
        ImageLoader.with(r1100).load(r1106).fitCenter().error(R.drawable.illustration_specialized_cta_banner2_mobile).override(r200, r204).into(new loc.d(r206));
    L197:
        r1106 = "";
        goto L198
    L181:
        r203 = 1;
        goto L182
    L178:
        r202 = 1;
    L50:
        r115 = null;
    L40:
        r110 = UIUtils.getString(getContext(), R.string.Lark_CtaCommon_UpgradeForMore_Title);
        goto L41
    L242:
        dismissAllowingStateLoss();     // Catch: Exception -> L19
    L23:
        FragmentActivity r207 = getActivity();
        if (r207 == null) goto L262;
        r207.finish();
        return;
    L262:
        return;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r208 = DialogFragmentLancet.sLastShowStack;
        if (r208 == null) goto L23;
        com.bytedance.crash.d.d(r208, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L23
    L12:
        this.f460530g = r102;
        this.f460531h = r102.getFeatureKey();
        CTAParams r209 = this.f460530g;
        if (r209 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("ctaParams");
        r209 = null;
    L15:
        this.f460532i = r209.getScene();
        r103 = true;
        goto L16
    L9:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        int r113 = koc.a.f504551a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.platform.component.cta.use_scroll_view_disabled") == true) goto L5;
        int r114 = R.layout.fragment_cta_dialog_with_scroll;
    L6:
        View r115 = r110.inflate(r114, r111, false);
        int r116 = R.id.benefit_list;
        RecyclerView r100 = (RecyclerView) ViewBindings.findChildViewById(r115, R.id.benefit_list);
        if (r100 == null) goto L27;
        r116 = R.id.button_list;
        CustomButtonGroup r101 = (CustomButtonGroup) ViewBindings.findChildViewById(r115, R.id.button_list);
        if (r101 == null) goto L27;
        r116 = R.id.cta_image;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r115, R.id.cta_image);
        if (r102 == null) goto L27;
        r116 = R.id.root_constraint_layout;
        ConstraintLayout r103 = (ConstraintLayout) ViewBindings.findChildViewById(r115, R.id.root_constraint_layout);
        if (r103 == null) goto L27;
        r116 = R.id.subtitle;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r115, R.id.subtitle);
        if (r104 == null) goto L27;
        r116 = R.id.title;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r115, R.id.title);
        if (r105 == null) goto L27;
        r116 = R.id.titlebar;
        CommonTitleBar r106 = (CommonTitleBar) ViewBindings.findChildViewById(r115, R.id.titlebar);
        if (r106 == null) goto L27;
        r116 = R.id.version_info;
        RecyclerView r107 = (RecyclerView) ViewBindings.findChildViewById(r115, R.id.version_info);
        if (r107 == null) goto L27;
        r116 = R.id.version_info_wrapper;
        LKUIRoundableLayout r117 = (LKUIRoundableLayout) ViewBindings.findChildViewById(r115, R.id.version_info_wrapper);
        if (r117 == null) goto L27;
        this.f460527d = new FragmentCtaDialogBinding((LKUIRoundableLayout) r115, r100, r101, r102, r103, r104, r105, r106, r107, r117);
        Intrinsics.checkNotNull(r115);
        return r115;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r115.getResources().getResourceName(r116)));
    L5:
        r114 = R.layout.fragment_cta_dialog;
        goto L6
    }
}
