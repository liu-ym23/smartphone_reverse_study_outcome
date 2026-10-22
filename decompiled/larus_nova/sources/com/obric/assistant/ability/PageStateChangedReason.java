package com.obric.assistant.ability;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/ability/PageStateChangedReason;", "", "<init>", "(Ljava/lang/String;I)V", FlowDoraWifiScene.OTHER, "WINDOW_ACTION_VIEW_CLICK", "ISLAND_CLICK", "AUTO_INCREASE", "SWIPE_GESTURE_VIEW", "SWIPE_UP_VIEW", "REQUEST_UNLOCK_FAILED", "RESTORE_STATE_FROM_DISMISS", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PageStateChangedReason extends Enum<PageStateChangedReason> {
    public static final PageStateChangedReason AUTO_INCREASE = null;
    public static final PageStateChangedReason ISLAND_CLICK = null;
    public static final PageStateChangedReason OTHER = null;
    public static final PageStateChangedReason REQUEST_UNLOCK_FAILED = null;
    public static final PageStateChangedReason RESTORE_STATE_FROM_DISMISS = null;
    public static final PageStateChangedReason SWIPE_GESTURE_VIEW = null;
    public static final PageStateChangedReason SWIPE_UP_VIEW = null;
    public static final PageStateChangedReason WINDOW_ACTION_VIEW_CLICK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageStateChangedReason[] f385215a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f385216b = null;

    public static EnumEntries<PageStateChangedReason> getEntries() {
        return f385216b;
    }

    static {
        PageStateChangedReason r100 = new PageStateChangedReason(FlowDoraWifiScene.OTHER, 0);
        OTHER = r100;
        PageStateChangedReason r101 = new PageStateChangedReason("WINDOW_ACTION_VIEW_CLICK", 1);
        WINDOW_ACTION_VIEW_CLICK = r101;
        PageStateChangedReason r102 = new PageStateChangedReason("ISLAND_CLICK", 2);
        ISLAND_CLICK = r102;
        PageStateChangedReason r103 = new PageStateChangedReason("AUTO_INCREASE", 3);
        AUTO_INCREASE = r103;
        PageStateChangedReason r104 = new PageStateChangedReason("SWIPE_GESTURE_VIEW", 4);
        SWIPE_GESTURE_VIEW = r104;
        PageStateChangedReason r105 = new PageStateChangedReason("SWIPE_UP_VIEW", 5);
        SWIPE_UP_VIEW = r105;
        PageStateChangedReason r110 = new PageStateChangedReason("REQUEST_UNLOCK_FAILED", 6);
        REQUEST_UNLOCK_FAILED = r110;
        PageStateChangedReason r111 = new PageStateChangedReason("RESTORE_STATE_FROM_DISMISS", 7);
        RESTORE_STATE_FROM_DISMISS = r111;
        PageStateChangedReason[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f385215a = r112;
        f385216b = EnumEntriesKt.enumEntries(r112);
    }

    public static PageStateChangedReason[] values() {
        return (PageStateChangedReason[]) f385215a.clone();
    }

    public static PageStateChangedReason valueOf(String r100) {
        return (PageStateChangedReason) a.a(PageStateChangedReason.class, r100);
    }

    public PageStateChangedReason(String r100, int r101) {
        super(r100, r101);
    }
}
