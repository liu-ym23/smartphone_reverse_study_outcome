package com.ss.android.lark.ding.entity;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J'\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006#"}, d2 = {"Lcom/ss/android/lark/ding/entity/UrgentInfo;", "Landroid/os/Parcelable;", "type", "Lcom/ss/android/lark/ding/entity/DingInaccessibleCode;", "readState", "Lcom/ss/android/lark/ding/entity/DingReadState;", "deniedReason", "", "<init>", "(Lcom/ss/android/lark/ding/entity/DingInaccessibleCode;Lcom/ss/android/lark/ding/entity/DingReadState;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getType", "()Lcom/ss/android/lark/ding/entity/DingInaccessibleCode;", "getReadState", "()Lcom/ss/android/lark/ding/entity/DingReadState;", "getDeniedReason", "()I", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "CREATOR", "ding-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrgentInfo implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DingInaccessibleCode f420408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DingReadState f420409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f420410c;

    public static final class a implements Parcelable.Creator<UrgentInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UrgentInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new UrgentInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final UrgentInfo[] newArray(int r100) {
            return new UrgentInfo[r100];
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
        if ((r100 instanceof UrgentInfo) == true) goto L8;
        return false;
    L8:
        UrgentInfo r101 = (UrgentInfo) r100;
        if (this.f420408a == r101.f420408a) goto L12;
        return false;
    L12:
        if (this.f420409b == r101.f420409b) goto L15;
        return false;
    L15:
        if (this.f420410c == r101.f420410c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f420408a.hashCode() * 31) + this.f420409b.hashCode()) * 31) + this.f420410c;
    }

    public final String toString() {
        return "UrgentInfo(type=" + this.f420408a + ", readState=" + this.f420409b + ", deniedReason=" + this.f420410c + ')';
    }

    public final DingInaccessibleCode getType() {
        return this.f420408a;
    }

    public UrgentInfo(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        DingInaccessibleCode.a r101 = DingInaccessibleCode.Companion;
        int r102 = r100.readInt();
        r101.getClass();
        if (r102 == 1) goto L16;
        if (r102 != 2) goto L6;
        DingInaccessibleCode r103 = DingInaccessibleCode.EMPTY_PHONE;
    L17:
        DingReadState.a r104 = DingReadState.Companion;
        int r105 = r100.readInt();
        r104.getClass();
        if (r105 == 1) goto L22;
        if (r105 == 2) goto L21;
        DingReadState r106 = DingReadState.NONE;
    L23:
        int r107 = r100.readInt();
        Intrinsics.checkNotNullParameter(r103, "type");
        Intrinsics.checkNotNullParameter(r106, "readState");
        this.f420408a = r103;
        this.f420409b = r106;
        this.f420410c = r107;
        return;
    L21:
        r106 = DingReadState.UN_READ;
        goto L23
    L22:
        r106 = DingReadState.READ;
        goto L23
    L6:
        if (r102 != 3) goto L8;
        r103 = DingInaccessibleCode.CROSS_PLATFORM;
        goto L17
    L8:
        if (r102 != 4) goto L10;
        r103 = DingInaccessibleCode.NOT_FRIEND;
        goto L17
    L10:
        if (r102 == 5) goto L12;
        r103 = DingInaccessibleCode.DEFAULT;
        goto L17
    L12:
        r103 = DingInaccessibleCode.USER_SETTING_DISABLED;
        goto L17
    L16:
        r103 = DingInaccessibleCode.EMPTY_NAME;
        goto L17
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.f420408a.getValue());
        r100.writeInt(this.f420409b.getValue());
        r100.writeInt(this.f420410c);
    }
}
