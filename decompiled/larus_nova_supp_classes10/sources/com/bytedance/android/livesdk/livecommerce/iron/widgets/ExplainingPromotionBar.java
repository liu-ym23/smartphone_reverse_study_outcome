package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.livesdk.livecommerce.utils.LiveBstReport;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/ExplainingPromotionBar;", "Landroid/widget/LinearLayout;", "", "promotionId", "", "setPreviousPromotionId", "getCurrentPromotionId", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainingPromotionBar extends LinearLayout {
    public final TextView a;
    public final TextView b;
    public final a c;
    public String d;
    public Function0<Unit> e;

    public static final class a implements Runnable {
        public final /* synthetic */ ExplainingPromotionBar a;

        public a(ExplainingPromotionBar r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ExplainingPromotionBar(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ExplainingPromotionBar(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void b() {
        removeCallbacks(this.c);
        setVisibility(8);
        Function0<Unit> r0 = this.e;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke();
        return;
    }

    public final String getCurrentPromotionId() {
        String r0 = this.d;
        if (r0 == null) goto L11;
        if (getVisibility() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L11;
        return r0;
    L7:
        r2 = false;
    L11:
        return null;
    }

    public final void setPreviousPromotionId(String r1) {
        this.d = r1;
    }

    public final void a(com.bytedance.android.ec.common.api.jump.model.g r5, final Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r5, "promotionParams");
        final ql.a r7 = r5.a;
        com.bytedance.android.bst.api.e r0 = new com.bytedance.android.bst.api.e(this);
        final String r1 = "a1.b0715.c9204.d10885";
        r0.a = "a1.b0715.c9204.d10885";
        if (r7.isLottery() == false) goto L5;
        String r2 = "livesdk_unrec_show_product";
    L6:
        r0.b = r2;
        if (r7.isLottery() == false) goto L9;
        String r3 = "live_shopping_lottery";
    L10:
        r0.d = r3;
        r0.c = r7.getUniTag() + "explain_bar";
        r0.e = 2131370502;
        r0.f = new LiveBstReport(new ExplainingPromotionBar$bindNewBst$$inlined$apply$lambda$1(r1, r7, r6), ExplainingPromotionBar$bindNewBst$builder$1$2.INSTANCE);
        com.bytedance.android.bst.api.f r8 = com.bytedance.android.bst.api.f.b;
        com.bytedance.android.bst.api.d r9 = BtmUtilsKt.h(r0);
        r8.getClass();
        com.bytedance.android.bst.api.f.a(r9);
        return;
    L9:
        r3 = "live_shopping";
        goto L10
    L5:
        r2 = "livesdk_show_product";
        goto L6
    }

    public ExplainingPromotionBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = new a(this);
        setOrientation(0);
        th.a.c(r2, 2131564717, this, true);
        this.a = (TextView) findViewById(2131390775);
        this.b = (TextView) findViewById(2131391198);
    }

    public /* synthetic */ ExplainingPromotionBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
