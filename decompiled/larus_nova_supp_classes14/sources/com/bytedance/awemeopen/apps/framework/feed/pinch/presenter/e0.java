package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e0 extends a {
    public e0(View r4) {
        Intrinsics.checkNotNullParameter(r4, "v");
        super(r4);
        this.h.add(new PinchViewImagePresenter(r4));
        this.h.add(new g0(r4));
        this.h.add(new PinchButtonBarGroupPresenter(r4, r4.findViewById(2131364998)));
        this.h.add(new PinchVideoScaleRestorePresenter(r4, (ViewGroup) r4.findViewById(2131361956)));
        this.h.add(new p(r4, (ViewGroup) r4.findViewById(2131372162)));
    }
}
