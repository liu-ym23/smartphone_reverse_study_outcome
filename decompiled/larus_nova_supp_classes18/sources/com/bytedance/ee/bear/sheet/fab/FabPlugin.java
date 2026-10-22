package com.bytedance.ee.bear.sheet.fab;

import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import ew4.e0;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FabPlugin extends DocumentPlugin {
    private static final String SHEET_FAB = "biz.sheet.setFabButtons";
    private static final String TAG = "FabPlugin";
    private FabViewModel mFabViewModel;

    public class a implements tb5.i<FabItem> {
        public final /* synthetic */ FabPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public a(FabPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r3, final tb5.m r4) {
            FabItem r5 = (FabItem) r3;
            tt5.a.b(FabPlugin.TAG, "handle: fab = " + r5);
            if (r5 != null) goto L5;
        L10:
            FabPlugin.access$100(this.a);
            FabPlugin.access$200(this.a).updateFabBottomOffset(0);
            FabPlugin.access$200(this.a).updateItems(new FabItem.FabSheetItem[0]);
            return;
        L5:
            if (r5.getData() == null) goto L10;
            if (r5.getData().length == 0) goto L10;
            FabPlugin.access$300(this.a);
            FabPlugin.access$200(this.a).updateFabBottomOffset(r5.getBottomOffset());
            FabPlugin.access$200(this.a).updateItems(r5.getData());
            FabPlugin.access$200(this.a).setDelegate(new l(r4));
        }
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void ensureFabFragment() {
        if (getUIContainer().l(this) != null) goto L6;
        addOrReplaceFragment(FabFragment.class);
        return;
    }

    public FabPlugin() {
    }

    private void hideFloatActionBottom() {
        removeFragment();
    }

    public static /* synthetic */ void access$100(FabPlugin r0) {
        r0.hideFloatActionBottom();
    }

    public static /* synthetic */ FabViewModel access$200(FabPlugin r0) {
        return r0.mFabViewModel;
    }

    public static /* synthetic */ void access$300(FabPlugin r0) {
        r0.ensureFabFragment();
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put(SHEET_FAB, new a(this));
    }

    public void onAttachToHost(DocumentPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        this.mFabViewModel = (FabViewModel) viewModel(FabViewModel.class);
        e0 r3 = (e0) r2.getUserComponent().a(e0.class);
        this.mFabViewModel.setSheetFabConfig(r3);
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super/*com.bytedance.ee.bear.browser.BaseWebPlugin*/.onDetachFromUIContainer(r1, r2);
        this.mFabViewModel.updateItems(new FabItem.FabSheetItem[0]);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
