package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0012HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/sdk/entity/global/ProactiveRecommendationSearchResult;", "Landroid/os/Parcelable;", "events", "", "", "entityList", "Lcom/obric/capabilitykit/entity/app/ProactiveMemoryEntity;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getEvents", "()Ljava/util/List;", "getEntityList", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveRecommendationSearchResult implements Parcelable {
    public static final a CREATOR = null;
    private final List<ProactiveMemoryEntity> entityList;
    private final List<String> events;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<ProactiveRecommendationSearchResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProactiveRecommendationSearchResult createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new ProactiveRecommendationSearchResult(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ProactiveRecommendationSearchResult[] newArray(int r100) {
            return new ProactiveRecommendationSearchResult[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProactiveRecommendationSearchResult copy$default(ProactiveRecommendationSearchResult r100, List r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.events;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.entityList;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<String> component1() {
        return this.events;
    }

    public final List<ProactiveMemoryEntity> component2() {
        return this.entityList;
    }

    public final ProactiveRecommendationSearchResult copy(List<String> r100, List<ProactiveMemoryEntity> r101) {
        Intrinsics.checkNotNullParameter(r100, "events");
        Intrinsics.checkNotNullParameter(r101, "entityList");
        return new ProactiveRecommendationSearchResult(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ProactiveRecommendationSearchResult) == true) goto L8;
        return false;
    L8:
        ProactiveRecommendationSearchResult r101 = (ProactiveRecommendationSearchResult) r100;
        if (Intrinsics.areEqual(this.events, r101.events) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entityList, r101.entityList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.events.hashCode() * 31) + this.entityList.hashCode();
    }

    public String toString() {
        return "ProactiveRecommendationSearchResult(events=" + this.events + ", entityList=" + this.entityList + ')';
    }

    public final List<ProactiveMemoryEntity> getEntityList() {
        return this.entityList;
    }

    public final List<String> getEvents() {
        return this.events;
    }

    public ProactiveRecommendationSearchResult(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        ArrayList<String> r101 = r100.createStringArrayList();
        Intrinsics.checkNotNull(r101);
        ArrayList r102 = r100.createTypedArrayList(ProactiveMemoryEntity.CREATOR);
        Intrinsics.checkNotNull(r102);
        this(r101, r102);
    }

    public ProactiveRecommendationSearchResult(List<String> r100, List<ProactiveMemoryEntity> r101) {
        Intrinsics.checkNotNullParameter(r100, "events");
        Intrinsics.checkNotNullParameter(r101, "entityList");
        this.events = r100;
        this.entityList = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeStringList(this.events);
        r100.writeTypedList(this.entityList);
    }
}
