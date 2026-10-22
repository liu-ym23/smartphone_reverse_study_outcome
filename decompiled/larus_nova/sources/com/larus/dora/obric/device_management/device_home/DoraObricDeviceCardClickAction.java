package com.larus.dora.obric.device_management.device_home;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceCardClickAction;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "OPEN_SETTINGS", "OPEN_MODE_SHEET", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricDeviceCardClickAction extends Enum<DoraObricDeviceCardClickAction> {
    public static final DoraObricDeviceCardClickAction NONE = null;
    public static final DoraObricDeviceCardClickAction OPEN_MODE_SHEET = null;
    public static final DoraObricDeviceCardClickAction OPEN_SETTINGS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricDeviceCardClickAction[] f339025a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339026b = null;

    public static EnumEntries<DoraObricDeviceCardClickAction> getEntries() {
        return f339026b;
    }

    static {
        DoraObricDeviceCardClickAction r100 = new DoraObricDeviceCardClickAction(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        DoraObricDeviceCardClickAction r101 = new DoraObricDeviceCardClickAction("OPEN_SETTINGS", 1);
        OPEN_SETTINGS = r101;
        DoraObricDeviceCardClickAction r102 = new DoraObricDeviceCardClickAction("OPEN_MODE_SHEET", 2);
        OPEN_MODE_SHEET = r102;
        DoraObricDeviceCardClickAction[] r103 = {r100, r101, r102};
        f339025a = r103;
        f339026b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoraObricDeviceCardClickAction[] values() {
        return (DoraObricDeviceCardClickAction[]) f339025a.clone();
    }

    public static DoraObricDeviceCardClickAction valueOf(String r100) {
        return (DoraObricDeviceCardClickAction) r27.a.a(DoraObricDeviceCardClickAction.class, r100);
    }

    public DoraObricDeviceCardClickAction(String r100, int r101) {
        super(r100, r101);
    }
}
