package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.rotation.BaseRotationAdapter;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.android.livesdk.livecommerce.iron.ui.ECCustomizedElementView;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.utils.ECLiveDegradeHelper;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends BaseRotationAdapter<com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a> {
    public static final /* synthetic */ int w = 0;
    public float m;
    public Animator n;
    public boolean o;
    public boolean p;
    public final List<com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a> q;
    public boolean r;
    public boolean s;
    public final gi2.a t;
    public final boolean u;
    public final RoomContextController v;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b$b, reason: collision with other inner class name */
    public static final class C0092b<T> implements Comparator<T> {
        public C0092b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) r1).a.getPriority()), Integer.valueOf(((com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) r2).a.getPriority()));
        }
    }

    public static final class c<T> implements Comparator<T> {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) r1).a.getPriority()), Integer.valueOf(((com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) r2).a.getPriority()));
        }
    }

    public static final class d extends AnimatorListenerAdapter {
        public final /* synthetic */ b a;

        public d(b r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            ((BaseRotationAdapter) this.a).l.setVisibility(8);
            com.bytedance.android.ec.core.utils.rotation.e.h(((BaseRotationAdapter) this.a).l);
            b r4 = this.a;
            r4.o = true;
            r4.k(true);
            if ((true ^ ((com.bytedance.android.ec.core.utils.rotation.e) r4).a.isEmpty()) == false) goto L6;
            ((com.bytedance.android.ec.core.utils.rotation.e) r4).b = 0;
            r4.j();
            return;
        }
    }

    static {
    }

    public final long e() {
        if (((com.bytedance.android.ec.core.utils.rotation.e) this).a.size() <= 1) goto L5;
        return KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION;
    L5:
        return 5000;
    }

    public final void g() {
        ViewGroup r0 = ((BaseRotationAdapter) this).l;
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r1.setDuration(400);
        r1.addUpdateListener(new e(r0));
        r1.addListener(new d(this));
        if (this.p == true) goto L5;
        ValueAnimator r2 = r1;
    L6:
        if (r2 == null) goto L8;
        r1.start();
    L8:
        Unit r3 = Unit.INSTANCE;
        this.n = r1;
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void j() {
        ((BaseRotationAdapter) this).l.setVisibility(0);
        this.o = false;
        super/*com.bytedance.android.ec.core.utils.rotation.e*/.j();
    }

    public final void a() {
        super/*com.bytedance.android.ec.core.utils.rotation.e*/.a();
        Animator r0 = this.n;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    public final Animator b(View r5) {
        Intrinsics.checkNotNullParameter(r5, "layout");
        ECLiveDegradeHelper.c.getClass();
        int r0 = ECLiveDegradeHelper.a("promotion_list_interaction_msg_degrade", ECLiveDegradeHelper.b().getEnablePromotionListInteractionMsgDegrade());
        if (r0 != 3) goto L5;
        long r1 = 0;
    L6:
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r3.setDuration(r1);
        r3.addUpdateListener(new com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.c(this, r5, r0));
        return r3;
    L5:
        r1 = 400;
        goto L6
    }

    public final Animator c(View r5) {
        Intrinsics.checkNotNullParameter(r5, "layout");
        ECLiveDegradeHelper.c.getClass();
        int r0 = ECLiveDegradeHelper.a("promotion_list_interaction_msg_degrade", ECLiveDegradeHelper.b().getEnablePromotionListInteractionMsgDegrade());
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (r0 != 3) goto L5;
        long r2 = 0;
    L6:
        r1.setDuration(r2);
        r1.addUpdateListener(new com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.d(this, r0, r5));
        return r1;
    L5:
        r2 = 400;
        goto L6
    }

    public final int d(int r6) {
        if (r6 >= 0) goto L4;
    L6:
        com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a r0 = null;
    L7:
        int r3 = 0;
        if (((com.bytedance.android.ec.core.utils.rotation.e) this).a.isEmpty() == false) goto L10;
        int r7 = 0;
    L12:
        if ((!((ArrayList) this.q).isEmpty()) == false) goto L14;
        k(true);
    L19:
        r7 = 0;
    L21:
        if (r7 >= 0) goto L23;
    L40:
        return -1;
    L23:
        if (((com.bytedance.android.ec.core.utils.rotation.e) this).a.isEmpty() == true) goto L40;
        if (((BaseRotationAdapter) this).l.getVisibility() != 0) goto L27;
        boolean r4 = true;
    L28:
        if (r4 == false) goto L40;
        if (this.p == true) goto L40;
    L33:
        if (Intrinsics.areEqual((com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) ListProtector.get(((com.bytedance.android.ec.core.utils.rotation.e) this).a, r7), r0) == false) goto L39;
        r3 = r3 + 1;
        if (r3 >= ((com.bytedance.android.ec.core.utils.rotation.e) this).a.size()) goto L36;
        r7 = (r7 + 1) % ((com.bytedance.android.ec.core.utils.rotation.e) this).a.size();
        goto L33
    L36:
        ArrayList r8 = new ArrayList();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        ((com.bytedance.android.ec.core.utils.rotation.e) this).a = r8;
        return -1;
    L39:
        return r7;
    L27:
        r4 = false;
        goto L28
    L14:
        if (r7 != 0) goto L16;
        boolean r1 = true;
    L17:
        k(r1);
        if (r7 < ((com.bytedance.android.ec.core.utils.rotation.e) this).a.size()) goto L21;
    L16:
        r1 = false;
        goto L17
    L10:
        r7 = (r6 + 1) % ((com.bytedance.android.ec.core.utils.rotation.e) this).a.size();
        goto L12
    L4:
        if (r6 >= ((com.bytedance.android.ec.core.utils.rotation.e) this).a.size()) goto L6;
        r0 = (com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) ListProtector.get(((com.bytedance.android.ec.core.utils.rotation.e) this).a, r6);
        goto L7
    }

    public final void k(boolean r8) {
        if (this.r == false) goto L18;
        Iterator r9 = ((ArrayList) this.q).iterator();
    L6:
        if (r9.hasNext() == false) goto L17;
        com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a r0 = (com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) r9.next();
        Iterator r3 = ((com.bytedance.android.ec.core.utils.rotation.e) this).a.iterator();
    L9:
        if (r3.hasNext() == false) goto L13;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(((com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) r4).a, r0.a) == false) goto L9;
    L14:
        com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a r5 = (com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) r4;
        if (r5 == null) goto L6;
        r0.b = r5.b;
        goto L6
    L13:
        r4 = null;
        goto L14
    L17:
        ArrayList r10 = new ArrayList();
        r10.addAll(this.q);
        Unit r1 = Unit.INSTANCE;
        List r11 = CollectionsKt.sortedWith(r10, new C0092b());
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        ((com.bytedance.android.ec.core.utils.rotation.e) this).a = r11;
        this.r = false;
        ((ArrayList) this.q).clear();
        return;
    L18:
        if (r8 == false) goto L46;
        ArrayList r12 = new ArrayList();
        r12.addAll(this.q);
        r12.addAll(((com.bytedance.android.ec.core.utils.rotation.e) this).a);
        Unit r2 = Unit.INSTANCE;
        ArrayList r6 = new ArrayList();
        Iterator r13 = r12.iterator();
    L21:
        if (r13.hasNext() == false) goto L30;
        Object r7 = r13.next();
        com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a r14 = (com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) r7;
        int r15 = r14.b;
        int r16 = r14.a.getLoopCount();
        if (r16 > 0) goto L25;
        r16 = 3;
    L25:
        if (r15 >= r16) goto L27;
        boolean r17 = true;
    L28:
        if (r17 == false) goto L21;
        r6.add(r7);
        goto L21
    L27:
        r17 = false;
        goto L28
    L30:
        List r18 = CollectionsKt.sortedWith(r6, new c());
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        ((com.bytedance.android.ec.core.utils.rotation.e) this).a = r18;
        ((ArrayList) this.q).clear();
        return;
    }

    public final void i(int r24, Object r25) {
        final com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a r1 = (com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.a) r25;
        Intrinsics.checkNotNullParameter(r1, "data");
        r1.b++;
        if (r24 != 0) goto L5;
        final View r3 = (View) ((BaseRotationAdapter) this).j.getValue();
    L6:
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r1, "data");
        View r6 = r3.findViewById(2131389173);
        List r7 = r1.a.getRows();
        int r8 = 0;
        if (r7 != null) goto L9;
    L12:
        boolean r9 = true;
    L14:
        if (r9 == false) goto L16;
        r6.setVisibility(8);
        return;
    L16:
        r6.setVisibility(0);
        List r10 = r1.a.getRows();
        if (r10 == null) goto L19;
        int r11 = r10.size();
    L20:
        GradientDrawable r12 = new GradientDrawable();
        r12.setShape(0);
        List r13 = r1.a.getBgColors();
        if (r13 == null) goto L37;
        ArrayList r14 = new ArrayList(3);
        Iterator r15 = r13.iterator();     // Catch: Exception -> L28
    L25:
        if (r15.hasNext() == false) goto L29;
        r14.add(Integer.valueOf(Color.parseColor((String) r15.next())));     // Catch: Exception -> L28
    L29:
        int[] r16 = CollectionsKt.toIntArray(r14);
        if (r16.length <= 1) goto L33;
        r12.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        r12.setGradientType(0);
        r12.setColors(r16);
        goto L37
    L33:
        if (ArraysKt.getLastIndex(r16) < 0) goto L35;
        int r5 = r16[0];
    L36:
        r12.setColor(r5);
        goto L37
    L35:
        r5 = ColorProtector.parseColor("#A6000000");
    L28:
        r14.clear();
        r14.add(Integer.valueOf(ColorProtector.parseColor("#A6000000")));
    L37:
        ViewGroup.LayoutParams r17 = r6.getLayoutParams();
        if (r17 == null) goto L121;
        ViewGroup.LayoutParams r18 = (ConstraintLayout.LayoutParams) r17;
        ((ConstraintLayout.LayoutParams) r18).matchConstraintPercentWidth = this.m;
        r6.setLayoutParams(r18);
        if (r11 <= 1) goto L47;
        r12.setCornerRadius(UtilityKotlinExtentionsKt.c(8));
        r6.setPadding(UtilityKotlinExtentionsKt.d(2), UtilityKotlinExtentionsKt.d(2), UtilityKotlinExtentionsKt.d(6), UtilityKotlinExtentionsKt.d(2));
        View r2 = r6.findViewById(2131389170);
        r2.getLayoutParams().width = UtilityKotlinExtentionsKt.d(Double.valueOf(15.6d));
        r2.getLayoutParams().height = UtilityKotlinExtentionsKt.d(Double.valueOf(13.2d));
        View r4 = r6.findViewById(2131389171);
        ViewGroup.LayoutParams r19 = r4.getLayoutParams();
        if ((r19 instanceof ViewGroup.MarginLayoutParams) == true) goto L44;
        r19 = null;
    L44:
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r19;
        if (r110 == null) goto L53;
        r110.rightMargin = UtilityKotlinExtentionsKt.d(6);
        r4.setLayoutParams(r110);
    L53:
        r6.setBackground(r12);
        com.bytedance.android.ec.model.live.n r20 = r1.a.getProduct();
        if (r20 == null) goto L80;
        ECDraweeView r111 = r6.findViewById(2131389169);
        ViewGroup.LayoutParams r21 = r111.getLayoutParams();
        if (r21 == null) goto L66;
        ECUrlModel r112 = r20.a();
        if (r112 == null) goto L60;
        int r113 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r112.getWidth()));
    L61:
        r21.width = r113;
        ECUrlModel r114 = r20.a();
        if (r114 == null) goto L64;
        int r115 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r114.getHeight()));
    L65:
        r21.height = r115;
        goto L66
    L64:
        r115 = 0;
        goto L65
    L60:
        r113 = 0;
    L66:
        ECUrlModel r22 = r20.a();
        if (r22 == null) goto L69;
        List r116 = r22.getUrlList();
    L70:
        h0.f(r111, r116, new com.bytedance.android.ec.core.imagex.r("ec_live", "promotion_list_top_vibe"), null, null, 120);
        if (r20.c() == false) goto L79;
        r6.findViewById(2131389170).setVisibility(0);
        TextView r23 = (TextView) r6.findViewById(2131389174);
        String r26 = String.valueOf(r20.b());
        r23.setText(r26);
        if (r26.length() <= 1) goto L78;
        if (r11 <= 1) goto L76;
        float r27 = 7.0f;
    L77:
        r23.setTextSize(1, r27);
        goto L80
    L76:
        r27 = 5.0f;
        goto L77
    L78:
        r23.setTextSize(1, 9.0f);
        goto L80
    L79:
        r6.findViewById(2131389170).setVisibility(8);
        goto L80
    L69:
        r116 = null;
    L80:
        View r28 = (View) CollectionsKt.getOrNull(com.bytedance.commerce.base.view.b.a(r6), 0);
        if (r28 == null) goto L83;
        r6.measure(View.MeasureSpec.makeMeasureSpec(((BaseRotationAdapter) this).l.getWidth(), 1073741824), 0);
        r28.measure(0, 0);
        float r29 = ((((r6.getMeasuredWidth() * this.m) - UtilityKotlinExtentionsKt.c(Integer.valueOf(r6.getPaddingLeft()))) - UtilityKotlinExtentionsKt.c(Integer.valueOf(r6.getPaddingRight()))) - r28.getMeasuredWidth()) - o0.b(r28);
    L84:
        List r30 = com.bytedance.commerce.base.view.b.a(r6.findViewById(2131389172));
        List r117 = r1.a.getRows();
        if (r117 == null) goto L108;
        Iterator r118 = r117.iterator();
        int r119 = 0;
    L88:
        if (r118.hasNext() == false) goto L108;
        Object r120 = r118.next();
        int r121 = r119 + 1;
        if (r119 >= 0) goto L92;
        CollectionsKt.throwIndexOverflow();
    L92:
        List<com.bytedance.android.ec.model.live.b> r122 = ((com.bytedance.android.ec.model.live.o) r120).a();
        if (r122 == null) goto L106;
        View r123 = (View) CollectionsKt.getOrNull(r30, r119);
        if (r123 == null) goto L100;
        r123.setVisibility(0);
        if (r29 <= 0.0f) goto L99;
        ((ECCustomizedElementView) r123).d(r122, (int) r29);
        goto L106
    L99:
        int r124 = ECCustomizedElementView.k;
        ((ECCustomizedElementView) r123).b(r122, false);
        goto L106
    L100:
        ECCustomizedElementView r125 = new ECCustomizedElementView(r6.getContext(), null, 6, r8);
        if (r29 <= 0) goto L103;
        r125.d(r122, (int) r29);
    L104:
        ((LinearLayout) r6.findViewById(2131389172)).addView(r125);
        Unit r126 = Unit.INSTANCE;
        goto L106
    L103:
        r125.b(r122, false);
    L106:
        r119 = r121;
    L108:
        if (r30.size() <= r11) goto L115;
        int r31 = r30.size();
    L110:
        if (r11 >= r31) goto L115;
        View r32 = (View) CollectionsKt.getOrNull(r30, r11);
        if (r32 == null) goto L114;
        r32.setVisibility(8);
    L114:
        r11 = r11 + 1;
    L115:
        final Map r33 = r1.a.getTrackParams();
        if (this.u == false) goto L118;
        oh.a.c("livesdk_show_shop_popup", new f(this, r33));
    L118:
        r3.findViewById(2131389173).setOnClickListener(new InteractionRotationAdapter$onBindView$clickListener$1(this, r33, r3, r1));
        return;
    L83:
        r29 = -1.0f;
        goto L84
    L47:
        r12.setCornerRadius(UtilityKotlinExtentionsKt.c(27));
        r6.setPadding(UtilityKotlinExtentionsKt.d(6), UtilityKotlinExtentionsKt.d(4), UtilityKotlinExtentionsKt.d(6), UtilityKotlinExtentionsKt.d(4));
        View r34 = r6.findViewById(2131389170);
        r34.getLayoutParams().width = UtilityKotlinExtentionsKt.d(Double.valueOf(11.5d));
        r34.getLayoutParams().height = UtilityKotlinExtentionsKt.d(Double.valueOf(9.6d));
        View r35 = r6.findViewById(2131389171);
        ViewGroup.LayoutParams r36 = r35.getLayoutParams();
        if ((r36 instanceof ViewGroup.MarginLayoutParams) == true) goto L50;
        r36 = null;
    L50:
        ViewGroup.MarginLayoutParams r37 = (ViewGroup.MarginLayoutParams) r36;
        if (r37 == null) goto L53;
        r37.rightMargin = UtilityKotlinExtentionsKt.d(4);
        r35.setLayoutParams(r37);
        goto L53
    L121:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L19:
        r11 = 0;
        goto L20
    L9:
        if (r7.isEmpty() == true) goto L12;
        r9 = false;
        goto L14
    L5:
        r3 = (View) ((BaseRotationAdapter) this).k.getValue();
        goto L6
    }

    public b(FrameLayout r2, gi2.a r3, RoomContextController r4) {
        Intrinsics.checkNotNullParameter(r2, "rootLayout");
        super(r2);
        this.t = r3;
        this.u = true;
        this.v = r4;
        ((com.bytedance.android.ec.core.utils.rotation.e) this).b = 1000;
        ((com.bytedance.android.ec.core.utils.rotation.e) this).c = KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION;
        ((com.bytedance.android.ec.core.utils.rotation.e) this).d = false;
        this.m = 0.64f;
        this.q = new ArrayList();
        this.s = true;
    }
}
