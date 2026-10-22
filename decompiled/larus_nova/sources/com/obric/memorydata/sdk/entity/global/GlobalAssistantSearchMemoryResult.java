package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchMemoryResult;", "Landroid/os/Parcelable;", "entityList", "", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "<init>", "(Ljava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getEntityList", "()Ljava/util/List;", "writeToParcel", "", "flags", "", "describeContents", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalAssistantSearchMemoryResult implements Parcelable {
    public static final a CREATOR = null;
    private final List<MemoryEntity> entityList;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<GlobalAssistantSearchMemoryResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GlobalAssistantSearchMemoryResult createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new GlobalAssistantSearchMemoryResult(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final GlobalAssistantSearchMemoryResult[] newArray(int r100) {
            return new GlobalAssistantSearchMemoryResult[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GlobalAssistantSearchMemoryResult copy$default(GlobalAssistantSearchMemoryResult r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.entityList;
    L6:
        return r100.copy(r101);
    }

    public final List<MemoryEntity> component1() {
        return this.entityList;
    }

    public final GlobalAssistantSearchMemoryResult copy(List<? extends MemoryEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "entityList");
        return new GlobalAssistantSearchMemoryResult(r100);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GlobalAssistantSearchMemoryResult) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.entityList, ((GlobalAssistantSearchMemoryResult) r100).entityList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.entityList.hashCode();
    }

    public String toString() {
        return "GlobalAssistantSearchMemoryResult(entityList=" + this.entityList + ')';
    }

    public final List<MemoryEntity> getEntityList() {
        return this.entityList;
    }

    public GlobalAssistantSearchMemoryResult(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        List r101 = r100.createTypedArrayList(MemoryEntity.CREATOR);
        if (r101 != null) goto L6;
        r101 = CollectionsKt.emptyList();
    L6:
        this(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GlobalAssistantSearchMemoryResult(List<? extends MemoryEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "entityList");
        this.entityList = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeTypedList(this.entityList);
    }
}
