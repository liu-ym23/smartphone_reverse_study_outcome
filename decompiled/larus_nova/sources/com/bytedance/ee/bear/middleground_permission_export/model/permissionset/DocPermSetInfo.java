package com.bytedance.ee.bear.middleground_permission_export.model.permissionset;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeRuleBean;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001By\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010 \u001a\u00020\u0003J\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0003J\u0006\u0010#\u001a\u00020\u0003J\u0006\u0010$\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020\u0003J\u0006\u0010&\u001a\u00020\u0003J\u0006\u0010'\u001a\u00020\u0003J\u0006\u0010(\u001a\u00020\u0003J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\u0005J\u0006\u0010,\u001a\u00020-J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010.\u001a\u00020\bJ\u0006\u0010/\u001a\u00020\u0003J\u0006\u00100\u001a\u00020\bJ\u0006\u00101\u001a\u00020\bJ\u0006\u00102\u001a\u00020\bJ\u0006\u00103\u001a\u00020\bJ\u0006\u00104\u001a\u00020\bJ\u0006\u00105\u001a\u00020\bJ\u0006\u00106\u001a\u00020\bJ\u0006\u00107\u001a\u00020\bJ\u0006\u00108\u001a\u00020\bJ\u0006\u00109\u001a\u00020\bJ\u0006\u0010:\u001a\u00020\bJ\u0006\u0010;\u001a\u00020\bJ\u0006\u0010<\u001a\u00020\bJ\u0006\u0010=\u001a\u00020\bJ\u0006\u0010>\u001a\u00020\bJ\u0006\u0010?\u001a\u00020\bJ\u0006\u0010@\u001a\u00020\bJ\u0006\u0010A\u001a\u00020\bJ\u0006\u0010B\u001a\u00020\bJ\u0006\u0010C\u001a\u00020\bJ\u0006\u0010D\u001a\u00020\bJ\u0006\u0010E\u001a\u00020\u0003J\u0006\u0010F\u001a\u00020\bJ\u0006\u0010G\u001a\u00020\bJ\u0006\u0010H\u001a\u00020\bJ\u0006\u0010I\u001a\u00020\bJ\u0006\u0010J\u001a\u00020\bJ\u0006\u0010K\u001a\u00020\bJ\u0006\u0010L\u001a\u00020\bJ\u0006\u0010M\u001a\u00020\bJ\u0006\u0010N\u001a\u00020\bJ\u0006\u0010O\u001a\u00020\bJ\u0006\u0010P\u001a\u00020\bJ\u0006\u0010Q\u001a\u00020\bJ\u0006\u0010R\u001a\u00020\bJ\u0006\u0010S\u001a\u00020\u0005J\u0006\u0010T\u001a\u00020\u0005J\u0006\u0010U\u001a\u00020\u0005J\u0006\u0010V\u001a\u00020\u0005J\u000e\u0010W\u001a\u00020X2\u0006\u0010D\u001a\u00020\bJ\u000e\u0010Y\u001a\u00020X2\u0006\u0010E\u001a\u00020\u0003J\u000e\u0010Z\u001a\u00020X2\u0006\u0010[\u001a\u00020*J\u000e\u0010\\\u001a\u00020X2\u0006\u0010]\u001a\u00020-J\u000e\u0010^\u001a\u00020X2\u0006\u0010.\u001a\u00020\bJ\u0006\u0010_\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010`\u001a\u00020\nJ\u000e\u0010a\u001a\u00020X2\u0006\u0010\t\u001a\u00020\nJ\t\u0010b\u001a\u00020\u0003HÂ\u0003J\t\u0010c\u001a\u00020\u0005HÂ\u0003J\t\u0010d\u001a\u00020\u0003HÂ\u0003J\t\u0010e\u001a\u00020\bHÂ\u0003J\t\u0010f\u001a\u00020\nHÂ\u0003J\t\u0010g\u001a\u00020\fHÂ\u0003J\t\u0010h\u001a\u00020\u000eHÂ\u0003J\t\u0010i\u001a\u00020\bHÂ\u0003J\t\u0010j\u001a\u00020\bHÆ\u0003J\t\u0010k\u001a\u00020\bHÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0013HÆ\u0003Jy\u0010m\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001J\u0006\u0010n\u001a\u00020\u0005J\u0013\u0010o\u001a\u00020\b2\b\u0010p\u001a\u0004\u0018\u00010qHÖ\u0003J\t\u0010r\u001a\u00020\u0005HÖ\u0001J\t\u0010s\u001a\u00020\u0003HÖ\u0001J\u0016\u0010t\u001a\u00020X2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0011\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006x"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/DocPermSetInfo;", "Landroid/os/Parcelable;", "url", "", "type", "", "token", "isWiki", "", "docMetaInfo", "Lcom/bytedance/ee/bear/DocMetaInfo;", "docPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/DocPermission;", "version", "Lcom/bytedance/ee/bear/list/dto/DocVersion;", "passwordSharingEnable", "transferOwnerEnable", "hasFetchPublicPermission", "escapeRuleBean", "Lcom/bytedance/ee/bear/middleground/permission/escape/model/EscapeRuleBean;", "<init>", "(Ljava/lang/String;ILjava/lang/String;ZLcom/bytedance/ee/bear/DocMetaInfo;Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/DocPermission;Lcom/bytedance/ee/bear/list/dto/DocVersion;ZZZLcom/bytedance/ee/bear/middleground/permission/escape/model/EscapeRuleBean;)V", "getTransferOwnerEnable", "()Z", "setTransferOwnerEnable", "(Z)V", "getHasFetchPublicPermission", "setHasFetchPublicPermission", "getEscapeRuleBean", "()Lcom/bytedance/ee/bear/middleground/permission/escape/model/EscapeRuleBean;", "setEscapeRuleBean", "(Lcom/bytedance/ee/bear/middleground/permission/escape/model/EscapeRuleBean;)V", "getUrl", "getType", "getToken", "getTitle", "getSubType", "getOwnerId", "getCreateTime", "getCreatorUid", "getCreatorTenantId", "getPublicPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;", "getUserPerm", "getUserPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;", "isOwner", "getOwnerTenantName", "canManagePermissionMeta", "canManageContainerPermissionMeta", "canManageSinglePagePermissionMeta", "canInviteContainerFa", "canInviteContainerEdit", "canInviteContainerRead", "canInviteSinglePageFa", "canInviteSinglePageEdit", "canInviteSinglePageRead", "isCanCross", "isAdminPartnerTenantCanCross", "isExternalAccess", "isPartnerTenantExternalAccess", "isInviteExternal", "canEdit", "canManagerCollaborator", "canManagerContainerCollaborator", "canManagerSinglePageCollaborator", "getLockState", "canUnLock", "hasPassword", "password", "isShareExternalWithFA", "isManagerCollaboratorTenant", "isManagerCollaboratorAnyone", "isManagerCollaboratorWithRead", "isManagerCollaboratorWithEdit", "isManagerCollaboratorWithFA", "isCommentWithRead", "isCommentWithEdit", "isSecurityWithRead", "isSecurityWithEdit", "isSecurityWithFA", "isExternalAccessSinglePagePermType", "isLinkShareSinglePagePermType", "getLinkShareAnyoneReadBlockValue", "getLinkShareAnyoneEditBlockValue", "getLinkSharePartnerTenantReadBlockValue", "getLinkSharePartnerTenantEditBlockValue", "setHasPassword", "", "setPassword", "setDocPermission", "docPublicPermission", "setDocUserPermission", "docUserPermission", "setOwner", "isDocV2", "getDocMetaInfo", "setDocMetaInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocPermSetInfo implements Parcelable {
    public static final Parcelable.Creator<DocPermSetInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f234427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f234428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f234429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f234430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DocMetaInfo f234431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DocPermission f234432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DocVersion f234433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f234434h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f234435i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f234436j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public EscapeRuleBean f234437k;

    public static final class a implements Parcelable.Creator<DocPermSetInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DocPermSetInfo createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            int r101 = r110.readInt();
            String r102 = r110.readString();
            if (r110.readInt() == 0) goto L5;
            boolean r103 = true;
        L6:
            DocMetaInfo r104 = (DocMetaInfo) r110.readSerializable();
            DocPermission r105 = (DocPermission) r110.readParcelable(DocPermSetInfo.class.getClassLoader());
            DocVersion r111 = (DocVersion) r110.readSerializable();
            if (r110.readInt() == 0) goto L9;
            boolean r112 = true;
        L11:
            if (r110.readInt() == 0) goto L13;
            boolean r113 = true;
        L15:
            if (r110.readInt() == 0) goto L17;
            boolean r114 = true;
        L18:
            boolean r106 = r103;
            boolean r107 = r112;
            boolean r115 = r113;
            boolean r116 = r114;
            return new DocPermSetInfo(r100, r101, r102, r106, r104, r105, r111, r107, r115, r116, (EscapeRuleBean) r110.readSerializable());
        L17:
            r114 = false;
            goto L18
        L13:
            r113 = false;
            goto L15
        L9:
            r112 = false;
            goto L11
        L5:
            r103 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final DocPermSetInfo[] newArray(int r100) {
            return new DocPermSetInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public DocPermSetInfo() {
        this(null, 0, null, false, null, null, null, false, false, false, 2047);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocPermSetInfo) == true) goto L8;
        return false;
    L8:
        DocPermSetInfo r101 = (DocPermSetInfo) r100;
        if (Intrinsics.areEqual(this.f234427a, r101.f234427a) == true) goto L12;
        return false;
    L12:
        if (this.f234428b == r101.f234428b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f234429c, r101.f234429c) == true) goto L18;
        return false;
    L18:
        if (this.f234430d == r101.f234430d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f234431e, r101.f234431e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f234432f, r101.f234432f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f234433g, r101.f234433g) == true) goto L30;
        return false;
    L30:
        if (this.f234434h == r101.f234434h) goto L33;
        return false;
    L33:
        if (this.f234435i == r101.f234435i) goto L36;
        return false;
    L36:
        if (this.f234436j == r101.f234436j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f234437k, r101.f234437k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f234427a.hashCode() * 31) + this.f234428b) * 31) + this.f234429c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f234430d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((((r100 + r102) * 31) + this.f234431e.hashCode()) * 31) + this.f234432f.hashCode()) * 31) + this.f234433g.hashCode()) * 31;
        if (this.f234434h == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f234435i == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f234436j == true) goto L18;
        r101 = 1237;
    L18:
        int r108 = (r107 + r101) * 31;
        EscapeRuleBean r109 = this.f234437k;
        if (r109 != null) goto L21;
        int r110 = 0;
    L23:
        return r108 + r110;
    L21:
        r110 = r109.hashCode();
        goto L23
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "DocPermSetInfo(url=" + this.f234427a + ", type=" + this.f234428b + ", token=" + this.f234429c + ", isWiki=" + this.f234430d + ", docMetaInfo=" + this.f234431e + ", docPermission=" + this.f234432f + ", version=" + this.f234433g + ", passwordSharingEnable=" + this.f234434h + ", transferOwnerEnable=" + this.f234435i + ", hasFetchPublicPermission=" + this.f234436j + ", escapeRuleBean=" + this.f234437k + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f234427a);
        r100.writeInt(this.f234428b);
        r100.writeString(this.f234429c);
        r100.writeInt(this.f234430d ? 1 : 0);
        r100.writeSerializable(this.f234431e);
        r100.writeParcelable(this.f234432f, r101);
        r100.writeSerializable(this.f234433g);
        r100.writeInt(this.f234434h ? 1 : 0);
        r100.writeInt(this.f234435i ? 1 : 0);
        r100.writeInt(this.f234436j ? 1 : 0);
        r100.writeSerializable(this.f234437k);
    }

    public final boolean a() {
        return this.f234433g.isDocV2();
    }

    public final boolean b() {
        return this.f234432f.f234420b.isOwner();
    }

    public final int getType() {
        return this.f234428b;
    }

    public final void c(IDocPublicPermission r100) {
        Intrinsics.checkNotNullParameter(r100, "docPublicPermission");
        DocPermission r101 = this.f234432f;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f234420b = r100;
    }

    public DocPermSetInfo(String r510, int r511, String r512, boolean r513, DocMetaInfo r514, DocPermission r515, DocVersion r516, boolean r517, boolean r610, boolean r611, int r612) {
        if ((r612 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r612 & 2) == 0) goto L9;
        int r101 = e.f541296g.f541317b;
    L11:
        if ((r612 & 4) == 0) goto L13;
        String r102 = "";
    L14:
        int r103 = 0;
        if ((r612 & 8) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r612 & 16) == 0) goto L21;
        DocMetaInfo r105 = new DocMetaInfo(null, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1, 63, null);
    L22:
        DefaultConstructorMarker r106 = null;
        if ((r612 & 32) == 0) goto L25;
        DocPermission r107 = new DocPermission(null, 3);
    L26:
        int r110 = 1;
        if ((r612 & 64) == 0) goto L29;
        DocVersion r108 = new DocVersion(r103, r110, r106);
    L31:
        if ((r612 & 128) == 0) goto L33;
        boolean r111 = true;
    L35:
        if ((r612 & 256) == 0) goto L37;
        boolean r112 = true;
    L39:
        if ((r612 & 512) == 0) goto L41;
        boolean r113 = true;
    L42:
        this(r100, r101, r102, r104, r105, r107, r108, r111, r112, r113, null);
        return;
    L41:
        r113 = r611;
        goto L42
    L37:
        r112 = r610;
        goto L39
    L33:
        r111 = r517;
        goto L35
    L29:
        r108 = r516;
        goto L31
    L25:
        r107 = r515;
        goto L26
    L21:
        r105 = r514;
        goto L22
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

    public DocPermSetInfo(String r100, int r101, String r102, boolean r103, DocMetaInfo r104, DocPermission r105, DocVersion r106, boolean r107, boolean r110, boolean r111, EscapeRuleBean r112) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r102, "token");
        Intrinsics.checkNotNullParameter(r104, "docMetaInfo");
        Intrinsics.checkNotNullParameter(r105, "docPermission");
        Intrinsics.checkNotNullParameter(r106, "version");
        this.f234427a = r100;
        this.f234428b = r101;
        this.f234429c = r102;
        this.f234430d = r103;
        this.f234431e = r104;
        this.f234432f = r105;
        this.f234433g = r106;
        this.f234434h = r107;
        this.f234435i = r110;
        this.f234436j = r111;
        this.f234437k = r112;
    }
}
