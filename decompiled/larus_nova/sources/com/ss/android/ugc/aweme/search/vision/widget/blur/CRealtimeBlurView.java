package com.ss.android.ugc.aweme.search.vision.widget.blur;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes40.dex */
public class CRealtimeBlurView extends RealtimeBlurView {
    @Override // com.ss.android.ugc.aweme.search.vision.widget.blur.RealtimeBlurView
    public View getActivityDecorView() {
        return getRootView();
    }

    public CRealtimeBlurView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
