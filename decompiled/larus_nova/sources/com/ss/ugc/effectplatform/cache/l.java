package com.ss.ugc.effectplatform.cache;

import android.content.Context;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes5.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f457357a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static l f457358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f457359c = null;

    public static final class a {
        public a() {
        }

        public static l a(Object r100) {
            if (l.f457358b != null) goto L19;
            if (r100 == null) goto L19;
            if ((r100 instanceof Context) == false) goto L19;
            Object r101 = l.f457357a;
            monitor-enter(r101);
        L15:
            th = move-exception;
            throw th;
        L10:
            if (l.f457358b != null) goto L12;
            l.f457358b = new l();     // Catch: Throwable -> L15
        L12:
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L15
            monitor-exit(r101);
        L19:
            return l.f457358b;
        }
    }

    public static Pair a() {
        return TuplesKt.to(0, 0L);
    }

    static {
        f457359c = new a();
        f457357a = new Object();
    }

    public l() {
    }
}
