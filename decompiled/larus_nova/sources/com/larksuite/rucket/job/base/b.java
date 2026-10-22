package com.larksuite.rucket.job.base;

import com.larksuite.framework.callback.Entity.ErrorResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class b<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f286077a = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.base.b$b, reason: collision with other inner class name */
    public static final class C3939b extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ErrorResult f286078b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3939b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f286078b, ((C3939b) r100).f286078b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f286078b.hashCode();
        }

        public final String toString() {
            return "Error(exception=" + this.f286078b + ')';
        }

        @Override // com.larksuite.rucket.job.base.b
        public final Object b() {
            throw this.f286078b;
        }

        public C3939b(ErrorResult r100) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
            this.f286078b = r100;
        }
    }

    public static final class c<T> extends b<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f286079b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f286079b, ((c) r100).f286079b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f286079b;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Success(data=" + this.f286079b + ')';
        }

        @Override // com.larksuite.rucket.job.base.b
        public final T b() {
            return this.f286079b;
        }

        public c(T r100) {
            this.f286079b = r100;
        }
    }

    static {
    }

    public b() {
    }

    public abstract R b();

    public final ErrorResult a() {
        if ((this instanceof C3939b) == true) goto L7;
        return null;
    L7:
        return ((C3939b) this).f286078b;
    }
}
