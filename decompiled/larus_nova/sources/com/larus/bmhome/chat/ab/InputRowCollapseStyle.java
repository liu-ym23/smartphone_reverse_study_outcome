package com.larus.bmhome.chat.ab;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/ab/InputRowCollapseStyle;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "TWO_LINE", "ONE_LINE", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InputRowCollapseStyle extends Enum<InputRowCollapseStyle> {
    public static final InputRowCollapseStyle NONE = null;
    public static final InputRowCollapseStyle ONE_LINE = null;
    public static final InputRowCollapseStyle TWO_LINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputRowCollapseStyle[] f296990a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f296991b = null;

    public static EnumEntries<InputRowCollapseStyle> getEntries() {
        return f296991b;
    }

    static {
        InputRowCollapseStyle r100 = new InputRowCollapseStyle(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        InputRowCollapseStyle r101 = new InputRowCollapseStyle("TWO_LINE", 1);
        TWO_LINE = r101;
        InputRowCollapseStyle r102 = new InputRowCollapseStyle("ONE_LINE", 2);
        ONE_LINE = r102;
        InputRowCollapseStyle[] r103 = {r100, r101, r102};
        f296990a = r103;
        f296991b = EnumEntriesKt.enumEntries(r103);
    }

    public static InputRowCollapseStyle[] values() {
        return (InputRowCollapseStyle[]) f296990a.clone();
    }

    public static InputRowCollapseStyle valueOf(String r100) {
        return (InputRowCollapseStyle) a.a(InputRowCollapseStyle.class, r100);
    }

    public InputRowCollapseStyle(String r100, int r101) {
        super(r100, r101);
    }
}
