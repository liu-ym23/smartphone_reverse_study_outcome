package com.bytedance.ee.bear.list.dto;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/list/dto/FolderVersion;", "Lcom/bytedance/ee/util/io/NonProguard;", "Landroid/os/Parcelable;", "ownerType", "", "shareVersion", "isShareFolder", "", "<init>", "(IIZ)V", "getOwnerType", "()I", "getShareVersion", "()Z", "isPersonalFolder", "isShareFolderV1", "isFolderV1", "isShareFolderV2", "isOldShareFolder", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "contentmanager-space-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderVersion implements NonProguard, Parcelable {
    public static final Parcelable.Creator<FolderVersion> CREATOR = null;
    public static final a Companion = null;
    public static final int NEW_SHARE_FOLDER_VERSION = 1;
    private static final int OLD_SHARE_FOLDER_VERSION = 0;
    private static final int OWNER_TYPE_OLD_SHARE_FOLDER_V1 = 1;
    private static final int OWNER_TYPE_OLD_SHARE_FOLDER_V2 = 5;
    private static final int OWNER_TYPE_PERSONAL_FOLDER = 0;
    private final boolean isShareFolder;
    private final int ownerType;
    private final int shareVersion;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static boolean c(Integer r1) {
            if (r1 != null) goto L5;
        L7:
            return false;
        L5:
            if (r1.intValue() != 5) goto L7;
            return true;
        }

        @JvmStatic
        public static boolean a(int r1, boolean r2) {
            if (c(Integer.valueOf(r1)) == false) goto L6;
            if (r2 == false) goto L7;
        L8:
            return false;
        L7:
            return true;
        L6:
            if (r1 != 0) goto L8;
            goto L7
        }

        @JvmStatic
        public static boolean b(int r3, boolean r4) {
            if (r3 != 1) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L9;
            return true;
        L9:
            if (c(Integer.valueOf(r3)) == false) goto L11;
            return r4;
        L11:
            return false;
        L5:
            r2 = false;
            goto L6
        }
    }

    public static final class b implements Parcelable.Creator<FolderVersion> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final FolderVersion createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            int r1 = r4.readInt();
            int r2 = r4.readInt();
            if (r4.readInt() == 0) goto L5;
            boolean r5 = true;
        L7:
            return new FolderVersion(r1, r2, r5);
        L5:
            r5 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final FolderVersion[] newArray(int r1) {
            return new FolderVersion[r1];
        }
    }

    static {
        Companion = new a();
        CREATOR = new b();
    }

    public FolderVersion() {
        this(0, 0, false, 7, null);
    }

    @JvmStatic
    public static final boolean acceptOwnerType(int r2) {
        Companion.getClass();
        if (r2 == 0) goto L10;
        if (r2 != 1) goto L6;
        return true;
    L6:
        if (r2 == 5) goto L12;
        return false;
    L12:
        return true;
    L10:
        return true;
    }

    @JvmStatic
    public static final int getNewShareFolderOwnerType() {
        Companion.getClass();
        return 5;
    }

    @JvmStatic
    public static final int getPersonalFolderOwnerType() {
        Companion.getClass();
        return 0;
    }

    @JvmStatic
    public static final boolean isNewShareFolder(int r1) {
        Companion.getClass();
        if (r1 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @JvmStatic
    public static final boolean isOldShareFolder(int r1) {
        Companion.getClass();
        if (r1 != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean isPersonalFolder(int r1, boolean r2) {
        Companion.getClass();
        return a.a(r1, r2);
    }

    @JvmStatic
    public static final boolean isShareFolder(int r1, boolean r2) {
        Companion.getClass();
        return a.b(r1, r2);
    }

    @JvmStatic
    public static final boolean isShareFolderV1(int r1) {
        Companion.getClass();
        if (r1 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @JvmStatic
    public static final boolean isShareFolderV2(Integer r1) {
        Companion.getClass();
        return a.c(r1);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeInt(this.ownerType);
        r1.writeInt(this.shareVersion);
        r1.writeInt(this.isShareFolder ? 1 : 0);
    }

    @JvmStatic
    public static final FolderVersion getFolderVersionV2() {
        Companion.getClass();
        return new FolderVersion(5, 0, true);
    }

    public final boolean isFolderV1() {
        int r0 = this.ownerType;
        if (r0 == 0) goto L8;
        if (r0 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    public final boolean isOldShareFolder() {
        a r0 = Companion;
        int r1 = this.shareVersion;
        r0.getClass();
        if (r1 != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isPersonalFolder() {
        a r0 = Companion;
        int r1 = this.ownerType;
        boolean r2 = this.isShareFolder;
        r0.getClass();
        return a.a(r1, r2);
    }

    public final boolean isShareFolderV1() {
        a r0 = Companion;
        int r1 = this.ownerType;
        r0.getClass();
        if (r1 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isShareFolderV2() {
        a r0 = Companion;
        Integer r1 = Integer.valueOf(this.ownerType);
        r0.getClass();
        return a.c(r1);
    }

    public final int getOwnerType() {
        return this.ownerType;
    }

    public final int getShareVersion() {
        return this.shareVersion;
    }

    public final boolean isShareFolder() {
        return this.isShareFolder;
    }

    public FolderVersion(int r1, int r2, boolean r3) {
        this.ownerType = r1;
        this.shareVersion = r2;
        this.isShareFolder = r3;
    }

    public /* synthetic */ FolderVersion(int r2, int r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = false;
    L11:
        this(r2, r3, r4);
    }
}
