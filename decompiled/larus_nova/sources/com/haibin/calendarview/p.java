package com.haibin.calendarview;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String[] f276214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String[] f276215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String[] f276216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String[] f276217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<Integer, String[]> f276218e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String[] f276219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<Integer, String[]> f276220g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f276221h = null;

    static {
        f276218e = new HashMap();
        f276219f = null;
        f276220g = new HashMap();
        f276221h = new int[]{8697535, 306771, 677704, 5580477, 861776, 890180, 4631225, 354893, 634178, 2404022, 306762, 6966718, 675154, 861510, 6116026, 742478, 879171, 2714935, 613195, 7642049, 300884, 674632, 5973436, 435536, 447557, 4905656, 177741, 612162, 2398135, 300874, 6703934, 870993, 959814, 5690554, 372046, 177732, 3749688, 601675, 8165055, 824659, 870984, 7185723, 742735, 354885, 4894137, 154957, 601410, 2921910, 693578, 8080061, 445009, 742726, 5593787, 318030, 678723, 3484600, 338764, 9082175, 955730, 436808, 7001404, 701775, 308805, 4871993, 677709, 337474, 4100917, 890185, 7711422, 354897, 617798, 5549755, 306511, 675139, 5056183, 861515, 9261759, 742482, 748103, 6909244, 613200, 301893, 4869049, 674637, 11216322, 435540, 447561, 7002685, 702033, 612166, 5543867, 300879, 412484, 3581239, 959818, 8827583, 371795, 702023, 5846716, 601680, 824901, 5065400, 870988, 894273, 2468534, 354889, 8039869, 154962, 601415, 6067642, 693582, 739907, 4937015, 709962, 9788095, 309843, 678728, 6630332, 338768, 693061, 4672185, 436812, 709953, 2415286, 308810, 6969149, 675409, 861766, 6198074, 873293, 371267, 3585335, 617803, 11841215, 306515, 675144, 7153084, 861519, 873028, 6138424, 744012, 355649, 2403766, 301898, 8014782, 674641, 697670, 5984954, 447054, 711234, 3496759, 603979, 8689601, 300883, 412488, 6726972, 959823, 436804, 4896312, 699980, 601666, 3970869, 824905, 8211133, 870993, 894277, 5614266, 354894, 683331, 4533943, 339275, 9082303, 693587, 739911, 7034171, 709967, 350789, 4873528, 678732, 338754, 3838902, 430921, 7809469, 436817, 709958, 5561018, 308814, 677699, 4532024, 861770, 9343806, 873042, 895559, 6731067, 355663, 306757, 4869817, 675148, 857409, 2986677};
    }

    public static void c(Calendar r310) {
        int r100 = r310.getYear();
        int r101 = r310.getMonth();
        int r102 = r310.getDay();
        int r103 = f.i(r310);
        if (r103 == 0) goto L7;
        if (r103 == 6) goto L7;
        boolean r104 = false;
    L8:
        r310.setWeekend(r104);
        r310.setWeek(f.i(r310));
        Calendar r105 = new Calendar();
        r310.setLunarCalendar(r105);
        int[] r106 = new int[4];
        int[] r110 = q.f276223b;
        int r111 = r100 - r110[0];
        if (r110[r111] <= (((r100 << 9) | (r101 << 5)) | r102)) goto L11;
        r111 = r111 - 1;
    L11:
        int r112 = r110[r111];
        long r113 = q.a(r100, r101, r102) - q.a((2096640 & r112) >> 9, (r112 & 480) >> 5, (r112 & 31) >> 0);
        int r114 = q.f276222a[r111];
        int r115 = 13;
        int r116 = (122880 & r114) >> 13;
        int r117 = r111 + r110[0];
        long r107 = r113 + 1;
        int r118 = 0;
        int r119 = 1;
    L13:
        if (r118 >= r115) goto L21;
        int r210 = 12 - r118;
        int[] r211 = r106;
        if (((r114 & (1 << r210)) >> r210) != 1) goto L17;
        int r120 = 30;
    L18:
        long r108 = r120;
        if (r107 <= r108) goto L22;
        r119 = r119 + 1;
        r107 = r107 - r108;
        r118 = r118 + 1;
        r106 = r211;
        r115 = 13;
    L22:
        int r109 = (int) r107;
        r211[0] = r117;
        r211[1] = r119;
        r211[3] = 0;
        if (r116 == 0) goto L28;
        if (r119 <= r116) goto L28;
        r211[1] = r119 - 1;
        if (r119 != (r116 + 1)) goto L28;
        r211[3] = 1;
    L28:
        r211[2] = r109;
        r105.setYear(r117);
        r105.setMonth(r211[1]);
        r105.setDay(r211[2]);
        if ((r100 % 4) != 0) goto L33;
        if ((r100 % 100) == 0) goto L33;
    L34:
        boolean r121 = true;
    L36:
        r310.setLeapYear(r121);
        if (r211[3] != 1) goto L39;
        r310.setLeapMonth(r211[1]);
        r105.setLeapMonth(r211[1]);
    L39:
        HashMap r122 = (HashMap) f276220g;
        if (r122.containsKey(Integer.valueOf(r100)) == true) goto L53;
        Integer r123 = Integer.valueOf(r100);
        int r124 = 24;
        String[] r125 = new String[24];
        String[] r126 = new String[3];
        double r127 = ((double) ((r100 - 1) - 2000)) * 365.2422d;
        int r128 = 21;
    L43:
        if (r128 >= r124) goto L45;
        r126[r128 - 21] = u.g((u.e((((double) r128) * 15.2d) + r127, r128 * 15) + 2451545.0d) + 0.3333333333333333d).toString() + u.f276225a[r128];
        r128 = r128 + 1;
        r124 = 24;
        goto L43
    L45:
        String[] r129 = new String[2];
        int r130 = 19;
    L47:
        if (r130 >= 21) goto L49;
        String[] r131 = r129;
        r131[r130 - 19] = u.g((u.e((((double) r130) * 15.2d) + r127, r130 * 15) + 2451545.0d) + 0.3333333333333333d).toString() + u.f276225a[r130];
        r130 = r130 + 1;
        r129 = r131;
        r126 = r126;
        goto L47
    L49:
        System.arraycopy(r126, 0, r125, 0, 3);
        System.arraycopy(r129, 0, r125, 22, 2);
        double r132 = ((double) (r100 - 2000)) * 365.2422d;
        int r133 = 0;
    L50:
        if (r133 >= 19) goto L52;
        r125[r133 + 3] = u.g((u.e((((double) r133) * 15.2d) + r132, r133 * 15) + 2451545.0d) + 0.3333333333333333d).toString() + u.f276225a[r133];
        r133 = r133 + 1;
        goto L50
    L52:
        r122.put(r123, r125);
    L53:
        String[] r134 = (String[]) ((HashMap) f276220g).get(Integer.valueOf(r100));
        String r135 = r100 + b(r101, r102);
        int r136 = r134.length;
        int r137 = 0;
    L54:
        String r138 = "";
        if (r137 >= r136) goto L60;
        String r139 = r134[r137];
        if (r139.contains(r135) == true) goto L58;
        r137 = r137 + 1;
        goto L54
    L58:
        String r140 = r139.replace(r135, "");
    L61:
        String r141 = b(r101, r102);
        String[] r142 = f276219f;
        int r143 = r142.length;
        int r144 = 0;
    L62:
        if (r144 >= r143) goto L67;
        String r145 = r142[r144];
        if (r145.contains(r141) == true) goto L65;
        r144 = r144 + 1;
        goto L62
    L65:
        String r146 = r145.replace(r141, "");
    L68:
        int r147 = r211[0];
        int r148 = r211[1];
        int r149 = r211[2];
        if (r148 == 12) goto L71;
    L76:
        String r150 = b(r148, r149);
        String[] r151 = f276215b;
        int r152 = r151.length;
        int r153 = 0;
    L77:
        if (r153 >= r152) goto L82;
        String r154 = r151[r153];
        if (r154.contains(r150) == true) goto L80;
        r153 = r153 + 1;
        goto L77
    L80:
        String r155 = r154.replace(r150, "");
    L83:
        int r156 = r211[1];
        int r157 = r211[2];
        int r158 = r211[3];
        if (r157 != 1) goto L88;
        if (r158 != 1) goto L87;
        String r159 = "闰" + f276214a[r156 - 1];
    L89:
        String r160 = r159;
        if (TextUtils.isEmpty(r146) == false) goto L114;
        HashMap r161 = (HashMap) f276218e;
        if (r161.containsKey(Integer.valueOf(r100)) == true) goto L107;
        Integer r162 = Integer.valueOf(r100);
        String[] r163 = new String[3];
        java.util.Calendar r164 = java.util.Calendar.getInstance();
        r164.set(r100, 4, 1);
        int r165 = (7 - r164.get(7)) + 1;
        if (r165 != 7) goto L96;
        r163[0] = a(r100, 5, r165 + 1) + f276217d[0];
        int r166 = 5;
        int r167 = 1;
    L97:
        r164.set(r100, r166, r167);
        int r168 = (7 - r164.get(7)) + r167;
        if (r168 != 7) goto L100;
        r163[1] = a(r100, 6, (r168 + 7) + 1) + f276217d[1];
        int r169 = 1;
    L101:
        r164.set(r100, 10, r169);
        int r170 = (7 - r164.get(7)) + r169;
        if (r170 > 2) goto L104;
        r163[2] = a(r100, 11, (r170 + 21) + 5) + f276217d[2];
    L105:
        r161.put(r162, r163);
        goto L107
    L104:
        r163[2] = a(r100, 11, (r170 + 14) + 5) + f276217d[2];
        goto L105
    L100:
        StringBuilder r171 = new StringBuilder();
        r171.append(a(r100, 6, ((r168 + 7) + 7) + r167));
        r169 = 1;
        r171.append(f276217d[1]);
        r163[1] = r171.toString();
        goto L101
    L96:
        StringBuilder r172 = new StringBuilder();
        r166 = 5;
        r172.append(a(r100, 5, (r165 + 7) + 1));
        r172.append(f276217d[0]);
        r163[0] = r172.toString();
        r167 = 1;
    L107:
        String[] r173 = (String[]) r161.get(Integer.valueOf(r100));
        String r174 = r100 + b(r101, r102);
        int r175 = r173.length;
        int r176 = 0;
    L108:
        if (r176 >= r175) goto L113;
        String r177 = r173[r176];
        if (r177.contains(r174) == true) goto L111;
        r176 = r176 + 1;
        goto L108
    L111:
        r138 = r177.replace(r174, "");
    L113:
        r146 = r138;
    L114:
        r310.setSolarTerm(r140);
        r310.setGregorianFestival(r146);
        r310.setTraditionFestival(r155);
        r105.setTraditionFestival(r155);
        r105.setSolarTerm(r140);
        if (TextUtils.isEmpty(r140) == true) goto L118;
        r310.setLunar(r140);
    L124:
        r105.setLunar(r160);
        return;
    L118:
        if (TextUtils.isEmpty(r146) == true) goto L121;
        r310.setLunar(r146);
        goto L124
    L121:
        if (TextUtils.isEmpty(r155) == true) goto L123;
        r310.setLunar(r155);
        goto L124
    L123:
        r310.setLunar(r160);
        goto L124
    L87:
        r159 = f276214a[r156 - 1];
        goto L89
    L88:
        r159 = f276216c[r157 - 1];
        goto L89
    L82:
        r155 = "";
        goto L83
    L71:
        if ((f276221h[r147 - 1900] & (1048576 >> r148)) != 0) goto L73;
        int r178 = 29;
    L74:
        if (r149 != r178) goto L76;
        r155 = f276215b[0];
        goto L83
    L73:
        r178 = 30;
        goto L74
    L67:
        r146 = "";
        goto L68
    L60:
        r140 = "";
    L33:
        if ((r100 % 400) == 0) goto L34;
        r121 = false;
        goto L36
    L17:
        r120 = 29;
        goto L18
    L21:
        r211 = r106;
    L7:
        r104 = true;
        goto L8
    }

    public static String b(int r100, int r101) {
        StringBuilder r102 = new StringBuilder();
        if (r100 < 10) goto L5;
        String r103 = String.valueOf(r100);
    L6:
        r102.append(r103);
        if (r101 < 10) goto L9;
        Object r104 = Integer.valueOf(r101);
    L10:
        r102.append(r104);
        return r102.toString();
    L9:
        r104 = "0" + r101;
        goto L10
    L5:
        r103 = "0" + r100;
        goto L6
    }

    public static String a(int r100, int r101, int r102) {
        return r100 + b(r101, r102);
    }
}
