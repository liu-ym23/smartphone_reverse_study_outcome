package com.larksuite.framework.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes24.dex */
public class ObservedScrollView extends ScrollView {

    public interface a {
    }

    public void setOnScrollListener(a r100) {
    }

    public ObservedScrollView(Context r100) {
        super(r100);
    }

    public ObservedScrollView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public ObservedScrollView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    @Override // android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
    }
}
