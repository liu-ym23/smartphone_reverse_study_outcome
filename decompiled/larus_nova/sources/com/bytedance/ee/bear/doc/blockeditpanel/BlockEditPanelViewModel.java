package com.bytedance.ee.bear.doc.blockeditpanel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import ey4.g;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0006J\u000e\u0010)\u001a\u00020'2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,J\u0016\u0010-\u001a\u00020'2\u0006\u0010+\u001a\u00020,2\u0006\u0010.\u001a\u00020\nJ\u0006\u0010/\u001a\u00020'J\u000e\u00100\u001a\u00020'2\u0006\u00101\u001a\u000202J.\u00103\u001a\u00020'2\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001052\b\u00107\u001a\u0004\u0018\u0001052\b\u00108\u001a\u0004\u0018\u000105J\u000e\u00109\u001a\u00020'2\u0006\u0010:\u001a\u000202J\u000e\u0010;\u001a\u00020'2\u0006\u00101\u001a\u000202J\u000e\u0010<\u001a\u00020'2\u0006\u00101\u001a\u000202J\u000e\u0010=\u001a\u00020'2\u0006\u00101\u001a\u000202R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR!\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006?"}, d2 = {"Lcom/bytedance/ee/bear/doc/blockeditpanel/BlockEditPanelViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "menuItems", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/doc/blockeditpanel/model/BlockEditPanelMenusModel;", "getMenuItems", "()Landroidx/lifecycle/MutableLiveData;", "active", "", "getActive", "delegate", "Lcom/bytedance/ee/bear/doc/blockeditpanel/BlockEditPanelViewModel$Delegate;", "getDelegate", "()Lcom/bytedance/ee/bear/doc/blockeditpanel/BlockEditPanelViewModel$Delegate;", "setDelegate", "(Lcom/bytedance/ee/bear/doc/blockeditpanel/BlockEditPanelViewModel$Delegate;)V", "highlight", "Lcom/bytedance/ee/bear/document/model/toolbar/selectcolor/impl/Highlight;", "getHighlight", "panelHeightInfoList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/doc/blockeditpanel/view/panel/PanelHeightInfo;", "Lkotlin/collections/ArrayList;", "getPanelHeightInfoList", "()Ljava/util/ArrayList;", "editStatus", "getEditStatus", "()Z", "setEditStatus", "(Z)V", "hostDocumentInfo", "Lcom/bytedance/ee/bear/middleground_permission_export/model/audit/HostDocumentInfo;", "getHostDocumentInfo", "()Lcom/bytedance/ee/bear/middleground_permission_export/model/audit/HostDocumentInfo;", "setHostDocumentInfo", "(Lcom/bytedance/ee/bear/middleground_permission_export/model/audit/HostDocumentInfo;)V", "setMenuItems", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "setActive", "onClickEditMenuItem", "menuItem", "Lcom/bytedance/ee/bear/doc/blockeditpanel/model/BlockEditPanelMenusModel$BlockEditPanelMenuItem;", "onClickHighlightItem", "isDropdown", "onDestroyEditPanel", "onCloseEditPanel", "level", "", "onClickColorMenuItem", "backgroundItem", "Lcom/bytedance/ee/bear/document/model/toolbar/selectcolor/impl/Highlight$ColorItem;", "textItem", "clearItem", "resetItem", "onPanelHeightChanged", "height", "onPullingDown", "onClickBack", "onClickTriangleButton", "Delegate", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockEditPanelViewModel extends ViewModel {
    private final MutableLiveData<Boolean> active;
    private a delegate;
    private boolean editStatus;
    private final MutableLiveData<Highlight> highlight;
    private HostDocumentInfo hostDocumentInfo;
    private final MutableLiveData<BlockEditPanelMenusModel> menuItems;
    private final ArrayList<g> panelHeightInfoList;

    public interface a {
        void a(Highlight.ColorItem r100, Highlight.ColorItem r101, Highlight.ColorItem r102, Highlight.ColorItem r103);

        void b();

        void c();

        void d();

        void e(int r100);

        void f(BlockEditPanelMenusModel.BlockEditPanelMenuItem r100, boolean r101);

        void g();

        void onPanelHeightChanged(int r100);
    }

    public final void onDestroyEditPanel() {
        setActive(false);
        a r100 = this.delegate;
        if (r100 == null) goto L6;
        r100.g();
        return;
    }

    public BlockEditPanelViewModel() {
        this.menuItems = new MutableLiveData();
        this.active = new MutableLiveData();
        this.highlight = new MutableLiveData();
        this.panelHeightInfoList = new ArrayList();
    }

    public final MutableLiveData<Boolean> getActive() {
        return this.active;
    }

    public final a getDelegate() {
        return this.delegate;
    }

    public final boolean getEditStatus() {
        return this.editStatus;
    }

    public final MutableLiveData<Highlight> getHighlight() {
        return this.highlight;
    }

    public final HostDocumentInfo getHostDocumentInfo() {
        return this.hostDocumentInfo;
    }

    public final MutableLiveData<BlockEditPanelMenusModel> getMenuItems() {
        return this.menuItems;
    }

    public final ArrayList<g> getPanelHeightInfoList() {
        return this.panelHeightInfoList;
    }

    public final void onClickBack(int r100) {
        a r101 = this.delegate;
        if (r101 == null) goto L6;
        r101.b();
        return;
    }

    public final void onClickEditMenuItem(BlockEditPanelMenusModel.BlockEditPanelMenuItem r100) {
        Intrinsics.checkNotNullParameter(r100, "menuItem");
        a r101 = this.delegate;
        if (r101 == null) goto L6;
        r101.f(r100, false);
        return;
    }

    public final void onClickTriangleButton(int r100) {
        a r101 = this.delegate;
        if (r101 == null) goto L6;
        r101.c();
        return;
    }

    public final void onCloseEditPanel(int r100) {
        a r101 = this.delegate;
        if (r101 == null) goto L6;
        r101.e(r100);
        return;
    }

    public final void onPanelHeightChanged(int r100) {
        a r101 = this.delegate;
        if (r101 == null) goto L6;
        r101.onPanelHeightChanged(r100);
        return;
    }

    public final void onPullingDown(int r100) {
        a r101 = this.delegate;
        if (r101 == null) goto L6;
        r101.d();
        return;
    }

    public final void setActive(boolean r100) {
        this.active.setValue(Boolean.valueOf(r100));
    }

    public final void setDelegate(a r100) {
        this.delegate = r100;
    }

    public final void setEditStatus(boolean r100) {
        this.editStatus = r100;
    }

    public final void setHostDocumentInfo(HostDocumentInfo r100) {
        this.hostDocumentInfo = r100;
    }

    public final void setMenuItems(BlockEditPanelMenusModel r100) {
        this.menuItems.setValue(r100);
    }

    public final void onClickHighlightItem(BlockEditPanelMenusModel.BlockEditPanelMenuItem r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "menuItem");
        a r102 = this.delegate;
        if (r102 == null) goto L6;
        r102.f(r100, r101);
        return;
    }

    public final void onClickColorMenuItem(Highlight.ColorItem r100, Highlight.ColorItem r101, Highlight.ColorItem r102, Highlight.ColorItem r103) {
        a r104 = this.delegate;
        if (r104 == null) goto L6;
        r104.a(r100, r101, r102, r103);
        return;
    }
}
