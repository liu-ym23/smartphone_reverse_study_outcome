package com.bytedance.locallife.groupon.api.toptools.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/bytedance/locallife/groupon/api/toptools/model/TopToolsEntranceStruct;", "", "itemList", "", "Lcom/bytedance/locallife/groupon/api/toptools/model/EntranceStruct;", "(Ljava/util/List;)V", "fromSetting", "", "getFromSetting", "()Z", "setFromSetting", "(Z)V", "getItemList", "()Ljava/util/List;", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class TopToolsEntranceStruct {
    private boolean fromSetting;

    @SerializedName("item_list")
    private final List<EntranceStruct> itemList;

    /* JADX WARN: Multi-variable type inference failed */
    public TopToolsEntranceStruct() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TopToolsEntranceStruct copy$default(TopToolsEntranceStruct r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.itemList;
    L6:
        return r100.copy(r101);
    }

    public final List<EntranceStruct> component1() {
        return this.itemList;
    }

    public final TopToolsEntranceStruct copy(List<EntranceStruct> r100) {
        return new TopToolsEntranceStruct(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TopToolsEntranceStruct) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.itemList, ((TopToolsEntranceStruct) r100).itemList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<EntranceStruct> r100 = this.itemList;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "TopToolsEntranceStruct(itemList=" + this.itemList + ')';
    }

    public final boolean getFromSetting() {
        return this.fromSetting;
    }

    public final List<EntranceStruct> getItemList() {
        return this.itemList;
    }

    public TopToolsEntranceStruct(List<EntranceStruct> r100) {
        this.itemList = r100;
    }

    public final void setFromSetting(boolean r100) {
        this.fromSetting = r100;
    }

    public /* synthetic */ TopToolsEntranceStruct(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        this(r100);
    }
}
