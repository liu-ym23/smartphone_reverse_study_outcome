package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/ScrollViewEventContentSizeChangedDetail;", "", "scrollHeight", "", "scrollWidth", "(DD)V", "getScrollHeight", "()D", "setScrollHeight", "(D)V", "getScrollWidth", "setScrollWidth", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ScrollViewEventContentSizeChangedDetail {
    private double scrollHeight;
    private double scrollWidth;

    public final double getScrollHeight() {
        return this.scrollHeight;
    }

    public final double getScrollWidth() {
        return this.scrollWidth;
    }

    public final void setScrollHeight(double r100) {
        this.scrollHeight = r100;
    }

    public final void setScrollWidth(double r100) {
        this.scrollWidth = r100;
    }

    public ScrollViewEventContentSizeChangedDetail(double r100, double r101) {
        this.scrollHeight = r100;
        this.scrollWidth = r101;
    }
}
