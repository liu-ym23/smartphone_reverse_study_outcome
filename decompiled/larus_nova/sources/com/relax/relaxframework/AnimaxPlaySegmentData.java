package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/AnimaxPlaySegmentData;", "", "startFrame", "", "endFrame", "(II)V", "getEndFrame", "()I", "setEndFrame", "(I)V", "getStartFrame", "setStartFrame", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AnimaxPlaySegmentData {
    private int endFrame;
    private int startFrame;

    public final int getEndFrame() {
        return this.endFrame;
    }

    public final int getStartFrame() {
        return this.startFrame;
    }

    public final void setEndFrame(int r100) {
        this.endFrame = r100;
    }

    public final void setStartFrame(int r100) {
        this.startFrame = r100;
    }

    public AnimaxPlaySegmentData(int r100, int r101) {
        this.startFrame = r100;
        this.endFrame = r101;
    }
}
