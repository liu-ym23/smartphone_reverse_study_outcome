package ih3;

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
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tf3.m;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements s83.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f489805b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s83.e f489806a;

    @Override // s83.e
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorName");
        Intrinsics.checkNotNullParameter("duration", "name");
        this.f489806a.a(r100);
    }

    @Override // s83.e
    public final void b(Bundle r100, Activity r101, View r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        Intrinsics.checkNotNullParameter(r101, "activity");
        Intrinsics.checkNotNullParameter(r102, "view");
        this.f489806a.b(r100, r101, r102, r103);
    }

    @Override // s83.e
    public final void c(Activity r100, View r110, String r111, String r112, ECUrlModel r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r111, "uid");
        Intrinsics.checkNotNullParameter(r112, "secUid");
        this.f489806a.c(r100, r110, r111, r112, r113, r114);
    }

    @Override // s83.e
    public final void createDurationMonitor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorName");
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, "eventName");
        this.f489806a.createDurationMonitor(r100);
    }

    @Override // s83.e
    public final void d(Object r100, String r101, String r102) {
        this.f489806a.d(r100, r101, r102);
    }

    @Override // s83.e
    public final boolean e() {
        return this.f489806a.e();
    }

    @Override // s83.e
    public final void f(JSONObject r100, ECSharePanelMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "jsbParams");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f489806a.f(r100, r101);
    }

    @Override // s83.e
    public final void g(Function2<? super Boolean, ? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f489806a.g(r100);
    }

    @Override // s83.e
    public final void h(JSONObject r100, ECShareGoodsPanelMethod.a r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "jsbParams");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "view");
        this.f489806a.h(r100, r101, r102);
    }

    @Override // s83.e
    public final void i(Context r100, Bundle r101, Bitmap r102, Function3<? super Boolean, ? super String, ? super Bundle, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "requestBundle");
        Intrinsics.checkNotNullParameter(r102, "screenshotBitmap");
        Intrinsics.checkNotNullParameter(r103, "callback");
        this.f489806a.i(r100, r101, r102, r103);
    }

    @Override // s83.e
    public final void j(m r100, String r101, Boolean r102) {
        this.f489806a.j(r100, r101, r102);
    }

    @Override // s83.e
    public final void k(boolean r110, boolean r111, Activity r112, View r113, String r114, String r210, ECUrlModel r211, String r212, String r213, String r214, ECShopShareQrCodeInfo r215, i r216) {
        Intrinsics.checkNotNullParameter(r112, "activity");
        Intrinsics.checkNotNullParameter(r113, "view");
        Intrinsics.checkNotNullParameter(r114, "shopId");
        Intrinsics.checkNotNullParameter(r210, "secShopId");
        this.f489806a.k(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    @Override // s83.e
    public final void l(String r100, String r101) {
        Intrinsics.checkNotNullParameter("good", "shareItemType");
        Intrinsics.checkNotNullParameter(r101, "shareType");
        Intrinsics.checkNotNullParameter("qr_code", "shareObject");
        this.f489806a.l(r100, r101);
    }

    static {
        f489805b = new f();
    }

    public f() {
        this.f489806a = g.f489807b.W();
    }
}
