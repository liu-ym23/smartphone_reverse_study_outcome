package com.bytedance.awemeopen.apps.framework.card.impression;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import cy3.c;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AosImpressionLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f193831a = 0;

    public abstract void a();

    public AosImpressionLinearLayout(Context r100) {
        super(r100);
        new a(this, new c(this));
    }

    public AosImpressionLinearLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        new a(this, new c(this));
    }

    public AosImpressionLinearLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        new a(this, new c(this));
    }
}
