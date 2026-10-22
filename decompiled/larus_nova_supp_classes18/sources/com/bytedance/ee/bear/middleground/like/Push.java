package com.bytedance.ee.bear.middleground.like;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class Push {
    public final String a;
    public final int b;
    public final int c;
    public final Lazy d;

    public static final class a {
    }

    static {
    }

    public Push(String r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = LazyKt.lazy(new Push$rnPushProtocol$2(this));
    }
}
