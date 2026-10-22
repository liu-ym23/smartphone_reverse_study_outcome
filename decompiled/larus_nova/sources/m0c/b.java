package m0c;

import com.ss.android.lark.log.LogLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f511550a = null;

        static {
            int[] r100 = new int[LogLevel.values().length];
            r100[LogLevel.DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[LogLevel.INFO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[LogLevel.WARN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[LogLevel.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f511550a = r100;
        }
    }

    public static final void b(com.ss.android.lark.log.c r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter("n_action_cm_global_manager_impl", "tag");
        r100.i("n_action_cm_global_manager_impl", r101);
    }

    public static void a(com.ss.android.lark.log.c r100, String r101, String r102) {
        LogLevel r103 = LogLevel.INFO;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r103, "level");
        int r104 = a.f511550a[r103.ordinal()];
        if (r104 != 1) goto L5;
        r100.d(r101, r102);
        return;
    L5:
        if (r104 != 2) goto L7;
        r100.i(r101, r102);
        return;
    L7:
        if (r104 != 3) goto L9;
        r100.w(r101, r102);
        return;
    L9:
        if (r104 == 4) goto L11;
        r100.v(r101, r102);
        return;
    L11:
        r100.e(r101, r102);
    }
}
