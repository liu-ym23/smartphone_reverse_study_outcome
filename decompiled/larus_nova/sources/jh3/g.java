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
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tf3.m;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements s83.e {
    public g() {
    }

    @Override // s83.e
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorName");
        Intrinsics.checkNotNullParameter("duration", "name");
    }

    @Override // s83.e
    public final void b(Bundle r100, Activity r101, View r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        Intrinsics.checkNotNullParameter(r101, "activity");
        Intrinsics.checkNotNullParameter(r102, "view");
    }

    @Override // s83.e
    public final void c(Activity r100, View r101, String r102, String r103, ECUrlModel r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "uid");
        Intrinsics.checkNotNullParameter(r103, "secUid");
    }

    @Override // s83.e
    public final void createDurationMonitor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorName");
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, "scene");
    }

    @Override // s83.e
    public final void d(Object r100, String r101, String r102) {
    }

    @Override // s83.e
    public final boolean e() {
        return false;
    }

    @Override // s83.e
    public final void f(JSONObject r100, ECSharePanelMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "jsbParams");
        Intrinsics.checkNotNullParameter(r101, "callback");
    }

    @Override // s83.e
    public final void g(Function2<? super Boolean, ? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
    }

    @Override // s83.e
    public final void h(JSONObject r100, ECShareGoodsPanelMethod.a r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "jsbParams");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "view");
    }

    @Override // s83.e
    public final void i(Context r100, Bundle r101, Bitmap r102, Function3<? super Boolean, ? super String, ? super Bundle, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "requestBundle");
        Intrinsics.checkNotNullParameter(r102, "screenshotBitmap");
        Intrinsics.checkNotNullParameter(r103, "callback");
    }

    @Override // s83.e
    public final void j(m r100, String r101, Boolean r102) {
    }

    @Override // s83.e
    public final void k(boolean r100, boolean r101, Activity r102, View r103, String r104, String r105, ECUrlModel r106, String r107, String r108, String r110, ECShopShareQrCodeInfo r111, com.bytedance.android.ec.model.i r112) {
        Intrinsics.checkNotNullParameter(r102, "activity");
        Intrinsics.checkNotNullParameter(r103, "view");
        Intrinsics.checkNotNullParameter(r104, "shopId");
        Intrinsics.checkNotNullParameter(r105, "secShopId");
    }

    @Override // s83.e
    public final void l(String r100, String r101) {
        Intrinsics.checkNotNullParameter("good", "shareItemType");
        Intrinsics.checkNotNullParameter(r101, "shareType");
        Intrinsics.checkNotNullParameter("qr_code", "shareObject");
    }
}
