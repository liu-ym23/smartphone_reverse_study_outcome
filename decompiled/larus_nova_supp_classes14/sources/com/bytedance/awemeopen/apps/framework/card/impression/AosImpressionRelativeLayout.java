package com.bytedance.awemeopen.apps.framework.card.impression;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import cy3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class AosImpressionRelativeLayout extends RelativeLayout {
    public abstract void a(boolean r1);

    public AosImpressionRelativeLayout(Context r2) {
        super(r2);
        new a(this, new d(this));
    }

    public AosImpressionRelativeLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        new a(this, new d(this));
    }

    public AosImpressionRelativeLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        new a(this, new d(this));
    }
}
