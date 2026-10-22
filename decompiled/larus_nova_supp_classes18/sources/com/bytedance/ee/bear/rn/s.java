package com.bytedance.ee.bear.rn;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.util.common.ReflectUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s implements tb5.g {
    public final /* synthetic */ tb5.i<Object> a;

    public s(tb5.i<Object> r1) {
        this.a = r1;
    }

    public final void a(String r4, tb5.m r5) {
        Class r0 = ReflectUtils.b(this.a);
        Object r1 = null;
        if (r0 != null) goto L6;
        this.a.handle(null, r5);
        return;
    L6:
        if (Intrinsics.areEqual(r0, String.class) == false) goto L14;
        this.a.handle(r4, r5);
        return;
    L14:
        r1 = JSON.parseObject(r4, r0);     // Catch: Throwable -> L10
    L12:
        this.a.handle(r1, r5);
        return;
    L10:
        th = move-exception;
        tt5.a.f("registerHandler", th, false);
        goto L12
    }
}
