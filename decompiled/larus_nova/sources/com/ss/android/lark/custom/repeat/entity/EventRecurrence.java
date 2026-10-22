package com.ss.android.lark.custom.repeat.entity;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.log.Log;
import com.ss.ttm.player.MediaPlayer;
import com.ttnet.org.chromium.net.NetError;
import java.util.HashMap;

/* JADX INFO: loaded from: classes35.dex */
public final class EventRecurrence {
    public static final String A = null;
    public static final HashMap<String, o> B = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final HashMap<String, Integer> f420300y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final HashMap<String, Integer> f420301z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f420302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f420303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f420304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f420305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f420306e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f420307f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f420308g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f420309h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f420310i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f420311j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f420312k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int[] f420313l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f420314m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f420315n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int[] f420316o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f420317p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int[] f420318q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f420319r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int[] f420320s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f420321t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int[] f420322u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f420323v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int[] f420324w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f420325x;

    public static class InvalidFormatException extends RuntimeException {
        private static final long serialVersionUID = -6734979874313418099L;

        public InvalidFormatException(String r100) {
            super(r100);
        }
    }

    public static class a extends o {
        public a(int r100) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r100, EventRecurrence r101) {
            int r102 = 0;
            if (r100.indexOf(",") >= 0) goto L5;
            int r103 = 1;
            int[] r104 = new int[1];
            int[] r105 = new int[1];
            d(r100, r104, r105, 0);
        L8:
            r101.f420313l = r104;
            r101.f420314m = r105;
            r101.f420315n = r103;
            return 128;
        L5:
            String[] r106 = r100.split(",");
            r103 = r106.length;
            r104 = new int[r103];
            r105 = new int[r103];
        L6:
            if (r102 >= r103) goto L8;
            d(r106[r102], r104, r105, r102);
            r102 = r102 + 1;
            goto L6
        }

