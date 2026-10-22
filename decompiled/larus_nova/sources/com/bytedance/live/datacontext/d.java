package com.bytedance.live.datacontext;

import androidx.fragment.app.Fragment;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f255080a = 0;

    static {
    }

    @JvmStatic
    @CheckReturnValue
    public static final <T extends DataContext> Pair<T, Disposable> a(Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        final T r101 = r100.invoke();
        int r102 = com.bytedance.revenue.platform.api.core.rx.h.f267513a;
        return TuplesKt.to(r101, com.bytedance.revenue.platform.api.core.rx.h.a(new DataContextKt$createImpl$1(r101)));
    }

    @JvmStatic
    public static final DataContext d(Object r100) {
        u.a r101 = b.f255078a.f255097a.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f255098a;
    }

    @JvmStatic
    public static final w b(Fragment r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        return new w(r100, r101);
    }

    @JvmStatic
    public static final void c(DataContext r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "self");
        b.a(r100, r101);
    }

    @JvmStatic
    public static final <T extends DataContext> T e(Object r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "cls");
        DataContext r102 = d(r100);
        if (r102 != null) goto L5;
    L7:
        r102 = null;
    L9:
        if ((r102 instanceof DataContext) == true) goto L11;
        return null;
    L11:
        return (T) r102;
    L5:
        if (r101.isAssignableFrom(r102.getClass()) == false) goto L7;
        goto L7
    }
}
