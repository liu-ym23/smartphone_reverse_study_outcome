package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0001#B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0016HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/RewriteQuery;", "Landroid/os/Parcelable;", "domain", "", "query", "type", "subDomain", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getDomain", "()Ljava/lang/String;", "getQuery", "getType", "getSubDomain", "()Ljava/util/Set;", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RewriteQuery implements Parcelable {
    public static final a CREATOR = null;
    private final String domain;
    private final String query;
    private final Set<String> subDomain;
    private final String type;

    public static final class a implements Parcelable.Creator<RewriteQuery> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RewriteQuery createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new RewriteQuery(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final RewriteQuery[] newArray(int r100) {
            return new RewriteQuery[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RewriteQuery copy$default(RewriteQuery r100, String r101, String r102, String r103, Set r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.domain;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.query;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.type;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.subDomain;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.domain;
    }

    public final String component2() {
        return this.query;
    }

    public final String component3() {
        return this.type;
    }

    public final Set<String> component4() {
        return this.subDomain;
    }

    public final RewriteQuery copy(String r100, String r101, String r102, Set<String> r103) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        Intrinsics.checkNotNullParameter(r101, "query");
        return new RewriteQuery(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RewriteQuery) == true) goto L8;
        return false;
    L8:
        RewriteQuery r101 = (RewriteQuery) r100;
        if (Intrinsics.areEqual(this.domain, r101.domain) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.query, r101.query) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.subDomain, r101.subDomain) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.domain.hashCode() * 31) + this.query.hashCode()) * 31;
        String r101 = this.type;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Set<String> r105 = this.subDomain;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "RewriteQuery(domain=" + this.domain + ", query=" + this.query + ", type=" + this.type + ", subDomain=" + this.subDomain + ')';
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getQuery() {
        return this.query;
    }

    public final Set<String> getSubDomain() {
        return this.subDomain;
    }

    public final String getType() {
        return this.type;
    }

    public RewriteQuery(Parcel r100) {
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
        String r104 = r100.readString();
        if (r104 != null) goto L12;
        r104 = "default";
    L12:
        String[] r105 = r100.createStringArray();
        if (r105 == null) goto L15;
        Set r106 = ArraysKt.toSet(r105);
    L16:
        this(r101, r102, r104, r106);
        return;
    L15:
        r106 = null;
        goto L16
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.domain);
        r100.writeString(this.query);
        r100.writeString(this.type);
        Set<String> r102 = this.subDomain;
        if (r102 == null) goto L5;
        String[] r103 = (String[]) r102.toArray(new String[0]);
    L6:
        r100.writeStringArray(r103);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public RewriteQuery(String r100, String r101, String r102, Set<String> r103) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        Intrinsics.checkNotNullParameter(r101, "query");
        this.domain = r100;
        this.query = r101;
        this.type = r102;
        this.subDomain = r103;
    }

    public /* synthetic */ RewriteQuery(String r100, String r101, String r102, Set r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        this(r100, r101, r102, r103);
    }
}
