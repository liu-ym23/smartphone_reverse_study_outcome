package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/relax/relaxframework/ViewPagerEventChangeDetail;", "", "index", "", "isDragged", "", "(IZ)V", "getIndex", "()I", "setIndex", "(I)V", "()Z", "setDragged", "(Z)V", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ViewPagerEventChangeDetail {
    private int index;
    private boolean isDragged;

    public final int getIndex() {
        return this.index;
    }

    public final boolean isDragged() {
        return this.isDragged;
    }

    public final void setDragged(boolean r100) {
        this.isDragged = r100;
    }

    public final void setIndex(int r100) {
        this.index = r100;
    }

    public ViewPagerEventChangeDetail(int r100, boolean r101) {
        this.index = r100;
        this.isDragged = r101;
    }
}
