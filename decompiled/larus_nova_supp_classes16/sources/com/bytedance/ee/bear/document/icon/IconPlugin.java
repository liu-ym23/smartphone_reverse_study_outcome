package com.bytedance.ee.bear.document.icon;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.s;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.icon.IconInfo;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0002J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0006\u0010\u0019\u001a\u00020\rJ\u0010\u0010\u0019\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/document/icon/IconPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/document/orientation/OrientationSupportPanel;", "<init>", "()V", "iconViewModel", "Lcom/bytedance/ee/bear/document/icon/IconViewModel;", "activeObserver", "Landroidx/lifecycle/Observer;", "", "iconEventReport", "Lcom/bytedance/ee/bear/document/icon/IconEventReport;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onDetachFromUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "ensureIconSelectFragment", "shouldDisableLandscape", "showOfflineToast", "setIcon", "iconInfoData", "Lcom/bytedance/ee/bear/document/icon/DocIconNetResult$Icon;", "showIconSelectList", "Lcom/bytedance/ee/bear/contract/icon/IconInfo;", "Companion", "SelectIconHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IconPlugin extends DocumentPlugin implements p {
    private static final String BIZ_NAVIGATION_SELECT_ICON = "biz.navigation.selectIcon";
    public static final a Companion = null;
    private static final String JS_BIZ_TITLE_SET_ICON = "javascript:window.lark.biz.title.setIcon";
    public static final String NONE_ICON_KEY = "noneIconKey";
    private static final String TAG = "DocIconPlugin";
    private Observer<Boolean> activeObserver;
    private com.bytedance.ee.bear.document.icon.a iconEventReport;
    private IconViewModel iconViewModel;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<IconInfo> {
        public final /* synthetic */ IconPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(IconPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            IconInfo r4 = (IconInfo) r2;
            tt5.a.h(IconPlugin.TAG, "Selected icon: " + r4);
            this.a.showIconSelectList(r4);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.icon.IconPlugin$onAttachToHost$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<DocIconNetResult.Icon, Unit> {
        public AnonymousClass2(Object r8) {
            super(1, r8, IconPlugin.class, "setIcon", "setIcon(Lcom/bytedance/ee/bear/document/icon/DocIconNetResult$Icon;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((DocIconNetResult.Icon) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(DocIconNetResult.Icon r2) {
            IconPlugin.access$setIcon((IconPlugin) ((CallableReference) this).receiver, r2);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        return true;
    }

    private final void ensureIconSelectFragment() {
        if (getUIContainer().l(this) == null) goto L5;
        return;
    L5:
        IconSelectFragment r0 = (IconSelectFragment) instantiateFragment(IconSelectFragment.class);
        r0.q = getDocViewModel().getToken();
        r0.r = this.iconEventReport;
        getUIContainer().e(this, r0, s.a(2130772201, 2130772203, 0, 0));
    }

    private final void showOfflineToast() {
        Context r0 = getContext();
        Context r1 = getContext();
        if (r1 == null) goto L6;
        CharSequence r2 = r1.getText(2131887667);
        if (r2 == null) goto L6;
    L7:
        Toast.showText(r0, r2, 0);
        return;
    L6:
        r2 = "";
        goto L7
    }

    public final void showIconSelectList() {
        showIconSelectList((IconInfo) getDocViewModel().getIconInfoData().getValue());
    }

    public IconPlugin() {
    }

    public static final /* synthetic */ void access$ensureIconSelectFragment(IconPlugin r0) {
        r0.ensureIconSelectFragment();
    }

    public static final /* synthetic */ void access$removeFragment(IconPlugin r0) {
        r0.removeFragment();
    }

    private final void setIcon(DocIconNetResult.Icon r4) {
        tt5.a.b(TAG, "set icon: " + r4);
        if (j.a.a.getNetworkState().a() == true) goto L7;
        showOfflineToast();
        return;
    L7:
        if (r4 != null) goto L9;
    L12:
        execJS(JS_BIZ_TITLE_SET_ICON, new JSONObject());
        return;
    L9:
        if (TextUtils.equals(NONE_ICON_KEY, r4.key) == true) goto L12;
        IconInfo r1 = new IconInfo();
        r1.setFs_unit(r4.fs_unit);
        r1.setKey(r4.key);
        r1.setType(r4.type);
        execJS(JS_BIZ_TITLE_SET_ICON, r1);
    }

    public void onAttachToHost(DocumentPluginHost r5) {
        super.onAttachToHost(r5);
        this.iconViewModel = (IconViewModel) viewModel(IconViewModel.class);
        this.activeObserver = new AnonymousClass1(this);
        IconViewModel r6 = this.iconViewModel;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconViewModel");
        r6 = null;
    L5:
        MutableLiveData<Boolean> r7 = r6.getActive();
        LifecycleOwner r2 = getLifecycleOwner();
        Observer<Boolean> r3 = this.activeObserver;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("activeObserver");
        r3 = null;
    L8:
        r7.observe(r2, r3);
        IconViewModel r8 = this.iconViewModel;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("iconViewModel");
        r8 = null;
    L11:
        r8.setSetIconCallback(new AnonymousClass2(this));
        this.iconEventReport = new com.bytedance.ee.bear.document.icon.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), getDocViewModel().getDocumentType());
        bindBridgeHandler(BIZ_NAVIGATION_SELECT_ICON, new b(this));
    }

    public final void showIconSelectList(IconInfo r5) {
        if (j.a.a.getNetworkState().a() == true) goto L6;
        showOfflineToast();
        return;
    L6:
        IconViewModel r0 = this.iconViewModel;
        IconViewModel r1 = null;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("iconViewModel");
        r0 = null;
    L9:
        r0.getActive().setValue(Boolean.TRUE);
        IconViewModel r2 = this.iconViewModel;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("iconViewModel");
    L13:
        r1.getSelectedIcon().setValue(r5);
        if (IconInfo.isEmpty(r5) == false) goto L18;
        com.bytedance.ee.bear.document.icon.a r6 = this.iconEventReport;
        if (r6 == null) goto L22;
        r6.a.v("docs_client_icon_change", r6.a("icon_add"));
        return;
    L22:
        return;
    L18:
        com.bytedance.ee.bear.document.icon.a r7 = this.iconEventReport;
        if (r7 == null) goto L24;
        r7.a.v("docs_client_icon_change", r7.a("icon_change"));
        return;
    L24:
        return;
    L12:
        r1 = r2;
        goto L13
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$findPlugin(IconPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ void access$setIcon(IconPlugin r0, DocIconNetResult.Icon r1) {
        r0.setIcon(r1);
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        IconViewModel r3 = this.iconViewModel;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconViewModel");
        r3 = null;
    L5:
        r3.getActive().setValue(Boolean.FALSE);
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
