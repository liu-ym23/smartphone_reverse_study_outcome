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
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import jg5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\bH\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Bk\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\b\u00107\u001a\u00020\u0004H\u0016J\b\u00108\u001a\u00020\u0006H\u0016J\b\u00109\u001a\u00020\u0006H\u0016J\b\u0010:\u001a\u00020\u0011H\u0016J\b\u0010;\u001a\u00020\u0004H\u0016J\b\u0010<\u001a\u00020\u0006H\u0016J\b\u0010=\u001a\u00020\u0006H\u0016J\b\u0010>\u001a\u00020\u0011H\u0016J\b\u0010?\u001a\u00020\u0011H\u0016J\b\u0010@\u001a\u00020\u0006H\u0016J\b\u0010A\u001a\u00020\u0011H\u0016J\b\u0010B\u001a\u00020\u0011H\u0016J\b\u0010C\u001a\u00020\u0011H\u0016J\b\u0010D\u001a\u00020\u0011H\u0016J\b\u0010E\u001a\u00020\u0011H\u0016J\b\u0010F\u001a\u00020\u0011H\u0016J\b\u0010G\u001a\u00020\u0011H\u0016J\b\u0010H\u001a\u00020\u0011H\u0016J\b\u0010I\u001a\u00020\u0011H\u0016J\b\u0010J\u001a\u00020\u0011H\u0016J\b\u0010K\u001a\u00020\u0011H\u0016J\t\u0010L\u001a\u00020\u0004HÆ\u0003J\t\u0010M\u001a\u00020\u0006HÆ\u0003J\t\u0010N\u001a\u00020\u0006HÆ\u0003J\t\u0010O\u001a\u00020\tHÆ\u0003J\t\u0010P\u001a\u00020\u000bHÆ\u0003J\t\u0010Q\u001a\u00020\rHÆ\u0003J\t\u0010R\u001a\u00020\u000fHÆ\u0003J\t\u0010S\u001a\u00020\u0011HÆ\u0003J\t\u0010T\u001a\u00020\u0011HÆ\u0003J\t\u0010U\u001a\u00020\u0011HÆ\u0003Jm\u0010V\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0011HÆ\u0001J\u0006\u0010W\u001a\u00020\u0004J\u0013\u0010X\u001a\u00020\u00112\b\u0010Y\u001a\u0004\u0018\u00010ZHÖ\u0003J\t\u0010[\u001a\u00020\u0004HÖ\u0001J\t\u0010\\\u001a\u00020\u0006HÖ\u0001J\u0016\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\u0012\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00101\"\u0004\b5\u00103R\u001a\u0010\u0013\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u00101\"\u0004\b6\u00103¨\u0006b"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/share/info/ShareDocInfo;", "Landroid/os/Parcelable;", "Lcom/bytedance/ee/bear/share/export/IShareInfo;", "type", "", "docUrl", "", "token", "version", "Lcom/bytedance/ee/bear/list/dto/DocVersion;", "docMetaInfo", "Lcom/bytedance/ee/bear/DocMetaInfo;", "userPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;", "publicPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;", "publicSuccess", "", "userSuccess", "isInit", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/list/dto/DocVersion;Lcom/bytedance/ee/bear/DocMetaInfo;Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;ZZZ)V", "getType", "()I", "setType", "(I)V", "getDocUrl", "()Ljava/lang/String;", "setDocUrl", "(Ljava/lang/String;)V", "getToken", "setToken", "getVersion", "()Lcom/bytedance/ee/bear/list/dto/DocVersion;", "setVersion", "(Lcom/bytedance/ee/bear/list/dto/DocVersion;)V", "getDocMetaInfo", "()Lcom/bytedance/ee/bear/DocMetaInfo;", "setDocMetaInfo", "(Lcom/bytedance/ee/bear/DocMetaInfo;)V", "getUserPermission", "()Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;", "setUserPermission", "(Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;)V", "getPublicPermission", "()Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;", "setPublicPermission", "(Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;)V", "getPublicSuccess", "()Z", "setPublicSuccess", "(Z)V", "getUserSuccess", "setUserSuccess", "setInit", "getUserPerm", "getCreateTimeStr", "getCreatorUid", "isOwner", "getDocType", "getObjToken", "getCreatorTenantId", "adminCanCross", "isSingleContainer", "getRequestToken", "enablePermSet", "externalAccess", "canExport", "canShare", "isLinkShareClose", "isLinkShareInternalRead", "isLinkShareInternalEdit", "isLinkShareAnyoneRead", "isLinkShareAnyoneEdit", "isContainerPermType", "canManagePermissionMeta", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareDocInfo implements Parcelable, f {
    public static final Parcelable.Creator<ShareDocInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f234242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f234243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f234244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DocVersion f234245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DocMetaInfo f234246e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IDocUserPermission f234247f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IDocPublicPermission f234248g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f234249h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f234250i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f234251j;

    public static final class a implements Parcelable.Creator<ShareDocInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShareDocInfo createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            int r100 = r110.readInt();
            String r101 = r110.readString();
            String r102 = r110.readString();
            DocVersion r103 = (DocVersion) r110.readSerializable();
            DocMetaInfo r104 = (DocMetaInfo) r110.readSerializable();
            IDocUserPermission r105 = (IDocUserPermission) r110.readSerializable();
            IDocPublicPermission r106 = (IDocPublicPermission) r110.readSerializable();
            if (r110.readInt() == 0) goto L5;
            boolean r111 = true;
        L7:
            if (r110.readInt() == 0) goto L9;
            boolean r112 = true;
        L11:
            if (r110.readInt() == 0) goto L13;
            boolean r113 = true;
        L15:
            return new ShareDocInfo(r100, r101, r102, r103, r104, r105, r106, r111, r112, r113);
        L13:
            r113 = false;
            goto L15
        L9:
            r112 = false;
            goto L11
        L5:
            r111 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ShareDocInfo[] newArray(int r100) {
            return new ShareDocInfo[r100];
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

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShareDocInfo) == true) goto L8;
        return false;
    L8:
        ShareDocInfo r101 = (ShareDocInfo) r100;
        if (this.f234242a == r101.f234242a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f234243b, r101.f234243b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f234244c, r101.f234244c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f234245d, r101.f234245d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f234246e, r101.f234246e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f234247f, r101.f234247f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f234248g, r101.f234248g) == true) goto L30;
        return false;
    L30:
        if (this.f234249h == r101.f234249h) goto L33;
        return false;
    L33:
        if (this.f234250i == r101.f234250i) goto L36;
        return false;
    L36:
        if (this.f234251j == r101.f234251j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((this.f234242a * 31) + this.f234243b.hashCode()) * 31) + this.f234244c.hashCode()) * 31) + this.f234245d.hashCode()) * 31) + this.f234246e.hashCode()) * 31) + this.f234247f.hashCode()) * 31) + this.f234248g.hashCode()) * 31;
        int r101 = 1231;
        if (this.f234249h == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f234250i == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f234251j == true) goto L15;
        r101 = 1237;
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ShareDocInfo(type=" + this.f234242a + ", docUrl=" + this.f234243b + ", token=" + this.f234244c + ", version=" + this.f234245d + ", docMetaInfo=" + this.f234246e + ", userPermission=" + this.f234247f + ", publicPermission=" + this.f234248g + ", publicSuccess=" + this.f234249h + ", userSuccess=" + this.f234250i + ", isInit=" + this.f234251j + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.f234242a);
        r100.writeString(this.f234243b);
        r100.writeString(this.f234244c);
        r100.writeSerializable(this.f234245d);
        r100.writeSerializable(this.f234246e);
        r100.writeSerializable(this.f234247f);
        r100.writeSerializable(this.f234248g);
        r100.writeInt(this.f234249h ? 1 : 0);
        r100.writeInt(this.f234250i ? 1 : 0);
        r100.writeInt(this.f234251j ? 1 : 0);
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String a() {
        return this.f234246e.getCreatorTenantId();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean adminCanCross() {
        return this.f234248g.adminCanCross();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean canExport() {
        ((b) org.koin.java.a.c(b.class, null, null, 6)).getConfig();
        if (e.a.f499003a.g() == false) goto L6;
        UniBaseEntity r100 = new UniBaseEntity(this.f234244c, sbb.e.d(this.f234242a), BizDomain.FileBizDomainCCM, a(), d(), null, null, null, null, 480, null);
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r100, "EXPORT"), new UserPermissionEntity(this.f234247f, null)).getAllow();
    L6:
        boolean r101 = ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_EXPORT", FileBizDomain.FileBizDomainCCM, this.f234242a, this.f234244c).f481503a;
        boolean r102 = this.f234247f.canExport();
        if (r101 == false) goto L10;
        if (r102 == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean canShare() {
        return this.f234247f.canManageCollaborator();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String d() {
        return this.f234246e.getCreatorUid();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean externalAccess() {
        return this.f234248g.externalAccess();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean g() {
        return this.f234247f.canManageContainerPermissionMeta();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String h() {
        return this.f234246e.getCreateTime();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean i() {
        return this.f234245d.isDocV2();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isLinkShareAnyoneEdit() {
        return this.f234248g.isLinkShareAnyoneEdit();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isLinkShareAnyoneRead() {
        return this.f234248g.isLinkShareAnyoneRead();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isLinkShareInternalEdit() {
        return this.f234248g.isLinkShareInternalEdit();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isLinkShareInternalRead() {
        return this.f234248g.isLinkShareInternalRead();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean isOwner() {
        return this.f234248g.isOwner();
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final boolean e() {
        if (isOwner() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f234247f.canManagePermissionMeta() == true) goto L8;
        return false;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final int getDocType() {
        return this.f234242a;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String getObjToken() {
        return this.f234244c;
    }

    public final int getType() {
        return this.f234242a;
    }

    @Override // com.bytedance.ee.bear.share.export.f
    public final String j() {
        return this.f234244c;
    }

    public /* synthetic */ ShareDocInfo(int r510, String r511, String r512, DocVersion r513, DocMetaInfo r514, IDocUserPermission r515, int r516) {
        if ((r516 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r516 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r516 & 4) == 0) goto L13;
        String r102 = "";
    L14:
        DefaultDocPublicPermission r103 = null;
        if ((r516 & 8) == 0) goto L17;
        DocVersion r104 = new DocVersion(0, 1, null);
    L19:
        if ((r516 & 16) == 0) goto L21;
        DocMetaInfo r105 = new DocMetaInfo(null, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1, 63, null);
    L23:
        if ((r516 & 32) == 0) goto L25;
        IDocUserPermission r106 = new DefaultDocUserPermission();
    L27:
        if ((r516 & 64) == 0) goto L29;
        r103 = new DefaultDocPublicPermission();
    L29:
        DefaultDocPublicPermission r110 = r103;
        if ((r516 & 512) == 0) goto L32;
        boolean r111 = true;
    L33:
        this(r100, r101, r102, r104, r105, r106, r110, false, false, r111);
        return;
    L32:
        r111 = false;
        goto L33
    L25:
        r106 = r515;
        goto L27
    L21:
        r105 = r514;
        goto L23
    L17:
        r104 = r513;
        goto L19
    L13:
        r102 = r512;
        goto L14
    L9:
        r101 = r511;
        goto L11
    L5:
        r100 = r510;
        goto L7
    }

    public ShareDocInfo(int r100, String r101, String r102, DocVersion r103, DocMetaInfo r104, IDocUserPermission r105, IDocPublicPermission r106, boolean r107, boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r101, "docUrl");
        Intrinsics.checkNotNullParameter(r102, "token");
        Intrinsics.checkNotNullParameter(r103, "version");
        Intrinsics.checkNotNullParameter(r104, "docMetaInfo");
        Intrinsics.checkNotNullParameter(r105, "userPermission");
        Intrinsics.checkNotNullParameter(r106, "publicPermission");
        this.f234242a = r100;
        this.f234243b = r101;
        this.f234244c = r102;
        this.f234245d = r103;
        this.f234246e = r104;
        this.f234247f = r105;
        this.f234248g = r106;
        this.f234249h = r107;
        this.f234250i = r110;
        this.f234251j = r111;
    }
}
