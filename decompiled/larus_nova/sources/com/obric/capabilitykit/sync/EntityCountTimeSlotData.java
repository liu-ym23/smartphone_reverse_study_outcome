package com.obric.capabilitykit.sync;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/capabilitykit/sync/EntityCountTimeSlotData;", "Landroid/os/Parcelable;", "CREATOR", "capabilitykit_release"}, k = 1, mv = {1, 7, 1})
public final class EntityCountTimeSlotData implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f396292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f396293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f396294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f396295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f396296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f396297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f396298g;

    public static final class a implements Parcelable.Creator<EntityCountTimeSlotData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EntityCountTimeSlotData createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            Intrinsics.checkNotNullParameter(r110, "parcel");
            Class r100 = Long.TYPE;
            Object r101 = r110.readValue(r100.getClassLoader());
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Long");
            long r102 = ((Long) r101).longValue();
            Object r103 = r110.readValue(r100.getClassLoader());
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Long");
            EntityCountTimeSlotData r104 = new EntityCountTimeSlotData(r102, ((Long) r103).longValue(), r110.readInt(), r110.readInt(), r110.readInt());
            Class r105 = Integer.TYPE;
            Object r106 = r110.readValue(r105.getClassLoader());
            Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.Int");
            r104.f396297f = ((Integer) r106).intValue();
            Object r111 = r110.readValue(r105.getClassLoader());
            Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.Int");
            r104.f396298g = ((Integer) r111).intValue();
            return r104;
        }

        @Override // android.os.Parcelable.Creator
        public final EntityCountTimeSlotData[] newArray(int r100) {
            return new EntityCountTimeSlotData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public EntityCountTimeSlotData(long r100, long r101, int r102, int r103, int r104) {
        this.f396292a = r100;
        this.f396293b = r101;
        this.f396294c = r102;
        this.f396295d = r103;
        this.f396296e = r104;
        this.f396297f = -1;
        this.f396298g = -1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EntityCountTimeSlotData) == true) goto L8;
        return false;
    L8:
        EntityCountTimeSlotData r101 = (EntityCountTimeSlotData) r100;
        if (this.f396292a == r101.f396292a) goto L12;
        return false;
    L12:
        if (this.f396293b == r101.f396293b) goto L15;
        return false;
    L15:
        if (this.f396294c == r101.f396294c) goto L18;
        return false;
    L18:
        if (this.f396295d == r101.f396295d) goto L21;
        return false;
    L21:
        if (this.f396296e == r101.f396296e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f396292a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f396293b;
        return ((((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f396294c) * 31) + this.f396295d) * 31) + this.f396296e;
    }

    public final String toString() {
        return "EntityCountTimeSlotData(startTime=" + this.f396292a + ", endTimeLong=" + this.f396293b + ", count=" + this.f396294c + ", leftTimeArrayIndex=" + this.f396295d + ", rightTimeArrayIndex=" + this.f396296e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeValue(Long.valueOf(this.f396292a));
        r100.writeValue(Long.valueOf(this.f396293b));
        r100.writeInt(this.f396294c);
        r100.writeInt(this.f396295d);
        r100.writeInt(this.f396296e);
        r100.writeValue(Integer.valueOf(this.f396297f));
        r100.writeValue(Integer.valueOf(this.f396298g));
    }
}
