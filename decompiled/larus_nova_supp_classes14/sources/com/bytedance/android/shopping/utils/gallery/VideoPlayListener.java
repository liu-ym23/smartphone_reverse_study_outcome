package com.bytedance.android.shopping.utils.gallery;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.shopping.anchorv3.detail.widget.VideoHolder;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/utils/gallery/VideoPlayListener;", "Landroidx/lifecycle/LifecycleObserver;", "", "pauseVideo", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoPlayListener implements LifecycleObserver {
    public final VideoHolder a;

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void pauseVideo() {
        VideoHolder r0 = this.a;
        if (r0 == null) goto L8;
        PlayerBlock r1 = r0.g;
        if (r1 == null) goto L9;
        int r2 = PlayerBlock.T;
        r1.C(false);
        return;
    L9:
        return;
    }

    public VideoPlayListener(VideoHolder r1) {
        this.a = r1;
    }
}
