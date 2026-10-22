package com.obric.miniapp.calendar.compatibility;

import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/miniapp/calendar/compatibility/ReminderEntity$TimeType;", "", "<init>", "(Ljava/lang/String;I)V", "minute", "hour", BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY, "week", "second", ILoadStallMonitor.START_TIME, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReminderEntity$TimeType extends Enum<ReminderEntity$TimeType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReminderEntity$TimeType[] f397582a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f397583b = null;
    public static final ReminderEntity$TimeType day = null;
    public static final ReminderEntity$TimeType hour = null;
    public static final ReminderEntity$TimeType minute = null;
    public static final ReminderEntity$TimeType second = null;
    public static final ReminderEntity$TimeType start_time = null;
    public static final ReminderEntity$TimeType week = null;

    public static EnumEntries<ReminderEntity$TimeType> getEntries() {
        return f397583b;
    }

    static {
        ReminderEntity$TimeType r100 = new ReminderEntity$TimeType("minute", 0);
        minute = r100;
        ReminderEntity$TimeType r101 = new ReminderEntity$TimeType("hour", 1);
        hour = r101;
        ReminderEntity$TimeType r102 = new ReminderEntity$TimeType(BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY, 2);
        day = r102;
        ReminderEntity$TimeType r103 = new ReminderEntity$TimeType("week", 3);
        week = r103;
        ReminderEntity$TimeType r104 = new ReminderEntity$TimeType("second", 4);
        second = r104;
        ReminderEntity$TimeType r105 = new ReminderEntity$TimeType(ILoadStallMonitor.START_TIME, 5);
        start_time = r105;
        ReminderEntity$TimeType[] r110 = {r100, r101, r102, r103, r104, r105};
        f397582a = r110;
        f397583b = EnumEntriesKt.enumEntries(r110);
    }

    public static ReminderEntity$TimeType[] values() {
        return (ReminderEntity$TimeType[]) f397582a.clone();
    }

    public static ReminderEntity$TimeType valueOf(String r100) {
        return (ReminderEntity$TimeType) r27.a.a(ReminderEntity$TimeType.class, r100);
    }

    public ReminderEntity$TimeType(String r100, int r101) {
        super(r100, r101);
    }
}
