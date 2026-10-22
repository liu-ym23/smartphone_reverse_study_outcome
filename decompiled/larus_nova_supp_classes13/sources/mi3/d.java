package mi3;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.sku.CommonMarqueeView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends com.bytedance.android.ecom.arch.slice.render.elements.a<CommonMarqueeView> {
    public final void A1() {
        I1().b();
    }

    public d(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "slcTemplateContext");
        super(r2);
        ((BaseSlcViewManager) this).j3 = true;
        ((BaseSlcViewGroupManager) this).Q3 = true;
        ((BaseSlcViewGroupManager) this).O3 = true;
    }

    public final void H0(Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "props");
        float r0 = com.bytedance.android.ecom.arch.slice.render.util.b.u(r4, "time_switch_interval", 3.0f);
        I1().setInterval((int) (r0 * 1000.0f));
        float r1 = com.bytedance.android.ecom.arch.slice.render.util.b.u(r4, "time_animation_interval", 0.4f);
        I1().setScrollDuration((int) (r1 * 1000.0f));
        boolean r2 = false;
        int r5 = com.bytedance.android.ecom.arch.slice.render.util.b.f(r4.get("scroll_direction"), 0) | 0;
        CommonMarqueeView r3 = I1();
        if (r5 != 0) goto L5;
        r2 = true;
    L5:
        r3.setOrientation(r2);
    }

    public final void J1(ViewGroup r2) {
        CommonMarqueeView r3 = (CommonMarqueeView) r2;
        Intrinsics.checkNotNullParameter(r3, "contentView");
        r3.addOnAttachStateChangeListener(new c(r3));
    }

    public final ViewGroup K1(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new CommonMarqueeView(r5, null, 6, 0);
    }

    public final void w0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCtx");
        super/*com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager*/.w0(r2);
        I1().c();
    }

    public final void y0(SlcElement r4) {
        super/*com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager*/.y0(r4);
        I1().setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        I1().setInterval(3000);
        I1().setItemSpacing(com.bytedance.android.shopping.extensions.b.b(4));
    }

    public final Map<String, Object> z0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCtx");
        if (I1().g == false) goto L5;
        ((BaseSlcViewManager) this).l3 = true;
    L5:
        return r2;
    }

    public final void D1(BaseSlcViewManager<?> r1, int r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "childViewManager");
        r1.v(0, 0, r1.getView().getWidth(), r1.getView().getHeight());
    }
}
