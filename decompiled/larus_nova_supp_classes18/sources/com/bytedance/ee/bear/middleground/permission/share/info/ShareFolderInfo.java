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
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import jg5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\bB\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Bk\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u00101\u001a\u00020\u0004H\u0016J\b\u00102\u001a\u00020\u0006H\u0016J\b\u00103\u001a\u00020\u0006H\u0016J\b\u00104\u001a\u00020\u0011H\u0016J\b\u00105\u001a\u00020\u0004H\u0016J\b\u00106\u001a\u00020\u0006H\u0016J\b\u00107\u001a\u00020\u0006H\u0016J\b\u00108\u001a\u00020\u0011H\u0016J\b\u00109\u001a\u00020\u0011H\u0016J\b\u0010:\u001a\u00020\u0006H\u0016J\b\u0010;\u001a\u00020\u0011H\u0016J\b\u0010<\u001a\u00020\u0011H\u0016J\b\u0010=\u001a\u00020\u0011H\u0016J\b\u0010>\u001a\u00020\u0011H\u0016J\b\u0010?\u001a\u00020\u0011H\u0016J\b\u0010@\u001a\u00020\u0011H\u0016J\b\u0010A\u001a\u00020\u0011H\u0016J\b\u0010B\u001a\u00020\u0011H\u0016J\b\u0010C\u001a\u00020\u0011H\u0016J\b\u0010D\u001a\u00020\u0011H\u0016J\b\u0010E\u001a\u00020\u0006H\u0016J\t\u0010F\u001a\u00020\u0004HÆ\u0003J\t\u0010G\u001a\u00020\u0006HÆ\u0003J\t\u0010H\u001a\u00020\u0006HÆ\u0003J\t\u0010I\u001a\u00020\u0006HÆ\u0003J\t\u0010J\u001a\u00020\u0006HÆ\u0003J\t\u0010K\u001a\u00020\u0006HÆ\u0003J\t\u0010L\u001a\u00020\u0006HÆ\u0003J\t\u0010M\u001a\u00020\rHÆ\u0003J\t\u0010N\u001a\u00020\u000fHÆ\u0003J\t\u0010O\u001a\u00020\u0011HÆ\u0003Jm\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0006\u0010Q\u001a\u00020\u0004J\u0013\u0010R\u001a\u00020\u00112\b\u0010S\u001a\u0004\u0018\u00010THÖ\u0003J\t\u0010U\u001a\u00020\u0004HÖ\u0001J\t\u0010V\u001a\u00020\u0006HÖ\u0001J\u0016\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010.\"\u0004\b/\u00100¨\u0006\\"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/share/info/ShareFolderInfo;", "Landroid/os/Parcelable;", "Lcom/bytedance/ee/bear/share/export/IShareInfo;", ResourceData.KEY_TYPE, "", "docUrl", "", ResourceData.KEY_TOKEN, "ownerUid", "createTime", "spaceId", "ownerTenantId", "folderVersion", "Lcom/bytedance/ee/bear/list/dto/FolderVersion;", "folderPerm", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderPermission;", "isInit", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/list/dto/FolderVersion;Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderPermission;Z)V", "getType", "()I", "setType", "(I)V", "getDocUrl", "()Ljava/lang/String;", "setDocUrl", "(Ljava/lang/String;)V", "getToken", "setToken", "getOwnerUid", "setOwnerUid", "getCreateTime", "setCreateTime", "getSpaceId", "setSpaceId", "getOwnerTenantId", "setOwnerTenantId", "getFolderVersion", "()Lcom/bytedance/ee/bear/list/dto/FolderVersion;", "setFolderVersion", "(Lcom/bytedance/ee/bear/list/dto/FolderVersion;)V", "getFolderPerm", "()Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderPermission;", "setFolderPerm", "(Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderPermission;)V", "()Z", "setInit", "(Z)V", "getUserPerm", "getCreateTimeStr", "getCreatorUid", "isOwner", "getDocType", "getObjToken", "getCreatorTenantId", "adminCanCross", "isSingleContainer", "getRequestToken", "enablePermSet", "externalAccess", "canExport", "canShare", "isLinkShareClose", "isLinkShareInternalRead", "isLinkShareInternalEdit", "isLinkShareAnyoneRead", "isLinkShareAnyoneEdit", "canManagePermissionMeta", "getOwnerTenantName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareFolderInfo implements Parcelable, f {
    public static final Parcelable.Creator<ShareFolderInfo> CREATOR = null;
    public final int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public FolderVersion h;
    public ShareFolderPermission i;
    public boolean j;

    public static final class a implements Parcelable.Creator<ShareFolderInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShareFolderInfo createFromParcel(Parcel r13) {
            Intrinsics.checkNotNullParameter(r13, "parcel");
            int r2 = r13.readInt();
            String r3 = r13.readString();
            String r4 = r13.readString();
            String r5 = r13.readString();
            String r6 = r13.readString();
            String r7 = r13.readString();
            String r8 = r13.readString();
            FolderVersion r9 = (FolderVersion) r13.readParcelable(ShareFolderInfo.class.getClassLoader());
            ShareFolderPermission r10 = (ShareFolderPermission) r13.readParcelable(ShareFolderInfo.class.getClassLoader());
            if (r13.readInt() == 0) goto L5;
            boolean r11 = true;
        L7:
            return new ShareFolderInfo(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        L5:
            r11 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ShareFolderInfo[] newArray(int r1) {
            return new ShareFolderInfo[r1];
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

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ShareFolderInfo) == true) goto L8;
        return false;
    L8:
        ShareFolderInfo r6 = (ShareFolderInfo) r5;
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
        if (this.j == r6.j) goto L38;
        return false;
    L38:
        return true;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean g() {
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((((((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        if (this.j == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isLinkShareAnyoneEdit() {
        return false;
    }

    public final String toString() {
        return "ShareFolderInfo(type=" + this.a + ", docUrl=" + this.b + ", token=" + this.c + ", ownerUid=" + this.d + ", createTime=" + this.e + ", spaceId=" + this.f + ", ownerTenantId=" + this.g + ", folderVersion=" + this.h + ", folderPerm=" + this.i + ", isInit=" + this.j + ')';
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
        r2.writeParcelable(this.h, r3);
        r2.writeParcelable(this.i, r3);
        r2.writeInt(this.j ? 1 : 0);
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean adminCanCross() {
        return this.i.b.adminCanCross();
    }

    public final boolean b() {
        return this.i.a.canManagePermissionMeta(isOwner());
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean canExport() {
        ((b) org.koin.java.a.c(b.class, null, null, 6)).getConfig();
        if (e.a.a.g() == false) goto L7;
        BaseEntity r0 = new BaseEntity(this.c, sbb.e.d(this.a), BizDomain.FileBizDomainCCM, this.g);
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r0, "EXPORT"), null).getAllow();
    L7:
        return ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_EXPORT", FileBizDomain.FileBizDomainCCM, this.a, this.c).a;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean canShare() {
        if (this.h.isFolderV1() == false) goto L9;
        if (this.h.isPersonalFolder() == false) goto L11;
        return true;
    L11:
        return this.i.a.canManagerCollaborator();
    L9:
        return this.i.a.canManagerCollaborator();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean externalAccess() {
        return this.i.b.externalAccess();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean i() {
        return this.h.isShareFolderV2();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isLinkShareAnyoneRead() {
        return this.i.b.isLinkShareAnyoneRead();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isLinkShareInternalEdit() {
        return this.i.b.isLinkShareInternalEdit();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isLinkShareInternalRead() {
        return this.i.b.isLinkShareInternalRead();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isOwner() {
        return this.i.b.isOwner();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean e() {
        if (isOwner() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.i.a.canManagePermissionMeta(isOwner()) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String j() {
        if (i() == false) goto L6;
        return this.c;
    L6:
        return this.f;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String a() {
        return this.g;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String d() {
        return this.d;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final int getDocType() {
        return this.a;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String getObjToken() {
        return this.c;
    }

    public final int getType() {
        return this.a;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String h() {
        return this.e;
    }

    public ShareFolderInfo(int r15, String r16, String r17, String r18, String r19, String r20, String r21, FolderVersion r22, ShareFolderPermission r23, int r24) {
        if ((r24 & 1) == 0) goto L5;
        int r3 = sbb.e.f.b;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r6 = "";
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r7 = "";
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r8 = "";
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r9 = "";
    L31:
        if ((r24 & 128) == 0) goto L33;
        FolderVersion r10 = new FolderVersion(0, 0, false, 7, null);
    L35:
        if ((r24 & 256) == 0) goto L37;
        ShareFolderPermission r11 = new ShareFolderPermission(0);
    L39:
        if ((r24 & 512) == 0) goto L41;
        boolean r12 = true;
    L42:
        this(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        return;
    L41:
        r12 = false;
        goto L42
    L37:
        r11 = r23;
        goto L39
    L33:
        r10 = r22;
        goto L35
    L29:
        r9 = r21;
        goto L31
    L25:
        r8 = r20;
        goto L27
    L21:
        r7 = r19;
        goto L23
    L17:
        r6 = r18;
        goto L19
    L13:
        r5 = r17;
        goto L15
    L9:
        r4 = r16;
        goto L11
    L5:
        r3 = r15;
        goto L7
    }

    public ShareFolderInfo(int r2, String r3, String r4, String r5, String r6, String r7, String r8, FolderVersion r9, ShareFolderPermission r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r3, "docUrl");
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r5, "ownerUid");
        Intrinsics.checkNotNullParameter(r6, "createTime");
        Intrinsics.checkNotNullParameter(r7, "spaceId");
        Intrinsics.checkNotNullParameter(r8, "ownerTenantId");
        Intrinsics.checkNotNullParameter(r9, "folderVersion");
        Intrinsics.checkNotNullParameter(r10, "folderPerm");
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
    }
}
