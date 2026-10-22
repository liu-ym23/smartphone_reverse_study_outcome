package com.bytedance.ee.bear.facade.common.empty;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class Config {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, CharSequence> f226405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, Integer> f226406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f226407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f226408d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f226409e;

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
        this.f226405a = new LinkedHashMap();
        this.f226406b = new LinkedHashMap();
        new LinkedHashMap();
        this.f226408d = Locale.ENGLISH.getLanguage();
        this.f226409e = "ccm.newerror.optimization";
        new LinkedHashMap();
    }

    public final void b(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        d(Config$defaultTips$1.INSTANCE);
        d(new Config$defaultTips$2(r100));
        d(new Config$defaultTips$3(r100));
        d(new Config$defaultTips$4(r100));
        d(new Config$defaultTips$5(r100));
        d(new Config$defaultTips$6(r100));
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.f(this.f226409e) == false) goto L5;
        d(new Config$defaultTips$7(r100));
    L6:
        d(new Config$defaultTips$9(r100));
        return;
    L5:
        d(new Config$defaultTips$8(r100));
        goto L6
    }

    public final void c(Function0<Pair<Integer, Integer>> r100) {
        Intrinsics.checkNotNullParameter(r100, "build");
        Pair<Integer, Integer> r101 = r100.invoke();
        this.f226406b.put(r101.getFirst(), r101.getSecond());
    }

    public final void d(Function0<? extends Pair<Integer, ? extends CharSequence>> r100) {
        Intrinsics.checkNotNullParameter(r100, "build");
        Pair<Integer, ? extends CharSequence> r101 = r100.invoke();
        this.f226405a.put(r101.getFirst(), r101.getSecond());
    }
}
