package com.bytedance.bdp.serviceapi.hostimpl.aweme;

/* JADX INFO: loaded from: classes11.dex */
public final enum JoinConversationCallback$Type extends Enum<JoinConversationCallback$Type> {
    public static final JoinConversationCallback$Type APPLY_FAIL = null;
    public static final JoinConversationCallback$Type GROUP_FULL = null;
    public static final JoinConversationCallback$Type INTERNAL_ERROR = null;
    public static final JoinConversationCallback$Type JUMP_FAIL = null;
    public static final JoinConversationCallback$Type NOT_AUTHENTICATE = null;
    public static final JoinConversationCallback$Type REQUEST_FAIL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JoinConversationCallback$Type[] f201599a = null;

    static {
        JoinConversationCallback$Type r100 = new JoinConversationCallback$Type("INTERNAL_ERROR", 0);
        INTERNAL_ERROR = r100;
        JoinConversationCallback$Type r101 = new JoinConversationCallback$Type("GROUP_FULL", 1);
        GROUP_FULL = r101;
        JoinConversationCallback$Type r102 = new JoinConversationCallback$Type("REQUEST_FAIL", 2);
        REQUEST_FAIL = r102;
        JoinConversationCallback$Type r103 = new JoinConversationCallback$Type("NOT_AUTHENTICATE", 3);
        NOT_AUTHENTICATE = r103;
        JoinConversationCallback$Type r104 = new JoinConversationCallback$Type("JUMP_FAIL", 4);
        JUMP_FAIL = r104;
        JoinConversationCallback$Type r105 = new JoinConversationCallback$Type("APPLY_FAIL", 5);
        APPLY_FAIL = r105;
        f201599a = new JoinConversationCallback$Type[]{r100, r101, r102, r103, r104, r105};
    }

    public static JoinConversationCallback$Type[] values() {
        return (JoinConversationCallback$Type[]) f201599a.clone();
    }

    public static JoinConversationCallback$Type valueOf(String r100) {
        return (JoinConversationCallback$Type) r27.a.a(JoinConversationCallback$Type.class, r100);
    }

    public JoinConversationCallback$Type(String r100, int r101) {
        super(r100, r101);
    }
}
