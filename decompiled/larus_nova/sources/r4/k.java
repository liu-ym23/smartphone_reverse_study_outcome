package r4;

import android.content.ClipData;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

/* JADX INFO: loaded from: classes43.dex */
public interface k {
    boolean a(Context r100, e3.d r101, String r102);

    void b(Context r100, e3.d r101, String r102, ClipData r103);

    ClipData c(Context r100, e3.d r101, String r102);

    void d(Context r100, Integer r101, Long r102, String r103, Long r104, c r105, Boolean r106, String r107);

    Sensor e(SensorManager r100, e3.d r101, String r102, int r103);
}
