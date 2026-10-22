package nj5;

import com.bytedance.ee.bear.more.copylink.CopyLinkFailReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CopyLinkFailReason f519448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f519449b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f519448a == r101.f519448a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f519449b, r101.f519449b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f519448a.hashCode() * 31;
            Throwable r101 = this.f519449b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Failed(reason=" + this.f519448a + ", error=" + this.f519449b + ')';
        }

        public a(CopyLinkFailReason r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f519448a = r100;
            this.f519449b = r101;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f519450a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f519450a, ((b) r100).f519450a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f519450a.hashCode();
        }

        public final String toString() {
            return "Success(copiedUrl=" + this.f519450a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "copiedUrl");
            this.f519450a = r100;
        }
    }

    public c() {
    }
}
