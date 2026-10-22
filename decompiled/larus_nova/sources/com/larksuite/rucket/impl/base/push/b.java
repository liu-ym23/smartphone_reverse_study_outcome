package com.larksuite.rucket.impl.base.push;

import com.squareup.wire.WireEnum;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Object, a<?>> f286061a = null;

    static {
        f286061a = new ConcurrentHashMap();
    }

    public static a a(WireEnum r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "command");
        Intrinsics.checkNotNullParameter(r101, "action");
        ConcurrentHashMap<Object, a<?>> r102 = f286061a;
        a<?> r103 = r102.get(r100);
        if (r103 != null) goto L8;
        r103 = (a) r101.invoke();
        a<?> r104 = r102.putIfAbsent(r100, r103);
        if (r104 == null) goto L8;
        r103 = r104;
    L8:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.larksuite.rucket.impl.base.push.BasePushRucketJob<T of com.larksuite.rucket.impl.base.push.PushCache.getOrPut>");
        return r103;
    }
}
