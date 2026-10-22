package com.bytedance.awemeopen.apps.framework.card.impression;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AosImpressionFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f193830a = 0;

    public abstract void a();

    public AosImpressionFrameLayout(Context r100) {
        super(r100);
        new a(this, new cy3.a(this));
    }

    public AosImpressionFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        new a(this, new cy3.a(this));
    }

    public AosImpressionFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        new a(this, new cy3.a(this));
    }
}
