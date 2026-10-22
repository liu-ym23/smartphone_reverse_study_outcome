package com.larus.platform.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/platform/api/ThemeColorKey;", "", "<init>", "(Ljava/lang/String;I)V", "MESSAGE_BUBBLE_COLOR", "MESSAGE_RECEIVE_BUBBLE_COLOR", "MESSAGE_SEND_COLOR", "NAVIBAR_TTS_BUTTON_COLOR", "MESSAGE_CHECKBOX_COLOR", "MESSAGE_SEND_TEXT_COLOR", "MESSAGE_SEND_TEXT_UNDERLINE_COLOR", "MESSAGE_SEND_TEXT_LOADING_COLOR", "MESSAGE_ANSWER_ACTION_BACKGROUND_COLOR", "MESSAGE_ANSWER_ACTION_COLOR", "MESSAGE_REPLY_TEXT_COLOR", "MESSAGE_REPLY_LINE_COLOR", "MESSAGE_REPLY_ICON_COLOR", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ThemeColorKey extends Enum<ThemeColorKey> {
    public static final ThemeColorKey MESSAGE_ANSWER_ACTION_BACKGROUND_COLOR = null;
    public static final ThemeColorKey MESSAGE_ANSWER_ACTION_COLOR = null;
    public static final ThemeColorKey MESSAGE_BUBBLE_COLOR = null;
    public static final ThemeColorKey MESSAGE_CHECKBOX_COLOR = null;
    public static final ThemeColorKey MESSAGE_RECEIVE_BUBBLE_COLOR = null;
    public static final ThemeColorKey MESSAGE_REPLY_ICON_COLOR = null;
    public static final ThemeColorKey MESSAGE_REPLY_LINE_COLOR = null;
    public static final ThemeColorKey MESSAGE_REPLY_TEXT_COLOR = null;
    public static final ThemeColorKey MESSAGE_SEND_COLOR = null;
    public static final ThemeColorKey MESSAGE_SEND_TEXT_COLOR = null;
    public static final ThemeColorKey MESSAGE_SEND_TEXT_LOADING_COLOR = null;
    public static final ThemeColorKey MESSAGE_SEND_TEXT_UNDERLINE_COLOR = null;
    public static final ThemeColorKey NAVIBAR_TTS_BUTTON_COLOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThemeColorKey[] f364851a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364852b = null;

    public static EnumEntries<ThemeColorKey> getEntries() {
        return f364852b;
    }

    static {
        ThemeColorKey r100 = new ThemeColorKey("MESSAGE_BUBBLE_COLOR", 0);
        MESSAGE_BUBBLE_COLOR = r100;
        ThemeColorKey r101 = new ThemeColorKey("MESSAGE_RECEIVE_BUBBLE_COLOR", 1);
        MESSAGE_RECEIVE_BUBBLE_COLOR = r101;
        ThemeColorKey r102 = new ThemeColorKey("MESSAGE_SEND_COLOR", 2);
        MESSAGE_SEND_COLOR = r102;
        ThemeColorKey r103 = new ThemeColorKey("NAVIBAR_TTS_BUTTON_COLOR", 3);
        NAVIBAR_TTS_BUTTON_COLOR = r103;
        ThemeColorKey r104 = new ThemeColorKey("MESSAGE_CHECKBOX_COLOR", 4);
        MESSAGE_CHECKBOX_COLOR = r104;
        ThemeColorKey r105 = new ThemeColorKey("MESSAGE_SEND_TEXT_COLOR", 5);
        MESSAGE_SEND_TEXT_COLOR = r105;
        ThemeColorKey r110 = new ThemeColorKey("MESSAGE_SEND_TEXT_UNDERLINE_COLOR", 6);
        MESSAGE_SEND_TEXT_UNDERLINE_COLOR = r110;
        ThemeColorKey r111 = new ThemeColorKey("MESSAGE_SEND_TEXT_LOADING_COLOR", 7);
        MESSAGE_SEND_TEXT_LOADING_COLOR = r111;
        ThemeColorKey r112 = new ThemeColorKey("MESSAGE_ANSWER_ACTION_BACKGROUND_COLOR", 8);
        MESSAGE_ANSWER_ACTION_BACKGROUND_COLOR = r112;
        ThemeColorKey r113 = new ThemeColorKey("MESSAGE_ANSWER_ACTION_COLOR", 9);
        MESSAGE_ANSWER_ACTION_COLOR = r113;
        ThemeColorKey r114 = new ThemeColorKey("MESSAGE_REPLY_TEXT_COLOR", 10);
        MESSAGE_REPLY_TEXT_COLOR = r114;
        ThemeColorKey r115 = new ThemeColorKey("MESSAGE_REPLY_LINE_COLOR", 11);
        MESSAGE_REPLY_LINE_COLOR = r115;
        ThemeColorKey r106 = new ThemeColorKey("MESSAGE_REPLY_ICON_COLOR", 12);
        MESSAGE_REPLY_ICON_COLOR = r106;
        ThemeColorKey[] r107 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
        f364851a = r107;
        f364852b = EnumEntriesKt.enumEntries(r107);
    }

    public static ThemeColorKey[] values() {
        return (ThemeColorKey[]) f364851a.clone();
    }

    public static ThemeColorKey valueOf(String r100) {
        return (ThemeColorKey) r27.a.a(ThemeColorKey.class, r100);
    }

    public ThemeColorKey(String r100, int r101) {
        super(r100, r101);
    }
}
