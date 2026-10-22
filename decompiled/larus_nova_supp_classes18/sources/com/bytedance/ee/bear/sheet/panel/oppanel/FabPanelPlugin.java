package com.bytedance.ee.bear.sheet.panel.oppanel;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.sheet.common.SheetDragView;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FabPanelPlugin extends DocumentPlugin implements com.bytedance.ee.bear.document.orientation.p {
    private static final String OPEN_PANEL = "biz.sheet.operationPanel";
    private static final String TAG = "FabPanelPlugin";
    private FabPanelViewModel mFabPanelViewModel;

    public class a implements FabPanelViewModel.a {
        public final /* synthetic */ FabPanelPlugin a;

        public a(FabPanelPlugin r1) {
            this.a = r1;
        }
    }

    public class b implements tb5.i<FabPanelItem> {
        public final /* synthetic */ FabPanelPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(FabPanelPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r7, tb5.m r8) {
            FabPanelItem r9 = (FabPanelItem) r7;
            tt5.a.b(FabPanelPlugin.TAG, "handle: FabPanelItem = " + r9);
            boolean r0 = false;
            if (r9 != null) goto L5;
        L28:
            FabPanelPlugin.access$300(this.a).setActive(false);
            return;
        L5:
            if (r9.getData() == null) goto L28;
            if (r9.getData().length == 0) goto L28;
            FabPanelPlugin.access$300(this.a).setBadges(r9.getBadges());
            FabPanelPlugin.access$300(this.a).updateItems(r9.getData());
            FabPanelPlugin.access$300(this.a).showKeyboardFab().setValue(Boolean.valueOf(r9.isShowEditButton()));
            if (r9.isForceOpen() == false) goto L12;
            FabPanelPlugin.access$300(this.a).setActive(true);
        L12:
            Map<String, String> r1 = qm5.d.a;
            boolean r2 = r9.isForceOpen();
            String r10 = r9.getUri();
            MutableLiveData<Boolean> r3 = qm5.d.b;
            if (Intrinsics.areEqual(r3.getValue(), Boolean.TRUE) == true) goto L27;
            if (r2 == true) goto L17;
        L26:
            r3.setValue(Boolean.FALSE);
            goto L27
        L17:
            if (TextUtils.isEmpty(r10) == true) goto L26;
            Uri r11 = UriProtector.parse(r10);
            qm5.d.c = r11;
            if (r11 == null) goto L27;
            qm5.d.d = r11.getScheme();
            qm5.d.e = r11.getHost();
            qm5.d.f = r11.getPathSegments();
            qm5.d.g = UriProtector.getQueryParameter(r11, "oppanelIndex");
            if (Intrinsics.areEqual(qm5.d.d, "sheetpanel") == true) goto L23;
        L25:
            r3.setValue(Boolean.valueOf(r0));
            goto L27
        L23:
            if (Intrinsics.areEqual(qm5.d.e, "client") == false) goto L25;
            r0 = true;
        L27:
            FabPanelPlugin.access$300(this.a).setDelegate(new j(r8));
        }
    }

    public static /* synthetic */ void c(FabPanelPlugin r0, BaseUnspecifiedOrientationPlugin r1, Boolean r2) {
        r0.lambda$onAttachToHost$0(r1, r2);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private int calculateVisibleHeight() {
        FabPanelFragment r0 = getUIContainer().l(this);
        if (r0 != null) goto L6;
        return 0;
    L6:
        if ((r0 instanceof FabPanelFragment) == true) goto L8;
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

    public FabPanelPlugin() {
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.t access$100(FabPanelPlugin r0) throws IllegalStateException {
        return r0.getUIContainer();
    }

    public static /* synthetic */ int access$200(FabPanelPlugin r0) {
        return r0.calculateVisibleHeight();
    }

    public static /* synthetic */ FabPanelViewModel access$300(FabPanelPlugin r0) {
        return r0.mFabPanelViewModel;
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put(OPEN_PANEL, new b(this));
    }

    public void onAttachToHost(DocumentPluginHost r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r4);
        final BaseUnspecifiedOrientationPlugin r5 = findPlugin(BaseUnspecifiedOrientationPlugin.class);
        FabPanelViewModel r0 = viewModel(FabPanelViewModel.class);
        this.mFabPanelViewModel = r0;
        r0.getActive().observe(getLifecycleOwner(), new i(this, r5));
        this.mFabPanelViewModel.setFabPanelDelegate2(new a(this));
    }

    public void onConfigurationChanged(Configuration r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onConfigurationChanged(r3);
        if (r3.orientation != 2) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L9;
        this.mFabPanelViewModel.setActive(false);
        return;
    L9:
        return;
    L5:
        r4 = false;
        goto L6
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    private void lambda$onAttachToHost$0(BaseUnspecifiedOrientationPlugin r5, Boolean r6) {
        tt5.a.b(TAG, "BaseCellPanelViewModel, active = " + r6);
        if (Boolean.TRUE.equals(r6) == false) goto L7;
        addOrReplaceFragment(FabPanelFragment.class, new Bundle(), com.bytedance.ee.bear.browser.plugin.s.a(2130772587, 2130772588, 0, 0));
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

    public void onAttachToUIContainer(DocumentPluginHost r3, com.bytedance.ee.bear.browser.plugin.t r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r3, r4);
        r3.b().registerEditPanel(getLifecycleOwner(), this.mFabPanelViewModel);
        this.mFabPanelViewModel.onAttachToUI(r3, getWeb());
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }
}
