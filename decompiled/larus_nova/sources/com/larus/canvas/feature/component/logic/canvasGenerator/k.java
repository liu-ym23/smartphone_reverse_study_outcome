package com.larus.canvas.feature.component.logic.canvasGenerator;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class k<T> {

    public static final class a extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f323337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f323338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f323339c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f323337a == r101.f323337a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f323338b, r101.f323338b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f323339c, r101.f323339c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f323337a * 31) + this.f323338b.hashCode()) * 31;
            Throwable r101 = this.f323339c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        @Override // com.larus.canvas.feature.component.logic.canvasGenerator.k
        public final String toString() {
            return "Error(code=" + this.f323337a + ", msg=" + this.f323338b + ", throwable=" + this.f323339c + ')';
        }

        public a(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            this.f323337a = r100;
            this.f323338b = r101;
            this.f323339c = null;
        }
    }

    public static final class b<T> extends k<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f323340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f323341b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f323340a, r101.f323340a) == true) goto L12;
            return false;
        L12:
            if (this.f323341b == r101.f323341b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f323340a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            int r102 = r101 * 31;
            if (this.f323341b == false) goto L9;
            int r103 = 1231;
        L11:
            return r102 + r103;
        L9:
            r103 = 1237;
            goto L11
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        @Override // com.larus.canvas.feature.component.logic.canvasGenerator.k
        public final String toString() {
            return "Success(data=" + this.f323340a + ", isFinish=" + this.f323341b + ')';
        }

        public b(T r100, boolean r101) {
            this.f323340a = r100;
            this.f323341b = r101;
        }
    }

    public k() {
    }

    public String toString() {
        if ((this instanceof b) == false) goto L6;
        return "Success[" + this + ']';
    L6:
        if ((this instanceof a) == false) goto L10;
        return "Error[" + this + ']';
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
