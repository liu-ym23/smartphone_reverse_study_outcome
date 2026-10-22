package r1;

import com.apm.lite.CrashType;
import com.apm.lite.ICrashCallback;
import com.apm.lite.IOOMCallback;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes39.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ICrashCallback> f535548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ICrashCallback> f535549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<ICrashCallback> f535550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<ICrashCallback> f535551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<IOOMCallback> f535552e;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f535553a = null;

        static {
            int[] r100 = new int[CrashType.values().length];
            f535553a = r100;
            r100[CrashType.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f535553a[CrashType.ANR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f535553a[CrashType.JAVA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f535553a[CrashType.LAUNCH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f535553a[CrashType.NATIVE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public c() {
        this.f535548a = new CopyOnWriteArrayList();
        this.f535549b = new CopyOnWriteArrayList();
        this.f535550c = new CopyOnWriteArrayList();
        this.f535551d = new CopyOnWriteArrayList();
        this.f535552e = new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
    }
}
