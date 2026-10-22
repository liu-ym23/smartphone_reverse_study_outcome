package com.larus.bmhome.chat.component.bottom.floating;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/floating/BottomFloatingButtonType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", UserProfileEvent.POSITION_NONE, "FAST_SCROLL_BUTTON", "CHECK_FAST_SCROLL_BUTTON", "SHARE_LONG_IMAGE_BUTTON", "SHARE_LONG_IMAGE_BUTTON_SCROLLED", "CHECK_SHARE_LONG_IMAGE_BUTTON", "ADD_COLLECT_TIP", "LOOK_COLLECT_TIP", "BACK_CHAT_BUTTON", "VIEW_NEW_NEWS_BUTTON", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BottomFloatingButtonType extends Enum<BottomFloatingButtonType> {
    public static final BottomFloatingButtonType ADD_COLLECT_TIP = null;
    public static final BottomFloatingButtonType BACK_CHAT_BUTTON = null;
    public static final BottomFloatingButtonType CHECK_FAST_SCROLL_BUTTON = null;
    public static final BottomFloatingButtonType CHECK_SHARE_LONG_IMAGE_BUTTON = null;
    public static final BottomFloatingButtonType FAST_SCROLL_BUTTON = null;
    public static final BottomFloatingButtonType LOOK_COLLECT_TIP = null;
    public static final BottomFloatingButtonType NONE = null;
    public static final BottomFloatingButtonType SHARE_LONG_IMAGE_BUTTON = null;
    public static final BottomFloatingButtonType SHARE_LONG_IMAGE_BUTTON_SCROLLED = null;
    public static final BottomFloatingButtonType VIEW_NEW_NEWS_BUTTON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BottomFloatingButtonType[] f299600a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f299601b = null;
    private final int type;

    public static EnumEntries<BottomFloatingButtonType> getEntries() {
        return f299601b;
    }

    static {
        BottomFloatingButtonType r100 = new BottomFloatingButtonType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        BottomFloatingButtonType r101 = new BottomFloatingButtonType("FAST_SCROLL_BUTTON", 1, 1);
        FAST_SCROLL_BUTTON = r101;
        BottomFloatingButtonType r102 = new BottomFloatingButtonType("CHECK_FAST_SCROLL_BUTTON", 2, 2);
        CHECK_FAST_SCROLL_BUTTON = r102;
        BottomFloatingButtonType r103 = new BottomFloatingButtonType("SHARE_LONG_IMAGE_BUTTON", 3, 3);
        SHARE_LONG_IMAGE_BUTTON = r103;
        BottomFloatingButtonType r104 = new BottomFloatingButtonType("SHARE_LONG_IMAGE_BUTTON_SCROLLED", 4, 4);
        SHARE_LONG_IMAGE_BUTTON_SCROLLED = r104;
        BottomFloatingButtonType r105 = new BottomFloatingButtonType("CHECK_SHARE_LONG_IMAGE_BUTTON", 5, 5);
        CHECK_SHARE_LONG_IMAGE_BUTTON = r105;
        BottomFloatingButtonType r110 = new BottomFloatingButtonType("ADD_COLLECT_TIP", 6, 6);
        ADD_COLLECT_TIP = r110;
        BottomFloatingButtonType r111 = new BottomFloatingButtonType("LOOK_COLLECT_TIP", 7, 7);
        LOOK_COLLECT_TIP = r111;
        BottomFloatingButtonType r112 = new BottomFloatingButtonType("BACK_CHAT_BUTTON", 8, 8);
        BACK_CHAT_BUTTON = r112;
        BottomFloatingButtonType r113 = new BottomFloatingButtonType("VIEW_NEW_NEWS_BUTTON", 9, 9);
        VIEW_NEW_NEWS_BUTTON = r113;
        BottomFloatingButtonType[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f299600a = r114;
        f299601b = EnumEntriesKt.enumEntries(r114);
    }

    public static BottomFloatingButtonType[] values() {
        return (BottomFloatingButtonType[]) f299600a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static BottomFloatingButtonType valueOf(String r100) {
        return (BottomFloatingButtonType) a.a(BottomFloatingButtonType.class, r100);
    }

    public BottomFloatingButtonType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
