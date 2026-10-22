package com.larus.bmhome.chat.layout.holder.progressloading;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.o0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes25.dex */
public final class GenImgLoadingResourceGetter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f304014a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f304015b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f304016c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f304017d;

    static {
        f304014a = LazyKt.lazy(new a());
        f304015b = LazyKt.lazy(new b());
        f304016c = LazyKt.lazy(new c());
    }

    public static e a() {
        if (((Boolean) f304014a.getValue()).booleanValue() == false) goto L10;
        if (o0.d(f304017d) == false) goto L10;
        if (new PolarisFileWrapper(f304017d).exists() == false) goto L10;
        return new e.b(f304017d);
    L10:
        return (e.a) f304015b.getValue();
    }

    public static void b() {
        if (f304017d == null) goto L5;
        return;
    L5:
        if (o0.d((String) f304016c.getValue()) == false) goto L9;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new GenImgLoadingResourceGetter$init$1(null), 2, null);
        return;
    }
}
