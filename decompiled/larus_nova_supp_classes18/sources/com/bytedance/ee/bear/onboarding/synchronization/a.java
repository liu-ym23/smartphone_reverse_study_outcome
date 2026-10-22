package com.bytedance.ee.bear.onboarding.synchronization;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a {
    void a(Function1<? super Map<String, Boolean>, Unit> r1, Function1<? super Throwable, Unit> r2);

    void b(String r1, Function1<? super Boolean, Unit> r2, Function1<? super Throwable, Unit> r3);

    void c(String r1, Function1<? super Boolean, Unit> r2, Function1<? super Throwable, Unit> r3);

    void dispose();
}
