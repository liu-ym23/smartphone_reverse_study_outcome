package com.bytedance.ee.bear.middleground.permission.share.info;

import android.os.Parcel;
import android.os.Parcelable;
import cj5.b;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderPermission;
import com.bytedance.ee.bear.share.export.f;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import jg5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\bB\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Bk\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u00101\u001a\u00020\u0004H\u0016J\b\u00102\u001a\u00020\u0006H\u0016J\b\u00103\u001a\u00020\u0006H\u0016J\b\u00104\u001a\u00020\u0011H\u0016J\b\u00105\u001a\u00020\u0004H\u0016J\b\u00106\u001a\u00020\u0006H\u0016J\b\u00107\u001a\u00020\u0006H\u0016J\b\u00108\u001a\u00020\u0011H\u0016J\b\u00109\u001a\u00020\u0011H\u0016J\b\u0010:\u001a\u00020\u0006H\u0016J\b\u0010;\u001a\u00020\u0011H\u0016J\b\u0010<\u001a\u00020\u0011H\u0016J\b\u0010=\u001a\u00020\u0011H\u0016J\b\u0010>\u001a\u00020\u0011H\u0016J\b\u0010?\u001a\u00020\u0011H\u0016J\b\u0010@\u001a\u00020\u0011H\u0016J\b\u0010A\u001a\u00020\u0011H\u0016J\b\u0010B\u001a\u00020\u0011H\u0016J\b\u0010C\u001a\u00020\u0011H\u0016J\b\u0010D\u001a\u00020\u0011H\u0016J\b\u0010E\u001a\u00020\u0006H\u0016J\t\u0010F\u001a\u00020\u0004HÆ\u0003J\t\u0010G\u001a\u00020\u0006HÆ\u0003J\t\u0010H\u001a\u00020\u0006HÆ\u0003J\t\u0010I\u001a\u00020\u0006HÆ\u0003J\t\u0010J\u001a\u00020\u0006HÆ\u0003J\t\u0010K\u001a\u00020\u0006HÆ\u0003J\t\u0010L\u001a\u00020\u0006HÆ\u0003J\t\u0010M\u001a\u00020\rHÆ\u0003J\t\u0010N\u001a\u00020\u000fHÆ\u0003J\t\u0010O\u001a\u00020\u0011HÆ\u0003Jm\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0006\u0010Q\u001a\u00020\u0004J\u0013\u0010R\u001a\u00020\u00112\b\u0010S\u001a\u0004\u0018\u00010THÖ\u0003J\t\u0010U\u001a\u00020\u0004HÖ\u0001J\t\u0010V\u001a\u00020\u0006HÖ\u0001J\u0016\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010.\"\u0004\b/\u00100¨\u0006\\"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/share/info/ShareFolderInfo;", "Landroid/os/Parcelable;", "Lcom/bytedance/ee/bear/share/export/IShareInfo;", "type", "", "docUrl", "", "token", "ownerUid", "createTime", "spaceId", "ownerTenantId", "folderVersion", "Lcom/bytedance/ee/bear/list/dto/FolderVersion;", "folderPerm", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderPermission;", "isInit", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/list/dto/FolderVersion;Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderPermission;Z)V", "getType", "()I", "setType", "(I)V", "getDocUrl", "()Ljava/lang/String;", "setDocUrl", "(Ljava/lang/String;)V", "getToken", "setToken", "getOwnerUid", "setOwnerUid", "getCreateTime", "setCreateTime", "getSpaceId", "setSpaceId", "getOwnerTenantId", "setOwnerTenantId", "getFolderVersion", "()Lcom/bytedance/ee/bear/list/dto/FolderVersion;", "setFolderVersion", "(Lcom/bytedance/ee/bear/list/dto/FolderVersion;)V", "getFolderPerm", "()Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderPermission;", "setFolderPerm", "(Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderPermission;)V", "()Z", "setInit", "(Z)V", "getUserPerm", "getCreateTimeStr", "getCreatorUid", "isOwner", "getDocType", "getObjToken", "getCreatorTenantId", "adminCanCross", "isSingleContainer", "getRequestToken", "enablePermSet", "externalAccess", "canExport", "canShare", "isLinkShareClose", "isLinkShareInternalRead", "isLinkShareInternalEdit", "isLinkShareAnyoneRead", "isLinkShareAnyoneEdit", "canManagePermissionMeta", "getOwnerTenantName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareFolderInfo implements Parcelable, f {
    public static final Parcelable.Creator<ShareFolderInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f234252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f234253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f234254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f234255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f234256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f234257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f234258g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FolderVersion f234259h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ShareFolderPermission f234260i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f234261j;

    public static final class a implements Parcelable.Creator<ShareFolderInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShareFolderInfo createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            int r100 = r110.readInt();
            String r101 = r110.readString();
            String r102 = r110.readString();
            String r103 = r110.readString();
            String r104 = r110.readString();
            String r105 = r110.readString();
            String r106 = r110.readString();
            FolderVersion r107 = (FolderVersion) r110.readParcelable(ShareFolderInfo.class.getClassLoader());
            ShareFolderPermission r111 = (ShareFolderPermission) r110.readParcelable(ShareFolderInfo.class.getClassLoader());
            if (r110.readInt() == 0) goto L5;
            boolean r112 = true;
        L7:
            return new ShareFolderInfo(r100, r101, r102, r103, r104, r105, r106, r107, r111, r112);
        L5:
            r112 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ShareFolderInfo[] newArray(int r100) {
            return new ShareFolderInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ShareFolderInfo() {
        this(0, null, null, null, null, null, null, null, null, 1023);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShareFolderInfo) == true) goto L8;
        return false;
    L8:
        ShareFolderInfo r101 = (ShareFolderInfo) r100;
        if (this.f234252a == r101.f234252a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f234253b, r101.f234253b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f234254c, r101.f234254c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f234255d, r101.f234255d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f234256e, r101.f234256e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f234257f, r101.f234257f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f234258g, r101.f234258g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f234259h, r101.f234259h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f234260i, r101.f234260i) == true) goto L36;
        return false;
    L36:
        if (this.f234261j == r101.f234261j) goto L38;
        return false;
    L38:
        return true;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean g() {
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((((this.f234252a * 31) + this.f234253b.hashCode()) * 31) + this.f234254c.hashCode()) * 31) + this.f234255d.hashCode()) * 31) + this.f234256e.hashCode()) * 31) + this.f234257f.hashCode()) * 31) + this.f234258g.hashCode()) * 31) + this.f234259h.hashCode()) * 31) + this.f234260i.hashCode()) * 31;
        if (this.f234261j == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isLinkShareAnyoneEdit() {
        return false;
    }

    public final String toString() {
        return "ShareFolderInfo(type=" + this.f234252a + ", docUrl=" + this.f234253b + ", token=" + this.f234254c + ", ownerUid=" + this.f234255d + ", createTime=" + this.f234256e + ", spaceId=" + this.f234257f + ", ownerTenantId=" + this.f234258g + ", folderVersion=" + this.f234259h + ", folderPerm=" + this.f234260i + ", isInit=" + this.f234261j + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.f234252a);
        r100.writeString(this.f234253b);
        r100.writeString(this.f234254c);
        r100.writeString(this.f234255d);
        r100.writeString(this.f234256e);
        r100.writeString(this.f234257f);
        r100.writeString(this.f234258g);
        r100.writeParcelable(this.f234259h, r101);
        r100.writeParcelable(this.f234260i, r101);
        r100.writeInt(this.f234261j ? 1 : 0);
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean adminCanCross() {
        return this.f234260i.f234426b.adminCanCross();
    }

    public final boolean b() {
        return this.f234260i.f234425a.canManagePermissionMeta(isOwner());
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean canExport() {
        ((b) org.koin.java.a.c(b.class, null, null, 6)).getConfig();
        if (e.a.f499003a.g() == false) goto L7;
        BaseEntity r100 = new BaseEntity(this.f234254c, sbb.e.d(this.f234252a), BizDomain.FileBizDomainCCM, this.f234258g);
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r100, "EXPORT"), null).getAllow();
    L7:
        return ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_EXPORT", FileBizDomain.FileBizDomainCCM, this.f234252a, this.f234254c).f481503a;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean canShare() {
        if (this.f234259h.isFolderV1() == false) goto L9;
        if (this.f234259h.isPersonalFolder() == false) goto L11;
        return true;
    L11:
        return this.f234260i.f234425a.canManagerCollaborator();
    L9:
        return this.f234260i.f234425a.canManagerCollaborator();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean externalAccess() {
        return this.f234260i.f234426b.externalAccess();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean i() {
        return this.f234259h.isShareFolderV2();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isLinkShareAnyoneRead() {
        return this.f234260i.f234426b.isLinkShareAnyoneRead();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isLinkShareInternalEdit() {
        return this.f234260i.f234426b.isLinkShareInternalEdit();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isLinkShareInternalRead() {
        return this.f234260i.f234426b.isLinkShareInternalRead();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isOwner() {
        return this.f234260i.f234426b.isOwner();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean e() {
        if (isOwner() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f234260i.f234425a.canManagePermissionMeta(isOwner()) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String j() {
        if (i() == false) goto L6;
        return this.f234254c;
    L6:
        return this.f234257f;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String a() {
        return this.f234258g;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String d() {
        return this.f234255d;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final int getDocType() {
        return this.f234252a;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String getObjToken() {
        return this.f234254c;
    }

    public final int getType() {
        return this.f234252a;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String h() {
        return this.f234256e;
    }

    public ShareFolderInfo(int r110, String r111, String r112, String r113, String r114, String r210, String r211, FolderVersion r212, ShareFolderPermission r213, int r214) {
        if ((r214 & 1) == 0) goto L5;
        int r100 = sbb.e.f541295f.f541317b;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r106 = "";
    L31:
        if ((r214 & 128) == 0) goto L33;
        FolderVersion r115 = new FolderVersion(0, 0, false, 7, null);
    L35:
        if ((r214 & 256) == 0) goto L37;
        ShareFolderPermission r116 = new ShareFolderPermission(0);
    L39:
        if ((r214 & 512) == 0) goto L41;
        boolean r117 = true;
    L42:
        this(r100, r101, r102, r103, r104, r105, r106, r115, r116, r117);
        return;
    L41:
        r117 = false;
        goto L42
    L37:
        r116 = r213;
        goto L39
    L33:
        r115 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public ShareFolderInfo(int r100, String r101, String r102, String r103, String r104, String r105, String r106, FolderVersion r107, ShareFolderPermission r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r101, "docUrl");
        Intrinsics.checkNotNullParameter(r102, "token");
        Intrinsics.checkNotNullParameter(r103, "ownerUid");
        Intrinsics.checkNotNullParameter(r104, "createTime");
        Intrinsics.checkNotNullParameter(r105, "spaceId");
        Intrinsics.checkNotNullParameter(r106, "ownerTenantId");
        Intrinsics.checkNotNullParameter(r107, "folderVersion");
        Intrinsics.checkNotNullParameter(r110, "folderPerm");
        this.f234252a = r100;
        this.f234253b = r101;
        this.f234254c = r102;
        this.f234255d = r103;
        this.f234256e = r104;
        this.f234257f = r105;
        this.f234258g = r106;
        this.f234259h = r107;
        this.f234260i = r110;
        this.f234261j = r111;
    }
}
