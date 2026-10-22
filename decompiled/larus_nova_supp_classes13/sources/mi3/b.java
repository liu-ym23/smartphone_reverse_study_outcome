package mi3;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.sku.CommonMarqueeView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends BaseSlcViewGroupManager<CommonMarqueeView> {
    public final void A1() {
        getView().b();
    }

    public b(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "slcTemplateContext");
        super(r2);
        ((BaseSlcViewManager) this).j3 = true;
        ((BaseSlcViewGroupManager) this).Q3 = true;
    }

    public final View A0(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new CommonMarqueeView(r5, null, 6, 0);
    }

    public final void H0(Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "props");
        float r0 = com.bytedance.android.ecom.arch.slice.render.util.b.u(r4, "time_switch_interval", 3.0f);
        getView().setInterval((int) (r0 * 1000.0f));
        float r1 = com.bytedance.android.ecom.arch.slice.render.util.b.u(r4, "time_animation_interval", 0.4f);
        getView().setScrollDuration((int) (r1 * 1000.0f));
        boolean r2 = false;
        int r5 = com.bytedance.android.ecom.arch.slice.render.util.b.f(r4.get("scroll_direction"), 0) | 0;
        CommonMarqueeView r3 = getView();
        if (r5 != 0) goto L5;
        r2 = true;
    L5:
        r3.setOrientation(r2);
    }

    public final void w0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCtx");
        super.w0(r2);
        getView().c();
    }

    public final void x0(View r2) {
        CommonMarqueeView r3 = (CommonMarqueeView) r2;
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        r3.addOnAttachStateChangeListener(new a(r3));
    }

    public final void y0(SlcElement r4) {
        super.y0(r4);
        getView().setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        getView().setInterval(3000);
        getView().setItemSpacing(com.bytedance.android.shopping.extensions.b.b(4));
    }

    public final Map<String, Object> z0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCtx");
        if (getView().g == false) goto L5;
        ((BaseSlcViewManager) this).l3 = true;
    L5:
        return r2;
    }

    public final void D1(BaseSlcViewManager<?> r1, int r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "childViewManager");
        r1.v(0, 0, r1.getView().getWidth(), r1.getView().getHeight());
    }
}
