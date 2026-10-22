package com.bytedance.ee.bear.middleground.permission.permission.doc;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ee.bear.middleground.permission.setting.publicpermset.model.CollaboratorPermissionType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u008b\u0002\u0012\u0018\b\u0002\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u0013J\u0006\u0010\u0019\u001a\u00020\u0013J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u0013J\u0006\u0010\u001d\u001a\u00020\u0013J\u0006\u0010\u001e\u001a\u00020\u0013J\u0006\u0010\u001f\u001a\u00020\u0013J\u0006\u0010 \u001a\u00020\u0013J\u0006\u0010!\u001a\u00020\u0013J\u0006\u0010\"\u001a\u00020\u0013J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u0013J\u0006\u0010&\u001a\u00020\u0013J\u0006\u0010'\u001a\u00020\u0013J\u0006\u0010(\u001a\u00020\u0013J\u0006\u0010)\u001a\u00020\u0013J\u0006\u0010*\u001a\u00020\u0013J\u0006\u0010+\u001a\u00020\u0013J\u0006\u0010,\u001a\u00020\u0013J\u0006\u0010-\u001a\u00020\u0013J\u0006\u0010.\u001a\u00020\u0013J\u0006\u0010/\u001a\u00020\u0013J\u0006\u00100\u001a\u00020\u0013J\u0006\u00101\u001a\u00020\u0013J\u0006\u00102\u001a\u00020\u0013J\u0006\u00103\u001a\u00020\u0013¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/permission/doc/BlockOptionsV2;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/BlockOptionsV2;", "Ljava/io/Serializable;", "share", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/BlockOptionsV2$BlockEntity;", "Lkotlin/collections/ArrayList;", "managerCollaborator", "externalAccess", "shareExternal", AppConstants.API_HOST_SI_PREFIX, "copy", "showCollaboratorInfo", "comment", "linkShare", "applyEmbed", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getApplyEmbedEntityReadBlockValue", "", "getApplyEmbedEntityEditBlockValue", "getApplyEmbedEntityFABlockValue", "getSecurityReadBlockValue", "getSecurityEditBlockValue", "getSecurityFaBlockValue", "getCopyReadBlockValue", "getCopyEditBlockValue", "getCopyFaBlockValue", "getShowCollaboratorInfoReadBlockValue", "getShowCollaboratorInfoEditBlockValue", "getShowCollaboratorInfoFaBlockValue", "getCommentReadBlockValue", "getCommentEditBlockValue", "getExternalAccessOpenBlockValue", "getExternalAccessCloseBlockValue", "canExternalAccessOpenEscape", "", "getPartnerTenantAccessBlockValue", "getLinkShareCloseBlockValue", "getLinkShareInternalReadBlockValue", "getLinkShareInternalEditBlockValue", "getLinkShareAnyoneReadBlockValue", "getLinkShareAnyoneEditBlockValue", "getLinkSharePartnerTenantReadBlockValue", "getLinkSharePartnerTenantEditBlockValue", "getShareExternalFaBlockValue", "getShareExternalReadBlockValue", "getManageCollaboratorReadBlockValue", "getManageCollaboratorEditBlockValue", "getManageCollaboratorFaBlockValue", "getShareInternalBlockValue", "getShareAnyoneBlockValue", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockOptionsV2 extends com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2 implements Serializable {
    public BlockOptionsV2() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public final boolean canExternalAccessOpenEscape() {
        Iterator<T> r100 = getExternalAccess().iterator();
        boolean r101 = false;
    L4:
        if (r100.hasNext() == false) goto L15;
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r102 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r100.next();
        if (r102.getValue() != 1) goto L4;
        if (CollectionsKt.listOf(new Integer[]{0, 5}).contains(Integer.valueOf(r102.getBlockType())) == false) goto L9;
        if (r102.getBlockType() != 5) goto L4;
        if (r102.getCanEscape() == false) goto L4;
        r101 = true;
        goto L4
    L9:
        return false;
    L15:
        return r101;
    }

    public final int getApplyEmbedEntityEditBlockValue() {
        Iterator<T> r100 = getApplyEmbed().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getApplyEmbedEntityFABlockValue() {
        Iterator<T> r100 = getApplyEmbed().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getApplyEmbedEntityReadBlockValue() {
        Iterator<T> r100 = getApplyEmbed().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != CollaboratorPermissionType.READ_PERM.getValue()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getCommentEditBlockValue() {
        Iterator<T> r100 = getComment().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getCommentReadBlockValue() {
        Iterator<T> r100 = getComment().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != CollaboratorPermissionType.READ_PERM.getValue()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getCopyEditBlockValue() {
        Iterator<T> r100 = getCopy().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getCopyFaBlockValue() {
        Iterator<T> r100 = getCopy().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getCopyReadBlockValue() {
        Iterator<T> r100 = getCopy().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != CollaboratorPermissionType.READ_PERM.getValue()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getExternalAccessCloseBlockValue() {
        Iterator<T> r100 = getExternalAccess().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != 2) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getExternalAccessOpenBlockValue() {
        Iterator<T> r100 = getExternalAccess().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        boolean r102 = true;
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() == 1) goto L9;
        r102 = false;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L11:
        r101 = null;
        goto L12
    }

    public final int getLinkShareAnyoneEditBlockValue() {
        Iterator<T> r100 = getLinkShare().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != 5) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getLinkShareAnyoneReadBlockValue() {
        Iterator<T> r100 = getLinkShare().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != 4) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getLinkShareCloseBlockValue() {
        Iterator<T> r100 = getLinkShare().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        boolean r102 = true;
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() == 1) goto L9;
        r102 = false;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L11:
        r101 = null;
        goto L12
    }

    public final int getLinkShareInternalEditBlockValue() {
        Iterator<T> r100 = getLinkShare().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != 3) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getLinkShareInternalReadBlockValue() {
        Iterator<T> r100 = getLinkShare().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != 2) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getLinkSharePartnerTenantEditBlockValue() {
        Iterator<T> r100 = getLinkShare().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != 7) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getLinkSharePartnerTenantReadBlockValue() {
        Iterator<T> r100 = getLinkShare().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != 6) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getManageCollaboratorEditBlockValue() {
        Iterator<T> r100 = getManagerCollaborator().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getManageCollaboratorFaBlockValue() {
        Iterator<T> r100 = getManagerCollaborator().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getManageCollaboratorReadBlockValue() {
        Iterator<T> r100 = getManagerCollaborator().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != CollaboratorPermissionType.READ_PERM.getValue()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getPartnerTenantAccessBlockValue() {
        Iterator<T> r100 = getExternalAccess().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != 3) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getSecurityEditBlockValue() {
        Iterator<T> r100 = getSecurity().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getSecurityFaBlockValue() {
        Iterator<T> r100 = getSecurity().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getSecurityReadBlockValue() {
        Iterator<T> r100 = getSecurity().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != CollaboratorPermissionType.READ_PERM.getValue()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getShareAnyoneBlockValue() {
        Iterator<T> r100 = getShare().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != 2) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getShareExternalFaBlockValue() {
        Iterator<T> r100 = getShareExternal().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getShareExternalReadBlockValue() {
        Iterator<T> r100 = getShareExternal().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != CollaboratorPermissionType.READ_PERM.getValue()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getShareInternalBlockValue() {
        Iterator<T> r100 = getShare().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        boolean r102 = true;
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() == 1) goto L9;
        r102 = false;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L11:
        r101 = null;
        goto L12
    }

    public final int getShowCollaboratorInfoEditBlockValue() {
        Iterator<T> r100 = getShowCollaboratorInfo().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getShowCollaboratorInfoFaBlockValue() {
        Iterator<T> r100 = getShowCollaboratorInfo().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final int getShowCollaboratorInfoReadBlockValue() {
        Iterator<T> r100 = getShowCollaboratorInfo().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101).getValue() != CollaboratorPermissionType.READ_PERM.getValue()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity r103 = (com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity) r101;
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.getBlockType();
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public BlockOptionsV2(ArrayList<com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity> r100, ArrayList<com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity> r101, ArrayList<com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity> r102, ArrayList<com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity> r103, ArrayList<com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity> r104, ArrayList<com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity> r105, ArrayList<com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity> r106, ArrayList<com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity> r107, ArrayList<com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity> r110, ArrayList<com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptionsV2.BlockEntity> r111) {
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

    public /* synthetic */ BlockOptionsV2(ArrayList r110, ArrayList r111, ArrayList r112, ArrayList r113, ArrayList r114, ArrayList r115, ArrayList r116, ArrayList r117, ArrayList r118, ArrayList r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 1) == 0) goto L5;
        ArrayList r100 = new ArrayList();
    L7:
        if ((r211 & 2) == 0) goto L9;
        ArrayList r101 = new ArrayList();
    L11:
        if ((r211 & 4) == 0) goto L13;
        ArrayList r102 = new ArrayList();
    L15:
        if ((r211 & 8) == 0) goto L17;
        ArrayList r103 = new ArrayList();
    L19:
        if ((r211 & 16) == 0) goto L21;
        ArrayList r104 = new ArrayList();
    L23:
        if ((r211 & 32) == 0) goto L25;
        ArrayList r105 = new ArrayList();
    L27:
        if ((r211 & 64) == 0) goto L29;
        ArrayList r106 = new ArrayList();
    L31:
        if ((r211 & 128) == 0) goto L33;
        ArrayList r107 = new ArrayList();
    L35:
        if ((r211 & 256) == 0) goto L37;
        ArrayList r108 = new ArrayList();
    L39:
        if ((r211 & 512) == 0) goto L41;
        ArrayList r109 = new ArrayList();
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
