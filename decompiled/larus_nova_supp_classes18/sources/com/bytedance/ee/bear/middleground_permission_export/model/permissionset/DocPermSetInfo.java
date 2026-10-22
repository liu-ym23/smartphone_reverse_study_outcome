package com.bytedance.ee.bear.middleground_permission_export.model.permissionset;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeRuleBean;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001By\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010 \u001a\u00020\u0003J\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0003J\u0006\u0010#\u001a\u00020\u0003J\u0006\u0010$\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020\u0003J\u0006\u0010&\u001a\u00020\u0003J\u0006\u0010'\u001a\u00020\u0003J\u0006\u0010(\u001a\u00020\u0003J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\u0005J\u0006\u0010,\u001a\u00020-J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010.\u001a\u00020\bJ\u0006\u0010/\u001a\u00020\u0003J\u0006\u00100\u001a\u00020\bJ\u0006\u00101\u001a\u00020\bJ\u0006\u00102\u001a\u00020\bJ\u0006\u00103\u001a\u00020\bJ\u0006\u00104\u001a\u00020\bJ\u0006\u00105\u001a\u00020\bJ\u0006\u00106\u001a\u00020\bJ\u0006\u00107\u001a\u00020\bJ\u0006\u00108\u001a\u00020\bJ\u0006\u00109\u001a\u00020\bJ\u0006\u0010:\u001a\u00020\bJ\u0006\u0010;\u001a\u00020\bJ\u0006\u0010<\u001a\u00020\bJ\u0006\u0010=\u001a\u00020\bJ\u0006\u0010>\u001a\u00020\bJ\u0006\u0010?\u001a\u00020\bJ\u0006\u0010@\u001a\u00020\bJ\u0006\u0010A\u001a\u00020\bJ\u0006\u0010B\u001a\u00020\bJ\u0006\u0010C\u001a\u00020\bJ\u0006\u0010D\u001a\u00020\bJ\u0006\u0010E\u001a\u00020\u0003J\u0006\u0010F\u001a\u00020\bJ\u0006\u0010G\u001a\u00020\bJ\u0006\u0010H\u001a\u00020\bJ\u0006\u0010I\u001a\u00020\bJ\u0006\u0010J\u001a\u00020\bJ\u0006\u0010K\u001a\u00020\bJ\u0006\u0010L\u001a\u00020\bJ\u0006\u0010M\u001a\u00020\bJ\u0006\u0010N\u001a\u00020\bJ\u0006\u0010O\u001a\u00020\bJ\u0006\u0010P\u001a\u00020\bJ\u0006\u0010Q\u001a\u00020\bJ\u0006\u0010R\u001a\u00020\bJ\u0006\u0010S\u001a\u00020\u0005J\u0006\u0010T\u001a\u00020\u0005J\u0006\u0010U\u001a\u00020\u0005J\u0006\u0010V\u001a\u00020\u0005J\u000e\u0010W\u001a\u00020X2\u0006\u0010D\u001a\u00020\bJ\u000e\u0010Y\u001a\u00020X2\u0006\u0010E\u001a\u00020\u0003J\u000e\u0010Z\u001a\u00020X2\u0006\u0010[\u001a\u00020*J\u000e\u0010\\\u001a\u00020X2\u0006\u0010]\u001a\u00020-J\u000e\u0010^\u001a\u00020X2\u0006\u0010.\u001a\u00020\bJ\u0006\u0010_\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010`\u001a\u00020\nJ\u000e\u0010a\u001a\u00020X2\u0006\u0010\t\u001a\u00020\nJ\t\u0010b\u001a\u00020\u0003HÂ\u0003J\t\u0010c\u001a\u00020\u0005HÂ\u0003J\t\u0010d\u001a\u00020\u0003HÂ\u0003J\t\u0010e\u001a\u00020\bHÂ\u0003J\t\u0010f\u001a\u00020\nHÂ\u0003J\t\u0010g\u001a\u00020\fHÂ\u0003J\t\u0010h\u001a\u00020\u000eHÂ\u0003J\t\u0010i\u001a\u00020\bHÂ\u0003J\t\u0010j\u001a\u00020\bHÆ\u0003J\t\u0010k\u001a\u00020\bHÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0013HÆ\u0003Jy\u0010m\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001J\u0006\u0010n\u001a\u00020\u0005J\u0013\u0010o\u001a\u00020\b2\b\u0010p\u001a\u0004\u0018\u00010qHÖ\u0003J\t\u0010r\u001a\u00020\u0005HÖ\u0001J\t\u0010s\u001a\u00020\u0003HÖ\u0001J\u0016\u0010t\u001a\u00020X2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0011\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006x"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/DocPermSetInfo;", "Landroid/os/Parcelable;", ResourceData.KEY_URL, "", ResourceData.KEY_TYPE, "", ResourceData.KEY_TOKEN, "isWiki", "", "docMetaInfo", "Lcom/bytedance/ee/bear/DocMetaInfo;", "docPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/DocPermission;", "version", "Lcom/bytedance/ee/bear/list/dto/DocVersion;", "passwordSharingEnable", "transferOwnerEnable", "hasFetchPublicPermission", "escapeRuleBean", "Lcom/bytedance/ee/bear/middleground/permission/escape/model/EscapeRuleBean;", "<init>", "(Ljava/lang/String;ILjava/lang/String;ZLcom/bytedance/ee/bear/DocMetaInfo;Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/DocPermission;Lcom/bytedance/ee/bear/list/dto/DocVersion;ZZZLcom/bytedance/ee/bear/middleground/permission/escape/model/EscapeRuleBean;)V", "getTransferOwnerEnable", "()Z", "setTransferOwnerEnable", "(Z)V", "getHasFetchPublicPermission", "setHasFetchPublicPermission", "getEscapeRuleBean", "()Lcom/bytedance/ee/bear/middleground/permission/escape/model/EscapeRuleBean;", "setEscapeRuleBean", "(Lcom/bytedance/ee/bear/middleground/permission/escape/model/EscapeRuleBean;)V", "getUrl", "getType", "getToken", "getTitle", "getSubType", "getOwnerId", "getCreateTime", "getCreatorUid", "getCreatorTenantId", "getPublicPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;", "getUserPerm", "getUserPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;", "isOwner", "getOwnerTenantName", "canManagePermissionMeta", "canManageContainerPermissionMeta", "canManageSinglePagePermissionMeta", "canInviteContainerFa", "canInviteContainerEdit", "canInviteContainerRead", "canInviteSinglePageFa", "canInviteSinglePageEdit", "canInviteSinglePageRead", "isCanCross", "isAdminPartnerTenantCanCross", "isExternalAccess", "isPartnerTenantExternalAccess", "isInviteExternal", "canEdit", "canManagerCollaborator", "canManagerContainerCollaborator", "canManagerSinglePageCollaborator", "getLockState", "canUnLock", "hasPassword", "password", "isShareExternalWithFA", "isManagerCollaboratorTenant", "isManagerCollaboratorAnyone", "isManagerCollaboratorWithRead", "isManagerCollaboratorWithEdit", "isManagerCollaboratorWithFA", "isCommentWithRead", "isCommentWithEdit", "isSecurityWithRead", "isSecurityWithEdit", "isSecurityWithFA", "isExternalAccessSinglePagePermType", "isLinkShareSinglePagePermType", "getLinkShareAnyoneReadBlockValue", "getLinkShareAnyoneEditBlockValue", "getLinkSharePartnerTenantReadBlockValue", "getLinkSharePartnerTenantEditBlockValue", "setHasPassword", "", "setPassword", "setDocPermission", "docPublicPermission", "setDocUserPermission", "docUserPermission", "setOwner", "isDocV2", "getDocMetaInfo", "setDocMetaInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocPermSetInfo implements Parcelable {
    public static final Parcelable.Creator<DocPermSetInfo> CREATOR = null;
    public final String a;
    public final int b;
    public final String c;
    public final boolean d;
    public final DocMetaInfo e;
    public final DocPermission f;
    public final DocVersion g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public EscapeRuleBean k;

    public static final class a implements Parcelable.Creator<DocPermSetInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DocPermSetInfo createFromParcel(Parcel r15) {
            Intrinsics.checkNotNullParameter(r15, "parcel");
            String r2 = r15.readString();
            int r3 = r15.readInt();
            String r4 = r15.readString();
            if (r15.readInt() == 0) goto L5;
            boolean r7 = true;
        L6:
            DocMetaInfo r8 = r15.readSerializable();
            DocPermission r9 = (DocPermission) r15.readParcelable(DocPermSetInfo.class.getClassLoader());
            DocVersion r10 = (DocVersion) r15.readSerializable();
            if (r15.readInt() == 0) goto L9;
            boolean r11 = true;
        L11:
            if (r15.readInt() == 0) goto L13;
            boolean r12 = true;
        L15:
            if (r15.readInt() == 0) goto L17;
            boolean r13 = true;
        L18:
            boolean r5 = r7;
            boolean r14 = r11;
            boolean r16 = r12;
            boolean r17 = r13;
            return new DocPermSetInfo(r2, r3, r4, r5, r8, r9, r10, r14, r16, r17, (EscapeRuleBean) r15.readSerializable());
        L17:
            r13 = false;
            goto L18
        L13:
            r12 = false;
            goto L15
        L9:
            r11 = false;
            goto L11
        L5:
            r7 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final DocPermSetInfo[] newArray(int r1) {
            return new DocPermSetInfo[r1];
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

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DocPermSetInfo) == true) goto L8;
        return false;
    L8:
        DocPermSetInfo r6 = (DocPermSetInfo) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
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
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((((((r0 + r1) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        if (this.h == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.i == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.j == true) goto L18;
        r2 = 1237;
    L18:
        int r8 = (r7 + r2) * 31;
        EscapeRuleBean r9 = this.k;
        if (r9 != null) goto L21;
        int r10 = 0;
    L23:
        return r8 + r10;
    L21:
        r10 = r9.hashCode();
        goto L23
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "DocPermSetInfo(url=" + this.a + ", type=" + this.b + ", token=" + this.c + ", isWiki=" + this.d + ", docMetaInfo=" + this.e + ", docPermission=" + this.f + ", version=" + this.g + ", passwordSharingEnable=" + this.h + ", transferOwnerEnable=" + this.i + ", hasFetchPublicPermission=" + this.j + ", escapeRuleBean=" + this.k + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeString(this.a);
        r2.writeInt(this.b);
        r2.writeString(this.c);
        r2.writeInt(this.d ? 1 : 0);
        r2.writeSerializable(this.e);
        r2.writeParcelable(this.f, r3);
        r2.writeSerializable(this.g);
        r2.writeInt(this.h ? 1 : 0);
        r2.writeInt(this.i ? 1 : 0);
        r2.writeInt(this.j ? 1 : 0);
        r2.writeSerializable(this.k);
    }

    public final boolean a() {
        return this.g.isDocV2();
    }

    public final boolean b() {
        return this.f.b.isOwner();
    }

    public final int getType() {
        return this.b;
    }

    public final void c(IDocPublicPermission r3) {
        Intrinsics.checkNotNullParameter(r3, "docPublicPermission");
        DocPermission r0 = this.f;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.b = r3;
    }

    public DocPermSetInfo(String r52, int r53, String r54, boolean r55, DocMetaInfo r56, DocPermission r57, DocVersion r58, boolean r59, boolean r60, boolean r61, int r62) {
        if ((r62 & 1) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r62 & 2) == 0) goto L9;
        int r5 = e.g.b;
    L11:
        if ((r62 & 4) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r62 & 8) == 0) goto L17;
        boolean r7 = false;
    L19:
        if ((r62 & 16) == 0) goto L21;
        DocMetaInfo r8 = new DocMetaInfo(null, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1, 63, null);
    L22:
        IDocUserPermission r3 = null;
        if ((r62 & 32) == 0) goto L25;
        DocPermission r9 = new DocPermission(r3, 3);
    L27:
        if ((r62 & 64) == 0) goto L29;
        DocVersion r1 = new DocVersion(0, 1, null);
    L31:
        if ((r62 & 128) == 0) goto L33;
        boolean r11 = true;
    L35:
        if ((r62 & 256) == 0) goto L37;
        boolean r12 = true;
    L39:
        if ((r62 & 512) == 0) goto L41;
        boolean r13 = true;
    L42:
        this(r4, r5, r6, r7, r8, r9, r1, r11, r12, r13, null);
        return;
    L41:
        r13 = r61;
        goto L42
    L37:
        r12 = r60;
        goto L39
    L33:
        r11 = r59;
        goto L35
    L29:
        r1 = r58;
        goto L31
    L25:
        r9 = r57;
        goto L27
    L21:
        r8 = r56;
        goto L22
    L17:
        r7 = r55;
        goto L19
    L13:
        r6 = r54;
        goto L15
    L9:
        r5 = r53;
        goto L11
    L5:
        r4 = r52;
        goto L7
    }

    public DocPermSetInfo(String r2, int r3, String r4, boolean r5, DocMetaInfo r6, DocPermission r7, DocVersion r8, boolean r9, boolean r10, boolean r11, EscapeRuleBean r12) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_URL);
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r6, "docMetaInfo");
        Intrinsics.checkNotNullParameter(r7, "docPermission");
        Intrinsics.checkNotNullParameter(r8, "version");
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
    }
}
