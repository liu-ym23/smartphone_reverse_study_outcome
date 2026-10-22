package ntb;

import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public interface o extends com.ss.android.lark.officesdk.di.core.b {

    public interface a {
        com.ss.android.lark.officesdk.utils.di.k a(String r100);

        com.ss.android.lark.officesdk.utils.di.k b();

        void flush();
    }

    public interface b {
    }

    public interface c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f520561a = null;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f520562a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final e f520563b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final e f520564c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final e f520565d = null;

            public a() {
            }

            static {
                f520562a = new a();
                f520563b = new e(EffectConstants.NORMAL, 1);
                f520564c = new e("WARN", 2);
                f520565d = new e("ERROR", 3);
            }
        }

        static {
            f520561a = a.f520562a;
        }
    }

    public static abstract class d implements b {
        public d(String r100, e r101) {
            Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        }
    }

    public static final class e implements c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f520566b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f520567c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f520566b, r101.f520566b) == true) goto L12;
            return false;
        L12:
            if (this.f520567c == r101.f520567c) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f520566b.hashCode() * 31) + this.f520567c;
        }

        public final String toString() {
            return "SimpleMonitorLevel(name=" + this.f520566b + ", level=" + this.f520567c + ')';
        }

        public e(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.f520566b = r100;
            this.f520567c = r101;
        }
    }

    String T();

    a d();

    String k0();
}
