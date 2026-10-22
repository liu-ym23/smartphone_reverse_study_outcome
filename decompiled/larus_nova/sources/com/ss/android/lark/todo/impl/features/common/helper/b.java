package com.ss.android.lark.todo.impl.features.common.helper;

import android.content.Context;
import com.larksuite.framework.utils.ICUUtils;
import com.larus.nova.R;
import com.ss.android.lark.time.format.entity.DisplayPattern;
import com.ss.android.lark.time.format.entity.LengthType;
import com.ss.android.lark.time.format.entity.TimePreciseness;
import com.ss.android.lark.todo.impl.features.common.entity.EndTimeTextAttribute;
import com.ss.android.lark.todo.impl.utils.i;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f442448a = 0;

    static {
    }

    public b() {
    }

    public static /* synthetic */ EndTimeTextAttribute b(Context r100, long r101, boolean r102, boolean r110) {
        return a(r100, r101, r102, r110, false);
    }

    public static EndTimeTextAttribute a(Context r110, long r111, boolean r210, boolean r211, boolean r212) {
        long r100 = r111;
        if (r110 == null) goto L36;
        if (r100 <= 0) goto L36;
        TimeZone r101 = TimeZone.getDefault();
        boolean r102 = true;
        if (r210 == false) goto L10;
        TimeZone r103 = TimeZone.getTimeZone("UTC");
        GregorianCalendar r104 = new GregorianCalendar();
        r104.setTimeZone(r103);
        r104.setTimeInMillis(r100);
        long r105 = new GregorianCalendar(r104.get(1), r104.get(2), r104.get(5), 0, 0, 0).getTimeInMillis();
        String r106 = c7c.b.a(r110, new Date(r105), new c7c.a(r101.getID(), DisplayPattern.RELATIVE, null, null, null, false, false, false, false, 1916));
        r100 = r105;
    L18:
        Intrinsics.checkNotNull(r101);
        GregorianCalendar r107 = new GregorianCalendar(r101);
        r107.setTime(new Date(r100));
        GregorianCalendar r108 = new GregorianCalendar(r101);
        int r109 = com.ss.android.lark.todo.impl.utils.c.b(r107) - com.ss.android.lark.todo.impl.utils.c.b(r108);
        if (r109 != 0) goto L27;
        if (r210 == false) goto L22;
    L24:
        if (r212 == false) goto L26;
        int r112 = y9c.d.c(r110, R.color.text_link_normal);
    L34:
        return new EndTimeTextAttribute(r106, r112);
    L26:
        r112 = y9c.d.c(r110, R.color.primary_fill_default);
        goto L34
    L22:
        if (r107.getTimeInMillis() >= r108.getTimeInMillis()) goto L24;
        r112 = y9c.d.c(r110, R.color.function_danger_content_default);
        goto L34
    L27:
        if (r109 <= 0) goto L32;
        if (r212 == false) goto L30;
        int r113 = R.color.text_title;
    L31:
        r112 = y9c.d.c(r110, r113);
        goto L34
    L30:
        r113 = R.color.text_caption;
        goto L31
    L32:
        r112 = y9c.d.c(r110, R.color.function_danger_fill_default);
        goto L34
    L10:
        Date r114 = new Date(r100);
        String r115 = r101.getID();
        boolean r116 = !r211;
        TimePreciseness r117 = TimePreciseness.MINUTE;
        DisplayPattern r118 = DisplayPattern.ABSOLUTE;
        if (new Date(r100).getYear() == new Date(System.currentTimeMillis()).getYear()) goto L14;
        r102 = false;
    L14:
        if (r102 == false) goto L16;
        LengthType r119 = LengthType.SHORT;
    L17:
        r106 = c7c.b.c(r110, r114, new c7c.a(r115, r118, r119, null, r117, false, r116, false, false, 1896));
        goto L18
    L16:
        r119 = LengthType.LONG;
    L36:
        return new EndTimeTextAttribute("", i.f444291a.a(R.color.lkui_N500));
    }

    public static EndTimeTextAttribute c(Context r100, long r101, long r102, boolean r110, boolean r111, boolean r112, int r113) {
        if ((r113 & 32) == 0) goto L6;
        r112 = false;
    L6:
        if (r101 != 0) goto L8;
    L10:
        if (r101 == 0) goto L14;
        EndTimeTextAttribute r103 = a(r100, r101, r110, r111, false);
        r103.setEndTimeColor(y9c.d.c(r100, R.color.text_caption));
        if (r112 == false) goto L19;
        r103.setEndTimeStr(ICUUtils.icuFormat(i.f444291a.g(R.string.Todo_TaskStartsFrom_Text), "day_time", r103.getEndTimeStr()));
        return r103;
    L19:
        return r103;
    L14:
        EndTimeTextAttribute r104 = a(r100, r102, r110, r111, false);
        if (r112 == false) goto L21;
        i r105 = i.f444291a;
        r104.setEndTimeStr(i.d(R.string.Todo_Task_TimeDue, "Time", r104.getEndTimeStr()));
        return r104;
    L21:
        return r104;
    L8:
        if (r102 == 0) goto L10;
        EndTimeTextAttribute r106 = a(r100, r101, r110, r111, false);
        EndTimeTextAttribute r107 = a(r100, r102, r110, r111, false);
        return new EndTimeTextAttribute(r106.getEndTimeStr() + " - " + r107.getEndTimeStr(), r107.getEndTimeColor());
    }
}
