package com.bytedance.ee.bear.facade.common.empty;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class Config {
    public final Map<Integer, CharSequence> a;
    public final Map<Integer, Integer> b;
    public int c;
    public String d;
    public final String e;

    public final void a() {
        c(Config$defaultIcons$1.INSTANCE);
        c(Config$defaultIcons$2.INSTANCE);
        c(Config$defaultIcons$3.INSTANCE);
        c(Config$defaultIcons$4.INSTANCE);
        c(Config$defaultIcons$5.INSTANCE);
        c(Config$defaultIcons$6.INSTANCE);
        c(Config$defaultIcons$7.INSTANCE);
        c(Config$defaultIcons$8.INSTANCE);
    }

    public Config() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        new LinkedHashMap();
        this.d = Locale.ENGLISH.getLanguage();
        this.e = "ccm.newerror.optimization";
        new LinkedHashMap();
    }

    public final void b(final Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        d(Config$defaultTips$1.INSTANCE);
        d(new Config$defaultTips$2(r3));
        d(new Config$defaultTips$3(r3));
        d(new Config$defaultTips$4(r3));
        d(new Config$defaultTips$5(r3));
        d(new Config$defaultTips$6(r3));
        if (com.bytedance.ee.bear.appsetting.c.a.a.f(this.e) == false) goto L5;
        d(new Config$defaultTips$7(r3));
    L6:
        d(new Config$defaultTips$9(r3));
        return;
    L5:
        d(new Config$defaultTips$8(r3));
        goto L6
    }

    public final void c(Function0<Pair<Integer, Integer>> r3) {
        Intrinsics.checkNotNullParameter(r3, "build");
        Pair r4 = (Pair) r3.invoke();
        Map<Integer, Integer> r0 = this.b;
        Object r1 = r4.getFirst();
        r0.put((Integer) r1, (Integer) r4.getSecond());
    }

    public final void d(Function0<? extends Pair<Integer, ? extends CharSequence>> r3) {
        Intrinsics.checkNotNullParameter(r3, "build");
        Pair r4 = (Pair) r3.invoke();
        Map<Integer, CharSequence> r0 = this.a;
        Object r1 = r4.getFirst();
        r0.put((Integer) r1, (CharSequence) r4.getSecond());
    }
}
