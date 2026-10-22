package n4a;

import kotlin.UByte;

/* JADX INFO: loaded from: classes32.dex */
public final class v2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f517819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f517820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f517821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f517822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f517823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f517824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public short f517825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f517826h;

    public v2(boolean r100) {
        this.f517821c = -113;
        this.f517824f = 0;
        this.f517826h = r100;
    }

    public static long a(String r110) {
        if (r110 != null) goto L5;
    L35:
        return 0;
    L5:
        if (r110.length() == 0) goto L35;
        int r100 = r110.length() - 1;
        int r101 = 0;
        long r102 = 0;
    L8:
        if (r100 < 0) goto L32;
        long r103 = r110.charAt(r100);
        if (r103 >= 48) goto L12;
    L15:
        long r111 = 97;
        if (r103 >= 97) goto L18;
    L20:
        r111 = 65;
        if (r103 < 65) goto L26;
        if (r103 > 70) goto L26;
    L19:
        long r104 = (r103 - r111) + 10;
    L14:
        r102 = r102 + (r104 << r101);
        r101 = r101 + 4;
    L30:
        r100 = r100 - 1;
    L26:
        if (r103 == 58) goto L30;
        if (r103 == 124) goto L30;
        return 0;
    L18:
        if (r103 > 102) goto L20;
    L12:
        if (r103 > 57) goto L15;
        r104 = r103 - 48;
        goto L14
    L32:
        if (r101 == 48) goto L34;
        return 0;
    L34:
        return r102;
    }

    public final String toString() {
        return "AmapWifi{mac=" + this.f517819a + ", ssid='" + this.f517820b + "', rssi=" + this.f517821c + ", frequency=" + this.f517822d + ", timestamp=" + this.f517823e + ", lastUpdateUtcMills=" + this.f517824f + ", freshness=" + this.f517825g + ", connected=" + this.f517826h + '}';
    }

    public final Object clone() throws CloneNotSupportedException {
        boolean r100 = this.f517826h;
        v2 r101 = new v2(r100);
        r101.f517819a = this.f517819a;
        r101.f517820b = this.f517820b;
        r101.f517821c = this.f517821c;
        r101.f517822d = this.f517822d;
        r101.f517823e = this.f517823e;
        r101.f517824f = this.f517824f;
        r101.f517825g = this.f517825g;
        r101.f517826h = r100;
        return r101;
    }

    public static String b(long r100) {
        if (r100 >= 0) goto L5;
        return null;
    L5:
        if (r100 > 281474976710655L) goto L27;
        byte[] r101 = new byte[6];
        int r102 = 0;
        int r103 = 0;
    L8:
        if (r103 >= 6) goto L10;
        r101[r103] = (byte) ((r100 >> (((6 - r103) - 1) * 8)) & 255);
        r103 = r103 + 1;
        goto L8
    L10:
        StringBuilder r104 = new StringBuilder();
    L11:
        if (r102 >= 6) goto L20;
        String r105 = Integer.toHexString(r101[r102] & UByte.MAX_VALUE);
        if (r105.length() >= 2) goto L15;
        r104.append("0");
    L15:
        r104.append(r105);
        if (r102 >= 5) goto L18;
        r104.append(":");
    L18:
        r102 = r102 + 1;
        goto L11
    L20:
        return r104.toString();
    L27:
        return null;
    }
}
