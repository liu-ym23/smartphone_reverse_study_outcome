package com.ss.android.lark.chat.export.entity.message.content;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;

/* JADX INFO: loaded from: classes35.dex */
public final enum ContentValueType extends Enum<ContentValueType> {
    public static final ContentValueType ACTION = null;
    public static final ContentValueType BOT = null;
    public static final ContentValueType CHAT = null;
    public static final ContentValueType CHATTER = null;
    public static final ContentValueType DEPARTMENT = null;
    public static final ContentValueType TEXT = null;
    public static final ContentValueType UNKNOWN = null;
    public static final ContentValueType URL = null;
    public static final ContentValueType USER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContentValueType[] f415397a = null;
    private final int value;

    static {
        ContentValueType r100 = new ContentValueType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ContentValueType r101 = new ContentValueType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
        USER = r101;
        ContentValueType r102 = new ContentValueType("BOT", 2, 2);
        BOT = r102;
        ContentValueType r103 = new ContentValueType(CardAdapter.TEXT, 3, 3);
        TEXT = r103;
        ContentValueType r104 = new ContentValueType("CHAT", 4, 4);
        CHAT = r104;
        ContentValueType r105 = new ContentValueType("CHATTER", 5, 5);
        CHATTER = r105;
        ContentValueType r110 = new ContentValueType("URL", 6, 6);
        URL = r110;
        ContentValueType r111 = new ContentValueType("ACTION", 7, 7);
        ACTION = r111;
        ContentValueType r112 = new ContentValueType("DEPARTMENT", 8, 8);
        DEPARTMENT = r112;
        f415397a = new ContentValueType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static ContentValueType[] values() {
        return (ContentValueType[]) f415397a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static ContentValueType fromValue(int r100) {
        switch(r100) {
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return DEPARTMENT;
    L8:
        return ACTION;
    L10:
        return URL;
    L12:
        return CHATTER;
    L14:
        return CHAT;
    L16:
        return TEXT;
    L18:
        return BOT;
    L20:
        return USER;
    L22:
        return UNKNOWN;
    }

    public static ContentValueType valueOf(String r100) {
        return (ContentValueType) r27.a.a(ContentValueType.class, r100);
    }

    public ContentValueType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
