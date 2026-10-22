package com.obric.capabilitykit.entity.enums;

import com.obric.miniapp.alarm.AlarmSessionType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/capabilitykit/entity/enums/CalendarTypeEnum;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CALENDAR", AlarmSessionType.TODO, "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final enum CalendarTypeEnum extends Enum<CalendarTypeEnum> {
    private static final /* synthetic */ CalendarTypeEnum[] $VALUES = null;
    public static final CalendarTypeEnum CALENDAR = null;
    public static final a Companion = null;
    public static final CalendarTypeEnum TODO = null;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ CalendarTypeEnum[] $values() {
        return new CalendarTypeEnum[]{CALENDAR, TODO};
    }

    static {
        CALENDAR = new CalendarTypeEnum("CALENDAR", 0);
        TODO = new CalendarTypeEnum(AlarmSessionType.TODO, 1);
        $VALUES = $values();
        Companion = new a();
    }

    private CalendarTypeEnum(String r100, int r101) {
        super(r100, r101);
    }

    public static CalendarTypeEnum valueOf(String r100) {
        return (CalendarTypeEnum) r27.a.a(CalendarTypeEnum.class, r100);
    }

    public static CalendarTypeEnum[] values() {
        return (CalendarTypeEnum[]) $VALUES.clone();
    }
}
