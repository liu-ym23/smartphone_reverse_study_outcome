package com.bytedance.ee.bear.middleground_permission_export.model.permissionset;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderPermission;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0005J\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020\u0011J\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0013J\u0006\u0010#\u001a\u00020\u0013J\u0006\u0010$\u001a\u00020\u0013J\u0006\u0010%\u001a\u00020\u0003J\u0006\u0010&\u001a\u00020\u0013J\u0006\u0010'\u001a\u00020\u0005J\u000e\u0010(\u001a\u00020)2\u0006\u0010&\u001a\u00020\u0013J\u000e\u0010*\u001a\u00020)2\u0006\u0010'\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u00020\u0013J\u0006\u00102\u001a\u00020\u0013J\u0006\u00103\u001a\u00020\u0013J\u0006\u00104\u001a\u00020\u0013J\u000e\u00105\u001a\u00020)2\u0006\u0010\"\u001a\u00020\u0013J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u00106\u001a\u00020\u0013J\u0006\u00107\u001a\u00020\u0013J\u0006\u00108\u001a\u00020\u0013J\u0006\u00109\u001a\u00020\u0013J\u0006\u0010:\u001a\u00020\u0013J\u0006\u0010;\u001a\u00020\u0011J\u0006\u0010<\u001a\u00020-J\u0006\u0010=\u001a\u000200J\u0006\u0010>\u001a\u00020\u0013J\t\u0010?\u001a\u00020\u0003HÂ\u0003J\t\u0010@\u001a\u00020\u0005HÂ\u0003J\t\u0010A\u001a\u00020\u0005HÂ\u0003J\t\u0010B\u001a\u00020\u0005HÂ\u0003J\t\u0010C\u001a\u00020\u0005HÂ\u0003J\t\u0010D\u001a\u00020\u0005HÂ\u0003J\t\u0010E\u001a\u00020\u0005HÂ\u0003J\t\u0010F\u001a\u00020\u0005HÂ\u0003J\t\u0010G\u001a\u00020\u0005HÂ\u0003J\t\u0010H\u001a\u00020\u000eHÂ\u0003J\t\u0010I\u001a\u00020\u0005HÂ\u0003J\t\u0010J\u001a\u00020\u0011HÂ\u0003J\t\u0010K\u001a\u00020\u0013HÂ\u0003J\u008b\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001J\u0006\u0010M\u001a\u00020\u0003J\u0013\u0010N\u001a\u00020\u00132\b\u0010O\u001a\u0004\u0018\u00010PHÖ\u0003J\t\u0010Q\u001a\u00020\u0003HÖ\u0001J\t\u0010R\u001a\u00020\u0005HÖ\u0001J\u0016\u0010S\u001a\u00020)2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/FolderPermSetInfo;", "Landroid/os/Parcelable;", ResourceData.KEY_TYPE, "", ResourceData.KEY_URL, "", ResourceData.KEY_TOKEN, "title", "ownerUid", "ownerName", "creatorUid", "createTime", "creatorTenantId", "shareFolderPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderPermission;", "spaceId", "version", "Lcom/bytedance/ee/bear/list/dto/FolderVersion;", "isRoot", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderPermission;Ljava/lang/String;Lcom/bytedance/ee/bear/list/dto/FolderVersion;Z)V", "getUrl", "getType", "getToken", "getTitle", "getOwnerName", "getOwnerUid", "getCreatorUid", "getCreateTime", "getCreatorTenantId", "getSpaceId", "getOwnerType", "getOwnerTenantName", "isOwner", "canCross", "externalAccess", "getUserPerm", "hasPassword", "password", "setHasPassword", "", "setPassword", "setPublicPermission", "shareFolderPublicPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/IFolderPublicPermission;", "setUserPermission", "shareFolderUserPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderUserPermission;", "getLockState", "canUnlock", "isShareFolderV2", "canPermSet", "setOwner", "canInviteFa", "canInviteEdit", "canInviteView", "canManageCollaborator", "showLinkShareSetView", "getFolderVersion", "getPublicPermission", "getUserPermission", "canMangePermMeta", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderPermSetInfo implements Parcelable {
    public static final Parcelable.Creator<FolderPermSetInfo> CREATOR = null;
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final ShareFolderPermission j;
    public final String k;
    public final FolderVersion l;
    public final boolean m;

    public static final class a implements Parcelable.Creator<FolderPermSetInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FolderPermSetInfo createFromParcel(Parcel r17) {
            Intrinsics.checkNotNullParameter(r17, "parcel");
            int r3 = r17.readInt();
            String r4 = r17.readString();
            String r5 = r17.readString();
            String r6 = r17.readString();
            String r7 = r17.readString();
            String r8 = r17.readString();
            String r9 = r17.readString();
            String r10 = r17.readString();
            String r11 = r17.readString();
            ShareFolderPermission r12 = (ShareFolderPermission) r17.readParcelable(FolderPermSetInfo.class.getClassLoader());
            String r13 = r17.readString();
            FolderVersion r14 = (FolderVersion) r17.readParcelable(FolderPermSetInfo.class.getClassLoader());
            if (r17.readInt() == 0) goto L5;
            boolean r15 = true;
        L7:
            return new FolderPermSetInfo(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
        L5:
            r15 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final FolderPermSetInfo[] newArray(int r1) {
            return new FolderPermSetInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public FolderPermSetInfo() {
        String r0 = null;
        int r2 = 0;
        this(r2, r0, r0, 8191);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FolderPermSetInfo) == true) goto L8;
        return false;
    L8:
        FolderPermSetInfo r6 = (FolderPermSetInfo) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((((((((((((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31;
        if (this.m == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "FolderPermSetInfo(type=" + this.a + ", url=" + this.b + ", token=" + this.c + ", title=" + this.d + ", ownerUid=" + this.e + ", ownerName=" + this.f + ", creatorUid=" + this.g + ", createTime=" + this.h + ", creatorTenantId=" + this.i + ", shareFolderPermission=" + this.j + ", spaceId=" + this.k + ", version=" + this.l + ", isRoot=" + this.m + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeInt(this.a);
        r2.writeString(this.b);
        r2.writeString(this.c);
        r2.writeString(this.d);
        r2.writeString(this.e);
        r2.writeString(this.f);
        r2.writeString(this.g);
        r2.writeString(this.h);
        r2.writeString(this.i);
        r2.writeParcelable(this.j, r3);
        r2.writeString(this.k);
        r2.writeParcelable(this.l, r3);
        r2.writeInt(this.m ? 1 : 0);
    }

    public final boolean a() {
        return this.j.b.isOwner();
    }

    public final boolean b() {
        return this.l.isShareFolderV2();
    }

    public final int getType() {
        return this.a;
    }

    public /* synthetic */ FolderPermSetInfo(int r22, String r23, String r24, int r25) {
        int r2 = 0;
        if ((r25 & 1) == 0) goto L5;
        int r4 = 0;
    L7:
        if ((r25 & 2) == 0) goto L9;
        String r1 = "";
    L11:
        if ((r25 & 4) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r25 & 8) == 0) goto L17;
        String r7 = "";
    L19:
        if ((r25 & 16) == 0) goto L21;
        String r8 = "";
    L23:
        if ((r25 & 32) == 0) goto L25;
        String r9 = "";
    L27:
        if ((r25 & 64) == 0) goto L29;
        String r10 = "";
    L31:
        if ((r25 & 128) == 0) goto L33;
        String r11 = "0";
    L35:
        if ((r25 & 256) == 0) goto L37;
        String r12 = "";
    L39:
        if ((r25 & 512) == 0) goto L41;
        ShareFolderPermission r13 = new ShareFolderPermission(r2);
    L43:
        if ((r25 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L45;
        String r14 = "";
    L47:
        if ((r25 & DocUserPermission.USER_PREVIEW) == 0) goto L49;
        FolderVersion r15 = new FolderVersion(0, 0, false, 7, null);
    L50:
        this(r4, r1, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, false);
        return;
    L49:
        r15 = null;
        goto L50
    L45:
        r14 = r24;
        goto L47
    L41:
        r13 = null;
        goto L43
    L37:
        r12 = null;
        goto L39
    L33:
        r11 = null;
        goto L35
    L29:
        r10 = null;
        goto L31
    L25:
        r9 = null;
        goto L27
    L21:
        r8 = null;
        goto L23
    L17:
        r7 = null;
        goto L19
    L13:
        r6 = r23;
        goto L15
    L9:
        r1 = null;
        goto L11
    L5:
        r4 = r22;
        goto L7
    }

    public FolderPermSetInfo(int r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, ShareFolderPermission r11, String r12, FolderVersion r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_URL);
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r5, "title");
        Intrinsics.checkNotNullParameter(r6, "ownerUid");
        Intrinsics.checkNotNullParameter(r7, "ownerName");
        Intrinsics.checkNotNullParameter(r8, "creatorUid");
        Intrinsics.checkNotNullParameter(r9, "createTime");
        Intrinsics.checkNotNullParameter(r10, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r11, "shareFolderPermission");
        Intrinsics.checkNotNullParameter(r12, "spaceId");
        Intrinsics.checkNotNullParameter(r13, "version");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
    }
}
