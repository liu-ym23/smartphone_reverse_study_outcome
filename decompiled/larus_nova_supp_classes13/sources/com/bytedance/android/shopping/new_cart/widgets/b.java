package com.bytedance.android.shopping.new_cart.widgets;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Runnable {
    public final /* synthetic */ CartGULView a;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return CartGULView.e(this.a.a);
        }
    }

    public b(CartGULView r1) {
        this.a = r1;
    }

    public final void a() {
        ti.l r1 = null;
        if (CartGULView.d(this.a) == false) goto L5;
        com.bytedance.android.shopping.api.mall.feed.d r0 = CartGULView.c(this.a);
        if (r0 == null) goto L27;
        View r3 = r0.getView();
        if ((true ^ Intrinsics.areEqual(r3.getParent(), this.a)) == false) goto L26;
        ti.l r2 = r3.getParent();
        if ((r2 instanceof ViewGroup) == false) goto L22;
        r1 = r2;
    L22:
        ViewGroup r4 = (ViewGroup) r1;
        if (r4 == null) goto L25;
        r4.removeView(r3);
    L25:
        this.a.addView(r3, new FrameLayout.LayoutParams(-1, -1));
    L26:
        r0.c();
        return;
    L27:
        EnsureManager.ensureNotReachHere("YATACartGULView, ECMallFeedComponent is null");
        if (ECAppInfoService.e.isLocalTest() == true) goto L31;
        return;
    L31:
        throw new IllegalStateException("YATACartGULView, ECMallFeedComponent is null");
    L5:
        if (this.a.getLiveComponent() != null) goto L10;
        this.a.removeAllViews();
        CartGULView r5 = this.a;
        Context r6 = r5.getContext();
        String r7 = CartGULView.a(this.a);
        JSONObject r8 = new JSONObject();
        r8.put("module_param", new JSONObject());
        r8.put("mob_data", new JSONObject());
        Unit r9 = Unit.INSTANCE;
        ti.l r10 = ECLiveHybridUtil.b(r6, r7, com.bytedance.android.shopping.hybrid.a.b(r8), this.a, null, null, null, false, null, null, false, 4080);
        if (r10 == null) goto L9;
        r10.registerMethod("x.publishEvent", new a(this));
        r1 = r10;
    L9:
        r5.setLiveComponent(r1);
        this.a.h(true);
        return;
    L10:
        ti.l r11 = this.a.getLiveComponent();
        if (r11 == null) goto L13;
        r11.loadUrl(CartGULView.a(this.a));
    L13:
        this.a.h(true);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
