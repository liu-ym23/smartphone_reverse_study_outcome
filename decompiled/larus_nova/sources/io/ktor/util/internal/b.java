package io.ktor.util.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes41.dex */
public class b {
    volatile /* synthetic */ Object _next;
    volatile /* synthetic */ Object _prev;
    private volatile /* synthetic */ Object _removedRef;

    static {
        AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_next");
        AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_prev");
        AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_removedRef");
    }

    public final String toString() {
        return Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + '@' + hashCode();
    }

    public b() {
        this._next = this;
        this._prev = this;
        this._removedRef = null;
    }
}
