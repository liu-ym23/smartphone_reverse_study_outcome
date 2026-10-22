package com.bytedance.android.shopping.deepfeed.slice.view.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.api.video.ScaleType;
import com.bytedance.android.shopping.api.video.e;
import com.bytedance.android.shopping.api.video.k;
import com.bytedance.android.shopping.api.video.l;
import com.bytedance.android.shopping.deepfeed.slice.service.d;
import com.bytedance.android.shopping.deepfeed.slice.view.f;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.android.ecom.arch.slice.render.elements.b<DeepFeedSliceVideoView> implements d, com.bytedance.android.shopping.deepfeed.slice.service.c {
    @Override // com.bytedance.android.shopping.deepfeed.slice.service.c
    public final Pair<Integer, Integer> a() {
        DeepFeedSliceVideoView r0 = (DeepFeedSliceVideoView) k1();
        if (r0 != null) goto L5;
        return null;
    L5:
        return TuplesKt.to(Integer.valueOf(r0.getCurrentTopMargin()), Integer.valueOf(r0.getCurrentTopMax()));
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.d
    public final boolean h() {
        DeepFeedSliceVideoView r0 = (DeepFeedSliceVideoView) k1();
        if (r0 == null) goto L7;
        ConcurrentHashMap<String, DeepFeedSliceVideoEarlyWarmCenter.a> r1 = DeepFeedSliceVideoEarlyWarmCenter.a;
        if (DeepFeedSliceVideoEarlyWarmCenter.a(DeepFeedSliceVideoEarlyWarmCenter.b(r0.h), DeepFeedSliceVideoEarlyWarmCenter.WarmLevel.PRERENDERED) != true) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.d
    public final boolean j() {
        DeepFeedSliceVideoView r0 = (DeepFeedSliceVideoView) k1();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.d != null) goto L7;
    L12:
        boolean r1 = false;
    L13:
        if (r1 != true) goto L17;
        return true;
    L17:
        return false;
    L7:
        if (r0.h.b.length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        r1 = true;
        goto L13
    L9:
        r2 = false;
        goto L10
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.d
    public final void p() {
        DeepFeedSliceVideoView r0 = (DeepFeedSliceVideoView) k1();
        if (r0 == null) goto L8;
        ECVideoPlayerView r1 = r0.d;
        if (r1 == null) goto L9;
        r1.p();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.d
    public final boolean q() {
        DeepFeedSliceVideoView r0 = (DeepFeedSliceVideoView) k1();
        if (r0 == null) goto L7;
        ConcurrentHashMap<String, DeepFeedSliceVideoEarlyWarmCenter.a> r1 = DeepFeedSliceVideoEarlyWarmCenter.a;
        if (DeepFeedSliceVideoEarlyWarmCenter.a(DeepFeedSliceVideoEarlyWarmCenter.b(r0.h), DeepFeedSliceVideoEarlyWarmCenter.WarmLevel.PRELOADED) != true) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.d
    public final void release() {
        DeepFeedSliceVideoView r0 = (DeepFeedSliceVideoView) k1();
        if (r0 == null) goto L6;
        ConcurrentHashMap<String, DeepFeedSliceVideoEarlyWarmCenter.a> r1 = DeepFeedSliceVideoEarlyWarmCenter.a;
        r0.d(DeepFeedSliceVideoEarlyWarmCenter.b(r0.h));
        r0.d = null;
        r0.h = new f(0);
        return;
    }

    public a(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [android.widget.FrameLayout, com.bytedance.android.shopping.deepfeed.slice.view.video.DeepFeedSliceVideoView] */
    public final void H0(Map<String, ? extends Object> r37) {
        Intrinsics.checkNotNullParameter(r37, "props");
        Object r1 = r37.get("targetTopOffset");
        Object r3 = null;
        if ((r1 instanceof Number) == true) goto L5;
        r1 = null;
    L5:
        Number r2 = (Number) r1;
        if (r2 == null) goto L10;
        double r4 = r2.doubleValue();
        DeepFeedSliceVideoView r5 = (DeepFeedSliceVideoView) k1();
        if (r5 == null) goto L10;
        r5.setMaxMargin(r4);
    L10:
        Object r6 = r37.get("startOffset");
        if ((r6 instanceof Number) == true) goto L13;
        r6 = null;
    L13:
        Number r7 = (Number) r6;
        if (r7 == null) goto L18;
        double r8 = r7.doubleValue();
        DeepFeedSliceVideoView r9 = (DeepFeedSliceVideoView) k1();
        if (r9 == null) goto L18;
        r9.setStartMargin(r8);
    L18:
        Object r10 = r37.get("vid");
        if ((r10 instanceof String) == true) goto L21;
        r10 = null;
    L21:
        String r11 = (String) r10;
        if (r11 != null) goto L24;
        String r12 = "";
    L25:
        Object r13 = r37.get("src");
        if ((r13 instanceof String) == true) goto L28;
        r13 = null;
    L28:
        String r14 = (String) r13;
        if (r14 != null) goto L31;
        String r15 = "";
    L32:
        Object r16 = r37.get("image");
        if ((r16 instanceof String) == true) goto L35;
        r16 = null;
    L35:
        String r17 = (String) r16;
        if (r17 != null) goto L38;
        String r18 = "";
    L39:
        Boolean r19 = Boolean.FALSE;
        Object r20 = r37.get("mute");
        if ((r20 instanceof Boolean) == true) goto L42;
        r20 = null;
    L42:
        Boolean r21 = (Boolean) r20;
        if (r21 != null) goto L45;
        r21 = r19;
    L45:
        boolean r22 = r21.booleanValue();
        Double r110 = Double.valueOf(0.0d);
        Object r111 = r37.get("width");
        if ((r111 instanceof Double) == true) goto L48;
        r111 = null;
    L48:
        Double r112 = (Double) r111;
        if (r112 == null) goto L52;
        r110 = r112;
    L52:
        int r113 = (int) r110.doubleValue();
        Double r23 = Double.valueOf(0.0d);
        Object r24 = r37.get("height");
        if ((r24 instanceof Double) == true) goto L55;
        r24 = null;
    L55:
        Double r25 = (Double) r24;
        if (r25 == null) goto L59;
        r23 = r25;
    L59:
        int r114 = (int) r23.doubleValue();
        Object r26 = r37.get("fullScreen");
        if ((r26 instanceof Boolean) == true) goto L62;
        r26 = null;
    L62:
        Boolean r27 = (Boolean) r26;
        if (r27 != null) goto L65;
        r27 = r19;
    L65:
        boolean r115 = r27.booleanValue();
        Integer r28 = 0;
        Object r116 = r37.get("topMargin");
        if ((r116 instanceof Integer) == true) goto L68;
        r116 = null;
    L68:
        Integer r117 = (Integer) r116;
        if (r117 == null) goto L72;
        r28 = r117;
    L72:
        int r118 = r28.intValue();
        Object r29 = r37.get("visible");
        if ((r29 instanceof Boolean) == true) goto L75;
        r29 = null;
    L75:
        Boolean r30 = (Boolean) r29;
        if (r30 != null) goto L78;
        r30 = r19;
    L78:
        boolean r119 = r30.booleanValue();
        Object r31 = r37.get("progress");
        if ((r31 instanceof Float) == true) goto L81;
        r31 = null;
    L81:
        Float r32 = (Float) r31;
        if (r32 != null) goto L84;
        Float r120 = null;
    L85:
        Object r0 = r37.get("isPlaying");
        if ((r0 instanceof Boolean) == true) goto L88;
        r0 = null;
    L88:
        Boolean r33 = (Boolean) r0;
        if (r33 == null) goto L92;
        r19 = r33;
    L92:
        f r34 = new f(r12, r15, r18, r22, r113, r114, r115, r118, r119, r120, r19.booleanValue());
        ?? r35 = (DeepFeedSliceVideoView) k1();
        if (r35 == 0) goto L249;
        Intrinsics.checkNotNullParameter(r34, "data");
        f r36 = r35.h;
        Intrinsics.checkNotNullParameter(r36, "newState");
        if ((!Intrinsics.areEqual(r34.a, r36.a)) == false) goto L97;
    L118:
        boolean r38 = true;
    L119:
        if (r38 == false) goto L249;
        if (r34.b.length() <= 0) goto L124;
        boolean r39 = true;
    L125:
        if (r39 == false) goto L133;
        String r40 = r34.b;
        f r41 = r35.h;
        if (r41 == null) goto L129;
        String r42 = r41.b;
    L131:
        if ((!Intrinsics.areEqual(r40, r42)) == false) goto L133;
        boolean r43 = true;
    L134:
        if (r43 == false) goto L207;
        c r44 = DeepFeedSliceVideoEarlyWarmCenter.b(r34);
        if (r44 == null) goto L158;
        ViewGroup r45 = r35.c;
        Intrinsics.checkNotNullParameter(r44, "meta");
        Intrinsics.checkNotNullParameter(r45, "container");
        DeepFeedSliceVideoEarlyWarmCenter.a r46 = DeepFeedSliceVideoEarlyWarmCenter.a.get(r44.a);
        if (r46 == null) goto L158;
        WeakReference<ECVideoPlayerView> r47 = r46.b;
        if (r47 == null) goto L158;
        ECVideoPlayerView r48 = r47.get();
        if (r48 == null) goto L158;
        if (r46.a == DeepFeedSliceVideoEarlyWarmCenter.WarmLevel.NONE) goto L158;
        ViewParent r49 = r48.getParent();
        if ((r49 instanceof ViewGroup) == true) goto L151;
        r49 = null;
    L151:
        ViewGroup r50 = (ViewGroup) r49;
        if (r50 == null) goto L155;
        r50.removeView(r48);
    L155:
        if (r48.getParent() != null) goto L157;
        r45.removeAllViews();
        r45.addView(r48, new ViewGroup.LayoutParams(-1, -1));
    L157:
        r46.c = true;
    L159:
        if (r48 != null) goto L161;
        r35.d(DeepFeedSliceVideoEarlyWarmCenter.b(r35.h));
        r35.d = new ECVideoPlayerView(r35.getContext(), null, 0, new l(AVScene.MALL_PRODUCT_INFLOW_LIVE_REPLAY, true, true, false, null, true, true, 40));
        r35.c.removeAllViews();
        r35.c.addView(r35.d, new ViewGroup.LayoutParams(-1, -1));
        String r51 = r34.a;
        String r52 = r34.b;
        boolean r53 = r34.d;
        ECVideoPlayerView r54 = r35.d;
        if (r54 == null) goto L167;
        long r55 = r54.getDuration();
    L169:
        if (r51.length() != 0) goto L171;
        boolean r56 = true;
    L172:
        if (r56 == false) goto L174;
        r51 = r52;
    L174:
        com.bytedance.android.shopping.api.video.d r57 = new com.bytedance.android.shopping.api.video.d(r53, true, 0, (int) r55, false, 484);
        k r58 = new k();
        Intrinsics.checkNotNullParameter(r51, "videoKey");
        r58.a = r51;
        Intrinsics.checkNotNullParameter(r51, "key");
        r58.b = r51;
        r58.a(r52);
        com.bytedance.android.shopping.api.video.b r59 = r58.b();
        if (r59 == null) goto L183;
        Intrinsics.checkNotNullParameter(r59, "playItem");
        ArrayList r60 = new ArrayList();
        r60.add(r59);
        Intrinsics.checkNotNullParameter(r57, "options");
        Intrinsics.checkNotNullParameter(r51, "newVid");
        e r61 = new e(r51, 0, null, r60, null, r57, -1, 0.0f, null, -1, -1, null, null);
        ECVideoPlayerView r62 = r35.d;
        if (r62 == null) goto L180;
        r62.w(ScaleType.CENTER_CROP);
    L180:
        ECVideoPlayerView r63 = r35.d;
        if (r63 == null) goto L183;
        r63.b(r61);
    L183:
        r35.f.setVisibility(0);
        String r64 = r34.c;
        if (r64.length() != 0) goto L186;
        boolean r65 = true;
    L187:
        if (r65 == true) goto L190;
        ECUrlModel r66 = new ECUrlModel();
        r66.setUrlList(CollectionsKt.listOf(r64));
        LruCache<String, Bitmap> r67 = com.bytedance.android.shopping.deepfeed.ui.vh.l.a;
        SimpleDraweeView r68 = r35.f;
        int r69 = com.bytedance.android.shopping.deepfeed.utlis.k.a;
        Intrinsics.checkNotNullParameter("video_image", "sceneTag");
        com.bytedance.android.shopping.deepfeed.ui.vh.l.c(null, r66, r68, new r("ec_na_deepfeed", "video_image"));
        SimpleDraweeView r70 = r35.e;
        Intrinsics.checkNotNullParameter("video_blur_image", "sceneTag");
        com.bytedance.android.shopping.deepfeed.ui.vh.l.a(null, r66, 0, r70, new r("ec_na_deepfeed", "video_blur_image"), null);
    L190:
        int r71 = r34.e;
        int r72 = r34.f;
        float r73 = r72;
        if (r35.g != 0) goto L194;
        r35.g = k1.o();
    L194:
        if (1 > r71) goto L198;
        if (r72 <= r71) goto L198;
        r73 = (r35.g * r72) / r71;
    L198:
        ViewGroup.LayoutParams r74 = r35.c.getLayoutParams();
        if (r74 == null) goto L201;
        r74.height = com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r73));
    L201:
        ECVideoPlayerView r75 = r35.d;
        if (r75 == null) goto L204;
        r75.getDuration();
    L204:
        ECVideoPlayerView r76 = r35.d;
        if (r76 == null) goto L207;
        r76.r(new b());
        goto L207
    L186:
        r65 = false;
        goto L187
    L171:
        r56 = false;
        goto L172
    L167:
        r55 = 0;
        goto L169
    L161:
        if (r35.d == r48) goto L163;
        r35.d(DeepFeedSliceVideoEarlyWarmCenter.b(r35.h));
    L163:
        r35.d = r48;
    L158:
        r48 = null;
    L207:
        int r77 = r34.h;
        f r78 = r35.h;
        if (r78 != null) goto L210;
    L211:
        r35.e(r77);
    L212:
        boolean r79 = r34.i;
        if (r79 == true) goto L215;
    L220:
        if (r79 == true) goto L229;
        ECVideoPlayerView r80 = r35.d;
        if (r80 != null) goto L224;
    L228:
        r35.f.setVisibility(0);
    L242:
        boolean r81 = r34.d;
        ECVideoPlayerView r82 = r35.d;
        if (r82 == null) goto L245;
        r82.k(r81);
    L245:
        com.bytedance.android.shopping.deepfeed.slice.service.b r84 = r35.b();
        if (r84 == null) goto L248;
        r84.K(r35.n);
    L248:
        r35.h = r34;
        goto L249
    L224:
        if (r80.h() != true) goto L228;
        ECVideoPlayerView r85 = r35.d;
        if (r85 == null) goto L228;
        r85.x();
        goto L228
    L229:
        Float r86 = r34.j;
        if (r86 == null) goto L242;
        float r87 = r86.floatValue();
        if (r87 <= 0) goto L242;
        f r88 = r35.h;
        if (r88 == null) goto L236;
        Float r89 = r88.j;
    L238:
        if ((!Intrinsics.areEqual(r87, r89)) == false) goto L242;
        ECVideoPlayerView r90 = r35.d;
        if (r90 == null) goto L242;
        r90.v(r87 * 100);
        goto L242
    L236:
        r89 = null;
        goto L238
    L215:
        if (r35.h.i == true) goto L220;
        ECVideoPlayerView r91 = r35.d;
        if (r91 == null) goto L219;
        r91.n();
    L219:
        System.currentTimeMillis();
        goto L242
    L210:
        if (r77 == r78.h) goto L212;
    L129:
        r42 = null;
    L133:
        r43 = false;
        goto L134
    L124:
        r39 = false;
        goto L125
    L97:
        if ((!Intrinsics.areEqual(r34.b, r36.b)) == true) goto L118;
        if ((!Intrinsics.areEqual(r34.c, r36.c)) == true) goto L118;
        if (r34.d != r36.d) goto L118;
        if (r34.e != r36.e) goto L118;
        if (r34.f != r36.f) goto L118;
        if (r34.g != r36.g) goto L118;
        if (r34.h != r36.h) goto L118;
        if (r34.i != r36.i) goto L118;
        if ((!Intrinsics.areEqual(r34.j, r36.j)) == true) goto L118;
        if (r34.k != r36.k) goto L118;
        r38 = false;
    L249:
        Object r92 = ((BaseSlcViewManager) this).a.o(com.bytedance.android.shopping.deepfeed.slice.service.b.class);
        if ((r92 instanceof com.bytedance.android.shopping.deepfeed.slice.service.b) == false) goto L253;
        r3 = r92;
    L253:
        com.bytedance.android.shopping.deepfeed.slice.service.b r94 = (com.bytedance.android.shopping.deepfeed.slice.service.b) r3;
        if (r94 == null) goto L262;
        int r95 = r94.L();
        DeepFeedSliceVideoView r96 = (DeepFeedSliceVideoView) k1();
        if (r96 == null) goto L263;
        r96.i = r95;
        if (r95 != 1) goto L260;
        r96.e(r96.l);
        return;
    L260:
        r96.e(r96.m);
        return;
    L263:
        return;
    L262:
        return;
    L84:
        r120 = r32;
        goto L85
    L38:
        r18 = r17;
        goto L39
    L31:
        r15 = r14;
        goto L32
    L24:
        r12 = r11;
        goto L25
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.d
    public final void b(float r2) {
        DeepFeedSliceVideoView r0 = (DeepFeedSliceVideoView) k1();
        if (r0 == null) goto L8;
        ECVideoPlayerView r1 = r0.d;
        if (r1 == null) goto L9;
        r1.v(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.d
    public final void c(boolean r2) {
        DeepFeedSliceVideoView r0 = (DeepFeedSliceVideoView) k1();
        if (r0 == null) goto L8;
        ECVideoPlayerView r1 = r0.d;
        if (r1 == null) goto L9;
        r1.k(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.d
    public final void f(int r2) {
        DeepFeedSliceVideoView r0 = (DeepFeedSliceVideoView) k1();
        if (r0 == null) goto L8;
        ECVideoPlayerView r1 = r0.d;
        if (r1 == null) goto L9;
        r1.o(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.c
    public final void m(int r2) {
        DeepFeedSliceVideoView r0 = (DeepFeedSliceVideoView) k1();
        if (r0 == null) goto L6;
        r0.e(r2);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View, com.bytedance.android.shopping.deepfeed.slice.view.video.DeepFeedSliceVideoView] */
    public final View n1(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        ((BaseSlcViewManager) this).a.s(d.class, this);
        ?? r0 = new DeepFeedSliceVideoView(r3);
        SlcTemplateContext r4 = ((BaseSlcViewManager) this).a;
        Intrinsics.checkNotNullParameter(r4, "templateCtx");
        r0.j = r4;
        return r0;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.d
    public final void play(boolean r3) {
        DeepFeedSliceVideoView r0 = (DeepFeedSliceVideoView) k1();
        if (r0 == null) goto L14;
        if (r3 == false) goto L9;
        com.bytedance.android.shopping.deepfeed.slice.service.b r4 = r0.b();
        if (r4 == null) goto L8;
        r4.N(true);
    L8:
        r0.g();
        return;
    L9:
        com.bytedance.android.shopping.deepfeed.slice.service.b r5 = r0.b();
        if (r5 == null) goto L12;
        r5.N(false);
    L12:
        r0.f();
        return;
    }

    public final void w0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCtx");
        ((BaseSlcViewManager) this).a.s(com.bytedance.android.shopping.deepfeed.slice.service.c.class, this);
    }
}
