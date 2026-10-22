package com.bytedance.ee.bear.middleground_permission_export.model;

/* JADX INFO: loaded from: classes18.dex */
public final class ShareFolderUtils {

    public static final enum ShareFolderRoleType extends Enum<ShareFolderRoleType> {
        public static final ShareFolderRoleType Manager = null;
        public static final ShareFolderRoleType Member = null;
        public static final ShareFolderRoleType Visitor = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ShareFolderRoleType[] f234418a = null;
        private int permission;

        static {
            ShareFolderRoleType r100 = new ShareFolderRoleType("Manager", 0, 1);
            Manager = r100;
            ShareFolderRoleType r101 = new ShareFolderRoleType("Member", 1, 2);
            Member = r101;
            ShareFolderRoleType r102 = new ShareFolderRoleType("Visitor", 2, 3);
            Visitor = r102;
            f234418a = new ShareFolderRoleType[]{r100, r101, r102};
        }

        public static ShareFolderRoleType[] values() {
            return (ShareFolderRoleType[]) f234418a.clone();
        }

        public int getPermission() {
            return this.permission;
        }

        public static ShareFolderRoleType valueOf(String r100) {
            return (ShareFolderRoleType) r27.a.a(ShareFolderRoleType.class, r100);
        }

        public ShareFolderRoleType(String r100, int r101, int r102) {
            super(r100, r101);
            this.permission = r102;
        }
    }

    public static int a() {
        return ShareFolderRoleType.Manager.getPermission();
    }
}
