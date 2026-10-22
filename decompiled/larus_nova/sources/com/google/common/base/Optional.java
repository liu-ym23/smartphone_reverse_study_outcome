package com.google.common.base;

import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@DoNotMock("Use Optional.of(value) or Optional.absent()")
@ElementTypesAreNonnullByDefault
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public class a implements Iterable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f274701a;

        /* JADX INFO: renamed from: com.google.common.base.Optional$a$a, reason: collision with other inner class name */
        public class C3846a extends AbstractIterator<T> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Iterator<? extends Optional<? extends T>> f274702c;

            @Override // com.google.common.base.AbstractIterator
            @CheckForNull
            public final T a() {
            L3:
                if (this.f274702c.hasNext() == false) goto L8;
                Optional<? extends T> r100 = this.f274702c.next();
                if (r100.isPresent() == false) goto L3;
                return r100.get();
            L8:
                this.f274686a = AbstractIterator.State.DONE;
                return null;
            }

            public C3846a(a r100) {
                Iterator<? extends Optional<? extends T>> r101 = r100.f274701a.iterator();
                r101.getClass();
                this.f274702c = r101;
            }
        }

        @Override // java.lang.Iterable
        public final Iterator<T> iterator() {
            return new C3846a(this);
        }

        public a(Iterable r100) {
            this.f274701a = r100;
        }
    }

    public Optional() {
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(@CheckForNull Object r100);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> r100);

    public abstract T or(t<? extends T> r100);

    public abstract T or(T r100);

    @CheckForNull
    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(g<? super T, V> r100);

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> fromNullable(@CheckForNull T r100) {
        if (r100 != null) goto L5;
        return absent();
    L5:
        return new Present(r100);
    }

    public static <T> Optional<T> of(T r100) {
        r100.getClass();
        return new Present(r100);
    }

    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> r100) {
        r100.getClass();
        return new a(r100);
    }
}
