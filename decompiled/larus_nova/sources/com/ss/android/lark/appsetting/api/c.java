package com.ss.android.lark.appsetting.api;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import io.reactivex.Scheduler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements awa.c {
    public c() {
    }

    @Override // awa.c
    public final int T1(String r100, Class<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        String r102 = a(r100, r101);
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        return CastIntegerProtector.parseInt(r102);
    }

    @Override // awa.c
    public final String V5(String r100, Class<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        return a(r100, r101);
    }

    public final String a(String r100, Class<?> r101) {
        e r102 = e.a.f408951a;
        AppConfig r103 = r102.b(r101);
        if (r103 != null) goto L7;
        return "";
    L7:
        return r102.c(r100, r103.key(), r103.needDiskCache());
    }

    @Override // awa.c
    public final long b4(String r100, Class<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        String r102 = a(r100, r101);
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        return CastLongProtector.parseLong(r102);
    }

    @Override // awa.c
    public final double m6(String r100, Class<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        String r102 = a(r100, r101);
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        return CastDoubleProtector.parseDouble(r102);
    }

    @Override // awa.c
    public final boolean s3(String r100, Class<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        String r102 = a(r100, r101);
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        return Boolean.parseBoolean(r102);
    }

    @Override // awa.c
    public final <T> T y0(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        return (T) e.a.f408951a.a(r100, r101.getName());
    }

    @Override // awa.c
    public final void Bd(String r100, Class<?> r101, IGetDataCallback<Double> r102) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r102 == null) goto L6;
        r102.onSuccess(Double.valueOf(m6(r100, r101)));
        return;
    }

    @Override // awa.c
    public final void C9(String r100, Class<?> r101, IGetDataCallback<String> r102) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r102 == null) goto L6;
        Intrinsics.checkNotNullParameter(r101, "clazz");
        r102.onSuccess(a(r100, r101));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // awa.c
    public final <T> void M5(String r100, Class<T> r101, IGetDataCallback<T> r102) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r102 == 0) goto L6;
        r102.onSuccess(e.a.f408951a.a(r100, r101.getName()));
        return;
    }

    @Override // awa.c
    public final void k9(String r100, Class<?> r101, IGetDataCallback<Integer> r102) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r102 == null) goto L6;
        r102.onSuccess(Integer.valueOf(T1(r100, r101)));
        return;
    }

    @Override // awa.c
    public final String q0(String r100, String r101, boolean r102) {
        return e.a.f408951a.c(r100, r101, r102);
    }

    @Override // awa.c
    public final void sc(String r100, Class<?> r101, IGetDataCallback<Boolean> r102) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r102 == null) goto L6;
        r102.onSuccess(Boolean.valueOf(s3(r100, r101)));
        return;
    }

    @Override // awa.c
    public final void D7(String r100, Class<?> r101, Scheduler r102, Scheduler r103, IGetDataCallback<Double> r104) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r104 == null) goto L6;
        r104.onSuccess(Double.valueOf(m6(r100, r101)));
        return;
    }

    @Override // awa.c
    public final void f7(String r100, Class<?> r101, Scheduler r102, Scheduler r103, IGetDataCallback<Integer> r104) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r104 == null) goto L6;
        r104.onSuccess(Integer.valueOf(T1(r100, r101)));
        return;
    }

    @Override // awa.c
    public final void m2(String r100, Class<?> r101, Scheduler r102, Scheduler r103, IGetDataCallback<Boolean> r104) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r104 == null) goto L6;
        r104.onSuccess(Boolean.valueOf(s3(r100, r101)));
        return;
    }

    @Override // awa.c
    public final void p5(String r100, Class<?> r101, Scheduler r102, Scheduler r103, IGetDataCallback<String> r104) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r104 == null) goto L6;
        Intrinsics.checkNotNullParameter(r101, "clazz");
        r104.onSuccess(a(r100, r101));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // awa.c
    public final <T> void x3(String r100, Class<T> r101, Scheduler r102, Scheduler r103, IGetDataCallback<T> r104) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r104 == 0) goto L6;
        r104.onSuccess(e.a.f408951a.a(r100, r101.getName()));
        return;
    }
}
