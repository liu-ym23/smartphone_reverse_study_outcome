package com.bytedance.ee.bear.middleground_permission_export.model.folder;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderPermission;", "Landroid/os/Parcelable;", "shareFolderUserPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderUserPermission;", "publicPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/IFolderPublicPermission;", "<init>", "(Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderUserPermission;Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/IFolderPublicPermission;)V", "getShareFolderUserPermission", "()Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderUserPermission;", "setShareFolderUserPermission", "(Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderUserPermission;)V", "getPublicPermission", "()Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/IFolderPublicPermission;", "setPublicPermission", "(Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/IFolderPublicPermission;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "middleground-permission-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareFolderPermission implements Parcelable {
    public static final Parcelable.Creator<ShareFolderPermission> CREATOR = null;
    public final ShareFolderUserPermission a;
    public final IFolderPublicPermission b;

    public static final class a implements Parcelable.Creator<ShareFolderPermission> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShareFolderPermission createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            return new ShareFolderPermission((ShareFolderUserPermission) r3.readSerializable(), (IFolderPublicPermission) r3.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        public final ShareFolderPermission[] newArray(int r1) {
            return new ShareFolderPermission[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ShareFolderPermission() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ShareFolderPermission) == true) goto L8;
        return false;
    L8:
        ShareFolderPermission r6 = (ShareFolderPermission) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "ShareFolderPermission(shareFolderUserPermission=" + this.a + ", publicPermission=" + this.b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeSerializable(this.a);
        r1.writeSerializable(this.b);
    }

    public /* synthetic */ ShareFolderPermission(int r9) {
        this(new ShareFolderUserPermission(0, null, null, false, null, 31, null), new DefaultFolderPublicPermission(false, 1, null));
    }

    public ShareFolderPermission(ShareFolderUserPermission r2, IFolderPublicPermission r3) {
        Intrinsics.checkNotNullParameter(r2, "shareFolderUserPermission");
        Intrinsics.checkNotNullParameter(r3, "publicPermission");
        this.a = r2;
        this.b = r3;
    }
}
