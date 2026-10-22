package eb9;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public abstract class e {

    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f471877a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f471877a, ((a) r100).f471877a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f471877a.hashCode();
        }

        public final String toString() {
            return "Raw(value=" + this.f471877a + ')';
        }

        public a(CharSequence r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.f471877a = r100;
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f471878a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f471878a == ((b) r100).f471878a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f471878a;
        }

        public final String toString() {
            return "Resource(resId=" + this.f471878a + ')';
        }

        public b(int r100) {
            this.f471878a = r100;
        }
    }

    public e() {
    }

    public final CharSequence a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((this instanceof b) == false) goto L6;
        return r100.getText(((b) this).f471878a);
    L6:
        if ((this instanceof a) == false) goto L10;
        return ((a) this).f471877a;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
