package com.larus.bmhome.social.page.datasource;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class g<T, Key> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f314041b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<T> f314042a;

    public static final class a {
    }

    public static final class b<T, Key> extends g<T, Key> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f314043c;

        public b() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f314043c, ((b) r100).f314043c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Object r100 = this.f314043c;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Empty(nothing=" + this.f314043c + ')';
        }

        public b(Object r100) {
            super(null);
            this.f314043c = r100;
        }
    }

    public static final class c<T, Key> extends g<T, Key> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f314044c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f314044c, ((c) r100).f314044c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Throwable r100 = this.f314044c;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Failed(error=" + this.f314044c + ')';
        }

        public c(Throwable r100) {
            super(CollectionsKt.emptyList());
            this.f314044c = r100;
        }
    }

    public static final class d<T, Key> extends g<T, Key> {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            ((d) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(null, null) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Success(list=null, prev=null, next=null)";
        }
    }

    static {
    }

    public g() {
        throw null;
    }

    public g(List r100) {
        this.f314042a = r100;
    }
}
