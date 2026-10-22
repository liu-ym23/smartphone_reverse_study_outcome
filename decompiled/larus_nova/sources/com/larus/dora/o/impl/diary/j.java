package com.larus.dora.o.impl.diary;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0014JD\u0010\u001a\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\bHÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/larus/dora/o/impl/diary/ODiaryBriefListData;", "", "items", "", "Lcom/larus/dora/o/impl/diary/ODiaryBriefItem;", "hasMore", "", "nextCursor", "", "recordedDiaryDays", "", "<init>", "(Ljava/util/List;ZLjava/lang/String;Ljava/lang/Long;)V", "getItems", "()Ljava/util/List;", "getHasMore", "()Z", "getNextCursor", "()Ljava/lang/String;", "getRecordedDiaryDays", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;ZLjava/lang/String;Ljava/lang/Long;)Lcom/larus/dora/o/impl/diary/ODiaryBriefListData;", "equals", "other", "hashCode", "", "toString", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j {

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("items")
    private final List<i> items;

    @SerializedName("next_cursor")
    private final String nextCursor;

    @SerializedName("recorded_diary_days")
    private final Long recordedDiaryDays;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.items, r101.items) == true) goto L12;
        return false;
    L12:
        if (this.hasMore == r101.hasMore) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nextCursor, r101.nextCursor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.recordedDiaryDays, r101.recordedDiaryDays) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        List<i> r100 = this.items;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        if (this.hasMore == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        String r106 = this.nextCursor;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        Long r109 = this.recordedDiaryDays;
        if (r109 == null) goto L19;
        r101 = r109.hashCode();
    L19:
        return r108 + r101;
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ODiaryBriefListData(items=" + this.items + ", hasMore=" + this.hasMore + ", nextCursor=" + this.nextCursor + ", recordedDiaryDays=" + this.recordedDiaryDays + ')';
    }

    public j() {
        this.items = null;
        this.hasMore = false;
        this.nextCursor = null;
        this.recordedDiaryDays = null;
    }

    public final boolean a() {
        return this.hasMore;
    }

    public final List<i> b() {
        return this.items;
    }

    public final String c() {
        return this.nextCursor;
    }

    public final Long d() {
        return this.recordedDiaryDays;
    }
}
