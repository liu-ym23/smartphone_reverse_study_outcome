package com.bytedance.android.shopping.mall.homepage.jsb;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallMountLottieJsb extends qf3.e {
    public final String d;
    public final ECHybridListEngine e;
    public final String f;
    public final List<String> g;
    public final List<b> h;
    public final List<b> i;
    public final ECMallMountLottieJsb$listChildListener$1 j;
    public final c k;
    public final View l;

    public static final class a {
    }

    public static final class b {
        public String a;
        public int b;
        public final LottieAnimationView c;
        public final FrameLayout.LayoutParams d;
        public final String e;
        public final String f;

        public b(LottieAnimationView r2, FrameLayout.LayoutParams r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "lottie");
            Intrinsics.checkNotNullParameter(r3, "lottieLP");
            Intrinsics.checkNotNullParameter(r4, "lottieUrl");
            Intrinsics.checkNotNullParameter(r5, "containerID");
            this.c = r2;
            this.d = r3;
            this.e = r4;
            this.f = r5;
            this.a = "";
            this.b = -1;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ECMallMountLottieJsb a;

        public c(ECMallMountLottieJsb r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r12) {
            Object r1 = null;
            if ((r12 instanceof LottieAnimationView) == true) goto L5;
            r12 = null;
        L5:
            LottieAnimationView r13 = (LottieAnimationView) r12;
            if (r13 != null) goto L8;
            return;
        L8:
            Iterator r0 = ((ArrayList) this.a.h).iterator();
        L10:
            if (r0.hasNext() == false) goto L14;
            Object r2 = r0.next();
            if (Intrinsics.areEqual(((b) r2).c, r13) == false) goto L10;
            r1 = r2;
        L14:
            b r3 = (b) r1;
            if (r3 != null) goto L17;
            return;
        L17:
            ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.lottieClicked", System.currentTimeMillis(), this.a.f, false, MapsKt.mapOf(new Pair[]{TuplesKt.to("container_id", r3.f), TuplesKt.to("click_id", r3.a)}), false, 32));
        }
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [com.bytedance.android.shopping.mall.homepage.jsb.ECMallMountLottieJsb$listChildListener$1] */
    public ECMallMountLottieJsb(qf3.d r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "mallJsbContext");
        super(r3);
        this.l = r4;
        this.d = "ec.lottieMount";
        ECMallFeed r5 = r3.b;
        this.e = r5.J;
        this.f = r5.B();
        this.g = CollectionsKt.listOf(new String[]{"margin_left", "margin_top", "margin_right", "margin_bottom"});
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ECMallMountLottieJsb$listChildListener$1(this);
        this.k = new c(this);
    }

    public static b g(List r2, String r3) {
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r0 = r4.next();
        if (Intrinsics.areEqual(((b) r0).f, r3) == false) goto L4;
    L10:
        return (b) r0;
    L8:
        r0 = null;
        goto L10
    }

    public static void h(List r2, b r3) {
        ViewParent r0 = r3.c.getParent();
        if (r0 != null) goto L5;
    L7:
        ((ArrayList) r2).remove(r3);
        return;
    L5:
        if ((r0 instanceof ViewGroup) == false) goto L7;
        ((ViewGroup) r0).removeView(r3.c);
        goto L7
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r24, IBDXBridgeContext r25, Map<String, ? extends Object> r26, Map<String, Object> r27) {
        Intrinsics.checkNotNullParameter(r24, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r25, "bridgeContext");
        Intrinsics.checkNotNullParameter(r26, "params");
        Intrinsics.checkNotNullParameter(r27, "result");
        Object r4 = b0.d(r26, "func_type", "");
        if (Intrinsics.areEqual(r4, "show") == false) goto L130;
        Context r1 = r24.a;
        Object r5 = b0.d(r26, "type", "absolute");
        Integer r6 = 0;
        int r12 = b0.g(r26, "width", 0);
        String r15 = "context";
        if (r12 <= 0) goto L7;
        Intrinsics.checkNotNullParameter(r1, "context");
        Resources r8 = r1.getResources();
        int r7 = (int) TypedValue.applyDimension(1, r12, WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()));
    L8:
        int r9 = b0.g(r26, "height", 0);
        if (r9 <= 0) goto L11;
        Intrinsics.checkNotNullParameter(r1, "context");
        Resources r13 = r1.getResources();
        int r10 = (int) TypedValue.applyDimension(1, r9, WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics()));
    L12:
        String r14 = b0.h(r26, "gravity", "");
        switch(r14.hashCode()) {
            case -1568783182: goto L25;
            case -1514196637: goto L22;
            case 1699249582: goto L19;
            case 1718760733: goto L16;
            default: goto L27;
        };
    L27:
        int r16 = 17;
    L28:
        List r17 = CollectionsKt.mutableListOf(new Integer[]{r6, r6, r6, r6});
        Iterator r18 = this.g.iterator();
        int r11 = 0;
    L30:
        if (r18.hasNext() == false) goto L35;
        Object r19 = r18.next();
        int r20 = r11 + 1;
        if (r11 >= 0) goto L34;
        CollectionsKt.throwIndexOverflow();
    L34:
        Iterator r21 = r18;
        String r110 = (String) r19;
        Integer r111 = r6;
        float r22 = b0.g(r26, r110, 0);
        Intrinsics.checkNotNullParameter(r1, r15);
        Resources r112 = r1.getResources();
        ListProtector.set(r17, r11, Integer.valueOf((int) TypedValue.applyDimension(1, r22, WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics()))));
        r6 = r111;
        r11 = r20;
        r18 = r21;
        r15 = r15;
        goto L30
    L35:
        Integer r113 = r6;
        LottieAnimationView r23 = new LottieAnimationView(r1);
        r23.setRepeatMode(1);
        int r2 = -1;
        r23.setRepeatCount(-1);
        FrameLayout.LayoutParams r28 = new FrameLayout.LayoutParams(r7, r10);
        r28.gravity = r16;
        r28.setMargins(((Number) ListProtector.get(r17, 0)).intValue(), ((Number) ListProtector.get(r17, 1)).intValue(), ((Number) ListProtector.get(r17, 2)).intValue(), ((Number) ListProtector.get(r17, 3)).intValue());
        Unit r29 = Unit.INSTANCE;
        Object r30 = r26.get("url");
        if ((r30 instanceof String) == true) goto L38;
        r30 = null;
    L38:
        String r31 = (String) r30;
        if (r31 != null) goto L41;
        r31 = "";
    L41:
        b r114 = new b(r23, r28, r31, String.valueOf(r23.hashCode()));
        r27.put("container_id", r114.f);
        if (Intrinsics.areEqual(r5, "absolute") == false) goto L74;
        View r3 = this.l;
        if ((r3 instanceof FrameLayout) == false) goto L46;
        FrameLayout r32 = (FrameLayout) r3;
    L63:
        if (r32 == null) goto L101;
        Object r33 = r26.get("click_id");
        if ((r33 instanceof String) == true) goto L68;
        r33 = null;
    L68:
        String r34 = (String) r33;
        if (r34 != null) goto L71;
        String r35 = "";
    L72:
        Intrinsics.checkNotNullParameter(r35, "<set-?>");
        r114.a = r35;
        ((ArrayList) this.h).add(r114);
        r114.c.setOnClickListener(this.k);
        r32.addView(r114.c, r114.d);
        r114.c.setAnimationFromUrl(r114.e);
        r114.c.playAnimation();
    L122:
        boolean r115 = true;
    L123:
        boolean r116 = r115;
    L128:
        return TuplesKt.to(Boolean.valueOf(r116), null);
    L71:
        r35 = r34;
    L101:
        r115 = false;
        goto L123
    L46:
        Activity r36 = ECHybridExtensionsKt.a(this.c.a);
        if ((r36 instanceof FragmentActivity) == true) goto L49;
        r36 = null;
    L49:
        FragmentActivity r37 = (FragmentActivity) r36;
        if (r37 == null) goto L58;
        Window r38 = r37.getWindow();
        if (r38 == null) goto L58;
        View r39 = r38.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L60;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r40 = ThreadMethodProxy.currentThread();
        if (r40 == com.larus.home.impl.utils.c.a) goto L60;
        com.larus.home.impl.utils.c.a(r40, "getDecorView");
    L60:
        if ((r39 instanceof FrameLayout) == true) goto L62;
        r39 = null;
    L62:
        r32 = (FrameLayout) r39;
    L58:
        r39 = null;
        goto L60
    L74:
        if (Intrinsics.areEqual(r5, "list") == false) goto L126;
        ECHybridListEngine r41 = this.e;
        if (r41 == null) goto L101;
        ECHybridRecyclerView r42 = r41.b;
        Object r43 = b0.d(r26, "index", r113);
        if (r43 == null) goto L125;
        int r44 = ((Integer) r43).intValue();
        Object r45 = r26.get("item_types");
        if ((r45 instanceof List) == true) goto L83;
        r45 = null;
    L83:
        List r46 = (List) r45;
        if (r46 != null) goto L86;
        r46 = CollectionsKt.emptyList();
    L86:
        int r47 = this.e.a.getItemCount();
        int r48 = 0;
        int r49 = -1;
    L87:
        if (r48 >= r47) goto L100;
        ECHybridListItemVO r50 = this.e.h(r48);
        if (r50 == null) goto L93;
        Integer r51 = r50.c;
        if (r51 == null) goto L93;
        int r52 = r51.intValue();
    L95:
        if (r46.contains(Integer.valueOf(r52)) == false) goto L97;
        r49 = r49 + 1;
    L97:
        if (r49 == r44) goto L98;
        r48 = r48 + 1;
        goto L87
    L98:
        r2 = r48;
    L93:
        r52 = 0;
    L100:
        if (r2 < 0) goto L101;
        r114.b = r2;
        ((ArrayList) this.i).add(r114);
        r42.removeOnChildAttachStateChangeListener(this.j);
        r42.addOnChildAttachStateChangeListener(this.j);
        View r53 = r42.getChildAt(0);
        if (r53 == null) goto L105;
        int r54 = r42.getChildViewHolder(r53).getAdapterPosition();
    L106:
        if (r2 < r54) goto L122;
        int r55 = r42.getChildCount() + r54;
        VirtualLayoutManager r56 = this.e.b.getLayoutManager();
        if (r56 == null) goto L112;
        List r57 = r56.Q();
        if (r57 == null) goto L112;
        int r117 = r57.size();
    L114:
        if (r2 > (r55 - r117)) goto L122;
        View r58 = r42.getChildAt(r2 - r54);
        if (r58 == null) goto L118;
        RecyclerView.ViewHolder r59 = r42.getChildViewHolder(r58);
    L120:
        if ((r59 instanceof ff3.b) == false) goto L122;
        ((ff3.b) r59).s3(r114.c, r114.d);
        r114.c.setAnimationFromUrl(r114.e);
        r114.c.playAnimation();
        goto L122
    L118:
        r59 = null;
    L112:
        r117 = 0;
        goto L114
    L105:
        r54 = 0;
        goto L106
    L125:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L126:
        r116 = false;
        goto L128
    L16:
        if (r14.equals("left_top") == false) goto L27;
        r16 = 8388659;
        goto L28
    L19:
        if (r14.equals("right_bottom") == false) goto L27;
        r16 = 8388693;
        goto L28
    L22:
        if (r14.equals("left_bottom") == false) goto L27;
        r16 = 8388691;
        goto L28
    L25:
        if (r14.equals("right_top") == false) goto L27;
        r16 = 8388661;
        goto L28
    L11:
        r10 = -2;
        goto L12
    L7:
        r7 = -2;
        goto L8
    L130:
        if (Intrinsics.areEqual(r4, "dismiss") == false) goto L172;
        Object r60 = b0.d(r26, "container_id", "");
        if (r60 == null) goto L170;
        String r61 = (String) r60;
        Object r62 = b0.d(r26, "type", "absolute");
        if (Intrinsics.areEqual(r62, "absolute") == false) goto L141;
        b r63 = g(this.h, r61);
        if (r63 == null) goto L166;
        h(this.h, r63);
    L163:
        boolean r118 = true;
    L168:
        return TuplesKt.to(Boolean.valueOf(r118), null);
    L166:
        r118 = false;
        goto L168
    L141:
        if (Intrinsics.areEqual(r62, "list") == false) goto L166;
        b r64 = g(this.i, r61);
        if (r64 == null) goto L166;
        Object r65 = b0.d(r26, "uuid", "");
        if (r65 == null) goto L165;
        String r66 = (String) r65;
        if (r66.length() != 0) goto L150;
        boolean r67 = true;
    L151:
        if (r67 == false) goto L153;
        h(this.i, r64);
        goto L163
    L153:
        ECHybridListEngine r68 = this.e;
        if (r68 == null) goto L156;
        ECHybridListItemVO r69 = r68.h(r64.b);
    L157:
        if (r69 == null) goto L166;
        String r70 = r69.g();
        if (r70 == null) goto L166;
        if (StringsKt.contains$default(r70, r66, false, 2, null) != true) goto L166;
        h(this.i, r64);
        goto L163
    L156:
        r69 = null;
        goto L157
    L150:
        r67 = false;
        goto L151
    L165:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L170:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L172:
        return qf3.e.c("unsupported func_type");
    }
}
