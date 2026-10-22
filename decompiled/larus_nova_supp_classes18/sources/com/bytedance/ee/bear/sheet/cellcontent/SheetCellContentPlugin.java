package com.bytedance.ee.bear.sheet.cellcontent;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.ai.docai.CcmDocAIScene;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetCellContentPlugin extends DocumentPlugin implements com.bytedance.ee.bear.document.orientation.p {
    private static final String SHOW_CELL_CONTENT_NAME = "biz.sheet.showCellContent";
    private static final String TAG = "SheetCellContentPlugin";
    private tb5.m callback;
    private SheetCellContentViewModel sheetCellContentViewModel;

    public class a implements com.bytedance.ee.bear.sheet.cellcontent.a {
        public final /* synthetic */ SheetCellContentPlugin a;

        public a(SheetCellContentPlugin r1) {
            this.a = r1;
        }
    }

    public class b implements tb5.i<SheetCellContentData> {
        public final /* synthetic */ SheetCellContentPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(SheetCellContentPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r2, tb5.m r3) {
            SheetCellContentData r4 = (SheetCellContentData) r2;
            if (r4 != null) goto L5;
        L8:
            SheetCellContentPlugin.access$200(this.a).setActive(false);
            return;
        L5:
            if (r4.getData() == null) goto L8;
            SheetCellContentPlugin.access$002(this.a, r3);
            SheetInputData.InputData r5 = r4.getData();
            r5.setSegments(ym5.b.a(r5.getValue()));
            SheetCellContentPlugin.access$200(this.a).setActive(true);
            SheetCellContentPlugin.access$200(this.a).updateFormulaData(r4.getFormulaData());
            SheetCellContentPlugin.access$200(this.a).updateCellData(r4.getData());
            SheetCellContentPlugin.access$200(this.a).setCopyable(r4.isCopyable());
            SheetCellContentPlugin.access$200(this.a).setBgColor(r4.getBgColor());
            SheetCellContentPlugin.access$200(this.a).setMidHeight(r4.getMinHeight());
        }
    }

    public static /* synthetic */ void c(SheetCellContentPlugin r0, Boolean r1) {
        r0.lambda$onAttachToUIContainer$0(r1);
    }

    public static /* synthetic */ void d(DocumentPluginHost r0, Float r1) {
        lambda$onAttachToUIContainer$1(r0, r1);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public boolean shouldDisableLandscape() {
        return true;
    }

    public SheetCellContentPlugin() {
    }

    public static /* synthetic */ tb5.m access$000(SheetCellContentPlugin r0) {
        return r0.callback;
    }

    public static /* synthetic */ SheetCellContentViewModel access$200(SheetCellContentPlugin r0) {
        return r0.sheetCellContentViewModel;
    }

    private /* synthetic */ void lambda$onAttachToUIContainer$0(Boolean r2) {
        if (Boolean.TRUE.equals(r2) == false) goto L5;
        addOrReplaceFragment(SheetCellContentPanelFragment.class);
        return;
    L5:
        removeFragment();
    }

    private void updateDocAIEnabled(DocumentPluginHost r4) {
        SheetCellContentViewModel r1 = this.sheetCellContentViewModel;     // Catch: Throwable -> L5
        yz4.b.a(r4).d(CcmDocAIScene.SHEET);     // Catch: Throwable -> L5
        r1.setDocAIEnabled(false);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e(TAG, "updateDocAIEnabled failed", th, false);
        this.sheetCellContentViewModel.setDocAIEnabled(false);
    }

    public static /* synthetic */ tb5.m access$002(SheetCellContentPlugin r0, tb5.m r1) {
        r0.callback = r1;
        return r1;
    }

    private static /* synthetic */ void lambda$onAttachToUIContainer$1(DocumentPluginHost r0, Float r1) {
        r0.b().requestUpdateWebContentHeight();
    }

    public void onAttachToUIContainer(final DocumentPluginHost r3, t r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r3, r4);
        SheetCellContentViewModel r5 = q.c(r3, SheetCellContentViewModel.class, null);
        this.sheetCellContentViewModel = r5;
        r5.onAttachToUI(r3, getWeb());
        this.sheetCellContentViewModel.setVCFollow(isVCFollow());
        updateDocAIEnabled(r3);
        this.sheetCellContentViewModel.getActive().observe(getLifecycleOwner(), new l(this));
        this.sheetCellContentViewModel.setOnSegmentsClickListener(new a(this));
        bindBridgeHandler(SHOW_CELL_CONTENT_NAME, new b(this));
        r3.b().registerEditPanel(getLifecycleOwner(), this.sheetCellContentViewModel);
        this.sheetCellContentViewModel.getPanelHeightData().observe(getLifecycleOwner(), new m(r3));
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }
}
