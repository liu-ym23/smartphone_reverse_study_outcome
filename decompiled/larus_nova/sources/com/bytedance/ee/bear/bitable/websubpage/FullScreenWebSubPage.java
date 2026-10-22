package com.bytedance.ee.bear.bitable.websubpage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.browser.WebViewV2;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.l;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0002&'B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u001a\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\rJ\b\u0010\"\u001a\u00020#H\u0016J\u0006\u0010$\u001a\u00020\u001aJ\b\u0010%\u001a\u00020\u001aH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/bitable/websubpage/FullScreenWebSubPage;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/IFullScreenPage;", "<init>", "()V", "mTitleBar", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "mWebViewLayout", "Landroid/widget/FrameLayout;", "mLoadingLayout", "mWaitingShowWebView", "Lcom/bytedance/ee/bear/browser/WebViewV2;", "mCloseHandler", "Lcom/bytedance/ee/bear/bitable/websubpage/FullScreenWebSubPage$CloseHandler;", "mInitStatusBarColor", "", "Ljava/lang/Integer;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "", RootDescription.ROOT_ELEMENT, "updateContent", "webViewV2", "pageInfo", "Lorg/json/JSONObject;", "setCloseHandler", "handler", "onBackPressed", "", "closePageIfNeeded", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "CloseHandler", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FullScreenWebSubPage extends BaseFragment implements l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BaseTitleBar f216278e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f216279f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f216280g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WebViewV2 f216281h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f216282i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f216283j;

    public interface a {
        void a();
    }

    public static final class b {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        FrameLayout r100 = this.f216279f;
        if (r100 == null) goto L5;
        r100.removeView(this.f216281h);
    L5:
        WebViewV2 r101 = this.f216281h;
        if (r101 == null) goto L8;
        r101.removeAllViews();
    L8:
        WebViewV2 r102 = this.f216281h;
        if (r102 == null) goto L11;
        r102.destroy();
    L11:
        this.f216281h = null;
        Integer r103 = this.f216283j;
        if (r103 == null) goto L18;
        int r104 = r103.intValue();
        FragmentActivity r105 = getActivity();
        if (r105 == null) goto L18;
        Window r106 = r105.getWindow();
        if (r106 == null) goto L18;
        r106.setStatusBarColor(r104);
    L18:
        super.onDestroy();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        if (super.onBackPressed() == true) goto L9;
        WebViewV2 r100 = this.f216281h;
        if (r100 == null) goto L10;
        r100.evaluateJavascript("javascript:window.lark.biz.webSubPage.onBackPress()", new com.bytedance.ee.bear.bitable.websubpage.a(this));
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    public FullScreenWebSubPage() {
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.full_screen_web_subpage, r101, false);
        Intrinsics.checkNotNull(r103);
        this.f216278e = (BaseTitleBar) r103.findViewById(R.id.titleBar);
        this.f216279f = (FrameLayout) r103.findViewById(R.id.webview_layout);
        FrameLayout r104 = (FrameLayout) r103.findViewById(R.id.loading_layout);
        this.f216280g = r104;
        if (r104 == null) goto L5;
        r104.setVisibility(8);
    L5:
        BaseTitleBar r105 = this.f216278e;
        if (r105 == null) goto L8;
        r105.setMainTitleSize(17.0f);
    L8:
        BaseTitleBar r106 = this.f216278e;
        if (r106 == null) goto L11;
        r106.setLeftImageResource(R.drawable.ud_icon_left_outlined);
    L11:
        WebViewV2 r107 = this.f216281h;
        if (r107 == null) goto L16;
        int r108 = lv4.a.f510961a;
        lv4.a.a(getContext(), r107);
        FrameLayout r109 = this.f216279f;
        if (r109 == null) goto L16;
        r109.addView(r107, new FrameLayout.LayoutParams(-1, -1));
    L16:
        BaseTitleBar r110 = this.f216278e;
        if (r110 == null) goto L19;
        r110.setLeftClickListener(new kv4.a(this));
    L19:
        FragmentActivity r111 = getActivity();
        if (r111 == null) goto L24;
        Window r112 = r111.getWindow();
        if (r112 == null) goto L24;
        Integer r113 = Integer.valueOf(r112.getStatusBarColor());
    L25:
        this.f216283j = r113;
        FragmentActivity r114 = getActivity();
        if (r114 == null) goto L30;
        Window r115 = r114.getWindow();
        if (r115 == null) goto L30;
        r115.setStatusBarColor(getResources().getColor(R.color.bg_float_base));
    L30:
        return r103;
    L24:
        r113 = null;
        goto L25
    }
}
