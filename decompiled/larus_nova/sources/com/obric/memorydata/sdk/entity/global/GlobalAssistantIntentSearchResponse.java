package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.memorydata.sdk.entity.search.SearchResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\n\u0010\u000eJ\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantIntentSearchResponse;", "Landroid/os/Parcelable;", "code", "", "message", "", "searchResponse", "Lcom/obric/memorydata/sdk/entity/search/SearchResponse;", "globalSearchResponse", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;", "<init>", "(ILjava/lang/String;Lcom/obric/memorydata/sdk/entity/search/SearchResponse;Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getCode", "()I", "setCode", "(I)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getSearchResponse", "()Lcom/obric/memorydata/sdk/entity/search/SearchResponse;", "setSearchResponse", "(Lcom/obric/memorydata/sdk/entity/search/SearchResponse;)V", "getGlobalSearchResponse", "()Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;", "setGlobalSearchResponse", "(Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;)V", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalAssistantIntentSearchResponse implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f397138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f397139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SearchResponse f397140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GlobalAssistantSearchResponse f397141d;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<GlobalAssistantIntentSearchResponse> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GlobalAssistantIntentSearchResponse createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new GlobalAssistantIntentSearchResponse(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final GlobalAssistantIntentSearchResponse[] newArray(int r100) {
            return new GlobalAssistantIntentSearchResponse[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GlobalAssistantIntentSearchResponse) == true) goto L8;
        return false;
    L8:
        GlobalAssistantIntentSearchResponse r101 = (GlobalAssistantIntentSearchResponse) r100;
        if (this.f397138a == r101.f397138a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397139b, r101.f397139b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397140c, r101.f397140c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f397141d, r101.f397141d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f397138a * 31) + this.f397139b.hashCode()) * 31;
        SearchResponse r101 = this.f397140c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        GlobalAssistantSearchResponse r105 = this.f397141d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "GlobalAssistantIntentSearchResponse(code=" + this.f397138a + ", message=" + this.f397139b + ", searchResponse=" + this.f397140c + ", globalSearchResponse=" + this.f397141d + ')';
    }

    public GlobalAssistantIntentSearchResponse(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        int r101 = r100.readInt();
        String r102 = r100.readString();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        SearchResponse r103 = (SearchResponse) r100.readParcelable(SearchResponse.class.getClassLoader());
        GlobalAssistantSearchResponse r104 = (GlobalAssistantSearchResponse) r100.readParcelable(GlobalAssistantSearchResponse.class.getClassLoader());
        Intrinsics.checkNotNullParameter(r102, "message");
        this.f397138a = r101;
        this.f397139b = r102;
        this.f397140c = r103;
        this.f397141d = r104;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.f397138a);
        r100.writeString(this.f397139b);
        r100.writeParcelable(this.f397140c, r101);
        r100.writeParcelable(this.f397141d, r101);
    }
}
