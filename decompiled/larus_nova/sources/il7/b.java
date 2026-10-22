package il7;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f490313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f490314b;

    public static float a() {
        float r100 = 0.0f;
        if (f490314b == false) goto L7;
        float r101 = f490313a;
        if (r101 <= 0.0f) goto L7;
        return r101;
    L7:
        zl7.d r102 = (zl7.d) hn7.d.b(zl7.d.class);
        if (r102 == null) goto L10;
        float r103 = r102.getDeviceScore();
    L15:
        if (r103 <= 0.0f) goto L25;
        f490313a = r103;
        if (f490314b == true) goto L25;
        if (r103 < 0.0f) goto L25;
        m r104 = m.a();
        float r105 = f490313a;
        if (r104.f490336a == null) goto L23;
        r104.g("device_score");
        SharedPreferences.Editor r106 = r104.f490336a.edit();
        r106.putFloat("device_score", r105);
        r106.apply();
    L23:
        f490314b = true;
    L25:
        if (f490313a > 0) goto L31;
        m r107 = m.a();
        if (r107.f490336a == null) goto L29;
        r107.g("device_score");
        r100 = r107.f490336a.getFloat("device_score", 0.0f);
    L29:
        f490313a = r100;
    L31:
        return f490313a;
    L10:
        zl7.g r108 = (zl7.g) hn7.d.b(zl7.g.class);
        if (r108 == null) goto L13;
        r103 = r108.getDeviceScore();
        goto L15
    L13:
        r103 = 0.0f;
        goto L15
    }

    static {
    }
}
