package com.bytedance.ee.bear.more.protocol3.checker;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.more.protocol3.j;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class UserPermissionChecker extends j {
    public final UserPermissionType e;

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
        public static final /* synthetic */ UserPermissionType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<UserPermissionType> getEntries() {
            return b;
        }

        static {
            UserPermissionType r0 = new UserPermissionType("CanRead", 0);
            CanRead = r0;
            UserPermissionType r1 = new UserPermissionType("CanComment", 1);
            CanComment = r1;
            UserPermissionType r3 = new UserPermissionType("CanEdit", 2);
            CanEdit = r3;
            UserPermissionType r5 = new UserPermissionType("CanCopy", 3);
            CanCopy = r5;
            UserPermissionType r7 = new UserPermissionType("CanExport", 4);
            CanExport = r7;
            UserPermissionType r9 = new UserPermissionType("CanManageCollaborator", 5);
            CanManageCollaborator = r9;
            UserPermissionType r11 = new UserPermissionType("CanManagePermissionMeta", 6);
            CanManagePermissionMeta = r11;
            UserPermissionType r13 = new UserPermissionType("CanCreateSubNode", 7);
            CanCreateSubNode = r13;
            UserPermissionType r15 = new UserPermissionType("CanUpload", 8);
            CanUpload = r15;
            UserPermissionType r14 = new UserPermissionType("CanDownload", 9);
            CanDownload = r14;
            UserPermissionType r12 = new UserPermissionType("CanOperateEntity", 10);
            CanOperateEntity = r12;
            UserPermissionType r10 = new UserPermissionType("CanInviteFullAccess", 11);
            CanInviteFullAccess = r10;
            UserPermissionType r8 = new UserPermissionType("CanInviteEdit", 12);
            CanInviteEdit = r8;
            UserPermissionType r6 = new UserPermissionType("CanInviteView", 13);
            CanInviteView = r6;
            UserPermissionType r4 = new UserPermissionType("CanInviteSinglePageFullAccess", 14);
            CanInviteSinglePageFullAccess = r4;
            UserPermissionType r2 = new UserPermissionType("CanInviteSinglePageEdit", 15);
            CanInviteSinglePageEdit = r2;
            UserPermissionType r16 = new UserPermissionType("CanInviteSinglePageView", 16);
            CanInviteSinglePageView = r16;
            UserPermissionType r17 = new UserPermissionType("CanMoveThisNode", 17);
            CanMoveThisNode = r17;
            UserPermissionType r18 = new UserPermissionType("CanMoveSubNode", 18);
            CanMoveSubNode = r18;
            UserPermissionType r19 = new UserPermissionType("CanMoveToHere", 19);
            CanMoveToHere = r19;
            UserPermissionType r20 = new UserPermissionType("CanManageContainerCollaborator", 20);
            CanManageContainerCollaborator = r20;
            UserPermissionType r21 = new UserPermissionType("CanManageContainerPermissionMeta", 21);
            CanManageContainerPermissionMeta = r21;
            UserPermissionType r22 = new UserPermissionType("CanManageSinglePageCollaborator", 22);
            CanManageSinglePageCollaborator = r22;
            UserPermissionType r23 = new UserPermissionType("CanManageSinglePagePermissionMeta", 23);
            CanManageSinglePagePermissionMeta = r23;
            UserPermissionType r24 = new UserPermissionType("CanVisitSecretLevel", 24);
            CanVisitSecretLevel = r24;
            UserPermissionType r25 = new UserPermissionType("CanModifySecretLevel", 25);
            CanModifySecretLevel = r25;
            UserPermissionType r26 = new UserPermissionType("CanCreateCopy", 26);
            CanCreateCopy = r26;
            UserPermissionType r27 = new UserPermissionType("CanSecretCopy", 27);
            CanSecretCopy = r27;
            UserPermissionType[] r28 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27};
            a = r28;
            b = EnumEntriesKt.enumEntries(r28);
        }

        public static UserPermissionType[] values() {
            return (UserPermissionType[]) a.clone();
        }

        public static UserPermissionType valueOf(String r1) {
            return (UserPermissionType) r27.a.a(UserPermissionType.class, r1);
        }

        public UserPermissionType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UserPermissionType.values().length];
            r0[UserPermissionType.CanRead.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L79:
            r0[UserPermissionType.CanComment.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L89:
            r0[UserPermissionType.CanEdit.ordinal()] = 3;     // Catch: NoSuchFieldError -> L35
        L95:
            r0[UserPermissionType.CanCopy.ordinal()] = 4;     // Catch: NoSuchFieldError -> L36
        L99:
            r0[UserPermissionType.CanExport.ordinal()] = 5;     // Catch: NoSuchFieldError -> L37
        L103:
            r0[UserPermissionType.CanManageCollaborator.ordinal()] = 6;     // Catch: NoSuchFieldError -> L38
        L113:
            r0[UserPermissionType.CanManagePermissionMeta.ordinal()] = 7;     // Catch: NoSuchFieldError -> L39
        L69:
            r0[UserPermissionType.CanCreateSubNode.ordinal()] = 8;     // Catch: NoSuchFieldError -> L40
        L81:
            r0[UserPermissionType.CanUpload.ordinal()] = 9;     // Catch: NoSuchFieldError -> L41
        L83:
            r0[UserPermissionType.CanDownload.ordinal()] = 10;     // Catch: NoSuchFieldError -> L42
        L91:
            r0[UserPermissionType.CanOperateEntity.ordinal()] = 11;     // Catch: NoSuchFieldError -> L43
        L107:
            r0[UserPermissionType.CanInviteFullAccess.ordinal()] = 12;     // Catch: NoSuchFieldError -> L44
        L115:
            r0[UserPermissionType.CanInviteEdit.ordinal()] = 13;     // Catch: NoSuchFieldError -> L45
        L61:
            r0[UserPermissionType.CanInviteView.ordinal()] = 14;     // Catch: NoSuchFieldError -> L46
        L67:
            r0[UserPermissionType.CanInviteSinglePageFullAccess.ordinal()] = 15;     // Catch: NoSuchFieldError -> L47
        L87:
            r0[UserPermissionType.CanInviteSinglePageEdit.ordinal()] = 16;     // Catch: NoSuchFieldError -> L48
        L93:
            r0[UserPermissionType.CanInviteSinglePageView.ordinal()] = 17;     // Catch: NoSuchFieldError -> L49
        L97:
            r0[UserPermissionType.CanMoveThisNode.ordinal()] = 18;     // Catch: NoSuchFieldError -> L50
        L105:
            r0[UserPermissionType.CanMoveSubNode.ordinal()] = 19;     // Catch: NoSuchFieldError -> L51
        L65:
            r0[UserPermissionType.CanMoveToHere.ordinal()] = 20;     // Catch: NoSuchFieldError -> L52
        L73:
            r0[UserPermissionType.CanManageContainerCollaborator.ordinal()] = 21;     // Catch: NoSuchFieldError -> L53
        L75:
            r0[UserPermissionType.CanManageContainerPermissionMeta.ordinal()] = 22;     // Catch: NoSuchFieldError -> L54
        L85:
            r0[UserPermissionType.CanManageSinglePageCollaborator.ordinal()] = 23;     // Catch: NoSuchFieldError -> L55
        L101:
            r0[UserPermissionType.CanManageSinglePagePermissionMeta.ordinal()] = 24;     // Catch: NoSuchFieldError -> L56
        L109:
            r0[UserPermissionType.CanVisitSecretLevel.ordinal()] = 25;     // Catch: NoSuchFieldError -> L57
        L111:
            r0[UserPermissionType.CanModifySecretLevel.ordinal()] = 26;     // Catch: NoSuchFieldError -> L58
        L63:
            r0[UserPermissionType.CanCreateCopy.ordinal()] = 27;     // Catch: NoSuchFieldError -> L59
        L77:
            r0[UserPermissionType.CanSecretCopy.ordinal()] = 28;     // Catch: NoSuchFieldError -> L60
        L31:
            a = r0;
        }
    }

    @Override // com.bytedance.ee.bear.more.protocol3.j
    public final int c() {
        return 2131887803;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.j
    public final boolean e() {
        oj5.c r0 = d();
        if (r0 != null) goto L5;
        return false;
    L5:
        IDocUserPermission r1 = r0.c().a;
        UserPermissionType r2 = this.e;
        switch(a.a[r2.ordinal()]) {
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
        if (r1.isSecretFileCopy() == true) goto L40;
        return true;
    L40:
        return false;
    L42:
        return r1.canCreateCopy();
    L43:
        return r1.canModifySecretLevel();
    L44:
        return r1.canVisitSecretLevel();
    L45:
        return r1.canManageSinglePagePermissionMeta();
    L46:
        return r1.canManageSinglePageCollaborator();
    L47:
        return r1.canManageContainerPermissionMeta();
    L48:
        return r1.canManageContainerCollaborator();
    L49:
        return r1.canMoveToHere();
    L50:
        return r1.canMoveSubNode();
    L51:
        return r1.canMoveThisNode();
    L52:
        return r1.canInviteSinglePageView();
    L53:
        return r1.canInviteSinglePageEdit();
    L54:
        return r1.canInviteSinglePageFullAccess();
    L55:
        return r1.canInviteView();
    L56:
        return r1.canInviteEdit();
    L57:
        return r1.canInviteFullAccess();
    L58:
        return r1.canOperateEntity();
    L59:
        return r1.canDownload();
    L60:
        return r1.canUpload();
    L61:
        return r1.canCreateSubNode();
    L62:
        return r1.canManagePermissionMeta();
    L63:
        return r1.canManageCollaborator();
    L64:
        return r1.canExport();
    L65:
        return r1.canCopy();
    L66:
        return r1.canEdit();
    L67:
        return r1.canComment();
    L39:
        return r1.canInviteFullAccess();
    }

    public UserPermissionChecker(UserPermissionType r2) {
        Intrinsics.checkNotNullParameter(r2, "permissionType");
        this.e = r2;
    }
}
