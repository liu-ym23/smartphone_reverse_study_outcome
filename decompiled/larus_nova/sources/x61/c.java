package x61;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public interface c extends h<View, a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f562583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewGroup f562584b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f562583a, r101.f562583a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f562584b, r101.f562584b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            Context r100 = this.f562583a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            ViewGroup r104 = this.f562584b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(context=" + this.f562583a + ", parent=" + this.f562584b + ")";
        }

        public final Context getContext() {
            return this.f562583a;
        }

        public a(Context r100, ViewGroup r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "parent");
            this.f562583a = r100;
            this.f562584b = r101;
        }
    }
}
