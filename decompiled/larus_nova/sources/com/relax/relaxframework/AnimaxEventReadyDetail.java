package com.relax.relaxframework;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/relax/relaxframework/AnimaxEventReadyDetail;", "", "animationID", "", "current", "", "total", "loopIndex", "", "elementID", "(Ljava/lang/String;DDILjava/lang/String;)V", "getAnimationID", "()Ljava/lang/String;", "setAnimationID", "(Ljava/lang/String;)V", "getCurrent", "()D", "setCurrent", "(D)V", "getElementID", "setElementID", "getLoopIndex", "()I", "setLoopIndex", "(I)V", "getTotal", "setTotal", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AnimaxEventReadyDetail {
    private String animationID;
    private double current;
    private String elementID;
    private int loopIndex;
    private double total;

    public final String getAnimationID() {
        return this.animationID;
    }

    public final double getCurrent() {
        return this.current;
    }

    public final String getElementID() {
        return this.elementID;
    }

    public final int getLoopIndex() {
        return this.loopIndex;
    }

    public final double getTotal() {
        return this.total;
    }

    public final void setAnimationID(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.animationID = r100;
    }

    public final void setCurrent(double r100) {
        this.current = r100;
    }

    public final void setElementID(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.elementID = r100;
    }

    public final void setLoopIndex(int r100) {
        this.loopIndex = r100;
    }

    public final void setTotal(double r100) {
        this.total = r100;
    }

    public AnimaxEventReadyDetail(String r100, double r101, double r102, int r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "animationID");
        Intrinsics.checkNotNullParameter(r104, "elementID");
        this.animationID = r100;
        this.current = r101;
        this.total = r102;
        this.loopIndex = r103;
        this.elementID = r104;
    }
}
