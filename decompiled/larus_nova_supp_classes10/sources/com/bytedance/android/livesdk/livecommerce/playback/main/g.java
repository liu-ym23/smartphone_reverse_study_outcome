package com.bytedance.android.livesdk.livecommerce.playback.main;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.livesdk.livecommerce.playback.card.k;
import com.bytedance.android.livesdk.livecommerce.playback.utils.ExplainPlaybackUtils;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g extends QUIModule {
    public final Fragment l;
    public final String m;

    public final QIPresenter h() {
        return new ExplainPlaybackPresenter(this.l);
    }

    public final List<QUIModule> i() {
        if (ExplainPlaybackUtils.d() == true) goto L9;
        if (ExplainPlaybackUtils.e(this.m) == true) goto L9;
        return CollectionsKt.listOf(new QUIModule[]{new com.bytedance.android.livesdk.livecommerce.playback.video.c(this.l), new com.bytedance.android.livesdk.livecommerce.playback.bottomliving.a(this.l), new com.bytedance.android.livesdk.livecommerce.playback.bottom.a(this.l), new com.bytedance.android.livesdk.livecommerce.playback.multicards.d(this.l), new com.bytedance.android.livesdk.livecommerce.playback.subtitle.a(this.l), new com.bytedance.android.livesdk.livecommerce.playback.authorinfo.a(this.l), new com.bytedance.android.livesdk.livecommerce.playback.banner.a(this.l), new com.bytedance.android.livesdk.livecommerce.playback.interaction.b(this.l)});
    L9:
        return CollectionsKt.listOf(new QUIModule[]{new com.bytedance.android.livesdk.livecommerce.playback.header.a(this.l), new com.bytedance.android.livesdk.livecommerce.playback.video.c(this.l), new com.bytedance.android.livesdk.livecommerce.playback.bottom.a(this.l), new k(this.l), new com.bytedance.android.livesdk.livecommerce.playback.tip.b(this.l), new com.bytedance.android.livesdk.livecommerce.playback.guide.c(this.l), new com.bytedance.android.livesdk.livecommerce.playback.authorinfo.a(this.l)});
    }

    public g(Fragment r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(0);
        this.l = r2;
        this.m = r3;
    }

    public final View f(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        ShoppingAsyncInflater.e.getClass();
        return ShoppingAsyncInflater.a.a(r3).aU(2131560692, r4, false);
    }
}
