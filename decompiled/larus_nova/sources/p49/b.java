package p49;

import com.larus.dora.api.annotation.EnvObserveChangeReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f527711a = null;

        static {
            int[] r100 = new int[EnvObserveChangeReason.values().length];
            r100[EnvObserveChangeReason.DEVICE_CHANGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[EnvObserveChangeReason.CONNECT_CHANGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[EnvObserveChangeReason.SWITCH_CHANGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[EnvObserveChangeReason.TIMER_CHANGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[EnvObserveChangeReason.WIFI_CHANGE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f527711a = r100;
        }
    }

    public static final String a(EnvObserveChangeReason r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = a.f527711a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "device state change";
    L5:
        if (r101 != 2) goto L7;
        return "link connect change";
    L7:
        if (r101 != 3) goto L9;
        return "env switch change";
    L9:
        if (r101 != 4) goto L11;
        return "env timer change";
    L11:
        if (r101 == 5) goto L13;
        return "unknown";
    L13:
        return "env wifi change";
    }
}
