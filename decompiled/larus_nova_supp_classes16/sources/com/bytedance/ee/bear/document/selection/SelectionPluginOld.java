package com.bytedance.ee.bear.document.selection;

import android.view.ActionMode;
import android.webkit.WebView;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.z4;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
class SelectionPluginOld extends SelectionPlugin {
    private static final String DOWNGRADE_AI_CHAT_CLEAR_SELECTION = "downgradeAIChatClearSelection";
    private static final String[] IS_MINDNOTE_SPECIAL = null;
    private static final String[] SUPPORT_CUSTOM_SELECTION_TYPES = null;
    private static final String[] SUPPORT_DOUBLE_TAP_TYPES = null;
    private static final String[] SUPPORT_LONG_PRESS_TYPES = null;
    private static final String[] SUPPORT_SINGLE_TAP_TYPES = null;
    private static final String[] SUPPORT_SLIDE_TYPES = null;
    private e0 webSelectionLayer;

    public class a implements tb5.i<String> {
        public final /* synthetic */ SelectionPluginOld a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(SelectionPluginOld r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r9, tb5.m r10) {
            String r11 = (String) r9;
            e0 r12 = SelectionPluginOld.access$000(this.a);
            if (r12.e == false) goto L27;
            boolean r1 = true;
            e0.l(new String[]{"onSelectionChanged:", r11});
            JSONObject r0 = new JSONObject(r11);     // Catch: Throwable -> L21
            int r13 = com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r0, "lineHeight"));     // Catch: Throwable -> L21
            int r3 = com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r0, "startLeft"));     // Catch: Throwable -> L21
            int r4 = com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r0, "startBottom"));     // Catch: Throwable -> L21
            int r5 = com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r0, "endRight"));     // Catch: Throwable -> L21
            int r2 = com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r0, "endBottom"));     // Catch: Throwable -> L21
            r12.G = r13;     // Catch: Throwable -> L21
            r12.E.set(r3, r4);     // Catch: Throwable -> L21
            r12.F.set(r5, r2);     // Catch: Throwable -> L21
            if (r12.R == true) goto L26;
            WebView r6 = r12.i();     // Catch: Throwable -> L21
            if (r13 != 0) goto L14;
            if (r3 != 0) goto L14;
            if (r5 != 0) goto L14;
            if (r2 != 0) goto L14;
        L16:
            if (r12.j == false) goto L19;
            if (r1 == true) goto L19;
            z r14 = new z(r12);     // Catch: Throwable -> L21
            e0.l(new String[]{"jsGetCursorBounds"});     // Catch: Throwable -> L21
            r12.g("javascript:window.lark.biz.selection.getCursorBounds", null, new b0(r12, r14));     // Catch: Throwable -> L21
        L19:
            r6.removeCallbacks(r12.M);     // Catch: Throwable -> L21
            r6.postDelayed(r12.M, 30);     // Catch: Throwable -> L21
            return;
        L14:
            r1 = false;
            goto L16
        L26:
            return;
        L21:
            th = move-exception;
            tt5.a.f("SelectionOld", th, false);
            return;
        }
    }

    public class b implements tb5.i<String> {
        public final /* synthetic */ SelectionPluginOld a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(SelectionPluginOld r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            String r5 = (String) r3;
            e0 r6 = SelectionPluginOld.access$000(this.a);
            r6.getClass();
            tt5.a.h("SelectionOld", "showActionMode:" + r5);
            r6.m(JSONObjectProtectorUtils.getJSONObject(new JSONObject(r5), "position"), r6.S);     // Catch: Throwable -> L5
            r6.i().post(new z(r6));     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            tt5.a.f("SelectionOld", th, false);
        }
    }

    public class c implements tb5.i<String> {
        public final /* synthetic */ SelectionPluginOld a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(SelectionPluginOld r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            String r4 = (String) r2;
            e0 r5 = SelectionPluginOld.access$000(this.a);
            r5.getClass();
            tt5.a.h("SelectionOld", "closeActionMode");
            ActionMode r6 = r5.C;
            if (r6 == null) goto L6;
            r6.finish();
            return;
        }
    }

    static {
        sbb.e r2 = sbb.e.g;
        sbb.e r3 = sbb.e.h;
        sbb.e r5 = sbb.e.k;
        sbb.e r7 = sbb.e.n;
        SUPPORT_CUSTOM_SELECTION_TYPES = new String[]{r2.getType(), r3.getType(), r5.getType(), r7.getType()};
        SUPPORT_SLIDE_TYPES = new String[]{r2.getType(), r7.getType()};
        SUPPORT_SINGLE_TAP_TYPES = new String[]{r2.getType(), r3.getType(), r5.getType(), r7.getType()};
        SUPPORT_DOUBLE_TAP_TYPES = new String[]{r2.getType(), r3.getType(), r5.getType(), r7.getType()};
        SUPPORT_LONG_PRESS_TYPES = new String[]{r2.getType(), r3.getType(), r7.getType()};
        IS_MINDNOTE_SPECIAL = new String[]{r5.getType()};
    }

    public static /* synthetic */ void f(String r0, tb5.m r1) {
        lambda$setupCustomSelection$0(r0, r1);
    }

    private static /* synthetic */ void lambda$setupCustomSelection$0(String r0, tb5.m r1) {
    }

    @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private e0 ensureWebSelectionLayer() {
        if (this.webSelectionLayer != null) goto L9;
        e0 r0 = new e0((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), (DocumentPluginHost) getHost());
        this.webSelectionLayer = r0;
        boolean r1 = containsType(IS_MINDNOTE_SPECIAL, getDocViewModel().getDocumentType());
        tt5.a.h("SelectionOld", "setMindnoteSpecial:" + r1);
        r0.j = r1;
        if ((getWeb().getWebView() instanceof zv4.c) == false) goto L7;
        ((zv4.c) getWeb().getWebView()).b(this.webSelectionLayer);
    L7:
        this.webSelectionLayer.a = getActionModeDelegate();
        this.webSelectionLayer.T = getMenuItemClickListener();
    L9:
        return this.webSelectionLayer;
    }

    @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public void clearSelection() {
        if (DowngradeSettingUtil.a(DOWNGRADE_AI_CHAT_CLEAR_SELECTION) == false) goto L5;
        return;
    L5:
        e0 r0 = ensureWebSelectionLayer();
        r0.getClass();
        e0.l(new String[]{"jsClearSelectionExcludeCursor"});
        r0.g("javascript:window.lark.biz.selection.clearSelectionExcludeCursor", null, null);
    }

    @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, vz4.d, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public void closeActionMode() {
        e0 r0 = ensureWebSelectionLayer();
        r0.getClass();
        tt5.a.h("SelectionOld", "closeActionMode");
        ActionMode r1 = r0.C;
        if (r1 == null) goto L6;
        r1.finish();
        return;
    }

    @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public boolean isShowingActionMode() {
        if (ensureWebSelectionLayer().C == null) goto L5;
        return true;
    L5:
        return false;
    }

    public SelectionPluginOld() {
    }

    public static /* synthetic */ e0 access$000(SelectionPluginOld r0) {
        return r0.webSelectionLayer;
    }

    private void setEnableTextIntentItems(Boolean r4) {
        e0 r0 = this.webSelectionLayer;
        boolean r5 = r4.booleanValue();
        r0.getClass();
        tt5.a.h("SelectionOld", "setEnableTextIntentItem" + r5);
        r0.s = r5;
    }

    private boolean shouldEnableCustomSelection(String r2) {
        if (containsType(SUPPORT_CUSTOM_SELECTION_TYPES, r2) == true) goto L7;
        return false;
    L7:
        return e0.h();
    }

    private void updateCustomSelectionConfig(String r6) {
        e0 r0 = this.webSelectionLayer;
        boolean r1 = shouldEnableCustomSelection(r6);
        r0.getClass();
        tt5.a.h("SelectionOld", "setEnableCustomSelection:" + r1);
        if (e0.h() == true) goto L5;
        tt5.a.d("SelectionOld", "Enable custom selection when not match necessary condition");
    L6:
        boolean r2 = containsType(SUPPORT_SLIDE_TYPES, r6);
        tt5.a.h("SelectionOld", "setEnableSlide:" + r2);
        r0.f = r2;
        boolean r3 = containsType(SUPPORT_SINGLE_TAP_TYPES, r6);
        tt5.a.h("SelectionOld", "setEnableSingleTap:" + r3);
        r0.h = r3;
        boolean r4 = containsType(SUPPORT_DOUBLE_TAP_TYPES, r6);
        tt5.a.h("SelectionOld", "setEnableDoubleTap:" + r4);
        r0.i = r4;
        boolean r7 = containsType(SUPPORT_LONG_PRESS_TYPES, r6);
        tt5.a.h("SelectionOld", "setEnableLongPress:" + r7);
        r0.g = r7;
        return;
    L5:
        r0.e = r1;
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin
    public void setSelectionScrollEndRate(float r2) {
        ensureWebSelectionLayer().w = r2;
    }

    private static boolean containsType(String[] r4, String r5) {
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r4[r2].equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private void setupCustomSelection(z4 r1, String r2) {
        r1.d(this.webSelectionLayer);
        bindBridgeHandlerAutoUnbind("biz.selection.isEnableCustomSelection", new l0());
        bindBridgeHandlerAutoUnbind("biz.selection.onSelectionChanged", new a(this));
        bindBridgeHandlerAutoUnbind("biz.navigation.showCustomContextMenu", new b(this));
        bindBridgeHandlerAutoUnbind("biz.navigation.closeCustomContextMenu", new c(this));
    }

    @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin
    public void onAttachToUIContainer(DocumentPluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        super.onAttachToUIContainer(r2, r3);
        ensureWebSelectionLayer();
        String r4 = r2.a().getDocumentType();
        if ((r2.getWeb() instanceof z4) == false) goto L5;
        setupCustomSelection((z4) r2.getWeb(), r4);
    L5:
        updateCustomSelectionConfig(r4);
        setEnableTextIntentItems(Boolean.valueOf(shouldEnableTextIntentItems()));
    }

    @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin
    public void onDetachFromUIContainer(DocumentPluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        super.onDetachFromUIContainer(r2, r3);
        if ((r2.getWeb() instanceof z4) == false) goto L8;
        z4 r4 = (z4) r2.getWeb();
        if ((getWeb().getWebView() instanceof zv4.c) == false) goto L7;
        ((zv4.c) getWeb().getWebView()).d(this.webSelectionLayer);
    L7:
        r4.F(this.webSelectionLayer);
    L8:
        this.webSelectionLayer = null;
    }

    @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
