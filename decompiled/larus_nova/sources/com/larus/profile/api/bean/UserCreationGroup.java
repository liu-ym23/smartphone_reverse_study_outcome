package com.larus.profile.api.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.platform.api.creation.UserCreation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J8\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0005J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0005R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lcom/larus/profile/api/bean/UserCreationGroup;", "Landroid/os/Parcelable;", "groupId", "", "scene", "", "creationList", "", "Lcom/larus/platform/api/creation/UserCreation;", "<init>", "(Ljava/lang/Long;ILjava/util/List;)V", "getGroupId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getScene", "()I", "getCreationList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;ILjava/util/List;)Lcom/larus/profile/api/bean/UserCreationGroup;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserCreationGroup implements Parcelable {
    public static final Parcelable.Creator<UserCreationGroup> CREATOR = null;

    @SerializedName("creation_list")
    private final List<UserCreation> creationList;

    @SerializedName("group_id")
    private final Long groupId;

    @SerializedName("scene")
    private final int scene;

    public static final class a implements Parcelable.Creator<UserCreationGroup> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationGroup createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ArrayList r101 = null;
            if (r100.readInt() != 0) goto L5;
            Long r102 = null;
        L6:
            int r103 = r100.readInt();
            if (r100.readInt() == 0) goto L14;
            int r104 = r100.readInt();
            ArrayList r105 = new ArrayList(r104);
            int r106 = 0;
        L10:
            if (r106 == r104) goto L12;
            r105.add(r100.readParcelable(UserCreationGroup.class.getClassLoader()));
            r106 = r106 + 1;
            goto L10
        L12:
            r101 = r105;
        L14:
            return new UserCreationGroup(r102, r103, r101);
        L5:
            r102 = Long.valueOf(r100.readLong());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationGroup[] newArray(int r100) {
            return new UserCreationGroup[r100];
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
        if ((r100 instanceof UserCreationGroup) == true) goto L8;
        return false;
    L8:
        UserCreationGroup r101 = (UserCreationGroup) r100;
        if (Intrinsics.areEqual(this.groupId, r101.groupId) == true) goto L12;
        return false;
    L12:
        if (this.scene == r101.scene) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.creationList, r101.creationList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.groupId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.scene) * 31;
        List<UserCreation> r104 = this.creationList;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "UserCreationGroup(groupId=" + this.groupId + ", scene=" + this.scene + ", creationList=" + this.creationList + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Long r102 = this.groupId;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeInt(this.scene);
        List<UserCreation> r103 = this.creationList;
        if (r103 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.size());
        Iterator<UserCreation> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L15;
        r100.writeParcelable(r104.next(), r101);
        goto L11
    L15:
        return;
    L5:
        r100.writeInt(1);
        r100.writeLong(r102.longValue());
        goto L6
    }

    public UserCreationGroup() {
        this(null, 0, new ArrayList());
    }

    public final List<UserCreation> a() {
        return this.creationList;
    }

    public UserCreationGroup(Long r100, int r101, List<UserCreation> r102) {
        this.groupId = r100;
        this.scene = r101;
        this.creationList = r102;
    }
}
