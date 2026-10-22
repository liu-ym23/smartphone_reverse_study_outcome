package com.bytedance.ee.bear.doc.blockeditpanel;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.browser.plugin.s;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;
import com.bytedance.ee.bear.doc.blockeditpanel.model.EMenuItemConfig;
import com.bytedance.ee.bear.doc.blockeditpanel.view.BlockEditPanelFragment;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.edit_toolbar.BaseSelectColorPlugin;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import com.bytedance.ee.util.ui.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00010B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ \u0010\u001f\u001a\u00020\u001c2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\"0!H\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016J\u0012\u0010&\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001c\u0010)\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u001cH\u0002J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u001aH\u0016J\u0010\u0010/\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u001aH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00060\u0017R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/doc/blockeditpanel/BlockEditPanelPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "Lcom/bytedance/ee/bear/doc/blockeditpanel/IBlockMenuClickListenerHolder;", "Lcom/bytedance/ee/bear/browser/plugin/AbilityProvider;", "<init>", "()V", "TAG", "", "JS_BIZ_UTIL_SET_PANEL_HEIGHT", "viewModel", "Lcom/bytedance/ee/bear/doc/blockeditpanel/BlockEditPanelViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/doc/blockeditpanel/BlockEditPanelViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "highlightDelegate", "Lcom/bytedance/ee/bear/document/edit_toolbar/BaseSelectColorPlugin$Delegate;", "getHighlightDelegate", "()Lcom/bytedance/ee/bear/document/edit_toolbar/BaseSelectColorPlugin$Delegate;", "highlightDelegate$delegate", "analytic", "Lcom/bytedance/ee/bear/doc/blockeditpanel/BlockEditPanelAnalytic;", "blockMenuItemsHandler", "Lcom/bytedance/ee/bear/doc/blockeditpanel/BlockEditPanelPlugin$SetBlockMenuItemsHandler;", "blockMenuClickListeners", "", "Lcom/bytedance/ee/bear/doc/blockeditpanel/IBlockMenuClickListenerHolder$BlockMenuClickListener;", "setEditStatus", "", JSEventListener.ACTION_EDIT, "", "getBridgeHandlers", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "getAbilities", "", "Lcom/bytedance/ee/bear/browser/plugin/PluginHostAbility;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "ensureFragment", "addBlockMenuClickListener", "listener", "removeBlockMenuClickListener", "SetBlockMenuItemsHandler", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockEditPanelPlugin extends DocumentPluginV2 implements com.bytedance.ee.bear.doc.blockeditpanel.b, com.bytedance.ee.bear.browser.plugin.a {
    private final String JS_BIZ_UTIL_SET_PANEL_HEIGHT;
    private final String TAG;
    private com.bytedance.ee.bear.doc.blockeditpanel.a analytic;
    private final List<com.bytedance.ee.bear.doc.blockeditpanel.b.a> blockMenuClickListeners;
    private a blockMenuItemsHandler;
    private final Lazy highlightDelegate$delegate;
    private final Lazy viewModel$delegate;

    public final class a implements i<BlockEditPanelMenusModel> {
        public m a;
        public final /* synthetic */ BlockEditPanelPlugin b;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(BlockEditPanelPlugin r1) {
            this.b = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            BlockEditPanelMenusModel r6 = (BlockEditPanelMenusModel) r4;
            tt5.a.h(BlockEditPanelPlugin.access$getTAG$p(this.b), "handle BlockMenuItemsData: " + r6);
            this.a = r5;
            BlockEditPanelPlugin.access$getViewModel(this.b).setActive(BlockEditPanelMenusModel.isValid(r6));
            BlockEditPanelPlugin.access$getViewModel(this.b).setMenuItems(r6);
            DocViewModel r7 = BlockEditPanelPlugin.access$getDocViewModel(this.b);     // Catch: Exception -> L25
            if (r7 == null) goto L12;
            w05.i r8 = r7.getDocumentInfoProvider();     // Catch: Exception -> L25
            if (r8 == null) goto L12;
            MutableLiveData<DocumentInfo> r9 = r8.g();     // Catch: Exception -> L25
            if (r9 == null) goto L12;
            DocumentInfo r10 = (DocumentInfo) r9.getValue();     // Catch: Exception -> L25
            if (r10 == null) goto L12;
            HostDocumentInfo r11 = r10.convertToHostDocumentInfo();     // Catch: Exception -> L25
        L13:
            if (r11 == null) goto L20;
            Integer r12 = r11.getType();     // Catch: Exception -> L25
            if (r12 == null) goto L20;
            if (r12.intValue() != 44) goto L20;
            boolean r13 = true;
        L21:
            if (r13 == false) goto L23;
            r11.setType(Integer.valueOf(this.b.getDocumentMetadata().getDocumentTypeValue()));     // Catch: Exception -> L25
            r11.setObjToken(this.b.getDocumentMetadata().getToken());     // Catch: Exception -> L25
        L23:
            BlockEditPanelPlugin.access$getViewModel(this.b).setHostDocumentInfo(r11);     // Catch: Exception -> L25
            return;
        L20:
            r13 = false;
        L12:
            r11 = null;
        L25:
            e = move-exception;
            tt5.a.d(BlockEditPanelPlugin.access$getTAG$p(this.b), "SetBlockMenuItemsHandler get hostDocumentInfo error " + e.getMessage());
        }
    }

    public static final class b implements BlockEditPanelViewModel.a {
        public final /* synthetic */ BlockEditPanelPlugin a;

        @Override // com.bytedance.ee.bear.doc.blockeditpanel.BlockEditPanelViewModel.a
        public final void b() {
            com.bytedance.ee.bear.doc.blockeditpanel.a r0 = BlockEditPanelPlugin.access$getAnalytic$p(this.a);
            if (r0 == null) goto L6;
            r0.a("menu_back");
            return;
        }

        @Override // com.bytedance.ee.bear.doc.blockeditpanel.BlockEditPanelViewModel.a
        public final void c() {
            com.bytedance.ee.bear.doc.blockeditpanel.a r0 = BlockEditPanelPlugin.access$getAnalytic$p(this.a);
            if (r0 == null) goto L6;
            r0.a("button_click");
            return;
        }

        @Override // com.bytedance.ee.bear.doc.blockeditpanel.BlockEditPanelViewModel.a
        public final void d() {
            com.bytedance.ee.bear.doc.blockeditpanel.a r0 = BlockEditPanelPlugin.access$getAnalytic$p(this.a);
            if (r0 == null) goto L6;
            r0.a("pulling_down");
            return;
        }

        @Override // com.bytedance.ee.bear.doc.blockeditpanel.BlockEditPanelViewModel.a
        public final void g() {
            tt5.a.h(BlockEditPanelPlugin.access$getTAG$p(this.a), "onDestroyBlockEditPanel");
        }

        public b(BlockEditPanelPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.doc.blockeditpanel.BlockEditPanelViewModel.a
        public final void e(int r9) {
            tt5.a.h(BlockEditPanelPlugin.access$getTAG$p(this.a), "onClosePanel, level: " + r9);
            BlockEditPanelPlugin r2 = this.a;
            JSONObject r4 = new JSONObject();
            r4.put("closedLevel", Integer.valueOf(r9));
            Unit r10 = Unit.INSTANCE;
            DocumentPluginV2.dispatchBridgeMsg$default(r2, "lark.biz.navigation.closeBlockMenuPanel", r4, null, 4, null);
        }

        @Override // com.bytedance.ee.bear.doc.blockeditpanel.BlockEditPanelViewModel.a
        public final void onPanelHeightChanged(int r9) {
            if (Intrinsics.areEqual(BlockEditPanelPlugin.access$getViewModel(this.a).getActive().getValue(), Boolean.TRUE) == true) goto L5;
            return;
        L5:
            int r10 = n.E(r9);
            tt5.a.h(BlockEditPanelPlugin.access$getTAG$p(this.a), "onPanelHeightChanged. height=" + r10);
            BlockEditPanelPlugin r2 = this.a;
            String r3 = BlockEditPanelPlugin.access$getJS_BIZ_UTIL_SET_PANEL_HEIGHT$p(r2);
            JSONObject r4 = new JSONObject();
            r4.put("height", Integer.valueOf(r10));
            Unit r11 = Unit.INSTANCE;
            DocumentPluginV2.dispatchBridgeMsg$default(r2, r3, r4, null, 4, null);
        }

        @Override // com.bytedance.ee.bear.doc.blockeditpanel.BlockEditPanelViewModel.a
        public final void f(BlockEditPanelMenusModel.BlockEditPanelMenuItem r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r5, "menuItem");
            Iterator r1 = new ArrayList(BlockEditPanelPlugin.access$getBlockMenuClickListeners$p(this.a)).iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((com.bytedance.ee.bear.doc.blockeditpanel.b.a) r1.next()).a(r5.getId());
            goto L4
        L6:
            a r2 = BlockEditPanelPlugin.access$getBlockMenuItemsHandler$p(this.a);
            r2.getClass();
            Intrinsics.checkNotNullParameter(r5, "menuItem");
            JSONObject r0 = new JSONObject();
            String r3 = r5.getId();
            r0.put("id", r3);
            if (TextUtils.equals(r3, EMenuItemConfig.HIGHLIGHT.id) == false) goto L9;
            r0.put("clickDropdown", Boolean.valueOf(r6));
            r0.put("backgroundColor", r5.getBackgroundColor());
            r0.put("foregroundColor", r5.getForegroundColor());
        L9:
            tt5.a.h(BlockEditPanelPlugin.access$getTAG$p(r2.b), "onClickMenuItem: " + r0);
            m r7 = r2.a;
            if (r7 == null) goto L14;
            r7.b(r0);
            return;
        }

        @Override // com.bytedance.ee.bear.doc.blockeditpanel.BlockEditPanelViewModel.a
        public final void a(Highlight.ColorItem r3, Highlight.ColorItem r4, Highlight.ColorItem r5, Highlight.ColorItem r6) {
            tt5.a.h(BlockEditPanelPlugin.access$getTAG$p(this.a), "onClickColorMenuItem");
            BaseSelectColorPlugin r0 = (BaseSelectColorPlugin) BlockEditPanelPlugin.access$findPlugin(this.a, BaseSelectColorPlugin.class);
            if (r0 == null) goto L6;
            r0.processItemClick(r3, r4, r5, r6);
            return;
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final BaseSelectColorPlugin.a getHighlightDelegate() {
        return (BaseSelectColorPlugin.a) this.highlightDelegate$delegate.getValue();
    }

    private final BlockEditPanelViewModel getViewModel() {
        return (BlockEditPanelViewModel) this.viewModel$delegate.getValue();
    }

    public BlockEditPanelPlugin() {
        this.TAG = "BlockEditPanelPlugin";
        this.JS_BIZ_UTIL_SET_PANEL_HEIGHT = "lark.biz.util.setPanelHeight";
        this.viewModel$delegate = LazyKt.lazy(new BlockEditPanelPlugin$viewModel$2(this));
        this.highlightDelegate$delegate = LazyKt.lazy(new BlockEditPanelPlugin$highlightDelegate$2(this));
        this.blockMenuItemsHandler = new a(this);
        this.blockMenuClickListeners = new ArrayList();
    }

    private final void ensureFragment() {
        if (getUIContainer() != null) goto L6;
        return;
    L6:
        if (getUIContainer().l(this) != null) goto L13;
        Fragment r0 = instantiateFragment(BlockEditPanelFragment.class);
        BlockEditPanelFragment r1 = (BlockEditPanelFragment) r0;
        rz4.a r2 = (rz4.a) getHostAbilityOrNull(rz4.a.class);
        if (r2 == null) goto L10;
        boolean r3 = r2.padModel();
    L11:
        r1.l = r3;
        getUIContainer().e(this, r0, s.a(2130772601, 2130772603, 0, 0));
        return;
    L10:
        r3 = false;
        goto L11
    }

    @Override // com.bytedance.ee.bear.browser.plugin.a
    public List<com.bytedance.ee.bear.browser.plugin.i> getAbilities() {
        return CollectionsKt.listOf(this);
    }

    public static final /* synthetic */ void access$ensureFragment(BlockEditPanelPlugin r0) {
        r0.ensureFragment();
    }

    public static final /* synthetic */ com.bytedance.ee.bear.doc.blockeditpanel.a access$getAnalytic$p(BlockEditPanelPlugin r0) {
        return r0.analytic;
    }

    public static final /* synthetic */ List access$getBlockMenuClickListeners$p(BlockEditPanelPlugin r0) {
        return r0.blockMenuClickListeners;
    }

    public static final /* synthetic */ a access$getBlockMenuItemsHandler$p(BlockEditPanelPlugin r0) {
        return r0.blockMenuItemsHandler;
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(BlockEditPanelPlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ BaseSelectColorPlugin.a access$getHighlightDelegate(BlockEditPanelPlugin r0) {
        return r0.getHighlightDelegate();
    }

    public static final /* synthetic */ String access$getJS_BIZ_UTIL_SET_PANEL_HEIGHT$p(BlockEditPanelPlugin r0) {
        return r0.JS_BIZ_UTIL_SET_PANEL_HEIGHT;
    }

    public static final /* synthetic */ String access$getTAG$p(BlockEditPanelPlugin r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ BlockEditPanelViewModel access$getViewModel(BlockEditPanelPlugin r0) {
        return r0.getViewModel();
    }

    public static final /* synthetic */ void access$removeFragment(BlockEditPanelPlugin r0) {
        r0.removeFragment();
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.b
    public void addBlockMenuClickListener(com.bytedance.ee.bear.doc.blockeditpanel.b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.blockMenuClickListeners.contains(r2) == true) goto L6;
        this.blockMenuClickListeners.add(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.navigation.setBlockMenuPanelItems", this.blockMenuItemsHandler);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r3) {
        super.onAttachToHost(r3);
        getViewModel().getActive().observe(getLifecycleOwner(), new AnonymousClass1(this));
        getViewModel().setDelegate(new b(this));
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.b
    public void removeBlockMenuClickListener(com.bytedance.ee.bear.doc.blockeditpanel.b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.blockMenuClickListeners.remove(r2);
    }

    public final void setEditStatus(boolean r2) {
        getViewModel().setEditStatus(r2);
    }

    public static final /* synthetic */ f access$findPlugin(BlockEditPanelPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ ViewModel access$viewModel(BlockEditPanelPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r4, t r5) {
        super.onAttachToUIContainer(r4, r5);
        this.analytic = new com.bytedance.ee.bear.doc.blockeditpanel.a(getEditorAbility().getDocumentMetadata().getBearUrl(), (d) org.koin.java.a.c(d.class, null, null, 6));
    }
}
