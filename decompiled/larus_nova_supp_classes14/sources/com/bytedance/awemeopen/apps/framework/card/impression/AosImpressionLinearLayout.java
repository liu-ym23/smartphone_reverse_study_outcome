package com.bytedance.awemeopen.apps.framework.card.impression;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import cy3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class AosImpressionLinearLayout extends LinearLayout {
    public static final /* synthetic */ int a = 0;

    public abstract void a();

    public AosImpressionLinearLayout(Context r2) {
        super(r2);
        new a(this, new c(this));
    }

    public AosImpressionLinearLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        new a(this, new c(this));
    }

    public AosImpressionLinearLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        new a(this, new c(this));
    }
}
