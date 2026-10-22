package com.larus.dora.obric.device_management.setting.g;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsAction;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "DEVICE_NAME", "GESTURE", "DOUBAO_CONVERSATION", "SOUND", "VIDEO_RECORD", "GENERAL", "DEVICE_INFO", "ENV_OBSERVE", "MEMORY_DATA", "PRIVACY_AND_PERMISSION", "FEEDBACK", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricGSettingsAction extends Enum<DoraObricGSettingsAction> {
    public static final DoraObricGSettingsAction DEVICE_INFO = null;
    public static final DoraObricGSettingsAction DEVICE_NAME = null;
    public static final DoraObricGSettingsAction DOUBAO_CONVERSATION = null;
    public static final DoraObricGSettingsAction ENV_OBSERVE = null;
    public static final DoraObricGSettingsAction FEEDBACK = null;
    public static final DoraObricGSettingsAction GENERAL = null;
    public static final DoraObricGSettingsAction GESTURE = null;
    public static final DoraObricGSettingsAction MEMORY_DATA = null;
    public static final DoraObricGSettingsAction NONE = null;
    public static final DoraObricGSettingsAction PRIVACY_AND_PERMISSION = null;
    public static final DoraObricGSettingsAction SOUND = null;
    public static final DoraObricGSettingsAction VIDEO_RECORD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricGSettingsAction[] f340240a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f340241b = null;

    public static EnumEntries<DoraObricGSettingsAction> getEntries() {
        return f340241b;
    }

    static {
        DoraObricGSettingsAction r100 = new DoraObricGSettingsAction(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        DoraObricGSettingsAction r101 = new DoraObricGSettingsAction("DEVICE_NAME", 1);
        DEVICE_NAME = r101;
        DoraObricGSettingsAction r102 = new DoraObricGSettingsAction("GESTURE", 2);
        GESTURE = r102;
        DoraObricGSettingsAction r103 = new DoraObricGSettingsAction("DOUBAO_CONVERSATION", 3);
        DOUBAO_CONVERSATION = r103;
        DoraObricGSettingsAction r104 = new DoraObricGSettingsAction("SOUND", 4);
        SOUND = r104;
        DoraObricGSettingsAction r105 = new DoraObricGSettingsAction("VIDEO_RECORD", 5);
        VIDEO_RECORD = r105;
        DoraObricGSettingsAction r110 = new DoraObricGSettingsAction("GENERAL", 6);
        GENERAL = r110;
        DoraObricGSettingsAction r111 = new DoraObricGSettingsAction("DEVICE_INFO", 7);
        DEVICE_INFO = r111;
        DoraObricGSettingsAction r112 = new DoraObricGSettingsAction("ENV_OBSERVE", 8);
        ENV_OBSERVE = r112;
        DoraObricGSettingsAction r113 = new DoraObricGSettingsAction("MEMORY_DATA", 9);
        MEMORY_DATA = r113;
        DoraObricGSettingsAction r114 = new DoraObricGSettingsAction("PRIVACY_AND_PERMISSION", 10);
        PRIVACY_AND_PERMISSION = r114;
        DoraObricGSettingsAction r115 = new DoraObricGSettingsAction("FEEDBACK", 11);
        FEEDBACK = r115;
        DoraObricGSettingsAction[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
        f340240a = r106;
        f340241b = EnumEntriesKt.enumEntries(r106);
    }

    public static DoraObricGSettingsAction[] values() {
        return (DoraObricGSettingsAction[]) f340240a.clone();
    }

    public static DoraObricGSettingsAction valueOf(String r100) {
        return (DoraObricGSettingsAction) r27.a.a(DoraObricGSettingsAction.class, r100);
    }

    public DoraObricGSettingsAction(String r100, int r101) {
        super(r100, r101);
    }
}
