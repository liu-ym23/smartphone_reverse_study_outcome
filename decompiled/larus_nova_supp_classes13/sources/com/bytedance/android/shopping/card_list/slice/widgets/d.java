package com.bytedance.android.shopping.card_list.slice.widgets;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.card_list.components.CardListSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements ti.k {
    public final /* synthetic */ e a;
    public final /* synthetic */ CardListSliceCustomWidgetAdapterComponent b;
    public final /* synthetic */ String c;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ ViewTreeObserver b;
        public final /* synthetic */ d c;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            int r0 = this.a.getHeight();
            if (r0 > 0) goto L5;
            return;
        L5:
            if (this.b.isAlive() == false) goto L7;
            this.b.removeOnGlobalLayoutListener(this);
        L7:
            d r1 = this.c;
            CardListSliceCustomWidgetAdapterComponent r2 = r1.b;
            if (r2 != null) goto L10;
            return;
        L10:
            if (r1.a.getEnableLargeTextMode() == false) goto L14;
            Float r3 = ECAppInfoService.e.getCurrentFontScale();
            if (r3 == null) goto L14;
            float r4 = r3.floatValue();
        L15:
            com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r5 = ((AndroidYaTaInstance) this.c.b.j.e.c.invoke()).p;
            if (r5 == null) goto L18;
            int r6 = com.bytedance.android.shopping.card_list.utils.h.a;
            Intrinsics.checkNotNullParameter(r5, "renderinfo");
            float r7 = r5.b.f.a;
        L19:
            int r8 = (int) ((60 * r4) * r7);
            if (com.bytedance.android.shopping.extensions.k.c(this.c.c) == false) goto L22;
            r2.i.e.invoke(Integer.valueOf((r8 + ((int) (12 * r7))) + r0));
            return;
        L22:
            r2.i.e.invoke(Integer.valueOf(r8));
            return;
        L18:
            Resources r9 = Resources.getSystem();
            r7 = WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics()).density;
        L14:
            r4 = 1.0f;
            goto L15
        }

        public a(View r1, ViewTreeObserver r2, d r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.requestLayout();     // Catch: Throwable -> L4
            this.a.a.invalidate();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        Intrinsics.checkNotNullParameter("", "errorMessage");
    }

    public final void onFirstScreen(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void onLoadSuccess(View r3) {
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        this.a.post(new b(this));
        ti.l r4 = this.a.c;
        if (r4 == null) goto L8;
        View r5 = r4.getHybridView();
        if (r5 == null) goto L9;
        ViewTreeObserver r0 = r5.getViewTreeObserver();
        r0.addOnGlobalLayoutListener(new a(r5, r0, this));
        return;
    L9:
        return;
    }

    public final void onRuntimeReady(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void g(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
    }

    public final void onLoadFailed(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "lynxView");
        Intrinsics.checkNotNullParameter(r1, "lynxView");
    }

    public final void onPageStart(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "lynxView");
        Intrinsics.checkNotNullParameter(r1, "lynxView");
    }

    public d(e r1, CardListSliceCustomWidgetAdapterComponent r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void s(View r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
    }
}
