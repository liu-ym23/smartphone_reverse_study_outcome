package com.bytedance.ee.bear.middleground.comment.export;

/* JADX INFO: loaded from: classes18.dex */
public final enum MentionUserState extends Enum<MentionUserState> {
    public static final MentionUserState NO_PERMISSION_SHARABLE = null;
    public static final MentionUserState NO_PERMISSION_UNSHARABLE_ASK_OWNER = null;
    public static final MentionUserState NO_PERMISSION_UNSHARABLE_RESIGNED = null;
    public static final MentionUserState PERMITTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MentionUserState[] f231341a = null;

    static {
        MentionUserState r100 = new MentionUserState("PERMITTED", 0);
        PERMITTED = r100;
        MentionUserState r101 = new MentionUserState("NO_PERMISSION_SHARABLE", 1);
        NO_PERMISSION_SHARABLE = r101;
        MentionUserState r102 = new MentionUserState("NO_PERMISSION_UNSHARABLE_RESIGNED", 2);
        NO_PERMISSION_UNSHARABLE_RESIGNED = r102;
        MentionUserState r103 = new MentionUserState("NO_PERMISSION_UNSHARABLE_ASK_OWNER", 3);
        NO_PERMISSION_UNSHARABLE_ASK_OWNER = r103;
        f231341a = new MentionUserState[]{r100, r101, r102, r103};
    }

    public static MentionUserState[] values() {
        return (MentionUserState[]) f231341a.clone();
    }

    public static MentionUserState valueOf(String r100) {
        return (MentionUserState) r27.a.a(MentionUserState.class, r100);
    }

    public MentionUserState(String r100, int r101) {
        super(r100, r101);
    }
}
