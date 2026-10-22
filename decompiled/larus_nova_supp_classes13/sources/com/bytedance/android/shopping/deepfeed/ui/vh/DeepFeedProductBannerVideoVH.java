package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005J\b\u0010\u0004\u001a\u00020\u0003H\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/vh/DeepFeedProductBannerVideoVH;", "Lcom/bytedance/android/shopping/deepfeed/ui/vh/AbstractDeepFeedBannerVH;", "Landroidx/lifecycle/LifecycleObserver;", "", "onDestory", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductBannerVideoVH extends AbstractDeepFeedBannerVH implements LifecycleObserver {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void onDestory() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.shopping.deepfeed.weights.c r1 = (com.bytedance.android.shopping.deepfeed.weights.c) r0;
        if (r1 == null) goto L11;
        ECVideoPlayerView r2 = r1.getVideoPlayerView();
        if (r2 == null) goto L12;
        r2.s();
        return;
    L12:
        return;
    }

    public final void V3() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.shopping.deepfeed.weights.c r1 = (com.bytedance.android.shopping.deepfeed.weights.c) r0;
        if (r1 == null) goto L11;
        ImageView r2 = r1.getVideoPauseIcon();
        if (r2 == null) goto L12;
        r2.setVisibility(8);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbstractDeepFeedBannerVH
    public final void T3(int r5) {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        ViewGroup.LayoutParams r2 = null;
        if ((r0 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.shopping.deepfeed.weights.c r1 = (com.bytedance.android.shopping.deepfeed.weights.c) r0;
        if (r1 == null) goto L23;
        ViewGroup.LayoutParams r3 = r1.d.getLayoutParams();
        if ((r3 instanceof FrameLayout.LayoutParams) == false) goto L11;
        r2 = r3;
    L11:
        FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) r2;
        if (r4 == null) goto L24;
        int r6 = r4.topMargin + (r5 / 3);
        int r7 = -com.bytedance.android.shopping.extensions.b.b(8);
        int r8 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r1.l));
        if (r7 > r6) goto L18;
        if (r8 < r6) goto L18;
        r1.a(r6);
        return;
    L18:
        EventBus r9 = EventBus.getDefault();
        boolean r10 = false;
        if (r6 > com.bytedance.android.shopping.extensions.b.b(0)) goto L21;
        r10 = true;
    L21:
        r9.post(new ge3.a(r10));
        return;
    L24:
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbstractDeepFeedBannerVH
    public final void U3(int r3) {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.shopping.deepfeed.weights.c r1 = (com.bytedance.android.shopping.deepfeed.weights.c) r0;
        if (r1 == null) goto L11;
        if (r3 != 0) goto L9;
        r1.a(-com.bytedance.android.shopping.extensions.b.b(8));
        return;
    L9:
        r1.a(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r1.l)));
        return;
    }

    public final void W3(boolean r3) {
        View r0 = null;
        if (r3 == false) goto L13;
        View r4 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r4 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == false) goto L8;
        r0 = r4;
    L8:
        com.bytedance.android.shopping.deepfeed.weights.c r1 = (com.bytedance.android.shopping.deepfeed.weights.c) r0;
        if (r1 == null) goto L31;
        ECVideoPlayerView r5 = r1.getVideoPlayerView();
        if (r5 == null) goto L32;
        r5.n();
        return;
    L32:
        return;
    L31:
        return;
    L13:
        View r6 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r6 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == true) goto L16;
        r6 = null;
    L16:
        com.bytedance.android.shopping.deepfeed.weights.c r7 = (com.bytedance.android.shopping.deepfeed.weights.c) r6;
        if (r7 == null) goto L21;
        ECVideoPlayerView r8 = r7.getVideoPlayerView();
        if (r8 == null) goto L21;
        r8.x();
    L21:
        View r9 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r9 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == false) goto L25;
        r0 = r9;
    L25:
        com.bytedance.android.shopping.deepfeed.weights.c r2 = (com.bytedance.android.shopping.deepfeed.weights.c) r0;
        if (r2 == null) goto L34;
        ImageView r10 = r2.getVideoPauseIcon();
        if (r10 == null) goto L35;
        r10.setVisibility(8);
        return;
    L35:
        return;
    }

    public DeepFeedProductBannerVideoVH(com.bytedance.android.shopping.deepfeed.weights.c r2, LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "owner");
        super(r2);
        r3.getLifecycle().addObserver(this);
    }
}
