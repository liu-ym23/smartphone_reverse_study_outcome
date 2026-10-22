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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface e {
    void a(String r1);

    void b(Bundle r1, Activity r2, View r3, Function0<Unit> r4);

    void c(Activity r1, View r2, String r3, String r4, ECUrlModel r5, String r6);

    void createDurationMonitor(String r1);

    void d(Object r1, String r2, String r3);

    boolean e();

    void f(JSONObject r1, ECSharePanelMethod.a r2);

    void g(Function2<? super Boolean, ? super String, Unit> r1);

    void h(JSONObject r1, ECShareGoodsPanelMethod.a r2, View r3);

    void i(Context r1, Bundle r2, Bitmap r3, Function3<? super Boolean, ? super String, ? super Bundle, Unit> r4);

    void j(m r1, String r2, Boolean r3);

    void k(boolean r1, boolean r2, Activity r3, View r4, String r5, String r6, ECUrlModel r7, String r8, String r9, String r10, ECShopShareQrCodeInfo r11, i r12);

    void l(String r1, String r2);
}
