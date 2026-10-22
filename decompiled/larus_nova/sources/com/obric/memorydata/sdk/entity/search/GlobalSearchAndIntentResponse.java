package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003JI\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0017HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006%"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/GlobalSearchAndIntentResponse;", "Landroid/os/Parcelable;", "origin_query", "", "searchAppEntity", "", "Lcom/obric/memorydata/sdk/entity/search/RewriteQuery;", "searchAppEntityContent", "searchMemoryEntity", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getOrigin_query", "()Ljava/lang/String;", "getSearchAppEntity", "()Ljava/util/List;", "getSearchAppEntityContent", "getSearchMemoryEntity", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalSearchAndIntentResponse implements Parcelable {
    public static final a CREATOR = null;
    private final String origin_query;
    private final List<RewriteQuery> searchAppEntity;
    private final List<RewriteQuery> searchAppEntityContent;
    private final List<RewriteQuery> searchMemoryEntity;

    public static final class a implements Parcelable.Creator<GlobalSearchAndIntentResponse> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GlobalSearchAndIntentResponse createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new GlobalSearchAndIntentResponse(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final GlobalSearchAndIntentResponse[] newArray(int r100) {
            return new GlobalSearchAndIntentResponse[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GlobalSearchAndIntentResponse copy$default(GlobalSearchAndIntentResponse r100, String r101, List r102, List r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.origin_query;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.searchAppEntity;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.searchAppEntityContent;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.searchMemoryEntity;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.origin_query;
    }

    public final List<RewriteQuery> component2() {
        return this.searchAppEntity;
    }

    public final List<RewriteQuery> component3() {
        return this.searchAppEntityContent;
    }

    public final List<RewriteQuery> component4() {
        return this.searchMemoryEntity;
    }

    public final GlobalSearchAndIntentResponse copy(String r100, List<RewriteQuery> r101, List<RewriteQuery> r102, List<RewriteQuery> r103) {
        Intrinsics.checkNotNullParameter(r100, "origin_query");
        return new GlobalSearchAndIntentResponse(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GlobalSearchAndIntentResponse) == true) goto L8;
        return false;
    L8:
        GlobalSearchAndIntentResponse r101 = (GlobalSearchAndIntentResponse) r100;
        if (Intrinsics.areEqual(this.origin_query, r101.origin_query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.searchAppEntity, r101.searchAppEntity) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.searchAppEntityContent, r101.searchAppEntityContent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.searchMemoryEntity, r101.searchMemoryEntity) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.origin_query.hashCode() * 31;
        List<RewriteQuery> r101 = this.searchAppEntity;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        List<RewriteQuery> r105 = this.searchAppEntityContent;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        List<RewriteQuery> r108 = this.searchMemoryEntity;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "GlobalSearchAndIntentResponse(origin_query=" + this.origin_query + ", searchAppEntity=" + this.searchAppEntity + ", searchAppEntityContent=" + this.searchAppEntityContent + ", searchMemoryEntity=" + this.searchMemoryEntity + ')';
    }

    public final String getOrigin_query() {
        return this.origin_query;
    }

    public final List<RewriteQuery> getSearchAppEntity() {
        return this.searchAppEntity;
    }

    public final List<RewriteQuery> getSearchAppEntityContent() {
        return this.searchAppEntityContent;
    }

    public final List<RewriteQuery> getSearchMemoryEntity() {
        return this.searchMemoryEntity;
    }

    public GlobalSearchAndIntentResponse(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        String r101 = r100.readString();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        RewriteQuery.a r102 = RewriteQuery.CREATOR;
        List r103 = r100.createTypedArrayList(r102);
        if (r103 != null) goto L9;
        r103 = CollectionsKt.emptyList();
    L9:
        List r104 = r100.createTypedArrayList(r102);
        if (r104 != null) goto L13;
        r104 = CollectionsKt.emptyList();
    L13:
        List r105 = r100.createTypedArrayList(r102);
        if (r105 != null) goto L17;
        r105 = CollectionsKt.emptyList();
    L17:
        this(r101, r103, r104, r105);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.origin_query);
        r100.writeTypedList(this.searchAppEntity);
        r100.writeTypedList(this.searchAppEntityContent);
        r100.writeTypedList(this.searchMemoryEntity);
    }

    public GlobalSearchAndIntentResponse(String r100, List<RewriteQuery> r101, List<RewriteQuery> r102, List<RewriteQuery> r103) {
        Intrinsics.checkNotNullParameter(r100, "origin_query");
        this.origin_query = r100;
        this.searchAppEntity = r101;
        this.searchAppEntityContent = r102;
        this.searchMemoryEntity = r103;
    }
}
