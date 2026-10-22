package wt7;

import com.flow.kmp.common.platform.PlatformLoggerLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f561232a = null;

        static {
            int[] r100 = new int[PlatformLoggerLevel.values().length];
            r100[PlatformLoggerLevel.DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[PlatformLoggerLevel.INFO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[PlatformLoggerLevel.WARN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[PlatformLoggerLevel.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f561232a = r100;
        }
    }

    public static void a(PlatformLoggerLevel r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "level");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "message");
        int r103 = a.f561232a[r100.ordinal()];
        if (r103 != 1) goto L5;
        return;
    L5:
        if (r103 != 2) goto L7;
        return;
    L7:
        if (r103 != 3) goto L9;
        return;
    L9:
        if (r103 != 4) goto L12;
        return;
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
