package com.bytedance.ee.bear.bitable.share.sharepanel;

import com.bytedance.ee.bear.lark.dependency.d0;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class h<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f215445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f215446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f215447c;

    public h(String r100, int r101, int r102) {
        this.f215445a = r100;
        this.f215446b = r101;
        this.f215447c = r102;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((String) r100, "it");
        return ((d0) org.koin.java.a.c(d0.class, null, null, 6)).e(this.f215445a, this.f215446b, this.f215447c);
    }
}
