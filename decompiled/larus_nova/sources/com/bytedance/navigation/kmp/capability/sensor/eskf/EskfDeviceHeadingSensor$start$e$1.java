package com.bytedance.navigation.kmp.capability.sensor.eskf;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class EskfDeviceHeadingSensor$start$e$1 extends FunctionReferenceImpl implements Function1<Double, Unit> {
    public EskfDeviceHeadingSensor$start$e$1(Object r100) {
        super(1, r100, EskfDeviceHeadingSensor.class, "onHeadingDeg", "onHeadingDeg(D)V", 0);
    }

    public final void invoke(double r110) {
        EskfDeviceHeadingSensor r100 = (EskfDeviceHeadingSensor) this.receiver;
        int r101 = EskfDeviceHeadingSensor.f265803n;
        r100.getClass();
        if (Double.isInfinite(r110) == false) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L20;
        com.bytedance.navigation.kmp.listener.b r103 = r100.f265808e;
        if (r103 == null) goto L21;
        long r104 = SystemClock.elapsedRealtime();
        long r105 = r100.f265812i;
        if (r105 > 0) goto L16;
    L18:
        r100.f265813j = r104;
        double r111 = ((r110 % 360.0d) + 360.0d) % 360.0d;
        r103.a((float) ((360.0d - r111) % 360.0d), (float) r111, true);
        return;
    L16:
        if ((r104 - r100.f265813j) >= r105) goto L18;
        return;
    L21:
        return;
    L20:
        return;
    L5:
        if (Double.isNaN(r110) == true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Double r100) {
        invoke(r100.doubleValue());
        return Unit.INSTANCE;
    }
}
