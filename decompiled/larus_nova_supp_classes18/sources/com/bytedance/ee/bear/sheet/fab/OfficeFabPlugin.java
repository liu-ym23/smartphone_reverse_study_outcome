package com.bytedance.ee.bear.sheet.fab;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import ew4.e0;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OfficeFabPlugin extends DocumentPluginV3 implements ISheetFabPlugin<ChameleonPluginHost> {
    private static final String SHEET_FAB = "biz.sheet.setFabButtons";
    private static final String TAG = "FabPlugin";
    private FabViewModel mFabViewModel;
    private Rect mPendingMarginRect;
    private boolean mVisibleFromNative;

    public class a implements tb5.i<FabItem> {
        public final /* synthetic */ OfficeFabPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public a(OfficeFabPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r3, final tb5.m r4) {
            FabItem r5 = (FabItem) r3;
            tt5.a.b(OfficeFabPlugin.TAG, "handle: fab = " + r5);
            OfficeFabPlugin.access$100(this.a).setDelegate(new x(r4));
            if (r5 != null) goto L5;
        L10:
            OfficeFabPlugin.access$200(this.a);
            OfficeFabPlugin.access$100(this.a).updateFabBottomOffset(0);
            OfficeFabPlugin.access$100(this.a).updateItems(new FabItem.FabSheetItem[0]);
            return;
        L5:
            if (r5.getData() == null) goto L10;
            if (r5.getData().length == 0) goto L10;
            OfficeFabPlugin.access$300(this.a);
            OfficeFabPlugin.access$100(this.a).updateFabBottomOffset(r5.getBottomOffset());
            OfficeFabPlugin.access$100(this.a).updateItems(r5.getData());
        }
    }

    @Override // com.bytedance.ee.bear.sheet.fab.ISheetFabPlugin
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public OfficeFabPlugin() {
        this.mVisibleFromNative = true;
    }

    private void applyPendingMargin() {
        if (isUIContainerAttached() == true) goto L5;
        return;
    L5:
        if (this.mPendingMarginRect == null) goto L18;
        ViewGroup r0 = getUIContainer().c(this);
        if (r0 != null) goto L11;
        tt5.a.k(TAG, "applyPendingMargin failed, pluginContainer is null");
        return;
    L11:
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L15;
        tt5.a.k(TAG, "applyPendingMargin failed, layoutParams = " + r2);
        return;
    L15:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        Rect r1 = this.mPendingMarginRect;
        r3.setMargins(r1.left, r1.top, r1.right, r1.bottom);
        r0.setLayoutParams(r3);
        return;
    }

    private void ensureFabFragment() {
        if (getUIContainer().l(this) != null) goto L5;
        addOrReplaceFragment(OfficeFabFragment.class);
    L5:
        applyPendingMargin();
    }

    private boolean isOfficeSDKAssembleFGEnabled() {
        return CCMOfficeSDKAssembleFG.a();
    }

    private void hideFloatActionBottom() {
        removeFragment();
    }

    public static /* synthetic */ FabViewModel access$100(OfficeFabPlugin r0) {
        return r0.mFabViewModel;
    }

    public static /* synthetic */ void access$200(OfficeFabPlugin r0) {
        r0.hideFloatActionBottom();
    }

    public static /* synthetic */ void access$300(OfficeFabPlugin r0) {
        r0.ensureFabFragment();
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put(SHEET_FAB, new a(this));
    }

    public void onAttachToHost(ChameleonPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        FabViewModel r0 = (FabViewModel) viewModel(FabViewModel.class);
        this.mFabViewModel = r0;
        r0.setVisibleFromNative(this.mVisibleFromNative);
        e0 r4 = (e0) r3.getUserComponent().a(e0.class);
        this.mFabViewModel.setSheetFabConfig(r4);
    }

    @Override // com.bytedance.ee.bear.sheet.fab.ISheetFabPlugin
    public void setEditButtonVisibilityFromNative(boolean r3) {
        tt5.a.h(TAG, "setEditButtonVisibilityFromNative, show = " + r3);
        this.mVisibleFromNative = r3;
        FabViewModel r0 = this.mFabViewModel;
        if (r0 != null) goto L6;
        tt5.a.k(TAG, "setEditButtonVisibilityFromNative pending, mFabViewModel is null");
        return;
    L6:
        r0.setVisibleFromNative(r3);
    }

    @Override // com.bytedance.ee.bear.sheet.fab.ISheetFabPlugin
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
        this.mFabViewModel.updateItems(new FabItem.FabSheetItem[0]);
    }

    @Override // com.bytedance.ee.bear.sheet.fab.ISheetFabPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.sheet.fab.ISheetFabPlugin
    public void setSheetFabMargin(int r4, int r5, int r6, int r7) {
        if (isOfficeSDKAssembleFGEnabled() == true) goto L6;
        tt5.a.h(TAG, "setSheetFabMargin ignored, fg disabled");
        return;
    L6:
        tt5.a.h(TAG, "setSheetFabMargin, left = " + r4 + ", top = " + r5 + ", right = " + r6 + ", bottom = " + r7);
        Rect r0 = this.mPendingMarginRect;
        if (r0 != null) goto L9;
        this.mPendingMarginRect = new Rect(r4, r5, r6, r7);
    L10:
        applyPendingMargin();
        return;
    L9:
        r0.set(r4, r5, r6, r7);
        goto L10
    }
}
