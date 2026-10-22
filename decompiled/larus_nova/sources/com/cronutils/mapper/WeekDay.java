package com.cronutils.mapper;

import java.io.Serializable;
import zr7.a;

/* JADX INFO: loaded from: classes6.dex */
public class WeekDay implements Serializable {
    private static final long serialVersionUID = -1542525283511798919L;
    private final boolean firstDayZero;
    private final int mondayDoWValue;

    public int getMondayDoWValue() {
        return this.mondayDoWValue;
    }

    public boolean isFirstDayZero() {
        return this.firstDayZero;
    }

    public WeekDay(int r100, boolean r101) {
        if (r100 < 0) goto L5;
        boolean r102 = true;
    L6:
        a.a(r102, "Monday Day of Week value must be greater or equal to zero");
        this.mondayDoWValue = r100;
        this.firstDayZero = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public int mapTo(int r100, WeekDay r101) {
        if (this.firstDayZero == false) goto L22;
        if (r101.isFirstDayZero() == false) goto L22;
        Integer r102 = Integer.valueOf(r100);
        int r103 = r101.getMondayDoWValue() - getMondayDoWValue();
        int r104 = r102.intValue();
        if (r103 == 0) goto L20;
        if (r103 >= 0) goto L14;
        r104 = r102.intValue() + r103;
        int r105 = 0 - r104;
        if (r104 >= 0) goto L14;
        r104 = (1 + 6) - r105;
    L14:
        if (r103 <= 0) goto L18;
        r104 = r102.intValue() + r103;
        if (r104 <= 6) goto L18;
        r104 = r104 - 6;
    L18:
        r102 = Integer.valueOf(r104);
    L20:
        return r102.intValue();
    L22:
        if (this.firstDayZero == true) goto L40;
        if (r101.isFirstDayZero() == true) goto L40;
        Integer r106 = Integer.valueOf(r100);
        int r107 = r101.getMondayDoWValue() - getMondayDoWValue();
        int r108 = r106.intValue();
        if (r107 == 0) goto L38;
        if (r107 >= 0) goto L32;
        r108 = r106.intValue() + r107;
        int r109 = 1 - r108;
        if (r108 >= 1) goto L32;
        r108 = (1 + 7) - r109;
    L32:
        if (r107 <= 0) goto L36;
        r108 = r106.intValue() + r107;
        if (r108 <= 7) goto L36;
        r108 = r108 - 7;
    L36:
        r106 = Integer.valueOf(r108);
    L38:
        return r106.intValue();
    L40:
        if (r101.isFirstDayZero() == false) goto L44;
        return mapTo(r100, new WeekDay(r101.getMondayDoWValue() + 1, false)) - 1;
    L44:
        return (mapTo(r100, new WeekDay(r101.getMondayDoWValue() - 1, true)) % 7) + 1;
    }
}
