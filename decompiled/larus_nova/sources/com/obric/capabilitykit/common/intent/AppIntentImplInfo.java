package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/obric/capabilitykit/common/intent/AppIntentImplInfo;", "Landroid/os/Parcelable;", "packageName", "", "implClassName", "(Ljava/lang/String;Ljava/lang/String;)V", "getImplClassName", "()Ljava/lang/String;", "getPackageName", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AppIntentImplInfo implements Parcelable {
    public static final Parcelable.Creator<AppIntentImplInfo> CREATOR = null;
    private final String implClassName;
    private final String packageName;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<AppIntentImplInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AppIntentImplInfo createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppIntentImplInfo r102 = new AppIntentImplInfo(r100.readString(), r100.readString());
            int r103 = Math.min(r101, 0);
            ClassLoader r104 = a.class.getClassLoader();
            int r105 = 1;
        L3:
            if (r105 > r103) goto L5;
            r105 = r105 + 1;
        L5:
            if (r105 > r101) goto L7;
            joa.a.d(r100, r104);
            r105 = r105 + 1;
            goto L5
        L7:
            return r102;
        }

        @Override // android.os.Parcelable.Creator
        public final AppIntentImplInfo[] newArray(int r100) {
            return new AppIntentImplInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public AppIntentImplInfo(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        Intrinsics.checkNotNullParameter(r101, "implClassName");
        this.packageName = r100;
        this.implClassName = r101;
    }

    public static /* synthetic */ AppIntentImplInfo copy$default(AppIntentImplInfo r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.packageName;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.implClassName;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.packageName;
    }

    public final String component2() {
        return this.implClassName;
    }

    public final AppIntentImplInfo copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        Intrinsics.checkNotNullParameter(r101, "implClassName");
        return new AppIntentImplInfo(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AppIntentImplInfo) == true) goto L8;
        return false;
    L8:
        AppIntentImplInfo r101 = (AppIntentImplInfo) r100;
        if (Intrinsics.areEqual(this.packageName, r101.packageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.implClassName, r101.implClassName) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getImplClassName() {
        return this.implClassName;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return (this.packageName.hashCode() * 31) + this.implClassName.hashCode();
    }

    public String toString() {
        return "AppIntentImplInfo(packageName=" + this.packageName + ", implClassName=" + this.implClassName + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.packageName);
        r100.writeString(this.implClassName);
    }
}
