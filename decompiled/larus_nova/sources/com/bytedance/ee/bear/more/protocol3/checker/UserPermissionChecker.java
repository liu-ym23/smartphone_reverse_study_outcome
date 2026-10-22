package com.bytedance.ee.bear.more.protocol3.checker;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.more.protocol3.j;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class UserPermissionChecker extends j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final UserPermissionType f234784e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/more/protocol3/checker/UserPermissionChecker$UserPermissionType;", "", "<init>", "(Ljava/lang/String;I)V", "CanRead", "CanComment", "CanEdit", "CanCopy", "CanExport", "CanManageCollaborator", "CanManagePermissionMeta", "CanCreateSubNode", "CanUpload", "CanDownload", "CanOperateEntity", "CanInviteFullAccess", "CanInviteEdit", "CanInviteView", "CanInviteSinglePageFullAccess", "CanInviteSinglePageEdit", "CanInviteSinglePageView", "CanMoveThisNode", "CanMoveSubNode", "CanMoveToHere", "CanManageContainerCollaborator", "CanManageContainerPermissionMeta", "CanManageSinglePageCollaborator", "CanManageSinglePagePermissionMeta", "CanVisitSecretLevel", "CanModifySecretLevel", "CanCreateCopy", "CanSecretCopy", "features-more-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum UserPermissionType extends Enum<UserPermissionType> {
        public static final UserPermissionType CanComment = null;
        public static final UserPermissionType CanCopy = null;
        public static final UserPermissionType CanCreateCopy = null;
        public static final UserPermissionType CanCreateSubNode = null;
        public static final UserPermissionType CanDownload = null;
        public static final UserPermissionType CanEdit = null;
        public static final UserPermissionType CanExport = null;
        public static final UserPermissionType CanInviteEdit = null;
        public static final UserPermissionType CanInviteFullAccess = null;
        public static final UserPermissionType CanInviteSinglePageEdit = null;
        public static final UserPermissionType CanInviteSinglePageFullAccess = null;
        public static final UserPermissionType CanInviteSinglePageView = null;
        public static final UserPermissionType CanInviteView = null;
        public static final UserPermissionType CanManageCollaborator = null;
        public static final UserPermissionType CanManageContainerCollaborator = null;
        public static final UserPermissionType CanManageContainerPermissionMeta = null;
        public static final UserPermissionType CanManagePermissionMeta = null;
        public static final UserPermissionType CanManageSinglePageCollaborator = null;
        public static final UserPermissionType CanManageSinglePagePermissionMeta = null;
        public static final UserPermissionType CanModifySecretLevel = null;
        public static final UserPermissionType CanMoveSubNode = null;
        public static final UserPermissionType CanMoveThisNode = null;
        public static final UserPermissionType CanMoveToHere = null;
        public static final UserPermissionType CanOperateEntity = null;
        public static final UserPermissionType CanRead = null;
        public static final UserPermissionType CanSecretCopy = null;
        public static final UserPermissionType CanUpload = null;
        public static final UserPermissionType CanVisitSecretLevel = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UserPermissionType[] f234785a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f234786b = null;

        public static EnumEntries<UserPermissionType> getEntries() {
            return f234786b;
        }

        static {
            UserPermissionType r100 = new UserPermissionType("CanRead", 0);
            CanRead = r100;
            UserPermissionType r101 = new UserPermissionType("CanComment", 1);
            CanComment = r101;
            UserPermissionType r102 = new UserPermissionType("CanEdit", 2);
            CanEdit = r102;
            UserPermissionType r103 = new UserPermissionType("CanCopy", 3);
            CanCopy = r103;
            UserPermissionType r104 = new UserPermissionType("CanExport", 4);
            CanExport = r104;
            UserPermissionType r105 = new UserPermissionType("CanManageCollaborator", 5);
            CanManageCollaborator = r105;
            UserPermissionType r110 = new UserPermissionType("CanManagePermissionMeta", 6);
            CanManagePermissionMeta = r110;
            UserPermissionType r111 = new UserPermissionType("CanCreateSubNode", 7);
            CanCreateSubNode = r111;
            UserPermissionType r112 = new UserPermissionType("CanUpload", 8);
            CanUpload = r112;
            UserPermissionType r113 = new UserPermissionType("CanDownload", 9);
            CanDownload = r113;
            UserPermissionType r114 = new UserPermissionType("CanOperateEntity", 10);
            CanOperateEntity = r114;
            UserPermissionType r115 = new UserPermissionType("CanInviteFullAccess", 11);
            CanInviteFullAccess = r115;
            UserPermissionType r106 = new UserPermissionType("CanInviteEdit", 12);
            CanInviteEdit = r106;
            UserPermissionType r107 = new UserPermissionType("CanInviteView", 13);
            CanInviteView = r107;
            UserPermissionType r108 = new UserPermissionType("CanInviteSinglePageFullAccess", 14);
            CanInviteSinglePageFullAccess = r108;
            UserPermissionType r109 = new UserPermissionType("CanInviteSinglePageEdit", 15);
            CanInviteSinglePageEdit = r109;
            UserPermissionType r116 = new UserPermissionType("CanInviteSinglePageView", 16);
            CanInviteSinglePageView = r116;
            UserPermissionType r117 = new UserPermissionType("CanMoveThisNode", 17);
            CanMoveThisNode = r117;
            UserPermissionType r118 = new UserPermissionType("CanMoveSubNode", 18);
            CanMoveSubNode = r118;
            UserPermissionType r119 = new UserPermissionType("CanMoveToHere", 19);
            CanMoveToHere = r119;
            UserPermissionType r120 = new UserPermissionType("CanManageContainerCollaborator", 20);
            CanManageContainerCollaborator = r120;
            UserPermissionType r121 = new UserPermissionType("CanManageContainerPermissionMeta", 21);
            CanManageContainerPermissionMeta = r121;
            UserPermissionType r122 = new UserPermissionType("CanManageSinglePageCollaborator", 22);
            CanManageSinglePageCollaborator = r122;
            UserPermissionType r123 = new UserPermissionType("CanManageSinglePagePermissionMeta", 23);
            CanManageSinglePagePermissionMeta = r123;
            UserPermissionType r124 = new UserPermissionType("CanVisitSecretLevel", 24);
            CanVisitSecretLevel = r124;
            UserPermissionType r125 = new UserPermissionType("CanModifySecretLevel", 25);
            CanModifySecretLevel = r125;
            UserPermissionType r126 = new UserPermissionType("CanCreateCopy", 26);
            CanCreateCopy = r126;
            UserPermissionType r127 = new UserPermissionType("CanSecretCopy", 27);
            CanSecretCopy = r127;
            UserPermissionType[] r128 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127};
            f234785a = r128;
            f234786b = EnumEntriesKt.enumEntries(r128);
        }

        public static UserPermissionType[] values() {
            return (UserPermissionType[]) f234785a.clone();
        }

        public static UserPermissionType valueOf(String r100) {
            return (UserPermissionType) r27.a.a(UserPermissionType.class, r100);
        }

        public UserPermissionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f234787a = null;

        static {
            int[] r100 = new int[UserPermissionType.values().length];
            r100[UserPermissionType.CanRead.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L79:
            r100[UserPermissionType.CanComment.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L89:
            r100[UserPermissionType.CanEdit.ordinal()] = 3;     // Catch: NoSuchFieldError -> L35
        L95:
            r100[UserPermissionType.CanCopy.ordinal()] = 4;     // Catch: NoSuchFieldError -> L36
        L99:
            r100[UserPermissionType.CanExport.ordinal()] = 5;     // Catch: NoSuchFieldError -> L37
        L103:
            r100[UserPermissionType.CanManageCollaborator.ordinal()] = 6;     // Catch: NoSuchFieldError -> L38
        L113:
            r100[UserPermissionType.CanManagePermissionMeta.ordinal()] = 7;     // Catch: NoSuchFieldError -> L39
        L69:
            r100[UserPermissionType.CanCreateSubNode.ordinal()] = 8;     // Catch: NoSuchFieldError -> L40
        L81:
            r100[UserPermissionType.CanUpload.ordinal()] = 9;     // Catch: NoSuchFieldError -> L41
        L83:
            r100[UserPermissionType.CanDownload.ordinal()] = 10;     // Catch: NoSuchFieldError -> L42
        L91:
            r100[UserPermissionType.CanOperateEntity.ordinal()] = 11;     // Catch: NoSuchFieldError -> L43
        L107:
            r100[UserPermissionType.CanInviteFullAccess.ordinal()] = 12;     // Catch: NoSuchFieldError -> L44
        L115:
            r100[UserPermissionType.CanInviteEdit.ordinal()] = 13;     // Catch: NoSuchFieldError -> L45
        L61:
            r100[UserPermissionType.CanInviteView.ordinal()] = 14;     // Catch: NoSuchFieldError -> L46
        L67:
            r100[UserPermissionType.CanInviteSinglePageFullAccess.ordinal()] = 15;     // Catch: NoSuchFieldError -> L47
        L87:
            r100[UserPermissionType.CanInviteSinglePageEdit.ordinal()] = 16;     // Catch: NoSuchFieldError -> L48
        L93:
            r100[UserPermissionType.CanInviteSinglePageView.ordinal()] = 17;     // Catch: NoSuchFieldError -> L49
        L97:
            r100[UserPermissionType.CanMoveThisNode.ordinal()] = 18;     // Catch: NoSuchFieldError -> L50
        L105:
            r100[UserPermissionType.CanMoveSubNode.ordinal()] = 19;     // Catch: NoSuchFieldError -> L51
        L65:
            r100[UserPermissionType.CanMoveToHere.ordinal()] = 20;     // Catch: NoSuchFieldError -> L52
        L73:
            r100[UserPermissionType.CanManageContainerCollaborator.ordinal()] = 21;     // Catch: NoSuchFieldError -> L53
        L75:
            r100[UserPermissionType.CanManageContainerPermissionMeta.ordinal()] = 22;     // Catch: NoSuchFieldError -> L54
        L85:
            r100[UserPermissionType.CanManageSinglePageCollaborator.ordinal()] = 23;     // Catch: NoSuchFieldError -> L55
        L101:
            r100[UserPermissionType.CanManageSinglePagePermissionMeta.ordinal()] = 24;     // Catch: NoSuchFieldError -> L56
        L109:
            r100[UserPermissionType.CanVisitSecretLevel.ordinal()] = 25;     // Catch: NoSuchFieldError -> L57
        L111:
            r100[UserPermissionType.CanModifySecretLevel.ordinal()] = 26;     // Catch: NoSuchFieldError -> L58
        L63:
            r100[UserPermissionType.CanCreateCopy.ordinal()] = 27;     // Catch: NoSuchFieldError -> L59
        L77:
            r100[UserPermissionType.CanSecretCopy.ordinal()] = 28;     // Catch: NoSuchFieldError -> L60
        L31:
            f234787a = r100;
        }
    }

    @Override // com.bytedance.ee.bear.more.protocol3.j
    public final int c() {
        return R.string.Doc_Facade_OperateFailedNoPermission;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.j
    public final boolean e() {
        oj5.c r100 = d();
        if (r100 != null) goto L5;
        return false;
    L5:
        IDocUserPermission r101 = r100.c().f234419a;
        UserPermissionType r102 = this.f234784e;
        switch(a.f234787a[r102.ordinal()]) {
            case 1: goto L39;
            case 2: goto L67;
            case 3: goto L66;
            case 4: goto L65;
            case 5: goto L64;
            case 6: goto L63;
            case 7: goto L62;
            case 8: goto L61;
            case 9: goto L60;
            case 10: goto L59;
            case 11: goto L58;
            case 12: goto L57;
            case 13: goto L56;
            case 14: goto L55;
            case 15: goto L54;
            case 16: goto L53;
            case 17: goto L52;
            case 18: goto L51;
            case 19: goto L50;
            case 20: goto L49;
            case 21: goto L48;
            case 22: goto L47;
            case 23: goto L46;
            case 24: goto L45;
            case 25: goto L44;
            case 26: goto L43;
            case 27: goto L42;
            case 28: goto L10;
            default: goto L8;
        };
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        if (r101.isSecretFileCopy() == true) goto L40;
        return true;
    L40:
        return false;
    L42:
        return r101.canCreateCopy();
    L43:
        return r101.canModifySecretLevel();
    L44:
        return r101.canVisitSecretLevel();
    L45:
        return r101.canManageSinglePagePermissionMeta();
    L46:
        return r101.canManageSinglePageCollaborator();
    L47:
        return r101.canManageContainerPermissionMeta();
    L48:
        return r101.canManageContainerCollaborator();
    L49:
        return r101.canMoveToHere();
    L50:
        return r101.canMoveSubNode();
    L51:
        return r101.canMoveThisNode();
    L52:
        return r101.canInviteSinglePageView();
    L53:
        return r101.canInviteSinglePageEdit();
    L54:
        return r101.canInviteSinglePageFullAccess();
    L55:
        return r101.canInviteView();
    L56:
        return r101.canInviteEdit();
    L57:
        return r101.canInviteFullAccess();
    L58:
        return r101.canOperateEntity();
    L59:
        return r101.canDownload();
    L60:
        return r101.canUpload();
    L61:
        return r101.canCreateSubNode();
    L62:
        return r101.canManagePermissionMeta();
    L63:
        return r101.canManageCollaborator();
    L64:
        return r101.canExport();
    L65:
        return r101.canCopy();
    L66:
        return r101.canEdit();
    L67:
        return r101.canComment();
    L39:
        return r101.canInviteFullAccess();
    }

    public UserPermissionChecker(UserPermissionType r100) {
        Intrinsics.checkNotNullParameter(r100, "permissionType");
        this.f234784e = r100;
    }
}