        public static void d(String r100, int[] r101, int[] r102, int r103) {
            int r104 = r100.length() - 2;
            if (r104 <= 0) goto L5;
            r102[r103] = o.a(r100.substring(0, r104), -53, 53, false);
            String r105 = r100.substring(r104);
        L6:
            Integer r106 = EventRecurrence.f420301z.get(r105);
            if (r106 == null) goto L11;
            r101[r103] = r106.intValue();
            return;
        L11:
            throw new InvalidFormatException("Invalid BYDAY value: ".concat(r100));
        L5:
            r105 = r100;
            goto L6
        }
    }

    public static class b extends o {
        public b(int r100) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r100, EventRecurrence r101) {
            int[] r102 = o.b(r100, 0, 23, true);
            r101.f420311j = r102;
            r101.f420312k = r102.length;
            return 64;
        }
    }

    public static class c extends o {
        public c(int r100) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r100, EventRecurrence r101) {
            int[] r102 = o.b(r100, 0, 59, true);
            r101.f420309h = r102;
            r101.f420310i = r102.length;
            return 32;
        }
    }

    public static class d extends o {
        public d(int r100) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r100, EventRecurrence r101) {
            int[] r102 = o.b(r100, 1, 12, false);
            r101.f420322u = r102;
            r101.f420323v = r102.length;
            return 2048;
        }
    }

    public static class e extends o {
        public e(int r100) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r100, EventRecurrence r101) {
            int[] r102 = o.b(r100, -31, 31, false);
            r101.f420316o = r102;
            r101.f420317p = r102.length;
            return 256;
        }
    }

    public static class f extends o {
        public f(int r100) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r100, EventRecurrence r101) {
            int[] r102 = o.b(r100, 0, 59, true);
            r101.f420307f = r102;
            r101.f420308g = r102.length;
            return 16;
        }
    }

    public static class g extends o {
        public g(int r100) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r100, EventRecurrence r101) {
            int[] r102 = o.b(r100, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
            r101.f420324w = r102;
            r101.f420325x = r102.length;
            return 4096;
        }
    }

    public static class h extends o {
        public h(int r100) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r100, EventRecurrence r101) {
            int[] r102 = o.b(r100, -53, 53, false);
            r101.f420320s = r102;
            r101.f420321t = r102.length;
            return 1024;
        }
    }

    public static class i extends o {
        public i(int r100) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r100, EventRecurrence r101) {
            int[] r102 = o.b(r100, NetError.ERR_PROXY_HTTP_1_1_REQUIRED, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME, false);
            r101.f420318q = r102;
            r101.f420319r = r102.length;
            return 512;
        }
    }

    public static class j extends o {
        public j(int r100) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r100, EventRecurrence r101) {
            int r102 = o.a(r100, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
            r101.f420304c = r102;
            if (r102 >= 0) goto L7;
            Log.d(EventRecurrence.A, "Invalid Count. Forcing COUNT to 1 from ".concat(r100));
            r101.f420304c = 1;
            return 4;
        L7:
            return 4;
        }
    }

    public static class k extends o {
        public k(int r100) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r100, EventRecurrence r101) {
            Integer r102 = EventRecurrence.f420300y.get(r100);
            if (r102 == null) goto L7;
            r101.f420302a = r102.intValue();
            return 1;
        L7:
            throw new InvalidFormatException("Invalid FREQ value: ".concat(r100));
        }
    }

    public static class l extends o {
        public l(int r100) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r100, EventRecurrence r101) {
            int r102 = o.a(r100, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
            r101.f420305d = r102;
            if (r102 >= 1) goto L7;
            Log.d(EventRecurrence.A, "Invalid Interval. Forcing INTERVAL to 1 from ".concat(r100));
            r101.f420305d = 1;
            return 8;
        L7:
            return 8;
        }
    }

    public static class m extends o {
        public m(int r100) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r100, EventRecurrence r101) {
            r101.f420303b = r100;
            return 2;
        }
    }

    public static class n extends o {
        public n(int r100) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r100, EventRecurrence r101) {
            Integer r102 = EventRecurrence.f420301z.get(r100);
            if (r102 == null) goto L7;
            r101.f420306e = r102.intValue();
            return 8192;
        L7:
            throw new InvalidFormatException("Invalid WKST value: ".concat(r100));
        }
    }

    public static abstract class o {
        public o() {
        }

        public abstract int c(String r100, EventRecurrence r101);

        public static int a(String r100, int r101, int r102, boolean r103) {
            if (r100.charAt(0) != '+') goto L6;
            r100 = r100.substring(1);     // Catch: NumberFormatException -> L14
        L6:
            int r104 = CastIntegerProtector.parseInt(r100);     // Catch: NumberFormatException -> L14
            if (r104 < r101) goto L13;
            if (r104 > r102) goto L13;
            if (r104 != 0) goto L11;
            if (r103 == false) goto L13;
        L11:
            return r104;
        L13:
            throw new InvalidFormatException("Integer value out of range: " + r100);     // Catch: NumberFormatException -> L14
        L15:
            throw new InvalidFormatException("Invalid integer value: " + r100);
        }

        public static int[] b(String r100, int r101, int r102, boolean r103) {
            int r104 = 0;
            if (r100.indexOf(",") < 0) goto L11;
            String[] r105 = r100.split(",");
            int r106 = r105.length;
            int[] r107 = new int[r106];
        L6:
            if (r104 >= r106) goto L9;
            r107[r104] = a(r105[r104], r101, r102, r103);
            r104 = r104 + 1;
            goto L6
        L9:
            return r107;
        L11:
            return new int[]{a(r100, r101, r102, r103)};
        }
    }

    public EventRecurrence() {
    }

    static {
        HashMap<String, Integer> r100 = new HashMap();
        f420300y = r100;
        HashMap<String, Integer> r101 = new HashMap();
        f420301z = r101;
        A = "EventRecur";
        HashMap<String, o> r102 = new HashMap();
        B = r102;
        r102.put("FREQ", new k(0));
        r102.put("UNTIL", new m(0));
        r102.put("COUNT", new j(0));
        r102.put("INTERVAL", new l(0));
        r102.put("BYSECOND", new f(0));
        r102.put("BYMINUTE", new c(0));
        r102.put("BYHOUR", new b(0));
        r102.put("BYDAY", new a(0));
        r102.put("BYMONTHDAY", new e(0));
        r102.put("BYYEARDAY", new i(0));
        r102.put("BYWEEKNO", new h(0));
        r102.put("BYMONTH", new d(0));
        r102.put("BYSETPOS", new g(0));
        r102.put("WKST", new n(0));
        r100.put("SECONDLY", 1);
        r100.put("MINUTELY", 2);
        r100.put("HOURLY", 3);
        r100.put("DAILY", 4);
        r100.put("WEEKLY", 5);
        r100.put("MONTHLY", 6);
        r100.put("YEARLY", 7);
        r101.put("SU", 65536);
        r101.put("MO", 131072);
        r101.put("TU", 262144);
        r101.put("WE", 524288);
        r101.put("TH", 1048576);
        r101.put("FR", 2097152);
        r101.put("SA", 4194304);
    }

    public final int hashCode() {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append("FREQ=");
        switch(this.f420302a) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L13;
        };
    L5:
        r100.append("YEARLY");
        goto L13
    L6:
        r100.append("MONTHLY");
        goto L13
    L7:
        r100.append("WEEKLY");
        goto L13
    L8:
        r100.append("DAILY");
        goto L13
    L9:
        r100.append("HOURLY");
        goto L13
    L10:
        r100.append("MINUTELY");
        goto L13
    L11:
        r100.append("SECONDLY");
    L13:
        if (TextUtils.isEmpty(this.f420303b) == true) goto L19;
        r100.append(";UNTIL=");
        if (TextUtils.isEmpty(null) == true) goto L17;
        r100.append(null);
        goto L19
    L17:
        r100.append(this.f420303b);
    L19:
        if (this.f420304c == 0) goto L22;
        r100.append(";COUNT=");
        r100.append(this.f420304c);
    L22:
        if (this.f420305d == 0) goto L25;
        r100.append(";INTERVAL=");
        r100.append(this.f420305d);
    L25:
        if (this.f420306e == 0) goto L27;
        r100.append(";WKST=");
        r100.append(c(this.f420306e));
    L27:
        a(r100, ";BYSECOND=", this.f420308g, this.f420307f);
        a(r100, ";BYMINUTE=", this.f420310i, this.f420309h);
        a(r100, ";BYSECOND=", this.f420312k, this.f420311j);
        int r101 = this.f420315n;
        if (r101 <= 0) goto L39;
        r100.append(";BYDAY=");
        int r102 = r101 - 1;
        int r103 = 0;
    L30:
        if (r103 >= r102) goto L35;
        int r104 = this.f420314m[r103];
        if (r104 == 0) goto L34;
        r100.append(r104);
    L34:
        r100.append(c(this.f420313l[r103]));
        r100.append(",");
        r103 = r103 + 1;
        goto L30
    L35:
        int r105 = this.f420314m[r102];
        if (r105 == 0) goto L38;
        r100.append(r105);
    L38:
        r100.append(c(this.f420313l[r102]));
    L39:
        a(r100, ";BYMONTHDAY=", this.f420317p, this.f420316o);
        a(r100, ";BYYEARDAY=", this.f420319r, this.f420318q);
        a(r100, ";BYWEEKNO=", this.f420321t, this.f420320s);
        a(r100, ";BYMONTH=", this.f420323v, this.f420322u);
        a(r100, ";BYSETPOS=", this.f420325x, this.f420324w);
        return r100.toString();
    }

    public static String c(int r100) {
        if (r100 != 65536) goto L5;
        return "SU";
    L5:
        if (r100 != 131072) goto L7;
        return "MO";
    L7:
        if (r100 != 262144) goto L9;
        return "TU";
    L9:
        if (r100 != 524288) goto L11;
        return "WE";
    L11:
        if (r100 != 1048576) goto L13;
        return "TH";
    L13:
        if (r100 != 2097152) goto L15;
        return "FR";
    L15:
        if (r100 != 4194304) goto L19;
        return "SA";
    L19:
        throw new IllegalArgumentException("bad day argument: " + r100);
    }

    public static EventRecurrence d(String r110) {
        EventRecurrence r100 = new EventRecurrence();
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return r100;
    L5:
        r100.f420303b = null;
        r100.f420325x = 0;
        r100.f420323v = 0;
        r100.f420321t = 0;
        r100.f420319r = 0;
        r100.f420317p = 0;
        r100.f420315n = 0;
        r100.f420312k = 0;
        r100.f420310i = 0;
        r100.f420308g = 0;
        r100.f420305d = 0;
        r100.f420304c = 0;
        r100.f420302a = 0;
        String[] r101 = r110.toUpperCase().split(com.alipay.sdk.m.u.i.f25853b);
        int r102 = r101.length;
        int r103 = 0;
        int r104 = 0;
    L6:
        if (r103 >= r102) goto L32;
        String r105 = r101[r103];
        if (TextUtils.isEmpty(r105) == true) goto L24;
        int r106 = r105.indexOf(61);
        if (r106 <= 0) goto L30;
        String r107 = r105.substring(0, r106);
        String r108 = r105.substring(r106 + 1);
        if (r108.length() == 0) goto L28;
        o r109 = B.get(r107);
        if (r109 == null) goto L17;
        int r111 = r109.c(r108, r100);
        if ((r104 & r111) != 0) goto L26;
        r104 = r104 | r111;
        goto L24
    L26:
        throw new InvalidFormatException("Part " + r107 + " was specified twice");
    L17:
        if (r107.startsWith("X-") == true) goto L24;
        throw new InvalidFormatException("Couldn't find parser for ".concat(r107));
    L28:
        throw new InvalidFormatException("Missing RHS in ".concat(r105));
    L30:
        throw new InvalidFormatException("Missing LHS in ".concat(r105));
    L24:
        r103 = r103 + 1;
        goto L6
    L32:
        if ((r104 & 8192) != 0) goto L35;
        r100.f420306e = 131072;
    L35:
        if ((r104 & 1) == 0) goto L41;
        if ((r104 & 6) != 6) goto L39;
        Log.w(A, "Warning: rrule has both UNTIL and COUNT: ".concat(r110));
    L39:
        return r100;
    L41:
        throw new InvalidFormatException("Must specify a FREQ value");
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EventRecurrence) == true) goto L8;
        return false;
    L8:
        EventRecurrence r101 = (EventRecurrence) r100;
        r101.getClass();
        if (this.f420302a != r101.f420302a) goto L44;
        String r102 = this.f420303b;
        if (r102 != null) goto L16;
        if (r101.f420303b != null) goto L44;
    L18:
        if (this.f420304c != r101.f420304c) goto L44;
        if (this.f420305d != r101.f420305d) goto L44;
        if (this.f420306e != r101.f420306e) goto L44;
        if (b(this.f420307f, this.f420308g, r101.f420307f, r101.f420308g) == false) goto L44;
        if (b(this.f420309h, this.f420310i, r101.f420309h, r101.f420310i) == false) goto L44;
        if (b(this.f420311j, this.f420312k, r101.f420311j, r101.f420312k) == false) goto L44;
        if (b(this.f420313l, this.f420315n, r101.f420313l, r101.f420315n) == false) goto L44;
        if (b(this.f420314m, this.f420315n, r101.f420314m, r101.f420315n) == false) goto L44;
        if (b(this.f420316o, this.f420317p, r101.f420316o, r101.f420317p) == false) goto L44;
        if (b(this.f420318q, this.f420319r, r101.f420318q, r101.f420319r) == false) goto L44;
        if (b(this.f420320s, this.f420321t, r101.f420320s, r101.f420321t) == false) goto L44;
        if (b(this.f420322u, this.f420323v, r101.f420322u, r101.f420323v) == false) goto L44;
        if (b(this.f420324w, this.f420325x, r101.f420324w, r101.f420325x) == false) goto L44;
        return true;
    L16:
        if (r102.equals(r101.f420303b) == true) goto L18;
    L44:
        return false;
    }

    public static void a(StringBuilder r100, String r101, int r102, int[] r103) {
        if (r102 <= 0) goto L9;
        r100.append(r101);
        int r104 = r102 - 1;
        int r105 = 0;
    L4:
        if (r105 >= r104) goto L6;
        r100.append(r103[r105]);
        r100.append(",");
        r105 = r105 + 1;
        goto L4
    L6:
        r100.append(r103[r104]);
        return;
    }

    public static boolean b(int[] r100, int r101, int[] r102, int r103) {
        if (r101 == r103) goto L5;
        return false;
    L5:
        int r104 = 0;
    L6:
        if (r104 >= r101) goto L11;
        if (r100[r104] != r102[r104]) goto L9;
        r104 = r104 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }
}
