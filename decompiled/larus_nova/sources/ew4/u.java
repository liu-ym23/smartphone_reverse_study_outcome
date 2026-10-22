package ew4;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.android.lark.integrator.ccm.dependency.di.a1;
import com.ss.android.lark.integrator.ccm.dependency.di.b1;
import com.ss.android.lark.integrator.ccm.dependency.di.z0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class u implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f474599a = null;

    static {
        f474599a = new u();
    }

    public u() {
    }

    @Override // ew4.a0
    public final Fragment U1(FragmentActivity r100, String r101, a1 r102) {
        Intrinsics.checkNotNullParameter(r101, "sceneToken");
        Intrinsics.checkNotNullParameter(r102, "callback");
        return null;
    }

    @Override // ew4.a0
    public final Fragment V1(FragmentActivity r100, String r101, q r102) {
        Intrinsics.checkNotNullParameter(r101, "sceneToken");
        Intrinsics.checkNotNullParameter(r102, "params");
        return null;
    }

    @Override // ew4.a0
    public final void x1(Activity r100, String r101, q r102) {
        Intrinsics.checkNotNullParameter(r101, "sceneToken");
        Intrinsics.checkNotNullParameter(r102, "params");
    }

    @Override // ew4.a0
    public final void I(Activity r100, String r101, z0.a r102) {
        Intrinsics.checkNotNullParameter(r101, "sceneToken");
        Intrinsics.checkNotNullParameter(r102, "callback");
        r102.a(null);
    }

    @Override // ew4.a0
    public final void w1(Context r100, String r101, p r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "sceneToken");
        Intrinsics.checkNotNullParameter(r102, "callback");
        r102.a(null);
    }

    @Override // ew4.a0
    public final void J1(Context r100, double r101, double r102, z0.b r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "callback");
        r103.a(null);
    }

    @Override // ew4.a0
    public final void b0(Context r100, String r101, String r102, b1 r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "sceneToken");
        Intrinsics.checkNotNullParameter(r102, LocationMonitorConst.ACCURACY);
        Intrinsics.checkNotNullParameter(r103, "callback");
        w1(r100, r101, r103);
    }
}
