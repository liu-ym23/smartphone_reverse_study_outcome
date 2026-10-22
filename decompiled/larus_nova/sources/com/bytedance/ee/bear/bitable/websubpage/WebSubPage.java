package com.bytedance.ee.bear.bitable.websubpage;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.browser.WebViewV2;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u000f2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0012\u0010#\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010%\u001a\u00020\u0014H\u0002J\b\u0010&\u001a\u00020\u0014H\u0002J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0016J\u001a\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/bitable/websubpage/WebSubPage;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "mActionPanel", "Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout;", "mDragable", "", "mShowNavBar", "mPageHeightFactor", "", "mDragDismissFactor", "mDragMinHeightFactor", "mDragMaxHeightFactor", "mWaitingShowWebView", "Lcom/bytedance/ee/bear/browser/WebViewV2;", "mInitTitle", "", "mReceivedTitle", WidgetCostModule.TYPE_ON_START, "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "updateContent", "webViewV2", "pageInfo", "Lorg/json/JSONObject;", "parsePageStyle", "style", "updatePageStyle", "updateTitle", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WebSubPage extends BaseAntiScreenshotsDialogFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CommonActionPanelLayout f216284h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f216285i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f216286j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f216287k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f216288l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f216289m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f216290n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public WebViewV2 f216291o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f216292p;

    public static final class a {
    }

    public static final class b extends CommonActionPanelLayout.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebSubPage f216293a;

        @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
        public final void d() {
            this.f216293a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r100 = DialogFragmentLancet.sLastShowStack;
            if (r100 == null) goto L12;
            d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        public b(WebSubPage r100) {
            this.f216293a = r100;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebSubPage f216294a;

        public c(WebSubPage r100) {
            this.f216294a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f216294a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public final void updateTitle() {
        CommonActionPanelLayout r100 = this.f216284h;
        if (r100 == null) goto L6;
        r100.setTitleBarVisible(this.f216286j);
    L6:
        if (this.f216286j == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(this.f216292p) == true) goto L14;
        CommonActionPanelLayout r101 = this.f216284h;
        if (r101 == null) goto L15;
        r101.setTitle(this.f216292p);
        return;
    L15:
        return;
    }

    public WebSubPage() {
        this.f216285i = true;
        this.f216287k = 0.5f;
        this.f216288l = 0.2f;
        this.f216289m = 0.5f;
        this.f216290n = 0.9f;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L7;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L7;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.gravity = 80;
        r102.y = k.e(r101.getContext());
        r102.windowAnimations = R.style.ActionSheetDialogAnimation;
        r101.setAttributes(r102);
        r101.setLayout(-1, -1);
        r101.setBackgroundDrawable(new ColorDrawable(0));
    L7:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).d(getDialog());
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L14
        super.onDismiss(r100);     // Catch: Throwable -> L14
        CommonActionPanelLayout r101 = this.f216284h;     // Catch: Throwable -> L14
        if (r101 == null) goto L5;
        r101.removeView(this.f216291o);     // Catch: Throwable -> L14
    L5:
        WebViewV2 r102 = this.f216291o;     // Catch: Throwable -> L14
        if (r102 == null) goto L8;
        r102.removeAllViews();     // Catch: Throwable -> L14
    L8:
        WebViewV2 r103 = this.f216291o;     // Catch: Throwable -> L14
        if (r103 == null) goto L11;
        r103.destroy();     // Catch: Throwable -> L14
    L11:
        this.f216291o = null;     // Catch: Throwable -> L14
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L14:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        CommonActionPanelLayout r102 = this.f216284h;
        if (r102 == null) goto L11;
        r102.b(this.f216285i);
        updateTitle();
        r102.setDragHandlerVisible(this.f216285i);
        if (this.f216285i == false) goto L7;
        r102.l(n.t() * this.f216288l, n.t() * this.f216289m, n.t() * this.f216290n);
    L8:
        com.bytedance.ee.bear.facade.common.widget.d r103 = r102.getDragUtil();
        if (r103 == null) goto L11;
        r103.f();
        goto L11
    L7:
        r102.l(n.t() * this.f216288l, n.t() * this.f216287k, n.t() * this.f216290n);
    L11:
        CommonActionPanelLayout r104 = this.f216284h;
        if (r104 == null) goto L14;
        r104.setOnActionListener(new b(this));
    L14:
        r100.setOnClickListener(new c(this));
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void show(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        FragmentTransaction r102 = r100.beginTransaction();     // Catch: Exception -> L9
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r102, this, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r101, 0) == true) goto L7;
        r102.add(this, r101);     // Catch: Exception -> L9
    L7:
        r102.commit();     // Catch: Exception -> L9
        return;
    L9:
        tt5.a.d("WebSubPage", "show Exception");
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.bitable_web_subpage, r101, false);
        if (r103 == null) goto L5;
        CommonActionPanelLayout r104 = (CommonActionPanelLayout) r103.findViewById(R.id.panel);
    L6:
        this.f216284h = r104;
        WebViewV2 r105 = this.f216291o;
        if (r105 == null) goto L11;
        int r106 = lv4.a.f510961a;
        lv4.a.a(getContext(), r105);
        CommonActionPanelLayout r107 = this.f216284h;
        if (r107 == null) goto L11;
        r107.addView(r105, new LinearLayout.LayoutParams(-1, -1));
    L11:
        return r103;
    L5:
        r104 = null;
        goto L6
    }
}
