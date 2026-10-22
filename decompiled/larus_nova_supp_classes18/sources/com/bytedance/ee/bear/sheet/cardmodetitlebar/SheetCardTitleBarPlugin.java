package com.bytedance.ee.bear.sheet.cardmodetitlebar;

import android.content.res.Configuration;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0002\u001d\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\f\u001a\u00020\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0002J\u001c\u0010\u0016\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/SheetCardTitleBarPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/document/orientation/OrientationSupportPanel;", "<init>", "()V", "viewModel", "Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/SheetCardTitleBarViewModel;", "activeObserver", "Landroidx/lifecycle/Observer;", "", "setNavBarHandler", "Lcom/bytedance/ee/bear/sheet/cardmodetitlebar/SheetCardTitleBarPlugin$SetNavBarHandler;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "ensureSheetCardTitleBarFragment", "onDetachFromUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onConfigurationChanged", "newConfiguration", "Landroid/content/res/Configuration;", "shouldDisableLandscape", "Companion", "SetNavBarHandler", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SheetCardTitleBarPlugin extends DocumentPlugin implements p {
    public static final a Companion = null;
    public static final String SET_NAV_BAR = "biz.sheet.setCardModeNavBar";
    private static final String TAG = null;
    private Observer<Boolean> activeObserver;
    private b setNavBarHandler;
    private SheetCardTitleBarViewModel viewModel;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<CardNavBarData> {
        public m a;
        public final /* synthetic */ SheetCardTitleBarPlugin b;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(SheetCardTitleBarPlugin r1) {
            this.b = r1;
        }

        public final void handle(Object r5, m r6) {
            CardNavBarData r7 = (CardNavBarData) r5;
            SheetCardTitleBarPlugin.Companion.getClass();
            tt5.a.h(SheetCardTitleBarPlugin.access$getTAG$cp(), "SetNavBarHandler receive data : " + r7);
            SheetCardTitleBarViewModel r0 = null;
            if (r7 == null) goto L5;
            CardNavBarItem r1 = r7.getItems();
        L7:
            if (r1 != null) goto L13;
            SheetCardTitleBarViewModel r8 = SheetCardTitleBarPlugin.access$getViewModel$p(this.b);
            if (r8 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L12:
            r0.getActive().setValue(Boolean.FALSE);
            return;
        L11:
            r0 = r8;
            goto L12
        L13:
            SheetCardTitleBarViewModel r2 = SheetCardTitleBarPlugin.access$getViewModel$p(this.b);
            if (r2 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r2 = null;
        L16:
            r2.getActive().setValue(Boolean.TRUE);
            SheetCardTitleBarViewModel r3 = SheetCardTitleBarPlugin.access$getViewModel$p(this.b);
            if (r3 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L20:
            r0.getNavBar().setValue(r7);
            this.a = r6;
            return;
        L19:
            r0 = r3;
            goto L20
        L5:
            r1 = null;
            goto L7
        }
    }

    public static final class c implements SheetCardTitleBarViewModel.a {
        public final /* synthetic */ SheetCardTitleBarPlugin a;

        public c(SheetCardTitleBarPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.sheet.cardmodetitlebar.SheetCardTitleBarViewModel.a
        public final void a(String r4) {
            Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_ID);
            JSONObject r1 = new JSONObject();
            r1.put(ResourceData.KEY_ID, r4);
            SheetCardTitleBarPlugin.Companion.getClass();
            tt5.a.b(SheetCardTitleBarPlugin.access$getTAG$cp(), "click card_nav_bar_item : ".concat(r4));
            b r5 = SheetCardTitleBarPlugin.access$getSetNavBarHandler$p(this.a);
            if (r5 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("setNavBarHandler");
            r5 = null;
        L5:
            m r6 = r5.a;
            if (r6 == null) goto L9;
            r6.b(r1);
            return;
        }
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public boolean shouldDisableLandscape() {
        return true;
    }

    static {
        Companion = new a();
        TAG = "SheetCardTitleBarPlugin";
    }

    private final void ensureSheetCardTitleBarFragment() {
        if (getUIContainer().l(this) == null) goto L5;
        return;
    L5:
        SheetCardTitleBarFragment r0 = instantiateFragment(SheetCardTitleBarFragment.class);
        getUIContainer().i(this, r0);
    }

    public SheetCardTitleBarPlugin() {
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public static final /* synthetic */ void access$ensureSheetCardTitleBarFragment(SheetCardTitleBarPlugin r0) {
        r0.ensureSheetCardTitleBarFragment();
    }

    public static final /* synthetic */ b access$getSetNavBarHandler$p(SheetCardTitleBarPlugin r0) {
        return r0.setNavBarHandler;
    }

    public static final /* synthetic */ SheetCardTitleBarViewModel access$getViewModel$p(SheetCardTitleBarPlugin r0) {
        return r0.viewModel;
    }

    public static final /* synthetic */ void access$removeFragment(SheetCardTitleBarPlugin r0) {
        r0.removeFragment();
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        b r0 = new b(this);
        this.setNavBarHandler = r0;
        r3.put(SET_NAV_BAR, r0);
    }

    public void onAttachToHost(DocumentPluginHost r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r4);
        this.viewModel = (SheetCardTitleBarViewModel) viewModel(SheetCardTitleBarViewModel.class);
        this.activeObserver = new AnonymousClass1(this);
        SheetCardTitleBarViewModel r5 = this.viewModel;
        Observer<Boolean> r1 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r5 = null;
    L5:
        r5.setDelegate(new c(this));
        SheetCardTitleBarViewModel r6 = this.viewModel;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r6 = null;
    L8:
        MutableLiveData<Boolean> r7 = r6.getActive();
        LifecycleOwner r0 = getLifecycleOwner();
        Observer<Boolean> r2 = this.activeObserver;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("activeObserver");
    L12:
        r7.observe(r0, r1);
        return;
    L11:
        r1 = r2;
        goto L12
    }

    public void onConfigurationChanged(Configuration r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onConfigurationChanged(r3);
        boolean r0 = false;
        if (r3 != null) goto L5;
    L7:
        if (r0 == false) goto L13;
        SheetCardTitleBarViewModel r4 = this.viewModel;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r4 = null;
    L11:
        r4.getActive().setValue(Boolean.FALSE);
        return;
    L13:
        return;
    L5:
        if (2 != r3.orientation) goto L7;
        r0 = true;
        goto L7
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ f access$findPlugin(SheetCardTitleBarPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.BaseWebPlugin*/.onDetachFromUIContainer(r1, r2);
        SheetCardTitleBarViewModel r3 = this.viewModel;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L5:
        r3.getActive().setValue(Boolean.FALSE);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
