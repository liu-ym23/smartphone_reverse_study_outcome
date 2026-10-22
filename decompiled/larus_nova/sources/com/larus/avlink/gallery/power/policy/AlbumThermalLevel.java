package com.larus.avlink.gallery.power.policy;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/avlink/gallery/power/policy/AlbumThermalLevel;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "LIGHT", "MODERATE", "SEVERE", "CRITICAL", "EMERGENCY", "SHUTDOWN", "UNKNOWN", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AlbumThermalLevel extends Enum<AlbumThermalLevel> {
    public static final AlbumThermalLevel CRITICAL = null;
    public static final AlbumThermalLevel EMERGENCY = null;
    public static final AlbumThermalLevel LIGHT = null;
    public static final AlbumThermalLevel MODERATE = null;
    public static final AlbumThermalLevel NONE = null;
    public static final AlbumThermalLevel SEVERE = null;
    public static final AlbumThermalLevel SHUTDOWN = null;
    public static final AlbumThermalLevel UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AlbumThermalLevel[] f292663a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f292664b = null;

    public static EnumEntries<AlbumThermalLevel> getEntries() {
        return f292664b;
    }

    static {
        AlbumThermalLevel r100 = new AlbumThermalLevel(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        AlbumThermalLevel r101 = new AlbumThermalLevel("LIGHT", 1);
        LIGHT = r101;
        AlbumThermalLevel r102 = new AlbumThermalLevel("MODERATE", 2);
        MODERATE = r102;
        AlbumThermalLevel r103 = new AlbumThermalLevel("SEVERE", 3);
        SEVERE = r103;
        AlbumThermalLevel r104 = new AlbumThermalLevel("CRITICAL", 4);
        CRITICAL = r104;
        AlbumThermalLevel r105 = new AlbumThermalLevel("EMERGENCY", 5);
        EMERGENCY = r105;
        AlbumThermalLevel r110 = new AlbumThermalLevel("SHUTDOWN", 6);
        SHUTDOWN = r110;
        AlbumThermalLevel r111 = new AlbumThermalLevel("UNKNOWN", 7);
        UNKNOWN = r111;
        AlbumThermalLevel[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f292663a = r112;
        f292664b = EnumEntriesKt.enumEntries(r112);
    }

    public static AlbumThermalLevel[] values() {
        return (AlbumThermalLevel[]) f292663a.clone();
    }

    public static AlbumThermalLevel valueOf(String r100) {
        return (AlbumThermalLevel) a.a(AlbumThermalLevel.class, r100);
    }

    public AlbumThermalLevel(String r100, int r101) {
        super(r100, r101);
    }
}
