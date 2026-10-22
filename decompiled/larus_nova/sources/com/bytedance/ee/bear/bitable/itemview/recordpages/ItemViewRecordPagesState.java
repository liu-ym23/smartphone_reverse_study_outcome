package com.bytedance.ee.bear.bitable.itemview.recordpages;

import com.bytedance.ee.bear.bitable.itemview.record.ItemViewRecordData;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0011J\u0010\u0010/\u001a\u0004\u0018\u00010\u00052\u0006\u0010.\u001a\u00020\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R6\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b0\u001aj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b`\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordPagesState;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "currentRecordId", "", "getCurrentRecordId", "()Ljava/lang/String;", "setCurrentRecordId", "(Ljava/lang/String;)V", "recordList", "", "getRecordList", "()Ljava/util/List;", "setRecordList", "(Ljava/util/List;)V", "firstItemGlobalIndex", "", "getFirstItemGlobalIndex", "()I", "setFirstItemGlobalIndex", "(I)V", "totalCount", "getTotalCount", "setTotalCount", "recordDataMap", "Ljava/util/HashMap;", "Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordData;", "Lkotlin/collections/HashMap;", "getRecordDataMap", "()Ljava/util/HashMap;", "setRecordDataMap", "(Ljava/util/HashMap;)V", "traceParams", "Lcom/bytedance/ee/bear/bitable/itemview/recordpages/TraceParams;", "getTraceParams", "()Lcom/bytedance/ee/bear/bitable/itemview/recordpages/TraceParams;", "setTraceParams", "(Lcom/bytedance/ee/bear/bitable/itemview/recordpages/TraceParams;)V", "cacheRebuildData", "Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordPagesData;", "getCacheRebuildData", "()Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordPagesData;", "setCacheRebuildData", "(Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordPagesData;)V", "positionToGlobalIndex", "position", "positionToGlobalIndexText", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewRecordPagesState implements NonProguard {
    private ItemViewRecordPagesData cacheRebuildData;
    private String currentRecordId;
    private int firstItemGlobalIndex;
    private HashMap<String, ItemViewRecordData> recordDataMap;
    private List<String> recordList;
    private int totalCount;
    private TraceParams traceParams;

    public ItemViewRecordPagesState() {
        this.recordList = new ArrayList();
        this.firstItemGlobalIndex = -1;
        this.totalCount = -1;
        this.recordDataMap = new HashMap();
    }

    public final ItemViewRecordPagesData getCacheRebuildData() {
        return this.cacheRebuildData;
    }

    public final String getCurrentRecordId() {
        return this.currentRecordId;
    }

    public final int getFirstItemGlobalIndex() {
        return this.firstItemGlobalIndex;
    }

    public final HashMap<String, ItemViewRecordData> getRecordDataMap() {
        return this.recordDataMap;
    }

    public final List<String> getRecordList() {
        return this.recordList;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final TraceParams getTraceParams() {
        return this.traceParams;
    }

    public final int positionToGlobalIndex(int r100) {
        return this.firstItemGlobalIndex + r100;
    }

    public final String positionToGlobalIndexText(int r100) {
        if (this.firstItemGlobalIndex != (-1)) goto L5;
        return null;
    L5:
        if (this.totalCount == (-1)) goto L11;
        StringBuilder r101 = new StringBuilder();
        r101.append((this.firstItemGlobalIndex + r100) + 1);
        r101.append('/');
        r101.append(this.totalCount);
        return r101.toString();
    L11:
        return null;
    }

    public final void setCacheRebuildData(ItemViewRecordPagesData r100) {
        this.cacheRebuildData = r100;
    }

    public final void setCurrentRecordId(String r100) {
        this.currentRecordId = r100;
    }

    public final void setFirstItemGlobalIndex(int r100) {
        this.firstItemGlobalIndex = r100;
    }

    public final void setRecordDataMap(HashMap<String, ItemViewRecordData> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recordDataMap = r100;
    }

    public final void setRecordList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recordList = r100;
    }

    public final void setTotalCount(int r100) {
        this.totalCount = r100;
    }

    public final void setTraceParams(TraceParams r100) {
        this.traceParams = r100;
    }
}
