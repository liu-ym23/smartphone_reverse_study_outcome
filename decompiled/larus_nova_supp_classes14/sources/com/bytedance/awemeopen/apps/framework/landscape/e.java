package com.bytedance.awemeopen.apps.framework.landscape;

import android.view.ViewGroup;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.VideoFeedPlayerPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public final ViewGroup a;
    public final VideoFeedPlayerPresenter b;
    public boolean c;

    public e(ViewGroup r2, VideoFeedPlayerPresenter r3) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "playerPresenter");
        this.a = r2;
        this.b = r3;
    }
}
