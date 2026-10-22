package com.bytedance.livesdk.preview.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/livesdk/preview/base/PreviewDialogPriority;", "", "BACK_ROOM_WIDGET", "SEARCH_CARD_WIDGET", "INSTANT_CARD_WIDGET", "DISLIKE_TIP", "FEED_BACK_WIDGET", "LIVE_TAB_EXIT_GUIDE", "LIVE_BROADCAST_GUIDE", "AD_EXPAND_WIDGET", "TABLIVE_FOLLOW_DESKTOP_WIDGET_GUIDE", "TABLIVE_ICON_DESKTOP_GUIDE", "TABLIVE_PIN_TOP_GUIDE", "LIVE_BROADCAST_NOTIFY_GUIDE", "PLATFORM_BOTTOM_GUIDE", "livepreview-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PreviewDialogPriority extends Enum<PreviewDialogPriority> {
    public static final PreviewDialogPriority AD_EXPAND_WIDGET = null;
    public static final PreviewDialogPriority BACK_ROOM_WIDGET = null;
    public static final PreviewDialogPriority DISLIKE_TIP = null;
    public static final PreviewDialogPriority FEED_BACK_WIDGET = null;
    public static final PreviewDialogPriority INSTANT_CARD_WIDGET = null;
    public static final PreviewDialogPriority LIVE_BROADCAST_GUIDE = null;
    public static final PreviewDialogPriority LIVE_BROADCAST_NOTIFY_GUIDE = null;
    public static final PreviewDialogPriority LIVE_TAB_EXIT_GUIDE = null;
    public static final PreviewDialogPriority PLATFORM_BOTTOM_GUIDE = null;
    public static final PreviewDialogPriority SEARCH_CARD_WIDGET = null;
    public static final PreviewDialogPriority TABLIVE_FOLLOW_DESKTOP_WIDGET_GUIDE = null;
    public static final PreviewDialogPriority TABLIVE_ICON_DESKTOP_GUIDE = null;
    public static final PreviewDialogPriority TABLIVE_PIN_TOP_GUIDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreviewDialogPriority[] f256404a = null;

    static {
        PreviewDialogPriority r100 = new PreviewDialogPriority("BACK_ROOM_WIDGET", 0);
        BACK_ROOM_WIDGET = r100;
        PreviewDialogPriority r101 = new PreviewDialogPriority("SEARCH_CARD_WIDGET", 1);
        SEARCH_CARD_WIDGET = r101;
        PreviewDialogPriority r102 = new PreviewDialogPriority("INSTANT_CARD_WIDGET", 2);
        INSTANT_CARD_WIDGET = r102;
        PreviewDialogPriority r103 = new PreviewDialogPriority("DISLIKE_TIP", 3);
        DISLIKE_TIP = r103;
        PreviewDialogPriority r104 = new PreviewDialogPriority("FEED_BACK_WIDGET", 4);
        FEED_BACK_WIDGET = r104;
        PreviewDialogPriority r105 = new PreviewDialogPriority("LIVE_TAB_EXIT_GUIDE", 5);
        LIVE_TAB_EXIT_GUIDE = r105;
        PreviewDialogPriority r106 = new PreviewDialogPriority("LIVE_BROADCAST_GUIDE", 6);
        LIVE_BROADCAST_GUIDE = r106;
        PreviewDialogPriority r107 = new PreviewDialogPriority("AD_EXPAND_WIDGET", 7);
        AD_EXPAND_WIDGET = r107;
        PreviewDialogPriority r108 = new PreviewDialogPriority("TABLIVE_FOLLOW_DESKTOP_WIDGET_GUIDE", 8);
        TABLIVE_FOLLOW_DESKTOP_WIDGET_GUIDE = r108;
        PreviewDialogPriority r109 = new PreviewDialogPriority("TABLIVE_ICON_DESKTOP_GUIDE", 9);
        TABLIVE_ICON_DESKTOP_GUIDE = r109;
        PreviewDialogPriority r110 = new PreviewDialogPriority("TABLIVE_PIN_TOP_GUIDE", 10);
        TABLIVE_PIN_TOP_GUIDE = r110;
        PreviewDialogPriority r111 = new PreviewDialogPriority("LIVE_BROADCAST_NOTIFY_GUIDE", 11);
        LIVE_BROADCAST_NOTIFY_GUIDE = r111;
        PreviewDialogPriority r112 = new PreviewDialogPriority("PLATFORM_BOTTOM_GUIDE", 12);
        PLATFORM_BOTTOM_GUIDE = r112;
        f256404a = new PreviewDialogPriority[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public static PreviewDialogPriority valueOf(String r100) {
        return (PreviewDialogPriority) r27.a.a(PreviewDialogPriority.class, r100);
    }

    public static PreviewDialogPriority[] values() {
        return (PreviewDialogPriority[]) f256404a.clone();
    }

    public PreviewDialogPriority(String r100, int r101) {
        super(r100, r101);
    }
}
