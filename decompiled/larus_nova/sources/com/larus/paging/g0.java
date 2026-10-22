package com.larus.paging;

import java.util.AbstractList;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Deprecated(message = "PagedList is deprecated and has been replaced by PagingData")
public abstract class g0<T> extends AbstractList<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f363848c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f363849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0<T> f363850b;

    public static abstract class a {
    }

    public static final class b {
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public u f363851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public u f363852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public u f363853c;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f363854a = null;

            static {
                int[] r100 = new int[LoadType.values().length];
                r100[LoadType.REFRESH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[LoadType.PREPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[LoadType.APPEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f363854a = r100;
            }
        }

        public abstract void a(LoadType r100, u r101);

        public c() {
            u.c r100 = u.c.f363922b;
            u.c r101 = u.c.f363923c;
            this.f363851a = r101;
            this.f363852b = r101;
            this.f363853c = r101;
        }
    }

    static {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f363850b.getSize();
    }

    @Override // java.util.AbstractList, java.util.List
    public final T get(int r100) {
        return this.f363850b.get(r100);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ T remove(int r100) {
        return (T) super.remove(r100);
    }

    public g0(PagingSource r100, h0 r101) {
        Intrinsics.checkNotNullParameter(r100, "pagingSource");
        Intrinsics.checkNotNullParameter(null, "coroutineScope");
        Intrinsics.checkNotNullParameter(null, "notifyDispatcher");
        Intrinsics.checkNotNullParameter(r101, "storage");
        Intrinsics.checkNotNullParameter(null, "config");
        this.f363849a = null;
        this.f363850b = r101;
        throw null;
    }
}
