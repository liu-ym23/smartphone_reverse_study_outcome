package com.larus.business.arc.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface m {

    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f319904a = null;

        static {
            f319904a = new a();
        }

        public a() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            a r101 = (a) r100;
            return true;
        }

        public final int hashCode() {
            return -1905343028;
        }

        public final String toString() {
            return "NoResponse";
        }
    }

    public static final class b implements m {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            ((b) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Ready(response=null)";
        }
    }
}
