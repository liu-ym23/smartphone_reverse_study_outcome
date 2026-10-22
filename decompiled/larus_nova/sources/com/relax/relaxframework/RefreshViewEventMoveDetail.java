package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/relax/relaxframework/RefreshViewEventMoveDetail;", "", "isDragging", "", "offsetPercent", "", "(ZD)V", "()Z", "setDragging", "(Z)V", "getOffsetPercent", "()D", "setOffsetPercent", "(D)V", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RefreshViewEventMoveDetail {
    private boolean isDragging;
    private double offsetPercent;

    public final double getOffsetPercent() {
        return this.offsetPercent;
    }

    public final boolean isDragging() {
        return this.isDragging;
    }

    public final void setDragging(boolean r100) {
        this.isDragging = r100;
    }

    public final void setOffsetPercent(double r100) {
        this.offsetPercent = r100;
    }

    public RefreshViewEventMoveDetail(boolean r100, double r101) {
        this.isDragging = r100;
        this.offsetPercent = r101;
    }
}
