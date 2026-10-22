package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0014J&\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0005H\u0014J\b\u0010!\u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020\tH\u0002J\b\u0010#\u001a\u00020\tH\u0002J\b\u0010$\u001a\u00020\tH\u0002J\b\u0010%\u001a\u00020&H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/BaseForsetiCompatBottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "compatRootView", "Landroid/view/View;", "bottomBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onFloatDismiss", "onDoCreateView", "handleInsetsForBottomSheet", "getBottomSheetInsetsConfig", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/InsetsConfig;", "getPageType", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/PageType;", "isFloat", "", "isBottomSheet", "isNormal", "isInForseti", "processBackGroundColor", "backGroundView", "dismissAllowingStateLoss", "dismissAllowingStateLossCompat", "dismissAllowingStateLossForseti", "invokeOnDismiss", "providePeekHeight", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/BaseForsetiCompatBottomSheetDialogFragment$PeekHeight;", "Companion", "PeekHeight", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseForsetiCompatBottomSheetDialogFragment extends BottomSheetDialogFragment {
    public View d;
    public BottomSheetBehavior<? extends View> e;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ BaseForsetiCompatBottomSheetDialogFragment a;

        public b(BaseForsetiCompatBottomSheetDialogFragment r1) {
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

    public static final class c extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ BaseForsetiCompatBottomSheetDialogFragment a;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "p0");
        }

        public c(BaseForsetiCompatBottomSheetDialogFragment r1) {
            this.a = r1;
        }

        public final void onStateChanged(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            if (r3 != 5) goto L6;
            BaseForsetiCompatBottomSheetDialogFragment.S90(this.a);
            BaseForsetiCompatBottomSheetDialogFragment r4 = this.a;
            r4.getClass();
            r4.onDismiss(new com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.b());
            return;
        }
    }

    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ BottomSheetBehavior<RecyclerView> a;
        public final /* synthetic */ BaseForsetiCompatBottomSheetDialogFragment b;
        public final /* synthetic */ FrameLayout c;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            tt5.a.h("BaseForsetiCompatBSDF", "onGlobalLayout");
            this.a.setState(4);
            View r0 = this.b.d;
            if (r0 == null) goto L7;
            ViewTreeObserver r1 = r0.getViewTreeObserver();
            if (r1 == null) goto L7;
            r1.removeOnGlobalLayoutListener(this);
        L7:
            BaseForsetiCompatBottomSheetDialogFragment r2 = this.b;
            FrameLayout r3 = this.c;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r3, "backGroundView");
            com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.e.b(r2, r3);
        }

        public d(BottomSheetBehavior<RecyclerView> r1, BaseForsetiCompatBottomSheetDialogFragment r2, FrameLayout r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class e implements com.ss.android.lark.api.ui.a {
        public final /* synthetic */ tua.b a;
        public final /* synthetic */ BaseForsetiCompatBottomSheetDialogFragment b;

        public final void a() {
            this.a.R(this.b, this);
            this.b.W90();
        }

        public e(tua.b r1, BaseForsetiCompatBottomSheetDialogFragment r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public abstract View V90(LayoutInflater r1, ViewGroup r2);

    public void W90() {
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

    public final void T90() {
        if (U90() == false) goto L34;
        PageType r0 = PageType.NORMAL;
        boolean r1 = false;
        if (com.suite.lark.component.navroute.forseti.f.b(this) != null) goto L36;
        PageType r2 = PageType.FLOAT;
        if (r2 != PageType.NORMAL) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L19;
        S90(this);
        return;
    L19:
        if (r2 != PageType.BOTTOM_SHEET) goto L21;
        boolean r4 = true;
    L22:
        if (r4 == false) goto L33;
        BottomSheetBehavior<? extends View> r5 = this.e;
        if (r5 != null) goto L26;
    L32:
        S90(this);
        onDismiss(new com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.b());
        return;
    L26:
        if (r5.getState() != 5) goto L28;
        r1 = true;
    L28:
        if (r1 == true) goto L32;
        BottomSheetBehavior<? extends View> r6 = this.e;
        if (r6 == null) goto L41;
        r6.setState(5);
        return;
    L41:
        return;
    L33:
        tt5.a.k("BaseForsetiCompatBSDF", "dismiss unexpected!");
        S90(this);
        return;
    L21:
        r4 = false;
        goto L22
    L15:
        r3 = false;
        goto L16
    L36:
        com.suite.lark.component.navroute.forseti.g r7 = com.suite.lark.component.navroute.forseti.f.b(this);     // Catch: Throwable -> L10
        if (r7 == null) goto L38;
        r7.g(null);     // Catch: Throwable -> L10
        return;
    L38:
        return;
    L10:
        th = move-exception;
        tt5.a.e("BaseForsetiCompatBSDF", "forseti goBack error!", th, false);
        return;
    L34:
        S90(this);
    }

    public final boolean U90() {
        return !getShowsDialog();
    }

    public BaseForsetiCompatBottomSheetDialogFragment() {
    }

    public static void S90(BottomSheetDialogFragment r1) {
        super/*androidx.fragment.app.DialogFragment*/.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public void onCreate(Bundle r4) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r4);
        if (U90() == true) goto L5;
        return;
    L5:
        if (PageType.FLOAT != PageType.BOTTOM_SHEET) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L12;
        o.a r6 = new o.a();
        r6.b = false;
        r6.a = false;
        r6.c = false;
        o r7 = r6.a();
        com.ss.android.lark.insets.f r0 = WindowInsetsUtils.b(this);
        r0.c(r7.a);
        r0.o(r7.b);
        r0.f(r7.c);
        r0.b(0);
        r0.i(r7.e);
        return;
    L12:
        return;
    L7:
        r5 = false;
        goto L8
    }

    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        if (U90() == false) goto L16;
        PageType r4 = PageType.NORMAL;
        if (r2.getBackground() != null) goto L7;
        r2.setBackgroundColor(ContextCompat.getColor(r2.getContext(), 2131100548));
    L7:
        h.a(r2);
        if (r2.isClickable() == true) goto L10;
        r2.setClickable(true);
    L10:
        sua.a r5 = (sua.a) ApiUtils.getApi(sua.a.class);
        if (r5 == null) goto L17;
        tua.b r6 = r5.tryGetChainManager(getActivity());
        if (r6 == null) goto L18;
        r6.u(this, new e(r6, this));
        return;
    L18:
        return;
    L17:
        return;
    }

    public View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        tt5.a.h("BaseForsetiCompatBSDF", "onCreateView");
        View r10 = V90(r7, r8);
        if (r10 != null) goto L7;
        return null;
    L7:
        if (U90() == true) goto L9;
    L17:
        this.d = r10;
        return r10;
    L9:
        if (PageType.FLOAT != PageType.BOTTOM_SHEET) goto L11;
        boolean r11 = true;
    L12:
        if (r11 == false) goto L17;
        FrameLayout r12 = new FrameLayout(r7.getContext());
        r12.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        CoordinatorLayout r0 = new CoordinatorLayout(r7.getContext());
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r12.setOnClickListener(new b(this));
        r12.addView(r0);
        FrameLayout r3 = new FrameLayout(r7.getContext());
        ViewGroup.LayoutParams r13 = new CoordinatorLayout.LayoutParams(-1, -2);
        BottomSheetBehavior<? extends View> r2 = new BottomSheetBehavior();
        r2.setPeekHeight((int) (com.bytedance.ee.util.ui.n.t() * 0.75f));
        r2.setHideable(true);
        r13.setBehavior(r2);
        this.e = r2;
        r2.setState(5);
        r2.addBottomSheetCallback(new c(this));
        ViewTreeObserver r1 = r12.getViewTreeObserver();
        if (r1 == null) goto L16;
        r1.addOnGlobalLayoutListener(new d(r2, this, r12));
    L16:
        Unit r4 = Unit.INSTANCE;
        r0.addView(r3, r13);
        r3.addView(r10);
        r10 = r12;
        goto L17
    L11:
        r11 = false;
        goto L12
    }
}
