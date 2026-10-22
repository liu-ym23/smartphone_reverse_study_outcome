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
import androidx.core.view.NestedScrollingChild;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.browser.WebViewV2;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ee.util.ui.n;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u000f2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0012\u0010#\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010%\u001a\u00020\u0014H\u0002J\b\u0010&\u001a\u00020\u0014H\u0002J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0016J\u001a\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/bitable/websubpage/WebSubPage;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "mActionPanel", "Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout;", "mDragable", "", "mShowNavBar", "mPageHeightFactor", "", "mDragDismissFactor", "mDragMinHeightFactor", "mDragMaxHeightFactor", "mWaitingShowWebView", "Lcom/bytedance/ee/bear/browser/WebViewV2;", "mInitTitle", "", "mReceivedTitle", "onStart", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "updateContent", "webViewV2", "pageInfo", "Lorg/json/JSONObject;", "parsePageStyle", JSEventListener.STYLE, "updatePageStyle", "updateTitle", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WebSubPage extends BaseAntiScreenshotsDialogFragment {
    public CommonActionPanelLayout h;
    public boolean i;
    public boolean j;
    public float k;
    public final float l;
    public float m;
    public float n;
    public WebViewV2 o;
    public String p;

    public static final class a {
    }

    public static final class b extends CommonActionPanelLayout.b {
        public final /* synthetic */ WebSubPage a;

        public final void d() {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r0 = DialogFragmentLancet.sLastShowStack;
            if (r0 == null) goto L12;
            d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        public b(WebSubPage r1) {
            this.a = r1;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ WebSubPage a;

        public c(WebSubPage r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public final void updateTitle() {
        CommonActionPanelLayout r0 = this.h;
        if (r0 == null) goto L6;
        r0.setTitleBarVisible(this.j);
    L6:
        if (this.j == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(this.p) == true) goto L14;
        CommonActionPanelLayout r1 = this.h;
        if (r1 == null) goto L15;
        r1.setTitle(this.p);
        return;
    L15:
        return;
    }

    public WebSubPage() {
        this.i = true;
        this.k = 0.5f;
        this.l = 0.2f;
        this.m = 0.5f;
        this.n = 0.9f;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.gravity = 80;
        r2.y = k.e(r1.getContext());
        r2.windowAnimations = 2131951621;
        r1.setAttributes(r2);
        r1.setLayout(-1, -1);
        r1.setBackgroundDrawable(new ColorDrawable(0));
    L7:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).d(getDialog());
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L14
        super.onDismiss(r2);     // Catch: Throwable -> L14
        CommonActionPanelLayout r3 = this.h;     // Catch: Throwable -> L14
        if (r3 == null) goto L5;
        r3.removeView(this.o);     // Catch: Throwable -> L14
    L5:
        NestedScrollingChild r4 = this.o;     // Catch: Throwable -> L14
        if (r4 == null) goto L8;
        r4.removeAllViews();     // Catch: Throwable -> L14
    L8:
        WebViewV2 r5 = this.o;     // Catch: Throwable -> L14
        if (r5 == null) goto L11;
        r5.destroy();     // Catch: Throwable -> L14
    L11:
        this.o = null;     // Catch: Throwable -> L14
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

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        CommonActionPanelLayout r7 = this.h;
        if (r7 == null) goto L11;
        r7.b(this.i);
        updateTitle();
        r7.setDragHandlerVisible(this.i);
        if (this.i == false) goto L7;
        r7.l(n.t() * this.l, n.t() * this.m, n.t() * this.n);
    L8:
        com.bytedance.ee.bear.facade.common.widget.d r8 = r7.getDragUtil();
        if (r8 == null) goto L11;
        r8.f();
        goto L11
    L7:
        r7.l(n.t() * this.l, n.t() * this.k, n.t() * this.n);
    L11:
        CommonActionPanelLayout r9 = this.h;
        if (r9 == null) goto L14;
        r9.setOnActionListener(new b(this));
    L14:
        r5.setOnClickListener(new c(this));
    }

    public final void show(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        FragmentTransaction r5 = r3.beginTransaction();     // Catch: Exception -> L9
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r5, this, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, 0) == true) goto L7;
        r5.add(this, r4);     // Catch: Exception -> L9
    L7:
        r5.commit();     // Catch: Exception -> L9
        return;
    L9:
        tt5.a.d("WebSubPage", "show Exception");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.view.View, com.bytedance.ee.bear.browser.WebViewV2] */
    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r6 = LayoutInflater.from(getContext()).inflate(2131559198, r4, false);
        if (r6 == null) goto L5;
        CommonActionPanelLayout r7 = (CommonActionPanelLayout) r6.findViewById(2131381847);
    L6:
        this.h = r7;
        ?? r8 = this.o;
        if (r8 == 0) goto L11;
        int r9 = lv4.a.a;
        lv4.a.a(getContext(), r8);
        CommonActionPanelLayout r10 = this.h;
        if (r10 == 0) goto L11;
        r10.addView(r8, new LinearLayout.LayoutParams(-1, -1));
    L11:
        return r6;
    L5:
        r7 = null;
        goto L6
    }
}
