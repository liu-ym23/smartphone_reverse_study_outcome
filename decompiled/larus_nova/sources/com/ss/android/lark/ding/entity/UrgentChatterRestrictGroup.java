package com.ss.android.lark.ding.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bHÆ\u0003J7\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/ss/android/lark/ding/entity/UrgentChatterRestrictGroup;", "Landroid/os/Parcelable;", "count", "", "boundedChatterIds", "", "", "allChatterIds", "", "<init>", "(ILjava/util/Set;Ljava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getCount", "()I", "setCount", "(I)V", "getBoundedChatterIds", "()Ljava/util/Set;", "getAllChatterIds", "()Ljava/util/List;", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "ding-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrgentChatterRestrictGroup implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f420405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f420406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f420407c;

    public static final class a implements Parcelable.Creator<UrgentChatterRestrictGroup> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UrgentChatterRestrictGroup createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = r100.readInt();
            String[] r102 = r100.createStringArray();
            if (r102 == null) goto L5;
            Set r103 = ArraysKt.toMutableSet(r102);
        L7:
            return new UrgentChatterRestrictGroup(r101, r103, r100.createStringArrayList());
        L5:
            r103 = null;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final UrgentChatterRestrictGroup[] newArray(int r100) {
            return new UrgentChatterRestrictGroup[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public UrgentChatterRestrictGroup() {
        this(null, 7);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UrgentChatterRestrictGroup) == true) goto L8;
        return false;
    L8:
        UrgentChatterRestrictGroup r101 = (UrgentChatterRestrictGroup) r100;
        if (this.f420405a == r101.f420405a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f420406b, r101.f420406b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f420407c, r101.f420407c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f420405a * 31;
        Set<String> r101 = this.f420406b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        List<String> r105 = this.f420407c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "UrgentChatterRestrictGroup(count=" + this.f420405a + ", boundedChatterIds=" + this.f420406b + ", allChatterIds=" + this.f420407c + ')';
    }

    public /* synthetic */ UrgentChatterRestrictGroup(Set r100, int r101) {
        if ((r101 & 2) == 0) goto L5;
        r100 = null;
    L5:
        this(0, r100, null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.f420405a);
        Set<String> r102 = this.f420406b;
        if (r102 == null) goto L6;
        String[] r103 = (String[]) r102.toArray(new String[0]);
        if (r103 == null) goto L6;
    L7:
        r100.writeStringArray(r103);
        r100.writeStringList(this.f420407c);
        return;
    L6:
        r103 = new String[0];
        goto L7
    }

    public UrgentChatterRestrictGroup(int r100, Set<String> r101, List<String> r102) {
        this.f420405a = r100;
        this.f420406b = r101;
        this.f420407c = r102;
    }
}
