package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0010HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/SearchDomainQuery;", "Landroid/os/Parcelable;", "domain", "", "query", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getDomain", "()Ljava/lang/String;", "getQuery", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SearchDomainQuery implements Parcelable {
    public static final a CREATOR = null;

    @SerializedName("domain")
    private final String domain;

    @SerializedName("query")
    private final String query;

    public static final class a implements Parcelable.Creator<SearchDomainQuery> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SearchDomainQuery createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new SearchDomainQuery(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SearchDomainQuery[] newArray(int r100) {
            return new SearchDomainQuery[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchDomainQuery() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SearchDomainQuery copy$default(SearchDomainQuery r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.domain;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.query;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.domain;
    }

    public final String component2() {
        return this.query;
    }

    public final SearchDomainQuery copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        Intrinsics.checkNotNullParameter(r101, "query");
        return new SearchDomainQuery(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SearchDomainQuery) == true) goto L8;
        return false;
    L8:
        SearchDomainQuery r101 = (SearchDomainQuery) r100;
        if (Intrinsics.areEqual(this.domain, r101.domain) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.query, r101.query) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.domain.hashCode() * 31) + this.query.hashCode();
    }

    public String toString() {
        return "SearchDomainQuery(domain=" + this.domain + ", query=" + this.query + ')';
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getQuery() {
        return this.query;
    }

    public SearchDomainQuery(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        String r101 = r100.readString();
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        String r103 = r100.readString();
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        this(r101, r102);
    }

    public SearchDomainQuery(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        Intrinsics.checkNotNullParameter(r101, "query");
        this.domain = r100;
        this.query = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.domain);
        r100.writeString(this.query);
    }

    public /* synthetic */ SearchDomainQuery(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
