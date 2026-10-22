package com.bytedance.ee.bear.drive.core.thumbnail;

import android.view.View;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements ThumbnailTrackerLayoutManager.b {
    public final /* synthetic */ b a;

    public e(b r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.drive.core.thumbnail.ThumbnailTrackerLayoutManager.b
    public final void transformItem(View r4, float r5) {
        float r0 = ((1.0f - RangesKt.coerceIn(Math.abs(r5), 0.0f, 1.0f)) * 0.29999995f) + 1.0f;
        r4.setScaleX(r0);
        View r1 = r4.findViewById(2131370334);
        if (r1 == null) goto L5;
        r1.setScaleY(r0);
    L5:
        r4.setTranslationX(this.a.g * r5);
    }
}
