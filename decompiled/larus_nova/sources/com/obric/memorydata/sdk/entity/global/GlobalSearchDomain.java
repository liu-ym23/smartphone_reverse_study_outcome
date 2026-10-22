package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/sdk/entity/global/GlobalSearchDomain;", "Landroid/os/Parcelable;", "name", "", "<init>", "(Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getName", "()Ljava/lang/String;", "writeToParcel", "", "flags", "", "describeContents", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalSearchDomain implements Parcelable {
    public static final a CREATOR = null;
    private final String name;

    public static final class a implements Parcelable.Creator<GlobalSearchDomain> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GlobalSearchDomain createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new GlobalSearchDomain(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final GlobalSearchDomain[] newArray(int r100) {
            return new GlobalSearchDomain[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ GlobalSearchDomain copy$default(GlobalSearchDomain r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.name;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.name;
    }

    public final GlobalSearchDomain copy(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return new GlobalSearchDomain(r100);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GlobalSearchDomain) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.name, ((GlobalSearchDomain) r100).name) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return "GlobalSearchDomain(name=" + this.name + ')';
    }

    public final String getName() {
        return this.name;
    }

    public GlobalSearchDomain(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        String r101 = r100.readString();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this(r101);
    }

    public GlobalSearchDomain(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.name = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.name);
    }
}
