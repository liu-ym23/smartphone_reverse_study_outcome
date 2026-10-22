package com.obric.miniapp.calendar.compatibility;

import com.ss.android.lark.banner.export.entity.BannerBizName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/miniapp/calendar/compatibility/ReminderEntity$Method;", "", "<init>", "(Ljava/lang/String;I)V", BannerBizName.NOTIFICATION, "ALARM", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReminderEntity$Method extends Enum<ReminderEntity$Method> {
    public static final ReminderEntity$Method ALARM = null;
    public static final ReminderEntity$Method NOTIFICATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReminderEntity$Method[] f397580a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f397581b = null;

    public static EnumEntries<ReminderEntity$Method> getEntries() {
        return f397581b;
    }

    static {
        ReminderEntity$Method r100 = new ReminderEntity$Method(BannerBizName.NOTIFICATION, 0);
        NOTIFICATION = r100;
        ReminderEntity$Method r101 = new ReminderEntity$Method("ALARM", 1);
        ALARM = r101;
        ReminderEntity$Method[] r102 = {r100, r101};
        f397580a = r102;
        f397581b = EnumEntriesKt.enumEntries(r102);
    }

    public static ReminderEntity$Method[] values() {
        return (ReminderEntity$Method[]) f397580a.clone();
    }

    public static ReminderEntity$Method valueOf(String r100) {
        return (ReminderEntity$Method) r27.a.a(ReminderEntity$Method.class, r100);
    }

    public ReminderEntity$Method(String r100, int r101) {
        super(r100, r101);
    }
}
