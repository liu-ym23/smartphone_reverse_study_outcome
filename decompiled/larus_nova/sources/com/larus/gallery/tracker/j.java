package com.larus.gallery.tracker;

import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes29.dex */
public final class j implements ThumbnailTrackerLayoutManager.b {
    public j() {
    }

    @Override // com.larus.gallery.tracker.ThumbnailTrackerLayoutManager.b
    public final void a(View r100, int r101, float r102) {
        float r103 = ((r101 * 0.3f) * r102) / 2.0f;
        float r104 = (1 + 0.3f) - (Math.abs(r102) * 0.3f);
        r100.setScaleX(r104);
        View r105 = r100.findViewById(R.id.content);
        if (r105 == null) goto L5;
        r105.setScaleY(r104);
    L5:
        r100.setTranslationX(r103);
        r100.invalidate();
    }
}
