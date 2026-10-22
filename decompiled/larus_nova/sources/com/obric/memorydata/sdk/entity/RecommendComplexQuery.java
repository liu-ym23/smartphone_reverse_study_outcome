package com.obric.memorydata.sdk.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0001!B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0014HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\""}, d2 = {"Lcom/obric/memorydata/sdk/entity/RecommendComplexQuery;", "Landroid/os/Parcelable;", "query", "", "reason", "sourceData", "meta", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getQuery", "()Ljava/lang/String;", "getReason", "getSourceData", "getMeta", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RecommendComplexQuery implements Parcelable {
    public static final a CREATOR = null;

    @SerializedName("meta")
    private final String meta;

    @SerializedName("query")
    private final String query;

    @SerializedName("reason")
    private final String reason;

    @SerializedName("sourceData")
    private final String sourceData;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<RecommendComplexQuery> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RecommendComplexQuery createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new RecommendComplexQuery(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final RecommendComplexQuery[] newArray(int r100) {
            return new RecommendComplexQuery[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ RecommendComplexQuery copy$default(RecommendComplexQuery r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.query;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.reason;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.sourceData;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.meta;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.query;
    }

    public final String component2() {
        return this.reason;
    }

    public final String component3() {
        return this.sourceData;
    }

    public final String component4() {
        return this.meta;
    }

    public final RecommendComplexQuery copy(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "query");
        Intrinsics.checkNotNullParameter(r101, "reason");
        Intrinsics.checkNotNullParameter(r102, "sourceData");
        Intrinsics.checkNotNullParameter(r103, "meta");
        return new RecommendComplexQuery(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RecommendComplexQuery) == true) goto L8;
        return false;
    L8:
        RecommendComplexQuery r101 = (RecommendComplexQuery) r100;
        if (Intrinsics.areEqual(this.query, r101.query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.reason, r101.reason) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sourceData, r101.sourceData) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.meta, r101.meta) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.query.hashCode() * 31) + this.reason.hashCode()) * 31) + this.sourceData.hashCode()) * 31) + this.meta.hashCode();
    }

    public String toString() {
        return "RecommendComplexQuery(query=" + this.query + ", reason=" + this.reason + ", sourceData=" + this.sourceData + ", meta=" + this.meta + ')';
    }

    public final String getMeta() {
        return this.meta;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getSourceData() {
        return this.sourceData;
    }

    public RecommendComplexQuery(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        String r101 = r100.readString();
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        String r103 = r100.readString();
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        String r104 = r100.readString();
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        String r105 = r100.readString();
        if (r105 == null) goto L15;
        r102 = r105;
    L15:
        this(r101, r103, r104, r102);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.query);
        r100.writeString(this.reason);
        r100.writeString(this.sourceData);
        r100.writeString(this.meta);
    }

    public RecommendComplexQuery(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "query");
        Intrinsics.checkNotNullParameter(r101, "reason");
        Intrinsics.checkNotNullParameter(r102, "sourceData");
        Intrinsics.checkNotNullParameter(r103, "meta");
        this.query = r100;
        this.reason = r101;
        this.sourceData = r102;
        this.meta = r103;
    }

    public /* synthetic */ RecommendComplexQuery(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = "";
    L5:
        this(r100, r101, r102, r103);
    }
}
