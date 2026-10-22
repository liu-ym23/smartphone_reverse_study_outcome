package com.bytedance.ee.bear.middleground.permission.share.info;

import android.os.Parcel;
import android.os.Parcelable;
import cj5.b;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UniBaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DefaultDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DefaultDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.share.export.f;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import jg5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\bH\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Bk\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\b\u00107\u001a\u00020\u0004H\u0016J\b\u00108\u001a\u00020\u0006H\u0016J\b\u00109\u001a\u00020\u0006H\u0016J\b\u0010:\u001a\u00020\u0011H\u0016J\b\u0010;\u001a\u00020\u0004H\u0016J\b\u0010<\u001a\u00020\u0006H\u0016J\b\u0010=\u001a\u00020\u0006H\u0016J\b\u0010>\u001a\u00020\u0011H\u0016J\b\u0010?\u001a\u00020\u0011H\u0016J\b\u0010@\u001a\u00020\u0006H\u0016J\b\u0010A\u001a\u00020\u0011H\u0016J\b\u0010B\u001a\u00020\u0011H\u0016J\b\u0010C\u001a\u00020\u0011H\u0016J\b\u0010D\u001a\u00020\u0011H\u0016J\b\u0010E\u001a\u00020\u0011H\u0016J\b\u0010F\u001a\u00020\u0011H\u0016J\b\u0010G\u001a\u00020\u0011H\u0016J\b\u0010H\u001a\u00020\u0011H\u0016J\b\u0010I\u001a\u00020\u0011H\u0016J\b\u0010J\u001a\u00020\u0011H\u0016J\b\u0010K\u001a\u00020\u0011H\u0016J\t\u0010L\u001a\u00020\u0004HÆ\u0003J\t\u0010M\u001a\u00020\u0006HÆ\u0003J\t\u0010N\u001a\u00020\u0006HÆ\u0003J\t\u0010O\u001a\u00020\tHÆ\u0003J\t\u0010P\u001a\u00020\u000bHÆ\u0003J\t\u0010Q\u001a\u00020\rHÆ\u0003J\t\u0010R\u001a\u00020\u000fHÆ\u0003J\t\u0010S\u001a\u00020\u0011HÆ\u0003J\t\u0010T\u001a\u00020\u0011HÆ\u0003J\t\u0010U\u001a\u00020\u0011HÆ\u0003Jm\u0010V\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0011HÆ\u0001J\u0006\u0010W\u001a\u00020\u0004J\u0013\u0010X\u001a\u00020\u00112\b\u0010Y\u001a\u0004\u0018\u00010ZHÖ\u0003J\t\u0010[\u001a\u00020\u0004HÖ\u0001J\t\u0010\\\u001a\u00020\u0006HÖ\u0001J\u0016\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\u0012\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00101\"\u0004\b5\u00103R\u001a\u0010\u0013\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u00101\"\u0004\b6\u00103¨\u0006b"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/share/info/ShareDocInfo;", "Landroid/os/Parcelable;", "Lcom/bytedance/ee/bear/share/export/IShareInfo;", ResourceData.KEY_TYPE, "", "docUrl", "", ResourceData.KEY_TOKEN, "version", "Lcom/bytedance/ee/bear/list/dto/DocVersion;", "docMetaInfo", "Lcom/bytedance/ee/bear/DocMetaInfo;", "userPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;", "publicPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;", "publicSuccess", "", "userSuccess", "isInit", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/list/dto/DocVersion;Lcom/bytedance/ee/bear/DocMetaInfo;Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;ZZZ)V", "getType", "()I", "setType", "(I)V", "getDocUrl", "()Ljava/lang/String;", "setDocUrl", "(Ljava/lang/String;)V", "getToken", "setToken", "getVersion", "()Lcom/bytedance/ee/bear/list/dto/DocVersion;", "setVersion", "(Lcom/bytedance/ee/bear/list/dto/DocVersion;)V", "getDocMetaInfo", "()Lcom/bytedance/ee/bear/DocMetaInfo;", "setDocMetaInfo", "(Lcom/bytedance/ee/bear/DocMetaInfo;)V", "getUserPermission", "()Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;", "setUserPermission", "(Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;)V", "getPublicPermission", "()Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;", "setPublicPermission", "(Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;)V", "getPublicSuccess", "()Z", "setPublicSuccess", "(Z)V", "getUserSuccess", "setUserSuccess", "setInit", "getUserPerm", "getCreateTimeStr", "getCreatorUid", "isOwner", "getDocType", "getObjToken", "getCreatorTenantId", "adminCanCross", "isSingleContainer", "getRequestToken", "enablePermSet", "externalAccess", "canExport", "canShare", "isLinkShareClose", "isLinkShareInternalRead", "isLinkShareInternalEdit", "isLinkShareAnyoneRead", "isLinkShareAnyoneEdit", "isContainerPermType", "canManagePermissionMeta", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareDocInfo implements Parcelable, f {
    public static final Parcelable.Creator<ShareDocInfo> CREATOR = null;
    public int a;
    public String b;
    public String c;
    public DocVersion d;
    public DocMetaInfo e;
    public IDocUserPermission f;
    public IDocPublicPermission g;
    public boolean h;
    public boolean i;
    public boolean j;

    public static final class a implements Parcelable.Creator<ShareDocInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShareDocInfo createFromParcel(Parcel r14) {
            Intrinsics.checkNotNullParameter(r14, "parcel");
            int r2 = r14.readInt();
            String r3 = r14.readString();
            String r4 = r14.readString();
            DocVersion r5 = (DocVersion) r14.readSerializable();
            DocMetaInfo r6 = r14.readSerializable();
            IDocUserPermission r7 = (IDocUserPermission) r14.readSerializable();
            IDocPublicPermission r8 = (IDocPublicPermission) r14.readSerializable();
            if (r14.readInt() == 0) goto L5;
            boolean r11 = true;
        L7:
            if (r14.readInt() == 0) goto L9;
            boolean r12 = true;
        L11:
            if (r14.readInt() == 0) goto L13;
            boolean r15 = true;
        L15:
            return new ShareDocInfo(r2, r3, r4, r5, r6, r7, r8, r11, r12, r15);
        L13:
            r15 = false;
            goto L15
        L9:
            r12 = false;
            goto L11
        L5:
            r11 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ShareDocInfo[] newArray(int r1) {
            return new ShareDocInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ShareDocInfo() {
        this(0, null, null, null, null, null, 1023);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ShareDocInfo) == true) goto L8;
        return false;
    L8:
        ShareDocInfo r6 = (ShareDocInfo) r5;
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
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        int r2 = 1231;
        if (this.h == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.i == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.j == true) goto L15;
        r2 = 1237;
    L15:
        return r5 + r2;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ShareDocInfo(type=" + this.a + ", docUrl=" + this.b + ", token=" + this.c + ", version=" + this.d + ", docMetaInfo=" + this.e + ", userPermission=" + this.f + ", publicPermission=" + this.g + ", publicSuccess=" + this.h + ", userSuccess=" + this.i + ", isInit=" + this.j + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeInt(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
        r1.writeSerializable(this.d);
        r1.writeSerializable(this.e);
        r1.writeSerializable(this.f);
        r1.writeSerializable(this.g);
        r1.writeInt(this.h ? 1 : 0);
        r1.writeInt(this.i ? 1 : 0);
        r1.writeInt(this.j ? 1 : 0);
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String a() {
        return this.e.getCreatorTenantId();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean adminCanCross() {
        return this.g.adminCanCross();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean canExport() {
        ((b) org.koin.java.a.c(b.class, null, null, 6)).getConfig();
        if (e.a.a.g() == false) goto L6;
        UniBaseEntity r0 = new UniBaseEntity(this.c, sbb.e.d(this.a), BizDomain.FileBizDomainCCM, a(), d(), null, null, null, null, 480, null);
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r0, "EXPORT"), new UserPermissionEntity(this.f, null)).getAllow();
    L6:
        boolean r1 = ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_EXPORT", FileBizDomain.FileBizDomainCCM, this.a, this.c).a;
        boolean r2 = this.f.canExport();
        if (r1 == false) goto L10;
        if (r2 == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean canShare() {
        return this.f.canManageCollaborator();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String d() {
        return this.e.getCreatorUid();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean externalAccess() {
        return this.g.externalAccess();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean g() {
        return this.f.canManageContainerPermissionMeta();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String h() {
        return this.e.getCreateTime();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean i() {
        return this.d.isDocV2();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isLinkShareAnyoneEdit() {
        return this.g.isLinkShareAnyoneEdit();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isLinkShareAnyoneRead() {
        return this.g.isLinkShareAnyoneRead();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isLinkShareInternalEdit() {
        return this.g.isLinkShareInternalEdit();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isLinkShareInternalRead() {
        return this.g.isLinkShareInternalRead();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isOwner() {
        return this.g.isOwner();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean e() {
        if (isOwner() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f.canManagePermissionMeta() == true) goto L8;
        return false;
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
    public final String j() {
        return this.c;
    }

    public /* synthetic */ ShareDocInfo(int r53, String r54, String r55, DocVersion r56, DocMetaInfo r57, IDocUserPermission r58, int r59) {
        if ((r59 & 1) == 0) goto L5;
        int r4 = 0;
    L7:
        if ((r59 & 2) == 0) goto L9;
        String r5 = "";
    L11:
        if ((r59 & 4) == 0) goto L13;
        String r6 = "";
    L14:
        DefaultDocPublicPermission r3 = null;
        if ((r59 & 8) == 0) goto L17;
        DocVersion r1 = new DocVersion(0, 1, null);
    L19:
        if ((r59 & 16) == 0) goto L21;
        DocMetaInfo r8 = new DocMetaInfo(null, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1, 63, null);
    L23:
        if ((r59 & 32) == 0) goto L25;
        IDocUserPermission r9 = new DefaultDocUserPermission();
    L27:
        if ((r59 & 64) == 0) goto L29;
        r3 = new DefaultDocPublicPermission();
    L29:
        DefaultDocPublicPermission r10 = r3;
        if ((r59 & 512) == 0) goto L32;
        boolean r13 = true;
    L33:
        this(r4, r5, r6, r1, r8, r9, r10, false, false, r13);
        return;
    L32:
        r13 = false;
        goto L33
    L25:
        r9 = r58;
        goto L27
    L21:
        r8 = r57;
        goto L23
    L17:
        r1 = r56;
        goto L19
    L13:
        r6 = r55;
        goto L14
    L9:
        r5 = r54;
        goto L11
    L5:
        r4 = r53;
        goto L7
    }

    public ShareDocInfo(int r2, String r3, String r4, DocVersion r5, DocMetaInfo r6, IDocUserPermission r7, IDocPublicPermission r8, boolean r9, boolean r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r3, "docUrl");
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r5, "version");
        Intrinsics.checkNotNullParameter(r6, "docMetaInfo");
        Intrinsics.checkNotNullParameter(r7, "userPermission");
        Intrinsics.checkNotNullParameter(r8, "publicPermission");
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
