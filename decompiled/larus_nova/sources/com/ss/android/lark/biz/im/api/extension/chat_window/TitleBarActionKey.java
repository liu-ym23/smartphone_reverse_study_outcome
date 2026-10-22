package com.ss.android.lark.biz.im.api.extension.chat_window;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/chat_window/TitleBarActionKey;", "", "<init>", "(Ljava/lang/String;I)V", "SPLIT_WINDOW", "BACK", "PAGE_SIZE", "BADGE", "DOUBAO", "VIDEO_CONFERENCE", "ON_CALL", "NEW_TOPIC", "SETTING", "CANCEL_MULTI_SELECT", "WIDGET_ACTION_DONE", "MARK_AS_UNREAD", "BOTTOM_SHEET_EXPAND", "FORWARD", "CLOSE", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TitleBarActionKey extends Enum<TitleBarActionKey> {
    public static final TitleBarActionKey BACK = null;
    public static final TitleBarActionKey BADGE = null;
    public static final TitleBarActionKey BOTTOM_SHEET_EXPAND = null;
    public static final TitleBarActionKey CANCEL_MULTI_SELECT = null;
    public static final TitleBarActionKey CLOSE = null;
    public static final TitleBarActionKey DOUBAO = null;
    public static final TitleBarActionKey FORWARD = null;
    public static final TitleBarActionKey MARK_AS_UNREAD = null;
    public static final TitleBarActionKey NEW_TOPIC = null;
    public static final TitleBarActionKey ON_CALL = null;
    public static final TitleBarActionKey PAGE_SIZE = null;
    public static final TitleBarActionKey SETTING = null;
    public static final TitleBarActionKey SPLIT_WINDOW = null;
    public static final TitleBarActionKey VIDEO_CONFERENCE = null;
    public static final TitleBarActionKey WIDGET_ACTION_DONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TitleBarActionKey[] f410094a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410095b = null;

    public static EnumEntries<TitleBarActionKey> getEntries() {
        return f410095b;
    }

    static {
        TitleBarActionKey r100 = new TitleBarActionKey("SPLIT_WINDOW", 0);
        SPLIT_WINDOW = r100;
        TitleBarActionKey r101 = new TitleBarActionKey("BACK", 1);
        BACK = r101;
        TitleBarActionKey r102 = new TitleBarActionKey("PAGE_SIZE", 2);
        PAGE_SIZE = r102;
        TitleBarActionKey r103 = new TitleBarActionKey("BADGE", 3);
        BADGE = r103;
        TitleBarActionKey r104 = new TitleBarActionKey("DOUBAO", 4);
        DOUBAO = r104;
        TitleBarActionKey r105 = new TitleBarActionKey("VIDEO_CONFERENCE", 5);
        VIDEO_CONFERENCE = r105;
        TitleBarActionKey r110 = new TitleBarActionKey("ON_CALL", 6);
        ON_CALL = r110;
        TitleBarActionKey r111 = new TitleBarActionKey("NEW_TOPIC", 7);
        NEW_TOPIC = r111;
        TitleBarActionKey r112 = new TitleBarActionKey("SETTING", 8);
        SETTING = r112;
        TitleBarActionKey r113 = new TitleBarActionKey("CANCEL_MULTI_SELECT", 9);
        CANCEL_MULTI_SELECT = r113;
        TitleBarActionKey r114 = new TitleBarActionKey("WIDGET_ACTION_DONE", 10);
        WIDGET_ACTION_DONE = r114;
        TitleBarActionKey r115 = new TitleBarActionKey("MARK_AS_UNREAD", 11);
        MARK_AS_UNREAD = r115;
        TitleBarActionKey r106 = new TitleBarActionKey("BOTTOM_SHEET_EXPAND", 12);
        BOTTOM_SHEET_EXPAND = r106;
        TitleBarActionKey r107 = new TitleBarActionKey("FORWARD", 13);
        FORWARD = r107;
        TitleBarActionKey r108 = new TitleBarActionKey("CLOSE", 14);
        CLOSE = r108;
        TitleBarActionKey[] r109 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108};
        f410094a = r109;
        f410095b = EnumEntriesKt.enumEntries(r109);
    }

    public static TitleBarActionKey[] values() {
        return (TitleBarActionKey[]) f410094a.clone();
    }

    public static TitleBarActionKey valueOf(String r100) {
        return (TitleBarActionKey) r27.a.a(TitleBarActionKey.class, r100);
    }

    public TitleBarActionKey(String r100, int r101) {
        super(r100, r101);
    }
}
