package cyb;

import com.ss.android.lark.opmonitor.model.OPMonitorLevel;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f465990a = null;

        static {
            int[] r100 = new int[OPMonitorLevel.values().length];
            f465990a = r100;
            r100[OPMonitorLevel.FATAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f465990a[OPMonitorLevel.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f465990a[OPMonitorLevel.WARN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f465990a[OPMonitorLevel.NORMAL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f465990a[OPMonitorLevel.TRACE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public c() {
    }
}
