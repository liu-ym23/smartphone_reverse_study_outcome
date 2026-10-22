package com.bytedance.ee.bear.onboarding.synchronization;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes18.dex */
public interface a {
    void a(Function1<? super Map<String, Boolean>, Unit> r100, Function1<? super Throwable, Unit> r101);

    void b(String r100, Function1<? super Boolean, Unit> r101, Function1<? super Throwable, Unit> r102);

    void c(String r100, Function1<? super Boolean, Unit> r101, Function1<? super Throwable, Unit> r102);

    void dispose();
}
