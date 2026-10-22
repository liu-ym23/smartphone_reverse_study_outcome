package com.larus.bmhome.chat.component.bottom.floating;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/floating/BottomFloatingButtonAction;", "", "action", "", "<init>", "(Ljava/lang/String;II)V", "getAction", "()I", "SCROLL_UP", "SCROLL_DOWN", "SCREENSHOT", "AUTO_HIDE", "SHOW_ADD_COLLECT_TIP", "SHOW_LOOK_COLLECT_TIP", "BACK_CHAT", "HIDE_BACK_CHAT", "VIEW_NEW_NEWS", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BottomFloatingButtonAction extends Enum<BottomFloatingButtonAction> {
    public static final BottomFloatingButtonAction AUTO_HIDE = null;
    public static final BottomFloatingButtonAction BACK_CHAT = null;
    public static final BottomFloatingButtonAction HIDE_BACK_CHAT = null;
    public static final BottomFloatingButtonAction SCREENSHOT = null;
    public static final BottomFloatingButtonAction SCROLL_DOWN = null;
    public static final BottomFloatingButtonAction SCROLL_UP = null;
    public static final BottomFloatingButtonAction SHOW_ADD_COLLECT_TIP = null;
    public static final BottomFloatingButtonAction SHOW_LOOK_COLLECT_TIP = null;
    public static final BottomFloatingButtonAction VIEW_NEW_NEWS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BottomFloatingButtonAction[] f299571a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f299572b = null;
    private final int action;

    public static EnumEntries<BottomFloatingButtonAction> getEntries() {
        return f299572b;
    }

    static {
        BottomFloatingButtonAction r100 = new BottomFloatingButtonAction("SCROLL_UP", 0, 1);
        SCROLL_UP = r100;
        BottomFloatingButtonAction r101 = new BottomFloatingButtonAction("SCROLL_DOWN", 1, 2);
        SCROLL_DOWN = r101;
        BottomFloatingButtonAction r102 = new BottomFloatingButtonAction("SCREENSHOT", 2, 3);
        SCREENSHOT = r102;
        BottomFloatingButtonAction r103 = new BottomFloatingButtonAction("AUTO_HIDE", 3, 4);
        AUTO_HIDE = r103;
        BottomFloatingButtonAction r104 = new BottomFloatingButtonAction("SHOW_ADD_COLLECT_TIP", 4, 5);
        SHOW_ADD_COLLECT_TIP = r104;
        BottomFloatingButtonAction r110 = new BottomFloatingButtonAction("SHOW_LOOK_COLLECT_TIP", 5, 6);
        SHOW_LOOK_COLLECT_TIP = r110;
        BottomFloatingButtonAction r111 = new BottomFloatingButtonAction("BACK_CHAT", 6, 7);
        BACK_CHAT = r111;
        BottomFloatingButtonAction r112 = new BottomFloatingButtonAction("HIDE_BACK_CHAT", 7, 8);
        HIDE_BACK_CHAT = r112;
        BottomFloatingButtonAction r113 = new BottomFloatingButtonAction("VIEW_NEW_NEWS", 8, 9);
        VIEW_NEW_NEWS = r113;
        BottomFloatingButtonAction[] r105 = {r100, r101, r102, r103, r104, r110, r111, r112, r113};
        f299571a = r105;
        f299572b = EnumEntriesKt.enumEntries(r105);
    }

    public static BottomFloatingButtonAction[] values() {
        return (BottomFloatingButtonAction[]) f299571a.clone();
    }

    public final int getAction() {
        return this.action;
    }

    public static BottomFloatingButtonAction valueOf(String r100) {
        return (BottomFloatingButtonAction) a.a(BottomFloatingButtonAction.class, r100);
    }

    public BottomFloatingButtonAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.action = r102;
    }
}
