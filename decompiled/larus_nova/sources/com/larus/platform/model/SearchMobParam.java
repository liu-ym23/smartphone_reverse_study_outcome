package com.larus.platform.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010$\u001a\u00020%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020%HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020%R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u00061"}, d2 = {"Lcom/larus/platform/model/SearchMobParam;", "Landroid/os/Parcelable;", "query", "", "queryId", "searchId", "searchRequestId", "searchResultId", "rank", "recommendFrom", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "getQueryId", "setQueryId", "getSearchId", "setSearchId", "getSearchRequestId", "setSearchRequestId", "getSearchResultId", "setSearchResultId", "getRank", "setRank", "getRecommendFrom", "setRecommendFrom", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchMobParam implements Parcelable {
    public static final Parcelable.Creator<SearchMobParam> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f365487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f365488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f365489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f365490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f365491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f365492f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f365493g;

    public static final class a implements Parcelable.Creator<SearchMobParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SearchMobParam createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new SearchMobParam(r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final SearchMobParam[] newArray(int r100) {
            return new SearchMobParam[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SearchMobParam() {
        this(null, null, null, null, null, 127);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SearchMobParam) == true) goto L8;
        return false;
    L8:
        SearchMobParam r101 = (SearchMobParam) r100;
        if (Intrinsics.areEqual(this.f365487a, r101.f365487a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365488b, r101.f365488b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365489c, r101.f365489c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365490d, r101.f365490d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f365491e, r101.f365491e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f365492f, r101.f365492f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f365493g, r101.f365493g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f365487a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f365488b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f365489c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f365490d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f365491e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f365492f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f365493g;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SearchMobParam(query=" + this.f365487a + ", queryId=" + this.f365488b + ", searchId=" + this.f365489c + ", searchRequestId=" + this.f365490d + ", searchResultId=" + this.f365491e + ", rank=" + this.f365492f + ", recommendFrom=" + this.f365493g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f365487a);
        r100.writeString(this.f365488b);
        r100.writeString(this.f365489c);
        r100.writeString(this.f365490d);
        r100.writeString(this.f365491e);
        r100.writeString(this.f365492f);
        r100.writeString(this.f365493g);
    }

    public final String a() {
        return this.f365488b;
    }

    public final String b() {
        return this.f365493g;
    }

    public /* synthetic */ SearchMobParam(String r100, String r110, String r111, String r112, String r113, int r114) {
        if ((r114 & 4) == 0) goto L6;
        r100 = null;
    L6:
        if ((r114 & 8) == 0) goto L8;
        String r101 = null;
    L10:
        if ((r114 & 16) == 0) goto L12;
        String r102 = null;
    L14:
        if ((r114 & 32) == 0) goto L16;
        String r103 = null;
    L18:
        if ((r114 & 64) == 0) goto L20;
        String r104 = null;
    L21:
        this(null, null, r100, r101, r102, r103, r104);
        return;
    L20:
        r104 = r113;
        goto L21
    L16:
        r103 = r112;
        goto L18
    L12:
        r102 = r111;
        goto L14
    L8:
        r101 = r110;
        goto L10
    }

    public SearchMobParam(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        this.f365487a = r100;
        this.f365488b = r101;
        this.f365489c = r102;
        this.f365490d = r103;
        this.f365491e = r104;
        this.f365492f = r105;
        this.f365493g = r106;
    }
}
