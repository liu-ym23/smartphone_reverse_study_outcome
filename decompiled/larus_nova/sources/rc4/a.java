package rc4;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.bytedance.bpea.basics.BPEAException;
import fna.g;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import ona.b;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: rc4.a$a, reason: collision with other inner class name */
    public static final class C7457a {
    }

    static {
    }

    @JvmStatic
    public static final void b(SensorManager r100, SensorEventListener r101, Sensor r102) throws BPEAException {
        if (g.d() == true) goto L5;
        r100.unregisterListener(r101, r102);
        return;
    L5:
        r100.unregisterListener(r101, r102);
        int r103 = 0;
        if (r101 == null) goto L8;
        int r104 = r101.hashCode();
    L9:
        if (r102 == null) goto L11;
        r103 = r102.hashCode();
    L11:
        b.c(new ona.a(r104, Integer.valueOf(r103)));
        return;
    L8:
        r104 = 0;
        goto L9
    }

    @JvmStatic
    public static final void a(SensorManager r100, SensorEventListener r101, Sensor r102, Handler r103) throws BPEAException {
        if (g.d() == true) goto L5;
        Boolean r104 = Boolean.valueOf(r100.registerListener(r101, r102, 3, r103));
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Boolean");
        r104.booleanValue();
        return;
    L5:
        Boolean r105 = Boolean.valueOf(r100.registerListener(r101, r102, 3, r103));
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Boolean");
        r105.booleanValue();
        int r106 = 0;
        if (r101 == null) goto L8;
        int r107 = r101.hashCode();
    L9:
        if (r102 == null) goto L11;
        r106 = r102.hashCode();
    L11:
        b.a(new ona.a(r107, Integer.valueOf(r106)));
        return;
    L8:
        r107 = 0;
        goto L9
    }
}
