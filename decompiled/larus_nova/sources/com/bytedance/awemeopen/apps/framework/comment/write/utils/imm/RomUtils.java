package com.bytedance.awemeopen.apps.framework.comment.write.utils.imm;

import f06.b;
import f06.c;
import f06.d;

/* JADX INFO: loaded from: classes14.dex */
public final class RomUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f194593a = 3;

    public @interface AppRunFrom {
    }

    public static Process a(Runtime r110, String r111) {
        c r100 = new c();
        Object[] r101 = {r111};
        b r112 = new b();
        d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }
}
