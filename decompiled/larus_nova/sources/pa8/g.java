package pa8;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.supervisor.token.Token;
import com.larus.office.base.location.FlowShowLocationFragment;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.integrator.ccm.dependency.di.a1;
import com.ss.android.lark.integrator.ccm.dependency.di.b1;
import com.ss.android.lark.integrator.ccm.dependency.di.z0;
import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.location.dto.POIConfig;
import com.ss.android.lark.location.dto.Scene;
import com.ss.android.lark.location.listener.LocationRequestOption;
import com.ss.android.lark.utils.statistics.PerfLog;
import ew4.a0;
import ew4.o;
import ew4.p;
import ew4.q;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f528382a;

    public static final class a {
    }

    static {
    }

    public g() {
        this.f528382a = new Handler(Looper.getMainLooper());
    }

    public static POIConfig X0(FragmentActivity r100) {
        POIConfig r101 = new POIConfig();
        int r102 = r100.getResources().getIdentifier("Bitable_Common_ButtonSave", "string", r100.getPackageName());
        if (r102 == 0) goto L5;
        String r103 = r100.getString(r102);
    L6:
        if (r103 == null) goto L8;
        r101.setActionText(r103);
    L8:
        r101.setSnapshot(false);
        r101.setSelfDefine(false);
        return r101;
    L5:
        FLogger.f375446a.w("FlowLocationHostService", "Bitable save text resource not found");
        r103 = null;
        goto L6
    }

    public static boolean Z1(q r100) {
        double r101 = r100.f474595c;
        if ((-90.0d) <= r101) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L26;
        double r103 = r100.f474596d;
        if ((-180.0d) <= r103) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == true) goto L17;
        return false;
    L17:
        if (Double.isNaN(r101) == false) goto L19;
        return false;
    L19:
        if (Double.isNaN(r100.f474596d) == false) goto L21;
        return false;
    L21:
        if (Double.isInfinite(r100.f474595c) == false) goto L23;
        return false;
    L23:
        if (Double.isInfinite(r100.f474596d) == true) goto L31;
        return true;
    L31:
        return false;
    L12:
        if (r103 > 180.0d) goto L14;
        r104 = true;
        goto L15
    L26:
        return false;
    L5:
        if (r101 > 90.0d) goto L7;
        r102 = true;
        goto L8
    }

    public static o b2(LarkLocation r110) {
        double r100 = r110.getLatitude();
        double r101 = r110.getLongitude();
        String r102 = r110.f431175a;
        String r103 = r110.f431176b;
        String r104 = r110.f431177c;
        String r105 = r110.f431178d;
        String r111 = r110.f431179e;
        String r112 = r110.f431180f;
        int r106 = r110.f431181g;
        if (r106 != 40100) goto L5;
        int r113 = 2;
    L10:
        return new o(r100, r101, null, r102, r103, r104, r105, r111, r112, r113, r110.f431183i);
    L5:
        if (r106 == 40400) goto L7;
        r113 = 0;
        goto L10
    L7:
        r113 = 3;
        goto L10
    }

    public final void a2(final Function0<Unit> r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        this.f528382a.post(new f(r100));
    }

    @Override // ew4.a0
    public final void I(Activity r100, final String r101, final z0.a r102) {
        Intrinsics.checkNotNullParameter(r101, "sceneToken");
        Intrinsics.checkNotNullParameter(r102, "callback");
        FLogger r103 = FLogger.f375446a;
        r103.i("FlowLocationHostService", "selectMapLocation, sceneToken=".concat(r101));
        if ((r100 instanceof FragmentActivity) == false) goto L5;
        final FragmentActivity r104 = (FragmentActivity) r100;
    L6:
        if (r104 != null) goto L9;
        r103.w("FlowLocationHostService", "selectMapLocation skipped, activity is not FragmentActivity");
        r102.a(null);
        return;
    L9:
        a2(new c(this, r104, r102, r101));
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // ew4.a0
    public final Fragment U1(FragmentActivity r100, String r101, a1 r102) {
        Intrinsics.checkNotNullParameter(r101, "sceneToken");
        Intrinsics.checkNotNullParameter(r102, "callback");
        FLogger.f375446a.i("FlowLocationHostService", "selectMapLocationFragment, sceneToken=".concat(r101));
        if (r100 != null) goto L7;
        return null;
    L7:
        return fqb.a.a(X0(r100), new Token(r101), Scene.Base.INSTANCE, new h(r102, this), true);
    }

    @Override // ew4.a0
    public final Fragment V1(FragmentActivity r100, String r101, q r110) {
        Intrinsics.checkNotNullParameter(r101, "sceneToken");
        Intrinsics.checkNotNullParameter(r110, "params");
        FLogger.f375446a.i("FlowLocationHostService", "getShowLocationFragment, sceneToken=".concat(r101));
        if (r100 != null) goto L5;
        return null;
    L5:
        if (Z1(r110) == false) goto L11;
        int r102 = FlowShowLocationFragment.f360580e;
        return FlowShowLocationFragment.a.a(r101, r110.f474593a, r110.f474594b, r110.f474595c, r110.f474596d);
    L11:
        return null;
    }

    @Override // ew4.a0
    public final void w1(Context r100, String r101, p r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "sceneToken");
        Intrinsics.checkNotNullParameter(r102, "callback");
        FLogger.f375446a.i("FlowLocationHostService", "getLocation, sceneToken=".concat(r101));
        new um9.a();
        final z0.c r103 = (z0.c) r102;
        um9.a.a(new Token(r101), Scene.Base.INSTANCE, new b(r103, this));
    }

    @Override // ew4.a0
    public final void x1(Activity r100, final String r101, final q r102) {
        Intrinsics.checkNotNullParameter(r101, "sceneToken");
        Intrinsics.checkNotNullParameter(r102, "params");
        FLogger r103 = FLogger.f375446a;
        r103.i("FlowLocationHostService", "showLocation, sceneToken=".concat(r101));
        if ((r100 instanceof FragmentActivity) == false) goto L5;
        final FragmentActivity r104 = (FragmentActivity) r100;
    L6:
        if (r104 != null) goto L10;
        r103.w("FlowLocationHostService", "showLocation skipped, activity is not FragmentActivity");
        return;
    L10:
        if (Z1(r102) == true) goto L13;
        r103.w("FlowLocationHostService", "showLocation skipped, invalid coordinate");
        return;
    L13:
        a2(new pa8.a(this, r104, r101, r102));
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // ew4.a0
    public final void J1(Context r100, double r110, double r111, final z0.b r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "callback");
        FLogger.f375446a.i("FlowLocationHostService", "getAddressFromLocation");
        new um9.f();
        Scene.Base r101 = Scene.Base.INSTANCE;
        com.ss.android.lark.location.service.h.a r102 = new e(r112, this);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "listener");
        um9.f.a(r100, r110, r111, r102);
    }

    @Override // ew4.a0
    public final void b0(Context r100, String r101, String r102, final b1 r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "sceneToken");
        Intrinsics.checkNotNullParameter(r102, LocationMonitorConst.ACCURACY);
        Intrinsics.checkNotNullParameter(r103, "callback");
        FLogger.f375446a.i("FlowLocationHostService", "getLocationWithOption, sceneToken=" + r101 + ", accuracy=" + r102);
        new um9.a();
        Token r104 = new Token(r101);
        Scene.Base r105 = Scene.Base.INSTANCE;
        dqb.c r106 = new d(r103, this);
        LarkLocation.CoordinateSystem r107 = LarkLocation.CoordinateSystem.DEFAULT;
        LocationRequestOption.LocationPriority r108 = LocationRequestOption.LocationPriority.PRIORITY_HIGH_ACCURACY;
        Intrinsics.checkNotNullParameter(r104, "token");
        Intrinsics.checkNotNullParameter(r105, "scene");
        um9.a.a(r104, r105, r106);
    }
}
