package com.bytedance.bpea.entry.common;

import com.bytedance.bpea.basics.BPEAException;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes8.dex */
public final class BaseAuthEntry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f202194a = null;

    public static final class Companion {
        public Companion() {
        }

        public final <T> T a(qc4.c r100, Function0<? extends T> r101) throws BPEAException {
            d.b(r100);
            return (T) call(r100, null, r101);
        }

        public final <T> T call(qc4.c r100, qc4.d r101, Function0<? extends T> r102) throws BPEAException {
            T r103 = r102.invoke();     // Catch: Throwable -> L5
            CopyOnWriteArraySet<b> r104 = c.f202198a;
            c.a(r100, BaseAuthEntry$Companion$call$1.INSTANCE);
            return r103;
        L5:
            th = move-exception;
            CopyOnWriteArraySet<b> r105 = c.f202198a;
            c.a(r100, BaseAuthEntry$Companion$call$1.INSTANCE);
            throw th;
        }
    }

    static {
        f202194a = new Companion();
    }
}
