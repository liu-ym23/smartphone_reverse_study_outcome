package com.larus.suggest.impl.wcb.render;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public interface n {

    public static final class a implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f370062a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f370062a, ((a) r100).f370062a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f370062a.hashCode();
        }

        public final String toString() {
            return "Rejected(reason=" + this.f370062a + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f370062a = r100;
        }
    }

    public static final class b implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f370063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f370064b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f370063a, r101.f370063a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f370064b, r101.f370064b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f370063a.hashCode() * 31) + this.f370064b.hashCode();
        }

        public final String toString() {
            return "Submitted(localMessageId=" + this.f370063a + ", ext=" + this.f370064b + ')';
        }

        public b(String r100, Map<String, String> r101) {
            Intrinsics.checkNotNullParameter(r100, "localMessageId");
            Intrinsics.checkNotNullParameter(r101, "ext");
            this.f370063a = r100;
            this.f370064b = r101;
        }
    }
}
