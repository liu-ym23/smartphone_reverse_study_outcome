package ua3;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.accessibility.b;
import com.bytedance.android.shopping.buynow.slice.countdown.BuyNowCountDownView;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends BaseSlcViewManager<BuyNowCountDownView> {
    public a(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "slcTemplateContext");
        super(r2);
    }

    public final View A0(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new BuyNowCountDownView(r5, null, 6, 0);
    }

    public final b E(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (((BuyNowCountDownView) getView()).dispatchHoverEvent(r2) == true) goto L5;
        return null;
    L5:
        return new b(this, true);
    }

    public final void H0(Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r13, "props");
        Object r0 = r13.get("count_down_end_timestamp");
        Object r2 = null;
        if ((r0 instanceof Number) == true) goto L5;
        r0 = null;
    L5:
        Number r1 = (Number) r0;
        if (r1 == null) goto L33;
        long r5 = r1.longValue();
        Object r3 = r13.get("count_down_type");
        if ((r3 instanceof String) == true) goto L10;
        r3 = null;
    L10:
        String r4 = (String) r3;
        if (r4 == null) goto L13;
        long r6 = CastLongProtector.parseLong(r4);
    L14:
        long r7 = r6;
        Object r8 = r13.get("font_color");
        if ((r8 instanceof String) == true) goto L17;
        r8 = null;
    L17:
        String r9 = (String) r8;
        if (r9 != null) goto L20;
        r9 = "#BF161823";
    L20:
        String r10 = r9;
        Object r11 = r13.get("suffix_text");
        if ((r11 instanceof Map) == true) goto L23;
        r11 = null;
    L23:
        Map<String, ? extends Object> r12 = (Map) r11;
        Object r14 = r13.get("font_size");
        if ((r14 instanceof String) == false) goto L27;
        r2 = r14;
    L27:
        String r15 = (String) r2;
        if (r15 == null) goto L30;
        int r16 = CastIntegerProtector.parseInt(r15);
    L31:
        ((BuyNowCountDownView) getView()).d(r16, r5, r7, r10, r12, com.bytedance.android.ecom.arch.slice.render.util.b.r(r13.get("count_down_end_action")));
        return;
    L30:
        r16 = 14;
        goto L31
    L13:
        r6 = 1;
        goto L14
    }
}
