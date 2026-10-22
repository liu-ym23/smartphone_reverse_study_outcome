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
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0014J&\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0005H\u0014J\b\u0010!\u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020\tH\u0002J\b\u0010#\u001a\u00020\tH\u0002J\b\u0010$\u001a\u00020\tH\u0002J\b\u0010%\u001a\u00020&H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/BaseForsetiCompatBottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "compatRootView", "Landroid/view/View;", "bottomBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onFloatDismiss", "onDoCreateView", "handleInsetsForBottomSheet", "getBottomSheetInsetsConfig", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/InsetsConfig;", "getPageType", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/PageType;", "isFloat", "", "isBottomSheet", "isNormal", "isInForseti", "processBackGroundColor", "backGroundView", "dismissAllowingStateLoss", "dismissAllowingStateLossCompat", "dismissAllowingStateLossForseti", "invokeOnDismiss", "providePeekHeight", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/BaseForsetiCompatBottomSheetDialogFragment$PeekHeight;", "Companion", "PeekHeight", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseForsetiCompatBottomSheetDialogFragment extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f216416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BottomSheetBehavior<? extends View> f216417e;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseForsetiCompatBottomSheetDialogFragment f216418a;

        public b(BaseForsetiCompatBottomSheetDialogFragment r100) {
            this.f216418a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f216418a.dismissAllowingStateLoss();     // Catch: Exception -> L5
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

    public static final class c extends BottomSheetBehavior.BottomSheetCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseForsetiCompatBottomSheetDialogFragment f216419a;

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onSlide(View r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "p0");
        }

        public c(BaseForsetiCompatBottomSheetDialogFragment r100) {
            this.f216419a = r100;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onStateChanged(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            if (r101 != 5) goto L6;
            BaseForsetiCompatBottomSheetDialogFragment.S90(this.f216419a);
            BaseForsetiCompatBottomSheetDialogFragment r102 = this.f216419a;
            r102.getClass();
            r102.onDismiss(new com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.b());
            return;
        }
    }

    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior<RecyclerView> f216420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseForsetiCompatBottomSheetDialogFragment f216421b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f216422c;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            tt5.a.h("BaseForsetiCompatBSDF", "onGlobalLayout");
            this.f216420a.setState(4);
            View r100 = this.f216421b.f216416d;
            if (r100 == null) goto L7;
            ViewTreeObserver r101 = r100.getViewTreeObserver();
            if (r101 == null) goto L7;
            r101.removeOnGlobalLayoutListener(this);
        L7:
            BaseForsetiCompatBottomSheetDialogFragment r102 = this.f216421b;
            FrameLayout r103 = this.f216422c;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "backGroundView");
            com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.e.b(r102, r103);
        }

        public d(BottomSheetBehavior<RecyclerView> r100, BaseForsetiCompatBottomSheetDialogFragment r101, FrameLayout r102) {
            this.f216420a = r100;
            this.f216421b = r101;
            this.f216422c = r102;
        }
    }

    public static final class e implements com.ss.android.lark.api.ui.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ tua.b f216423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseForsetiCompatBottomSheetDialogFragment f216424b;

        @Override // com.ss.android.lark.api.ui.a
        public final void a() {
            this.f216423a.R(this.f216424b, this);
            this.f216424b.W90();
        }

        public e(tua.b r100, BaseForsetiCompatBottomSheetDialogFragment r101) {
            this.f216423a = r100;
            this.f216424b = r101;
        }
    }

    static {
    }

    public abstract View V90(LayoutInflater r100, ViewGroup r101);

    public void W90() {
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

    public final void T90() {
        if (U90() == false) goto L34;
        PageType r100 = PageType.NORMAL;
        boolean r101 = false;
        if (com.suite.lark.component.navroute.forseti.f.b(this) != null) goto L36;
        PageType r102 = PageType.FLOAT;
        if (r102 != PageType.NORMAL) goto L15;
        boolean r103 = true;
    L16:
        if (r103 == false) goto L19;
        S90(this);
        return;
    L19:
        if (r102 != PageType.BOTTOM_SHEET) goto L21;
        boolean r104 = true;
    L22:
        if (r104 == false) goto L33;
        BottomSheetBehavior<? extends View> r105 = this.f216417e;
        if (r105 != null) goto L26;
    L32:
        S90(this);
        onDismiss(new com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.b());
        return;
    L26:
        if (r105.getState() != 5) goto L28;
        r101 = true;
    L28:
        if (r101 == true) goto L32;
        BottomSheetBehavior<? extends View> r106 = this.f216417e;
        if (r106 == null) goto L41;
        r106.setState(5);
        return;
    L41:
        return;
    L33:
        tt5.a.k("BaseForsetiCompatBSDF", "dismiss unexpected!");
        S90(this);
        return;
    L21:
        r104 = false;
        goto L22
    L15:
        r103 = false;
        goto L16
    L36:
        com.suite.lark.component.navroute.forseti.g r107 = com.suite.lark.component.navroute.forseti.f.b(this);     // Catch: Throwable -> L10
        if (r107 == null) goto L38;
        r107.g(null);     // Catch: Throwable -> L10
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

    public static void S90(BottomSheetDialogFragment r100) {
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (U90() == true) goto L5;
        return;
    L5:
        if (PageType.FLOAT != PageType.BOTTOM_SHEET) goto L7;
        boolean r101 = true;
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
    L12:
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        if (U90() == false) goto L16;
        PageType r102 = PageType.NORMAL;
        if (r100.getBackground() != null) goto L7;
        r100.setBackgroundColor(ContextCompat.getColor(r100.getContext(), R.color.bg_body));
    L7:
        h.a(r100);
        if (r100.isClickable() == true) goto L10;
        r100.setClickable(true);
    L10:
        sua.a r103 = (sua.a) ApiUtils.getApi(sua.a.class);
        if (r103 == null) goto L17;
        tua.b r104 = r103.tryGetChainManager(getActivity());
        if (r104 == null) goto L18;
        r104.u(this, new e(r104, this));
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        tt5.a.h("BaseForsetiCompatBSDF", "onCreateView");
        View r103 = V90(r100, r101);
        if (r103 != null) goto L7;
        return null;
    L7:
        if (U90() == true) goto L9;
    L17:
        this.f216416d = r103;
        return r103;
    L9:
        if (PageType.FLOAT != PageType.BOTTOM_SHEET) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L17;
        FrameLayout r105 = new FrameLayout(r100.getContext());
        r105.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        CoordinatorLayout r106 = new CoordinatorLayout(r100.getContext());
        r106.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r105.setOnClickListener(new b(this));
        r105.addView(r106);
        FrameLayout r107 = new FrameLayout(r100.getContext());
        CoordinatorLayout.LayoutParams r108 = new CoordinatorLayout.LayoutParams(-1, -2);
        BottomSheetBehavior<? extends View> r109 = new BottomSheetBehavior();
        r109.setPeekHeight((int) (com.bytedance.ee.util.ui.n.t() * 0.75f));
        r109.setHideable(true);
        r108.setBehavior(r109);
        this.f216417e = r109;
        r109.setState(5);
        r109.addBottomSheetCallback(new c(this));
        ViewTreeObserver r110 = r105.getViewTreeObserver();
        if (r110 == null) goto L16;
        r110.addOnGlobalLayoutListener(new d(r109, this, r105));
    L16:
        Unit r111 = Unit.INSTANCE;
        r106.addView(r107, r108);
        r107.addView(r103);
        r103 = r105;
        goto L17
    L11:
        r104 = false;
        goto L12
    }
}
