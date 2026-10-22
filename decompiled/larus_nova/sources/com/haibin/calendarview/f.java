package com.haibin.calendarview;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class f {
    public static int i(Calendar r100) {
        java.util.Calendar r101 = java.util.Calendar.getInstance();
        r101.set(r100.getYear(), r100.getMonth() - 1, r100.getDay());
        return r101.get(7) - 1;
    }

    public static int a(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return (int) ((r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }

    public static int c(int r100, int r101) {
        boolean r102 = false;
        if (r101 != 1) goto L5;
    L18:
        int r103 = 31;
    L20:
        if (r101 != 4) goto L22;
    L27:
        r103 = 30;
    L29:
        if (r101 == 2) goto L31;
        return r103;
    L31:
        if ((r100 % 4) != 0) goto L35;
        if ((r100 % 100) == 0) goto L35;
    L36:
        r102 = true;
    L37:
        if (r102 == false) goto L39;
        return 29;
    L39:
        return 28;
    L35:
        if ((r100 % 400) != 0) goto L37;
    L22:
        if (r101 == 6) goto L27;
        if (r101 == 9) goto L27;
        if (r101 != 11) goto L29;
    L5:
        if (r101 == 3) goto L18;
        if (r101 == 5) goto L18;
        if (r101 == 7) goto L18;
        if (r101 == 8) goto L18;
        if (r101 == 10) goto L18;
        if (r101 == 12) goto L18;
        r103 = 0;
        goto L20
    }

    public static int g(Calendar r100, int r101) {
        java.util.Calendar r102 = java.util.Calendar.getInstance();
        r102.set(r100.getYear(), r100.getMonth() - 1, 1);
        int r103 = r102.get(7);
        if (r101 != 1) goto L7;
        return r103 - 1;
    L7:
        if (r101 != 2) goto L12;
        if (r103 != 1) goto L11;
        return 6;
    L11:
        return r103 - r101;
    L12:
        if (r103 != 7) goto L16;
        return 0;
    L16:
        return r103;
    }

    public static int j(Calendar r100, int r101) {
        java.util.Calendar.getInstance().set(r100.getYear(), r100.getMonth() - 1, 1);
        int r102 = g(r100, r101);
        return (((r100.getDay() + r102) - 1) / 7) + 1;
    }

    public static boolean o(Calendar r100, l r101) {
        int r102 = r101.T;
        int r103 = r101.V;
        int r104 = r101.X;
        int r105 = r101.U;
        int r106 = r101.W;
        int r107 = r101.Y;
        java.util.Calendar r108 = java.util.Calendar.getInstance();
        r108.set(r102, r103 - 1, r104);
        long r109 = r108.getTimeInMillis();
        r108.set(r105, r106 - 1, r107);
        long r110 = r108.getTimeInMillis();
        r108.set(r100.getYear(), r100.getMonth() - 1, r100.getDay());
        long r111 = r108.getTimeInMillis();
        if (r111 >= r109) goto L5;
    L7:
        return false;
    L5:
        if (r111 > r110) goto L7;
        return true;
    }

    public static int f(int r100, int r101, int r102) {
        java.util.Calendar r103 = java.util.Calendar.getInstance();
        r103.set(r100, r101 - 1, 1);
        int r104 = r103.get(7);
        if (r102 != 1) goto L7;
        return r104 - 1;
    L7:
        if (r102 != 2) goto L12;
        if (r104 != 1) goto L11;
        return 6;
    L11:
        return r104 - r102;
    L12:
        if (r104 != 7) goto L16;
        return 0;
    L16:
        return r104;
    }

    public static List<Calendar> n(Calendar r110, l r111, int r112) {
        java.util.Calendar r100 = java.util.Calendar.getInstance();
        r100.set(r110.getYear(), r110.getMonth() - 1, r110.getDay());
        long r101 = r100.getTimeInMillis();
        int r113 = k(r110.getYear(), r110.getMonth(), r110.getDay(), r112);
        ArrayList r114 = new ArrayList();
        r100.setTimeInMillis(r101);
        Calendar r102 = new Calendar();
        r102.setYear(r100.get(1));
        r102.setMonth(r100.get(2) + 1);
        r102.setDay(r100.get(5));
        if (r102.equals(r111.f276165e0) == false) goto L5;
        r102.setCurrentDay(true);
    L5:
        p.c(r102);
        r102.setCurrentMonth(true);
        r114.add(r102);
        int r103 = 1;
    L6:
        if (r103 > r113) goto L11;
        r100.setTimeInMillis((((long) r103) * 86400000) + r101);
        Calendar r104 = new Calendar();
        r104.setYear(r100.get(1));
        r104.setMonth(r100.get(2) + 1);
        r104.setDay(r100.get(5));
        if (r104.equals(r111.f276165e0) == false) goto L10;
        r104.setCurrentDay(true);
    L10:
        p.c(r104);
        r104.setCurrentMonth(true);
        r114.add(r104);
        r103 = r103 + 1;
        goto L6
    L11:
        return r114;
    }

    public static int d(int r100, int r101, int r102, int r103) {
        java.util.Calendar r104 = java.util.Calendar.getInstance();
        r104.set(r100, r101 - 1, r102);
        int r105 = r104.get(7);
        if (r103 != 1) goto L7;
        return 7 - r105;
    L7:
        if (r103 != 2) goto L12;
        if (r105 != 1) goto L11;
        return 0;
    L11:
        return (7 - r105) + 1;
    L12:
        if (r105 != 7) goto L15;
        return 6;
    L15:
        return (7 - r105) - 1;
    }

    public static int e(int r100, int r101, int r102, int r103) {
        java.util.Calendar.getInstance().set(r100, r101 - 1, 1);
        int r104 = f(r100, r101, r103);
        int r105 = c(r100, r101);
        return (((r104 + r105) + d(r100, r101, r105, r103)) / 7) * r102;
    }

    public static int k(int r100, int r101, int r102, int r103) {
        java.util.Calendar r104 = java.util.Calendar.getInstance();
        r104.set(r100, r101 - 1, r102);
        int r105 = r104.get(7);
        if (r103 != 1) goto L7;
        return 7 - r105;
    L7:
        if (r103 != 2) goto L12;
        if (r105 != 1) goto L11;
        return 0;
    L11:
        return (7 - r105) + 1;
    L12:
        if (r105 != 7) goto L15;
        return 6;
    L15:
        return (7 - r105) - 1;
    }

    public static int l(int r100, int r101, int r102, int r103) {
        java.util.Calendar r104 = java.util.Calendar.getInstance();
        r104.set(r100, r101 - 1, r102);
        int r105 = r104.get(7);
        if (r103 != 1) goto L7;
        return r105 - 1;
    L7:
        if (r103 != 2) goto L12;
        if (r105 != 1) goto L11;
        return 6;
    L11:
        return r105 - r103;
    L12:
        if (r105 != 7) goto L16;
        return 0;
    L16:
        return r105;
    }

    public static List<Calendar> m(int r110, int r111, Calendar r112, int r113) {
        int r100 = r111 - 1;
        java.util.Calendar.getInstance().set(r110, r100, 1);
        int r114 = f(r110, r111, r113);
        int r101 = c(r110, r111);
        ArrayList r102 = new ArrayList();
        int r103 = 12;
        int r104 = 0;
        if (r111 != 1) goto L9;
        int r105 = r110 - 1;
        int r106 = r111 + 1;
        if (r114 != 0) goto L7;
        int r107 = 0;
    L8:
        int r108 = r107;
        int r109 = r106;
        int r115 = r110;
    L20:
        int r116 = 1;
    L22:
        if (r104 >= 42) goto L34;
        Calendar r117 = new Calendar();
        if (r104 >= r114) goto L27;
        r117.setYear(r105);
        r117.setMonth(r103);
        r117.setDay(((r108 - r114) + r104) + 1);
    L31:
        if (r117.equals(r112) == false) goto L33;
        r117.setCurrentDay(true);
    L33:
        p.c(r117);
        r102.add(r117);
        r104 = r104 + 1;
        goto L22
    L27:
        if (r104 < (r101 + r114)) goto L29;
        r117.setYear(r115);
        r117.setMonth(r109);
        r117.setDay(r116);
        r116 = r116 + 1;
        goto L31
    L29:
        r117.setYear(r110);
        r117.setMonth(r111);
        r117.setCurrentMonth(true);
        r117.setDay((r104 - r114) + 1);
        goto L31
    L34:
        return r102;
    L7:
        r107 = c(r105, 12);
        goto L8
    L9:
        if (r111 != 12) goto L15;
        int r118 = r110 + 1;
        if (r114 != 0) goto L13;
        int r119 = 0;
    L14:
        r115 = r118;
        r108 = r119;
        r109 = 1;
        r103 = r100;
        r105 = r110;
        goto L20
    L13:
        r119 = c(r110, r100);
        goto L14
    L15:
        int r120 = r111 + 1;
        if (r114 != 0) goto L18;
        int r121 = 0;
    L19:
        r103 = r100;
        r108 = r121;
        r105 = r110;
        r109 = r120;
        r115 = r105;
        goto L20
    L18:
        r121 = c(r110, r100);
        goto L19
    }

    public static Calendar b(int r100, int r101, int r110, int r111, int r112) {
        java.util.Calendar r102 = java.util.Calendar.getInstance();
        r102.set(r100, r101 - 1, r110);
        long r113 = ((long) ((r111 - 1) * 7)) * 86400000;
        long r114 = r113 + r102.getTimeInMillis();
        r102.setTimeInMillis(r114);
        r102.setTimeInMillis(r114 - (((long) l(r102.get(1), r102.get(2) + 1, r102.get(5), r112)) * 86400000));
        Calendar r103 = new Calendar();
        r103.setYear(r102.get(1));
        r103.setMonth(r102.get(2) + 1);
        r103.setDay(r102.get(5));
        return r103;
    }

    public static int h(int r100, int r101, int r102, int r103, int r104, int r105, int r106) {
        java.util.Calendar r107 = java.util.Calendar.getInstance();
        r107.set(r100, r101 - 1, r102);
        long r108 = r107.getTimeInMillis();
        int r109 = l(r100, r101, r102, r106);
        r107.set(r103, r104 - 1, r105);
        return ((r109 + k(r103, r104, r105, r106)) + (((int) ((r107.getTimeInMillis() - r108) / 86400000)) + 1)) / 7;
    }
}
