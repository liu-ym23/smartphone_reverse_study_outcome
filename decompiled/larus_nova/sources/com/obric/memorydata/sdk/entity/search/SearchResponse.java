package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0001'B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/SearchResponse;", "Landroid/os/Parcelable;", "code", "", "message", "", "data", "Lcom/obric/memorydata/sdk/entity/search/SearchResult;", "<init>", "(ILjava/lang/String;Lcom/obric/memorydata/sdk/entity/search/SearchResult;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getCode", "()I", "setCode", "(I)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getData", "()Lcom/obric/memorydata/sdk/entity/search/SearchResult;", "setData", "(Lcom/obric/memorydata/sdk/entity/search/SearchResult;)V", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SearchResponse implements Parcelable {
    public static final a CREATOR = null;
    private int code;
    private SearchResult data;
    private String message;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<SearchResponse> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SearchResponse createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new SearchResponse(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SearchResponse[] newArray(int r100) {
            return new SearchResponse[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ SearchResponse copy$default(SearchResponse r100, int r101, String r102, SearchResult r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.message;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.data;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final SearchResult component3() {
        return this.data;
    }

    public final SearchResponse copy(int r100, String r101, SearchResult r102) {
        Intrinsics.checkNotNullParameter(r101, "message");
        return new SearchResponse(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SearchResponse) == true) goto L8;
        return false;
    L8:
        SearchResponse r101 = (SearchResponse) r100;
        if (this.code == r101.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.code * 31) + this.message.hashCode()) * 31;
        SearchResult r101 = this.data;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "SearchResponse(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
    }

    public final int getCode() {
        return this.code;
    }

    public final SearchResult getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public SearchResponse(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        int r101 = r100.readInt();
        String r102 = r100.readString();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        this(r101, r102, (SearchResult) r100.readParcelable(SearchResult.class.getClassLoader()));
    }

    public final void setCode(int r100) {
        this.code = r100;
    }

    public final void setData(SearchResult r100) {
        this.data = r100;
    }

    public final void setMessage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.message = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.code);
        r100.writeString(this.message);
        r100.writeParcelable(this.data, r101);
    }

    public SearchResponse(int r100, String r101, SearchResult r102) {
        Intrinsics.checkNotNullParameter(r101, "message");
        this.code = r100;
        this.message = r101;
        this.data = r102;
    }

    public /* synthetic */ SearchResponse(int r100, String r101, SearchResult r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
