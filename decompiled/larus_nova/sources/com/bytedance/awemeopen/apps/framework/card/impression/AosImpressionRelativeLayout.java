package com.bytedance.awemeopen.apps.framework.card.impression;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import cy3.d;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AosImpressionRelativeLayout extends RelativeLayout {
    public abstract void a(boolean r100);

    public AosImpressionRelativeLayout(Context r100) {
        super(r100);
        new a(this, new d(this));
    }

    public AosImpressionRelativeLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        new a(this, new d(this));
    }

    public AosImpressionRelativeLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        new a(this, new d(this));
    }
}
