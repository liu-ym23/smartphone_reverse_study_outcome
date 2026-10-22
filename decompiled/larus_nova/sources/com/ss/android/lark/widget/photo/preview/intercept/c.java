package com.ss.android.lark.widget.photo.preview.intercept;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public interface c {

    public static final class a implements c {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            ((a) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Error(debugMsg=null, throwable=null)";
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f446730a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f446730a, ((b) r100).f446730a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f446730a.hashCode();
        }

        public final String toString() {
            return "Success(debugMsg=" + this.f446730a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "debugMsg");
            this.f446730a = r100;
        }
    }
}
