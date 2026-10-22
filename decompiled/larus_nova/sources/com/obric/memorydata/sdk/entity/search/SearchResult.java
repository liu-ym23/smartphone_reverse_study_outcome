package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0013HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/SearchResult;", "Landroid/os/Parcelable;", "entityList", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "quResult", "Lcom/obric/memorydata/sdk/entity/search/AssistantQuResult;", "<init>", "(Ljava/util/List;Lcom/obric/memorydata/sdk/entity/search/AssistantQuResult;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getEntityList", "()Ljava/util/List;", "getQuResult", "()Lcom/obric/memorydata/sdk/entity/search/AssistantQuResult;", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SearchResult implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<AppEntity> f397143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AssistantQuResult f397144b;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<SearchResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SearchResult createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new SearchResult(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SearchResult[] newArray(int r100) {
            return new SearchResult[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SearchResult() {
        throw null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SearchResult) == true) goto L8;
        return false;
    L8:
        SearchResult r101 = (SearchResult) r100;
        if (Intrinsics.areEqual(this.f397143a, r101.f397143a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397144b, r101.f397144b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f397143a.hashCode() * 31;
        AssistantQuResult r101 = this.f397144b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "SearchResult(entityList=" + this.f397143a + ", quResult=" + this.f397144b + ')';
    }

    public SearchResult(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        List<AppEntity> r101 = r100.createTypedArrayList(AppEntity.CREATOR);
        if (r101 != null) goto L6;
        r101 = CollectionsKt.emptyList();
    L6:
        AssistantQuResult r102 = (AssistantQuResult) r100.readParcelable(AssistantQuResult.class.getClassLoader());
        Intrinsics.checkNotNullParameter(r101, "entityList");
        this.f397143a = r101;
        this.f397144b = r102;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeTypedList(this.f397143a);
        r100.writeParcelable(this.f397144b, r101);
    }
}
