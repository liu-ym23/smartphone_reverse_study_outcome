package com.bytedance.ee.bear.middleground.permission.collaborator.search.department;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u0004H\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0013J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/VisibleDepartment;", "Landroid/os/Parcelable;", "Lcom/bytedance/ee/bear/pathnavigationview/PathNavigationModel;", "departmentId", "", "depName", "avatar", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDepartmentId", "()Ljava/lang/String;", "getDepName", "getAvatar", "getName", "equals", "", "other", "", "hashCode", "", "component1", "component2", "component3", "copy", "describeContents", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VisibleDepartment implements Parcelable, kl5.a {
    public static final Parcelable.Creator<VisibleDepartment> CREATOR = null;
    public final String a;
    public final String b;
    public final String c;

    public static final class a {
        public static VisibleDepartment a(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return new VisibleDepartment("0", r3.getString(2131888043), "");
        }
    }

    public static final class b implements Parcelable.Creator<VisibleDepartment> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final VisibleDepartment createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            return new VisibleDepartment(r4.readString(), r4.readString(), r4.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final VisibleDepartment[] newArray(int r1) {
            return new VisibleDepartment[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "VisibleDepartment(departmentId=" + this.a + ", depName=" + this.b + ", avatar=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
    }

    public VisibleDepartment() {
        this("", "", "");
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // kl5.a
    public final String getName() {
        return this.b;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(VisibleDepartment.class, r3.getClass()) == true) goto L10;
        return false;
    L10:
        return Objects.equals(this.a, ((VisibleDepartment) r3).a);
    }

    public VisibleDepartment(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "departmentId");
        Intrinsics.checkNotNullParameter(r3, "depName");
        Intrinsics.checkNotNullParameter(r4, "avatar");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
