package com.bytedance.ee.bear.drive.core.thumbnail;

import android.view.View;
import com.larus.nova.R;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements ThumbnailTrackerLayoutManager.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f224370a;

    public e(b r100) {
        this.f224370a = r100;
    }

    @Override // com.bytedance.ee.bear.drive.core.thumbnail.ThumbnailTrackerLayoutManager.b
    public final void transformItem(View r100, float r101) {
        float r102 = ((1.0f - RangesKt.coerceIn(Math.abs(r101), 0.0f, 1.0f)) * 0.29999995f) + 1.0f;
        r100.setScaleX(r102);
        View r103 = r100.findViewById(R.id.drive_thumbnail_content);
        if (r103 == null) goto L5;
        r103.setScaleY(r102);
    L5:
        r100.setTranslationX(this.f224370a.f224364g * r101);
    }
}
