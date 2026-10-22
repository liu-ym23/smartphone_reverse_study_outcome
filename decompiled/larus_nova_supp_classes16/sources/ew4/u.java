package ew4;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.integrator.ccm.dependency.di.a1;
import com.ss.android.lark.integrator.ccm.dependency.di.b1;
import com.ss.android.lark.integrator.ccm.dependency.di.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u implements a0 {
    public static final u a = null;

    static {
        a = new u();
    }

    public u() {
    }

    @Override // ew4.a0
    public final Fragment U1(FragmentActivity r1, String r2, a1 r3) {
        Intrinsics.checkNotNullParameter(r2, "sceneToken");
        Intrinsics.checkNotNullParameter(r3, "callback");
        return null;
    }

    @Override // ew4.a0
    public final Fragment V1(FragmentActivity r1, String r2, q r3) {
        Intrinsics.checkNotNullParameter(r2, "sceneToken");
        Intrinsics.checkNotNullParameter(r3, "params");
        return null;
    }

    @Override // ew4.a0
    public final void x1(Activity r1, String r2, q r3) {
        Intrinsics.checkNotNullParameter(r2, "sceneToken");
        Intrinsics.checkNotNullParameter(r3, "params");
    }

    @Override // ew4.a0
    public final void I(Activity r1, String r2, z0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "sceneToken");
        Intrinsics.checkNotNullParameter(r3, "callback");
        r3.a(null);
    }

    @Override // ew4.a0
    public final void w1(Context r2, String r3, p r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "sceneToken");
        Intrinsics.checkNotNullParameter(r4, "callback");
        r4.a(null);
    }

    @Override // ew4.a0
    public final void J1(Context r1, double r2, double r4, z0.b r6) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r6, "callback");
        r6.a(null);
    }

    @Override // ew4.a0
    public final void b0(Context r2, String r3, String r4, b1 r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "sceneToken");
        Intrinsics.checkNotNullParameter(r4, "accuracy");
        Intrinsics.checkNotNullParameter(r5, "callback");
        w1(r2, r3, r5);
    }
}
