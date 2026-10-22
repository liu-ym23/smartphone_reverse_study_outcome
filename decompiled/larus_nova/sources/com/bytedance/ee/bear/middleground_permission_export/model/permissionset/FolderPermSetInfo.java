package com.bytedance.ee.bear.middleground_permission_export.model.permissionset;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderPermission;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0005J\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020\u0011J\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0013J\u0006\u0010#\u001a\u00020\u0013J\u0006\u0010$\u001a\u00020\u0013J\u0006\u0010%\u001a\u00020\u0003J\u0006\u0010&\u001a\u00020\u0013J\u0006\u0010'\u001a\u00020\u0005J\u000e\u0010(\u001a\u00020)2\u0006\u0010&\u001a\u00020\u0013J\u000e\u0010*\u001a\u00020)2\u0006\u0010'\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u00020\u0013J\u0006\u00102\u001a\u00020\u0013J\u0006\u00103\u001a\u00020\u0013J\u0006\u00104\u001a\u00020\u0013J\u000e\u00105\u001a\u00020)2\u0006\u0010\"\u001a\u00020\u0013J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u00106\u001a\u00020\u0013J\u0006\u00107\u001a\u00020\u0013J\u0006\u00108\u001a\u00020\u0013J\u0006\u00109\u001a\u00020\u0013J\u0006\u0010:\u001a\u00020\u0013J\u0006\u0010;\u001a\u00020\u0011J\u0006\u0010<\u001a\u00020-J\u0006\u0010=\u001a\u000200J\u0006\u0010>\u001a\u00020\u0013J\t\u0010?\u001a\u00020\u0003HÂ\u0003J\t\u0010@\u001a\u00020\u0005HÂ\u0003J\t\u0010A\u001a\u00020\u0005HÂ\u0003J\t\u0010B\u001a\u00020\u0005HÂ\u0003J\t\u0010C\u001a\u00020\u0005HÂ\u0003J\t\u0010D\u001a\u00020\u0005HÂ\u0003J\t\u0010E\u001a\u00020\u0005HÂ\u0003J\t\u0010F\u001a\u00020\u0005HÂ\u0003J\t\u0010G\u001a\u00020\u0005HÂ\u0003J\t\u0010H\u001a\u00020\u000eHÂ\u0003J\t\u0010I\u001a\u00020\u0005HÂ\u0003J\t\u0010J\u001a\u00020\u0011HÂ\u0003J\t\u0010K\u001a\u00020\u0013HÂ\u0003J\u008b\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001J\u0006\u0010M\u001a\u00020\u0003J\u0013\u0010N\u001a\u00020\u00132\b\u0010O\u001a\u0004\u0018\u00010PHÖ\u0003J\t\u0010Q\u001a\u00020\u0003HÖ\u0001J\t\u0010R\u001a\u00020\u0005HÖ\u0001J\u0016\u0010S\u001a\u00020)2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/FolderPermSetInfo;", "Landroid/os/Parcelable;", "type", "", "url", "", "token", "title", "ownerUid", "ownerName", "creatorUid", "createTime", "creatorTenantId", "shareFolderPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderPermission;", "spaceId", "version", "Lcom/bytedance/ee/bear/list/dto/FolderVersion;", "isRoot", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderPermission;Ljava/lang/String;Lcom/bytedance/ee/bear/list/dto/FolderVersion;Z)V", "getUrl", "getType", "getToken", "getTitle", "getOwnerName", "getOwnerUid", "getCreatorUid", "getCreateTime", "getCreatorTenantId", "getSpaceId", "getOwnerType", "getOwnerTenantName", "isOwner", "canCross", "externalAccess", "getUserPerm", "hasPassword", "password", "setHasPassword", "", "setPassword", "setPublicPermission", "shareFolderPublicPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/IFolderPublicPermission;", "setUserPermission", "shareFolderUserPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderUserPermission;", "getLockState", "canUnlock", "isShareFolderV2", "canPermSet", "setOwner", "canInviteFa", "canInviteEdit", "canInviteView", "canManageCollaborator", "showLinkShareSetView", "getFolderVersion", "getPublicPermission", "getUserPermission", "canMangePermMeta", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderPermSetInfo implements Parcelable {
    public static final Parcelable.Creator<FolderPermSetInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f234438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f234439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f234440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f234441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f234442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f234443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f234444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f234445h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f234446i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ShareFolderPermission f234447j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f234448k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final FolderVersion f234449l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f234450m;

    public static final class a implements Parcelable.Creator<FolderPermSetInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FolderPermSetInfo createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            int r100 = r110.readInt();
            String r101 = r110.readString();
            String r102 = r110.readString();
            String r103 = r110.readString();
            String r104 = r110.readString();
            String r105 = r110.readString();
            String r106 = r110.readString();
            String r111 = r110.readString();
            String r112 = r110.readString();
            ShareFolderPermission r113 = (ShareFolderPermission) r110.readParcelable(FolderPermSetInfo.class.getClassLoader());
            String r114 = r110.readString();
            FolderVersion r115 = (FolderVersion) r110.readParcelable(FolderPermSetInfo.class.getClassLoader());
            if (r110.readInt() == 0) goto L5;
            boolean r116 = true;
        L7:
            return new FolderPermSetInfo(r100, r101, r102, r103, r104, r105, r106, r111, r112, r113, r114, r115, r116);
        L5:
            r116 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final FolderPermSetInfo[] newArray(int r100) {
            return new FolderPermSetInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public FolderPermSetInfo() {
        String r100 = null;
        int r101 = 0;
        this(r101, r100, r100, 8191);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FolderPermSetInfo) == true) goto L8;
        return false;
    L8:
        FolderPermSetInfo r101 = (FolderPermSetInfo) r100;
        if (this.f234438a == r101.f234438a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f234439b, r101.f234439b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f234440c, r101.f234440c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f234441d, r101.f234441d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f234442e, r101.f234442e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f234443f, r101.f234443f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f234444g, r101.f234444g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f234445h, r101.f234445h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f234446i, r101.f234446i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f234447j, r101.f234447j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f234448k, r101.f234448k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f234449l, r101.f234449l) == true) goto L45;
        return false;
    L45:
        if (this.f234450m == r101.f234450m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((((((((((this.f234438a * 31) + this.f234439b.hashCode()) * 31) + this.f234440c.hashCode()) * 31) + this.f234441d.hashCode()) * 31) + this.f234442e.hashCode()) * 31) + this.f234443f.hashCode()) * 31) + this.f234444g.hashCode()) * 31) + this.f234445h.hashCode()) * 31) + this.f234446i.hashCode()) * 31) + this.f234447j.hashCode()) * 31) + this.f234448k.hashCode()) * 31) + this.f234449l.hashCode()) * 31;
        if (this.f234450m == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "FolderPermSetInfo(type=" + this.f234438a + ", url=" + this.f234439b + ", token=" + this.f234440c + ", title=" + this.f234441d + ", ownerUid=" + this.f234442e + ", ownerName=" + this.f234443f + ", creatorUid=" + this.f234444g + ", createTime=" + this.f234445h + ", creatorTenantId=" + this.f234446i + ", shareFolderPermission=" + this.f234447j + ", spaceId=" + this.f234448k + ", version=" + this.f234449l + ", isRoot=" + this.f234450m + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.f234438a);
        r100.writeString(this.f234439b);
        r100.writeString(this.f234440c);
        r100.writeString(this.f234441d);
        r100.writeString(this.f234442e);
        r100.writeString(this.f234443f);
        r100.writeString(this.f234444g);
        r100.writeString(this.f234445h);
        r100.writeString(this.f234446i);
        r100.writeParcelable(this.f234447j, r101);
        r100.writeString(this.f234448k);
        r100.writeParcelable(this.f234449l, r101);
        r100.writeInt(this.f234450m ? 1 : 0);
    }

    public final boolean a() {
        return this.f234447j.f234426b.isOwner();
    }

    public final boolean b() {
        return this.f234449l.isShareFolderV2();
    }

    public final int getType() {
        return this.f234438a;
    }

    public /* synthetic */ FolderPermSetInfo(int r210, String r211, String r212, int r213) {
        int r100 = 0;
        if ((r213 & 1) == 0) goto L5;
        int r101 = 0;
    L7:
        if ((r213 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r213 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r213 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r213 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r213 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r213 & 64) == 0) goto L29;
        String r110 = "";
    L31:
        if ((r213 & 128) == 0) goto L33;
        String r111 = "0";
    L35:
        if ((r213 & 256) == 0) goto L37;
        String r112 = "";
    L39:
        if ((r213 & 512) == 0) goto L41;
        ShareFolderPermission r113 = new ShareFolderPermission(r100);
    L43:
        if ((r213 & 1024) == 0) goto L45;
        String r114 = "";
    L47:
        if ((r213 & 2048) == 0) goto L49;
        FolderVersion r115 = new FolderVersion(0, 0, false, 7, null);
    L50:
        this(r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, false);
        return;
    L49:
        r115 = null;
        goto L50
    L45:
        r114 = r212;
        goto L47
    L41:
        r113 = null;
        goto L43
    L37:
        r112 = null;
        goto L39
    L33:
        r111 = null;
        goto L35
    L29:
        r110 = null;
        goto L31
    L25:
        r106 = null;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = r211;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }

    public FolderPermSetInfo(int r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, ShareFolderPermission r111, String r112, FolderVersion r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "token");
        Intrinsics.checkNotNullParameter(r103, "title");
        Intrinsics.checkNotNullParameter(r104, "ownerUid");
        Intrinsics.checkNotNullParameter(r105, "ownerName");
        Intrinsics.checkNotNullParameter(r106, "creatorUid");
        Intrinsics.checkNotNullParameter(r107, "createTime");
        Intrinsics.checkNotNullParameter(r110, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r111, "shareFolderPermission");
        Intrinsics.checkNotNullParameter(r112, "spaceId");
        Intrinsics.checkNotNullParameter(r113, "version");
        this.f234438a = r100;
        this.f234439b = r101;
        this.f234440c = r102;
        this.f234441d = r103;
        this.f234442e = r104;
        this.f234443f = r105;
        this.f234444g = r106;
        this.f234445h = r107;
        this.f234446i = r110;
        this.f234447j = r111;
        this.f234448k = r112;
        this.f234449l = r113;
        this.f234450m = r114;
    }
}
