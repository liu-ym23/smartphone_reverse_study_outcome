package com.bytedance.ee.bear.bean;

import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum MentionPanelType extends Enum<MentionPanelType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MentionPanelType[] f206692a = null;
    public static final MentionPanelType chat = null;
    public static final MentionPanelType file = null;
    public static final MentionPanelType user = null;

    static {
        MentionPanelType r100 = new MentionPanelType("user", 0);
        user = r100;
        MentionPanelType r101 = new MentionPanelType("chat", 1);
        chat = r101;
        MentionPanelType r102 = new MentionPanelType("file", 2);
        file = r102;
        f206692a = new MentionPanelType[]{r100, r101, r102};
    }

    public static MentionPanelType[] values() {
        return (MentionPanelType[]) f206692a.clone();
    }

    public static MentionPanelType valueOf(String r100) {
        return (MentionPanelType) a.a(MentionPanelType.class, r100);
    }

    public MentionPanelType(String r100, int r101) {
        super(r100, r101);
    }
}
