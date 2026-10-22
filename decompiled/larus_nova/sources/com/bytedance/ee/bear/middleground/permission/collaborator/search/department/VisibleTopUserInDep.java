package com.bytedance.ee.bear.middleground.permission.collaborator.search.department;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0016\u001a\u00020\u0011J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/VisibleTopUserInDep;", "Landroid/os/Parcelable;", "userId", "", "userName", "avatar", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getUserName", "getAvatar", "equals", "", "other", "", "hashCode", "", "component1", "component2", "component3", "copy", "describeContents", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VisibleTopUserInDep implements Parcelable {
    public static final Parcelable.Creator<VisibleTopUserInDep> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f233447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f233448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f233449c;

    public static final class a implements Parcelable.Creator<VisibleTopUserInDep> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VisibleTopUserInDep createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new VisibleTopUserInDep(r100.readString(), r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final VisibleTopUserInDep[] newArray(int r100) {
            return new VisibleTopUserInDep[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "VisibleTopUserInDep(userId=" + this.f233447a + ", userName=" + this.f233448b + ", avatar=" + this.f233449c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f233447a);
        r100.writeString(this.f233448b);
        r100.writeString(this.f233449c);
    }

    public VisibleTopUserInDep() {
        this("", "", "");
    }

    public final int hashCode() {
        return this.f233447a.hashCode();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(VisibleTopUserInDep.class, r100.getClass()) == true) goto L10;
        return false;
    L10:
        return Objects.equals(this.f233447a, ((VisibleTopUserInDep) r100).f233447a);
    }

    public VisibleTopUserInDep(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "userName");
        Intrinsics.checkNotNullParameter(r102, "avatar");
        this.f233447a = r100;
        this.f233448b = r101;
        this.f233449c = r102;
    }
}
