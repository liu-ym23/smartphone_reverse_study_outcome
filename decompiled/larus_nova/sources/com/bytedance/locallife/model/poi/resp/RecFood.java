package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/RecFood;", "Ljava/io/Serializable;", "itemId", "", "title", "start", "", "end", "(Ljava/lang/String;Ljava/lang/String;II)V", "getEnd", "()I", "getItemId", "()Ljava/lang/String;", "getStart", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class RecFood implements Serializable {

    @SerializedName("end")
    private final int end;

    @SerializedName("item_id")
    private final String itemId;

    @SerializedName("start")
    private final int start;

    @SerializedName("title")
    private final String title;

    public RecFood() {
        this(null, null, 0, 0, 15, null);
    }

    public static /* synthetic */ RecFood copy$default(RecFood r100, String r101, String r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.itemId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.title;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.start;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.end;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.itemId;
    }

    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.start;
    }

    public final int component4() {
        return this.end;
    }

    public final RecFood copy(String r100, String r101, int r102, int r103) {
        return new RecFood(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RecFood) == true) goto L8;
        return false;
    L8:
        RecFood r101 = (RecFood) r100;
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (this.start == r101.start) goto L18;
        return false;
    L18:
        if (this.end == r101.end) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.itemId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((((r103 + r101) * 31) + this.start) * 31) + this.end;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RecFood(itemId=" + this.itemId + ", title=" + this.title + ", start=" + this.start + ", end=" + this.end + ')';
    }

    public final int getEnd() {
        return this.end;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final int getStart() {
        return this.start;
    }

    public final String getTitle() {
        return this.title;
    }

    public RecFood(String r100, String r101, int r102, int r103) {
        this.itemId = r100;
        this.title = r101;
        this.start = r102;
        this.end = r103;
    }

    public /* synthetic */ RecFood(String r100, String r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
