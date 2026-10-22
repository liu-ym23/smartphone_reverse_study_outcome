package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/relax/relaxframework/ViewPagerSetTabParams;", "", "index", "", "smooth", "", "(IZ)V", "getIndex", "()I", "setIndex", "(I)V", "getSmooth", "()Z", "setSmooth", "(Z)V", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ViewPagerSetTabParams {
    private int index;
    private boolean smooth;

    public final int getIndex() {
        return this.index;
    }

    public final boolean getSmooth() {
        return this.smooth;
    }

    public final void setIndex(int r100) {
        this.index = r100;
    }

    public final void setSmooth(boolean r100) {
        this.smooth = r100;
    }

    public ViewPagerSetTabParams(int r100, boolean r101) {
        this.index = r100;
        this.smooth = r101;
    }
}
