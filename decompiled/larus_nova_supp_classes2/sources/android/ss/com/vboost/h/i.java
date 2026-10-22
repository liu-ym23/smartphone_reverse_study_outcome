package android.ss.com.vboost.h;

import android.content.Context;
import android.os.Build;
import android.ss.com.vboost.utils.LogUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class i implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f97a = "i";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static h f98b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int[] f99c;
    private static int[] d;
    private static int[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int[] f100f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int[] f101g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int[] f102h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int[] f103i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int[] f104j;

    static {
        f99c = new int[]{1077936128, 1, 1086324736, 1, 1082130432, 4095, 1082130688, 4095, 1082130944, 4095, 1098907648, 255, 1119944704, 1, 1124073472, 255, 1128267776, 65535, 1115799552, 2000, 1115734016, 1000};
        d = new int[]{1077936128, 1, 1086324736, 1, 1082130432, 4095, 1082130688, 4095, 1098907648, 255, 1119944704, 1, 1124073472, 255, 1128267776, 65535, 1115799552, 2000, 1115734016, 1000};
        e = new int[]{1077936128, 1, 1086324736, 1, 1082130432, 4095, 1082130688, 4095, 1098907648, 255, 1119944704, 1, 1124073472, 255, 1128267776, 65535, 1115799552, 1, 1115734016, 1000};
        f100f = new int[]{1077936128, 1, 1086324736, 1, 1082130432, 4095, 1082130688, 4095, 1098907648, 255, 1119944704, 1};
        f101g = new int[]{1077936128, 1, 1086324736, 1, 1090519040, 4, 1090519296, 4, 1082130432, 4095, 1082130688, 4095, 1098907648, 255};
        int[] r0 = {1077936128, 1, 1086324736, 1, 1082130432, 4095, 1082130688, 4095, 1098907648, 255, 1119944704, 1};
        f102h = r0;
        f103i = r0;
        f104j = new int[]{1077936128, 1, 1115799552, 2000, 1115734016, 1000};
    }

    public i() {
    }

    @Override // android.ss.com.vboost.h.c
    public void a() {
        if (f98b == null) goto L6;
        LogUtil.debug(f97a, "release");
        f98b.b();
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public void a(long r4) {
        if (f98b == null) goto L6;
        LogUtil.debug(f97a, "try boost timeout " + r4);
        f98b.a((int) r4, f103i);
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public boolean a(Context r4) {
        if (f98b != null) goto L6;
        f98b = new h(r4);
    L6:
        if (f98b.a() == false) goto L24;
        int r5 = e.c();
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 28) goto L14;
        LogUtil.debug(f97a, "cluster num:" + r5);
        if (r5 != 3) goto L12;
        f103i = f99c;
    L22:
        LogUtil.info(f97a, "QcomPerfInterface init.");
        return true;
    L12:
        f103i = d;
        goto L22
    L14:
        if (r1 < 26) goto L17;
        f103i = e;
        goto L22
    L17:
        if (r1 < 24) goto L20;
        f103i = f100f;
        goto L22
    L20:
        if (r1 < 23) goto L24;
        f103i = f101g;
    L24:
        return false;
    }

    @Override // android.ss.com.vboost.h.c
    public void b() {
        if (f98b == null) goto L6;
        LogUtil.debug(f97a, "try boost");
        f98b.a(30000, f103i);
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public void b(long r4) {
        if (f98b == null) goto L6;
        LogUtil.debug(f97a, "try boost gpu with timeout " + r4);
        f98b.a((int) r4, f104j);
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public void c(long r4) {
        if (f98b == null) goto L6;
        LogUtil.debug(f97a, "try boost storage with timeout " + r4);
        f98b.a((int) r4, f103i);
        return;
    }
}
