package com.larus.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class n0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<T> f375451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<T> f375452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f375453c;

    public final T a() {
        if (this.f375453c >= ((ArrayList) this.f375452b).size()) goto L6;
        List<T> r100 = this.f375452b;
        int r101 = this.f375453c;
        this.f375453c = r101 + 1;
        return (T) ListProtector.get(r100, r101);
    L6:
        T r102 = this.f375451a.invoke();
        this.f375453c++;
        ((ArrayList) this.f375452b).add(r102);
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n0(Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "creator");
        this.f375451a = r100;
        this.f375452b = new ArrayList();
    }
}
