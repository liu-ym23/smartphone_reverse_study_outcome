package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.R;
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
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\b&\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u001a\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0014J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\nH\u0002J\b\u0010\u001e\u001a\u00020\nH\u0002J\b\u0010\u001f\u001a\u00020\nH\u0002J\u0006\u0010 \u001a\u00020\nJ\u0010\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0005H\u0014J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\nH\u0014J\b\u0010&\u001a\u00020\fH\u0016J\b\u0010'\u001a\u00020\fH\u0002J\b\u0010(\u001a\u00020\fH\u0002J\b\u0010)\u001a\u00020\fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/BaseForsetiCompatDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "compatRootView", "Landroid/view/View;", "originView", "exitAnim", "Landroid/view/animation/Animation;", "showAsBottomSheet", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDoCreateView", "onViewCreated", "view", "onFloatDismiss", "handleInsetsForBottomSheet", "getBottomSheetInsetsConfig", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/InsetsConfig;", "getPageType", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/PageType;", "isFloat", "isBottomSheet", "isNormal", "isInForseti", "processBottomSheetBackGroundColor", "backGroundView", "getBottomSheetAnimationId", "", "enter", "dismissAllowingStateLoss", "dismissAllowingStateLossCompat", "dismissAllowingStateLossForseti", "invokeOnDismiss", "Companion", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseForsetiCompatDialogFragment extends DialogFragment {
    public View d;
    public View e;
    public Animation f;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ BaseForsetiCompatDialogFragment a;

        public b(BaseForsetiCompatDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ FrameLayout a;
        public final /* synthetic */ BaseForsetiCompatDialogFragment b;
        public final /* synthetic */ View c;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            tt5.a.h("BaseForsetiCompatBSDF", "onGlobalLayout");
            ViewTreeObserver r0 = this.a.getViewTreeObserver();
            if (r0 == null) goto L5;
            r0.removeOnGlobalLayoutListener(this);
        L5:
            BaseForsetiCompatDialogFragment r1 = this.b;
            FrameLayout r2 = this.a;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r2, "backGroundView");
            e.b(r1, r2);
            int r3 = this.b.U90(true);
            if (r3 == 0) goto L9;
            this.c.startAnimation(AnimationUtils.loadAnimation(this.a.getContext(), r3));
            return;
        }

        public c(FrameLayout r1, BaseForsetiCompatDialogFragment r2, View r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class d implements com.ss.android.lark.api.ui.a {
        public final /* synthetic */ tua.b a;
        public final /* synthetic */ BaseForsetiCompatDialogFragment b;

        public final void a() {
            this.a.R(this.b, this);
            this.b.Y90();
        }

        public d(tua.b r1, BaseForsetiCompatDialogFragment r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public abstract View X90(LayoutInflater r1, ViewGroup r2);

    public void Y90() {
    }

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
        boolean r1 = true;
        if ((!getShowsDialog()) == true) goto L5;
        S90(this);
        return;
    L5:
        if (W90() == false) goto L15;
        if (com.suite.lark.component.navroute.forseti.f.b(this) == null) goto L15;
        com.suite.lark.component.navroute.forseti.g r0 = com.suite.lark.component.navroute.forseti.f.b(this);     // Catch: Throwable -> L12
        if (r0 == null) goto L40;
        r0.g(null);     // Catch: Throwable -> L12
        return;
    L40:
        return;
    L12:
        th = move-exception;
        tt5.a.e("BaseForsetiCompatBSDF", "forseti goBack error!", th, false);
        return;
    L15:
        if (V90() != PageType.NORMAL) goto L17;
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        S90(this);
        return;
    L21:
        if (V90() == PageType.BOTTOM_SHEET) goto L24;
        r1 = false;
    L24:
        if (r1 == false) goto L35;
        int r3 = U90(false);
        if (r3 != 0) goto L29;
        S90(this);
        return;
    L29:
        if (this.f != null) goto L47;
        Animation r4 = AnimationUtils.loadAnimation(requireContext(), r3);
        r4.setAnimationListener(new com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.c(this));
        View r5 = this.e;
        if (r5 == null) goto L34;
        r5.startAnimation(r4);
    L34:
        this.f = r4;
        return;
    L47:
        return;
    L35:
        tt5.a.k("BaseForsetiCompatBSDF", "dismiss unexpected!");
        S90(this);
        return;
    L17:
        r2 = false;
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

    public static void S90(DialogFragment r1) {
        super.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final int U90(boolean r9) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        tt5.a.h("DialogFragmentHelper", "getEnterAnimFromTheme, enter: " + r9);
        if (r9 == false) goto L5;
        int r0 = 2130772647;
    L6:
        Resources.Theme r2 = e.a(this);
        if (r2 != null) goto L9;
        tt5.a.d("DialogFragmentHelper", "theme is null!");
        return r0;
    L9:
        if (r9 == false) goto L11;
        int r10 = R.attr.windowEnterAnimation;
    L12:
        int r3 = 0;
        TypedArray r5 = r2.obtainStyledAttributes(new int[]{r10});     // Catch: Throwable -> L52
        Intrinsics.checkNotNull(r5);
        int r6 = r5.getResourceId(0, 0);     // Catch: Throwable -> L17
        r5.recycle();
    L20:
        if (r6 == 0) goto L63;
        tt5.a.h("DialogFragmentHelper", "return from windowEnterAnimation");
        return r6;
    L63:
        TypedArray r7 = r2.obtainStyledAttributes(new int[]{R.attr.windowAnimationStyle});     // Catch: Throwable -> L47
        Intrinsics.checkNotNull(r7);
        int r8 = r7.getResourceId(0, 0);     // Catch: Throwable -> L26
        r7.recycle();
    L65:
        TypedArray r11 = r2.obtainStyledAttributes(r8, new int[]{r10});     // Catch: Throwable -> L42
        Intrinsics.checkNotNull(r11);
        r3 = r11.getResourceId(0, 0);     // Catch: Throwable -> L33
    L35:
        r11.recycle();
        if (r3 == 0) goto L38;
        tt5.a.h("DialogFragmentHelper", "return from windowAnimationStyle");
        return r3;
    L38:
        tt5.a.h("DialogFragmentHelper", "return default");
        return r0;
    L33:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "get animId2 failed!", th, false);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        r11.recycle();
        throw th;
    L42:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "obtain animation from windowAnimationStyle failed!", th, false);
        return r0;
    L26:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "get animStyleId failed!", th, false);     // Catch: Throwable -> L44
        r7.recycle();
        r8 = 0;
    L44:
        th = move-exception;
        r7.recycle();
        throw th;
    L47:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "obtain windowAnimationStyle failed!", th, false);
        return r0;
    L17:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "get animId failed!", th, false);     // Catch: Throwable -> L49
        r5.recycle();
        r6 = 0;
    L49:
        th = move-exception;
        r5.recycle();
        throw th;
    L52:
        th = move-exception;
        tt5.a.e("DialogFragmentHelper", "obtain animation failed!", th, false);
        return r0;
    L11:
        r10 = R.attr.windowExitAnimation;
        goto L12
    L5:
        r0 = 2130772648;
        goto L6
    }

    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        boolean r0 = true;
        if ((!getShowsDialog()) == true) goto L5;
        return;
    L5:
        if (V90() == PageType.BOTTOM_SHEET) goto L8;
        r0 = false;
    L8:
        if (r0 == false) goto L12;
        o.a r5 = new o.a();
        r5.b = false;
        r5.a = false;
        r5.c = false;
        o r6 = r5.a();
        com.ss.android.lark.insets.f r1 = WindowInsetsUtils.b(this);
        r1.c(r6.a);
        r1.o(r6.b);
        r1.f(r6.c);
        r1.b(0);
        r1.i(r6.e);
        return;
    }

    public void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        if ((!getShowsDialog()) == true) goto L5;
        return;
    L5:
        if (W90() == true) goto L7;
        return;
    L7:
        if (r3.getBackground() != null) goto L9;
        r3.setBackgroundColor(ContextCompat.getColor(r3.getContext(), 2131100548));
    L9:
        h.a(r3);
        if (r3.isClickable() == true) goto L12;
        r3.setClickable(true);
    L12:
        sua.a r5 = (sua.a) ApiUtils.getApi(sua.a.class);
        if (r5 == null) goto L20;
        tua.b r6 = r5.tryGetChainManager(getActivity());
        if (r6 == null) goto L21;
        r6.u(this, new d(r6, this));
        return;
    L21:
        return;
    }

    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        tt5.a.h("BaseForsetiCompatBSDF", "onCreateView");
        View r7 = X90(r4, r5);
        if (r7 != null) goto L6;
        return null;
    L6:
        this.e = r7;
        if ((!getShowsDialog()) == true) goto L9;
    L27:
        this.d = r7;
        return r7;
    L9:
        if (V90() != PageType.BOTTOM_SHEET) goto L11;
        boolean r8 = true;
    L12:
        if (r8 == false) goto L27;
        if (r7.isClickable() == true) goto L17;
        r7.setClickable(true);
    L17:
        if (r7.getFitsSystemWindows() == false) goto L19;
        r7.setFitsSystemWindows(false);
    L19:
        FrameLayout r9 = new FrameLayout(r4.getContext());
        r9.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r9.setOnClickListener(new b(this));
        ViewTreeObserver r10 = r9.getViewTreeObserver();
        if (r10 == null) goto L22;
        r10.addOnGlobalLayoutListener(new c(r9, this, r7));
    L22:
        r9.addView(r7);
        ViewGroup.LayoutParams r11 = r7.getLayoutParams();
        if (r11 == null) goto L26;
        FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) r11;
        r12.gravity = 81;
        r7.setLayoutParams(r12);
        r7 = r9;
        goto L27
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L11:
        r8 = false;
        goto L12
    }
}
