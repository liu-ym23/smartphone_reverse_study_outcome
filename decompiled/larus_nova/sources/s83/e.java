package s83;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.ec.core.hybrid.bridges.ECShareGoodsPanelMethod;
import com.bytedance.android.ec.core.hybrid.bridges.ECSharePanelMethod;
import com.bytedance.android.ec.model.ECShopShareQrCodeInfo;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.json.JSONObject;
import tf3.m;

/* JADX INFO: loaded from: classes13.dex */
public interface e {
    void a(String r100);

    void b(Bundle r100, Activity r101, View r102, Function0<Unit> r103);

    void c(Activity r100, View r101, String r102, String r103, ECUrlModel r104, String r105);

    void createDurationMonitor(String r100);

    void d(Object r100, String r101, String r102);

    boolean e();

    void f(JSONObject r100, ECSharePanelMethod.a r101);

    void g(Function2<? super Boolean, ? super String, Unit> r100);

    void h(JSONObject r100, ECShareGoodsPanelMethod.a r101, View r102);

    void i(Context r100, Bundle r101, Bitmap r102, Function3<? super Boolean, ? super String, ? super Bundle, Unit> r103);

    void j(m r100, String r101, Boolean r102);

    void k(boolean r100, boolean r101, Activity r102, View r103, String r104, String r105, ECUrlModel r106, String r107, String r108, String r110, ECShopShareQrCodeInfo r111, i r112);

    void l(String r100, String r101);
}
