package com.larus.suggest.impl.wcb.policy;

import com.larus.bmhome.chat.bean.NexPulseResponseData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public interface v {

    public static final class a implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NexPulseResponseData f370009a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f370009a, ((a) r100).f370009a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f370009a.hashCode();
        }

        public final String toString() {
            return "Hit(response=" + this.f370009a + ')';
        }

        public a(NexPulseResponseData r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            this.f370009a = r100;
        }
    }

    public static final class b implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f370010a = null;

        static {
            f370010a = new b();
        }

        public b() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            b r101 = (b) r100;
            return true;
        }

        public final int hashCode() {
            return 1601625825;
        }

        public final String toString() {
            return "Miss";
        }
    }

    public static final class c implements v {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            ((c) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Suppress(reason=null)";
        }
    }
}
