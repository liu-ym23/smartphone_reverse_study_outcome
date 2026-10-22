package t98;

import com.larus.power.state.api.PowerMetricAvailability;
import com.larus.power.state.api.ThermalLevel;

/* JADX INFO: loaded from: classes25.dex */
public final class j {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f545138a = null;

        static {
            int[] r100 = new int[ThermalLevel.values().length];
            r100[ThermalLevel.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[ThermalLevel.LIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[ThermalLevel.MODERATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[ThermalLevel.SEVERE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[ThermalLevel.CRITICAL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[ThermalLevel.EMERGENCY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[ThermalLevel.SHUTDOWN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[ThermalLevel.UNKNOWN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f545138a = r100;
        }
    }

    public static final <T> T a(wr9.d<T> r100) {
        T r101 = r100.f560886a;
        if (r100.f560887b != PowerMetricAvailability.AVAILABLE) goto L6;
        if (r101 == null) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L11;
        return null;
    L11:
        return r101;
    L6:
        r102 = false;
        goto L7
    }
}
