package com.obric.memorydata.sdk.accessibility;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0003J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/sdk/accessibility/VisibleNodeCountCondition;", "Landroid/os/Parcelable;", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getMin", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMax", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/obric/memorydata/sdk/accessibility/VisibleNodeCountCondition;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VisibleNodeCountCondition implements Parcelable {
    public static final Parcelable.Creator<VisibleNodeCountCondition> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f397075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f397076b;

    public static final class a implements Parcelable.Creator<VisibleNodeCountCondition> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VisibleNodeCountCondition createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Integer r101 = null;
            if (r100.readInt() != 0) goto L5;
            Integer r102 = null;
        L7:
            if (r100.readInt() == 0) goto L11;
            r101 = Integer.valueOf(r100.readInt());
        L11:
            return new VisibleNodeCountCondition(r102, r101);
        L5:
            r102 = Integer.valueOf(r100.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final VisibleNodeCountCondition[] newArray(int r100) {
            return new VisibleNodeCountCondition[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public VisibleNodeCountCondition() {
        this(null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VisibleNodeCountCondition) == true) goto L8;
        return false;
    L8:
        VisibleNodeCountCondition r101 = (VisibleNodeCountCondition) r100;
        if (Intrinsics.areEqual(this.f397075a, r101.f397075a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397076b, r101.f397076b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f397075a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f397076b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VisibleNodeCountCondition(min=" + this.f397075a + ", max=" + this.f397076b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Integer r102 = this.f397075a;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Integer r103 = this.f397076b;
        if (r103 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
        goto L6
    }

    public VisibleNodeCountCondition(Integer r100, Integer r101) {
        this.f397075a = r100;
        this.f397076b = r101;
    }
}
