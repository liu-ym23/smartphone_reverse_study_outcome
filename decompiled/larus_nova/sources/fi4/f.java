package fi4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class f<DATA> {

    public static final class a<DATA> extends f<DATA> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DATA f477363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f477364b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f477365c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f477363a, r101.f477363a) == true) goto L12;
            return false;
        L12:
            if (this.f477364b == r101.f477364b) goto L15;
            return false;
        L15:
            if (this.f477365c == r101.f477365c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            DATA r100 = this.f477363a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            int r102 = ((r101 * 31) + this.f477364b) * 31;
            if (this.f477365c == false) goto L9;
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

        public final String toString() {
            return "VideoPlayStatus(data=" + this.f477363a + ", playedDuration=" + this.f477364b + ", errorOccurred=" + this.f477365c + ')';
        }

        public a(DATA r100, int r101, boolean r102) {
            this.f477363a = r100;
            this.f477364b = r101;
            this.f477365c = r102;
        }
    }

    public f() {
    }
}
