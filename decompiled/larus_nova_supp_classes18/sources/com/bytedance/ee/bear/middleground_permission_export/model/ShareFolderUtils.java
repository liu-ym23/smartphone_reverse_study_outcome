package com.bytedance.ee.bear.middleground_permission_export.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class ShareFolderUtils {

    public static final enum ShareFolderRoleType extends Enum<ShareFolderRoleType> {
        public static final ShareFolderRoleType Manager = null;
        public static final ShareFolderRoleType Member = null;
        public static final ShareFolderRoleType Visitor = null;
        public static final /* synthetic */ ShareFolderRoleType[] a = null;
        private int permission;

        static {
            ShareFolderRoleType r0 = new ShareFolderRoleType("Manager", 0, 1);
            Manager = r0;
            ShareFolderRoleType r1 = new ShareFolderRoleType("Member", 1, 2);
            Member = r1;
            ShareFolderRoleType r4 = new ShareFolderRoleType("Visitor", 2, 3);
            Visitor = r4;
            a = new ShareFolderRoleType[]{r0, r1, r4};
        }

        public static ShareFolderRoleType[] values() {
            return (ShareFolderRoleType[]) a.clone();
        }

        public int getPermission() {
            return this.permission;
        }

        public static ShareFolderRoleType valueOf(String r1) {
            return (ShareFolderRoleType) r27.a.a(ShareFolderRoleType.class, r1);
        }

        public ShareFolderRoleType(String r1, int r2, int r3) {
            super(r1, r2);
            this.permission = r3;
        }
    }

    public static int a() {
        return ShareFolderRoleType.Manager.getPermission();
    }
}
