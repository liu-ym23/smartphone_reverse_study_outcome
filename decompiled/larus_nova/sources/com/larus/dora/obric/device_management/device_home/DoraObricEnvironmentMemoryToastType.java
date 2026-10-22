package com.larus.dora.obric.device_management.device_home;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricEnvironmentMemoryToastType;", "", "<init>", "(Ljava/lang/String;I)V", "ENABLED", "TEMPORARY_OVERRIDE", "UNAVAILABLE", "SWITCH_OPEN_NETWORK_ERROR", UserProfileEvent.POSITION_NONE, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricEnvironmentMemoryToastType extends Enum<DoraObricEnvironmentMemoryToastType> {
    public static final DoraObricEnvironmentMemoryToastType ENABLED = null;
    public static final DoraObricEnvironmentMemoryToastType NONE = null;
    public static final DoraObricEnvironmentMemoryToastType SWITCH_OPEN_NETWORK_ERROR = null;
    public static final DoraObricEnvironmentMemoryToastType TEMPORARY_OVERRIDE = null;
    public static final DoraObricEnvironmentMemoryToastType UNAVAILABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricEnvironmentMemoryToastType[] f339149a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339150b = null;

    public static EnumEntries<DoraObricEnvironmentMemoryToastType> getEntries() {
        return f339150b;
    }

    static {
        DoraObricEnvironmentMemoryToastType r100 = new DoraObricEnvironmentMemoryToastType("ENABLED", 0);
        ENABLED = r100;
        DoraObricEnvironmentMemoryToastType r101 = new DoraObricEnvironmentMemoryToastType("TEMPORARY_OVERRIDE", 1);
        TEMPORARY_OVERRIDE = r101;
        DoraObricEnvironmentMemoryToastType r102 = new DoraObricEnvironmentMemoryToastType("UNAVAILABLE", 2);
        UNAVAILABLE = r102;
        DoraObricEnvironmentMemoryToastType r103 = new DoraObricEnvironmentMemoryToastType("SWITCH_OPEN_NETWORK_ERROR", 3);
        SWITCH_OPEN_NETWORK_ERROR = r103;
        DoraObricEnvironmentMemoryToastType r104 = new DoraObricEnvironmentMemoryToastType(UserProfileEvent.POSITION_NONE, 4);
        NONE = r104;
        DoraObricEnvironmentMemoryToastType[] r105 = {r100, r101, r102, r103, r104};
        f339149a = r105;
        f339150b = EnumEntriesKt.enumEntries(r105);
    }

    public static DoraObricEnvironmentMemoryToastType[] values() {
        return (DoraObricEnvironmentMemoryToastType[]) f339149a.clone();
    }

    public static DoraObricEnvironmentMemoryToastType valueOf(String r100) {
        return (DoraObricEnvironmentMemoryToastType) r27.a.a(DoraObricEnvironmentMemoryToastType.class, r100);
    }

    public DoraObricEnvironmentMemoryToastType(String r100, int r101) {
        super(r100, r101);
    }
}
