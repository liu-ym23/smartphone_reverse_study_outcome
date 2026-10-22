package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPopExtendInfo;
import com.bytedance.android.ec.model.response.ExtendInfoContent;
import com.bytedance.android.ec.model.response.ExtendInfoHeader;
import com.bytedance.android.ec.model.response.ExtendInfoRow;
import com.bytedance.android.ec.model.response.ExtendInfoTable;
import com.bytedance.android.ec.model.response.ExtendInfoTopContent;
import com.bytedance.android.ec.model.response.d0;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r extends p {
    public s g;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ r a;
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c b;

        public b(r r1, com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r5) {
            pk2.d r6 = (pk2.d) r5;
            if (r6.b != 0) goto L7;
            ((ViewGroup) this.a.w().f()).removeAllViews();
            r r0 = this.a;
            s r1 = r0.g;
            if (r1 == null) goto L7;
            ((ViewGroup) r0.w().f()).removeCallbacks(r1);
        L7:
            ECPopExtendInfo r2 = r6.a;
            if (r2 == null) goto L28;
            List r3 = r2.getContent();
            if (r3 == null) goto L29;
            boolean r4 = true;
            if ((!r3.isEmpty()) == true) goto L15;
            r3 = null;
        L15:
            if (r3 != null) goto L17;
            return;
        L17:
            if (r6.b != 2) goto L31;
            this.a.w().g(0);
            r r7 = this.a;
            ExtendInfoTopContent r8 = r6.a.getTopContent();
            if (r8 == null) goto L25;
            List r9 = r8.getContent();
            if (r9 == null) goto L25;
            if ((!r9.isEmpty()) != true) goto L25;
        L26:
            r.E(r7, 0, r3, r4);
            return;
        L25:
            r4 = false;
            goto L26
        L31:
            return;
        L29:
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ TextView a;

        public c(TextView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.setGravity(8388629);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public r() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r4) {
        Intrinsics.checkNotNullParameter(r4, "model");
        ExplainCardViewModel r0 = this.e;
        if (r0 == null) goto L6;
        r0.getCardExtendInfoState().b(r4.getLifecycleOwner(), new b(this, r4));
        return;
    }

    public final TextView G(String r4) {
        TextView r0 = new TextView(u().c());
        r0.setText(r4);
        r0.setTextSize(2, 10.0f);
        r0.setTextColor(-16777216);
        r0.setGravity(8388627);
        r0.setEllipsize(null);
        r0.setMaxLines(1);
        r0.setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
        return r0;
    }

    public final LinearLayout F(String r10, String r11, boolean r12) {
        LinearLayout r0 = new LinearLayout(u().c());
        r0.setOrientation(0);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilityKotlinExtentionsKt.d(21)));
        r0.setGravity(16);
        RelativeLayout r2 = new RelativeLayout(u().c());
        o0.c(r2, 8388611);
        r2.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        TextView r13 = G(r10);
        if (r12 == false) goto L5;
        r13.setTextColor(th.a.a(u().c(), 2131105953));
    L5:
        ViewGroup.LayoutParams r6 = r13.getLayoutParams();
        if (r6 == null) goto L17;
        ((RelativeLayout.LayoutParams) r6).addRule(20, -1);
        Unit r7 = Unit.INSTANCE;
        r2.addView(r13);
        r0.addView(r2);
        int r14 = UtilityKotlinExtentionsKt.d(8);
        TextView r3 = new TextView(u().c());
        r3.setLayoutParams(new LinearLayout.LayoutParams(r14, 0));
        r0.addView(r3);
        RelativeLayout r15 = new RelativeLayout(u().c());
        o0.c(r15, 8388613);
        r15.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        TextView r16 = G(r11);
        if (r12 == false) goto L10;
        r16.setTextColor(th.a.a(u().c(), 2131105953));
    L10:
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 == null) goto L15;
        ((RelativeLayout.LayoutParams) r17).addRule(21, -1);
        r16.post(new c(r16));
        r15.addView(r16);
        r0.addView(r15);
        return r0;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    public static final void E(r r10, int r11, List r12, boolean r13) {
        ViewGroup r2 = (ViewGroup) r10.w().f();
        ExtendInfoContent r0 = (ExtendInfoContent) CollectionsKt.getOrNull(r12, r11);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getType() == 1) goto L7;
        ECExceptionMonitor.c("Unsupported type: " + r0.getType());
        return;
    L7:
        View r1 = (View) CollectionsKt.lastOrNull(com.bytedance.commerce.base.view.b.a(r2));
        ExtendInfoTable r4 = r0.getTable();
        LinearLayout r5 = new LinearLayout(r10.u().c());
        r5.setOrientation(1);
        r5.setBackgroundColor(-1);
        r5.setPadding(UtilityKotlinExtentionsKt.d(8), 0, UtilityKotlinExtentionsKt.d(8), 0);
        if (r4 == null) goto L12;
        ExtendInfoHeader r6 = r4.getHeader();
        if (r6 == null) goto L12;
        LinearLayout r7 = r10.F(r6.getName(), r6.getValue(), true);
        r7.setTag("header");
        r5.addView(r7);
    L12:
        LinearLayout r8 = new LinearLayout(r10.u().c());
        r8.setOrientation(1);
        r8.setTag("row");
        if (r4 == null) goto L23;
        List r3 = r4.getRows();
        if (r3 == null) goto L23;
        Iterator r9 = r3.iterator();
        int r14 = 0;
    L18:
        if (r9.hasNext() == false) goto L23;
        Object r15 = r9.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        ExtendInfoRow r17 = (ExtendInfoRow) r15;
        r8.addView(r10.F(r17.getName(), r17.getValue(), false));
        r14 = r16;
    L23:
        r5.addView(r8);
        r2.addView(r5);
        if (r11 != 0) goto L26;
        r5.setTranslationY(r2.getHeight());
        r5.animate().translationY(0.0f).setInterpolator(new FastOutSlowInInterpolator()).setDuration(500).start();
    L29:
        r10.g = new s(r2, r10, r12, r11, r13);
        ((ViewGroup) r10.w().f()).postDelayed(r10.g, r0.getDuration());
        final d0 r18 = r0.getTrackInfo();
        if (r18 == null) goto L38;
        ExplainCardViewModel r19 = r10.e;
        String r110 = r18.a();
        ExplainCardViewModel r20 = r10.e;
        if (r20 == null) goto L36;
        QLiveData<ECUIPromotion> r21 = r20.getPromotionState();
        if (r21 == null) goto L36;
        ECUIPromotion r22 = (ECUIPromotion) r21.a();
    L37:
        UtilityKotlinExtentionsKt.g(r19, r110, r22, new ExtendContentPresenter$handleContentExpose$1$1(r18));
    L36:
        r22 = null;
    L38:
        ExplainCardViewModel r111 = r10.e;
        if (r111 == null) goto L53;
        QLiveData<ECUIPromotion> r112 = r111.getPromotionState();
        if (r112 == null) goto L54;
        ECUIPromotion r113 = (ECUIPromotion) r112.a();
        if (r113 == null) goto L55;
        ql.b r114 = r113.getClientData();
        if (r114 == null) goto L56;
        r114.i = r0;
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L26:
        r5.setTranslationX(r2.getWidth());
        r5.animate().translationX(0.0f).setInterpolator(new FastOutSlowInInterpolator()).setDuration(500).start();
        if (r1 == null) goto L29;
        r1.animate().translationX(-r2.getWidth()).setInterpolator(new FastOutSlowInInterpolator()).setDuration(500).start();
        goto L29
    }
}
