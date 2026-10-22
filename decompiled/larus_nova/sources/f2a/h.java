package f2a;

import com.larus.utils.logger.LogLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f475260a;

    /* JADX INFO: loaded from: classes31.dex */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f475261a = null;

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
            f475261a = r100;
        }
    }

    public h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f475260a = r100;
    }
}
