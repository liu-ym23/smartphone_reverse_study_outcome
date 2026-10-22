package com.bytedance.ee.android.file.picker.lib.v2.data.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/GroupEntity;", "Landroid/os/Parcelable;", "category", "", "fileList", "", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/FileEntry;", "key", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/Key;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/Key;)V", "getCategory", "()Ljava/lang/String;", "getFileList", "()Ljava/util/List;", "getKey", "()Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/Key;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "file-picker-lib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupEntity implements Parcelable {
    public static final Parcelable.Creator<GroupEntity> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f206021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<FileEntry> f206022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Key f206023c;

    public static final class a implements Parcelable.Creator<GroupEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GroupEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            int r102 = r100.readInt();
            ArrayList r103 = new ArrayList(r102);
            int r104 = 0;
        L3:
            if (r104 == r102) goto L6;
            r103.add(FileEntry.CREATOR.createFromParcel(r100));
            r104 = r104 + 1;
            goto L3
        L6:
            return new GroupEntity(r101, r103, (Key) r100.readParcelable(GroupEntity.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final GroupEntity[] newArray(int r100) {
            return new GroupEntity[r100];
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
        if ((r100 instanceof GroupEntity) == true) goto L8;
        return false;
    L8:
        GroupEntity r101 = (GroupEntity) r100;
        if (Intrinsics.areEqual(this.f206021a, r101.f206021a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f206022b, r101.f206022b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f206023c, r101.f206023c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f206021a.hashCode() * 31) + this.f206022b.hashCode()) * 31) + this.f206023c.hashCode();
    }

    public final String toString() {
        return "GroupEntity(category=" + this.f206021a + ", fileList=" + this.f206022b + ", key=" + this.f206023c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f206021a);
        List<FileEntry> r102 = this.f206022b;
        r100.writeInt(r102.size());
        Iterator<FileEntry> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().writeToParcel(r100, r101);
        goto L4
    L6:
        r100.writeParcelable(this.f206023c, r101);
    }

    public static GroupEntity a(GroupEntity r100, List r101) {
        String r102 = r100.f206021a;
        Key r103 = r100.f206023c;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "category");
        Intrinsics.checkNotNullParameter(r101, "fileList");
        Intrinsics.checkNotNullParameter(r103, "key");
        return new GroupEntity(r102, r101, r103);
    }

    public GroupEntity(String r100, List<FileEntry> r101, Key r102) {
        Intrinsics.checkNotNullParameter(r100, "category");
        Intrinsics.checkNotNullParameter(r101, "fileList");
        Intrinsics.checkNotNullParameter(r102, "key");
        this.f206021a = r100;
        this.f206022b = r101;
        this.f206023c = r102;
    }
}
