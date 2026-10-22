package com.ss.android.lark.contact.base.contact_myqrcode;

import com.larksuite.framework.callback.Entity.ErrorResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class b<T> {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ErrorResult f418706a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f418706a, ((a) r100).f418706a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f418706a.hashCode();
        }

        public final String toString() {
            return "Error(error=" + this.f418706a + ')';
        }

        public a(ErrorResult r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f418706a = r100;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_myqrcode.b$b, reason: collision with other inner class name */
    public static final class C4926b<T> extends b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f418707a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4926b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f418707a, ((C4926b) r100).f418707a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f418707a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Success(data=" + this.f418707a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C4926b(z8b.a r100) {
            this.f418707a = r100;
        }
    }

    public b() {
    }
}
