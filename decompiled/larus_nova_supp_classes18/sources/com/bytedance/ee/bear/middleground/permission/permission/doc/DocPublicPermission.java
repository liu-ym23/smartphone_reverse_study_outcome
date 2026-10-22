package com.bytedance.ee.bear.middleground.permission.permission.doc;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.b;
import com.bytedance.ee.bear.middleground.permission.setting.publicpermset.model.CollaboratorPermissionType;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.permission.define.value.TypePermissionScope;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u009a\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0006\u009a\u0001\u009b\u0001\u009c\u0001Bµ\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0010\u0012\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u001cj\b\u0012\u0004\u0012\u00020\u0012`\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001f\u001a\u00020 \u0012\b\b\u0002\u0010!\u001a\u00020\"\u0012\b\b\u0002\u0010#\u001a\u00020$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b)\u0010*J\b\u00101\u001a\u00020\u0010H\u0016J\b\u00102\u001a\u00020\u0010H\u0016J\b\u00103\u001a\u00020\u0010H\u0016J\b\u00104\u001a\u00020\u0010H\u0016J\u000f\u0010'\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u00105J\b\u00106\u001a\u00020\u0010H\u0016J\b\u00107\u001a\u00020\u0010H\u0016J\b\u00108\u001a\u00020\u0010H\u0016J\b\u00109\u001a\u00020\u0010H\u0016J\b\u0010:\u001a\u00020\u0010H\u0016J\b\u0010;\u001a\u00020\u0010H\u0016J\b\u0010<\u001a\u00020\u0010H\u0016J\b\u0010=\u001a\u00020\u0010H\u0016J\b\u0010>\u001a\u00020\u0010H\u0016J\b\u0010?\u001a\u00020\u0010H\u0016J\b\u0010@\u001a\u00020\u0010H\u0016J\b\u0010A\u001a\u00020\u0010H\u0016J\b\u0010B\u001a\u00020\u0010H\u0016J\b\u0010C\u001a\u00020\u0010H\u0016J\b\u0010D\u001a\u00020\u0010H\u0016J\b\u0010E\u001a\u00020\u0010H\u0016J\b\u0010F\u001a\u00020\u0010H\u0016J\b\u0010G\u001a\u00020\u0010H\u0016J\b\u0010H\u001a\u00020\u0010H\u0016J\b\u0010I\u001a\u00020\u0010H\u0016J\b\u0010J\u001a\u00020\u0005H\u0016J\b\u0010K\u001a\u00020\u0005H\u0016J\b\u0010L\u001a\u00020\u0005H\u0016J\b\u0010M\u001a\u00020\u0005H\u0016J\b\u0010N\u001a\u00020\u0005H\u0016J\b\u0010O\u001a\u00020\u0005H\u0016J\b\u0010P\u001a\u00020\u0010H\u0016J\b\u0010Q\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\b\u0010R\u001a\u00020\u0010H\u0016J\b\u0010S\u001a\u00020\u0010H\u0016J\b\u0010T\u001a\u00020\u0010H\u0016J\b\u0010U\u001a\u00020\u0010H\u0016J\b\u0010V\u001a\u00020\u0010H\u0016J\b\u0010W\u001a\u00020\u0010H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010X\u001a\u00020\u0010H\u0016J\b\u0010Y\u001a\u00020\u0010H\u0016J\b\u0010Z\u001a\u00020\u0012H\u0016J\u000f\u0010[\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\\J\u0010\u0010]\u001a\u00020^2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u0010\u0010_\u001a\u00020^2\u0006\u0010`\u001a\u00020\u0010H\u0016J\u0010\u0010a\u001a\u00020^2\u0006\u0010b\u001a\u00020\u0012H\u0016J\b\u0010c\u001a\u00020\u0010H\u0016J\b\u0010d\u001a\u00020\u0010H\u0016J\b\u0010e\u001a\u00020\u0010H\u0016J\b\u0010f\u001a\u00020\u0010H\u0016J\b\u0010g\u001a\u00020\u0010H\u0016J\b\u0010h\u001a\u00020\u0010H\u0016J\b\u0010i\u001a\u00020\u0010H\u0016J\b\u0010j\u001a\u00020\u0010H\u0016J\b\u0010k\u001a\u00020\u0010H\u0016J\b\u0010l\u001a\u00020\u0010H\u0016J\u0012\u0010m\u001a\u00020\u00102\b\u0010n\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010o\u001a\u00020\u0010H\u0016J\b\u0010p\u001a\u00020\u0010H\u0016J\b\u0010q\u001a\u00020\u0010H\u0016J\b\u0010r\u001a\u00020\u0010H\u0016J\b\u0010s\u001a\u00020tH\u0016J\n\u0010u\u001a\u0004\u0018\u00010&H\u0016J\u000f\u0010v\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\\J\t\u0010w\u001a\u00020\u0005HÂ\u0003J\t\u0010x\u001a\u00020\u0005HÂ\u0003J\t\u0010y\u001a\u00020\u0005HÂ\u0003J\t\u0010z\u001a\u00020\u0005HÂ\u0003J\t\u0010{\u001a\u00020\u0005HÂ\u0003J\t\u0010|\u001a\u00020\u0005HÂ\u0003J\t\u0010}\u001a\u00020\u0005HÂ\u0003J\t\u0010~\u001a\u00020\u0005HÂ\u0003J\t\u0010\u007f\u001a\u00020\u0005HÂ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0010HÂ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0012HÂ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0005HÂ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0010HÂ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0010HÂ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0005HÂ\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0005HÂ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0010HÂ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0010HÂ\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0010HÂ\u0003J\u001a\u0010\u008b\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u001cj\b\u0012\u0004\u0012\u00020\u0012`\u001dHÂ\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0012HÂ\u0003J\n\u0010\u008d\u0001\u001a\u00020 HÂ\u0003J\n\u0010\u008e\u0001\u001a\u00020\"HÂ\u0003J\n\u0010\u008f\u0001\u001a\u00020$HÂ\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010&HÂ\u0003J\u0011\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0010HÂ\u0003¢\u0006\u0002\u00105J\u0011\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0005HÂ\u0003¢\u0006\u0002\u0010\\J¾\u0002\u0010\u0093\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u00102\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u001cj\b\u0012\u0004\u0012\u00020\u0012`\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0003\u0010\u0094\u0001J\u0016\u0010\u0095\u0001\u001a\u00020\u00102\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001HÖ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0005HÖ\u0001J\n\u0010\u0099\u0001\u001a\u00020\u0012HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u001cj\b\u0012\u0004\u0012\u00020\u0012`\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010/R\u0012\u0010(\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u00100¨\u0006\u009d\u0001"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/permission/doc/DocPublicPermission;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;", "shareExternalEntity", "", "linkShareEntityV2", "searchEntity", "commentEntity", "shareEntity", "managerCollaboratorEntity", "securityEntity", "copyEntity", "showCollaboratorInfo", "externalAccessEntity", "hasLinkPassword", "", "linkPassword", "", "applyEmbedEntity", "leaderCopySwitch", "isOwner", "ownerPermType", "adminExternalAccessEntity", "anonymousVerify", "lockState", "canUnlock", "partnerTenantIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reportPublicPermJson", "permType", "Lcom/bytedance/ee/bear/middleground/permission/permission/doc/PermType;", "blockOptions", "Lcom/bytedance/ee/bear/middleground/permission/permission/doc/BlockOptions;", "blockOptionsV2", "Lcom/bytedance/ee/bear/middleground/permission/permission/doc/BlockOptionsV2;", "configInfo", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission$ConfigInfo;", "hasModifiedLinkShare", "visibilityStatus", "<init>", "(IIIIIIIIIIZLjava/lang/String;IZZIIZZZLjava/util/ArrayList;Ljava/lang/String;Lcom/bytedance/ee/bear/middleground/permission/permission/doc/PermType;Lcom/bytedance/ee/bear/middleground/permission/permission/doc/BlockOptions;Lcom/bytedance/ee/bear/middleground/permission/permission/doc/BlockOptionsV2;Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission$ConfigInfo;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getExternalAccessEntity", "()I", "setExternalAccessEntity", "(I)V", "Ljava/lang/Boolean;", "Ljava/lang/Integer;", "isLinkShareClose", "isLinkShareInternalRead", "isLinkShareInternalEdit", "isLinkShareAnyoneRead", "()Ljava/lang/Boolean;", "isLinkShareAnyoneEdit", "isLinkSharePartnerTenantRead", "isLinkSharePartnerTenantEdit", "isSearchableTenant", "isSearchableKnownLink", "isOpenLinkWithRead", "isOpenLinkWithEdit", "isOpenLinkWithFA", "isCommentWithRead", "isCommentWithEdit", "isSecurityWithRead", "isSecurityWithEdit", "isSecurityWithFA", "isCopyWithRead", "isCopyWithEdit", "isCopyWithFA", "canLeaderCopy", "isShowCollaboratorInfoRead", "isShowCollaboratorInfoEdit", "isShowCollaboratorInfoFA", "getLinkShareAnyoneReadBlockValue", "getLinkShareAnyoneEditBlockValue", "getLinkSharePartnerTenantReadBlockValue", "getLinkSharePartnerTenantEditBlockValue", "getExternalAccessOpenBlockValue", "getExternalAccessCloseBlockValue", "canExternalAccessOpenEscape", "getPartnerTenantAccessBlockValue", "isSinglePageOwner", "isContainerOwner", "adminCanCross", "adminPartnerTenantCross", "externalAccess", "partnerTenantCross", "isLock", "canUnLock", "getReportJson", "getVisibilityStatus", "()Ljava/lang/Integer;", "setOwner", "", "setHasPassword", "hasPassword", "setPassword", "password", "isManagerCollaboratorTenant", "isManagerCollaboratorAnyone", "isManagerCollaboratorWithRead", "isManagerCollaboratorWithEdit", "isManagerCollaboratorWithFA", "isShareExternalWithRead", "isShareExternalWithEdit", "isShareExternalWithFA", "isExternalAccessPermTypeSinglePage", "isLinkSharePermTypeSinglePage", "isPartnerTenant", "tenantId", "isShareOnlyMe", "inviteExternal", "isShareInternal", "isShareAnyone", "getBlockOptions", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/BlockOptions;", "getConfigInfo", "getLinkShareEntityV2", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "copy", "(IIIIIIIIIIZLjava/lang/String;IZZIIZZZLjava/util/ArrayList;Ljava/lang/String;Lcom/bytedance/ee/bear/middleground/permission/permission/doc/PermType;Lcom/bytedance/ee/bear/middleground/permission/permission/doc/BlockOptions;Lcom/bytedance/ee/bear/middleground/permission/permission/doc/BlockOptionsV2;Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission$ConfigInfo;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/bytedance/ee/bear/middleground/permission/permission/doc/DocPublicPermission;", "equals", "other", "", "hashCode", "toString", "Companion", "LinkSharePermissionV1", "SearchEntity", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocPublicPermission extends Result<Serializable> implements IDocPublicPermission {
    public static final a Companion = null;
    public static final int MANAGER_COLLABORATOR_ANYONE = 2;
    public static final int MANAGER_COLLABORATOR_TENANT = 1;
    private int adminExternalAccessEntity;
    private boolean anonymousVerify;
    private int applyEmbedEntity;
    private final BlockOptions blockOptions;
    private final BlockOptionsV2 blockOptionsV2;
    private boolean canUnlock;
    private int commentEntity;
    private IDocPublicPermission.ConfigInfo configInfo;
    private int copyEntity;
    private int externalAccessEntity;
    private boolean hasLinkPassword;
    private Boolean hasModifiedLinkShare;
    private boolean isOwner;
    private boolean leaderCopySwitch;
    private String linkPassword;
    private int linkShareEntityV2;
    private boolean lockState;
    private int managerCollaboratorEntity;
    private int ownerPermType;
    private ArrayList<String> partnerTenantIds;
    private final PermType permType;
    private String reportPublicPermJson;
    private int searchEntity;
    private int securityEntity;
    private int shareEntity;
    private int shareExternalEntity;
    private int showCollaboratorInfo;
    private Integer visibilityStatus;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DocPublicPermission() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, null, 0, false, false, 0, 0, false, false, false, null, null, null, null, null, null, null, null, 268435455, null);
    }

    private final int component1() {
        return this.shareExternalEntity;
    }

    private final boolean component11() {
        return this.hasLinkPassword;
    }

    private final String component12() {
        return this.linkPassword;
    }

    private final int component13() {
        return this.applyEmbedEntity;
    }

    private final boolean component14() {
        return this.leaderCopySwitch;
    }

    private final boolean component15() {
        return this.isOwner;
    }

    private final int component16() {
        return this.ownerPermType;
    }

    private final int component17() {
        return this.adminExternalAccessEntity;
    }

    private final boolean component18() {
        return this.anonymousVerify;
    }

    private final boolean component19() {
        return this.lockState;
    }

    private final int component2() {
        return this.linkShareEntityV2;
    }

    private final boolean component20() {
        return this.canUnlock;
    }

    private final ArrayList<String> component21() {
        return this.partnerTenantIds;
    }

    private final String component22() {
        return this.reportPublicPermJson;
    }

    private final PermType component23() {
        return this.permType;
    }

    private final BlockOptions component24() {
        return this.blockOptions;
    }

    private final BlockOptionsV2 component25() {
        return this.blockOptionsV2;
    }

    private final IDocPublicPermission.ConfigInfo component26() {
        return this.configInfo;
    }

    private final Boolean component27() {
        return this.hasModifiedLinkShare;
    }

    private final Integer component28() {
        return this.visibilityStatus;
    }

    private final int component3() {
        return this.searchEntity;
    }

    private final int component4() {
        return this.commentEntity;
    }

    private final int component5() {
        return this.shareEntity;
    }

    private final int component6() {
        return this.managerCollaboratorEntity;
    }

    private final int component7() {
        return this.securityEntity;
    }

    private final int component8() {
        return this.copyEntity;
    }

    private final int component9() {
        return this.showCollaboratorInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DocPublicPermission copy$default(DocPublicPermission r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, int r26, int r27, boolean r28, String r29, int r30, boolean r31, boolean r32, int r33, int r34, boolean r35, boolean r36, boolean r37, ArrayList r38, String r39, PermType r40, BlockOptions r41, BlockOptionsV2 r42, IDocPublicPermission.ConfigInfo r43, Boolean r44, Integer r45, int r46, Object r47) {
        if ((r46 & 1) == 0) goto L5;
        int r2 = r17.shareExternalEntity;
    L7:
        if ((r46 & 2) == 0) goto L9;
        int r3 = r17.linkShareEntityV2;
    L11:
        if ((r46 & 4) == 0) goto L13;
        int r4 = r17.searchEntity;
    L15:
        if ((r46 & 8) == 0) goto L17;
        int r5 = r17.commentEntity;
    L19:
        if ((r46 & 16) == 0) goto L21;
        int r6 = r17.shareEntity;
    L23:
        if ((r46 & 32) == 0) goto L25;
        int r7 = r17.managerCollaboratorEntity;
    L27:
        if ((r46 & 64) == 0) goto L29;
        int r8 = r17.securityEntity;
    L31:
        if ((r46 & 128) == 0) goto L33;
        int r9 = r17.copyEntity;
    L35:
        if ((r46 & 256) == 0) goto L37;
        int r10 = r17.showCollaboratorInfo;
    L39:
        if ((r46 & 512) == 0) goto L41;
        int r11 = r17.externalAccessEntity;
    L43:
        if ((r46 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L45;
        boolean r12 = r17.hasLinkPassword;
    L47:
        if ((r46 & DocUserPermission.USER_PREVIEW) == 0) goto L49;
        String r13 = r17.linkPassword;
    L51:
        if ((r46 & DocUserPermission.USER_PERCEIVE) == 0) goto L53;
        int r14 = r17.applyEmbedEntity;
    L55:
        if ((r46 & 8192) == 0) goto L57;
        boolean r15 = r17.leaderCopySwitch;
    L58:
        boolean r310 = r15;
        if ((r46 & 16384) == 0) goto L61;
        boolean r16 = r17.isOwner;
    L62:
        boolean r311 = r16;
        if ((r46 & 32768) == 0) goto L65;
        int r110 = r17.ownerPermType;
    L66:
        int r312 = r110;
        if ((r46 & 65536) == 0) goto L69;
        int r111 = r17.adminExternalAccessEntity;
    L70:
        int r313 = r111;
        if ((r46 & 131072) == 0) goto L73;
        boolean r112 = r17.anonymousVerify;
    L74:
        boolean r314 = r112;
        if ((r46 & 262144) == 0) goto L77;
        boolean r113 = r17.lockState;
    L78:
        boolean r315 = r113;
        if ((r46 & 524288) == 0) goto L81;
        boolean r114 = r17.canUnlock;
    L82:
        boolean r316 = r114;
        if ((r46 & 1048576) == 0) goto L85;
        ArrayList r115 = r17.partnerTenantIds;
    L86:
        ArrayList r317 = r115;
        if ((r46 & 2097152) == 0) goto L89;
        String r116 = r17.reportPublicPermJson;
    L90:
        String r318 = r116;
        if ((r46 & 4194304) == 0) goto L93;
        PermType r117 = r17.permType;
    L94:
        PermType r48 = r117;
        if ((r46 & 8388608) == 0) goto L97;
        BlockOptions r118 = r17.blockOptions;
    L98:
        BlockOptions r49 = r118;
        if ((r46 & 16777216) == 0) goto L101;
        BlockOptionsV2 r119 = r17.blockOptionsV2;
    L102:
        BlockOptionsV2 r410 = r119;
        if ((r46 & 33554432) == 0) goto L105;
        IDocPublicPermission.ConfigInfo r120 = r17.configInfo;
    L106:
        IDocPublicPermission.ConfigInfo r411 = r120;
        if ((r46 & 67108864) == 0) goto L109;
        Boolean r121 = r17.hasModifiedLinkShare;
    L111:
        if ((r46 & 134217728) == 0) goto L113;
        Integer r1 = r17.visibilityStatus;
    L115:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r48, r49, r410, r411, r121, r1);
    L113:
        r1 = r45;
        goto L115
    L109:
        r121 = r44;
        goto L111
    L105:
        r120 = r43;
        goto L106
    L101:
        r119 = r42;
        goto L102
    L97:
        r118 = r41;
        goto L98
    L93:
        r117 = r40;
        goto L94
    L89:
        r116 = r39;
        goto L90
    L85:
        r115 = r38;
        goto L86
    L81:
        r114 = r37;
        goto L82
    L77:
        r113 = r36;
        goto L78
    L73:
        r112 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final int component10() {
        return this.externalAccessEntity;
    }

    public final DocPublicPermission copy(int r31, int r32, int r33, int r34, int r35, int r36, int r37, int r38, int r39, int r40, boolean r41, String r42, int r43, boolean r44, boolean r45, int r46, int r47, boolean r48, boolean r49, boolean r50, ArrayList<String> r51, String r52, PermType r53, BlockOptions r54, BlockOptionsV2 r55, IDocPublicPermission.ConfigInfo r56, Boolean r57, Integer r58) {
        Intrinsics.checkNotNullParameter(r42, "linkPassword");
        Intrinsics.checkNotNullParameter(r51, "partnerTenantIds");
        Intrinsics.checkNotNullParameter(r52, "reportPublicPermJson");
        Intrinsics.checkNotNullParameter(r53, "permType");
        Intrinsics.checkNotNullParameter(r54, "blockOptions");
        Intrinsics.checkNotNullParameter(r55, "blockOptionsV2");
        return new DocPublicPermission(r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DocPublicPermission) == true) goto L8;
        return false;
    L8:
        DocPublicPermission r6 = (DocPublicPermission) r5;
        if (this.shareExternalEntity == r6.shareExternalEntity) goto L12;
        return false;
    L12:
        if (this.linkShareEntityV2 == r6.linkShareEntityV2) goto L15;
        return false;
    L15:
        if (this.searchEntity == r6.searchEntity) goto L18;
        return false;
    L18:
        if (this.commentEntity == r6.commentEntity) goto L21;
        return false;
    L21:
        if (this.shareEntity == r6.shareEntity) goto L24;
        return false;
    L24:
        if (this.managerCollaboratorEntity == r6.managerCollaboratorEntity) goto L27;
        return false;
    L27:
        if (this.securityEntity == r6.securityEntity) goto L30;
        return false;
    L30:
        if (this.copyEntity == r6.copyEntity) goto L33;
        return false;
    L33:
        if (this.showCollaboratorInfo == r6.showCollaboratorInfo) goto L36;
        return false;
    L36:
        if (this.externalAccessEntity == r6.externalAccessEntity) goto L39;
        return false;
    L39:
        if (this.hasLinkPassword == r6.hasLinkPassword) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.linkPassword, r6.linkPassword) == true) goto L45;
        return false;
    L45:
        if (this.applyEmbedEntity == r6.applyEmbedEntity) goto L48;
        return false;
    L48:
        if (this.leaderCopySwitch == r6.leaderCopySwitch) goto L51;
        return false;
    L51:
        if (this.isOwner == r6.isOwner) goto L54;
        return false;
    L54:
        if (this.ownerPermType == r6.ownerPermType) goto L57;
        return false;
    L57:
        if (this.adminExternalAccessEntity == r6.adminExternalAccessEntity) goto L60;
        return false;
    L60:
        if (this.anonymousVerify == r6.anonymousVerify) goto L63;
        return false;
    L63:
        if (this.lockState == r6.lockState) goto L66;
        return false;
    L66:
        if (this.canUnlock == r6.canUnlock) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.partnerTenantIds, r6.partnerTenantIds) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.reportPublicPermJson, r6.reportPublicPermJson) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.permType, r6.permType) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.blockOptions, r6.blockOptions) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.blockOptionsV2, r6.blockOptionsV2) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.configInfo, r6.configInfo) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.hasModifiedLinkShare, r6.hasModifiedLinkShare) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.visibilityStatus, r6.visibilityStatus) == true) goto L92;
        return false;
    L92:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((((((((((this.shareExternalEntity * 31) + this.linkShareEntityV2) * 31) + this.searchEntity) * 31) + this.commentEntity) * 31) + this.shareEntity) * 31) + this.managerCollaboratorEntity) * 31) + this.securityEntity) * 31) + this.copyEntity) * 31) + this.showCollaboratorInfo) * 31) + this.externalAccessEntity) * 31;
        int r2 = 1231;
        if (this.hasLinkPassword == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((((r0 + r1) * 31) + this.linkPassword.hashCode()) * 31) + this.applyEmbedEntity) * 31;
        if (this.leaderCopySwitch == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.isOwner == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (((((r5 + r6) * 31) + this.ownerPermType) * 31) + this.adminExternalAccessEntity) * 31;
        if (this.anonymousVerify == false) goto L17;
        int r8 = 1231;
    L18:
        int r9 = (r7 + r8) * 31;
        if (this.lockState == false) goto L21;
        int r10 = 1231;
    L22:
        int r11 = (r9 + r10) * 31;
        if (this.canUnlock == true) goto L26;
        r2 = 1237;
    L26:
        int r12 = (((((((((((r11 + r2) * 31) + this.partnerTenantIds.hashCode()) * 31) + this.reportPublicPermJson.hashCode()) * 31) + this.permType.hashCode()) * 31) + this.blockOptions.hashCode()) * 31) + this.blockOptionsV2.hashCode()) * 31;
        IDocPublicPermission.ConfigInfo r13 = this.configInfo;
        int r14 = 0;
        if (r13 != null) goto L29;
        int r15 = 0;
    L30:
        int r16 = (r12 + r15) * 31;
        Boolean r17 = this.hasModifiedLinkShare;
        if (r17 != null) goto L33;
        int r18 = 0;
    L34:
        int r19 = (r16 + r18) * 31;
        Integer r20 = this.visibilityStatus;
        if (r20 == null) goto L39;
        r14 = r20.hashCode();
    L39:
        return r19 + r14;
    L33:
        r18 = r17.hashCode();
        goto L34
    L29:
        r15 = r13.hashCode();
        goto L30
    L21:
        r10 = 1237;
        goto L22
    L17:
        r8 = 1237;
        goto L18
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

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean inviteExternal() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isShareAnyone() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isShareInternal() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isShareOnlyMe() {
        return false;
    }

    public String toString() {
        return "DocPublicPermission(shareExternalEntity=" + this.shareExternalEntity + ", linkShareEntityV2=" + this.linkShareEntityV2 + ", searchEntity=" + this.searchEntity + ", commentEntity=" + this.commentEntity + ", shareEntity=" + this.shareEntity + ", managerCollaboratorEntity=" + this.managerCollaboratorEntity + ", securityEntity=" + this.securityEntity + ", copyEntity=" + this.copyEntity + ", showCollaboratorInfo=" + this.showCollaboratorInfo + ", externalAccessEntity=" + this.externalAccessEntity + ", hasLinkPassword=" + this.hasLinkPassword + ", linkPassword=" + this.linkPassword + ", applyEmbedEntity=" + this.applyEmbedEntity + ", leaderCopySwitch=" + this.leaderCopySwitch + ", isOwner=" + this.isOwner + ", ownerPermType=" + this.ownerPermType + ", adminExternalAccessEntity=" + this.adminExternalAccessEntity + ", anonymousVerify=" + this.anonymousVerify + ", lockState=" + this.lockState + ", canUnlock=" + this.canUnlock + ", partnerTenantIds=" + this.partnerTenantIds + ", reportPublicPermJson=" + this.reportPublicPermJson + ", permType=" + this.permType + ", blockOptions=" + this.blockOptions + ", blockOptionsV2=" + this.blockOptionsV2 + ", configInfo=" + this.configInfo + ", hasModifiedLinkShare=" + this.hasModifiedLinkShare + ", visibilityStatus=" + this.visibilityStatus + ')';
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean adminCanCross() {
        if (this.adminExternalAccessEntity == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean adminPartnerTenantCross() {
        if (this.adminExternalAccessEntity != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean externalAccess() {
        if (this.externalAccessEntity == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public Integer getLinkShareEntityV2() {
        return Integer.valueOf(this.linkShareEntityV2);
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isCommentWithEdit() {
        if (this.commentEntity != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isCommentWithRead() {
        if (this.commentEntity != CollaboratorPermissionType.READ_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isContainerOwner() {
        int r0 = hj5.a.a;
        int r1 = this.ownerPermType;
        if (r1 == 0) goto L8;
        if (r1 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isCopyWithEdit() {
        if (this.copyEntity != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isCopyWithFA() {
        if (this.copyEntity != CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isCopyWithRead() {
        if (this.copyEntity != CollaboratorPermissionType.READ_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isExternalAccessPermTypeSinglePage() {
        if (this.permType.getExternalAccessSwitch() != TypePermissionScope.SINGLE_PAGE.getTypeValue().intValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isLinkShareAnyoneEdit() {
        if (this.linkShareEntityV2 != 5) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isLinkShareAnyoneRead() {
        if (this.linkShareEntityV2 != 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isLinkShareClose() {
        if (this.linkShareEntityV2 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isLinkShareInternalEdit() {
        if (this.linkShareEntityV2 != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isLinkShareInternalRead() {
        if (this.linkShareEntityV2 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isLinkSharePartnerTenantEdit() {
        if (this.linkShareEntityV2 != 7) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isLinkSharePartnerTenantRead() {
        if (this.linkShareEntityV2 != 6) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isLinkSharePermTypeSinglePage() {
        if (this.permType.getLinkShareEntity() != TypePermissionScope.SINGLE_PAGE.getTypeValue().intValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isManagerCollaboratorAnyone() {
        if (this.shareEntity != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isManagerCollaboratorTenant() {
        if (this.shareEntity == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isManagerCollaboratorWithEdit() {
        if (this.managerCollaboratorEntity != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isManagerCollaboratorWithFA() {
        if (this.managerCollaboratorEntity != CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isManagerCollaboratorWithRead() {
        if (this.managerCollaboratorEntity != CollaboratorPermissionType.READ_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isOpenLinkWithEdit() {
        if (this.applyEmbedEntity != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isOpenLinkWithFA() {
        if (this.applyEmbedEntity != CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isOpenLinkWithRead() {
        if (this.applyEmbedEntity != CollaboratorPermissionType.READ_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isSearchableKnownLink() {
        if (this.searchEntity != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isSearchableTenant() {
        if (this.searchEntity == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isSecurityWithEdit() {
        if (this.securityEntity != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isSecurityWithFA() {
        if (this.securityEntity != CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isSecurityWithRead() {
        if (this.securityEntity != CollaboratorPermissionType.READ_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isShareExternalWithEdit() {
        if (this.shareExternalEntity != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isShareExternalWithFA() {
        if (this.shareExternalEntity != CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isShareExternalWithRead() {
        if (this.shareExternalEntity != CollaboratorPermissionType.READ_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isShowCollaboratorInfoEdit() {
        if (this.showCollaboratorInfo != CollaboratorPermissionType.EDIT_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isShowCollaboratorInfoFA() {
        if (this.showCollaboratorInfo != CollaboratorPermissionType.FULL_ACCESS_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isShowCollaboratorInfoRead() {
        if (this.showCollaboratorInfo != CollaboratorPermissionType.READ_PERM.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isSinglePageOwner() {
        int r0 = hj5.a.a;
        if (this.ownerPermType != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean partnerTenantCross() {
        if (this.externalAccessEntity != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean canExternalAccessOpenEscape() {
        if (b.n() == true) goto L7;
        return false;
    L7:
        return this.blockOptionsV2.canExternalAccessOpenEscape();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public int getExternalAccessCloseBlockValue() {
        if (b.n() == false) goto L6;
        return this.blockOptionsV2.getExternalAccessCloseBlockValue();
    L6:
        return this.blockOptions.getExternalAccessCloseBlockValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public int getExternalAccessOpenBlockValue() {
        if (b.n() == false) goto L6;
        return this.blockOptionsV2.getExternalAccessOpenBlockValue();
    L6:
        return this.blockOptions.getExternalAccessOpenBlockValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public int getLinkShareAnyoneEditBlockValue() {
        if (b.n() == false) goto L6;
        return this.blockOptionsV2.getLinkShareAnyoneEditBlockValue();
    L6:
        return this.blockOptions.getLinkShareAnyoneEditBlockValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public int getLinkShareAnyoneReadBlockValue() {
        if (b.n() == false) goto L6;
        return this.blockOptionsV2.getLinkShareAnyoneReadBlockValue();
    L6:
        return this.blockOptions.getLinkShareAnyoneReadBlockValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public int getLinkSharePartnerTenantEditBlockValue() {
        if (b.n() == false) goto L6;
        return this.blockOptionsV2.getLinkSharePartnerTenantEditBlockValue();
    L6:
        return this.blockOptions.getLinkSharePartnerTenantEditBlockValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public int getLinkSharePartnerTenantReadBlockValue() {
        if (b.n() == false) goto L6;
        return this.blockOptionsV2.getLinkSharePartnerTenantReadBlockValue();
    L6:
        return this.blockOptions.getLinkSharePartnerTenantReadBlockValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public int getPartnerTenantAccessBlockValue() {
        if (b.n() == false) goto L6;
        return this.blockOptionsV2.getPartnerTenantAccessBlockValue();
    L6:
        return this.blockOptions.getPartnerTenantAccessBlockValue();
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean anonymousVerify() {
        return this.anonymousVerify;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean canLeaderCopy() {
        return this.leaderCopySwitch;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean canUnLock() {
        return this.canUnlock;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public com.bytedance.ee.bear.middleground_permission_export.model.folder.BlockOptions getBlockOptions() {
        return this.blockOptions;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public IDocPublicPermission.ConfigInfo getConfigInfo() {
        return this.configInfo;
    }

    public final int getExternalAccessEntity() {
        return this.externalAccessEntity;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public String getReportJson() {
        return this.reportPublicPermJson;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public Integer getVisibilityStatus() {
        return this.visibilityStatus;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean hasLinkPassword() {
        return this.hasLinkPassword;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public Boolean hasModifiedLinkShare() {
        return this.hasModifiedLinkShare;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isLock() {
        return this.lockState;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isOwner() {
        return this.isOwner;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public String linkPassword() {
        return this.linkPassword;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public boolean isPartnerTenant(String r4) {
        Iterator<String> r0 = this.partnerTenantIds.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        String r1 = r0.next();
        if (TextUtils.isEmpty(r1) == true) goto L4;
        if (TextUtils.equals(r1, r4) == false) goto L4;
        return true;
    L11:
        return false;
    }

    public final void setExternalAccessEntity(int r1) {
        this.externalAccessEntity = r1;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public void setHasPassword(boolean r1) {
        this.hasLinkPassword = r1;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public void setOwner(boolean r1) {
        this.isOwner = r1;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public void setPassword(String r2) {
        Intrinsics.checkNotNullParameter(r2, "password");
        this.linkPassword = r2;
    }

    public DocPublicPermission(int r9, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, boolean r19, String r20, int r21, boolean r22, boolean r23, int r24, int r25, boolean r26, boolean r27, boolean r28, ArrayList<String> r29, String r30, PermType r31, BlockOptions r32, BlockOptionsV2 r33, IDocPublicPermission.ConfigInfo r34, Boolean r35, Integer r36) {
        Intrinsics.checkNotNullParameter(r20, "linkPassword");
        Intrinsics.checkNotNullParameter(r29, "partnerTenantIds");
        Intrinsics.checkNotNullParameter(r30, "reportPublicPermJson");
        Intrinsics.checkNotNullParameter(r31, "permType");
        Intrinsics.checkNotNullParameter(r32, "blockOptions");
        Intrinsics.checkNotNullParameter(r33, "blockOptionsV2");
        this.shareExternalEntity = r9;
        this.linkShareEntityV2 = r10;
        this.searchEntity = r11;
        this.commentEntity = r12;
        this.shareEntity = r13;
        this.managerCollaboratorEntity = r14;
        this.securityEntity = r15;
        this.copyEntity = r16;
        this.showCollaboratorInfo = r17;
        this.externalAccessEntity = r18;
        this.hasLinkPassword = r19;
        this.linkPassword = r20;
        this.applyEmbedEntity = r21;
        this.leaderCopySwitch = r22;
        this.isOwner = r23;
        this.ownerPermType = r24;
        this.adminExternalAccessEntity = r25;
        this.anonymousVerify = r26;
        this.lockState = r27;
        this.canUnlock = r28;
        this.partnerTenantIds = r29;
        this.reportPublicPermJson = r30;
        this.permType = r31;
        this.blockOptions = r32;
        this.blockOptionsV2 = r33;
        this.configInfo = r34;
        this.hasModifiedLinkShare = r35;
        this.visibilityStatus = r36;
    }

    public /* synthetic */ DocPublicPermission(int r39, int r40, int r41, int r42, int r43, int r44, int r45, int r46, int r47, int r48, boolean r49, String r50, int r51, boolean r52, boolean r53, int r54, int r55, boolean r56, boolean r57, boolean r58, ArrayList r59, String r60, PermType r61, BlockOptions r62, BlockOptionsV2 r63, IDocPublicPermission.ConfigInfo r64, Boolean r65, Integer r66, int r67, DefaultConstructorMarker r68) {
        if ((r67 & 1) == 0) goto L5;
        int r1 = 0;
    L7:
        if ((r67 & 2) == 0) goto L9;
        int r3 = 0;
    L11:
        if ((r67 & 4) == 0) goto L13;
        int r4 = 0;
    L15:
        if ((r67 & 8) == 0) goto L17;
        int r5 = 0;
    L19:
        if ((r67 & 16) == 0) goto L21;
        int r6 = 0;
    L23:
        if ((r67 & 32) == 0) goto L25;
        int r7 = 0;
    L27:
        if ((r67 & 64) == 0) goto L29;
        int r8 = 0;
    L31:
        if ((r67 & 128) == 0) goto L33;
        int r9 = 0;
    L35:
        if ((r67 & 256) == 0) goto L37;
        int r10 = 0;
    L39:
        if ((r67 & 512) == 0) goto L41;
        int r11 = 0;
    L43:
        if ((r67 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L45;
        boolean r12 = false;
    L47:
        if ((r67 & DocUserPermission.USER_PREVIEW) == 0) goto L49;
        String r13 = "";
    L51:
        if ((r67 & DocUserPermission.USER_PERCEIVE) == 0) goto L53;
        int r15 = 0;
    L55:
        if ((r67 & 8192) == 0) goto L57;
        boolean r2 = false;
    L59:
        if ((r67 & 16384) == 0) goto L61;
        boolean r14 = false;
    L63:
        if ((r67 & 32768) == 0) goto L65;
        int r16 = 0;
    L67:
        if ((r67 & 65536) == 0) goto L69;
        int r17 = 0;
    L71:
        if ((r67 & 131072) == 0) goto L73;
        boolean r18 = false;
    L75:
        if ((r67 & 262144) == 0) goto L77;
        boolean r19 = false;
    L79:
        if ((r67 & 524288) == 0) goto L81;
        boolean r20 = false;
    L83:
        if ((r67 & 1048576) == 0) goto L85;
        ArrayList r21 = new ArrayList();
    L87:
        if ((r67 & 2097152) == 0) goto L89;
        String r22 = "";
    L91:
        if ((r67 & 4194304) == 0) goto L93;
        PermType r23 = new PermType(0, 0, 0, 7, null);
    L95:
        if ((r67 & 8388608) == 0) goto L97;
        BlockOptions r24 = new BlockOptions(null, null, null, null, null, null, null, null, null, null, 1023, null);
    L99:
        if ((r67 & 16777216) == 0) goto L101;
        BlockOptionsV2 r25 = new BlockOptionsV2(null, null, null, null, null, null, null, null, null, null, 1023, null);
    L102:
        Integer r27 = null;
        if ((r67 & 33554432) == 0) goto L105;
        IDocPublicPermission.ConfigInfo r26 = null;
    L107:
        if ((r67 & 67108864) == 0) goto L109;
        Boolean r28 = null;
    L111:
        if ((r67 & 134217728) != 0) goto L114;
        r27 = r66;
    L114:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r2, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r27);
        return;
    L109:
        r28 = r65;
        goto L111
    L105:
        r26 = r64;
        goto L107
    L101:
        r25 = r63;
        goto L102
    L97:
        r24 = r62;
        goto L99
    L93:
        r23 = r61;
        goto L95
    L89:
        r22 = r60;
        goto L91
    L85:
        r21 = r59;
        goto L87
    L81:
        r20 = r58;
        goto L83
    L77:
        r19 = r57;
        goto L79
    L73:
        r18 = r56;
        goto L75
    L69:
        r17 = r55;
        goto L71
    L65:
        r16 = r54;
        goto L67
    L61:
        r14 = r53;
        goto L63
    L57:
        r2 = r52;
        goto L59
    L53:
        r15 = r51;
        goto L55
    L49:
        r13 = r50;
        goto L51
    L45:
        r12 = r49;
        goto L47
    L41:
        r11 = r48;
        goto L43
    L37:
        r10 = r47;
        goto L39
    L33:
        r9 = r46;
        goto L35
    L29:
        r8 = r45;
        goto L31
    L25:
        r7 = r44;
        goto L27
    L21:
        r6 = r43;
        goto L23
    L17:
        r5 = r42;
        goto L19
    L13:
        r4 = r41;
        goto L15
    L9:
        r3 = r40;
        goto L11
    L5:
        r1 = r39;
        goto L7
    }
}
