package com.bytedance.android.shopping.new_cart.components;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.btm.api.view.BtmViewUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.yata.biz.popup.PopupLayer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l extends com.bytedance.android.shopping.new_cart.components.a {
    public final Lazy b;
    public final Lazy c;
    public final FrameLayout d;

    public static final class a implements hl3.e.a {
        public final /* synthetic */ Context a;
        public final /* synthetic */ l b;

        public final FrameLayout getHost() {
            FrameLayout r0 = this.b.d;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return new FrameLayout(getContext());
        }

        public final FrameLayout.LayoutParams getLayoutParams() {
            return new FrameLayout.LayoutParams(-1, -1);
        }

        public Context getContext() {
            return this.a;
        }

        public a(Context r1, l r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final PopupLayer n() {
        return (PopupLayer) this.b.getValue();
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void j() {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L11
        r0.putOpt("visible", Boolean.FALSE);     // Catch: Exception -> L11
        r0.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L11
        hl3.a r1 = n().k();     // Catch: Exception -> L11
        if ((r1 instanceof com.bytedance.android.shopping.yata.biz.popup.a) == true) goto L5;
        r1 = null;
    L5:
        com.bytedance.android.shopping.yata.biz.popup.a r2 = (com.bytedance.android.shopping.yata.biz.popup.a) r1;     // Catch: Exception -> L11
        if (r2 == null) goto L16;
        hl3.d r3 = r2.a();     // Catch: Exception -> L11
        if (r3 == null) goto L17;
        r3.a(r0);     // Catch: Exception -> L11
        return;
    L17:
        return;
    L16:
        return;
    L11:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void k() {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L11
        r0.putOpt("visible", Boolean.TRUE);     // Catch: Exception -> L11
        r0.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L11
        hl3.a r1 = n().k();     // Catch: Exception -> L11
        if ((r1 instanceof com.bytedance.android.shopping.yata.biz.popup.a) == true) goto L5;
        r1 = null;
    L5:
        com.bytedance.android.shopping.yata.biz.popup.a r2 = (com.bytedance.android.shopping.yata.biz.popup.a) r1;     // Catch: Exception -> L11
        if (r2 == null) goto L16;
        hl3.d r3 = r2.a();     // Catch: Exception -> L11
        if (r3 == null) goto L17;
        r3.a(r0);     // Catch: Exception -> L11
        return;
    L17:
        return;
    L16:
        return;
    L11:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public final void o() {
        FrameLayout r0 = this.d;
        FrameLayout r1 = null;
        if (r0 == null) goto L5;
        ViewParent r2 = r0.getParent();
    L7:
        if ((r2 instanceof ViewGroup) == true) goto L9;
        r2 = null;
    L9:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 == null) goto L12;
        Integer r4 = Integer.valueOf(r3.indexOfChild(this.d));
    L13:
        if (r4 == null) goto L17;
        int r5 = r4.intValue();
        if (r4.intValue() != (r3.getChildCount() - 1)) goto L17;
        r3.removeViewAt(r5);
        r3.addView(this.d, r3.getChildCount() - 2);
    L17:
        FrameLayout r6 = this.d;
        if (r6 == null) goto L25;
        r6.setVisibility(8);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == true) goto L22;
        r7 = null;
    L22:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        if (r8 == null) goto L25;
        r8.bottomMargin = 0;
    L25:
        FrameLayout r9 = this.d;
        if ((r9 instanceof View) == false) goto L29;
        r1 = r9;
    L29:
        if (r1 == null) goto L32;
        String r10 = BtmViewUtils.a;
        BtmViewUtils.a(r1);
        return;
    L32:
        return;
    L12:
        r4 = null;
        goto L13
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void h() {
        Context r0 = e();
        if (r0 == null) goto L6;
        n().j(new a(r0, this));
        return;
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void i() {
        com.bytedance.android.shopping.yata.biz.popup.b r0 = n().d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("queue");
    L5:
        r0.a.clear();
    }

    public l(CartObjectContainer r3, FrameLayout r4) {
        Intrinsics.checkNotNullParameter(r3, "objectContainer");
        Intrinsics.checkNotNullParameter("yata_cart", "bizCode");
        super(r3);
        this.d = r4;
        this.b = LazyKt.lazy(CartPopupLayerComponent$footerPopupLayer$2.INSTANCE);
        this.c = LazyKt.lazy(new CartPopupLayerComponent$footerComponent$2(this));
    }
}
