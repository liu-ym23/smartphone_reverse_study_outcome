package com.bytedance.ee.bear.secret;

import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\bI\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\bJ\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010\u001d\u001a\u00020\bJ\u0006\u0010\u001e\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\bJ\u0006\u0010 \u001a\u00020\bJ\u0006\u0010!\u001a\u00020\bJ\u0006\u0010\"\u001a\u00020\bJ\u0006\u0010#\u001a\u00020\bJ\u0006\u0010$\u001a\u00020\bJ\u0006\u0010%\u001a\u00020\bJ\u0006\u0010&\u001a\u00020\bJ\u0006\u0010'\u001a\u00020\bJ\u0006\u0010(\u001a\u00020\bJ\u0006\u0010)\u001a\u00020\bJ\u0006\u0010*\u001a\u00020\bJ\u0006\u0010+\u001a\u00020\bJ\u0006\u0010,\u001a\u00020\bJ\u0006\u0010-\u001a\u00020\bJ\u0006\u0010.\u001a\u00020\bJ\u0006\u0010/\u001a\u00020\bJ\u0006\u00100\u001a\u00020\bJ\u0006\u00101\u001a\u00020\bJ\u0006\u00102\u001a\u00020\bJ\u0006\u00103\u001a\u00020\bJ\u0006\u00104\u001a\u00020\bJ\u0006\u00105\u001a\u00020\bJ\u0006\u00106\u001a\u00020\bJ\u0006\u00107\u001a\u00020\bJ\u0006\u00108\u001a\u00020\bJ\u0006\u00109\u001a\u00020\bJ\u0006\u0010:\u001a\u00020\bJ\u0006\u0010;\u001a\u00020\bJ\u0006\u0010<\u001a\u00020\bJ\u0006\u0010=\u001a\u00020\bJ\u0006\u0010>\u001a\u00020\bJ\u0006\u0010?\u001a\u00020\bJ\u0006\u0010@\u001a\u00020\bJ\u0010\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\u0003H\u0002J\t\u0010C\u001a\u00020\u0003HÂ\u0003J\t\u0010D\u001a\u00020\u0003HÂ\u0003J\t\u0010E\u001a\u00020\u0003HÂ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\bHÆ\u0003J\t\u0010H\u001a\u00020\u0003HÂ\u0003J\t\u0010I\u001a\u00020\u0003HÂ\u0003J\t\u0010J\u001a\u00020\bHÆ\u0003J\t\u0010K\u001a\u00020\u0003HÂ\u0003J\t\u0010L\u001a\u00020\u0003HÂ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\u0081\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010P\u001a\u00020\b2\b\u0010Q\u001a\u0004\u0018\u00010RHÖ\u0003J\t\u0010S\u001a\u00020\u0003HÖ\u0001J\t\u0010T\u001a\u00020UHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013¨\u0006V"}, d2 = {"Lcom/bytedance/ee/bear/secret/PermissionControl;", "Ljava/io/Serializable;", "shareEntity", "", "securityEntity", "commentEntity", "linkShareEntity", "externalAccessSwitch", "", "shareExternalEntity", "managerCollaboratorEntity", "linkPasswordSwitch", "copyEntity", "externalAccessEntity", "searchEntity", "disableAISearchEntity", "<init>", "(IIIIZIIZIIII)V", "getLinkShareEntity", "()I", "getExternalAccessSwitch", "()Z", "getLinkPasswordSwitch", "getSearchEntity", "getDisableAISearchEntity", "onlyShareInternal", "onlyShareInternalV2", "allowShareExternal", "isCanShareExternal", "shareExternalNoLimit", "shareExternalOnlyRelated", "denyShareExternal", "onlyFaCanShareExternal", "onlyFaCanShareExternalV2", "onlyCanShareInternal", "onlyCanShowInternalV2", "onlyReadCanCopy", "onlyEditorOrFaCanCopy", "onlyFaCanCopy", "onlyCanCopyAndDownload", "onlyEditorOrFaCanCopyAndDownload", "onlyFaCanCopyAndDownload", "onlyCanAddCollaborator", "onlyInternalCanAddCollaborator", "onlyCanEditorCanAddCollaborator", "onlyInterCanEditorCanAddCollaborator", "onlyFaCanAddOrManagerCollaborator", "onlyInternalCanAddOrManagerCollaborator", "onlyEditorOrFaCanAddCollaborator", "onlyFaCanAddCollaborator", "isShareInternal", "onlyInternalCollaboratorCanAddCollaborator", "onlyInternalEditorOrFaCanAddCollaborator", "onlyInternalFaCanAddCollaborator", "allowLinkShare", "closeLinkShare", "canReadInternalLinkShare", "canEditorInternalLinkShare", "canReadLinkShare", "canEditorLinkShare", "canOrgReadLinkShare", "canOrgEditLinkShare", "onlyCanEditorCanComment", "onlyCanReadCanComment", "canSaveAsTemplate", "isDefault", "value", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "", "hashCode", "toString", "", "docs-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermissionControl implements Serializable {
    private final int commentEntity;
    private final int copyEntity;
    private final int disableAISearchEntity;
    private final int externalAccessEntity;
    private final boolean externalAccessSwitch;
    private final boolean linkPasswordSwitch;
    private final int linkShareEntity;
    private final int managerCollaboratorEntity;
    private final int searchEntity;
    private final int securityEntity;
    private final int shareEntity;
    private final int shareExternalEntity;

    public PermissionControl() {
        this(0, 0, 0, 0, false, 0, 0, false, 0, 0, 0, 0, UnixStat.PERM_MASK, null);
    }

    public static /* synthetic */ PermissionControl copy$default(PermissionControl r110, int r111, int r112, int r113, int r114, boolean r115, int r116, int r210, boolean r211, int r212, int r213, int r214, int r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        int r100 = r110.shareEntity;
    L7:
        if ((r216 & 2) == 0) goto L9;
        int r101 = r110.securityEntity;
    L11:
        if ((r216 & 4) == 0) goto L13;
        int r102 = r110.commentEntity;
    L15:
        if ((r216 & 8) == 0) goto L17;
        int r103 = r110.linkShareEntity;
    L19:
        if ((r216 & 16) == 0) goto L21;
        boolean r104 = r110.externalAccessSwitch;
    L23:
        if ((r216 & 32) == 0) goto L25;
        int r105 = r110.shareExternalEntity;
    L27:
        if ((r216 & 64) == 0) goto L29;
        int r106 = r110.managerCollaboratorEntity;
    L31:
        if ((r216 & 128) == 0) goto L33;
        boolean r107 = r110.linkPasswordSwitch;
    L35:
        if ((r216 & 256) == 0) goto L37;
        int r117 = r110.copyEntity;
    L39:
        if ((r216 & 512) == 0) goto L41;
        int r118 = r110.externalAccessEntity;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        int r119 = r110.searchEntity;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        int r108 = r110.disableAISearchEntity;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component11() {
        return this.searchEntity;
    }

    public final int component12() {
        return this.disableAISearchEntity;
    }

    public final int component4() {
        return this.linkShareEntity;
    }

    public final boolean component5() {
        return this.externalAccessSwitch;
    }

    public final boolean component8() {
        return this.linkPasswordSwitch;
    }

    public final PermissionControl copy(int r110, int r111, int r112, int r113, boolean r114, int r210, int r211, boolean r212, int r213, int r214, int r215, int r216) {
        return new PermissionControl(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PermissionControl) == true) goto L8;
        return false;
    L8:
        PermissionControl r101 = (PermissionControl) r100;
        if (this.shareEntity == r101.shareEntity) goto L12;
        return false;
    L12:
        if (this.securityEntity == r101.securityEntity) goto L15;
        return false;
    L15:
        if (this.commentEntity == r101.commentEntity) goto L18;
        return false;
    L18:
        if (this.linkShareEntity == r101.linkShareEntity) goto L21;
        return false;
    L21:
        if (this.externalAccessSwitch == r101.externalAccessSwitch) goto L24;
        return false;
    L24:
        if (this.shareExternalEntity == r101.shareExternalEntity) goto L27;
        return false;
    L27:
        if (this.managerCollaboratorEntity == r101.managerCollaboratorEntity) goto L30;
        return false;
    L30:
        if (this.linkPasswordSwitch == r101.linkPasswordSwitch) goto L33;
        return false;
    L33:
        if (this.copyEntity == r101.copyEntity) goto L36;
        return false;
    L36:
        if (this.externalAccessEntity == r101.externalAccessEntity) goto L39;
        return false;
    L39:
        if (this.searchEntity == r101.searchEntity) goto L42;
        return false;
    L42:
        if (this.disableAISearchEntity == r101.disableAISearchEntity) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((this.shareEntity * 31) + this.securityEntity) * 31) + this.commentEntity) * 31) + this.linkShareEntity) * 31;
        int r101 = 1231;
        if (this.externalAccessSwitch == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.shareExternalEntity) * 31) + this.managerCollaboratorEntity) * 31;
        if (this.linkPasswordSwitch == true) goto L11;
        r101 = 1237;
    L11:
        return ((((((((r103 + r101) * 31) + this.copyEntity) * 31) + this.externalAccessEntity) * 31) + this.searchEntity) * 31) + this.disableAISearchEntity;
    L5:
        r102 = 1237;
        goto L6
    }

    public final boolean isCanShareExternal() {
        return ArraysKt.contains(new Integer[]{3, 1}, Integer.valueOf(this.externalAccessEntity));
    }

    public String toString() {
        return "PermissionControl(shareEntity=" + this.shareEntity + ", securityEntity=" + this.securityEntity + ", commentEntity=" + this.commentEntity + ", linkShareEntity=" + this.linkShareEntity + ", externalAccessSwitch=" + this.externalAccessSwitch + ", shareExternalEntity=" + this.shareExternalEntity + ", managerCollaboratorEntity=" + this.managerCollaboratorEntity + ", linkPasswordSwitch=" + this.linkPasswordSwitch + ", copyEntity=" + this.copyEntity + ", externalAccessEntity=" + this.externalAccessEntity + ", searchEntity=" + this.searchEntity + ", disableAISearchEntity=" + this.disableAISearchEntity + ')';
    }

    public final boolean allowLinkShare() {
        int r100 = this.linkShareEntity;
        if (r100 != 2) goto L5;
        return true;
    L5:
        if (r100 != 3) goto L7;
        return true;
    L7:
        if (r100 != 4) goto L9;
        return true;
    L9:
        if (r100 != 5) goto L11;
        return true;
    L11:
        if (r100 != 6) goto L13;
        return true;
    L13:
        if (r100 == 7) goto L24;
        if (r100 == 0) goto L25;
        return false;
    L25:
        return true;
    L24:
        return true;
    }

    public final boolean allowShareExternal() {
        int r100 = this.externalAccessEntity;
        if (r100 == 3) goto L14;
        if (r100 == 1) goto L6;
    L7:
        if (r100 == 1) goto L9;
    L10:
        if (r100 == 0) goto L14;
        return false;
    L9:
        if (this.shareExternalEntity == 1) goto L14;
    L6:
        if (this.shareExternalEntity != 3) goto L7;
    L14:
        return true;
    }

    public final boolean canEditorInternalLinkShare() {
        if (this.linkShareEntity != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean canEditorLinkShare() {
        if (this.linkShareEntity != 5) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean canOrgEditLinkShare() {
        if (this.linkShareEntity != 7) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean canOrgReadLinkShare() {
        if (this.linkShareEntity != 6) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean canReadInternalLinkShare() {
        if (this.linkShareEntity != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean canReadLinkShare() {
        if (this.linkShareEntity != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean canSaveAsTemplate() {
        int r100 = this.securityEntity;
        if (r100 == 1) goto L10;
        if (r100 != (-1)) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L10;
        boolean r102 = false;
    L11:
        int r103 = this.managerCollaboratorEntity;
        if (r103 == 1) goto L17;
        if (r103 != (-1)) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == true) goto L17;
    L26:
        boolean r105 = false;
    L28:
        if (r102 == false) goto L32;
        if (r105 == false) goto L33;
        return true;
    L33:
        return false;
    L32:
        return false;
    L15:
        r104 = false;
    L17:
        int r106 = this.shareEntity;
        if (r106 != 1) goto L20;
    L27:
        r105 = true;
        goto L28
    L20:
        if (r106 == 2) goto L27;
        if (r106 != (-1)) goto L23;
        boolean r107 = true;
    L24:
        if (r107 == false) goto L26;
    L23:
        r107 = false;
        goto L24
    L6:
        r101 = false;
    L10:
        r102 = true;
        goto L11
    }

    public final boolean closeLinkShare() {
        if (this.linkShareEntity == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean denyShareExternal() {
        if (this.externalAccessEntity != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isShareInternal() {
        if (this.shareEntity == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean onlyCanAddCollaborator() {
        if (this.shareEntity == 2) goto L5;
    L7:
        return false;
    L5:
        if (this.managerCollaboratorEntity != 1) goto L7;
        return true;
    }

    public final boolean onlyCanCopyAndDownload() {
        if (this.securityEntity == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean onlyCanEditorCanAddCollaborator() {
        if (this.shareEntity == 2) goto L5;
    L7:
        return false;
    L5:
        if (this.managerCollaboratorEntity != 2) goto L7;
        return true;
    }

    public final boolean onlyCanEditorCanComment() {
        if (this.commentEntity != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean onlyCanReadCanComment() {
        if (this.commentEntity == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean onlyCanShareInternal() {
        if (this.externalAccessSwitch == true) goto L5;
    L7:
        return false;
    L5:
        if (this.shareExternalEntity != 1) goto L7;
        return true;
    }

    public final boolean onlyCanShowInternalV2() {
        int r100 = this.externalAccessEntity;
        if (r100 == 1) goto L8;
        if (r100 == 3) goto L8;
        if (r100 == 0) goto L8;
    L10:
        return false;
    L8:
        if (this.shareExternalEntity == 2) goto L10;
        return true;
    }

    public final boolean onlyEditorOrFaCanAddCollaborator() {
        if (this.managerCollaboratorEntity != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean onlyEditorOrFaCanCopy() {
        if (this.copyEntity != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean onlyEditorOrFaCanCopyAndDownload() {
        if (this.securityEntity != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean onlyFaCanAddCollaborator() {
        if (this.managerCollaboratorEntity != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean onlyFaCanAddOrManagerCollaborator() {
        if (this.shareEntity == 2) goto L5;
    L7:
        return false;
    L5:
        if (this.managerCollaboratorEntity != 3) goto L7;
        return true;
    }

    public final boolean onlyFaCanCopy() {
        if (this.copyEntity != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean onlyFaCanCopyAndDownload() {
        if (this.securityEntity != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean onlyFaCanShareExternal() {
        if (this.externalAccessSwitch == true) goto L5;
    L7:
        return false;
    L5:
        if (this.shareExternalEntity != 3) goto L7;
        return true;
    }

    public final boolean onlyFaCanShareExternalV2() {
        if (this.externalAccessEntity == 1) goto L5;
    L7:
        return false;
    L5:
        if (this.shareExternalEntity != 3) goto L7;
        return true;
    }

    public final boolean onlyInterCanEditorCanAddCollaborator() {
        if (this.shareEntity == 1) goto L5;
    L7:
        return false;
    L5:
        if (this.managerCollaboratorEntity != 2) goto L7;
        return true;
    }

    public final boolean onlyInternalCanAddCollaborator() {
        if (this.shareEntity == 1) goto L5;
    L7:
        return false;
    L5:
        if (this.managerCollaboratorEntity != 1) goto L7;
        return true;
    }

    public final boolean onlyInternalCanAddOrManagerCollaborator() {
        if (this.shareEntity == 1) goto L5;
    L7:
        return false;
    L5:
        if (this.managerCollaboratorEntity != 3) goto L7;
        return true;
    }

    public final boolean onlyInternalCollaboratorCanAddCollaborator() {
        if (this.shareEntity == 1) goto L5;
    L7:
        return false;
    L5:
        if (this.managerCollaboratorEntity != 1) goto L7;
        return true;
    }

    public final boolean onlyInternalEditorOrFaCanAddCollaborator() {
        if (this.shareEntity == 1) goto L5;
    L7:
        return false;
    L5:
        if (this.managerCollaboratorEntity != 2) goto L7;
        return true;
    }

    public final boolean onlyInternalFaCanAddCollaborator() {
        if (this.shareEntity == 1) goto L5;
    L7:
        return false;
    L5:
        if (this.managerCollaboratorEntity != 3) goto L7;
        return true;
    }

    public final boolean onlyReadCanCopy() {
        if (this.copyEntity == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean onlyShareInternal() {
        return !this.externalAccessSwitch;
    }

    public final boolean onlyShareInternalV2() {
        if (this.externalAccessEntity != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean shareExternalNoLimit() {
        int r100 = this.externalAccessEntity;
        if (r100 == 0) goto L13;
        if (r100 == 1) goto L6;
    L7:
        if (r100 == 1) goto L9;
        return false;
    L9:
        if (this.shareExternalEntity == 3) goto L13;
        return false;
    L6:
        if (this.shareExternalEntity != 1) goto L7;
    L13:
        return true;
    }

    public final boolean shareExternalOnlyRelated() {
        if (this.externalAccessEntity != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getDisableAISearchEntity() {
        return this.disableAISearchEntity;
    }

    public final boolean getExternalAccessSwitch() {
        return this.externalAccessSwitch;
    }

    public final boolean getLinkPasswordSwitch() {
        return this.linkPasswordSwitch;
    }

    public final int getLinkShareEntity() {
        return this.linkShareEntity;
    }

    public final int getSearchEntity() {
        return this.searchEntity;
    }

    public PermissionControl(int r100, int r101, int r102, int r103, boolean r104, int r105, int r106, boolean r107, int r108, int r110, int r111, int r112) {
        this.shareEntity = r100;
        this.securityEntity = r101;
        this.commentEntity = r102;
        this.linkShareEntity = r103;
        this.externalAccessSwitch = r104;
        this.shareExternalEntity = r105;
        this.managerCollaboratorEntity = r106;
        this.linkPasswordSwitch = r107;
        this.copyEntity = r108;
        this.externalAccessEntity = r110;
        this.searchEntity = r111;
        this.disableAISearchEntity = r112;
    }

    public /* synthetic */ PermissionControl(int r110, int r111, int r112, int r113, boolean r114, int r115, int r210, boolean r211, int r212, int r213, int r214, int r215, int r216, DefaultConstructorMarker r217) {
        int r100 = -1;
        if ((r216 & 1) == 0) goto L5;
        int r101 = -1;
    L7:
        if ((r216 & 2) == 0) goto L9;
        int r102 = -1;
    L11:
        if ((r216 & 4) == 0) goto L13;
        int r103 = -1;
    L15:
        if ((r216 & 8) == 0) goto L17;
        int r104 = -1;
    L18:
        boolean r105 = false;
        if ((r216 & 16) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r216 & 32) == 0) goto L25;
        int r107 = -1;
    L27:
        if ((r216 & 64) == 0) goto L29;
        int r108 = -1;
    L31:
        if ((r216 & 128) != 0) goto L35;
        r105 = r211;
    L35:
        if ((r216 & 256) == 0) goto L37;
        int r116 = -1;
    L39:
        if ((r216 & 512) == 0) goto L41;
        int r117 = -1;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        int r118 = -1;
    L47:
        if ((r216 & 2048) != 0) goto L50;
        r100 = r215;
    L50:
        this(r101, r102, r103, r104, r106, r107, r108, r105, r116, r117, r118, r100);
        return;
    L45:
        r118 = r214;
        goto L47
    L41:
        r117 = r213;
        goto L43
    L37:
        r116 = r212;
        goto L39
    L29:
        r108 = r210;
        goto L31
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L18
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
