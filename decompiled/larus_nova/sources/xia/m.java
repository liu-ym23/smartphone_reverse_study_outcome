package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.enums.CalendarTypeEnum;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class m implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f563992a = null;

    static {
        f563992a = new m();
    }

    public m() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof ScheduleEntity) == false) goto L66;
        ScheduleEntity r101 = (ScheduleEntity) r100;
        int r102 = ((((r101.getName().hashCode() + 0) * 31) + r101.getStartTime().hashCode()) * 31) + r101.getEndTime().hashCode();
        String r103 = r101.getAddress();
        if (r103 == null) goto L7;
        r102 = (r102 * 31) + r103.hashCode();
    L7:
        List<ContactEntity> r104 = r101.getAttendees();
        if (r104 == null) goto L10;
        r102 = (r102 * 31) + r104.hashCode();
    L10:
        String r105 = r101.getRepeatDescription();
        if (r105 == null) goto L13;
        r102 = (r102 * 31) + r105.hashCode();
    L13:
        Long r106 = r101.getStartTimestamp();
        if (r106 == null) goto L16;
        long r107 = r106.longValue();
        r102 = (r102 * 31) + ((int) (r107 ^ (r107 >>> 32)));
    L16:
        Long r108 = r101.getEndTimestamp();
        if (r108 == null) goto L19;
        long r109 = r108.longValue();
        r102 = (r102 * 31) + ((int) (r109 ^ (r109 >>> 32)));
    L19:
        int r110 = r102 * 31;
        int r111 = 1231;
        if (r101.getAllDay() == false) goto L22;
        int r112 = 1231;
    L23:
        int r113 = r110 + r112;
        String r114 = r101.getNote();
        if (r114 == null) goto L26;
        r113 = (r113 * 31) + r114.hashCode();
    L26:
        Boolean r115 = r101.getCompleted();
        if (r115 == null) goto L33;
        int r116 = r113 * 31;
        if (r115.booleanValue() == false) goto L31;
        int r117 = 1231;
    L32:
        r113 = r116 + r117;
        goto L33
    L31:
        r117 = 1237;
    L33:
        int r118 = r113 * 31;
        if (r101.isFavorite() == true) goto L37;
        r111 = 1237;
    L37:
        int r119 = r118 + r111;
        String r120 = r101.getReminderDesc();
        if (r120 == null) goto L40;
        r119 = (r119 * 31) + r120.hashCode();
    L40:
        String r121 = r101.getTimeDescription();
        if (r121 == null) goto L43;
        r119 = (r119 * 31) + r121.hashCode();
    L43:
        String r122 = r101.getRruleDescription();
        if (r122 == null) goto L46;
        r119 = (r119 * 31) + r122.hashCode();
    L46:
        String r123 = r101.getIcsId();
        if (r123 == null) goto L49;
        r119 = (r119 * 31) + r123.hashCode();
    L49:
        String r124 = r101.getRecurrenceId();
        if (r124 == null) goto L52;
        r119 = (r119 * 31) + r124.hashCode();
    L52:
        CalendarTypeEnum r125 = r101.getCalendarType();
        if (r125 == null) goto L55;
        r119 = (r119 * 31) + r125.name().hashCode();
    L55:
        String r126 = r101.getICalendarText();
        if (r126 == null) goto L58;
        r119 = (r119 * 31) + r126.hashCode();
    L58:
        Long r127 = r101.getJumpCalendarPageStartTimeStamp();
        if (r127 == null) goto L61;
        long r128 = r127.longValue();
        r119 = (r119 * 31) + ((int) ((r128 >>> 32) ^ r128));
    L61:
        String r129 = r101.getRawRrule();
        if (r129 != null) goto L64;
        return r119;
    L64:
        return (r119 * 31) + r129.hashCode();
    L22:
        r112 = 1237;
        goto L23
    L66:
        throw new IllegalStateException("Check failed.".toString());
    }
}
