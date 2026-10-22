package m9;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public interface c extends com.bytedance.android.annie.service.a {
    void c1(String r100);

    double getCpuRate();

    double getCpuSpeed();

    float getTemperature();

    void h0(String r100, Function2<? super Double, ? super JSONObject, Unit> r101);
}
