package com.bytedance.ee.bear.middleground.permission.permission.doc;

import android.text.TextUtils;
import com.autonavi.amap.mapcore.AMapEngineUtils;
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

/* JADX INFO: loaded from: classes18.dex */
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
    public static /* synthetic */ DocPublicPermission copy$default(DocPublicPermission r110, int r111, int r112, int r210, int r211, int r212, int r213, int r214, int r215, int r216, int r217, boolean r218, String r219, int r310, boolean r311, boolean r312, int r313, int r314, boolean r315, boolean r316, boolean r317, ArrayList r318, String r319, PermType r410, BlockOptions r411, BlockOptionsV2 r412, IDocPublicPermission.ConfigInfo r413, Boolean r414, Integer r415, int r416, Object r417) {
        if ((r416 & 1) == 0) goto L5;
        int r100 = r110.shareExternalEntity;
    L7:
        if ((r416 & 2) == 0) goto L9;
        int r101 = r110.linkShareEntityV2;
    L11:
        if ((r416 & 4) == 0) goto L13;
        int r102 = r110.searchEntity;
    L15:
        if ((r416 & 8) == 0) goto L17;
        int r103 = r110.commentEntity;
    L19:
        if ((r416 & 16) == 0) goto L21;
        int r104 = r110.shareEntity;
    L23:
        if ((r416 & 32) == 0) goto L25;
        int r105 = r110.managerCollaboratorEntity;
    L27:
        if ((r416 & 64) == 0) goto L29;
        int r106 = r110.securityEntity;
    L31:
        if ((r416 & 128) == 0) goto L33;
        int r107 = r110.copyEntity;
    L35:
        if ((r416 & 256) == 0) goto L37;
        int r113 = r110.showCollaboratorInfo;
    L39:
        if ((r416 & 512) == 0) goto L41;
        int r114 = r110.externalAccessEntity;
    L43:
        if ((r416 & 1024) == 0) goto L45;
        boolean r115 = r110.hasLinkPassword;
    L47:
        if ((r416 & 2048) == 0) goto L49;
        String r116 = r110.linkPassword;
    L51:
        if ((r416 & 4096) == 0) goto L53;
        int r117 = r110.applyEmbedEntity;
    L55:
        if ((r416 & 8192) == 0) goto L57;
        boolean r118 = r110.leaderCopySwitch;
    L58:
        boolean r320 = r118;
        if ((r416 & 16384) == 0) goto L61;
        boolean r119 = r110.isOwner;
    L62:
        boolean r321 = r119;
        if ((r416 & 32768) == 0) goto L65;
        int r120 = r110.ownerPermType;
    L66:
        int r322 = r120;
        if ((r416 & 65536) == 0) goto L69;
        int r121 = r110.adminExternalAccessEntity;
    L70:
        int r323 = r121;
        if ((r416 & 131072) == 0) goto L73;
        boolean r122 = r110.anonymousVerify;
    L74:
        boolean r324 = r122;
        if ((r416 & 262144) == 0) goto L77;
        boolean r123 = r110.lockState;
    L78:
        boolean r325 = r123;
        if ((r416 & 524288) == 0) goto L81;
        boolean r124 = r110.canUnlock;
    L82:
        boolean r326 = r124;
        if ((r416 & 1048576) == 0) goto L85;
        ArrayList r125 = r110.partnerTenantIds;
    L86:
        ArrayList r327 = r125;
        if ((r416 & 2097152) == 0) goto L89;
        String r126 = r110.reportPublicPermJson;
    L90:
        String r328 = r126;
        if ((r416 & 4194304) == 0) goto L93;
        PermType r127 = r110.permType;
    L94:
        PermType r418 = r127;
        if ((r416 & 8388608) == 0) goto L97;
        BlockOptions r128 = r110.blockOptions;
    L98:
        BlockOptions r419 = r128;
        if ((r416 & 16777216) == 0) goto L101;
        BlockOptionsV2 r129 = r110.blockOptionsV2;
    L102:
        BlockOptionsV2 r420 = r129;
        if ((r416 & 33554432) == 0) goto L105;
        IDocPublicPermission.ConfigInfo r130 = r110.configInfo;
    L106:
        IDocPublicPermission.ConfigInfo r421 = r130;
        if ((r416 & 67108864) == 0) goto L109;
        Boolean r131 = r110.hasModifiedLinkShare;
    L111:
        if ((r416 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        Integer r108 = r110.visibilityStatus;
    L115:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r418, r419, r420, r421, r131, r108);
    L113:
        r108 = r415;
        goto L115
    L109:
        r131 = r414;
        goto L111
    L105:
        r130 = r413;
        goto L106
    L101:
        r129 = r412;
        goto L102
    L97:
        r128 = r411;
        goto L98
    L93:
        r127 = r410;
        goto L94
    L89:
        r126 = r319;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component10() {
        return this.externalAccessEntity;
    }

    public final DocPublicPermission copy(int r310, int r311, int r312, int r313, int r314, int r315, int r316, int r317, int r318, int r410, boolean r411, String r412, int r413, boolean r414, boolean r415, int r416, int r417, boolean r418, boolean r419, boolean r510, ArrayList<String> r511, String r512, PermType r513, BlockOptions r514, BlockOptionsV2 r515, IDocPublicPermission.ConfigInfo r516, Boolean r517, Integer r518) {
        Intrinsics.checkNotNullParameter(r412, "linkPassword");
        Intrinsics.checkNotNullParameter(r511, "partnerTenantIds");
        Intrinsics.checkNotNullParameter(r512, "reportPublicPermJson");
        Intrinsics.checkNotNullParameter(r513, "permType");
        Intrinsics.checkNotNullParameter(r514, "blockOptions");
        Intrinsics.checkNotNullParameter(r515, "blockOptionsV2");
        return new DocPublicPermission(r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocPublicPermission) == true) goto L8;
        return false;
    L8:
        DocPublicPermission r101 = (DocPublicPermission) r100;
        if (this.shareExternalEntity == r101.shareExternalEntity) goto L12;
        return false;
    L12:
        if (this.linkShareEntityV2 == r101.linkShareEntityV2) goto L15;
        return false;
    L15:
        if (this.searchEntity == r101.searchEntity) goto L18;
        return false;
    L18:
        if (this.commentEntity == r101.commentEntity) goto L21;
        return false;
    L21:
        if (this.shareEntity == r101.shareEntity) goto L24;
        return false;
    L24:
        if (this.managerCollaboratorEntity == r101.managerCollaboratorEntity) goto L27;
        return false;
    L27:
        if (this.securityEntity == r101.securityEntity) goto L30;
        return false;
    L30:
        if (this.copyEntity == r101.copyEntity) goto L33;
        return false;
    L33:
        if (this.showCollaboratorInfo == r101.showCollaboratorInfo) goto L36;
        return false;
    L36:
        if (this.externalAccessEntity == r101.externalAccessEntity) goto L39;
        return false;
    L39:
        if (this.hasLinkPassword == r101.hasLinkPassword) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.linkPassword, r101.linkPassword) == true) goto L45;
        return false;
    L45:
        if (this.applyEmbedEntity == r101.applyEmbedEntity) goto L48;
        return false;
    L48:
        if (this.leaderCopySwitch == r101.leaderCopySwitch) goto L51;
        return false;
    L51:
        if (this.isOwner == r101.isOwner) goto L54;
        return false;
    L54:
        if (this.ownerPermType == r101.ownerPermType) goto L57;
        return false;
    L57:
        if (this.adminExternalAccessEntity == r101.adminExternalAccessEntity) goto L60;
        return false;
    L60:
        if (this.anonymousVerify == r101.anonymousVerify) goto L63;
        return false;
    L63:
        if (this.lockState == r101.lockState) goto L66;
        return false;
    L66:
        if (this.canUnlock == r101.canUnlock) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.partnerTenantIds, r101.partnerTenantIds) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.reportPublicPermJson, r101.reportPublicPermJson) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.permType, r101.permType) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.blockOptions, r101.blockOptions) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.blockOptionsV2, r101.blockOptionsV2) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.configInfo, r101.configInfo) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.hasModifiedLinkShare, r101.hasModifiedLinkShare) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.visibilityStatus, r101.visibilityStatus) == true) goto L92;
        return false;
    L92:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((((((((((((this.shareExternalEntity * 31) + this.linkShareEntityV2) * 31) + this.searchEntity) * 31) + this.commentEntity) * 31) + this.shareEntity) * 31) + this.managerCollaboratorEntity) * 31) + this.securityEntity) * 31) + this.copyEntity) * 31) + this.showCollaboratorInfo) * 31) + this.externalAccessEntity) * 31;
        int r101 = 1231;
        if (this.hasLinkPassword == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.linkPassword.hashCode()) * 31) + this.applyEmbedEntity) * 31;
        if (this.leaderCopySwitch == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.isOwner == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (((((r105 + r106) * 31) + this.ownerPermType) * 31) + this.adminExternalAccessEntity) * 31;
        if (this.anonymousVerify == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.lockState == false) goto L21;
        int r110 = 1231;
    L22:
        int r111 = (r109 + r110) * 31;
        if (this.canUnlock == true) goto L26;
        r101 = 1237;
    L26:
        int r112 = (((((((((((r111 + r101) * 31) + this.partnerTenantIds.hashCode()) * 31) + this.reportPublicPermJson.hashCode()) * 31) + this.permType.hashCode()) * 31) + this.blockOptions.hashCode()) * 31) + this.blockOptionsV2.hashCode()) * 31;
        IDocPublicPermission.ConfigInfo r113 = this.configInfo;
        int r114 = 0;
        if (r113 != null) goto L29;
        int r115 = 0;
    L30:
        int r116 = (r112 + r115) * 31;
        Boolean r117 = this.hasModifiedLinkShare;
        if (r117 != null) goto L33;
        int r118 = 0;
    L34:
        int r119 = (r116 + r118) * 31;
        Integer r120 = this.visibilityStatus;
        if (r120 == null) goto L39;
        r114 = r120.hashCode();
    L39:
        return r119 + r114;
    L33:
        r118 = r117.hashCode();
        goto L34
    L29:
        r115 = r113.hashCode();
        goto L30
    L21:
        r110 = 1237;
        goto L22
    L17:
        r108 = 1237;
        goto L18
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
        int r100 = hj5.a.f485431a;
        int r101 = this.ownerPermType;
        if (r101 == 0) goto L8;
        if (r101 == 1) goto L9;
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
        if (this.permType.getExternalAccessSwitch() != TypePermissionScope.SINGLE_PAGE.m8352getTypeValue().intValue()) goto L5;
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
        if (this.permType.getLinkShareEntity() != TypePermissionScope.SINGLE_PAGE.m8352getTypeValue().intValue()) goto L5;
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
        int r100 = hj5.a.f485431a;
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
    public boolean isPartnerTenant(String r100) {
        Iterator<String> r101 = this.partnerTenantIds.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        String r102 = r101.next();
        if (TextUtils.isEmpty(r102) == true) goto L4;
        if (TextUtils.equals(r102, r100) == false) goto L4;
        return true;
    L11:
        return false;
    }

    public final void setExternalAccessEntity(int r100) {
        this.externalAccessEntity = r100;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public void setHasPassword(boolean r100) {
        this.hasLinkPassword = r100;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public void setOwner(boolean r100) {
        this.isOwner = r100;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission
    public void setPassword(String r100) {
        Intrinsics.checkNotNullParameter(r100, "password");
        this.linkPassword = r100;
    }

    public DocPublicPermission(int r100, int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118, boolean r119, String r210, int r211, boolean r212, boolean r213, int r214, int r215, boolean r216, boolean r217, boolean r218, ArrayList<String> r219, String r310, PermType r311, BlockOptions r312, BlockOptionsV2 r313, IDocPublicPermission.ConfigInfo r314, Boolean r315, Integer r316) {
        Intrinsics.checkNotNullParameter(r210, "linkPassword");
        Intrinsics.checkNotNullParameter(r219, "partnerTenantIds");
        Intrinsics.checkNotNullParameter(r310, "reportPublicPermJson");
        Intrinsics.checkNotNullParameter(r311, "permType");
        Intrinsics.checkNotNullParameter(r312, "blockOptions");
        Intrinsics.checkNotNullParameter(r313, "blockOptionsV2");
        this.shareExternalEntity = r100;
        this.linkShareEntityV2 = r110;
        this.searchEntity = r111;
        this.commentEntity = r112;
        this.shareEntity = r113;
        this.managerCollaboratorEntity = r114;
        this.securityEntity = r115;
        this.copyEntity = r116;
        this.showCollaboratorInfo = r117;
        this.externalAccessEntity = r118;
        this.hasLinkPassword = r119;
        this.linkPassword = r210;
        this.applyEmbedEntity = r211;
        this.leaderCopySwitch = r212;
        this.isOwner = r213;
        this.ownerPermType = r214;
        this.adminExternalAccessEntity = r215;
        this.anonymousVerify = r216;
        this.lockState = r217;
        this.canUnlock = r218;
        this.partnerTenantIds = r219;
        this.reportPublicPermJson = r310;
        this.permType = r311;
        this.blockOptions = r312;
        this.blockOptionsV2 = r313;
        this.configInfo = r314;
        this.hasModifiedLinkShare = r315;
        this.visibilityStatus = r316;
    }

    public /* synthetic */ DocPublicPermission(int r310, int r410, int r411, int r412, int r413, int r414, int r415, int r416, int r417, int r418, boolean r419, String r510, int r511, boolean r512, boolean r513, int r514, int r515, boolean r516, boolean r517, boolean r518, ArrayList r519, String r610, PermType r611, BlockOptions r612, BlockOptionsV2 r613, IDocPublicPermission.ConfigInfo r614, Boolean r615, Integer r616, int r617, DefaultConstructorMarker r618) {
        if ((r617 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r617 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r617 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r617 & 8) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r617 & 16) == 0) goto L21;
        int r104 = 0;
    L23:
        if ((r617 & 32) == 0) goto L25;
        int r105 = 0;
    L27:
        if ((r617 & 64) == 0) goto L29;
        int r106 = 0;
    L31:
        if ((r617 & 128) == 0) goto L33;
        int r107 = 0;
    L35:
        if ((r617 & 256) == 0) goto L37;
        int r110 = 0;
    L39:
        if ((r617 & 512) == 0) goto L41;
        int r111 = 0;
    L43:
        if ((r617 & 1024) == 0) goto L45;
        boolean r112 = false;
    L47:
        if ((r617 & 2048) == 0) goto L49;
        String r113 = "";
    L51:
        if ((r617 & 4096) == 0) goto L53;
        int r114 = 0;
    L55:
        if ((r617 & 8192) == 0) goto L57;
        boolean r108 = false;
    L59:
        if ((r617 & 16384) == 0) goto L61;
        boolean r115 = false;
    L63:
        if ((r617 & 32768) == 0) goto L65;
        int r116 = 0;
    L67:
        if ((r617 & 65536) == 0) goto L69;
        int r117 = 0;
    L71:
        if ((r617 & 131072) == 0) goto L73;
        boolean r118 = false;
    L75:
        if ((r617 & 262144) == 0) goto L77;
        boolean r119 = false;
    L79:
        if ((r617 & 524288) == 0) goto L81;
        boolean r210 = false;
    L83:
        if ((r617 & 1048576) == 0) goto L85;
        ArrayList r211 = new ArrayList();
    L87:
        if ((r617 & 2097152) == 0) goto L89;
        String r212 = "";
    L91:
        if ((r617 & 4194304) == 0) goto L93;
        PermType r213 = new PermType(0, 0, 0, 7, null);
    L95:
        if ((r617 & 8388608) == 0) goto L97;
        BlockOptions r214 = new BlockOptions(null, null, null, null, null, null, null, null, null, null, 1023, null);
    L99:
        if ((r617 & 16777216) == 0) goto L101;
        BlockOptionsV2 r215 = new BlockOptionsV2(null, null, null, null, null, null, null, null, null, null, 1023, null);
    L102:
        Integer r216 = null;
        if ((r617 & 33554432) == 0) goto L105;
        IDocPublicPermission.ConfigInfo r217 = null;
    L107:
        if ((r617 & 67108864) == 0) goto L109;
        Boolean r218 = null;
    L111:
        if ((r617 & AMapEngineUtils.HALF_MAX_P20_WIDTH) != 0) goto L114;
        r216 = r616;
    L114:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r108, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r217, r218, r216);
        return;
    L109:
        r218 = r615;
        goto L111
    L105:
        r217 = r614;
        goto L107
    L101:
        r215 = r613;
        goto L102
    L97:
        r214 = r612;
        goto L99
    L93:
        r213 = r611;
        goto L95
    L89:
        r212 = r610;
        goto L91
    L85:
        r211 = r519;
        goto L87
    L81:
        r210 = r518;
        goto L83
    L77:
        r119 = r517;
        goto L79
    L73:
        r118 = r516;
        goto L75
    L69:
        r117 = r515;
        goto L71
    L65:
        r116 = r514;
        goto L67
    L61:
        r115 = r513;
        goto L63
    L57:
        r108 = r512;
        goto L59
    L53:
        r114 = r511;
        goto L55
    L49:
        r113 = r510;
        goto L51
    L45:
        r112 = r419;
        goto L47
    L41:
        r111 = r418;
        goto L43
    L37:
        r110 = r417;
        goto L39
    L33:
        r107 = r416;
        goto L35
    L29:
        r106 = r415;
        goto L31
    L25:
        r105 = r414;
        goto L27
    L21:
        r104 = r413;
        goto L23
    L17:
        r103 = r412;
        goto L19
    L13:
        r102 = r411;
        goto L15
    L9:
        r101 = r410;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
