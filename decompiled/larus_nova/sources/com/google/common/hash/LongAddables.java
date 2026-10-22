package com.google.common.hash;

import com.google.common.base.t;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class LongAddables {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t<j> f275572a = null;

    public static final class PureJavaLongAddable extends AtomicLong implements j {
        @Override // com.google.common.hash.j
        public long sum() {
            return get();
        }

        private PureJavaLongAddable() {
        }

        @Override // com.google.common.hash.j
        public void increment() {
            getAndIncrement();
        }

        public /* synthetic */ PureJavaLongAddable(a r100) {
            this();
        }

        @Override // com.google.common.hash.j
        public void add(long r100) {
            getAndAdd(r100);
        }
    }

    public class a implements t<j> {
        public a() {
        }

        @Override // com.google.common.base.t
        public final j get() {
            return new LongAdder();
        }
    }

    public class b implements t<j> {
        public b() {
        }

        @Override // com.google.common.base.t
        public final j get() {
            return new PureJavaLongAddable(null);
        }
    }

    static {
        new LongAdder();     // Catch: Throwable -> L4
        t<j> r100 = new a();     // Catch: Throwable -> L4
    L5:
        f275572a = r100;
        return;
    L4:
        r100 = new b();
        goto L5
    }
}
