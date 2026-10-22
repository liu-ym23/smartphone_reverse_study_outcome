package com.bytedance.ee.bear.more.protocol3.panel;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface u {
    w a();

    void registerMoreConfig(Function1<? super l, Unit> r1);

    void unregisterMoreConfig();
}
