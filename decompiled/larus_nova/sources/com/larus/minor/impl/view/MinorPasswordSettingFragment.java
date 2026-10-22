package com.larus.minor.impl.view;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.utils.x1;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common_ui.widget.SeparatedEditText;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.minor.impl.databinding.LarusPageMinorPasswordBinding;
import com.larus.minor.impl.viewmodel.MinorPasswordViewModel;
import com.larus.nova.R;
import com.larus.platform.service.e2;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.obric.assistant.spi.security.minormode.IObricMinorModeService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Arrays;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import v19.i5;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\u001dH\u0016J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u0012H\u0002J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u0015H\u0002J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u001dH\u0002J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020-H\u0002J\b\u00100\u001a\u00020\u001dH\u0002J\u001a\u00101\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u00102\u001a\u00020\u001dH\u0002J\b\u00103\u001a\u00020\u001dH\u0016J\b\u00104\u001a\u00020\u001dH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/minor/impl/view/MinorPasswordSettingFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/minor/impl/databinding/LarusPageMinorPasswordBinding;", "viewModel", "Lcom/larus/minor/impl/viewmodel/MinorPasswordViewModel;", "getViewModel", "()Lcom/larus/minor/impl/viewmodel/MinorPasswordViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "imeManager", "Lcom/larus/bmhome/utils/ImeManager;", "lastClickTime", "", "gapClick", "useImeWatch", "", "hasTraceClick", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initViews", "", "safeDismiss", "getTitleString", "", "onResume", "refreshViewState", "state", "Lcom/larus/minor/impl/model/PasswordState;", "isQuickClick", "openFeedbackLink", "view", "getTheme", "", "initViewModel", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "adaptViewWidthForPad", "configuration", "updateInset", "onViewCreated", "setupLandscape", "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MinorPasswordSettingFragment extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f359235k = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusPageMinorPasswordBinding f359236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f359237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public x1 f359238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f359239g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f359240h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f359241i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f359242j;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f359243a;

        public b(com.larus.minor.impl.view.b r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f359243a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f359243a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f359243a.invoke(r100);
        }
    }

    static {
    }

    public final String T90() {
        if (z2.f365865a.I() != 1) goto L7;
        Context r100 = getContext();
        if (r100 != null) goto L12;
        return null;
    L12:
        return r100.getString(R.string.larus_teenagerMode_modeName_parent_cn);
    L7:
        Context r101 = getContext();
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.getString(R.string.larus_teenagerMode_modeName_teenager_cn);
    }

    public final MinorPasswordViewModel U90() {
        return (MinorPasswordViewModel) this.f359237e.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        if (this.f359241i == false) goto L5;
        return R.style.BottomSheetTransparentDialogNoAni;
    L5:
        return R.style.BottomSheetTransparentDialogNoAniAdjustResize;
    }

    public MinorPasswordSettingFragment() {
        this.f359237e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MinorPasswordViewModel.class), new MinorPasswordSettingFragment$special$$inlined$activityViewModels$default$1(this), new MinorPasswordSettingFragment$special$$inlined$activityViewModels$default$2(this));
        this.f359240h = 500;
        if (Build.VERSION.SDK_INT <= 29) goto L5;
        boolean r100 = true;
    L6:
        this.f359241i = r100;
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        IObricMinorModeService r100 = (IObricMinorModeService) ServiceManager.get().getService(IObricMinorModeService.class);
        if (r100 == null) goto L6;
        r100.f();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        LarusPageMinorPasswordBinding r100 = this.f359236d;
        if (r100 == null) goto L7;
        SeparatedEditText r101 = r100.f359195c;
        if (r101 == null) goto L7;
        x1 r102 = new x1(r101);
    L8:
        this.f359238f = r102;
        LarusPageMinorPasswordBinding r103 = this.f359236d;
        if (r103 == null) goto L14;
        ChatConstraintLayout r104 = r103.f359200h;
        if (r104 == null) goto L15;
        r104.postDelayed(new h(this), 100);
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r102 = null;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
    }

    public final void S90(Configuration r100) {
        if (e2.f365734a.isPad() == true) goto L6;
        return;
    L6:
        if (r100.orientation != 2) goto L52;
        LarusPageMinorPasswordBinding r101 = this.f359236d;
        if (r101 == null) goto L16;
        SeparatedEditText r102 = r101.f359195c;
        if (r102 == null) goto L16;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L15;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
        r104.topMargin = i5.q();
        r102.setLayoutParams(r104);
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L16:
        LarusPageMinorPasswordBinding r105 = this.f359236d;
        if (r105 == null) goto L25;
        Button r106 = r105.f359201i;
        if (r106 == null) goto L25;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if (r107 == null) goto L24;
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
        r108.topMargin = i5.q();
        r106.setLayoutParams(r108);
        goto L25
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L25:
        LarusPageMinorPasswordBinding r109 = this.f359236d;
        if (r109 == null) goto L34;
        Button r110 = r109.f359199g;
        if (r110 == null) goto L34;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if (r111 == null) goto L33;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
        r112.topMargin = i5.q();
        r110.setLayoutParams(r112);
        goto L34
    L33:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L34:
        LarusPageMinorPasswordBinding r113 = this.f359236d;
        if (r113 == null) goto L43;
        Button r114 = r113.f359194b;
        if (r114 == null) goto L43;
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
        if (r115 == null) goto L42;
        ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) r115;
        r116.topMargin = i5.q();
        r114.setLayoutParams(r116);
        goto L43
    L42:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L43:
        LarusPageMinorPasswordBinding r117 = this.f359236d;
        if (r117 == null) goto L97;
        TextView r118 = r117.f359198f;
        if (r118 == null) goto L97;
        ViewGroup.LayoutParams r119 = r118.getLayoutParams();
        if (r119 == null) goto L51;
        ViewGroup.MarginLayoutParams r120 = (ViewGroup.MarginLayoutParams) r119;
        r120.topMargin = i5.q();
        r118.setLayoutParams(r120);
        goto L97
    L51:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L97:
        LarusPageMinorPasswordBinding r121 = this.f359236d;
        if (r121 == null) goto L103;
        ChatConstraintLayout r122 = r121.f359200h;
        if (r122 == null) goto L104;
        r122.postDelayed(new g(this), 200);
        return;
    L104:
        return;
    L103:
        return;
    L52:
        LarusPageMinorPasswordBinding r123 = this.f359236d;
        if (r123 == null) goto L61;
        SeparatedEditText r124 = r123.f359195c;
        if (r124 == null) goto L61;
        ViewGroup.LayoutParams r125 = r124.getLayoutParams();
        if (r125 == null) goto L60;
        ViewGroup.MarginLayoutParams r126 = (ViewGroup.MarginLayoutParams) r125;
        r126.topMargin = i5.E();
        r124.setLayoutParams(r126);
        goto L61
    L60:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L61:
        LarusPageMinorPasswordBinding r127 = this.f359236d;
        if (r127 == null) goto L70;
        Button r128 = r127.f359201i;
        if (r128 == null) goto L70;
        ViewGroup.LayoutParams r129 = r128.getLayoutParams();
        if (r129 == null) goto L69;
        ViewGroup.MarginLayoutParams r130 = (ViewGroup.MarginLayoutParams) r129;
        r130.topMargin = i5.l0();
        r128.setLayoutParams(r130);
        goto L70
    L69:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L70:
        LarusPageMinorPasswordBinding r131 = this.f359236d;
        if (r131 == null) goto L79;
        Button r132 = r131.f359199g;
        if (r132 == null) goto L79;
        ViewGroup.LayoutParams r133 = r132.getLayoutParams();
        if (r133 == null) goto L78;
        ViewGroup.MarginLayoutParams r134 = (ViewGroup.MarginLayoutParams) r133;
        r134.topMargin = i5.l0();
        r132.setLayoutParams(r134);
        goto L79
    L78:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L79:
        LarusPageMinorPasswordBinding r135 = this.f359236d;
        if (r135 == null) goto L88;
        Button r136 = r135.f359194b;
        if (r136 == null) goto L88;
        ViewGroup.LayoutParams r137 = r136.getLayoutParams();
        if (r137 == null) goto L87;
        ViewGroup.MarginLayoutParams r138 = (ViewGroup.MarginLayoutParams) r137;
        r138.topMargin = i5.l0();
        r136.setLayoutParams(r138);
        goto L88
    L87:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L88:
        LarusPageMinorPasswordBinding r139 = this.f359236d;
        if (r139 == null) goto L97;
        TextView r140 = r139.f359198f;
        if (r140 == null) goto L97;
        ViewGroup.LayoutParams r141 = r140.getLayoutParams();
        if (r141 == null) goto L96;
        ViewGroup.MarginLayoutParams r142 = (ViewGroup.MarginLayoutParams) r141;
        r142.topMargin = i5.h0();
        r140.setLayoutParams(r142);
        goto L97
    L96:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        if (e2.f365734a.isPad() == true) goto L5;
        return;
    L5:
        S90(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Dialog r102 = getDialog();
        final View r103 = null;
        if ((r102 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r104 = (BottomSheetDialog) r102;
    L6:
        if (r104 == null) goto L8;
        r103 = r104.findViewById(R.id.design_bottom_sheet);
    L8:
        Dialog r105 = getDialog();
        if (r105 == null) goto L11;
        r105.setOnShowListener(new j(r103));
    L11:
        S90(getResources().getConfiguration());
        Dialog r106 = getDialog();
        if (r106 == null) goto L15;
        r106.setOnDismissListener(new i(this));
    L15:
        if (this.f359241i == false) goto L22;
        LarusPageMinorPasswordBinding r107 = this.f359236d;
        if (r107 == null) goto L23;
        View r108 = r107.f359202j;
        if (r108 == null) goto L24;
        e1.o(r108);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L5:
        r104 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [com.larus.minor.impl.view.b] */
    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r210, ViewGroup r211, Bundle r212) {
        Intrinsics.checkNotNullParameter(r210, "inflater");
        View r100 = r210.inflate(R.layout.larus_page_minor_password, r211, false);
        int r101 = R.id.checkbox_minor_mode_disclaimer_stub;
        ViewStub r102 = (ViewStub) ViewBindings.findChildViewById(r100, R.id.checkbox_minor_mode_disclaimer_stub);
        if (r102 == null) goto L55;
        r101 = R.id.close_btn;
        ImageView r110 = (ImageView) ViewBindings.findChildViewById(r100, R.id.close_btn);
        if (r110 == null) goto L55;
        r101 = R.id.confirm_btn;
        Button r111 = (Button) ViewBindings.findChildViewById(r100, R.id.confirm_btn);
        if (r111 == null) goto L55;
        r101 = R.id.edit_solid;
        SeparatedEditText r112 = (SeparatedEditText) ViewBindings.findChildViewById(r100, R.id.edit_solid);
        if (r112 == null) goto L55;
        r101 = R.id.feedback_message;
        UrlSpanTextView r113 = (UrlSpanTextView) ViewBindings.findChildViewById(r100, R.id.feedback_message);
        if (r113 == null) goto L55;
        r101 = R.id.minor_sub_title;
        TextView r114 = (TextView) ViewBindings.findChildViewById(r100, R.id.minor_sub_title);
        if (r114 == null) goto L55;
        r101 = R.id.minor_title;
        TextView r115 = (TextView) ViewBindings.findChildViewById(r100, R.id.minor_title);
        if (r115 == null) goto L55;
        r101 = R.id.pre_step;
        Button r116 = (Button) ViewBindings.findChildViewById(r100, R.id.pre_step);
        if (r116 == null) goto L55;
        ChatConstraintLayout r103 = (ChatConstraintLayout) r100;
        Button r104 = (Button) ViewBindings.findChildViewById(r100, R.id.set_password);
        if (r104 == null) goto L53;
        View r117 = ViewBindings.findChildViewById(r100, R.id.splitter);
        if (r117 == null) goto L52;
        this.f359236d = new LarusPageMinorPasswordBinding(r103, r102, r110, r111, r112, r113, r114, r115, r116, r103, r104, r117);
        Context r105 = getContext();
        if (r105 == null) goto L26;
        if (r103 == null) goto L26;
        r103.k6(r105);
    L26:
        r112.setWidth(i5.I());
        r112.setMaxLength(4);
        r112.setTextChangedListener(new k(this));
        e1.d(r104, new c(this));
        e1.d(r116, new d(this));
        e1.d(r111, new e(this));
        e1.d(r110, new f(this));
        String r106 = T90();
        Context r107 = getContext();
        if (r107 == null) goto L30;
        String r108 = r107.getString(R.string.larus_teenagerMode_createParentPasscode_desc_cn);
        if (r108 == null) goto L30;
    L31:
        StringCompanionObject r109 = StringCompanionObject.INSTANCE;
        boolean r118 = true;
        r114.setText(String.format(r108, Arrays.copyOf(new Object[]{r106}, 1)));
        IObricMinorModeService r119 = (IObricMinorModeService) ServiceManager.get().getService(IObricMinorModeService.class);
        if (r119 != null) goto L34;
    L36:
        r118 = false;
    L37:
        if (r118 == false) goto L39;
        r119.b(requireContext(), r102);
    L39:
        MinorPasswordViewModel r120 = U90();
        if (r120 == null) goto L44;
        LiveData<wk9.b> r121 = r120.getCurrentState();
        if (r121 == null) goto L44;
        r121.observe(getViewLifecycleOwner(), new b(new com.larus.minor.impl.view.b(this)));
    L44:
        MinorPasswordViewModel r122 = U90();
        if (r122 == null) goto L47;
        r122.initState();
    L47:
        LarusPageMinorPasswordBinding r123 = this.f359236d;
        if (r123 != null) goto L56;
        return null;
    L56:
        return r123.f359200h;
    L34:
        if (r119.a() != true) goto L36;
    L30:
        r108 = "";
        goto L31
    L52:
        r101 = R.id.splitter;
        goto L55
    L53:
        r101 = R.id.set_password;
    L55:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }
}
