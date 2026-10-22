package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.GestureFrameLayout;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.PhotoFeedViewHolder;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.VideoFeedViewHolder;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.player.AutoPlayHelper;
import com.bytedance.awemeopen.apps.framework.player.VideoPreRenderHelper;
import com.bytedance.awemeopen.infra.base.live.AoLive;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.bytedance.awemeopen.servicesapi.livepreview.AoLiveService;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public h() {
    }

    public static int c(r14.c r1) {
        Intrinsics.checkNotNullParameter(r1, "aweme");
        if (r1.a == false) goto L5;
        return -1;
    L5:
        d14.a r0 = b14.a.a;
        if (b14.a.a(x24.a.class).w2(r1) == false) goto L9;
        return 4;
    L9:
        if (b14.a.a(x24.a.class).W(r1) == false) goto L12;
    L17:
        return 1;
    L12:
        if (b14.a.a(x24.a.class).G2(r1) == false) goto L15;
        return 2;
    L15:
        if (b14.a.a(x24.a.class).v3(r1) == false) goto L17;
        return 3;
    }

    public static /* synthetic */ com.bytedance.awemeopen.apps.framework.framework.viewpager.g b(ViewGroup r9, int r10, FeedPagerListViewModel r11, Activity r12, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r13, FeedSeekBarHelper r14, VideoPreRenderHelper r15, vz3.c r16) {
        return a(r9, r10, r11, r12, r13, r14, r15, r16, false);
    }

    public static com.bytedance.awemeopen.apps.framework.framework.viewpager.g a(ViewGroup r16, int r17, final FeedPagerListViewModel r18, final Activity r19, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r20, FeedSeekBarHelper r21, VideoPreRenderHelper r22, vz3.c r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r16, "parent");
        Intrinsics.checkNotNullParameter(r18, "vm");
        Intrinsics.checkNotNullParameter(r20, "aosPageOwner");
        Intrinsics.checkNotNullParameter(r21, "feedSeekBarHelper");
        Intrinsics.checkNotNullParameter(r22, "videoPreRenderHelper");
        Intrinsics.checkNotNullParameter(r23, "feedPageConfig");
        boolean r4 = true;
        final boolean r7 = false;
        if (r17 != 1) goto L5;
        g54.b r9 = AosExtConfig.b.p2();
        LayoutInflater r1 = LayoutInflater.from(r16.getContext());
        int r2 = VideoFeedViewHolder.p;
        View r3 = r9.a(r1.inflate(2131558665, r16, false));
        final boolean r5 = r18.getEnableBtmComment();
        VideoFeedViewHolder r13 = new VideoFeedViewHolder(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a(r3, r16, r18, r19, r20, r9, r23, new FeedItemViewHolderHelper$bottomMarginConfig$1(r19, r18, r5)), r21, new p(), r22, new FeedItemViewHolderHelper$createVideoViewHolder$1(r18));
        r13.l = r24;
        return r13;
    L5:
        if (r17 != 2) goto L7;
        g54.b r6 = AosExtConfig.b.p2();
        LayoutInflater r8 = LayoutInflater.from(r16.getContext());
        int r10 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.b.e;
        View r11 = r8.inflate(2131558662, r16, false);
        if ((r11 instanceof GestureFrameLayout) == false) goto L17;
        GestureFrameLayout r12 = (GestureFrameLayout) r11;
    L18:
        if (r12 == null) goto L21;
        r12.setGestureCallback(new g());
    L21:
        AutoPlayHelper r14 = r18.getAutoPlayHelper();
        if (r14 != null) goto L24;
    L26:
        r4 = false;
    L27:
        if (r4 == false) goto L31;
        AoLiveService r15 = AoLive.a;
        if (r15 == null) goto L31;
        r15.m2();
    L31:
        View r25 = r6.a(r11);
        vz3.c r26 = new vz3.c();
        Function0<Integer> r110 = new FeedItemViewHolderHelper$bottomMarginConfig$1(r19, r18, r7);
        Intrinsics.checkNotNullParameter(r25, "itemView");
        Intrinsics.checkNotNullParameter(r16, "viewPager");
        Intrinsics.checkNotNullParameter(r18, "vm");
        Intrinsics.checkNotNullParameter(r20, "pageOwner");
        Intrinsics.checkNotNullParameter(r6, "impression");
        Intrinsics.checkNotNullParameter(r26, "feedPageConfig");
        Intrinsics.checkNotNullParameter(r110, "bottomMargin");
        AoLiveService r27 = AoLive.a;
        Context r28 = r16.getContext();
        Bundle r29 = new Bundle();
        Bundle r0 = new Bundle();     // Catch: Exception -> L34
        r0.putString("enter_from_merge", r18.sceneId());     // Catch: Exception -> L34
        r0.putString("enter_method", "live_cell");     // Catch: Exception -> L34
        r0.putString("action_type", "draw");     // Catch: Exception -> L34
        r29.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", r0);     // Catch: Exception -> L34
    L36:
        Intrinsics.checkNotNullParameter(r28, "context");
        Intrinsics.checkNotNullParameter(r29, "liveBundle");
        AoLiveService r30 = AoLive.a;
        Intrinsics.checkNotNull(r30);
        r30.T1();
        ViewGroup r31 = (ViewGroup) r11;
        throw null;
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L36
    L24:
        if (r14.a() != true) goto L26;
    L17:
        r12 = null;
        goto L18
    L7:
        if (r17 != 3) goto L9;
        g54.b r32 = AosExtConfig.b.p2();
        LayoutInflater r33 = LayoutInflater.from(r16.getContext());
        int r34 = PhotoFeedViewHolder.o;
        View r35 = r32.a(r33.inflate(2131558663, r16, false));
        final boolean r36 = r18.getEnableBtmComment();
        return new PhotoFeedViewHolder(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a(r35, r16, r18, r19, r20, r32, r23, new FeedItemViewHolderHelper$bottomMarginConfig$1(r19, r18, r36)), new p());
    L9:
        if (r17 != 4) goto L12;
        g54.b r37 = AosExtConfig.b.p2();
        LayoutInflater r38 = LayoutInflater.from(r16.getContext());
        int r39 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.a.h;
        View r40 = r38.inflate(2131558661, r16, false);
        int r41 = j64.b.a;
        j64.b.a(AoHostService.class).l0(r16.getContext(), new Bundle());
        Intrinsics.checkNotNull(r40, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r40).addView(null);
        return new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.a(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a(r37.a(r40), r16, r18, r19, r20, r37, new vz3.c(), new FeedItemViewHolderHelper$bottomMarginConfig$1(r19, r18, r7)));
    L12:
        throw new RuntimeException("无法处理的AosFeedItemType类型" + r17);
    }
}
