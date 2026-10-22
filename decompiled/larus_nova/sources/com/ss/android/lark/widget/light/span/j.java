package com.ss.android.lark.widget.light.span;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public interface j {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Pair<Integer, Integer> f446248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final NoPreviewPlaceHolderSpan.c f446249b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f446248a, r101.f446248a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f446249b, r101.f446249b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f446248a.hashCode() * 31;
            NoPreviewPlaceHolderSpan.c r101 = this.f446249b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "SizeInfo(size=" + this.f446248a + ", margin=" + this.f446249b + ')';
        }

        public a(Pair<Integer, Integer> r100, NoPreviewPlaceHolderSpan.c r101) {
            Intrinsics.checkNotNullParameter(r100, "size");
            this.f446248a = r100;
            this.f446249b = r101;
        }
    }

    a c();

    boolean d(int r100, int r101);
}
