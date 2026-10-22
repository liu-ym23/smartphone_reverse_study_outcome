package com.ss.lark.android.encryption.utils;

import android.os.Build;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class c {

    public static final class a implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f456827a;

        public a(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f456827a = r100;
        }

        @Override // java.util.function.Function
        public final /* synthetic */ Object apply(Object r100) {
            return this.f456827a.invoke(r100);
        }
    }

    public static final <K, V> V a(ConcurrentHashMap<K, V> r100, K r101, Function1<? super K, ? extends V> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "function");
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        V r103 = r100.get(r101);
        if (r103 != null) goto L18;
        monitor-enter(r100);
        r103 = r100.get(r101);     // Catch: Throwable -> L15
        if (r103 != null) goto L12;
        V r104 = r102.invoke(r101);     // Catch: Throwable -> L15
        r100.put(r101, r104);     // Catch: Throwable -> L15
        r103 = r104;
    L12:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r100);
    L15:
        th = move-exception;
        throw th;
    L18:
        return r103;
    L5:
        return r100.computeIfAbsent(r101, new a(r102));
    }
}
