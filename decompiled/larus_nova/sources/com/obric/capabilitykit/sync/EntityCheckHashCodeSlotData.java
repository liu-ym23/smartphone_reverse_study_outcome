package com.obric.capabilitykit.sync;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/capabilitykit/sync/EntityCheckHashCodeSlotData;", "Landroid/os/Parcelable;", "CREATOR", "capabilitykit_release"}, k = 1, mv = {1, 7, 1})
public final class EntityCheckHashCodeSlotData implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f396289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f396290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<EntityHashData> f396291c;

    public static final class a implements Parcelable.Creator<EntityCheckHashCodeSlotData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EntityCheckHashCodeSlotData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            long r101 = r100.readLong();
            long r102 = r100.readLong();
            List r103 = r100.createTypedArrayList(EntityHashData.CREATOR);
            if (r103 != null) goto L6;
            r103 = CollectionsKt.emptyList();
        L6:
            return new EntityCheckHashCodeSlotData(r101, r102, r103);
        }

        @Override // android.os.Parcelable.Creator
        public final EntityCheckHashCodeSlotData[] newArray(int r100) {
            return new EntityCheckHashCodeSlotData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public EntityCheckHashCodeSlotData(long r100, long r101, List<EntityHashData> r102) {
        Intrinsics.checkNotNullParameter(r102, "hashCodeData");
        this.f396289a = r100;
        this.f396290b = r101;
        this.f396291c = r102;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeLong(this.f396289a);
        r100.writeLong(this.f396290b);
        r100.writeTypedList(this.f396291c);
    }
}
