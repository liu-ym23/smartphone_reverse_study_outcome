package com.bytedance.android.shopping.card_list.components;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.btm.api.view.BtmViewUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.yata.biz.popup.PopupLayer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListPopupLayerComponent extends b {
    public final Lazy d;
    public final Lazy e;
    public final FrameLayout f;

    public static final class a implements hl3.e.a {
        public final /* synthetic */ Context a;
        public final /* synthetic */ CardListPopupLayerComponent b;

        public final FrameLayout getHost() {
            FrameLayout r0 = this.b.f;
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

        public a(Context r1, CardListPopupLayerComponent r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final PopupLayer g() {
        return (PopupLayer) this.d.getValue();
    }

    public final void h() {
        FrameLayout r0 = this.f;
        FrameLayout r1 = null;
        if (r0 == null) goto L5;
        ViewParent r2 = r0.getParent();
    L7:
        if ((r2 instanceof ViewGroup) == true) goto L9;
        r2 = null;
    L9:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 == null) goto L12;
        Integer r4 = Integer.valueOf(r3.indexOfChild(this.f));
    L13:
        if (r4 == null) goto L17;
        int r5 = r4.intValue();
        if (r4.intValue() != (r3.getChildCount() - 1)) goto L17;
        r3.removeViewAt(r5);
        r3.addView(this.f, r3.getChildCount() - 2);
    L17:
        FrameLayout r6 = this.f;
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
        FrameLayout r9 = this.f;
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

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onCreate() {
        super.onCreate();
        Context r0 = e();
        if (r0 == null) goto L6;
        g().j(new a(r0, this));
        return;
    }

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.shopping.yata.biz.popup.b r0 = g().d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("queue");
    L5:
        r0.a.clear();
    }

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onPause() {
        super.onPause();
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L12
        r0.putOpt("visible", Boolean.FALSE);     // Catch: Exception -> L12
        r0.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L12
        hl3.a r1 = g().k();     // Catch: Exception -> L12
        if ((r1 instanceof com.bytedance.android.shopping.yata.biz.popup.a) == true) goto L6;
        r1 = null;
    L6:
        com.bytedance.android.shopping.yata.biz.popup.a r2 = (com.bytedance.android.shopping.yata.biz.popup.a) r1;     // Catch: Exception -> L12
        if (r2 == null) goto L17;
        hl3.d r3 = r2.a();     // Catch: Exception -> L12
        if (r3 == null) goto L18;
        r3.a(r0);     // Catch: Exception -> L12
        return;
    L18:
        return;
    L17:
        return;
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onResume() {
        super.onResume();
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L12
        r0.putOpt("visible", Boolean.TRUE);     // Catch: Exception -> L12
        r0.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L12
        hl3.a r1 = g().k();     // Catch: Exception -> L12
        if ((r1 instanceof com.bytedance.android.shopping.yata.biz.popup.a) == true) goto L6;
        r1 = null;
    L6:
        com.bytedance.android.shopping.yata.biz.popup.a r2 = (com.bytedance.android.shopping.yata.biz.popup.a) r1;     // Catch: Exception -> L12
        if (r2 == null) goto L17;
        hl3.d r3 = r2.a();     // Catch: Exception -> L12
        if (r3 == null) goto L18;
        r3.a(r0);     // Catch: Exception -> L12
        return;
    L18:
        return;
    L17:
        return;
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public CardListPopupLayerComponent(CardListObjectContainer r2, FrameLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        super(r2);
        this.f = r3;
        this.d = LazyKt.lazy(CardListPopupLayerComponent$footerPopupLayer$2.INSTANCE);
        this.e = LazyKt.lazy(new CardListPopupLayerComponent$footerComponent$2(this));
    }
}
