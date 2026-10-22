package com.larus.ugc.perf.impl;

import android.text.TextUtils;
import android.util.LruCache;
import com.google.gson.reflect.TypeToken;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.delegate.c0;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f375107a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, e> f375108b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<Integer, d> f375109c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Function2<String, Integer, Unit>> f375110d = null;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends com.larus.ugc.perf.impl.a>> {
        public a() {
        }
    }

    public f() {
    }

    static {
        f375107a = new f();
        f375108b = new LruCache(10);
        f375109c = new HashMap();
        f375110d = new ConcurrentHashMap();
    }

    public static List a(Message r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = tz9.a.b(r100);
        if (r101 != null) goto L26;
        return null;
    L26:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L23
        zd9.h r103 = zd9.h.f571481a;     // Catch: Throwable -> L23
        if (StringsKt.isBlank(r101) == false) goto L28;
    L20:
        Object r104 = null;
    L21:
        return (List) r104;
    L28:
        r103.getClass();     // Catch: Throwable -> L13
        r104 = Result.m9449constructorimpl(zd9.h.f571482b.fromJson(r101, new a().getType()));     // Catch: Throwable -> L13
    L15:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);     // Catch: Throwable -> L23
        if (r105 == null) goto L19;
        c0 r106 = c0.f348199b;     // Catch: Throwable -> L23
        StringBuilder r107 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r105, "<this>");     // Catch: Throwable -> L23
        r107.append(ExceptionsKt.stackTraceToString(r105));     // Catch: Throwable -> L23
        r106.e("GsonHolder", r107.toString());     // Catch: Throwable -> L23
    L19:
        if (Result.m9455isFailureimpl(r104) == false) goto L21;
    L13:
        th = move-exception;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L23
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    public static e b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        if (r100 != null) goto L7;
        return null;
    L7:
        return f375108b.get(r100);
    }

    public static void c(int r100, d r101) {
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_TRACKER);
        Integer r102 = Integer.valueOf(r100);
        f375109c.put(r102, r101);
    }
}
