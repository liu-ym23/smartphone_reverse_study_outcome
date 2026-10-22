package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/popup/PopupWindowUtil$NavigationBarType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "CLASSIC", "GESTURES", "GESTURES_THREE_STAGE", "DOUBLE", "UNKNOWN", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PopupWindowUtil$NavigationBarType extends Enum<PopupWindowUtil$NavigationBarType> {
    public static final PopupWindowUtil$NavigationBarType CLASSIC = null;
    public static final PopupWindowUtil$NavigationBarType DOUBLE = null;
    public static final PopupWindowUtil$NavigationBarType GESTURES = null;
    public static final PopupWindowUtil$NavigationBarType GESTURES_THREE_STAGE = null;
    public static final PopupWindowUtil$NavigationBarType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PopupWindowUtil$NavigationBarType[] f429969a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f429970b = null;
    private final int type;

    public static EnumEntries<PopupWindowUtil$NavigationBarType> getEntries() {
        return f429970b;
    }

    static {
        PopupWindowUtil$NavigationBarType r100 = new PopupWindowUtil$NavigationBarType("CLASSIC", 0, 0);
        CLASSIC = r100;
        PopupWindowUtil$NavigationBarType r101 = new PopupWindowUtil$NavigationBarType("GESTURES", 1, 1);
        GESTURES = r101;
        PopupWindowUtil$NavigationBarType r102 = new PopupWindowUtil$NavigationBarType("GESTURES_THREE_STAGE", 2, 2);
        GESTURES_THREE_STAGE = r102;
        PopupWindowUtil$NavigationBarType r103 = new PopupWindowUtil$NavigationBarType("DOUBLE", 3, 3);
        DOUBLE = r103;
        PopupWindowUtil$NavigationBarType r104 = new PopupWindowUtil$NavigationBarType("UNKNOWN", 4, -1);
        UNKNOWN = r104;
        PopupWindowUtil$NavigationBarType[] r105 = {r100, r101, r102, r103, r104};
        f429969a = r105;
        f429970b = EnumEntriesKt.enumEntries(r105);
    }

    public static PopupWindowUtil$NavigationBarType[] values() {
        return (PopupWindowUtil$NavigationBarType[]) f429969a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static PopupWindowUtil$NavigationBarType valueOf(String r100) {
        return (PopupWindowUtil$NavigationBarType) r27.a.a(PopupWindowUtil$NavigationBarType.class, r100);
    }

    public PopupWindowUtil$NavigationBarType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
