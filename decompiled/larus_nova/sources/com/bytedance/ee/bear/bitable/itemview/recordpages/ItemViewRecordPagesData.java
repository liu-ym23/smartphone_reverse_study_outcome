package com.bytedance.ee.bear.bitable.itemview.recordpages;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.UpdateStrategy;
import com.bytedance.ee.bear.bitable.itemview.record.ItemViewRecordData;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010Z\u001a\u00020\u001eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\u001a\u0010&\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\u001c\u0010)\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\b\"\u0004\b+\u0010\nR\u001a\u0010,\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\u001c\u0010/\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\b\"\u0004\b1\u0010\nR \u00102\u001a\b\u0012\u0004\u0012\u00020\u000603X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R&\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020:09X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001a\"\u0004\bA\u0010\u001cR\u001a\u0010B\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001a\"\u0004\bD\u0010\u001cR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001a\u0010W\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010 \"\u0004\bY\u0010\"¨\u0006["}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordPagesData;", "Lcom/bytedance/ee/bear/bitable/itemview/recordpages/PagesContextData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "baseId", "", "getBaseId", "()Ljava/lang/String;", "setBaseId", "(Ljava/lang/String;)V", "baseName", "getBaseName", "setBaseName", "tableId", "getTableId", "setTableId", "viewId", "getViewId", "setViewId", "recordId", "getRecordId", "setRecordId", "mode", "", "getMode", "()I", "setMode", "(I)V", "useNewLayout", "", "getUseNewLayout", "()Z", "setUseNewLayout", "(Z)V", "tableRev", "getTableRev", "setTableRev", "layout", "getLayout", "setLayout", "fieldId", "getFieldId", "setFieldId", "needConfirm", "getNeedConfirm", "setNeedConfirm", "forceCurrentRecordId", "getForceCurrentRecordId", "setForceCurrentRecordId", "recordList", "", "getRecordList", "()Ljava/util/List;", "setRecordList", "(Ljava/util/List;)V", "recordDataMap", "", "Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordData;", "getRecordDataMap", "()Ljava/util/Map;", "setRecordDataMap", "(Ljava/util/Map;)V", "firstItemGlobalIndex", "getFirstItemGlobalIndex", "setFirstItemGlobalIndex", "totalCount", "getTotalCount", "setTotalCount", "updateStrategy", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/UpdateStrategy;", "getUpdateStrategy", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/UpdateStrategy;", "setUpdateStrategy", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/UpdateStrategy;)V", "traceParams", "Lcom/bytedance/ee/bear/bitable/itemview/recordpages/TraceParams;", "getTraceParams", "()Lcom/bytedance/ee/bear/bitable/itemview/recordpages/TraceParams;", "setTraceParams", "(Lcom/bytedance/ee/bear/bitable/itemview/recordpages/TraceParams;)V", "firstOpenCommentData", "Lcom/bytedance/ee/bear/bitable/itemview/recordpages/OpenCommentData;", "getFirstOpenCommentData", "()Lcom/bytedance/ee/bear/bitable/itemview/recordpages/OpenCommentData;", "setFirstOpenCommentData", "(Lcom/bytedance/ee/bear/bitable/itemview/recordpages/OpenCommentData;)V", "fromCache", "getFromCache", "setFromCache", "isConfigLayout", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewRecordPagesData implements v, NonProguard {
    private String baseId;
    private String baseName;
    private String fieldId;
    private int firstItemGlobalIndex;
    private OpenCommentData firstOpenCommentData;
    private String forceCurrentRecordId;
    private boolean fromCache;
    private int layout;
    private int mode;
    private boolean needConfirm;
    private Map<String, ItemViewRecordData> recordDataMap;
    private String recordId;
    private List<String> recordList;
    private String tableId;
    private int tableRev;
    private int totalCount;
    private TraceParams traceParams;
    private UpdateStrategy updateStrategy;
    private boolean useNewLayout;
    private String viewId;

    public final boolean isConfigLayout() {
        if (this.layout == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public ItemViewRecordPagesData() {
        this.baseId = "";
        this.baseName = "";
        this.tableId = "";
        this.viewId = "";
        this.recordId = "";
        this.useNewLayout = true;
        this.recordList = CollectionsKt.emptyList();
        this.recordDataMap = new HashMap();
        this.firstItemGlobalIndex = -1;
        this.totalCount = -1;
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.recordpages.v
    public String getBaseId() {
        return this.baseId;
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.recordpages.v
    public String getBaseName() {
        return this.baseName;
    }

    public final String getFieldId() {
        return this.fieldId;
    }

    public final int getFirstItemGlobalIndex() {
        return this.firstItemGlobalIndex;
    }

    public final OpenCommentData getFirstOpenCommentData() {
        return this.firstOpenCommentData;
    }

    public final String getForceCurrentRecordId() {
        return this.forceCurrentRecordId;
    }

    public final boolean getFromCache() {
        return this.fromCache;
    }

    public final int getLayout() {
        return this.layout;
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.recordpages.v
    public int getMode() {
        return this.mode;
    }

    public final boolean getNeedConfirm() {
        return this.needConfirm;
    }

    public final Map<String, ItemViewRecordData> getRecordDataMap() {
        return this.recordDataMap;
    }

    public String getRecordId() {
        return this.recordId;
    }

    public final List<String> getRecordList() {
        return this.recordList;
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.recordpages.v
    public String getTableId() {
        return this.tableId;
    }

    public final int getTableRev() {
        return this.tableRev;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final TraceParams getTraceParams() {
        return this.traceParams;
    }

    public final UpdateStrategy getUpdateStrategy() {
        return this.updateStrategy;
    }

    public boolean getUseNewLayout() {
        return this.useNewLayout;
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.recordpages.v
    public String getViewId() {
        return this.viewId;
    }

    public void setBaseId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.baseId = r100;
    }

    public void setBaseName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.baseName = r100;
    }

    public final void setFieldId(String r100) {
        this.fieldId = r100;
    }

    public final void setFirstItemGlobalIndex(int r100) {
        this.firstItemGlobalIndex = r100;
    }

    public final void setFirstOpenCommentData(OpenCommentData r100) {
        this.firstOpenCommentData = r100;
    }

    public final void setForceCurrentRecordId(String r100) {
        this.forceCurrentRecordId = r100;
    }

    public final void setFromCache(boolean r100) {
        this.fromCache = r100;
    }

    public final void setLayout(int r100) {
        this.layout = r100;
    }

    public void setMode(int r100) {
        this.mode = r100;
    }

    public final void setNeedConfirm(boolean r100) {
        this.needConfirm = r100;
    }

    public final void setRecordDataMap(Map<String, ItemViewRecordData> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recordDataMap = r100;
    }

    public void setRecordId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recordId = r100;
    }

    public final void setRecordList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recordList = r100;
    }

    public void setTableId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tableId = r100;
    }

    public final void setTableRev(int r100) {
        this.tableRev = r100;
    }

    public final void setTotalCount(int r100) {
        this.totalCount = r100;
    }

    public final void setTraceParams(TraceParams r100) {
        this.traceParams = r100;
    }

    public final void setUpdateStrategy(UpdateStrategy r100) {
        this.updateStrategy = r100;
    }

    public void setUseNewLayout(boolean r100) {
        this.useNewLayout = r100;
    }

    public void setViewId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.viewId = r100;
    }
}
