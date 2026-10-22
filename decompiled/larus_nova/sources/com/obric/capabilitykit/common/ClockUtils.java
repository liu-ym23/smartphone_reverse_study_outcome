package com.obric.capabilitykit.common;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¨\u0006\u0016"}, d2 = {"Lcom/obric/capabilitykit/common/ClockUtils;", "", "()V", "convertDaysOfWeekToDesc", "", "daysOfWeek", "", "", "convertTimeToDesc", "hour", DocumentType.MINUTES_NAME, "genClockTimeDesc", "alarm", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "getTodayOrTomorrow", "date", "minute", "isSameDay", "", "cal1", "Ljava/util/Calendar;", "cal2", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClockUtils {
    public static final ClockUtils INSTANCE = null;

    static {
        INSTANCE = new ClockUtils();
    }

    private ClockUtils() {
    }

    private final String convertDaysOfWeekToDesc(List<Integer> r110) {
        ArrayList r100 = new ArrayList();
        Iterator<Integer> r111 = r110.iterator();
    L4:
        if (r111.hasNext() == false) goto L17;
        switch(r111.next().intValue()) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L4;
        };
    L8:
        String r101 = "周日";
    L15:
        r100.add(r101);
        goto L4
    L9:
        r101 = "周六";
        goto L15
    L10:
        r101 = "周五";
        goto L15
    L11:
        r101 = "周四";
        goto L15
    L12:
        r101 = "周三";
        goto L15
    L13:
        r101 = "周二";
        goto L15
    L14:
        r101 = "周一";
        goto L15
    L17:
        if (r100.size() != 7) goto L20;
        return "每天";
    L20:
        return "每" + CollectionsKt.joinToString$default(r100, "、", null, null, 0, null, null, 62, null);
    }

    private final String convertTimeToDesc(int r100, int r101) {
        boolean r102 = true;
        if (r100 < 0) goto L6;
        if (r100 >= 5) goto L6;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L10;
        String r104 = "凌晨";
    L32:
        if (r100 <= 12) goto L35;
        r100 = r100 - 12;
    L35:
        if (r101 != 0) goto L38;
        return r104 + r100 + 28857;
    L38:
        return r104 + r100 + 28857 + r101 + 20998;
    L10:
        if (5 > r100) goto L13;
        if (r100 >= 12) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L16;
        r104 = "上午";
        goto L32
    L16:
        if (r100 != 12) goto L19;
        r104 = "中午";
        goto L32
    L19:
        if (13 > r100) goto L22;
        if (r100 >= 20) goto L22;
        boolean r106 = true;
    L23:
        if (r106 == false) goto L25;
        r104 = "下午";
        goto L32
    L25:
        if (20 <= r100) goto L27;
    L29:
        r102 = false;
    L30:
        if (r102 == false) goto L40;
        r104 = "晚上";
        goto L32
    L40:
        throw new IllegalArgumentException("小时必须在0到23之间");
    L27:
        if (r100 >= 24) goto L29;
    L22:
        r106 = false;
    L13:
        r105 = false;
    L6:
        r103 = false;
        goto L8
    }

    private final String getTodayOrTomorrow(String r100, int r101, int r102) {
        Date r103 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(r100 + ' ' + r101 + ':' + r102);
        Calendar r104 = Calendar.getInstance();
        r104.setTime(r103);
        Calendar r105 = Calendar.getInstance();
        Calendar r106 = Calendar.getInstance();
        r106.add(6, 1);
        Calendar r107 = Calendar.getInstance();
        r107.add(6, 2);
        if (isSameDay(r104, r105) == false) goto L6;
        return "今天";
    L6:
        if (isSameDay(r104, r106) == false) goto L9;
        return "明天";
    L9:
        if (isSameDay(r104, r107) == false) goto L11;
        return "后天";
    L11:
        StringBuilder r108 = new StringBuilder();
        r108.append(r104.get(2) + 1);
        r108.append(26376);
        r108.append(r104.get(5));
        r108.append(26085);
        return r108.toString();
    }

    private final boolean isSameDay(Calendar r100, Calendar r101) {
        if (r100.get(1) == r101.get(1)) goto L5;
    L7:
        return false;
    L5:
        if (r100.get(6) != r101.get(6)) goto L7;
        return true;
    }

    public final String genClockTimeDesc(AlarmEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "alarm");
        int r101 = CastIntegerProtector.parseInt(StringsKt.substringBefore$default(r100.getStartTime(), ":", null, 2, null));
        int r102 = CastIntegerProtector.parseInt(StringsKt.substringAfter$default(r100.getStartTime(), ":", null, 2, null));
        StringBuilder r103 = new StringBuilder();
        List<Integer> r104 = r100.getRepeatDayOfWeek();
        if (r104 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == true) goto L11;
        List<Integer> r106 = r100.getRepeatDayOfWeek();
        Intrinsics.checkNotNull(r106);
        String r107 = convertDaysOfWeekToDesc(r106);
    L12:
        r103.append(r107);
        r103.append(convertTimeToDesc(r101, r102));
        return r103.toString();
    L11:
        String r108 = r100.getDate();
        Intrinsics.checkNotNull(r108);
        r107 = getTodayOrTomorrow(r108, r101, r102);
        goto L12
    L5:
        if (r104.isEmpty() == true) goto L8;
        r105 = false;
        goto L9
    }
}
