package com.bytedance.ee.bear.bitable.itemview.record;

import com.bytedance.ee.bear.bitable.itemview.cell.ItemViewRecordCellData;
import com.bytedance.ee.bear.bitable.itemview.record.list.ItemViewRenderItemData;
import com.bytedance.ee.bear.bitable.itemview.record.list.RenderItemKey;
import com.bytedance.ee.bear.bitable.itemview.recordpages.ItemViewRecordFooterData;
import com.bytedance.ee.bear.bitable.itemview.util.ReportEvent;
import com.bytedance.ee.bear.bitable.uikit.ContextField;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010T\u001a\u00020 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010+\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\u0003\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00102\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b3\u0010\u0003\u001a\u0004\b4\u0010\"\"\u0004\b5\u0010$R*\u00106\u001a\u0012\u0012\u0004\u0012\u00020807j\b\u0012\u0004\u0012\u000208`9X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=RB\u0010>\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0@0?j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0@`BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR6\u0010G\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020H0?j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020H`BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010D\"\u0004\bJ\u0010FR\u001c\u0010K\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0007\"\u0004\bM\u0010\tR\u001c\u0010N\u001a\u0004\u0018\u00010OX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010S¨\u0006U"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "titleBar", "Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordTitleBarData;", "getTitleBar", "()Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordTitleBarData;", "setTitleBar", "(Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordTitleBarData;)V", ContainerPosition.FOOTER, "Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordFooterData;", "getFooter", "()Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordFooterData;", "setFooter", "(Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordFooterData;)V", "notice1", "Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewNoticeData;", "getNotice1", "()Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewNoticeData;", "setNotice1", "(Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewNoticeData;)V", "notice2", "getNotice2", "setNotice2", "visible", "", "getVisible", "()Z", "setVisible", "(Z)V", "emptyModel", "Lcom/bytedance/ee/bear/bitable/itemview/record/EmptyData;", "getEmptyModel", "()Lcom/bytedance/ee/bear/bitable/itemview/record/EmptyData;", "setEmptyModel", "(Lcom/bytedance/ee/bear/bitable/itemview/record/EmptyData;)V", "globalIndex", "", "getGlobalIndex$annotations", "getGlobalIndex", "()I", "setGlobalIndex", "(I)V", "useNewLayout", "getUseNewLayout$annotations", "getUseNewLayout", "setUseNewLayout", "renderList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/itemview/record/list/RenderItemKey;", "Lkotlin/collections/ArrayList;", "getRenderList", "()Ljava/util/ArrayList;", "setRenderList", "(Ljava/util/ArrayList;)V", "renderDataMap", "Ljava/util/HashMap;", "Lcom/bytedance/ee/bear/bitable/itemview/record/list/ItemViewRenderItemData;", "", "Lkotlin/collections/HashMap;", "getRenderDataMap", "()Ljava/util/HashMap;", "setRenderDataMap", "(Ljava/util/HashMap;)V", "pureUIDataMap", "Lcom/bytedance/ee/bear/bitable/itemview/cell/ItemViewRecordCellData;", "getPureUIDataMap", "setPureUIDataMap", "scrollRenderId", "getScrollRenderId", "setScrollRenderId", "recordViewEvent", "Lcom/bytedance/ee/bear/bitable/itemview/util/ReportEvent;", "getRecordViewEvent", "()Lcom/bytedance/ee/bear/bitable/itemview/util/ReportEvent;", "setRecordViewEvent", "(Lcom/bytedance/ee/bear/bitable/itemview/util/ReportEvent;)V", "showEmpty", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewRecordData implements NonProguard {
    private EmptyData emptyModel;
    private ItemViewRecordFooterData footer;
    private int globalIndex;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f214012id;
    private ItemViewNoticeData notice1;
    private ItemViewNoticeData notice2;
    private HashMap<String, ItemViewRecordCellData> pureUIDataMap;
    private ReportEvent recordViewEvent;
    private HashMap<String, ItemViewRenderItemData<Object>> renderDataMap;
    private ArrayList<RenderItemKey> renderList;
    private String scrollRenderId;
    private ItemViewRecordTitleBarData titleBar;
    private boolean useNewLayout;
    private boolean visible;

    @ContextField
    public static /* synthetic */ void getGlobalIndex$annotations() {
    }

    @ContextField
    public static /* synthetic */ void getUseNewLayout$annotations() {
    }

    public final boolean showEmpty() {
        if (this.visible == true) goto L5;
    L8:
        return true;
    L5:
        if (this.emptyModel != null) goto L8;
        return false;
    }

    public ItemViewRecordData() {
        this.f214012id = "";
        this.titleBar = new ItemViewRecordTitleBarData();
        this.visible = true;
        this.useNewLayout = true;
        this.renderList = new ArrayList();
        this.renderDataMap = new HashMap();
        this.pureUIDataMap = new HashMap();
    }

    public final EmptyData getEmptyModel() {
        return this.emptyModel;
    }

    public final ItemViewRecordFooterData getFooter() {
        return this.footer;
    }

    public final int getGlobalIndex() {
        return this.globalIndex;
    }

    public final String getId() {
        return this.f214012id;
    }

    public final ItemViewNoticeData getNotice1() {
        return this.notice1;
    }

    public final ItemViewNoticeData getNotice2() {
        return this.notice2;
    }

    public final HashMap<String, ItemViewRecordCellData> getPureUIDataMap() {
        return this.pureUIDataMap;
    }

    public final ReportEvent getRecordViewEvent() {
        return this.recordViewEvent;
    }

    public final HashMap<String, ItemViewRenderItemData<Object>> getRenderDataMap() {
        return this.renderDataMap;
    }

    public final ArrayList<RenderItemKey> getRenderList() {
        return this.renderList;
    }

    public final String getScrollRenderId() {
        return this.scrollRenderId;
    }

    public final ItemViewRecordTitleBarData getTitleBar() {
        return this.titleBar;
    }

    public final boolean getUseNewLayout() {
        return this.useNewLayout;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final void setEmptyModel(EmptyData r100) {
        this.emptyModel = r100;
    }

    public final void setFooter(ItemViewRecordFooterData r100) {
        this.footer = r100;
    }

    public final void setGlobalIndex(int r100) {
        this.globalIndex = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f214012id = r100;
    }

    public final void setNotice1(ItemViewNoticeData r100) {
        this.notice1 = r100;
    }

    public final void setNotice2(ItemViewNoticeData r100) {
        this.notice2 = r100;
    }

    public final void setPureUIDataMap(HashMap<String, ItemViewRecordCellData> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pureUIDataMap = r100;
    }

    public final void setRecordViewEvent(ReportEvent r100) {
        this.recordViewEvent = r100;
    }

    public final void setRenderDataMap(HashMap<String, ItemViewRenderItemData<Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.renderDataMap = r100;
    }

    public final void setRenderList(ArrayList<RenderItemKey> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.renderList = r100;
    }

    public final void setScrollRenderId(String r100) {
        this.scrollRenderId = r100;
    }

    public final void setTitleBar(ItemViewRecordTitleBarData r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.titleBar = r100;
    }

    public final void setUseNewLayout(boolean r100) {
        this.useNewLayout = r100;
    }

    public final void setVisible(boolean r100) {
        this.visible = r100;
    }
}
