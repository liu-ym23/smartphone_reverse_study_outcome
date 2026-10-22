package com.larus.bmhome.chat.detail.code.preview;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f302790a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f302791b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f302792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f302793b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f302792a, r101.f302792a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f302793b, r101.f302793b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f302792a.hashCode() * 31) + this.f302793b.hashCode();
        }

        public final String toString() {
            return "PreloadCodeData(code=" + this.f302792a + ", language=" + this.f302793b + ')';
        }

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "code");
            Intrinsics.checkNotNullParameter(r101, "language");
            this.f302792a = r100;
            this.f302793b = r101;
        }
    }

    static {
        f302790a = LazyKt.lazy(new g());
        f302791b = LazyKt.lazy(new h());
    }
}
