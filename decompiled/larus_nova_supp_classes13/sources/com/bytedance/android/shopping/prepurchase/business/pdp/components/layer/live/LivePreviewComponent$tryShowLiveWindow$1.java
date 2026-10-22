package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.live;

import android.widget.RelativeLayout;
import com.bytedance.android.shopping.anchorv4.dto.business.BottomRightControl;
import com.bytedance.android.shopping.anchorv4.dto.business.BottomRightWidgetParam;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.extensions.k;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/android/ec/adapter/api/a;", "invoke", "()Lcom/bytedance/android/ec/adapter/api/a;", "buildFloatExtra"}, k = 3, mv = {1, 4, 3})
final class LivePreviewComponent$tryShowLiveWindow$1 extends Lambda implements Function0<com.bytedance.android.ec.adapter.api.a> {
    final /* synthetic */ LivePreviewComponent this$0;

    public LivePreviewComponent$tryShowLiveWindow$1(LivePreviewComponent r1) {
        this.this$0 = r1;
        super(0);
    }

    public final com.bytedance.android.ec.adapter.api.a invoke() {
        com.bytedance.android.ec.adapter.api.a r0 = new com.bytedance.android.ec.adapter.api.a();
        Intrinsics.checkNotNullParameter("ecom_product_detail", "<set-?>");
        r0.a = "ecom_product_detail";
        LivePreviewComponent r1 = this.this$0;
        int r2 = LivePreviewComponent.s;
        String r3 = r1.g2().getNativeParams().getLiveRoomId();
        RelativeLayout.LayoutParams r4 = null;
        if (r3 != null) goto L5;
    L10:
        String r5 = this.this$0.g2().getNativeParams().getV3EventsAdditions();
        if (r5 == null) goto L19;
        JSONObject r6 = k.w(r5);
        if (r6 == null) goto L19;
        HashMap r7 = new HashMap();
        Iterator<String> r8 = r6.keys();
    L16:
        if (r8.hasNext() == false) goto L18;
        String r9 = r8.next();
        r7.put(r9, r6.optString(r9));
        goto L16
    L18:
        r0.e = r7;
    L19:
        CommonMeta r10 = this.this$0.O1().d().getData().a().a();
        if (r10 != null) goto L22;
    L24:
        r4 = new RelativeLayout.LayoutParams(1, 1);
        r4.addRule(12);
        r4.addRule(11);
        if (r10 == null) goto L33;
        BottomRightControl r11 = r10.getBottomRightControl();
        if (r11 == null) goto L33;
        BottomRightWidgetParam r12 = r11.getSmallWindow();
        if (r12 == null) goto L33;
        Integer r13 = r12.getBottomMargin();
        if (r13 == null) goto L33;
        int r14 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r13.intValue() - 13));
    L34:
        r4.bottomMargin = r14;
    L35:
        r0.f = r4;
        return r0;
    L33:
        r14 = com.bytedance.android.shopping.extensions.b.b(103);
        goto L34
    L22:
        if (r10.isBottomTipExist() == true) goto L24;
    L5:
        if (k.c(r3) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L10;
        r0.b = StringsKt.toLongOrNull(r3);
        goto L10
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m2551invoke() {
        return invoke();
    }
}
