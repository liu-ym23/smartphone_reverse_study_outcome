package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/relax/relaxframework/TextLineLayout;", "", "ellipsisCount", "", "end", "start", "(III)V", "getEllipsisCount", "()I", "setEllipsisCount", "(I)V", "getEnd", "setEnd", "getStart", "setStart", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextLineLayout {
    private int ellipsisCount;
    private int end;
    private int start;

    public final int getEllipsisCount() {
        return this.ellipsisCount;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getStart() {
        return this.start;
    }

    public final void setEllipsisCount(int r100) {
        this.ellipsisCount = r100;
    }

    public final void setEnd(int r100) {
        this.end = r100;
    }

    public final void setStart(int r100) {
        this.start = r100;
    }

    public TextLineLayout(int r100, int r101, int r102) {
        this.ellipsisCount = r100;
        this.end = r101;
        this.start = r102;
    }
}
