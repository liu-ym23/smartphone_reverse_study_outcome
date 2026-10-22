package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001%B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J1\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0019HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0015¨\u0006&"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/GlobalQUResult;", "Landroid/os/Parcelable;", "origin_query", "", "query_rewrite", "", "Lcom/obric/memorydata/sdk/entity/search/RewriteQuery;", "slot_result", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getOrigin_query", "()Ljava/lang/String;", "getQuery_rewrite", "()Ljava/util/List;", "setQuery_rewrite", "(Ljava/util/List;)V", "getSlot_result", "setSlot_result", "(Ljava/lang/String;)V", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalQUResult implements Parcelable {
    public static final a CREATOR = null;
    private final String origin_query;
    private List<RewriteQuery> query_rewrite;
    private String slot_result;

    public static final class a implements Parcelable.Creator<GlobalQUResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GlobalQUResult createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new GlobalQUResult(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final GlobalQUResult[] newArray(int r100) {
            return new GlobalQUResult[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GlobalQUResult copy$default(GlobalQUResult r100, String r101, List r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.origin_query;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.query_rewrite;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.slot_result;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.origin_query;
    }

    public final List<RewriteQuery> component2() {
        return this.query_rewrite;
    }

    public final String component3() {
        return this.slot_result;
    }

    public final GlobalQUResult copy(String r100, List<RewriteQuery> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "origin_query");
        return new GlobalQUResult(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GlobalQUResult) == true) goto L8;
        return false;
    L8:
        GlobalQUResult r101 = (GlobalQUResult) r100;
        if (Intrinsics.areEqual(this.origin_query, r101.origin_query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.query_rewrite, r101.query_rewrite) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.slot_result, r101.slot_result) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.origin_query.hashCode() * 31;
        List<RewriteQuery> r101 = this.query_rewrite;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.slot_result;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "GlobalQUResult(origin_query=" + this.origin_query + ", query_rewrite=" + this.query_rewrite + ", slot_result=" + this.slot_result + ')';
    }

    public final String getOrigin_query() {
        return this.origin_query;
    }

    public final List<RewriteQuery> getQuery_rewrite() {
        return this.query_rewrite;
    }

    public final String getSlot_result() {
        return this.slot_result;
    }

    public GlobalQUResult(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        String r101 = r100.readString();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this(r101, r100.createTypedArrayList(RewriteQuery.CREATOR), r100.readString());
    }

    public final void setQuery_rewrite(List<RewriteQuery> r100) {
        this.query_rewrite = r100;
    }

    public final void setSlot_result(String r100) {
        this.slot_result = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.origin_query);
        r100.writeTypedList(this.query_rewrite);
        r100.writeString(this.slot_result);
    }

    public GlobalQUResult(String r100, List<RewriteQuery> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "origin_query");
        this.origin_query = r100;
        this.query_rewrite = r101;
        this.slot_result = r102;
    }

    public /* synthetic */ GlobalQUResult(String r100, List r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
