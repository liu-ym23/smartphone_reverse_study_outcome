package com.ss.android.ainote.data;

import com.ss.android.ainote.model.AINoteWriteError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: com.ss.android.ainote.data.a$a, reason: collision with other inner class name */
    public static final class C4704a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Integer f406704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f406705b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AINoteWriteError f406706c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4704a) == true) goto L8;
            return false;
        L8:
            C4704a r101 = (C4704a) r100;
            if (Intrinsics.areEqual(this.f406704a, r101.f406704a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f406705b, r101.f406705b) == true) goto L15;
            return false;
        L15:
            if (this.f406706c == r101.f406706c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.f406704a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f406705b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return ((r103 + r101) * 31) + this.f406706c.hashCode();
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "BizError(code=" + this.f406704a + ", message=" + this.f406705b + ", writeError=" + this.f406706c + ')';
        }

        public C4704a(Integer r100, String r101, AINoteWriteError r102) {
            Intrinsics.checkNotNullParameter(r102, "writeError");
            this.f406704a = r100;
            this.f406705b = r101;
            this.f406706c = r102;
        }
    }

    public static final class b<T> extends a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f406707a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f406707a, ((b) r100).f406707a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f406707a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Success(data=" + this.f406707a + ')';
        }

        public b(T r100) {
            this.f406707a = r100;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f406708a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f406708a, ((c) r100).f406708a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f406708a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "TransportError(message=" + this.f406708a + ')';
        }

        public c(String r100) {
            this.f406708a = r100;
        }
    }

    public a() {
    }
}
