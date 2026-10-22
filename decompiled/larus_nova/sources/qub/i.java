package qub;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class i {

    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f534857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f534858b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f534857a, r101.f534857a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f534858b, r101.f534858b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f534857a.hashCode() * 31) + this.f534858b.hashCode();
        }

        public final String toString() {
            return "OpenWebPage(context=" + this.f534857a + ", url=" + this.f534858b + ')';
        }

        public final Context getContext() {
            return this.f534857a;
        }

        public a(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "url");
            this.f534857a = r100;
            this.f534858b = r101;
        }
    }

    public i() {
    }
}
