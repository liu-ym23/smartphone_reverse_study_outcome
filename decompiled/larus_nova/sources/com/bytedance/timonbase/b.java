package com.bytedance.timonbase;

import com.bytedance.timon.foundation.interfaces.ILogger;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f270799a = 0;

    static {
    }

    public static void f(String r100) {
        vg7.a.c().v("Timon-ClipboardSuite", r100);
    }

    public static void a(String r100, String r101) {
        if (TMEnv.f270767a == false) goto L6;
        vg7.a.c().d("Timon-".concat(r100), r101);
        return;
    }

    public static void b(String r110, Object... r111) {
        if (TMEnv.f270767a == false) goto L6;
        vg7.a.c().d("Timon-HeliosSettings", r110 + " " + ArraysKt.joinToString$default(r111, null, null, null, 0, null, null, 63, null));
        return;
    }

    public static void c(String r100, String r101) {
        vg7.a.c().e("Timon-".concat(r100), r101, null);
    }

    public static void e(String r100, String r101) {
        vg7.a.c().i("Timon-".concat(r100), r101);
    }

    public static void d(String r100, String r101, Throwable r102) {
        ILogger r103 = vg7.a.c();
        String r104 = "Timon-" + r100;
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        r103.e(r104, r101, r102);
    }
}
