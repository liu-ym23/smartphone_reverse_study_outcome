package com.bytedance.ee.bear.middleground.permission.permission.doc;

import com.bytedance.ee.bear.middleground.permission.setting.publicpermset.model.CollaboratorPermissionType;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b+\u0018\u00002\u00020\u00012\u00020\u0002B\u0083\u0003\u0012$\b\u0002\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u0012$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u0012$\b\u0002\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u0012$\b\u0002\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u0012$\b\u0002\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u0012$\b\u0002\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u0012$\b\u0002\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u0012$\b\u0002\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u0012$\b\u0002\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u0012$\b\u0002\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0005J\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020\u0005J\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0005J\u0006\u0010&\u001a\u00020\u0005J\u0006\u0010'\u001a\u00020\u0005J\u0006\u0010(\u001a\u00020\u0005J\u0006\u0010)\u001a\u00020\u0005J\u0006\u0010*\u001a\u00020\u0005J\u0006\u0010+\u001a\u00020\u0005J\u0006\u0010,\u001a\u00020\u0005J\u0006\u0010-\u001a\u00020\u0005J\u0006\u0010.\u001a\u00020\u0005J\u0006\u0010/\u001a\u00020\u0005J\u0006\u00100\u001a\u00020\u0005¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/permission/doc/BlockOptions;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/BlockOptions;", "Ljava/io/Serializable;", "share", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "managerCollaborator", "externalAccess", "shareExternal", "security", "copy", "showCollaboratorInfo", "comment", "linkShare", "applyEmbed", "<init>", "(Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;)V", "getApplyEmbedEntityReadBlockValue", "getApplyEmbedEntityEditBlockValue", "getApplyEmbedEntityFABlockValue", "getSecurityReadBlockValue", "getSecurityEditBlockValue", "getSecurityFaBlockValue", "getCopyReadBlockValue", "getCopyEditBlockValue", "getCopyFaBlockValue", "getShowCollaboratorInfoReadBlockValue", "getShowCollaboratorInfoEditBlockValue", "getShowCollaboratorInfoFaBlockValue", "getCommentReadBlockValue", "getCommentEditBlockValue", "getExternalAccessOpenBlockValue", "getExternalAccessCloseBlockValue", "getPartnerTenantAccessBlockValue", "getLinkShareCloseBlockValue", "getLinkShareInternalReadBlockValue", "getLinkShareInternalEditBlockValue", "getLinkShareAnyoneReadBlockValue", "getLinkShareAnyoneEditBlockValue", "getLinkSharePartnerTenantReadBlockValue", "getLinkSharePartnerTenantEditBlockValue", "getShareExternalFaBlockValue", "getShareExternalReadBlockValue", "getManageCollaboratorReadBlockValue", "getManageCollaboratorEditBlockValue", "getManageCollaboratorFaBlockValue", "getShareInternalBlockValue", "getShareAnyoneBlockValue", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockOptions extends com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptions {
    public BlockOptions() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public final int getApplyEmbedEntityEditBlockValue() {
        Integer r0 = getApplyEmbedMap().get(Integer.valueOf(CollaboratorPermissionType.EDIT_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getApplyEmbedEntityFABlockValue() {
        Integer r0 = getApplyEmbedMap().get(Integer.valueOf(CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getApplyEmbedEntityReadBlockValue() {
        Integer r0 = getApplyEmbedMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getCommentEditBlockValue() {
        Integer r0 = getCommentMap().get(Integer.valueOf(CollaboratorPermissionType.EDIT_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getCommentReadBlockValue() {
        Integer r0 = getCommentMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getCopyEditBlockValue() {
        Integer r0 = getCopyMap().get(Integer.valueOf(CollaboratorPermissionType.EDIT_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getCopyFaBlockValue() {
        Integer r0 = getCopyMap().get(Integer.valueOf(CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getCopyReadBlockValue() {
        Integer r0 = getCopyMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getExternalAccessCloseBlockValue() {
        Integer r0 = getExternalAccessMap().get(2);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getExternalAccessOpenBlockValue() {
        Integer r0 = getExternalAccessMap().get(1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getLinkShareAnyoneEditBlockValue() {
        Integer r0 = getLinkShareMap().get(5);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getLinkShareAnyoneReadBlockValue() {
        Integer r0 = getLinkShareMap().get(4);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getLinkShareCloseBlockValue() {
        Integer r0 = getLinkShareMap().get(1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getLinkShareInternalEditBlockValue() {
        Integer r0 = getLinkShareMap().get(3);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getLinkShareInternalReadBlockValue() {
        Integer r0 = getLinkShareMap().get(2);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getLinkSharePartnerTenantEditBlockValue() {
        Integer r0 = getLinkShareMap().get(7);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getLinkSharePartnerTenantReadBlockValue() {
        Integer r0 = getLinkShareMap().get(6);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getManageCollaboratorEditBlockValue() {
        Integer r0 = getManagerCollaboratorMap().get(Integer.valueOf(CollaboratorPermissionType.EDIT_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getManageCollaboratorFaBlockValue() {
        Integer r0 = getManagerCollaboratorMap().get(Integer.valueOf(CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getManageCollaboratorReadBlockValue() {
        Integer r0 = getManagerCollaboratorMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getPartnerTenantAccessBlockValue() {
        Integer r0 = getExternalAccessMap().get(3);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getSecurityEditBlockValue() {
        Integer r0 = getSecurityMap().get(Integer.valueOf(CollaboratorPermissionType.EDIT_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getSecurityFaBlockValue() {
        Integer r0 = getSecurityMap().get(Integer.valueOf(CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getSecurityReadBlockValue() {
        Integer r0 = getSecurityMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getShareAnyoneBlockValue() {
        Integer r0 = getShareMap().get(2);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getShareExternalFaBlockValue() {
        Integer r0 = getShareExternalMap().get(Integer.valueOf(CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getShareExternalReadBlockValue() {
        Integer r0 = getShareExternalMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getShareInternalBlockValue() {
        Integer r0 = getShareMap().get(1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getShowCollaboratorInfoEditBlockValue() {
        Integer r0 = getShowCollaboratorInfoMap().get(Integer.valueOf(CollaboratorPermissionType.EDIT_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getShowCollaboratorInfoFaBlockValue() {
        Integer r0 = getShowCollaboratorInfoMap().get(Integer.valueOf(CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getShowCollaboratorInfoReadBlockValue() {
        Integer r0 = getShowCollaboratorInfoMap().get(Integer.valueOf(CollaboratorPermissionType.READ_PERM.getValue()));
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public BlockOptions(HashMap<Integer, Integer> r2, HashMap<Integer, Integer> r3, HashMap<Integer, Integer> r4, HashMap<Integer, Integer> r5, HashMap<Integer, Integer> r6, HashMap<Integer, Integer> r7, HashMap<Integer, Integer> r8, HashMap<Integer, Integer> r9, HashMap<Integer, Integer> r10, HashMap<Integer, Integer> r11) {
        Intrinsics.checkNotNullParameter(r2, "share");
        Intrinsics.checkNotNullParameter(r3, "managerCollaborator");
        Intrinsics.checkNotNullParameter(r4, "externalAccess");
        Intrinsics.checkNotNullParameter(r5, "shareExternal");
        Intrinsics.checkNotNullParameter(r6, "security");
        Intrinsics.checkNotNullParameter(r7, "copy");
        Intrinsics.checkNotNullParameter(r8, "showCollaboratorInfo");
        Intrinsics.checkNotNullParameter(r9, "comment");
        Intrinsics.checkNotNullParameter(r10, "linkShare");
        Intrinsics.checkNotNullParameter(r11, "applyEmbed");
        super(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public /* synthetic */ BlockOptions(HashMap r11, HashMap r12, HashMap r13, HashMap r14, HashMap r15, HashMap r16, HashMap r17, HashMap r18, HashMap r19, HashMap r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 1) == 0) goto L5;
        HashMap r1 = new HashMap();
    L7:
        if ((r21 & 2) == 0) goto L9;
        HashMap r2 = new HashMap();
    L11:
        if ((r21 & 4) == 0) goto L13;
        HashMap r3 = new HashMap();
    L15:
        if ((r21 & 8) == 0) goto L17;
        HashMap r4 = new HashMap();
    L19:
        if ((r21 & 16) == 0) goto L21;
        HashMap r5 = new HashMap();
    L23:
        if ((r21 & 32) == 0) goto L25;
        HashMap r6 = new HashMap();
    L27:
        if ((r21 & 64) == 0) goto L29;
        HashMap r7 = new HashMap();
    L31:
        if ((r21 & 128) == 0) goto L33;
        HashMap r8 = new HashMap();
    L35:
        if ((r21 & 256) == 0) goto L37;
        HashMap r9 = new HashMap();
    L39:
        if ((r21 & 512) == 0) goto L41;
        HashMap r0 = new HashMap();
    L42:
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r0);
        return;
    L41:
        r0 = r20;
        goto L42
    L37:
        r9 = r19;
        goto L39
    L33:
        r8 = r18;
        goto L35
    L29:
        r7 = r17;
        goto L31
    L25:
        r6 = r16;
        goto L27
    L21:
        r5 = r15;
        goto L23
    L17:
        r4 = r14;
        goto L19
    L13:
        r3 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}
