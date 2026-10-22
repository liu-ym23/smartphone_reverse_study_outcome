package com.google.common.base;

import com.bytedance.mt.protector.impl.PatternProtector;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class e {
    public e() {
    }

    public abstract int flags();

    public abstract d matcher(CharSequence r100);

    public abstract String pattern();

    public abstract String toString();

    public static boolean isPcreLike() {
        l.f274724a.getClass();
        return true;
    }

    public static e compile(String r100) {
        l.a r101 = l.f274724a;
        r100.getClass();
        l.f274724a.getClass();
        return new JdkPattern(PatternProtector.compile(r100));
    }
}
