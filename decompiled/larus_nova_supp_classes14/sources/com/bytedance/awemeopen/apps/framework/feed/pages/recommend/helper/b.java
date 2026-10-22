package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.GestureFrameLayout;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.VideoFeedViewHolder;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.VideoFitContainerAdViewHolder;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.player.VideoPreRenderHelper;
import com.bytedance.awemeopen.infra.base.npth.AoExceptionReporter;
import com.bytedance.awemeopen.infra.base.npth.ErrorPriority;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Integer c(r14.c r1) {
        Intrinsics.checkNotNullParameter(r1, "aweme");
        d14.a r0 = b14.a.a;
        if (b14.a.a(l24.b.class).a(r1) == false) goto L6;
        return 10001;
    L6:
        if (b14.a.a(l24.a.class).a(r1) == true) goto L11;
        return null;
    L11:
        return 10002;
    }

    public static com.bytedance.awemeopen.apps.framework.framework.viewpager.g a(ViewGroup r12, final FeedPagerListViewModel r13, final Activity r14, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r15, FeedSeekBarHelper r16, VideoPreRenderHelper r17, vz3.c r18, l14.b r19, int r20) {
        AosExtConfig r0 = AosExtConfig.b;
        g54.b r6 = r0.p2();
        if (r19 != null) goto L6;
        AoNpthService r5 = AoExceptionReporter.a;
        AoExceptionReporter.b(ErrorPriority.p0, AosPagerListViewModel.API_TYPE_FEED, "ad", "ad should not be null", 16);
        g54.b r7 = r0.p2();
        LayoutInflater r1 = LayoutInflater.from(r12.getContext());
        int r8 = VideoFeedViewHolder.p;
        return new VideoFeedViewHolder(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a(r7.a(r1.inflate(2131558665, r12, false)), r12, r13, r14, r15, r7, r18, new AdFeedItemViewHolderHelper$bottomMarginConfig$1(r14, r13)), r16, new p(), r17);
    L6:
        LayoutInflater r2 = LayoutInflater.from(r12.getContext());
        int r9 = VideoFitContainerAdViewHolder.g;
        View r3 = r2.inflate(2131558660, r12, false);
        if ((r3 instanceof GestureFrameLayout) == false) goto L9;
        GestureFrameLayout r4 = (GestureFrameLayout) r3;
    L10:
        if (r4 == null) goto L13;
        r4.setGestureCallback(new a());
    L13:
        ((ViewGroup) r3).addView(r19.createView(r12.getContext()));
        return new VideoFitContainerAdViewHolder(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a(r6.a(r3), r12, r13, r14, r15, r6, new vz3.c(), new AdFeedItemViewHolderHelper$bottomMarginConfig$1(r14, r13)), r19, r20);
    L9:
        r4 = null;
        goto L10
    }

    public static com.bytedance.awemeopen.apps.framework.framework.viewpager.g b(ViewGroup r10, int r11, FeedPagerListViewModel r12, Activity r13, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r14, FeedSeekBarHelper r15, VideoPreRenderHelper r16, vz3.c r17, String r18) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r12, "vm");
        Intrinsics.checkNotNullParameter(r14, "aosPageOwner");
        Intrinsics.checkNotNullParameter(r15, "feedSeekBarHelper");
        Intrinsics.checkNotNullParameter(r16, "videoPreRenderHelper");
        Intrinsics.checkNotNullParameter(r17, "feedPageConfig");
        Intrinsics.checkNotNullParameter(r18, "pageKey");
        if (r11 != 10001) goto L5;
        d14.a r0 = b14.a.a;
        b14.a.a(l24.b.class).s(r10.getContext());
        return a(r10, r12, r13, r14, r15, r16, r17, null, r11);
    L5:
        if (r11 == 10002) goto L7;
        return null;
    L7:
        d14.a r1 = b14.a.a;
        b14.a.a(l24.a.class).D1(r10.getContext(), r18);
        return a(r10, r12, r13, r14, r15, r16, r17, null, r11);
    }
}
