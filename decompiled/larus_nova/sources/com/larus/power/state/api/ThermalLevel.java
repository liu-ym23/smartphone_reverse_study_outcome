package com.larus.power.state.api;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/power/state/api/ThermalLevel;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "LIGHT", "MODERATE", "SEVERE", "CRITICAL", "EMERGENCY", "SHUTDOWN", "UNKNOWN", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ThermalLevel extends Enum<ThermalLevel> {
    public static final ThermalLevel CRITICAL = null;
    public static final ThermalLevel EMERGENCY = null;
    public static final ThermalLevel LIGHT = null;
    public static final ThermalLevel MODERATE = null;
    public static final ThermalLevel NONE = null;
    public static final ThermalLevel SEVERE = null;
    public static final ThermalLevel SHUTDOWN = null;
    public static final ThermalLevel UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThermalLevel[] f365953a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365954b = null;

    public static EnumEntries<ThermalLevel> getEntries() {
        return f365954b;
    }

    static {
        ThermalLevel r100 = new ThermalLevel(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        ThermalLevel r101 = new ThermalLevel("LIGHT", 1);
        LIGHT = r101;
        ThermalLevel r102 = new ThermalLevel("MODERATE", 2);
        MODERATE = r102;
        ThermalLevel r103 = new ThermalLevel("SEVERE", 3);
        SEVERE = r103;
        ThermalLevel r104 = new ThermalLevel("CRITICAL", 4);
        CRITICAL = r104;
        ThermalLevel r105 = new ThermalLevel("EMERGENCY", 5);
        EMERGENCY = r105;
        ThermalLevel r110 = new ThermalLevel("SHUTDOWN", 6);
        SHUTDOWN = r110;
        ThermalLevel r111 = new ThermalLevel("UNKNOWN", 7);
        UNKNOWN = r111;
        ThermalLevel[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f365953a = r112;
        f365954b = EnumEntriesKt.enumEntries(r112);
    }

    public static ThermalLevel[] values() {
        return (ThermalLevel[]) f365953a.clone();
    }

    public static ThermalLevel valueOf(String r100) {
        return (ThermalLevel) a.a(ThermalLevel.class, r100);
    }

    public ThermalLevel(String r100, int r101) {
        super(r100, r101);
    }
}
