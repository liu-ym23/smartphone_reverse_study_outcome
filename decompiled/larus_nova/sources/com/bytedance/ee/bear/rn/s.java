package com.bytedance.ee.bear.rn;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.util.common.ReflectUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class s implements tb5.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tb5.i<Object> f236631a;

    public s(tb5.i<Object> r100) {
        this.f236631a = r100;
    }

    @Override // tb5.g
    public final void a(String r100, tb5.m r101) {
        Class r102 = ReflectUtils.b(this.f236631a);
        Object r103 = null;
        if (r102 != null) goto L6;
        this.f236631a.handle(null, r101);
        return;
    L6:
        if (Intrinsics.areEqual(r102, String.class) == false) goto L14;
        this.f236631a.handle(r100, r101);
        return;
    L14:
        r103 = JSON.parseObject(r100, r102);     // Catch: Throwable -> L10
    L12:
        this.f236631a.handle(r103, r101);
        return;
    L10:
        th = move-exception;
        tt5.a.f("registerHandler", th, false);
        goto L12
    }
}
