package com.bytedance.ee.bear.share.export;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum ShareMemberGroupType extends Enum<ShareMemberGroupType> {
    public static final ShareMemberGroupType GROUP_MEMBER = null;
    public static final ShareMemberGroupType GROUP_TITLE = null;
    public static final /* synthetic */ ShareMemberGroupType[] a = null;
    int type;

    static {
        ShareMemberGroupType r0 = new ShareMemberGroupType("GROUP_TITLE", 0, 0);
        GROUP_TITLE = r0;
        ShareMemberGroupType r1 = new ShareMemberGroupType("GROUP_MEMBER", 1, 1);
        GROUP_MEMBER = r1;
        a = new ShareMemberGroupType[]{r0, r1};
    }

    public static ShareMemberGroupType[] values() {
        return (ShareMemberGroupType[]) a.clone();
    }

    public int getType() {
        return this.type;
    }

    public static ShareMemberGroupType valueOf(String r1) {
        return (ShareMemberGroupType) r27.a.a(ShareMemberGroupType.class, r1);
    }

    public ShareMemberGroupType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
