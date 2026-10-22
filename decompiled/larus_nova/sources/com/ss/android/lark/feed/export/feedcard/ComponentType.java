package com.ss.android.lark.feed.export.feedcard;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/feed/export/feedcard/ComponentType;", "", "<init>", "(Ljava/lang/String;I)V", "AVATAR", "TITLE", "TITLE_RIGHT", "SUBTITLE", "PREVIEW", "BOTTOM_ACTION", "AVATAR_VIEW", "BADGE_VIEW", "TITLE_VIEW", "FEED_TAG_VIEW", "SPECIAL_FOCUS_VIEW", "CUSTOM_STATUS_VIEW", "STATE_VIEW", "SUBTITLE_ICON_VIEW", "SUBTITLE_VIEW", "MARK_ICON_VIEW", "REACTION_VIEW", "DIGEST_VIEW", "MUTE_VIEW", "AT_AVATAR_VIEW", "ACTION_VIEW", "MARK_TEXT", "TEAM", "AI_SMART_REPLY_VIEW", "FLOW_PREVIEW_VIEW", "FLOW_PREVIEW_TEXT_LAYER", "FLOW_LOADING_VIEW", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ComponentType extends Enum<ComponentType> {
    public static final ComponentType ACTION_VIEW = null;
    public static final ComponentType AI_SMART_REPLY_VIEW = null;
    public static final ComponentType AT_AVATAR_VIEW = null;
    public static final ComponentType AVATAR = null;
    public static final ComponentType AVATAR_VIEW = null;
    public static final ComponentType BADGE_VIEW = null;
    public static final ComponentType BOTTOM_ACTION = null;
    public static final ComponentType CUSTOM_STATUS_VIEW = null;
    public static final ComponentType DIGEST_VIEW = null;
    public static final ComponentType FEED_TAG_VIEW = null;
    public static final ComponentType FLOW_LOADING_VIEW = null;
    public static final ComponentType FLOW_PREVIEW_TEXT_LAYER = null;
    public static final ComponentType FLOW_PREVIEW_VIEW = null;
    public static final ComponentType MARK_ICON_VIEW = null;
    public static final ComponentType MARK_TEXT = null;
    public static final ComponentType MUTE_VIEW = null;
    public static final ComponentType PREVIEW = null;
    public static final ComponentType REACTION_VIEW = null;
    public static final ComponentType SPECIAL_FOCUS_VIEW = null;
    public static final ComponentType STATE_VIEW = null;
    public static final ComponentType SUBTITLE = null;
    public static final ComponentType SUBTITLE_ICON_VIEW = null;
    public static final ComponentType SUBTITLE_VIEW = null;
    public static final ComponentType TEAM = null;
    public static final ComponentType TITLE = null;
    public static final ComponentType TITLE_RIGHT = null;
    public static final ComponentType TITLE_VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComponentType[] f420994a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420995b = null;

    public static EnumEntries<ComponentType> getEntries() {
        return f420995b;
    }

    static {
        ComponentType r100 = new ComponentType("AVATAR", 0);
        AVATAR = r100;
        ComponentType r101 = new ComponentType("TITLE", 1);
        TITLE = r101;
        ComponentType r102 = new ComponentType("TITLE_RIGHT", 2);
        TITLE_RIGHT = r102;
        ComponentType r103 = new ComponentType("SUBTITLE", 3);
        SUBTITLE = r103;
        ComponentType r104 = new ComponentType("PREVIEW", 4);
        PREVIEW = r104;
        ComponentType r105 = new ComponentType("BOTTOM_ACTION", 5);
        BOTTOM_ACTION = r105;
        ComponentType r110 = new ComponentType("AVATAR_VIEW", 6);
        AVATAR_VIEW = r110;
        ComponentType r111 = new ComponentType("BADGE_VIEW", 7);
        BADGE_VIEW = r111;
        ComponentType r112 = new ComponentType("TITLE_VIEW", 8);
        TITLE_VIEW = r112;
        ComponentType r113 = new ComponentType("FEED_TAG_VIEW", 9);
        FEED_TAG_VIEW = r113;
        ComponentType r114 = new ComponentType("SPECIAL_FOCUS_VIEW", 10);
        SPECIAL_FOCUS_VIEW = r114;
        ComponentType r115 = new ComponentType("CUSTOM_STATUS_VIEW", 11);
        CUSTOM_STATUS_VIEW = r115;
        ComponentType r106 = new ComponentType("STATE_VIEW", 12);
        STATE_VIEW = r106;
        ComponentType r107 = new ComponentType("SUBTITLE_ICON_VIEW", 13);
        SUBTITLE_ICON_VIEW = r107;
        ComponentType r108 = new ComponentType("SUBTITLE_VIEW", 14);
        SUBTITLE_VIEW = r108;
        ComponentType r109 = new ComponentType("MARK_ICON_VIEW", 15);
        MARK_ICON_VIEW = r109;
        ComponentType r116 = new ComponentType("REACTION_VIEW", 16);
        REACTION_VIEW = r116;
        ComponentType r117 = new ComponentType("DIGEST_VIEW", 17);
        DIGEST_VIEW = r117;
        ComponentType r118 = new ComponentType("MUTE_VIEW", 18);
        MUTE_VIEW = r118;
        ComponentType r119 = new ComponentType("AT_AVATAR_VIEW", 19);
        AT_AVATAR_VIEW = r119;
        ComponentType r120 = new ComponentType("ACTION_VIEW", 20);
        ACTION_VIEW = r120;
        ComponentType r121 = new ComponentType("MARK_TEXT", 21);
        MARK_TEXT = r121;
        ComponentType r122 = new ComponentType("TEAM", 22);
        TEAM = r122;
        ComponentType r123 = new ComponentType("AI_SMART_REPLY_VIEW", 23);
        AI_SMART_REPLY_VIEW = r123;
        ComponentType r124 = new ComponentType("FLOW_PREVIEW_VIEW", 24);
        FLOW_PREVIEW_VIEW = r124;
        ComponentType r125 = new ComponentType("FLOW_PREVIEW_TEXT_LAYER", 25);
        FLOW_PREVIEW_TEXT_LAYER = r125;
        ComponentType r126 = new ComponentType("FLOW_LOADING_VIEW", 26);
        FLOW_LOADING_VIEW = r126;
        ComponentType[] r127 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126};
        f420994a = r127;
        f420995b = EnumEntriesKt.enumEntries(r127);
    }

    public static ComponentType[] values() {
        return (ComponentType[]) f420994a.clone();
    }

    public static ComponentType valueOf(String r100) {
        return (ComponentType) r27.a.a(ComponentType.class, r100);
    }

    public ComponentType(String r100, int r101) {
        super(r100, r101);
    }
}
