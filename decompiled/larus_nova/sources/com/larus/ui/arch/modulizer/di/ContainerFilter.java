package com.larus.ui.arch.modulizer.di;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b.\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.¨\u0006/"}, d2 = {"Lcom/larus/ui/arch/modulizer/di/ContainerFilter;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "O", "O_WINDOW_CHAT", "FLOAT_CHAT", "SMART_REPLY", "DOUYIN", "INPUT_ONLY", "INPUT_TEXT_ONLY", "INPUT_MULTI_MODAL", "CHAT_SETTING", "REALTIME_CALL", "MINOR_MODE", "KMP", "VOICE_SETTING_DIALOG_SHEET", "VOICE_SETTING_DOUBLE_TAB_SHELL", "VOICE_SETTING_SINGLE_SCREEN", "VOICE_SETTING_PUBLIC_LIST", "BOT_SETTINGS", "EMPTY", "CREATION", "REALTIME_CALL_KMP", HTTP.NOTIFY, "SIDEBAR_HOST", "SPRING_MAIN_VENUE", "CHAT_GALLERY", "SERVICE_BOT", "SERVICE_BOT_SETTING", "READONLY_FORWARD_DETAIL", "MAIN_TAB", "AGGREGATE_SEARCH_KMP", "RECORD_MINUTES_DETAIL", "BOT_DISCOVER", "CREATION_FEED_KMP", "COMMUNITY_CREATE_KMP", "FONT_SIZE_SETTING", "CAMERA", "CAMERA_RESULT", "PROFILE", "OFFICE_APPLET", "AI_FLOAT_CHAT", "LONG_IMAGE", "CUSTOM_DIALOG", "CHAT_JOB_MANAGEMENT", "component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContainerFilter extends Enum<ContainerFilter> {
    public static final ContainerFilter AGGREGATE_SEARCH_KMP = null;
    public static final ContainerFilter AI_FLOAT_CHAT = null;
    public static final ContainerFilter BOT_DISCOVER = null;
    public static final ContainerFilter BOT_SETTINGS = null;
    public static final ContainerFilter CAMERA = null;
    public static final ContainerFilter CAMERA_RESULT = null;
    public static final ContainerFilter CHAT_GALLERY = null;
    public static final ContainerFilter CHAT_JOB_MANAGEMENT = null;
    public static final ContainerFilter CHAT_SETTING = null;
    public static final ContainerFilter COMMUNITY_CREATE_KMP = null;
    public static final ContainerFilter CREATION = null;
    public static final ContainerFilter CREATION_FEED_KMP = null;
    public static final ContainerFilter CUSTOM_DIALOG = null;
    public static final ContainerFilter DEFAULT = null;
    public static final ContainerFilter DOUYIN = null;
    public static final ContainerFilter EMPTY = null;
    public static final ContainerFilter FLOAT_CHAT = null;
    public static final ContainerFilter FONT_SIZE_SETTING = null;
    public static final ContainerFilter INPUT_MULTI_MODAL = null;
    public static final ContainerFilter INPUT_ONLY = null;
    public static final ContainerFilter INPUT_TEXT_ONLY = null;
    public static final ContainerFilter KMP = null;
    public static final ContainerFilter LONG_IMAGE = null;
    public static final ContainerFilter MAIN_TAB = null;
    public static final ContainerFilter MINOR_MODE = null;
    public static final ContainerFilter NOTIFY = null;
    public static final ContainerFilter O = null;
    public static final ContainerFilter OFFICE_APPLET = null;
    public static final ContainerFilter O_WINDOW_CHAT = null;
    public static final ContainerFilter PROFILE = null;
    public static final ContainerFilter READONLY_FORWARD_DETAIL = null;
    public static final ContainerFilter REALTIME_CALL = null;
    public static final ContainerFilter REALTIME_CALL_KMP = null;
    public static final ContainerFilter RECORD_MINUTES_DETAIL = null;
    public static final ContainerFilter SERVICE_BOT = null;
    public static final ContainerFilter SERVICE_BOT_SETTING = null;
    public static final ContainerFilter SIDEBAR_HOST = null;
    public static final ContainerFilter SMART_REPLY = null;
    public static final ContainerFilter SPRING_MAIN_VENUE = null;
    public static final ContainerFilter VOICE_SETTING_DIALOG_SHEET = null;
    public static final ContainerFilter VOICE_SETTING_DOUBLE_TAB_SHELL = null;
    public static final ContainerFilter VOICE_SETTING_PUBLIC_LIST = null;
    public static final ContainerFilter VOICE_SETTING_SINGLE_SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContainerFilter[] f375178a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f375179b = null;

    public static EnumEntries<ContainerFilter> getEntries() {
        return f375179b;
    }

    static {
        ContainerFilter r100 = new ContainerFilter("DEFAULT", 0);
        DEFAULT = r100;
        ContainerFilter r101 = new ContainerFilter("O", 1);
        O = r101;
        ContainerFilter r102 = new ContainerFilter("O_WINDOW_CHAT", 2);
        O_WINDOW_CHAT = r102;
        ContainerFilter r103 = new ContainerFilter("FLOAT_CHAT", 3);
        FLOAT_CHAT = r103;
        ContainerFilter r104 = new ContainerFilter("SMART_REPLY", 4);
        SMART_REPLY = r104;
        ContainerFilter r105 = new ContainerFilter("DOUYIN", 5);
        DOUYIN = r105;
        ContainerFilter r110 = new ContainerFilter("INPUT_ONLY", 6);
        INPUT_ONLY = r110;
        ContainerFilter r111 = new ContainerFilter("INPUT_TEXT_ONLY", 7);
        INPUT_TEXT_ONLY = r111;
        ContainerFilter r112 = new ContainerFilter("INPUT_MULTI_MODAL", 8);
        INPUT_MULTI_MODAL = r112;
        ContainerFilter r113 = new ContainerFilter("CHAT_SETTING", 9);
        CHAT_SETTING = r113;
        ContainerFilter r114 = new ContainerFilter("REALTIME_CALL", 10);
        REALTIME_CALL = r114;
        ContainerFilter r115 = new ContainerFilter("MINOR_MODE", 11);
        MINOR_MODE = r115;
        ContainerFilter r106 = new ContainerFilter("KMP", 12);
        KMP = r106;
        ContainerFilter r107 = new ContainerFilter("VOICE_SETTING_DIALOG_SHEET", 13);
        VOICE_SETTING_DIALOG_SHEET = r107;
        ContainerFilter r108 = new ContainerFilter("VOICE_SETTING_DOUBLE_TAB_SHELL", 14);
        VOICE_SETTING_DOUBLE_TAB_SHELL = r108;
        ContainerFilter r109 = new ContainerFilter("VOICE_SETTING_SINGLE_SCREEN", 15);
        VOICE_SETTING_SINGLE_SCREEN = r109;
        ContainerFilter r116 = new ContainerFilter("VOICE_SETTING_PUBLIC_LIST", 16);
        VOICE_SETTING_PUBLIC_LIST = r116;
        ContainerFilter r117 = new ContainerFilter("BOT_SETTINGS", 17);
        BOT_SETTINGS = r117;
        ContainerFilter r118 = new ContainerFilter("EMPTY", 18);
        EMPTY = r118;
        ContainerFilter r119 = new ContainerFilter("CREATION", 19);
        CREATION = r119;
        ContainerFilter r120 = new ContainerFilter("REALTIME_CALL_KMP", 20);
        REALTIME_CALL_KMP = r120;
        ContainerFilter r121 = new ContainerFilter(HTTP.NOTIFY, 21);
        NOTIFY = r121;
        ContainerFilter r122 = new ContainerFilter("SIDEBAR_HOST", 22);
        SIDEBAR_HOST = r122;
        ContainerFilter r123 = new ContainerFilter("SPRING_MAIN_VENUE", 23);
        SPRING_MAIN_VENUE = r123;
        ContainerFilter r124 = new ContainerFilter("CHAT_GALLERY", 24);
        CHAT_GALLERY = r124;
        ContainerFilter r125 = new ContainerFilter("SERVICE_BOT", 25);
        SERVICE_BOT = r125;
        ContainerFilter r126 = new ContainerFilter("SERVICE_BOT_SETTING", 26);
        SERVICE_BOT_SETTING = r126;
        ContainerFilter r127 = new ContainerFilter("READONLY_FORWARD_DETAIL", 27);
        READONLY_FORWARD_DETAIL = r127;
        ContainerFilter r128 = new ContainerFilter("MAIN_TAB", 28);
        MAIN_TAB = r128;
        ContainerFilter r129 = new ContainerFilter("AGGREGATE_SEARCH_KMP", 29);
        AGGREGATE_SEARCH_KMP = r129;
        ContainerFilter r130 = new ContainerFilter("RECORD_MINUTES_DETAIL", 30);
        RECORD_MINUTES_DETAIL = r130;
        ContainerFilter r131 = new ContainerFilter("BOT_DISCOVER", 31);
        BOT_DISCOVER = r131;
        ContainerFilter r132 = new ContainerFilter("CREATION_FEED_KMP", 32);
        CREATION_FEED_KMP = r132;
        ContainerFilter r133 = new ContainerFilter("COMMUNITY_CREATE_KMP", 33);
        COMMUNITY_CREATE_KMP = r133;
        ContainerFilter r134 = new ContainerFilter("FONT_SIZE_SETTING", 34);
        FONT_SIZE_SETTING = r134;
        ContainerFilter r135 = new ContainerFilter("CAMERA", 35);
        CAMERA = r135;
        ContainerFilter r136 = new ContainerFilter("CAMERA_RESULT", 36);
        CAMERA_RESULT = r136;
        ContainerFilter r137 = new ContainerFilter("PROFILE", 37);
        PROFILE = r137;
        ContainerFilter r138 = new ContainerFilter("OFFICE_APPLET", 38);
        OFFICE_APPLET = r138;
        ContainerFilter r139 = new ContainerFilter("AI_FLOAT_CHAT", 39);
        AI_FLOAT_CHAT = r139;
        ContainerFilter r140 = new ContainerFilter("LONG_IMAGE", 40);
        LONG_IMAGE = r140;
        ContainerFilter r141 = new ContainerFilter("CUSTOM_DIALOG", 41);
        CUSTOM_DIALOG = r141;
        ContainerFilter r142 = new ContainerFilter("CHAT_JOB_MANAGEMENT", 42);
        CHAT_JOB_MANAGEMENT = r142;
        ContainerFilter[] r143 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142};
        f375178a = r143;
        f375179b = EnumEntriesKt.enumEntries(r143);
    }

    public static ContainerFilter[] values() {
        return (ContainerFilter[]) f375178a.clone();
    }

    public static ContainerFilter valueOf(String r100) {
        return (ContainerFilter) a.a(ContainerFilter.class, r100);
    }

    public ContainerFilter(String r100, int r101) {
        super(r100, r101);
    }
}
