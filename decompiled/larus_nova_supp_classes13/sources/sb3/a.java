package sb3;

import android.content.Context;
import android.view.View;
import androidx.core.view.NestedScrollingParent3;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.collect.slice.widgets.ProductCardContainerView;
import com.bytedance.android.shopping.collect.util.CollectCommonLog;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends b implements View.OnAttachStateChangeListener {
    public final String W3;
    public final SlcTemplateContext X3;
    public final com.bytedance.android.shopping.collect.slice.a Y3;

    public final /* bridge */ /* synthetic */ View A0(Context r1) {
        return J1(r1);
    }

    public final void H0(Map<String, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r8, "props");
        Lazy r0 = CollectCommonLog.a;
        CollectCommonLog.c(this.W3, "onUpdateProp: " + r8);
        Object r1 = r8.get("slide_threshold");
        Object r2 = null;
        if ((r1 instanceof Number) == true) goto L5;
        r1 = null;
    L5:
        Number r3 = (Number) r1;
        if (r3 == null) goto L8;
        int r4 = r3.intValue();
    L9:
        Object r5 = r8.get("bottom_buttons");
        if ((r5 instanceof List) == true) goto L12;
        r5 = null;
    L12:
        List r6 = (List) r5;
        if (r6 != null) goto L15;
        r6 = CollectionsKt.emptyList();
    L15:
        Object r9 = r8.get(PdpOpenThirdParam.KEY_PRODUCT_ID);
        if ((r9 instanceof String) == true) goto L18;
        r9 = null;
    L18:
        String r10 = (String) r9;
        if (r10 != null) goto L21;
        r10 = "";
    L21:
        View r7 = getView();
        if ((r7 instanceof ProductCardContainerView) == false) goto L25;
        r2 = r7;
    L25:
        ProductCardContainerView r11 = (ProductCardContainerView) r2;
        if (r11 == null) goto L41;
        int r12 = SlcDimensExtensionsKt.a(Integer.valueOf(r4), ((BaseSlcViewManager) this).a.m());
        List r13 = r6;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r15 = r13.iterator();
    L29:
        if (r15.hasNext() == false) goto L36;
        Object r16 = ((Map) r15.next()).get("key");
        if (r16 == null) goto L34;
        String r17 = r16.toString();
        if (r17 == null) goto L34;
    L35:
        r14.add(r17);
    L34:
        r17 = "";
        goto L35
    L36:
        Intrinsics.checkNotNullParameter(r10, "productId");
        Intrinsics.checkNotNullParameter(r14, "buttonList");
        r11.g = r12;
        return;
    L41:
        return;
    L8:
        r4 = 210;
        goto L9
    }

    public final SlcFlexElementView J1(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        NestedScrollingParent3 r0 = new ProductCardContainerView(r4, this.X3, this.Y3);
        r0.addOnAttachStateChangeListener(this);
        return r0;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        Object r3 = getView();
        if ((r3 instanceof ProductCardContainerView) == true) goto L5;
        r3 = null;
    L5:
        ProductCardContainerView r4 = (ProductCardContainerView) r3;
        if (r4 == null) goto L9;
        r4.h();
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        Object r3 = getView();
        if ((r3 instanceof ProductCardContainerView) == true) goto L5;
        r3 = null;
    L5:
        ProductCardContainerView r4 = (ProductCardContainerView) r3;
        if (r4 == null) goto L9;
        r4.h();
        return;
    }

    public a(SlcTemplateContext r2, com.bytedance.android.shopping.collect.slice.a r3) {
        Intrinsics.checkNotNullParameter(r2, "slcTemplateContext");
        super(r2);
        this.X3 = r2;
        this.Y3 = r3;
        this.W3 = "ProductCardContainerVM";
    }
}
