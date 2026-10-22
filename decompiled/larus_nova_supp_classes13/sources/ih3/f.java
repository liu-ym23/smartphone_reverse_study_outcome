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
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tf3.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements s83.e {
    public static final f b = null;
    public final /* synthetic */ s83.e a;

    @Override // s83.e
    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "monitorName");
        Intrinsics.checkNotNullParameter("duration", "name");
        this.a.a(r3);
    }

    @Override // s83.e
    public final void b(Bundle r2, Activity r3, View r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "bundle");
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        this.a.b(r2, r3, r4, r5);
    }

    @Override // s83.e
    public final void c(Activity r9, View r10, String r11, String r12, ECUrlModel r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "activity");
        Intrinsics.checkNotNullParameter(r10, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r11, "uid");
        Intrinsics.checkNotNullParameter(r12, "secUid");
        this.a.c(r9, r10, r11, r12, r13, r14);
    }

    @Override // s83.e
    public final void createDurationMonitor(String r3) {
        Intrinsics.checkNotNullParameter(r3, "monitorName");
        Intrinsics.checkNotNullParameter("product_detail", "eventName");
        this.a.createDurationMonitor(r3);
    }

    @Override // s83.e
    public final void d(Object r2, String r3, String r4) {
        this.a.d(r2, r3, r4);
    }

    @Override // s83.e
    public final boolean e() {
        return this.a.e();
    }

    @Override // s83.e
    public final void f(JSONObject r2, ECSharePanelMethod.a r3) {
        Intrinsics.checkNotNullParameter(r2, "jsbParams");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a.f(r2, r3);
    }

    @Override // s83.e
    public final void g(Function2<? super Boolean, ? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a.g(r2);
    }

    @Override // s83.e
    public final void h(JSONObject r2, ECShareGoodsPanelMethod.a r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "jsbParams");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        this.a.h(r2, r3, r4);
    }

    @Override // s83.e
    public final void i(Context r2, Bundle r3, Bitmap r4, Function3<? super Boolean, ? super String, ? super Bundle, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "requestBundle");
        Intrinsics.checkNotNullParameter(r4, "screenshotBitmap");
        Intrinsics.checkNotNullParameter(r5, "callback");
        this.a.i(r2, r3, r4, r5);
    }

    @Override // s83.e
    public final void j(m r2, String r3, Boolean r4) {
        this.a.j(r2, r3, r4);
    }

    @Override // s83.e
    public final void k(boolean r15, boolean r16, Activity r17, View r18, String r19, String r20, ECUrlModel r21, String r22, String r23, String r24, ECShopShareQrCodeInfo r25, i r26) {
        Intrinsics.checkNotNullParameter(r17, "activity");
        Intrinsics.checkNotNullParameter(r18, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r19, "shopId");
        Intrinsics.checkNotNullParameter(r20, "secShopId");
        this.a.k(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    @Override // s83.e
    public final void l(String r3, String r4) {
        Intrinsics.checkNotNullParameter("good", "shareItemType");
        Intrinsics.checkNotNullParameter(r4, "shareType");
        Intrinsics.checkNotNullParameter("qr_code", "shareObject");
        this.a.l(r3, r4);
    }

    static {
        b = new f();
    }

    public f() {
        this.a = g.b.W();
    }
}
