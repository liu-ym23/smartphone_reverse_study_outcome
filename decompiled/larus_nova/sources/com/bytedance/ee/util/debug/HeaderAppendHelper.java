package com.bytedance.ee.util.debug;

import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class HeaderAppendHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f243122a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f243123b = null;

    static {
        f243122a = LazyKt.lazy(HeaderAppendHelper$canAppend$2.INSTANCE);
        f243123b = LazyKt.lazy(HeaderAppendHelper$headerAppendSp$2.INSTANCE);
    }

    public static void a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "header");
        if (((Boolean) f243122a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        Map<String, ?> r101 = ((SharedPreferences) f243123b.getValue()).getAll();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        Iterator<Map.Entry<String, ?>> r102 = r101.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<String, ?> r103 = r102.next();
        r100.put(r103.getKey(), (String) r103.getValue());
        goto L7
    }
}
