package com.bytedance.ee.bear.middleground.permission.permission.doc;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ee.bear.middleground.permission.setting.publicpermset.model.CollaboratorPermissionType;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b+\u0018\u00002\u00020\u00012\u00020\u0002B\u0083\u0003\u0012$\b\u0002\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u0012$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u0012$\b\u0002\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u0012$\b\u0002\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u0012$\b\u0002\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u0012$\b\u0002\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u0012$\b\u0002\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u0012$\b\u0002\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u0012$\b\u0002\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u0012$\b\u0002\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0005J\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020\u0005J\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0005J\u0006\u0010&\u001a\u00020\u0005J\u0006\u0010'\u001a\u00020\u0005J\u0006\u0010(\u001a\u00020\u0005J\u0006\u0010)\u001a\u00020\u0005J\u0006\u0010*\u001a\u00020\u0005J\u0006\u0010+\u001a\u00020\u0005J\u0006\u0010,\u001a\u00020\u0005J\u0006\u0010-\u001a\u00020\u0005J\u0006\u0010.\u001a\u00020\u0005J\u0006\u0010/\u001a\u00020\u0005J\u0006\u00100\u001a\u00020\u0005¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/permission/doc/BlockOptions;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/BlockOptions;", "Ljava/io/Serializable;", "share", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "managerCollaborator", "externalAccess", "shareExternal", AppConstants.API_HOST_SI_PREFIX, "copy", "showCollaboratorInfo", "comment", "linkShare", "applyEmbed", "<init>", "(Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;)V", "getApplyEmbedEntityReadBlockValue", "getApplyEmbedEntityEditBlockValue", "getApplyEmbedEntityFABlockValue", "getSecurityReadBlockValue", "getSecurityEditBlockValue", "getSecurityFaBlockValue", "getCopyReadBlockValue", "getCopyEditBlockValue", "getCopyFaBlockValue", "getShowCollaboratorInfoReadBlockValue", "getShowCollaboratorInfoEditBlockValue", "getShowCollaboratorInfoFaBlockValue", "getCommentReadBlockValue", "getCommentEditBlockValue", "getExternalAccessOpenBlockValue", "getExternalAccessCloseBlockValue", "getPartnerTenantAccessBlockValue", "getLinkShareCloseBlockValue", "getLinkShareInternalReadBlockValue", "getLinkShareInternalEditBlockValue", "getLinkShareAnyoneReadBlockValue", "getLinkShareAnyoneEditBlockValue", "getLinkSharePartnerTenantReadBlockValue", "getLinkSharePartnerTenantEditBlockValue", "getShareExternalFaBlockValue", "getShareExternalReadBlockValue", "getManageCollaboratorReadBlockValue", "getManageCollaboratorEditBlockValue", "getManageCollaboratorFaBlockValue", "getShareInternalBlockValue", "getShareAnyoneBlockValue", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockOptions extends com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptions {
    public BlockOptions() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public final int getApplyEmbedEntityEditBlockValue() {
        Integer r100 = getApplyEmbedMap().get(Integer.valueOf(CollaboratorPermissionType.EDIT_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getApplyEmbedEntityFABlockValue() {
        Integer r100 = getApplyEmbedMap().get(Integer.valueOf(CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getApplyEmbedEntityReadBlockValue() {
        Integer r100 = getApplyEmbedMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getCommentEditBlockValue() {
        Integer r100 = getCommentMap().get(Integer.valueOf(CollaboratorPermissionType.EDIT_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getCommentReadBlockValue() {
        Integer r100 = getCommentMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getCopyEditBlockValue() {
        Integer r100 = getCopyMap().get(Integer.valueOf(CollaboratorPermissionType.EDIT_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getCopyFaBlockValue() {
        Integer r100 = getCopyMap().get(Integer.valueOf(CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getCopyReadBlockValue() {
        Integer r100 = getCopyMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getExternalAccessCloseBlockValue() {
        Integer r100 = getExternalAccessMap().get(2);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getExternalAccessOpenBlockValue() {
        Integer r100 = getExternalAccessMap().get(1);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getLinkShareAnyoneEditBlockValue() {
        Integer r100 = getLinkShareMap().get(5);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getLinkShareAnyoneReadBlockValue() {
        Integer r100 = getLinkShareMap().get(4);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getLinkShareCloseBlockValue() {
        Integer r100 = getLinkShareMap().get(1);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getLinkShareInternalEditBlockValue() {
        Integer r100 = getLinkShareMap().get(3);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getLinkShareInternalReadBlockValue() {
        Integer r100 = getLinkShareMap().get(2);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getLinkSharePartnerTenantEditBlockValue() {
        Integer r100 = getLinkShareMap().get(7);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getLinkSharePartnerTenantReadBlockValue() {
        Integer r100 = getLinkShareMap().get(6);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getManageCollaboratorEditBlockValue() {
        Integer r100 = getManagerCollaboratorMap().get(Integer.valueOf(CollaboratorPermissionType.EDIT_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getManageCollaboratorFaBlockValue() {
        Integer r100 = getManagerCollaboratorMap().get(Integer.valueOf(CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getManageCollaboratorReadBlockValue() {
        Integer r100 = getManagerCollaboratorMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getPartnerTenantAccessBlockValue() {
        Integer r100 = getExternalAccessMap().get(3);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getSecurityEditBlockValue() {
        Integer r100 = getSecurityMap().get(Integer.valueOf(CollaboratorPermissionType.EDIT_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getSecurityFaBlockValue() {
        Integer r100 = getSecurityMap().get(Integer.valueOf(CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getSecurityReadBlockValue() {
        Integer r100 = getSecurityMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getShareAnyoneBlockValue() {
        Integer r100 = getShareMap().get(2);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getShareExternalFaBlockValue() {
        Integer r100 = getShareExternalMap().get(Integer.valueOf(CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getShareExternalReadBlockValue() {
        Integer r100 = getShareExternalMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getShareInternalBlockValue() {
        Integer r100 = getShareMap().get(1);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getShowCollaboratorInfoEditBlockValue() {
        Integer r100 = getShowCollaboratorInfoMap().get(Integer.valueOf(CollaboratorPermissionType.EDIT_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getShowCollaboratorInfoFaBlockValue() {
        Integer r100 = getShowCollaboratorInfoMap().get(Integer.valueOf(CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final int getShowCollaboratorInfoReadBlockValue() {
        Integer r100 = getShowCollaboratorInfoMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public BlockOptions(HashMap<Integer, Integer> r100, HashMap<Integer, Integer> r101, HashMap<Integer, Integer> r102, HashMap<Integer, Integer> r103, HashMap<Integer, Integer> r104, HashMap<Integer, Integer> r105, HashMap<Integer, Integer> r106, HashMap<Integer, Integer> r107, HashMap<Integer, Integer> r110, HashMap<Integer, Integer> r111) {
        Intrinsics.checkNotNullParameter(r100, "share");
        Intrinsics.checkNotNullParameter(r101, "managerCollaborator");
        Intrinsics.checkNotNullParameter(r102, "externalAccess");
        Intrinsics.checkNotNullParameter(r103, "shareExternal");
        Intrinsics.checkNotNullParameter(r104, AppConstants.API_HOST_SI_PREFIX);
        Intrinsics.checkNotNullParameter(r105, "copy");
        Intrinsics.checkNotNullParameter(r106, "showCollaboratorInfo");
        Intrinsics.checkNotNullParameter(r107, "comment");
        Intrinsics.checkNotNullParameter(r110, "linkShare");
        Intrinsics.checkNotNullParameter(r111, "applyEmbed");
        super(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111);
    }

    public /* synthetic */ BlockOptions(HashMap r110, HashMap r111, HashMap r112, HashMap r113, HashMap r114, HashMap r115, HashMap r116, HashMap r117, HashMap r118, HashMap r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 1) == 0) goto L5;
        HashMap r100 = new HashMap();
    L7:
        if ((r211 & 2) == 0) goto L9;
        HashMap r101 = new HashMap();
    L11:
        if ((r211 & 4) == 0) goto L13;
        HashMap r102 = new HashMap();
    L15:
        if ((r211 & 8) == 0) goto L17;
        HashMap r103 = new HashMap();
    L19:
        if ((r211 & 16) == 0) goto L21;
        HashMap r104 = new HashMap();
    L23:
        if ((r211 & 32) == 0) goto L25;
        HashMap r105 = new HashMap();
    L27:
        if ((r211 & 64) == 0) goto L29;
        HashMap r106 = new HashMap();
    L31:
        if ((r211 & 128) == 0) goto L33;
        HashMap r107 = new HashMap();
    L35:
        if ((r211 & 256) == 0) goto L37;
        HashMap r108 = new HashMap();
    L39:
        if ((r211 & 512) == 0) goto L41;
        HashMap r109 = new HashMap();
    L42:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109);
        return;
    L41:
        r109 = r210;
        goto L42
    L37:
        r108 = r118;
        goto L39
    L33:
        r107 = r117;
        goto L35
    L29:
        r106 = r116;
        goto L31
    L25:
        r105 = r115;
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
}
