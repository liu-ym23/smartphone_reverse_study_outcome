package com.bytedance.ee.bear.share.export;

/* JADX INFO: loaded from: classes18.dex */
public final enum ShareMemberGroupType extends Enum<ShareMemberGroupType> {
    public static final ShareMemberGroupType GROUP_MEMBER = null;
    public static final ShareMemberGroupType GROUP_TITLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShareMemberGroupType[] f237019a = null;
    int type;

    static {
        ShareMemberGroupType r100 = new ShareMemberGroupType("GROUP_TITLE", 0, 0);
        GROUP_TITLE = r100;
        ShareMemberGroupType r101 = new ShareMemberGroupType("GROUP_MEMBER", 1, 1);
        GROUP_MEMBER = r101;
        f237019a = new ShareMemberGroupType[]{r100, r101};
    }

    public static ShareMemberGroupType[] values() {
        return (ShareMemberGroupType[]) f237019a.clone();
    }

    public int getType() {
        return this.type;
    }

    public static ShareMemberGroupType valueOf(String r100) {
        return (ShareMemberGroupType) r27.a.a(ShareMemberGroupType.class, r100);
    }

    public ShareMemberGroupType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
