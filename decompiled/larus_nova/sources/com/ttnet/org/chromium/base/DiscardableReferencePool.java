package com.ttnet.org.chromium.base;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes41.dex */
public class DiscardableReferencePool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Set<DiscardableReference<?>> mPool;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.DiscardableReferencePool$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class DiscardableReference<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private T mPayload;

        private void discard() {
            this.mPayload = null;
        }

        static {
        }

        public T get() {
            return this.mPayload;
        }

        private DiscardableReference(T r100) {
            this.mPayload = r100;
        }

        public static /* synthetic */ void access$100(DiscardableReference r100) {
            r100.discard();
        }

        public /* synthetic */ DiscardableReference(Object r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public void drain() {
        Iterator<DiscardableReference<?>> r100 = this.mPool.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        DiscardableReference.access$100(r100.next());
        goto L4
    L6:
        this.mPool.clear();
    }

    public DiscardableReferencePool() {
        this.mPool = Collections.newSetFromMap(new WeakHashMap());
    }

    static {
    }

    public <T> DiscardableReference<T> put(T r100) {
        DiscardableReference<T> r101 = new DiscardableReference(r100, null);
        this.mPool.add(r101);
        return r101;
    }

    public void remove(DiscardableReference<?> r100) {
        if (this.mPool.contains(r100) == true) goto L5;
        return;
    L5:
        DiscardableReference.access$100(r100);
        this.mPool.remove(r100);
    }
}
