package com.bytedance.ee.bear.bitable.websubpage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.WebViewV2;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.l;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0002&'B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u001a\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\rJ\b\u0010\"\u001a\u00020#H\u0016J\u0006\u0010$\u001a\u00020\u001aJ\b\u0010%\u001a\u00020\u001aH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/bitable/websubpage/FullScreenWebSubPage;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/IFullScreenPage;", "<init>", "()V", "mTitleBar", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "mWebViewLayout", "Landroid/widget/FrameLayout;", "mLoadingLayout", "mWaitingShowWebView", "Lcom/bytedance/ee/bear/browser/WebViewV2;", "mCloseHandler", "Lcom/bytedance/ee/bear/bitable/websubpage/FullScreenWebSubPage$CloseHandler;", "mInitStatusBarColor", "", "Ljava/lang/Integer;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "", "root", "updateContent", "webViewV2", "pageInfo", "Lorg/json/JSONObject;", "setCloseHandler", "handler", "onBackPressed", "", "closePageIfNeeded", "onDestroy", "Companion", "CloseHandler", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FullScreenWebSubPage extends BaseFragment implements l {
    public BaseTitleBar e;
    public FrameLayout f;
    public FrameLayout g;
    public WebViewV2 h;
    public a i;
    public Integer j;

    public interface a {
        void a();
    }

    public static final class b {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onDestroy() {
        FrameLayout r0 = this.f;
        if (r0 == null) goto L5;
        r0.removeView(this.h);
    L5:
        NestedScrollingChild r1 = this.h;
        if (r1 == null) goto L8;
        r1.removeAllViews();
    L8:
        WebViewV2 r2 = this.h;
        if (r2 == null) goto L11;
        r2.destroy();
    L11:
        this.h = null;
        Integer r3 = this.j;
        if (r3 == null) goto L18;
        int r4 = r3.intValue();
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L18;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L18;
        r6.setStatusBarColor(r4);
    L18:
        super.onDestroy();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        if (super.onBackPressed() == true) goto L9;
        WebViewV2 r0 = this.h;
        if (r0 == null) goto L10;
        r0.evaluateJavascript("javascript:window.lark.biz.webSubPage.onBackPress()", new com.bytedance.ee.bear.bitable.websubpage.a(this));
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    public FullScreenWebSubPage() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12, types: [android.view.View, com.bytedance.ee.bear.browser.WebViewV2] */
    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r6 = LayoutInflater.from(getContext()).inflate(2131561260, r4, false);
        Intrinsics.checkNotNull(r6);
        this.e = r6.findViewById(2131388775);
        this.f = (FrameLayout) r6.findViewById(2131393140);
        FrameLayout r7 = (FrameLayout) r6.findViewById(2131379045);
        this.g = r7;
        if (r7 == null) goto L5;
        r7.setVisibility(8);
    L5:
        BaseTitleBar r8 = this.e;
        if (r8 == null) goto L8;
        r8.setMainTitleSize(17.0f);
    L8:
        BaseTitleBar r9 = this.e;
        if (r9 == null) goto L11;
        r9.setLeftImageResource(2131254998);
    L11:
        ?? r10 = this.h;
        if (r10 == 0) goto L16;
        int r11 = lv4.a.a;
        lv4.a.a(getContext(), r10);
        FrameLayout r12 = this.f;
        if (r12 == 0) goto L16;
        r12.addView(r10, new FrameLayout.LayoutParams(-1, -1));
    L16:
        BaseTitleBar r13 = this.e;
        if (r13 == null) goto L19;
        r13.setLeftClickListener(new kv4.a(this));
    L19:
        FragmentActivity r14 = getActivity();
        if (r14 == null) goto L24;
        Window r16 = r14.getWindow();
        if (r16 == null) goto L24;
        Integer r17 = Integer.valueOf(r16.getStatusBarColor());
    L25:
        this.j = r17;
        FragmentActivity r18 = getActivity();
        if (r18 == null) goto L30;
        Window r19 = r18.getWindow();
        if (r19 == null) goto L30;
        r19.setStatusBarColor(getResources().getColor(2131100558));
    L30:
        return r6;
    L24:
        r17 = null;
        goto L25
    }
}
