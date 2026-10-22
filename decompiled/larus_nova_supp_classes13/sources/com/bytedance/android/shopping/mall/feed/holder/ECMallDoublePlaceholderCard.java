package com.bytedance.android.shopping.mall.feed.holder;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.tools.TransitionAnimationHelper;
import com.bytedance.android.ec.hybrid.ui.ECMediaType;
import com.bytedance.android.shopping.api.mall.IECMallDeliveryService;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.api.mall.common.tools.k;
import com.bytedance.android.shopping.api.mall.homepage.ECMallDeliveryReduceConfig;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import yj.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/holder/ECMallDoublePlaceholderCard;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", "a", "b", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallDoublePlaceholderCard extends BaseViewHolder {
    public static final /* synthetic */ int r = 0;
    public final SimpleDraweeView o;
    public final SimpleDraweeView p;
    public Runnable q;

    public static final class a extends BaseControllerListener<ImageInfo> {
        public final Function0<Unit> a;

        public a(Function0<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "action");
            this.a = r2;
        }

        public final void onFailure(String r1, Throwable r2) {
            super.onFailure(r1, r2);
            this.a.invoke();
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            super.onFinalImageSet(r1, (ImageInfo) r2, r3);
            this.a.invoke();
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ECMallDoublePlaceholderCard a;

        public c(ECMallDoublePlaceholderCard r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Runnable r0 = this.a.q;     // Catch: Throwable -> L7
            if (r0 == null) goto L5;
            r0.run();     // Catch: Throwable -> L7
        L5:
            this.a.q = null;     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ boolean a;

        public d(boolean r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ServiceManager r0 = ServiceManager.get();     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            IECMallDeliveryService r1 = (IECMallDeliveryService) r0.getService(IECMallDeliveryService.class);     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            r1.notifyDeliveryEventBlockEnd(this.a);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ ECMallDoublePlaceholderCard a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ boolean c;

        public e(ECMallDoublePlaceholderCard r1, Object r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            String r7 = ((ECMallPlaceholderCardVO) this.b).getSchema();
            if (r7 != null) goto L5;
        L8:
            boolean r1 = true;
        L10:
            if ((!r1) == true) goto L13;
            r7 = null;
        L13:
            if (r7 != null) goto L15;
            return;
        L15:
            Uri r8 = UriProtector.parse(r7);
            SimpleDraweeView r2 = this.a.o;
            int r3 = View.generateViewId();
            r2.setId(r3);
            String r9 = r8.buildUpon().appendQueryParameter("share_element_view_id", String.valueOf(r3)).build().toString();
            IHybridHostService r4 = com.bytedance.android.ec.hybrid.a.h();
            if (r4 == null) goto L21;
            t r5 = r4.getHybridLynxHostService();
            if (r5 == null) goto L21;
            if (r5.isOptProductCardTransition() != true) goto L21;
        L22:
            k.b.d(((RecyclerView.ViewHolder) this.a).itemView.getContext(), r9, null);
            Lazy r10 = TransitionAnimationHelper.a;
            TransitionAnimationHelper.b(ECMediaType.PRODUCT.getType(), this.c);
            return;
        L21:
            TransitionAnimationHelper.d(r2, "product");
            goto L22
        L5:
            if (r7.length() == 0) goto L8;
            r1 = false;
            goto L10
        }
    }

    static {
    }

    public final boolean C3() {
        return false;
    }

    public ECMallDoublePlaceholderCard(View r6) {
        Intrinsics.checkNotNullParameter(r6, "itemView");
        super(r6);
        SimpleDraweeView r0 = new SimpleDraweeView(r6.getContext());
        r0.setTag(2131389328, new Object());
        Unit r1 = Unit.INSTANCE;
        this.o = r0;
        View r2 = new SimpleDraweeView(r6.getContext());
        this.p = r2;
        ViewGroup r7 = (ViewGroup) r6;
        r7.addView(r0, new ViewGroup.LayoutParams(-1, -2));
        r7.addView(r2, new ViewGroup.LayoutParams(-1, -2));
    }

    public final void q4(final String r7, ECMallDeliveryReduceConfig r8) {
        final Ref.LongRef r0 = new Ref.LongRef();
        r0.element = -1;
        boolean r1 = true;
        final Integer r3 = null;
        if (r8 == null) goto L10;
        final Integer r4 = Integer.valueOf(r8.getTargetDuration());
        if (r4.intValue() <= 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L10;
    L11:
        if (r8 == null) goto L18;
        Integer r9 = Integer.valueOf(r8.getMaxDelayJumpDuration());
        if (r9.intValue() > 0) goto L16;
        r1 = false;
    L16:
        if (r1 == false) goto L18;
        r3 = r9;
    L18:
        if (r7 == null) goto L22;
        if (r4 == null) goto L22;
        if (r3 == null) goto L22;
        kk.d.c(new ECMallDoublePlaceholderCard$executeDeliveryRunnable$1(r7, r0, r4, r3));
    L22:
        c r10 = new c(this);
        if (r0.element <= 0) goto L25;
        t93.a.b().postDelayed(r10, r0.element);
        return;
    L25:
        r10.run();
        return;
    L7:
        r5 = false;
    L10:
        r4 = null;
        goto L11
    }

    public final void b4(Object r10, String r11, com.bytedance.android.ec.hybrid.list.entity.k.a r12) {
        Intrinsics.checkNotNullParameter(r11, "itemId");
        super.b4(r10, r11, r12);
        if ((r10 instanceof ECMallPlaceholderCardVO) == true) goto L5;
        return;
    L5:
        ECMallPlaceholderCardVO r13 = (ECMallPlaceholderCardVO) r10;
        if (r13.getBackgroundUrlPair() == null) goto L8;
    L10:
        ECMallDeliveryReduceConfig r14 = r13.getReduceConfig();
        String r0 = null;
        if (r14 == null) goto L13;
        Double r15 = Double.valueOf(r14.getCardRadius());
    L14:
        if (r15 == null) goto L16;
        float r16 = b0.c(r15);
        this.o.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(r16, r16, 0.0f, 0.0f));
        this.p.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(0.0f, 0.0f, r16, r16));
    L17:
        ECMallDeliveryReduceConfig r17 = r13.getReduceConfig();
        boolean r1 = false;
        if (r17 != null) goto L20;
    L22:
        boolean r18 = false;
    L24:
        if (r13.getShouldNotifyDelivery() == false) goto L26;
        d r3 = new d(r18);
    L27:
        this.q = r3;
        ECMallDeliveryReduceConfig r4 = r13.getReduceConfig();
        if (r4 != null) goto L30;
    L32:
        a r5 = null;
    L33:
        String r6 = r13.getCover();
        if (r6 != null) goto L36;
    L39:
        boolean r7 = true;
    L40:
        int r8 = -1;
        if (r7 == true) goto L52;
        Pair<Float, Float> r9 = r13.getBackgroundUrlRatioPair();
        if (r9 == null) goto L47;
        Float r19 = (Float) r9.getFirst();
        if (r19 == null) goto L47;
        this.o.setAspectRatio(r19.floatValue());
    L47:
        SimpleDraweeView r20 = this.o;
        String r21 = r13.getCover();
        Intrinsics.checkNotNull(r21);
        if (d0.a(r20, r5, r21, "ec_na_mall", "ec_na_mall_product_cover") == true) goto L81;
        if (r5 == null) goto L51;
        this.o.setController(Fresco.newDraweeControllerBuilder().setControllerListener(r5).build());
    L51:
        this.o.setImageURI(r13.getCover());
    L81:
        Pair<String, String> r22 = r13.getBackgroundUrlPair();
        if (r22 == null) goto L84;
        r0 = (String) r22.getSecond();
    L84:
        if (r0 != null) goto L86;
    L87:
        r1 = true;
    L88:
        if (r1 == true) goto L95;
        Pair<Float, Float> r2 = r13.getBackgroundUrlRatioPair();
        if (r2 == null) goto L94;
        Float r23 = (Float) r2.getSecond();
        if (r23 == null) goto L94;
        this.p.setAspectRatio(r23.floatValue());
    L94:
        SimpleDraweeView r24 = this.p;
        Pair<String, String> r25 = r13.getBackgroundUrlPair();
        Intrinsics.checkNotNull(r25);
        r24.setImageURI((String) r25.getSecond());
    L106:
        if (r5 != null) goto L108;
        q4(r13.getDeliverySessionId(), r13.getReduceConfig());
    L108:
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new e(this, r10, r18));
        return;
    L95:
        Pair<Float, Float> r26 = r13.getBackgroundResIdRatioPair();
        if (r26 == null) goto L100;
        Float r27 = (Float) r26.getSecond();
        if (r27 == null) goto L100;
        this.p.setAspectRatio(r27.floatValue());
    L100:
        SimpleDraweeView r28 = this.p;
        Pair<Integer, Integer> r29 = r13.getBackgroundResIdPair();
        if (r29 == null) goto L105;
        Integer r30 = (Integer) r29.getSecond();
        if (r30 == null) goto L105;
        r8 = r30.intValue();
    L105:
        r28.setImageResource(r8);
        goto L106
    L86:
        if (r0.length() != 0) goto L88;
    L52:
        Pair<String, String> r31 = r13.getBackgroundUrlPair();
        if (r31 == null) goto L55;
        String r32 = (String) r31.getFirst();
    L56:
        if (r32 != null) goto L58;
    L61:
        boolean r33 = true;
    L62:
        if (r33 == true) goto L69;
        Pair<Float, Float> r34 = r13.getBackgroundUrlRatioPair();
        if (r34 == null) goto L68;
        Float r35 = (Float) r34.getFirst();
        if (r35 == null) goto L68;
        this.o.setAspectRatio(r35.floatValue());
    L68:
        SimpleDraweeView r36 = this.o;
        Pair<String, String> r37 = r13.getBackgroundUrlPair();
        Intrinsics.checkNotNull(r37);
        r36.setImageURI((String) r37.getFirst());
        goto L81
    L69:
        Pair<Float, Float> r38 = r13.getBackgroundResIdRatioPair();
        if (r38 == null) goto L74;
        Float r39 = (Float) r38.getFirst();
        if (r39 == null) goto L74;
        this.o.setAspectRatio(r39.floatValue());
    L74:
        SimpleDraweeView r40 = this.o;
        Pair<Integer, Integer> r41 = r13.getBackgroundResIdPair();
        if (r41 == null) goto L79;
        Integer r42 = (Integer) r41.getFirst();
        if (r42 == null) goto L79;
        int r43 = r42.intValue();
    L80:
        r40.setImageResource(r43);
    L79:
        r43 = -1;
        goto L80
    L58:
        if (r32.length() == 0) goto L61;
        r33 = false;
        goto L62
    L55:
        r32 = null;
        goto L56
    L36:
        if (r6.length() == 0) goto L39;
        r7 = false;
        goto L40
    L30:
        if (r4.getJumpAfterImageLoaded() != true) goto L32;
        r5 = new a(new ECMallDoublePlaceholderCard$onBind$controllerListener$1(this, r10));
        goto L33
    L26:
        r3 = null;
        goto L27
    L20:
        if (r17.getForbidExitAnimation() != true) goto L22;
        r18 = true;
        goto L24
    L16:
        this.o.getHierarchy().setRoundingParams(null);
        this.p.getHierarchy().setRoundingParams(null);
        goto L17
    L13:
        r15 = null;
        goto L14
    L8:
        if (r13.getBackgroundResIdPair() != null) goto L10;
    }
}
