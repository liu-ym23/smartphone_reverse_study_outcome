package com.bytedance.ee.bear.sheet.cellcontent;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.ai.docai.CcmDocAIScene;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;

/* JADX INFO: loaded from: classes18.dex */
public class SheetCellContentPlugin extends DocumentPlugin implements com.bytedance.ee.bear.document.orientation.p {
    private static final String SHOW_CELL_CONTENT_NAME = "biz.sheet.showCellContent";
    private static final String TAG = "SheetCellContentPlugin";
    private tb5.m callback;
    private SheetCellContentViewModel sheetCellContentViewModel;

    public class a implements com.bytedance.ee.bear.sheet.cellcontent.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetCellContentPlugin f237420a;

        public a(SheetCellContentPlugin r100) {
            this.f237420a = r100;
        }
    }

    public class b implements tb5.i<SheetCellContentData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetCellContentPlugin f237421a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(SheetCellContentPlugin r100) {
            this.f237421a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, tb5.m r101) {
            SheetCellContentData r102 = (SheetCellContentData) r100;
            if (r102 != null) goto L5;
        L8:
            SheetCellContentPlugin.access$200(this.f237421a).setActive(false);
            return;
        L5:
            if (r102.getData() == null) goto L8;
            SheetCellContentPlugin.access$002(this.f237421a, r101);
            SheetInputData.InputData r103 = r102.getData();
            r103.setSegments(ym5.b.a(r103.getValue()));
            SheetCellContentPlugin.access$200(this.f237421a).setActive(true);
            SheetCellContentPlugin.access$200(this.f237421a).updateFormulaData(r102.getFormulaData());
            SheetCellContentPlugin.access$200(this.f237421a).updateCellData(r102.getData());
            SheetCellContentPlugin.access$200(this.f237421a).setCopyable(r102.isCopyable());
            SheetCellContentPlugin.access$200(this.f237421a).setBgColor(r102.getBgColor());
            SheetCellContentPlugin.access$200(this.f237421a).setMidHeight(r102.getMinHeight());
        }
    }

    public static /* synthetic */ void c(SheetCellContentPlugin r100, Boolean r101) {
        r100.lambda$onAttachToUIContainer$0(r101);
    }

    public static /* synthetic */ void d(DocumentPluginHost r100, Float r101) {
        lambda$onAttachToUIContainer$1(r100, r101);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        return true;
    }

    public SheetCellContentPlugin() {
    }

    public static /* synthetic */ tb5.m access$000(SheetCellContentPlugin r100) {
        return r100.callback;
    }

    public static /* synthetic */ SheetCellContentViewModel access$200(SheetCellContentPlugin r100) {
        return r100.sheetCellContentViewModel;
    }

    private /* synthetic */ void lambda$onAttachToUIContainer$0(Boolean r100) {
        if (Boolean.TRUE.equals(r100) == false) goto L5;
        addOrReplaceFragment(SheetCellContentPanelFragment.class);
        return;
    L5:
        removeFragment();
    }

    private void updateDocAIEnabled(DocumentPluginHost r100) {
        SheetCellContentViewModel r101 = this.sheetCellContentViewModel;     // Catch: Throwable -> L5
        yz4.b.a(r100).d(CcmDocAIScene.SHEET);     // Catch: Throwable -> L5
        r101.setDocAIEnabled(false);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e(TAG, "updateDocAIEnabled failed", th, false);
        this.sheetCellContentViewModel.setDocAIEnabled(false);
    }

    public static /* synthetic */ tb5.m access$002(SheetCellContentPlugin r100, tb5.m r101) {
        r100.callback = r101;
        return r101;
    }

    private static /* synthetic */ void lambda$onAttachToUIContainer$1(DocumentPluginHost r100, Float r101) {
        r100.b().requestUpdateWebContentHeight();
    }

    public void onAttachToUIContainer(final DocumentPluginHost r100, t r101) {
        super.onAttachToUIContainer(r100, r101);
        SheetCellContentViewModel r102 = (SheetCellContentViewModel) q.c(r100, SheetCellContentViewModel.class, null);
        this.sheetCellContentViewModel = r102;
        r102.onAttachToUI(r100, getWeb());
        this.sheetCellContentViewModel.setVCFollow(isVCFollow());
        updateDocAIEnabled(r100);
        this.sheetCellContentViewModel.getActive().observe(getLifecycleOwner(), new l(this));
        this.sheetCellContentViewModel.setOnSegmentsClickListener(new a(this));
        bindBridgeHandler(SHOW_CELL_CONTENT_NAME, new b(this));
        r100.b().registerEditPanel(getLifecycleOwner(), this.sheetCellContentViewModel);
        this.sheetCellContentViewModel.getPanelHeightData().observe(getLifecycleOwner(), new m(r100));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, t r101) {
        onAttachToUIContainer((DocumentPluginHost) r100, r101);
    }
}
