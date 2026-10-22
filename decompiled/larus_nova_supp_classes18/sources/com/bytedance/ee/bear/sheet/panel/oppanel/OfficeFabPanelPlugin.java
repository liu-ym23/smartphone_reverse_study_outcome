package com.bytedance.ee.bear.sheet.panel.oppanel;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.sheet.common.SheetDragView;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OfficeFabPanelPlugin extends DocumentPluginV3 implements com.bytedance.ee.bear.document.orientation.p {
    private static final Gson COMPAT_GSON = null;
    private static final String OPEN_PANEL = "biz.sheet.operationPanel";
    private static final String TAG = "FabPanelPlugin";
    private OfficeFabPanelViewModel mOfficeFabPanelViewModel;
    private ew4.f0 sheetFabPanelConfig;

    public class a implements OfficeFabPanelViewModel.a {
        public final /* synthetic */ OfficeFabPanelPlugin a;

        public a(OfficeFabPanelPlugin r1) {
            this.a = r1;
        }
    }

    public class b implements tb5.i<String> {
        public final /* synthetic */ OfficeFabPanelPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(OfficeFabPanelPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r7, tb5.m r8) {
            String r9 = (String) r7;
            tt5.a.b(OfficeFabPanelPlugin.TAG, "handle: FabPanelItem = " + r9);
            FabPanelItem r0 = (FabPanelItem) OfficeFabPanelPlugin.access$300().fromJson(r9, FabPanelItem.class);     // Catch: Throwable -> L5
        L6:
            boolean r10 = false;
            if (r0 != null) goto L9;
        L34:
            OfficeFabPanelPlugin.access$400(this.a).setActive(false);
            return;
        L9:
            if (r0.getData() == null) goto L34;
            if (r0.getData().length == 0) goto L34;
            OfficeFabPanelPlugin.access$400(this.a).setBadges(r0.getBadges());
            OfficeFabPanelPlugin.access$400(this.a).updateItems(r0.getData());
            OfficeFabPanelPlugin.access$400(this.a).showKeyboardFab().setValue(Boolean.valueOf(r0.isShowEditButton()));
            if (r0.isForceOpen() == false) goto L18;
            OfficeFabPanelPlugin.access$400(this.a).setActive(true);
            if (KeyboardUtils.isSoftShowing(OfficeFabPanelPlugin.access$500(this.a)) == false) goto L18;
            tt5.a.h(OfficeFabPanelPlugin.TAG, "KeyboardUtils.hideSoftKeyboard");
            KeyboardUtils.hideKeyboard(OfficeFabPanelPlugin.access$600(this.a));
        L18:
            Map<String, String> r1 = on5.b.a;
            boolean r2 = r0.isForceOpen();
            String r3 = r0.getUri();
            MutableLiveData<Boolean> r4 = on5.b.b;
            if (Intrinsics.areEqual(r4.getValue(), Boolean.TRUE) == true) goto L33;
            if (r2 == true) goto L23;
        L32:
            r4.setValue(Boolean.FALSE);
            goto L33
        L23:
            if (TextUtils.isEmpty(r3) == true) goto L32;
            Uri r5 = UriProtector.parse(r3);
            on5.b.c = r5;
            if (r5 == null) goto L33;
            on5.b.d = r5.getScheme();
            on5.b.e = r5.getHost();
            on5.b.f = r5.getPathSegments();
            on5.b.g = UriProtector.getQueryParameter(r5, "oppanelIndex");
            if (Intrinsics.areEqual(on5.b.d, "sheetpanel") == true) goto L29;
        L31:
            r4.setValue(Boolean.valueOf(r10));
            goto L33
        L29:
            if (Intrinsics.areEqual(on5.b.e, "client") == false) goto L31;
            r10 = true;
        L33:
            OfficeFabPanelPlugin.access$400(this.a).setDelegate(new u(r8));
            return;
        L5:
            Gson r6 = com.ss.android.lark.utils.e0.a;
            r0 = (FabPanelItem) com.ss.android.lark.utils.e0.a(r9, FabPanelItem.class);
            goto L6
        }
    }

    public static /* synthetic */ void a(OfficeFabPanelPlugin r0, BaseUnspecifiedOrientationPlugin r1, Boolean r2) {
        r0.lambda$onAttachToHost$0(r1, r2);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    static {
        COMPAT_GSON = new GsonBuilder().registerTypeAdapter(SheetItem.class, new SheetItemCompatDeserializer()).create();
    }

    private int calculateVisibleHeight() {
        OfficeFabPanelFragment r0 = getUIContainer().l(this);
        if (r0 != null) goto L6;
        return 0;
    L6:
        if ((r0 instanceof OfficeFabPanelFragment) == true) goto L8;
        return 0;
    L8:
        SheetDragView r1 = r0.j;
        if (r1 == null) goto L16;
        View r2 = r1.findViewById(2131381566);
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getHeight();
    L16:
        return 0;
    }

    public boolean shouldDisableLandscape() {
        return !ku5.c.k(getContext());
    }

    public OfficeFabPanelPlugin() {
    }

    public static /* synthetic */ Gson access$300() {
        return COMPAT_GSON;
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.t access$100(OfficeFabPanelPlugin r0) throws IllegalStateException {
        return r0.getUIContainer();
    }

    public static /* synthetic */ int access$200(OfficeFabPanelPlugin r0) {
        return r0.calculateVisibleHeight();
    }

    public static /* synthetic */ OfficeFabPanelViewModel access$400(OfficeFabPanelPlugin r0) {
        return r0.mOfficeFabPanelViewModel;
    }

    public static /* synthetic */ FragmentActivity access$500(OfficeFabPanelPlugin r0) {
        return r0.getActivity();
    }

    public static /* synthetic */ FragmentActivity access$600(OfficeFabPanelPlugin r0) {
        return r0.getActivity();
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put(OPEN_PANEL, new b(this));
    }

    public void onAttachToHost(ChameleonPluginHost r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r4);
        this.sheetFabPanelConfig = (ew4.f0) r4.getUserComponent().a(ew4.f0.class);
        final BaseUnspecifiedOrientationPlugin r5 = findPlugin(BaseUnspecifiedOrientationPlugin.class);
        OfficeFabPanelViewModel r0 = viewModel(OfficeFabPanelViewModel.class);
        this.mOfficeFabPanelViewModel = r0;
        r0.setFabPanelConfig(this.sheetFabPanelConfig);
        this.mOfficeFabPanelViewModel.getActive().observe(getLifecycleOwner(), new t(this, r5));
        this.mOfficeFabPanelViewModel.setFabPanelDelegate2(new a(this));
    }

    public void onConfigurationChanged(Configuration r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onConfigurationChanged(r3);
        if (r3.orientation != 2) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L9;
        this.mOfficeFabPanelViewModel.setActive(false);
        return;
    L9:
        return;
    L5:
        r4 = false;
        goto L6
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    private void lambda$onAttachToHost$0(BaseUnspecifiedOrientationPlugin r5, Boolean r6) {
        tt5.a.b(TAG, "BaseCellPanelViewModel, active = " + r6);
        if (Boolean.TRUE.equals(r6) == false) goto L7;
        addOrReplaceFragment(OfficeFabPanelFragment.class, new Bundle(), com.bytedance.ee.bear.browser.plugin.s.a(2130772587, 2130772588, 0, 0));
        if (r5 == null) goto L11;
        r5.onOrientationSupportPanelShowing(this);
        return;
    L11:
        return;
    L7:
        getUIContainer().d(this);
        if (r5 == null) goto L13;
        r5.onOrientationSupportPanelDismiss(this);
        return;
    }

    public void onAttachToUIContainer(ChameleonPluginHost r3, com.bytedance.ee.bear.browser.plugin.t r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r3, r4);
        h35.a.a(r3).registerEditPanel(r3.getLifecycleOwner(), this.mOfficeFabPanelViewModel);
        this.mOfficeFabPanelViewModel.onAttachToUI(r3, getWeb());
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }
}
