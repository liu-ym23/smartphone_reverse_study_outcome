package com.bytedance.awemeopen.apps.framework.comment.write.utils.imm;

import f06.b;
import f06.c;
import f06.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class RomUtils {
    public static int a = 3;

    public @interface AppRunFrom {
    }

    public static Process a(Runtime r12, String r13) {
        c r8 = new c();
        Object[] r9 = {r13};
        b r10 = new b();
        d r11 = r8.b(102900, "java/lang/Runtime", "exec", r12, r9, "java.lang.Process", r10);
        if (r11.a == false) goto L6;
        r8.a(102900, "java/lang/Runtime", "exec", r12, r9, null, r10, false);
        return (Process) r11.b;
    L6:
        Process r14 = r12.exec(r13);
        r8.a(102900, "java/lang/Runtime", "exec", r12, r9, r14, r10, true);
        return r14;
    }
}
