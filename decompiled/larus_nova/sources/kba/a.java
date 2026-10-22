package kba;

import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f502286a = 0;

    static {
    }

    public static long a(long r100) {
        long r101 = (r100 * (-7046029254386353131L)) + 1366960921;
        long r102 = (r101 ^ (r101 >>> 30)) * (-4658895280553007687L);
        long r103 = (r102 ^ (r102 >>> 27)) * (-7723592293110705685L);
        return r103 ^ (r103 >>> 31);
    }

    public static float b(long r210) {
        long r100 = RangesKt.coerceAtLeast(r210, 0);
        long r101 = r100 / 220;
        long r102 = r100 % 220;
        long r103 = 0;
        long r104 = r101;
    L3:
        long r110 = a(r103);
        boolean r111 = true;
        long r112 = 2;
        if (r110 < 0) goto L6;
        long r113 = r110 % 2;
    L11:
        long r114 = (r113 + 1) + 4;
        if (r104 < r114) goto L14;
        r104 = r104 - r114;
        r103 = r103 + r114;
        goto L3
    L14:
        if (r104 >= 4) goto L17;
        r111 = false;
    L17:
        float r105 = 0.06f;
        if (r111 == false) goto L20;
        return 0.06f;
    L20:
        float r106 = (((float) ((a(r101) >>> 11) / 9.007199254740991E15d)) * 0.5f) + 0.45f;
        if (r102 > 45) goto L23;
        r106 = (r106 - 0.06f) * (r102 / 45.0f);
    L25:
        return r106 + r105;
    L23:
        r105 = (0.06f - r106) * RangesKt.coerceIn((r102 - 45) / 130.0f, 0.0f, 1.0f);
        goto L25
    L6:
        long r115 = r110 - ((((r110 >>> 1) / 2) << 1) * 2);
        if ((Long.MIN_VALUE ^ r115) >= (-9223372036854775806L)) goto L10;
        r112 = 0;
    L10:
        r113 = r115 - r112;
        goto L11
    }
}
