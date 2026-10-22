package t98;

import com.larus.avlink.gallery.power.policy.AlbumThermalLevel;
import com.larus.common.apphost.AppHost;
import com.larus.power.state.api.PowerMetricAvailability;
import com.larus.power.state.api.PowerStateService;
import com.larus.power.state.api.ThermalLevel;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f545137a;

    public static final class a {
    }

    static {
    }

    @Override // t98.h
    public final g o() {
        if (this.f545137a.compareAndSet(false, true) == true) goto L97;
    L95:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L22
        PowerStateService.f365951a.getClass();     // Catch: Throwable -> L22
        PowerStateService r101 = (PowerStateService) ServiceManager.get().getService(PowerStateService.class);     // Catch: Throwable -> L22
        if (r101 == null) goto L19;
        wr9.j r102 = r101.o();     // Catch: Throwable -> L22
    L20:
        Object r103 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L22
    L24:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L28;
        FLogger.f375446a.e("AlbumPowerState", "Failed to read cached album power state: " + r104.getMessage(), r104);
    L28:
        if (Result.m9455isFailureimpl(r103) == false) goto L30;
        r103 = null;
    L30:
        wr9.j r105 = (wr9.j) r103;
        if (r105 == null) goto L94;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        wr9.d<ThermalLevel> r106 = r105.f560895b.f560904a;
        ThermalLevel r107 = r106.f560886a;
        Boolean r110 = (Boolean) j.a(r105.f560898e.f560878c);
        Integer r111 = (Integer) j.a(r105.f560898e.f560876a);
        Boolean r112 = (Boolean) j.a(r105.f560898e.f560877b);
        Double r113 = (Double) j.a(r105.f560896c.f560879a);
        Double r114 = (Double) j.a(r105.f560896c.f560880b);
        Boolean r115 = (Boolean) j.a(r105.f560897d.f560884d);
        Long r116 = (Long) j.a(r105.f560897d.f560882b);
        Integer r108 = (Integer) j.a(r105.f560899f.f560900a);
        if (r108 != null) goto L35;
    L40:
        Integer r117 = null;
    L41:
        Integer r109 = (Integer) j.a(r105.f560899f.f560903d);
        if (r109 != null) goto L44;
    L49:
        Integer r118 = null;
    L51:
        if (r107 != null) goto L53;
        int r119 = -1;
    L54:
        switch(r119) {
            case -1: goto L64;
            case 0: goto L56;
            case 1: goto L63;
            case 2: goto L62;
            case 3: goto L61;
            case 4: goto L60;
            case 5: goto L59;
            case 6: goto L58;
            case 7: goto L57;
            case 8: goto L64;
            default: goto L56;
        };
    L57:
        AlbumThermalLevel r120 = AlbumThermalLevel.SHUTDOWN;
    L65:
        AlbumThermalLevel r121 = r120;
        if (r106.f560887b == PowerMetricAvailability.AVAILABLE) goto L68;
    L70:
        boolean r122 = false;
    L71:
        if (r113 != null) goto L75;
        if (r114 != null) goto L75;
        boolean r210 = false;
    L76:
        if (r115 != null) goto L80;
        if (r116 != null) goto L80;
        boolean r211 = false;
    L81:
        if (r110 != null) goto L86;
        if (r111 != null) goto L86;
        if (r112 != null) goto L86;
        boolean r212 = false;
    L87:
        if (r117 != null) goto L91;
        if (r118 != null) goto L91;
        boolean r213 = false;
    L99:
        return new g(r121, r122, r110, r111, r112, r113, r114, r115, r116, r117, r118, r210, r211, r212, r213);
    L91:
        r213 = true;
    L86:
        r212 = true;
    L80:
        r211 = true;
    L75:
        r210 = true;
        goto L76
    L68:
        if (r106.f560886a == null) goto L70;
        r122 = true;
        goto L71
    L58:
        r120 = AlbumThermalLevel.EMERGENCY;
        goto L65
    L59:
        r120 = AlbumThermalLevel.CRITICAL;
        goto L65
    L60:
        r120 = AlbumThermalLevel.SEVERE;
        goto L65
    L61:
        r120 = AlbumThermalLevel.MODERATE;
        goto L65
    L62:
        r120 = AlbumThermalLevel.LIGHT;
        goto L65
    L63:
        r120 = AlbumThermalLevel.NONE;
        goto L65
    L64:
        r120 = AlbumThermalLevel.UNKNOWN;
        goto L65
    L56:
        throw new NoWhenBranchMatchedException();
    L53:
        r119 = j.a.f545138a[r107.ordinal()];
        goto L54
    L44:
        if (r109.intValue() < 0) goto L46;
        boolean r123 = true;
    L47:
        if (r123 == false) goto L49;
        r118 = r109;
        goto L51
    L46:
        r123 = false;
        goto L47
    L35:
        if (r108.intValue() <= 0) goto L37;
        boolean r124 = true;
    L38:
        if (r124 == false) goto L40;
        r117 = r108;
        goto L41
    L37:
        r124 = false;
        goto L38
    L94:
        return new g(AlbumThermalLevel.UNKNOWN, false, null, null, null, null, null, null, null, null, null, false, false, false, false);
    L19:
        r102 = null;
    L22:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L97:
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L11
        PowerStateService.f365951a.getClass();     // Catch: Throwable -> L11
        PowerStateService r127 = (PowerStateService) ServiceManager.get().getService(PowerStateService.class);     // Catch: Throwable -> L11
        if (r127 == null) goto L8;
        r127.initialize(AppHost.f326268a.getApplication());     // Catch: Throwable -> L11
        Unit r128 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Object r129 = Result.m9449constructorimpl(r128);     // Catch: Throwable -> L11
    L13:
        Throwable r130 = Result.m9452exceptionOrNullimpl(r129);
        if (r130 == null) goto L95;
        this.f545137a.set(false);
        FLogger.f375446a.e("AlbumPowerState", "Failed to initialize album power state: " + r130.getMessage(), r130);
        goto L95
    L8:
        r128 = null;
    L11:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public i() {
        this.f545137a = new AtomicBoolean(false);
    }
}
