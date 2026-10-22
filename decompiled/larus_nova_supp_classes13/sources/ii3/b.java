package ii3;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b {
    public int W3;
    public int X3;
    public int Y3;

    public b(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.W3 = 3;
        ((BaseSlcViewManager) this).j3 = true;
    }

    public final void H0(Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "props");
        if (r3.get("max_child") == null) goto L6;
        this.W3 = mq.b.b(r3.get("max_child"), 3);
        return;
    }

    public final void w0(Map<String, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r7, "dataCtx");
        super/*com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager*/.w0(r7);
        int r0 = 0;
        int r8 = mq.b.b(((BaseSlcViewManager) this).a.w.m0.a("len(data.coupon.item_list)", l(), null), 0);     // Catch: Exception -> L15
        this.Y3 = r8;     // Catch: Exception -> L15
    L4:
        if (r0 >= r8) goto L24;
        SlcRenderContext r1 = ((BaseSlcViewManager) this).a.w;     // Catch: Exception -> L15
        r1.getClass();     // Catch: Exception -> L15
        View r2 = SlcRenderContext.f(getView(), "pd_price_show_one_line_unique_key" + r0);     // Catch: Exception -> L15
        if (r2 == null) goto L7;
        Object r3 = r2.getTag(2131386877);     // Catch: Exception -> L15
        if ((r3 instanceof BaseSlcViewManager) == true) goto L11;
        r3 = null;
    L11:
        BaseSlcViewManager r4 = (BaseSlcViewManager) r3;     // Catch: Exception -> L15
        if (r4 == null) goto L14;
        r4.d1();     // Catch: Exception -> L15
    L14:
        r0 = r0 + 1;
        goto L4
    L7:
        return;
    L24:
        return;
    L15:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public final Map<String, Object> z0(Map<String, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r7, "dataCtx");
        Object r0 = l().get("data");
        Object r3 = null;
        if ((r0 instanceof Map) == true) goto L5;
        r0 = null;
    L5:
        Map r1 = (Map) r0;
        if (r1 != null) goto L8;
        return r7;
    L8:
        if (r1.get("should_sec_line") == null) goto L24;
        LinkedHashMap r4 = new LinkedHashMap();
        Object r8 = r7.get("data");
        if ((r8 instanceof HashMap) == false) goto L13;
        r3 = r8;
    L13:
        HashMap r5 = (HashMap) r3;
        if (r5 == null) goto L20;
        Iterator r9 = r5.entrySet().iterator();
    L17:
        if (r9.hasNext() == false) goto L19;
        Map.Entry r6 = (Map.Entry) r9.next();
        r4.put(r6.getKey(), r6.getValue());
        goto L17
    L19:
        r4.put("should_sec_line", r1.get("should_sec_line"));
    L20:
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put("data", r4);
        return r10;
    L24:
        return r7;
    }

    public final void v(int r11, int r12, int r13, int r14) {
        int r0 = 0;
        this.X3 = 0;
        super/*com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager*/.v(r11, r12, r13, r14);
        View r15 = getView().getChildAt(0);
        if (r15 != null) goto L6;
        return;
    L6:
        if (com.bytedance.commerce.base.view.b.a(r15).size() > this.W3) goto L34;
        int r16 = com.bytedance.commerce.base.view.b.a(r15).size();
        int r1 = 0;
    L8:
        if (r1 >= r16) goto L17;
        View r4 = (View) ListProtector.get(com.bytedance.commerce.base.view.b.a(r15), r1);
        if ((this.X3 + r4.getWidth()) <= r15.getWidth()) goto L15;
        if (r1 == 0) goto L12;
        r4.layout(r4.getLeft(), r4.getTop(), r4.getLeft(), r4.getBottom());
    L16:
        r1 = r1 + 1;
        goto L8
    L12:
        super/*com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager*/.v(r11, r12, r11, r12);
        getView().post(new a(this));
        return;
    L15:
        r4.layout(r4.getLeft() + this.X3, r4.getTop(), r4.getRight() + this.X3, r4.getBottom());
        this.X3 += r4.getWidth();
        goto L16
    L17:
        View r17 = getView().getChildAt(1);
        if (r17 == null) goto L28;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == true) goto L22;
        r18 = null;
    L22:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        if (r19 == null) goto L25;
        Integer r110 = Integer.valueOf(r19.leftMargin);
    L26:
        if (r110 == null) goto L28;
        int r111 = r110.intValue();
    L30:
        if (com.bytedance.commerce.base.view.b.a(getView()).size() <= 1) goto L61;
        View r112 = getView().getChildAt(1);
        if (r112 == null) goto L61;
        r15.layout((r112.getLeft() - this.X3) - r111, r15.getTop(), r112.getLeft() - r111, r15.getBottom());
    L61:
        int r113 = this.Y3;     // Catch: Exception -> L58
    L47:
        if (r0 >= r113) goto L73;
        SlcRenderContext r114 = ((BaseSlcViewManager) this).a.w;     // Catch: Exception -> L58
        r114.getClass();     // Catch: Exception -> L58
        View r115 = SlcRenderContext.f(getView(), "pd_price_show_one_line_unique_key" + r0);     // Catch: Exception -> L58
        if (r115 == null) goto L50;
        Object r116 = r115.getTag(2131386877);     // Catch: Exception -> L58
        if ((r116 instanceof BaseSlcViewManager) == true) goto L54;
        r116 = null;
    L54:
        BaseSlcViewManager r117 = (BaseSlcViewManager) r116;     // Catch: Exception -> L58
        if (r117 == null) goto L57;
        r117.H();     // Catch: Exception -> L58
    L57:
        r0 = r0 + 1;
        goto L47
    L50:
        return;
    L73:
        return;
    L58:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L25:
        r110 = null;
    L28:
        r111 = 0;
        goto L30
    L34:
        int r118 = r15.getWidth();
        int r2 = com.bytedance.commerce.base.view.b.a(r15).size();
        int r5 = 0;
    L35:
        if (r5 >= r2) goto L42;
        View r6 = (View) ListProtector.get(com.bytedance.commerce.base.view.b.a(r15), r5);
        if ((this.X3 + r6.getWidth()) > r118) goto L38;
        r6.layout(r6.getLeft() + this.X3, r6.getTop(), r6.getRight() + this.X3, r6.getBottom());
        this.X3 += r6.getWidth();
        r5 = r5 + 1;
        goto L35
    L38:
        super/*com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager*/.v(r11, r12, r11, r12);
        getView().post(new a(this));
        return;
    L42:
        if (com.bytedance.commerce.base.view.b.a(getView()).size() <= 1) goto L61;
        View r119 = getView().getChildAt(1);
        if (r119 == null) goto L61;
        r15.layout(r119.getLeft() - this.X3, r15.getTop(), r119.getLeft(), r15.getBottom());
        goto L61
    }
}
