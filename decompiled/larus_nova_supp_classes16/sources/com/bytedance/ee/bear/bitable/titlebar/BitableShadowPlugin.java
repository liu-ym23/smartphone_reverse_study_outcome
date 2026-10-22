package com.bytedance.ee.bear.bitable.titlebar;

import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.core.basemain.ability.b;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.d;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fJ\u0006\u0010\u0017\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\u000eJ\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0002J\u001c\u0010\u001d\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/bitable/titlebar/BitableShadowPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/TitleBar$OnTitleBarStateChangedListener;", "<init>", "()V", "maskView", "Landroid/view/View;", "getMaskView", "()Landroid/view/View;", "setMaskView", "(Landroid/view/View;)V", "topScrimPrepared", "", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "getOldVersionTitleBarHeight", "", "showStatusBar", "intoDarkShadow", "outDarkShadow", "removeMaskView", "decorView", "Landroid/view/ViewGroup;", "refreshDarkShadow", "onDetachFromUIContainer", "onConfigurationChanged", "newConfiguration", "Landroid/content/res/Configuration;", "onTitleBarStateChanged", "deviceInfo", "Lcom/bytedance/ee/bear/browser/plugin/DeviceInfo;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableShadowPlugin extends DocumentPlugin implements TitleBar.a {
    private View maskView;
    private boolean topScrimPrepared;

    public static final class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            return true;
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void refreshDarkShadow() {
        FragmentActivity r0 = ((DocumentPluginHost) getHost()).getActivity();
        ViewGroup r1 = null;
        if (r0 == null) goto L7;
        Window r2 = r0.getWindow();
        if (r2 == null) goto L7;
        View r3 = INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_titlebar_BitableShadowPlugin_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r2);
    L9:
        if ((r3 instanceof ViewGroup) == false) goto L11;
        r1 = (ViewGroup) r3;
    L11:
        if (r1 != null) goto L13;
        return;
    L13:
        removeMaskView(r1);
        intoDarkShadow();
        return;
    L7:
        r3 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void intoDarkShadow() {
        FragmentActivity r0 = ((DocumentPluginHost) getHost()).getActivity();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        View r2 = INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_titlebar_BitableShadowPlugin_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1);
    L8:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r3 = (ViewGroup) r2;
        BitableTitlePlugin r4 = (BitableTitlePlugin) findPlugin(BitableTitlePlugin.class);
        boolean r5 = false;
        if (r4 == null) goto L11;
        boolean r6 = r4.getShowStatusBar();
    L12:
        b r7 = getHostAbilityOrNull(b.class);
        if (r7 == null) goto L17;
        Integer r8 = r7.t5(r6);
        if (r8 == null) goto L17;
        int r9 = r8.intValue();
    L18:
        if (r7 == null) goto L20;
        r5 = true;
    L20:
        this.topScrimPrepared = r5;
        removeMaskView(r3);
        View r10 = new View(getContext());
        this.maskView = r10;
        r10.setBackgroundColor(r10.getResources().getColor(2131106513));
        ViewGroup.LayoutParams r11 = new ViewGroup.LayoutParams(-1, r9);
        r10.setOnTouchListener(new a());
        r10.setLayoutParams(r11);
        r3.addView(r10);
        return;
    L17:
        r9 = getOldVersionTitleBarHeight(r6);
        goto L18
    L11:
        r6 = false;
    L7:
        r2 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void outDarkShadow() {
        FragmentActivity r0 = ((DocumentPluginHost) getHost()).getActivity();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        View r2 = INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_titlebar_BitableShadowPlugin_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1);
    L8:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.ViewGroup");
        removeMaskView((ViewGroup) r2);
        if (this.topScrimPrepared == false) goto L15;
        b r3 = getHostAbilityOrNull(b.class);
        if (r3 == null) goto L13;
        r3.l5();
    L13:
        this.topScrimPrepared = false;
        return;
    L15:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public BitableShadowPlugin() {
    }

    public final View getMaskView() {
        return this.maskView;
    }

    public static View INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_titlebar_BitableShadowPlugin_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    private final void removeMaskView(ViewGroup r2) {
        View r0 = this.maskView;
        if (r0 == null) goto L5;
        r2.removeView(r0);
    L5:
        this.maskView = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int getOldVersionTitleBarHeight(boolean r6) {
        t r0 = getUIContainer();
        if (r0 == null) goto L5;
        View r1 = r0.findView(2131369266);
    L6:
        int r2 = 0;
        if (r1 == null) goto L9;
        int r3 = r1.getHeight();
    L10:
        if (r6 == false) goto L13;
        int r7 = c76.a.a;
        FragmentActivity r8 = ((DocumentPluginHost) getHost()).getActivity();
        Intrinsics.checkNotNullParameter(r8, "context");
        int r4 = r8.getResources().getIdentifier("status_bar_height", "dimen", "android");
        r2 = r8.getResources().getDimensionPixelSize(r4);
    L13:
        return r3 + r2;
    L9:
        r3 = 0;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        if (this.maskView == null) goto L5;
    L6:
        refreshDarkShadow();
        return;
    L5:
        if (this.topScrimPrepared == true) goto L6;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar.a
    public void onTitleBarStateChanged(d r1) {
        if (this.maskView == null) goto L5;
    L6:
        refreshDarkShadow();
        return;
    L5:
        if (this.topScrimPrepared == true) goto L6;
    }

    public final void setMaskView(View r1) {
        this.maskView = r1;
    }

    public void onAttachToHost(DocumentPluginHost r1) {
        super.onAttachToHost(r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        TitleBar r3 = getTitleBar();
        if (r3 == null) goto L6;
        r3.g(this);
        return;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        outDarkShadow();
        TitleBar r3 = getTitleBar();
        if (r3 == null) goto L6;
        r3.c(this);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
