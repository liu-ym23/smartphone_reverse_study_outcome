package com.larus.profile.api.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0016R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006!"}, d2 = {"Lcom/larus/profile/api/bean/UserCreationGroupListResponse;", "Landroid/os/Parcelable;", "creationGroupList", "", "Lcom/larus/profile/api/bean/UserCreationGroup;", "hasMore", "", "nextCursor", "", "<init>", "(Ljava/util/List;ZLjava/lang/String;)V", "getCreationGroupList", "()Ljava/util/List;", "getHasMore", "()Z", "getNextCursor", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserCreationGroupListResponse implements Parcelable {
    public static final Parcelable.Creator<UserCreationGroupListResponse> CREATOR = null;

    @SerializedName("creation_group_list")
    private final List<UserCreationGroup> creationGroupList;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("next_cursor")
    private final String nextCursor;

    public static final class a implements Parcelable.Creator<UserCreationGroupListResponse> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationGroupListResponse createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            boolean r101 = false;
            ArrayList r102 = null;
            if (r100.readInt() == 0) goto L14;
            int r103 = r100.readInt();
            ArrayList r104 = new ArrayList(r103);
            int r105 = 0;
        L6:
            if (r105 == r103) goto L12;
            if (r100.readInt() != 0) goto L10;
            UserCreationGroup r106 = null;
        L11:
            r104.add(r106);
            r105 = r105 + 1;
            goto L6
        L10:
            r106 = UserCreationGroup.CREATOR.createFromParcel(r100);
            goto L11
        L12:
            r102 = r104;
        L14:
            if (r100.readInt() == 0) goto L17;
            r101 = true;
        L17:
            return new UserCreationGroupListResponse(r102, r101, r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationGroupListResponse[] newArray(int r100) {
            return new UserCreationGroupListResponse[r100];
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
        if ((r100 instanceof UserCreationGroupListResponse) == true) goto L8;
        return false;
    L8:
        UserCreationGroupListResponse r101 = (UserCreationGroupListResponse) r100;
        if (Intrinsics.areEqual(this.creationGroupList, r101.creationGroupList) == true) goto L12;
        return false;
    L12:
        if (this.hasMore == r101.hasMore) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nextCursor, r101.nextCursor) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        List<UserCreationGroup> r100 = this.creationGroupList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        if (this.hasMore == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        String r106 = this.nextCursor;
        if (r106 == null) goto L15;
        r101 = r106.hashCode();
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "UserCreationGroupListResponse(creationGroupList=" + this.creationGroupList + ", hasMore=" + this.hasMore + ", nextCursor=" + this.nextCursor + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        List<UserCreationGroup> r102 = this.creationGroupList;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L12:
        r100.writeInt(this.hasMore ? 1 : 0);
        r100.writeString(this.nextCursor);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<UserCreationGroup> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L12;
        UserCreationGroup r104 = r103.next();
        if (r104 == null) goto L10;
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        goto L7
    L10:
        r100.writeInt(0);
        goto L7
    }

    public UserCreationGroupListResponse() {
        this(new ArrayList(), false, null);
    }

    public final List<UserCreationGroup> a() {
        return this.creationGroupList;
    }

    public final boolean b() {
        return this.hasMore;
    }

    public final String c() {
        return this.nextCursor;
    }

    public UserCreationGroupListResponse(List<UserCreationGroup> r100, boolean r101, String r102) {
        this.creationGroupList = r100;
        this.hasMore = r101;
        this.nextCursor = r102;
    }
}
