package com.bytedance.ee.bear.middleground.comment.export;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum MentionUserState extends Enum<MentionUserState> {
    public static final MentionUserState NO_PERMISSION_SHARABLE = null;
    public static final MentionUserState NO_PERMISSION_UNSHARABLE_ASK_OWNER = null;
    public static final MentionUserState NO_PERMISSION_UNSHARABLE_RESIGNED = null;
    public static final MentionUserState PERMITTED = null;
    public static final /* synthetic */ MentionUserState[] a = null;

    static {
        MentionUserState r0 = new MentionUserState("PERMITTED", 0);
        PERMITTED = r0;
        MentionUserState r1 = new MentionUserState("NO_PERMISSION_SHARABLE", 1);
        NO_PERMISSION_SHARABLE = r1;
        MentionUserState r3 = new MentionUserState("NO_PERMISSION_UNSHARABLE_RESIGNED", 2);
        NO_PERMISSION_UNSHARABLE_RESIGNED = r3;
        MentionUserState r5 = new MentionUserState("NO_PERMISSION_UNSHARABLE_ASK_OWNER", 3);
        NO_PERMISSION_UNSHARABLE_ASK_OWNER = r5;
        a = new MentionUserState[]{r0, r1, r3, r5};
    }

    public static MentionUserState[] values() {
        return (MentionUserState[]) a.clone();
    }

    public static MentionUserState valueOf(String r1) {
        return (MentionUserState) r27.a.a(MentionUserState.class, r1);
    }

    public MentionUserState(String r1, int r2) {
        super(r1, r2);
    }
}
