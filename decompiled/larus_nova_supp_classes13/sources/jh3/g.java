package jh3;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.ec.core.hybrid.bridges.ECShareGoodsPanelMethod;
import com.bytedance.android.ec.core.hybrid.bridges.ECSharePanelMethod;
import com.bytedance.android.ec.model.ECShopShareQrCodeInfo;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tf3.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements s83.e {
    public g() {
    }

    @Override // s83.e
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "monitorName");
        Intrinsics.checkNotNullParameter("duration", "name");
    }

    @Override // s83.e
    public final void b(Bundle r1, Activity r2, View r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r1, "bundle");
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
    }

    @Override // s83.e
    public final void c(Activity r1, View r2, String r3, String r4, ECUrlModel r5, String r6) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "uid");
        Intrinsics.checkNotNullParameter(r4, "secUid");
    }

    @Override // s83.e
    public final void createDurationMonitor(String r2) {
        Intrinsics.checkNotNullParameter(r2, "monitorName");
        Intrinsics.checkNotNullParameter("product_detail", "scene");
    }

    @Override // s83.e
    public final void d(Object r1, String r2, String r3) {
    }

    @Override // s83.e
    public final boolean e() {
        return false;
    }

    @Override // s83.e
    public final void f(JSONObject r2, ECSharePanelMethod.a r3) {
        Intrinsics.checkNotNullParameter(r2, "jsbParams");
        Intrinsics.checkNotNullParameter(r3, "callback");
    }

    @Override // s83.e
    public final void g(Function2<? super Boolean, ? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }

    @Override // s83.e
    public final void h(JSONObject r2, ECShareGoodsPanelMethod.a r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "jsbParams");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
    }

    @Override // s83.e
    public final void i(Context r2, Bundle r3, Bitmap r4, Function3<? super Boolean, ? super String, ? super Bundle, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "requestBundle");
        Intrinsics.checkNotNullParameter(r4, "screenshotBitmap");
        Intrinsics.checkNotNullParameter(r5, "callback");
    }

    @Override // s83.e
    public final void j(m r1, String r2, Boolean r3) {
    }

    @Override // s83.e
    public final void k(boolean r1, boolean r2, Activity r3, View r4, String r5, String r6, ECUrlModel r7, String r8, String r9, String r10, ECShopShareQrCodeInfo r11, com.bytedance.android.ec.model.i r12) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r5, "shopId");
        Intrinsics.checkNotNullParameter(r6, "secShopId");
    }

    @Override // s83.e
    public final void l(String r2, String r3) {
        Intrinsics.checkNotNullParameter("good", "shareItemType");
        Intrinsics.checkNotNullParameter(r3, "shareType");
        Intrinsics.checkNotNullParameter("qr_code", "shareObject");
    }
}
