package com.obric.assistant.privacy.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.common.mssdk.api.SecurityService;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.home.api.main.HomeService;
import com.larus.init.IImageInitiator;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.lynx.textra.PlatformFontCaps;
import com.obric.assistant.guide.IObricUserGuide;
import com.obric.assistant.interaction.base.util.DeviceUtil;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.privacy.impl.databinding.ObricActivityPrivacyAgreementExternalBinding;
import com.obric.oui.button.OButton;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.update.api.v2.ObricUpdateSettingDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 =2\u00020\u0001:\u0003=>?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0002J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\b\u0010 \u001a\u00020\u000fH\u0016J\b\u0010!\u001a\u00020\u000fH\u0016J\b\u0010\"\u001a\u00020\u000fH\u0002J\b\u0010#\u001a\u00020\u000fH\u0002J \u0010$\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0007H\u0002J\b\u0010(\u001a\u00020\u000fH\u0002J\b\u0010)\u001a\u00020\u000fH\u0002J\b\u0010*\u001a\u00020\u000fH\u0002J\b\u0010+\u001a\u00020\u000fH\u0002J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0002J \u0010/\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u00100\u001a\u00020.2\u0006\u00101\u001a\u000202H\u0002J\u0018\u00103\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u00101\u001a\u000202H\u0002J \u00104\u001a\u0002052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u00100\u001a\u00020.2\u0006\u00101\u001a\u000202H\u0002J\b\u00106\u001a\u00020\u000fH\u0016J\b\u00107\u001a\u00020\u000fH\u0016J\b\u00108\u001a\u00020\u000fH\u0016J\b\u00109\u001a\u00020\u000fH\u0002J\b\u0010:\u001a\u00020\u000fH\u0002J\u0010\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020.H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/obric/assistant/privacy/dialog/GRPrivacyDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/obric/assistant/privacy/impl/databinding/ObricActivityPrivacyAgreementExternalBinding;", "originalOrientation", "", "mConfirmClickListener", "Lcom/larus/common_ui/dialog/ConfirmClickListener;", "mCancelClickListener", "Lcom/larus/common_ui/dialog/CancelClickListener;", "workScope", "Lkotlinx/coroutines/CoroutineScope;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", WidgetCostModule.TYPE_ON_START, "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "adaptNavigationBarPadding", "onStop", "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "setupView", "setupExternalScrollFadeMask", "setupFadeMaskView", "orientation", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "fadeColor", "setupPrivacyPolicyView", "setupActionButtons", "setupWifiToggle", "setupExternalPermissionList", "getPermissionLines", "", "", "createPermissionItemView", "line", "style", "Lcom/obric/assistant/privacy/dialog/GRPrivacyDialog$PermissionListStyle;", "createPermissionBulletView", "createPermissionTextView", "Landroid/widget/TextView;", "onResume", "dismiss", "dismissAllowingStateLoss", "adaptScreenOrientationOnStart", "restoreScreenOrientationOnStop", "clickPrivacyLink", "linkUrl", "Companion", "PermissionListStyle", "Builder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GRPrivacyDialog extends DialogFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f391096i = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObricActivityPrivacyAgreementExternalBinding f391097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f391098e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p0 f391099f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.larus.common_ui.dialog.u f391100g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CoroutineScope f391101h;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnKeyListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
            if (r101 != 4) goto L6;
            return true;
        L6:
            return false;
        }
    }

    static {
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismiss() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L11
        super.dismissAllowingStateLoss();     // Catch: Exception -> L5 Throwable -> L11
    L9:
        Object r101 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L21;
        FLogger.f375446a.w("ObricPrivacyDialog", "dismissAllowingStateLoss failed. " + r102.getMessage() + ", it: " + r102);
        return;
    L21:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r103 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r103 == null) goto L9;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismissAllowingStateLoss() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L11
        super.dismissAllowingStateLoss();     // Catch: Exception -> L5 Throwable -> L11
    L9:
        Object r101 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L21;
        FLogger.f375446a.w("ObricPrivacyDialog", "dismissAllowingStateLoss failed. " + r102.getMessage() + ", it: " + r102);
        return;
    L21:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r103 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r103 == null) goto L9;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        CoroutineScopeKt.cancel$default(this.f391101h, null, 1, null);
        super.onDestroy();
        FLogger.f375446a.i("ObricPrivacyDialog", LiveCommonConstants.REASON_ON_DEDTROY);
    }

    public GRPrivacyDialog() {
        this.f391098e = -1;
        this.f391101h = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        FLogger.f375446a.i("ObricPrivacyDialog", "onDestroyView");
        this.f391097d = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r100 = ISecPrivacyService.a.a();
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.h() != true) goto L7;
    L8:
        if (r101 == false) goto L14;
        ObricActivityPrivacyAgreementExternalBinding r102 = this.f391097d;
        if (r102 == null) goto L14;
        OButton r103 = r102.f391145b;
        if (r103 == null) goto L14;
        r103.performClick();
    L14:
        final ObricActivityPrivacyAgreementExternalBinding r104 = this.f391097d;
        if (r104 != null) goto L18;
        return;
    L18:
        if (getActivity() == null) goto L21;
        r104.f391144a.post(new d(r104));
        return;
    L21:
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        FLogger r100 = FLogger.f375446a;
        r100.i("ObricPrivacyDialog", WidgetCostModule.TYPE_ON_START);
        this.f391098e = requireActivity().getRequestedOrientation();
        boolean r101 = true;
        if (DeviceUtil.INSTANCE.isHorizontalFoldable() == true) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (HomeService.f344094a.isPad() == true) goto L13;
        if (r102 == true) goto L13;
        int r103 = 1;
    L14:
        r100.i("ObricPrivacyDialog", "adaptScreenOrientationOnStart orientation: " + r103 + ", isUnfolded: " + r102);
        requireActivity().setRequestedOrientation(r103);
        Dialog r104 = getDialog();
        if (r104 == null) goto L39;
        Window r105 = r104.getWindow();
        if (r105 == null) goto L39;
        WindowCompat.setDecorFitsSystemWindows(r105, false);
        r105.setStatusBarColor(0);
        r105.setNavigationBarColor(0);
        View r106 = r105.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L23;
        r100.i("DecorViewLancet", "getDecorView");
        Thread r107 = ThreadMethodProxy.currentThread();
        if (r107 == com.larus.home.impl.utils.c.f346341a) goto L23;
        com.larus.home.impl.utils.c.a(r107, "getDecorView");
    L23:
        WindowInsetsControllerCompat r108 = WindowCompat.getInsetsController(r105, r106);
        if (r108 == null) goto L27;
        r108.show(WindowInsetsCompat.Type.systemBars());
        r108.setAppearanceLightStatusBars(true);
        r108.setAppearanceLightNavigationBars(true);
    L27:
        if (Build.VERSION.SDK_INT < 28) goto L29;
        WindowManager.LayoutParams r109 = r105.getAttributes();
        r109.layoutInDisplayCutoutMode = 1;
        r105.setAttributes(r109);
    L29:
        IObricUserGuide r110 = (IObricUserGuide) ServiceManager.get().getService(IObricUserGuide.class);
        if (r110 != null) goto L32;
    L34:
        r101 = false;
    L35:
        if (r101 == false) goto L39;
        r105.setWindowAnimations(0);
        r105.clearFlags(2);
        WindowManager.LayoutParams r111 = r105.getAttributes();
        if (r111 == null) goto L39;
        r111.dimAmount = 0.0f;
        r105.setAttributes(r111);
        goto L39
    L32:
        if (r110.d(requireContext()) != true) goto L34;
    L39:
        Dialog r112 = getDialog();
        if (r112 == null) goto L43;
        r112.setOnKeyListener(new b());
        return;
    L43:
        return;
    L13:
        r103 = 13;
        goto L14
    L5:
        if (getResources().getConfiguration().smallestScreenWidthDp < 600) goto L7;
        r102 = true;
        goto L9
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        FLogger r100 = FLogger.f375446a;
        r100.i("ObricPrivacyDialog", "onStop");
        r100.i("ObricPrivacyDialog", "restoreScreenOrientationOnStop originalOrientation: " + this.f391098e);
        requireActivity().setRequestedOrientation(this.f391098e);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        FLogger.f375446a.i("ObricPrivacyDialog", "onAttach");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        FLogger.f375446a.i("ObricPrivacyDialog", WidgetCostModule.TYPE_ON_CREATE);
        setStyle(0, R.style.ObricFullScreenDialogTheme);
        IImageInitiator r101 = (IImageInitiator) ServiceManager.get().getService(IImageInitiator.class);
        if (r101 == null) goto L6;
        r101.a();
        return;
    }

    public static final void S90(final GRPrivacyDialog r100, final String r101) {
        r100.getClass();
        SecurityService r102 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r102 == null) goto L6;
        r102.x(r100.requireActivity().getSupportFragmentManager(), new g(r101, r100));
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        FLogger.f375446a.i("ObricPrivacyDialog", "onViewCreated");
        ObricActivityPrivacyAgreementExternalBinding r112 = this.f391097d;
        if (r112 == null) goto L6;
        r112.f391152i.setUrlSpannedText(getString(R.string.obric_privacy_read_and_agree));
        r112.f391152i.setOnClickListener(new n(this));
    L6:
        ObricActivityPrivacyAgreementExternalBinding r113 = this.f391097d;
        if (r113 == null) goto L10;
        r113.f391145b.setOnClickListener(new i(this));
        r113.f391146c.setOnClickListener(new j(this));
    L10:
        ObricActivityPrivacyAgreementExternalBinding r114 = this.f391097d;
        if (r114 == null) goto L19;
        OCardListItem.h(r114.f391153j, 0);
        int r100 = rda.a.f537347a;
        rda.a.a(r114.f391153j, 0);
        OCheckBoxLayout r101 = r114.f391153j.getEndCheckBox();
        if (r101 == null) goto L16;
        r101.setChecked(ObricUpdateSettingDelegate.f404037a.a());
    L16:
        OCheckBoxLayout r115 = r114.f391153j.getEndCheckBox();
        if (r115 == null) goto L19;
        r115.setOnCheckedChangeListener(new h());
    L19:
        ObricActivityPrivacyAgreementExternalBinding r116 = this.f391097d;
        if (r116 == null) goto L29;
        LinearLayout r117 = r116.f391148e;
        r117.setBaselineAligned(false);
        r117.removeAllViews();
        List r102 = SequencesKt.toList(SequencesKt.filter(SequencesKt.map(StringsKt.lineSequence(getString(R.string.obric_privacy_other_permissions_list)), new e()), new f()));
        if (r102.isEmpty() == true) goto L29;
        Context r103 = r117.getContext();
        int r104 = ContextCompat.getColor(r103, R.color.obric_guide_text_3);
        Resources r105 = r117.getResources();
        float r106 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density;
        Typeface r107 = Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0);
        int r108 = (int) (4 * r106);
        int r109 = (int) (8 * r106);
        Intrinsics.checkNotNullParameter(r107, "typeface");
        Iterator r118 = r102.iterator();
    L27:
        if (r118.hasNext() == false) goto L29;
        String r119 = (String) r118.next();
        Intrinsics.checkNotNull(r103);
        LinearLayout r120 = new LinearLayout(r103);
        r120.setOrientation(0);
        r120.setGravity(48);
        r120.setBaselineAligned(false);
        r120.setPadding(0, r108, 0, r108);
        r120.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        View r121 = new View(r103);
        GradientDrawable r122 = new GradientDrawable();
        r122.setShape(1);
        r122.setColor(r104);
        r121.setBackground(r122);
        LinearLayout.LayoutParams r123 = new LinearLayout.LayoutParams(r108, r108);
        r123.topMargin = r109;
        r123.setMarginEnd(r109);
        r121.setLayoutParams(r123);
        r120.addView(r121);
        TextView r124 = new TextView(r103);
        r124.setText(r119);
        r124.setTypeface(r107);
        r124.setTextColor(r104);
        r124.setTextSize(12.0f);
        r124.setIncludeFontPadding(true);
        r124.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        r120.addView(r124);
        r117.addView(r120);
    L29:
        final ObricActivityPrivacyAgreementExternalBinding r125 = this.f391097d;
        if (r125 == null) goto L33;
        int r126 = ContextCompat.getColor(requireContext(), v19.c.b(R.attr.larus_base_1_overlay, requireContext(), R.color.larus_base_1_overlay));
        V90(r125.f391151h, GradientDrawable.Orientation.TOP_BOTTOM, r126);
        V90(r125.f391149f, GradientDrawable.Orientation.BOTTOM_TOP, r126);
        final Ref.BooleanRef r127 = new Ref.BooleanRef();
        final Ref.BooleanRef r128 = new Ref.BooleanRef();
        r125.f391147d.setOnScrollChangeListener(new k(r125, r127, r128));
        r125.f391147d.addOnLayoutChangeListener(new l(r125, r127, r128));
    L33:
        Context r129 = getContext();
        if (r129 == null) goto L36;
        HomeService.f344094a.Q(r129);
    L36:
        HomeService.f344094a.x(new JSONObject());
        Dialog r130 = getDialog();
        if (r130 == null) goto L41;
        r130.setCanceledOnTouchOutside(false);
        return;
    }

    public static void V90(View r100, GradientDrawable.Orientation r101, int r102) {
        r100.setBackground(new GradientDrawable(r101, new int[]{r102, 0}));
        r100.setEnabled(false);
        r100.setClickable(false);
        r100.setFocusable(false);
        r100.setImportantForAccessibility(2);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        FLogger.f375446a.i("ObricPrivacyDialog", "onCreateView");
        View r113 = r110.inflate(R.layout.obric_activity_privacy_agreement_external, r111, false);
        int r114 = R.id.button_agree;
        OButton r100 = (OButton) ViewBindings.findChildViewById(r113, R.id.button_agree);
        if (r100 == null) goto L33;
        r114 = R.id.button_disagree;
        OButton r101 = (OButton) ViewBindings.findChildViewById(r113, R.id.button_disagree);
        if (r101 == null) goto L33;
        r114 = R.id.privacy_content_scroll;
        NestedScrollView r102 = (NestedScrollView) ViewBindings.findChildViewById(r113, R.id.privacy_content_scroll);
        if (r102 == null) goto L33;
        r114 = R.id.privacy_icon;
        if (((ImageView) ViewBindings.findChildViewById(r113, R.id.privacy_icon)) == null) goto L33;
        r114 = R.id.privacy_intro_card;
        if (((LinearLayout) ViewBindings.findChildViewById(r113, R.id.privacy_intro_card)) == null) goto L33;
        r114 = R.id.privacy_other_card;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r113, R.id.privacy_other_card)) == null) goto L33;
        r114 = R.id.privacy_other_content;
        LinearLayout r103 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.privacy_other_content);
        if (r103 == null) goto L33;
        r114 = R.id.privacy_other_title;
        if (((TextView) ViewBindings.findChildViewById(r113, R.id.privacy_other_title)) == null) goto L33;
        r114 = R.id.privacy_scroll_bottom_fade;
        View r104 = ViewBindings.findChildViewById(r113, R.id.privacy_scroll_bottom_fade);
        if (r104 == null) goto L33;
        r114 = R.id.privacy_scroll_container;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.privacy_scroll_container);
        if (r105 == null) goto L33;
        r114 = R.id.privacy_scroll_top_fade;
        View r106 = ViewBindings.findChildViewById(r113, R.id.privacy_scroll_top_fade);
        if (r106 == null) goto L33;
        r114 = R.id.privacy_title;
        if (((TextView) ViewBindings.findChildViewById(r113, R.id.privacy_title)) == null) goto L33;
        r114 = R.id.tv_privacy_policy;
        UrlSpanTextView r107 = (UrlSpanTextView) ViewBindings.findChildViewById(r113, R.id.tv_privacy_policy);
        if (r107 == null) goto L33;
        r114 = R.id.wifi_section;
        OCardListItem r115 = (OCardListItem) ViewBindings.findChildViewById(r113, R.id.wifi_section);
        if (r115 == null) goto L33;
        ConstraintLayout r116 = (ConstraintLayout) r113;
        this.f391097d = new ObricActivityPrivacyAgreementExternalBinding(r116, r100, r101, r102, r103, r104, r105, r106, r107, r115);
        return r116;
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }

    public static final void T90(ObricActivityPrivacyAgreementExternalBinding r110, Ref.BooleanRef r111, Ref.BooleanRef r112, boolean r113) {
        U90(r111, r112, r110.f391151h, r110.f391147d.canScrollVertically(-1), true, r113);
        U90(r111, r112, r110.f391149f, r110.f391147d.canScrollVertically(1), false, r113);
    }

    public static final void U90(Ref.BooleanRef r100, Ref.BooleanRef r101, View r102, boolean r103, boolean r104, boolean r105) {
        if (r104 == false) goto L4;
        boolean r106 = r100.element;
    L5:
        if (r106 != r103) goto L7;
        return;
    L7:
        if (r104 == false) goto L9;
        r100.element = r103;
    L10:
        r102.animate().cancel();
        float r107 = 1.0f;
        if (r105 == false) goto L17;
        ViewPropertyAnimator r108 = r102.animate();
        if (r103 == true) goto L16;
        r107 = 0.0f;
    L16:
        r108.alpha(r107).setDuration(120).withLayer().start();
        return;
    L17:
        if (r103 == true) goto L20;
        r107 = 0.0f;
    L20:
        r102.setAlpha(r107);
        return;
    L9:
        r101.element = r103;
        goto L10
    L4:
        r106 = r101.element;
        goto L5
    }
}
