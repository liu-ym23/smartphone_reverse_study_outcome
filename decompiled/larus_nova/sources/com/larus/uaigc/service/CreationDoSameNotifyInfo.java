package com.larus.uaigc.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.platform.api.creation.UserCreationType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0005J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006$"}, d2 = {"Lcom/larus/uaigc/service/CreationDoSameNotifyInfo;", "Landroid/os/Parcelable;", "creationId", "", "userCreationType", "", "trackTemplateSource", "trackTemplateSubType", "trackTemplateType", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreationId", "()Ljava/lang/String;", "getUserCreationType", "()I", "getTrackTemplateSource", "getTrackTemplateSubType", "getTrackTemplateType", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDoSameNotifyInfo implements Parcelable {
    public static final Parcelable.Creator<CreationDoSameNotifyInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f373884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f373885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f373886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f373887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f373888e;

    public static final class a implements Parcelable.Creator<CreationDoSameNotifyInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CreationDoSameNotifyInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new CreationDoSameNotifyInfo(r100.readString(), r100.readInt(), r100.readString(), r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final CreationDoSameNotifyInfo[] newArray(int r100) {
            return new CreationDoSameNotifyInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationDoSameNotifyInfo) == true) goto L8;
        return false;
    L8:
        CreationDoSameNotifyInfo r101 = (CreationDoSameNotifyInfo) r100;
        if (Intrinsics.areEqual(this.f373884a, r101.f373884a) == true) goto L12;
        return false;
    L12:
        if (this.f373885b == r101.f373885b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f373886c, r101.f373886c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f373887d, r101.f373887d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f373888e, r101.f373888e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f373884a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f373885b) * 31;
        String r104 = this.f373886c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f373887d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f373888e;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationDoSameNotifyInfo(creationId=" + this.f373884a + ", userCreationType=" + this.f373885b + ", trackTemplateSource=" + this.f373886c + ", trackTemplateSubType=" + this.f373887d + ", trackTemplateType=" + this.f373888e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f373884a);
        r100.writeInt(this.f373885b);
        r100.writeString(this.f373886c);
        r100.writeString(this.f373887d);
        r100.writeString(this.f373888e);
    }

    public CreationDoSameNotifyInfo(String r100, @UserCreationType int r101, String r102, String r103, String r104) {
        this.f373884a = r100;
        this.f373885b = r101;
        this.f373886c = r102;
        this.f373887d = r103;
        this.f373888e = r104;
    }
}
