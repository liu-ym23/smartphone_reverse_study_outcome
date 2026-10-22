package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedTypewriterTextView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003\n\u000b\fB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedAiContainerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DeepFeedAiAdapter", "DeepFeedAiHeaderViewHolder", "DeepFeedAiViewHolder", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedAiContainerView extends ConstraintLayout {
    public final String a;
    public final String b;
    public final RecyclerView c;
    public final DeepFeedAiAdapter d;
    public final DeepFeedTypewriterTextView e;
    public final ImageView f;
    public final ViewGroup g;
    public final LottieAnimationView h;
    public final Set<String> i;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedAiContainerView$DeepFeedAiAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DeepFeedAiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public final int a;

        public final int getItemCount() {
            return 0;
        }

        public DeepFeedAiAdapter() {
            this.a = 2;
        }

        public final int getItemViewType(int r1) {
            return this.a;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "holder");
            if ((r3 - 1) >= 0) goto L5;
            return;
        L5:
            if ((r2 instanceof DeepFeedAiViewHolder) == true) goto L7;
            r2 = null;
        L7:
            DeepFeedAiViewHolder r4 = (DeepFeedAiViewHolder) r2;
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            if (r4 == 1) goto L5;
            View r5 = th.a.c(r3.getContext(), 2131564626, r3, false);
            r5.setBackgroundResource(2131247976);
            return new DeepFeedAiViewHolder(r5);
        L5:
            return new DeepFeedAiHeaderViewHolder(th.a.c(r3.getContext(), 2131564625, r3, false));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedAiContainerView$DeepFeedAiHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DeepFeedAiHeaderViewHolder extends RecyclerView.ViewHolder {
        public DeepFeedAiHeaderViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedAiContainerView$DeepFeedAiViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DeepFeedAiViewHolder extends RecyclerView.ViewHolder {
        public final AppCompatTextView a;

        public DeepFeedAiViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
            super(r2);
            this.a = r2.findViewById(2131368665);
        }
    }

    public DeepFeedAiContainerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepFeedAiContainerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void R5() {
        Iterator<T> r0 = this.i.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((String) r0.next()).length() <= 0) goto L4;
        goto L4
    L9:
        this.i.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeepFeedAiContainerView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.a = "正在努力为你寻找 ";
        this.b = " ...";
        this.d = new DeepFeedAiAdapter();
        int r8 = com.bytedance.android.ec.base.settings.a.a;
        Object r9 = Boolean.TRUE;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L166
        Object r1 = null;
        Object r2 = com.bytedance.android.ec.base.settings.d.c.get("mall_deep_feed_ai_event_fix");     // Catch: Throwable -> L57
        if (r2 != null) goto L9;
    L54:
        Object r3 = null;
    L55:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L57
    L59:
        Throwable r10 = Result.exceptionOrNull-impl(r4);     // Catch: Throwable -> L166
        if (r10 == null) goto L63;
        EnsureManager.ensureNotReachHere(r10);     // Catch: Throwable -> L166
    L63:
        if (Result.isFailure-impl(r4) == false) goto L66;
        r4 = null;
    L66:
        if ((r4 instanceof Boolean) == true) goto L68;
        r4 = null;
    L68:
        Object r11 = (Boolean) r4;     // Catch: Throwable -> L166
        if (r11 != null) goto L75;
        Object r12 = com.bytedance.android.ec.base.settings.d.a.get("mall_deep_feed_ai_event_fix");     // Catch: Throwable -> L166
        if ((r12 instanceof Boolean) == true) goto L74;
        r12 = null;
    L74:
        r11 = (Boolean) r12;     // Catch: Throwable -> L166
    L75:
        if (r11 != null) goto L175;
        int r13 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r14 = com.bytedance.android.ec.base.settings.d.c.get("mall_deep_feed_ai_event_fix");     // Catch: Throwable -> L130
        if (r14 != null) goto L82;
    L127:
        Object r15 = null;
    L128:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L130
    L132:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L156
        if (r17 == null) goto L136;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r16) == false) goto L139;
        r16 = null;
    L139:
        if ((r16 instanceof Boolean) == true) goto L141;
        r16 = null;
    L141:
        r11 = (Boolean) r16;     // Catch: Throwable -> L156
        if (r11 != null) goto L164;
        IHybridHostService r18 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r18 == null) goto L147;
        Object r19 = r18.getHostABValue("mall_deep_feed_ai_event_fix", r9);     // Catch: Throwable -> L156
    L148:
        if (r19 != null) goto L150;
    L155:
        r11 = r9;
        goto L164
    L150:
        if ((r19 instanceof Boolean) == false) goto L153;
        r1 = r19;
    L153:
        Object r20 = (Boolean) r1;     // Catch: Throwable -> L156
        if (r20 == null) goto L155;
    L163:
        r11 = r20;
        goto L164
    L147:
        r19 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("mall_deep_feed_ai_event_fix", r11);     // Catch: Throwable -> L166
        goto L175
    L82:
        if ((r14 instanceof Boolean) == true) goto L84;
        Object r21 = null;
    L85:
        r15 = (Boolean) r21;     // Catch: Throwable -> L130
        if (r15 != null) goto L128;
        if ((r14 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L130
        if ((r22 instanceof Boolean) == true) goto L95;
        r22 = null;
    L95:
        r15 = (Boolean) r22;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L130
        if ((r23 instanceof Boolean) == true) goto L101;
        r23 = null;
    L101:
        r15 = (Boolean) r23;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r24 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L130
        if ((r24 instanceof Boolean) == true) goto L107;
        r24 = null;
    L107:
        r15 = (Boolean) r24;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r25 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L130
        if ((r25 instanceof Boolean) == true) goto L113;
        r25 = null;
    L113:
        r15 = (Boolean) r25;     // Catch: Throwable -> L130
    L115:
        if ((r14 instanceof JSONObject) == false) goto L117;
    L183:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r26 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r26 instanceof Boolean) == true) goto L121;
        r26 = null;
    L121:
        Object r27 = Result.constructor-impl((Boolean) r26);     // Catch: Throwable -> L123
    L125:
        r15 = r27;
        if (Result.isFailure-impl(r15) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L130
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r14 instanceof JSONArray) == false) goto L127;
    L84:
        r21 = r14;
    L156:
        th = move-exception;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L166
        r20 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r30 = Result.exceptionOrNull-impl(r20);     // Catch: Throwable -> L166
        if (r30 == null) goto L161;
        EnsureManager.ensureNotReachHere(r30);     // Catch: Throwable -> L166
    L161:
        if (Result.isFailure-impl(r20) == false) goto L163;
        r20 = r9;
    L130:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L156
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L175:
        boolean r32 = ((Boolean) r11).booleanValue();
        ViewGroup.inflate(r5, 2131564652, this);
        RecyclerView r33 = findViewById(2131368669);
        this.c = r33;
        this.e = (DeepFeedTypewriterTextView) findViewById(2131368672);
        this.f = (ImageView) findViewById(2131368662);
        this.g = (ViewGroup) findViewById(2131368671);
        LottieAnimationView r34 = findViewById(2131368670);
        this.h = r34;
        int r35 = ed3.a.a;
        Intrinsics.checkNotNullParameter(r34, "lottieView");
        r34.setAnimation("deep_feed_ai_under_lottie_bg.json");
        r33.setAdapter(this.d);
        r33.setLayoutManager(new LinearLayoutManager(r5, 0, false));
        boolean r36 = ECServiceManager.a;
        if (((IECHostService) ECServiceManager.c(IECHostService.class)).getRecommendStatus() == true) goto L178;
        r33.setPadding(com.bytedance.android.shopping.extensions.b.b(8), 0, com.bytedance.android.shopping.extensions.b.b(12), 0);
    L178:
        if (r32 == false) goto L181;
        r33.addOnChildAttachStateChangeListener(new DeepFeedAiContainerView$onShowReport$1(this));
    L181:
        this.i = new LinkedHashSet();
        return;
    L9:
        if ((r2 instanceof Boolean) == true) goto L11;
        Object r37 = null;
    L12:
        r3 = (Boolean) r37;     // Catch: Throwable -> L57
        if (r3 != null) goto L55;
        if ((r2 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r38 = Float.valueOf(((Number) r2).floatValue());     // Catch: Throwable -> L57
        if ((r38 instanceof Boolean) == true) goto L22;
        r38 = null;
    L22:
        r3 = (Boolean) r38;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r39 = Double.valueOf(((Number) r2).doubleValue());     // Catch: Throwable -> L57
        if ((r39 instanceof Boolean) == true) goto L28;
        r39 = null;
    L28:
        r3 = (Boolean) r39;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r40 = Integer.valueOf(((Number) r2).intValue());     // Catch: Throwable -> L57
        if ((r40 instanceof Boolean) == true) goto L34;
        r40 = null;
    L34:
        r3 = (Boolean) r40;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r41 = Long.valueOf(((Number) r2).longValue());     // Catch: Throwable -> L57
        if ((r41 instanceof Boolean) == true) goto L40;
        r41 = null;
    L40:
        r3 = (Boolean) r41;     // Catch: Throwable -> L57
    L42:
        if ((r2 instanceof JSONObject) == false) goto L44;
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r42 = SDKSettingsCacheManager.a().fromJson(r2.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r42 instanceof Boolean) == true) goto L48;
        r42 = null;
    L48:
        Object r43 = Result.constructor-impl((Boolean) r42);     // Catch: Throwable -> L50
    L52:
        r3 = r43;
        if (Result.isFailure-impl(r3) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L57
        r43 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r2 instanceof JSONArray) == false) goto L54;
    L11:
        r37 = r2;
    L57:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L166
        r4 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        Object r47 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r48 = Result.exceptionOrNull-impl(r47);
        if (r48 == null) goto L171;
        EnsureManager.ensureNotReachHere(r48);
    L171:
        if (Result.isFailure-impl(r47) == true) goto L174;
        r9 = r47;
    L174:
        r11 = r9;
        goto L175
    }

    public /* synthetic */ DeepFeedAiContainerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
