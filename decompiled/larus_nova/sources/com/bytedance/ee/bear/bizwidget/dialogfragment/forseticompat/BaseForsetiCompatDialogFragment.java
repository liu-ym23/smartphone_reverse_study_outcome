package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\b&\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u001a\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0014J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\nH\u0002J\b\u0010\u001e\u001a\u00020\nH\u0002J\b\u0010\u001f\u001a\u00020\nH\u0002J\u0006\u0010 \u001a\u00020\nJ\u0010\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0005H\u0014J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\nH\u0014J\b\u0010&\u001a\u00020\fH\u0016J\b\u0010'\u001a\u00020\fH\u0002J\b\u0010(\u001a\u00020\fH\u0002J\b\u0010)\u001a\u00020\fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/BaseForsetiCompatDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "compatRootView", "Landroid/view/View;", "originView", "exitAnim", "Landroid/view/animation/Animation;", "showAsBottomSheet", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onDoCreateView", "onViewCreated", "view", "onFloatDismiss", "handleInsetsForBottomSheet", "getBottomSheetInsetsConfig", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/InsetsConfig;", "getPageType", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/PageType;", "isFloat", "isBottomSheet", "isNormal", "isInForseti", "processBottomSheetBackGroundColor", "backGroundView", "getBottomSheetAnimationId", "", "enter", "dismissAllowingStateLoss", "dismissAllowingStateLossCompat", "dismissAllowingStateLossForseti", "invokeOnDismiss", "Companion", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseForsetiCompatDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f216425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f216426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Animation f216427f;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseForsetiCompatDialogFragment f216428a;

        public b(BaseForsetiCompatDialogFragment r100) {
            this.f216428a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f216428a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f216429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseForsetiCompatDialogFragment f216430b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f216431c;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            tt5.a.h("BaseForsetiCompatBSDF", "onGlobalLayout");
            ViewTreeObserver r100 = this.f216429a.getViewTreeObserver();
            if (r100 == null) goto L5;
            r100.removeOnGlobalLayoutListener(this);
        L5:
            BaseForsetiCompatDialogFragment r101 = this.f216430b;
            FrameLayout r102 = this.f216429a;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, "backGroundView");
            e.b(r101, r102);
            int r103 = this.f216430b.U90(true);
            if (r103 == 0) goto L9;
            this.f216431c.startAnimation(AnimationUtils.loadAnimation(this.f216429a.getContext(), r103));
            return;
        }

        public c(FrameLayout r100, BaseForsetiCompatDialogFragment r101, View r102) {
            this.f216429a = r100;
            this.f216430b = r101;
            this.f216431c = r102;
        }
    }

    public static final class d implements com.ss.android.lark.api.ui.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ tua.b f216432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseForsetiCompatDialogFragment f216433b;

        @Override // com.ss.android.lark.api.ui.a
        public final void a() {
            this.f216432a.R(this.f216433b, this);
            this.f216433b.Y90();
        }

        public d(tua.b r100, BaseForsetiCompatDialogFragment r101) {
            this.f216432a = r100;
            this.f216433b = r101;
        }
    }

    static {
    }

    public abstract View X90(LayoutInflater r100, ViewGroup r101);

    public void Y90() {
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
    L8:
        th = move-exception;
        tt5.a.f("BaseForsetiCompatBSDF", th, false);
        iu5.d.a("BaseForsetiCompatBSDF_dismissIgnoreErr()", th);
        return;
    L4:
        if (isAdded() == false) goto L6;
        T90();     // Catch: Throwable -> L8
    L11:
        return;
    L6:
        tt5.a.d("BaseForsetiCompatBSDF", "fragment is not add");     // Catch: Throwable -> L8
        goto L11
    }

    private final void T90() {
        boolean r100 = true;
        if ((!getShowsDialog()) == true) goto L5;
        S90(this);
        return;
    L5:
        if (W90() == false) goto L15;
        if (com.suite.lark.component.navroute.forseti.f.b(this) == null) goto L15;
        com.suite.lark.component.navroute.forseti.g r101 = com.suite.lark.component.navroute.forseti.f.b(this);     // Catch: Throwable -> L12
        if (r101 == null) goto L40;
        r101.g(null);     // Catch: Throwable -> L12
        return;
    L40:
        return;
    L12:
        th = move-exception;
        tt5.a.e("BaseForsetiCompatBSDF", "forseti goBack error!", th, false);
        return;
    L15:
        if (V90() != PageType.NORMAL) goto L17;
        boolean r102 = true;
    L18:
        if (r102 == false) goto L21;
        S90(this);
        return;
    L21:
        if (V90() == PageType.BOTTOM_SHEET) goto L24;
        r100 = false;
    L24:
        if (r100 == false) goto L35;
        int r103 = U90(false);
        if (r103 != 0) goto L29;
        S90(this);
        return;
    L29:
        if (this.f216427f != null) goto L47;
        Animation r104 = AnimationUtils.loadAnimation(requireContext(), r103);
        r104.setAnimationListener(new com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.c(this));
        View r105 = this.f216426e;
        if (r105 == null) goto L34;
        r105.startAnimation(r104);
    L34:
        this.f216427f = r104;
        return;
    L47:
        return;
    L35:
        tt5.a.k("BaseForsetiCompatBSDF", "dismiss unexpected!");
        S90(this);
        return;
    L17:
        r102 = false;
        goto L18
    }

    private final boolean W90() {
        if (V90() != PageType.FLOAT) goto L5;
        return true;
    L5:
        return false;
    }

    public BaseForsetiCompatDialogFragment() {
    }

    public PageType V90() {
        return PageType.FLOAT;
    }

    public static void S90(DialogFragment r100) {
        super.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final int U90(boolean r100) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        tt5.a.h("DialogFragmentHelper", "getEnterAnimFromTheme, enter: " + r100);
        if (r100 == false) goto L5;
        int r101 = R.anim.spacekit_anim_action_sheet_in;
    L6:
        Resources.Theme r102 = e.a(this);
        if (r102 != null) goto L9;
        tt5.a.d("DialogFragmentHelper", "theme is null!");
        return r101;
    L9:
        if (r100 == false) goto L11;
        int r103 = android.R.attr.windowEnterAnimation;
    L12:
        int r104 = 0;
        TypedArray r105 = r102.obtainStyledAttributes(new int[]{r103});     // Catch: Throwable -> L52
        Intrinsics.checkNotNull(r105);
        int r106 = r105.getResourceId(0, 0);     // Catch: Throwable -> L17
        r105.recycle();
    L20:
        if (r106 == 0) goto L63;
        tt5.a.h("DialogFragmentHelper", "return from windowEnterAnimation");
        return r106;
    L63:
        TypedArray r107 = r102.obtainStyledAttributes(new int[]{android.R.attr.windowAnimationStyle});     // Catch: Throwable -> L47
        Intrinsics.checkNotNull(r107);
        int r108 = r107.getResourceId(0, 0);     // Catch: Throwable -> L26
        r107.recycle();
    L65:
        TypedArray r109 = r102.obtainStyledAttributes(r108, new int[]{r103});     // Catch: Throwable -> L42
        Intrinsics.checkNotNull(r109);
        r104 = r109.getResourceId(0, 0);     // Catch: Throwable -> L33
    L35:
        r109.recycle();
        if (r104 == 0) goto L38;
        tt5.a.h("DialogFragmentHelper", "return from windowAnimationStyle");
        return r104;
    L38:
        tt5.a.h("DialogFragmentHelper", "return default");
        return r101;
    L33:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "get animId2 failed!", th, false);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        r109.recycle();
        throw th;
    L42:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "obtain animation from windowAnimationStyle failed!", th, false);
        return r101;
    L26:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "get animStyleId failed!", th, false);     // Catch: Throwable -> L44
        r107.recycle();
        r108 = 0;
    L44:
        th = move-exception;
        r107.recycle();
        throw th;
    L47:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "obtain windowAnimationStyle failed!", th, false);
        return r101;
    L17:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "get animId failed!", th, false);     // Catch: Throwable -> L49
        r105.recycle();
        r106 = 0;
    L49:
        th = move-exception;
        r105.recycle();
        throw th;
    L52:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "obtain animation failed!", th, false);
        return r101;
    L11:
        r103 = android.R.attr.windowExitAnimation;
        goto L12
    L5:
        r101 = R.anim.spacekit_anim_action_sheet_out;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        boolean r101 = true;
        if ((!getShowsDialog()) == true) goto L5;
        return;
    L5:
        if (V90() == PageType.BOTTOM_SHEET) goto L8;
        r101 = false;
    L8:
        if (r101 == false) goto L12;
        o.a r102 = new o.a();
        r102.f216482b = false;
        r102.f216481a = false;
        r102.f216483c = false;
        o r103 = r102.a();
        com.ss.android.lark.insets.f r104 = WindowInsetsUtils.b(this);
        r104.c(r103.f216476a);
        r104.o(r103.f216477b);
        r104.f(r103.f216478c);
        r104.b(0);
        r104.i(r103.f216480e);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        if ((!getShowsDialog()) == true) goto L5;
        return;
    L5:
        if (W90() == true) goto L7;
        return;
    L7:
        if (r100.getBackground() != null) goto L9;
        r100.setBackgroundColor(ContextCompat.getColor(r100.getContext(), R.color.bg_body));
    L9:
        h.a(r100);
        if (r100.isClickable() == true) goto L12;
        r100.setClickable(true);
    L12:
        sua.a r102 = (sua.a) ApiUtils.getApi(sua.a.class);
        if (r102 == null) goto L20;
        tua.b r103 = r102.tryGetChainManager(getActivity());
        if (r103 == null) goto L21;
        r103.u(this, new d(r103, this));
        return;
    L21:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        tt5.a.h("BaseForsetiCompatBSDF", "onCreateView");
        View r103 = X90(r100, r101);
        if (r103 != null) goto L6;
        return null;
    L6:
        this.f216426e = r103;
        if ((!getShowsDialog()) == true) goto L9;
    L27:
        this.f216425d = r103;
        return r103;
    L9:
        if (V90() != PageType.BOTTOM_SHEET) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L27;
        if (r103.isClickable() == true) goto L17;
        r103.setClickable(true);
    L17:
        if (r103.getFitsSystemWindows() == false) goto L19;
        r103.setFitsSystemWindows(false);
    L19:
        FrameLayout r105 = new FrameLayout(r100.getContext());
        r105.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r105.setOnClickListener(new b(this));
        ViewTreeObserver r106 = r105.getViewTreeObserver();
        if (r106 == null) goto L22;
        r106.addOnGlobalLayoutListener(new c(r105, this, r103));
    L22:
        r105.addView(r103);
        ViewGroup.LayoutParams r107 = r103.getLayoutParams();
        if (r107 == null) goto L26;
        FrameLayout.LayoutParams r108 = (FrameLayout.LayoutParams) r107;
        r108.gravity = 81;
        r103.setLayoutParams(r108);
        r103 = r105;
        goto L27
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L11:
        r104 = false;
        goto L12
    }
}
