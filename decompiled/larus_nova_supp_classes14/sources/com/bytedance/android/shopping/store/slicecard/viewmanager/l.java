package com.bytedance.android.shopping.store.slicecard.viewmanager;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.view.ECShopProgressBarView;
import com.bytedance.android.ec.store.view.ECShopVideoPlayerView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.api.video.CodecType;
import com.bytedance.android.shopping.store.slicecard.dto.ShopCoverDto;
import com.bytedance.android.shopping.store.slicecard.dto.ShopPlayVideoDto;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l extends com.bytedance.android.ecom.arch.slice.render.elements.b<ECShopVideoPlayerView> {
    public boolean H3;
    public final SlcTemplateContext I3;

    public static final class a {
    }

    static {
    }

    public l(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "contextV");
        super(r2);
        this.I3 = r2;
    }

    public final void H0(Map<String, ? extends Object> r25) {
        Intrinsics.checkNotNullParameter(r25, "props");
        Object r0 = r25.get("data");
        if (r0 == null) goto L128;
        String r1 = com.bytedance.android.ec.hybrid.list.util.k.d(r0);
        if (r1 == null) goto L130;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        int r4 = t0.a;     // Catch: Throwable -> L9
        Object r2 = Result.constructor-impl((ShopPlayVideoDto) t0.a.a.fromJson(r1, ShopPlayVideoDto.class));     // Catch: Throwable -> L9
    L11:
        m r5 = null;
        if (Result.isFailure-impl(r2) == false) goto L14;
        r2 = null;
    L14:
        ShopPlayVideoDto r6 = (ShopPlayVideoDto) r2;
        if (r6 != null) goto L17;
        return;
    L17:
        String r7 = r6.getVideoId();
        if (r7 != null) goto L20;
        return;
    L20:
        String r8 = "";
        if (this.H3 == true) goto L40;
        this.H3 = true;
        SlcTemplateContext r9 = ((BaseSlcViewManager) this).a;
        String r10 = r9.g;
        if (r10 != null) goto L25;
        r10 = "";
    L25:
        Object r11 = r9.o(r10);
        if ((r11 instanceof gk3.a) == true) goto L28;
        r11 = null;
    L28:
        gk3.a r12 = (gk3.a) r11;
        if (r12 == null) goto L32;
        LifecycleOwner r13 = r12.getLifecycleOwner();
        if (r13 == null) goto L32;
    L36:
        if (r13 == null) goto L40;
        Lifecycle r14 = r13.getLifecycle();
        if (r14 == null) goto L40;
        r14.addObserver(new ShopVideoPlayerViewManager$registerLifecycleObserver$1(this));
    L32:
        Context r15 = getContext();
        if ((r15 instanceof LifecycleOwner) == true) goto L35;
        r15 = null;
    L35:
        r13 = (LifecycleOwner) r15;
    L40:
        com.bytedance.android.shopping.api.video.k r16 = new com.bytedance.android.shopping.api.video.k();
        Intrinsics.checkNotNullParameter(r7, "videoKey");
        r16.a = r7;
        Intrinsics.checkNotNullParameter(r7, "key");
        r16.b = r7;
        String r17 = r6.getPlayUrl();
        if (r17 == null) goto L44;
        r8 = r17;
    L44:
        r16.a(r8);
        r16.e = ((long) r6.getHeight()) * ((long) r6.getWidth());
        CodecType r18 = CodecType.CODEC_TYPE_265;
        Intrinsics.checkNotNullParameter(r18, "codecType");
        r16.c = r18;
        Long r19 = r6.getDuration();
        long r20 = 0;
        if (r19 == null) goto L47;
        long r21 = r19.longValue();
    L48:
        long r110 = ECDraweeView.SQUARE;
        r16.f = r21 * r110;
        com.bytedance.android.shopping.api.video.b r22 = r16.b();
        if (r22 != null) goto L51;
        return;
    L51:
        Intrinsics.checkNotNullParameter(r7, "newVid");
        com.bytedance.android.shopping.api.video.d r111 = new com.bytedance.android.shopping.api.video.d(true, true, 0, 0, true, 380);
        Intrinsics.checkNotNullParameter(r111, "options");
        int r112 = r6.getHeight();
        int r113 = r6.getWidth();
        Long r23 = r6.getDuration();
        if (r23 == null) goto L54;
        long r24 = r23.longValue();
    L55:
        Long r26 = Long.valueOf(r24 * r110);
        if (r26 == null) goto L58;
        r20 = r26.longValue();
    L58:
        Intrinsics.checkNotNullParameter(r22, "playItem");
        ArrayList r114 = new ArrayList();
        r114.add(r22);
        com.bytedance.android.shopping.api.video.e r27 = new com.bytedance.android.shopping.api.video.e(r7, r20, null, r114, null, r111, -1, 0.0f, null, r112, r113, null, null);
        int r28 = t0.a;     // Catch: Throwable -> L61
        Object r29 = Result.constructor-impl((ShopCoverDto) t0.a.a.fromJson(com.bytedance.android.ec.hybrid.list.util.k.d(r25.get("cover")), ShopCoverDto.class));     // Catch: Throwable -> L61
    L64:
        if (Result.isFailure-impl(r29) == false) goto L66;
        r29 = null;
    L66:
        ShopCoverDto r30 = (ShopCoverDto) r29;
        ECShopVideoPlayerView r31 = k1();
        if (r31 != null) goto L69;
    L76:
        ECShopVideoPlayerView r32 = k1();
        if (r32 == null) goto L86;
        Intrinsics.checkNotNullParameter(r27, "newVideoModel");
        com.bytedance.android.shopping.api.video.e r33 = r32.a;
        if (r33 == null) goto L81;
        String r34 = r33.a;
    L83:
        if (Intrinsics.areEqual(r34, r27.a) == true) goto L86;
        r32.a = r27;
        r32.f.setVisibility(0);
        goto L86
    L81:
        r34 = null;
    L86:
        Object r35 = r25.get("is_mute");
        if (r35 == null) goto L93;
        String r36 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r35);
        if (r36 == null) goto L93;
        boolean r37 = Boolean.parseBoolean(r36);
        ECShopVideoPlayerView r38 = k1();
        if (r38 == null) goto L93;
        r38.setVolumeEnabled(!r37);
    L93:
        Object r39 = r25.get("is_loop");
        if (r39 == null) goto L100;
        String r40 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r39);
        if (r40 == null) goto L100;
        boolean r41 = Boolean.parseBoolean(r40);
        ECShopVideoPlayerView r42 = k1();
        if (r42 == null) goto L100;
        r42.setLooping(r41);
    L100:
        SlcTemplateContext r43 = this.I3;
        Object r44 = r25.get("progress_bar_slice_key");
        if (r44 == null) goto L103;
        String r45 = r44.toString();
    L104:
        m r46 = r43.h(r45);
        if ((r46 instanceof m) == false) goto L108;
        r5 = r46;
    L108:
        m r47 = r5;
        if (r47 == null) goto L115;
        ECShopProgressBarView r48 = r47.k1();
        if (r48 == null) goto L115;
        ECShopVideoPlayerView r49 = k1();
        if (r49 == null) goto L115;
        r49.a(r48);
    L115:
        dm.a.a("slice播控").a("onUpdateProp:" + r25.get("play_status"));
        ECShopVideoPlayerView r50 = k1();
        if (r50 == null) goto L129;
        Object r51 = r25.get("play_status");
        if (r51 == null) goto L121;
        String r52 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r51);
        if (r52 == null) goto L121;
    L122:
        r50.setPlayStatus(r52);
        return;
    L121:
        r52 = ECShopVideoPlayerView.PlayStatus.STOP.name();
        goto L122
    L129:
        return;
    L103:
        r45 = null;
        goto L104
    L69:
        if (r31.c != null) goto L76;
        if (r30 == null) goto L76;
        ECUrlModel r53 = r30.getUrl();
        if (r53 == null) goto L76;
        r31.c = r53;
        h0.d(r31.f, r30.getUrl(), null, null, null, null, null, 120);
    L61:
        th = move-exception;
        Result.Companion r54 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L64
    L54:
        r24 = 0;
        goto L55
    L47:
        r21 = 0;
    L9:
        th = move-exception;
        Result.Companion r55 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L130:
        return;
    }

    public final View n1(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        SlcTemplateContext r0 = ((BaseSlcViewManager) this).a;
        String r1 = r0.g;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        Object r2 = r0.o(r1);
        Context r3 = null;
        if ((r2 instanceof gk3.a) == true) goto L8;
        r2 = null;
    L8:
        gk3.a r5 = (gk3.a) r2;
        if (r5 == null) goto L13;
        LifecycleOwner r6 = r5.getLifecycleOwner();
        if (r6 == null) goto L13;
    L18:
        return new ECShopVideoPlayerView(r4, r6);
    L13:
        if ((r4 instanceof LifecycleOwner) == false) goto L16;
        r3 = r4;
    L16:
        r6 = (LifecycleOwner) r3;
        goto L18
    }
}
