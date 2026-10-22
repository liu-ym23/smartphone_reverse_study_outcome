package com.ss.android.lark.biz.im.api;

/* JADX INFO: loaded from: classes34.dex */
public final enum ChatSettingApplyWay extends Enum<ChatSettingApplyWay> {
    public static final ChatSettingApplyWay INVITATION = null;
    public static final ChatSettingApplyWay SELF_APPLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatSettingApplyWay[] f409802a = null;
    private int value;

    static {
        ChatSettingApplyWay r100 = new ChatSettingApplyWay("SELF_APPLY", 0, 1);
        SELF_APPLY = r100;
        ChatSettingApplyWay r101 = new ChatSettingApplyWay("INVITATION", 1, 2);
        INVITATION = r101;
        f409802a = new ChatSettingApplyWay[]{r100, r101};
    }

    public static ChatSettingApplyWay[] values() {
        return (ChatSettingApplyWay[]) f409802a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static ChatSettingApplyWay forNumber(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return null;
    L9:
        return INVITATION;
    L11:
        return SELF_APPLY;
    }

    public static ChatSettingApplyWay valueOf(String r100) {
        return (ChatSettingApplyWay) r27.a.a(ChatSettingApplyWay.class, r100);
    }

    public static ChatSettingApplyWay valueOf(int r100) {
        return forNumber(r100);
    }

    public ChatSettingApplyWay(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
