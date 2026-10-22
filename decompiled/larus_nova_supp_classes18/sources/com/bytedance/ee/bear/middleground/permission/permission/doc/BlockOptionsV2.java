package com.bytedance.ee.bear.middleground.permission.permission.doc;

import com.bytedance.ee.bear.middleground.permission.setting.publicpermset.model.CollaboratorPermissionType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u008b\u0002\u0012\u0018\b\u0002\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u0013J\u0006\u0010\u0019\u001a\u00020\u0013J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u0013J\u0006\u0010\u001d\u001a\u00020\u0013J\u0006\u0010\u001e\u001a\u00020\u0013J\u0006\u0010\u001f\u001a\u00020\u0013J\u0006\u0010 \u001a\u00020\u0013J\u0006\u0010!\u001a\u00020\u0013J\u0006\u0010\"\u001a\u00020\u0013J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u0013J\u0006\u0010&\u001a\u00020\u0013J\u0006\u0010'\u001a\u00020\u0013J\u0006\u0010(\u001a\u00020\u0013J\u0006\u0010)\u001a\u00020\u0013J\u0006\u0010*\u001a\u00020\u0013J\u0006\u0010+\u001a\u00020\u0013J\u0006\u0010,\u001a\u00020\u0013J\u0006\u0010-\u001a\u00020\u0013J\u0006\u0010.\u001a\u00020\u0013J\u0006\u0010/\u001a\u00020\u0013J\u0006\u00100\u001a\u00020\u0013J\u0006\u00101\u001a\u00020\u0013J\u0006\u00102\u001a\u00020\u0013J\u0006\u00103\u001a\u00020\u0013¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/permission/doc/BlockOptionsV2;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/BlockOptionsV2;", "Ljava/io/Serializable;", "share", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/BlockOptionsV2$BlockEntity;", "Lkotlin/collections/ArrayList;", "managerCollaborator", "externalAccess", "shareExternal", "security", "copy", "showCollaboratorInfo", "comment", "linkShare", "applyEmbed", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getApplyEmbedEntityReadBlockValue", "", "getApplyEmbedEntityEditBlockValue", "getApplyEmbedEntityFABlockValue", "getSecurityReadBlockValue", "getSecurityEditBlockValue", "getSecurityFaBlockValue", "getCopyReadBlockValue", "getCopyEditBlockValue", "getCopyFaBlockValue", "getShowCollaboratorInfoReadBlockValue", "getShowCollaboratorInfoEditBlockValue", "getShowCollaboratorInfoFaBlockValue", "getCommentReadBlockValue", "getCommentEditBlockValue", "getExternalAccessOpenBlockValue", "getExternalAccessCloseBlockValue", "canExternalAccessOpenEscape", "", "getPartnerTenantAccessBlockValue", "getLinkShareCloseBlockValue", "getLinkShareInternalReadBlockValue", "getLinkShareInternalEditBlockValue", "getLinkShareAnyoneReadBlockValue", "getLinkShareAnyoneEditBlockValue", "getLinkSharePartnerTenantReadBlockValue", "getLinkSharePartnerTenantEditBlockValue", "getShareExternalFaBlockValue", "getShareExternalReadBlockValue", "getManageCollaboratorReadBlockValue", "getManageCollaboratorEditBlockValue", "getManageCollaboratorFaBlockValue", "getShareInternalBlockValue", "getShareAnyoneBlockValue", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockOptionsV2 extends com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2 implements Serializable {
    public BlockOptionsV2() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public final boolean canExternalAccessOpenEscape() {
        Iterator<T> r0 = getExternalAccess().iterator();
        boolean r2 = false;
    L4:
        if (r0.hasNext() == false) goto L15;
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r3 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r0.next();
        if (r3.getValue() != 1) goto L4;
        if (CollectionsKt.listOf(new Integer[]{0, 5}).contains(Integer.valueOf(r3.getBlockType())) == false) goto L9;
        if (r3.getBlockType() != 5) goto L4;
        if (r3.getCanEscape() == false) goto L4;
        r2 = true;
        goto L4
    L9:
        return false;
    L15:
        return r2;
    }

    public final int getApplyEmbedEntityEditBlockValue() {
        Iterator<T> r0 = getApplyEmbed().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getApplyEmbedEntityFABlockValue() {
        Iterator<T> r0 = getApplyEmbed().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getApplyEmbedEntityReadBlockValue() {
        Iterator<T> r0 = getApplyEmbed().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != CollaboratorPermissionType.READ_PERM.getValue()) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getCommentEditBlockValue() {
        Iterator<T> r0 = getComment().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getCommentReadBlockValue() {
        Iterator<T> r0 = getComment().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != CollaboratorPermissionType.READ_PERM.getValue()) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getCopyEditBlockValue() {
        Iterator<T> r0 = getCopy().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getCopyFaBlockValue() {
        Iterator<T> r0 = getCopy().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getCopyReadBlockValue() {
        Iterator<T> r0 = getCopy().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != CollaboratorPermissionType.READ_PERM.getValue()) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getExternalAccessCloseBlockValue() {
        Iterator<T> r0 = getExternalAccess().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != 2) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getExternalAccessOpenBlockValue() {
        Iterator<T> r0 = getExternalAccess().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        boolean r4 = true;
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() == 1) goto L9;
        r4 = false;
    L9:
        if (r4 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L11:
        r1 = null;
        goto L12
    }

    public final int getLinkShareAnyoneEditBlockValue() {
        Iterator<T> r0 = getLinkShare().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != 5) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getLinkShareAnyoneReadBlockValue() {
        Iterator<T> r0 = getLinkShare().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != 4) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getLinkShareCloseBlockValue() {
        Iterator<T> r0 = getLinkShare().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        boolean r4 = true;
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() == 1) goto L9;
        r4 = false;
    L9:
        if (r4 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L11:
        r1 = null;
        goto L12
    }

    public final int getLinkShareInternalEditBlockValue() {
        Iterator<T> r0 = getLinkShare().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != 3) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getLinkShareInternalReadBlockValue() {
        Iterator<T> r0 = getLinkShare().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != 2) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getLinkSharePartnerTenantEditBlockValue() {
        Iterator<T> r0 = getLinkShare().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != 7) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getLinkSharePartnerTenantReadBlockValue() {
        Iterator<T> r0 = getLinkShare().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != 6) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getManageCollaboratorEditBlockValue() {
        Iterator<T> r0 = getManagerCollaborator().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getManageCollaboratorFaBlockValue() {
        Iterator<T> r0 = getManagerCollaborator().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getManageCollaboratorReadBlockValue() {
        Iterator<T> r0 = getManagerCollaborator().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != CollaboratorPermissionType.READ_PERM.getValue()) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getPartnerTenantAccessBlockValue() {
        Iterator<T> r0 = getExternalAccess().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != 3) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getSecurityEditBlockValue() {
        Iterator<T> r0 = getSecurity().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getSecurityFaBlockValue() {
        Iterator<T> r0 = getSecurity().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getSecurityReadBlockValue() {
        Iterator<T> r0 = getSecurity().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != CollaboratorPermissionType.READ_PERM.getValue()) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getShareAnyoneBlockValue() {
        Iterator<T> r0 = getShare().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != 2) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getShareExternalFaBlockValue() {
        Iterator<T> r0 = getShareExternal().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getShareExternalReadBlockValue() {
        Iterator<T> r0 = getShareExternal().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != CollaboratorPermissionType.READ_PERM.getValue()) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getShareInternalBlockValue() {
        Iterator<T> r0 = getShare().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        boolean r4 = true;
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() == 1) goto L9;
        r4 = false;
    L9:
        if (r4 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L11:
        r1 = null;
        goto L12
    }

    public final int getShowCollaboratorInfoEditBlockValue() {
        Iterator<T> r0 = getShowCollaboratorInfo().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getShowCollaboratorInfoFaBlockValue() {
        Iterator<T> r0 = getShowCollaboratorInfo().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final int getShowCollaboratorInfoReadBlockValue() {
        Iterator<T> r0 = getShowCollaboratorInfo().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1).getValue() != CollaboratorPermissionType.READ_PERM.getValue()) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r2 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r1;
        if (r2 != null) goto L15;
        return 0;
    L15:
        return r2.getBlockType();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public BlockOptionsV2(ArrayList<com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity> r2, ArrayList<com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity> r3, ArrayList<com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity> r4, ArrayList<com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity> r5, ArrayList<com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity> r6, ArrayList<com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity> r7, ArrayList<com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity> r8, ArrayList<com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity> r9, ArrayList<com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity> r10, ArrayList<com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity> r11) {
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

    public /* synthetic */ BlockOptionsV2(ArrayList r11, ArrayList r12, ArrayList r13, ArrayList r14, ArrayList r15, ArrayList r16, ArrayList r17, ArrayList r18, ArrayList r19, ArrayList r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 1) == 0) goto L5;
        ArrayList r1 = new ArrayList();
    L7:
        if ((r21 & 2) == 0) goto L9;
        ArrayList r2 = new ArrayList();
    L11:
        if ((r21 & 4) == 0) goto L13;
        ArrayList r3 = new ArrayList();
    L15:
        if ((r21 & 8) == 0) goto L17;
        ArrayList r4 = new ArrayList();
    L19:
        if ((r21 & 16) == 0) goto L21;
        ArrayList r5 = new ArrayList();
    L23:
        if ((r21 & 32) == 0) goto L25;
        ArrayList r6 = new ArrayList();
    L27:
        if ((r21 & 64) == 0) goto L29;
        ArrayList r7 = new ArrayList();
    L31:
        if ((r21 & 128) == 0) goto L33;
        ArrayList r8 = new ArrayList();
    L35:
        if ((r21 & 256) == 0) goto L37;
        ArrayList r9 = new ArrayList();
    L39:
        if ((r21 & 512) == 0) goto L41;
        ArrayList r0 = new ArrayList();
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
