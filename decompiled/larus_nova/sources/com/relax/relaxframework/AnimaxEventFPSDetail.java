package com.relax.relaxframework;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/relax/relaxframework/AnimaxEventFPSDetail;", "", "fps", "", "maxDropRate", "animationID", "", "current", "total", "loopIndex", "", "(DDLjava/lang/String;DDI)V", "getAnimationID", "()Ljava/lang/String;", "setAnimationID", "(Ljava/lang/String;)V", "getCurrent", "()D", "setCurrent", "(D)V", "getFps", "setFps", "getLoopIndex", "()I", "setLoopIndex", "(I)V", "getMaxDropRate", "setMaxDropRate", "getTotal", "setTotal", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AnimaxEventFPSDetail {
    private String animationID;
    private double current;
    private double fps;
    private int loopIndex;
    private double maxDropRate;
    private double total;

    public final String getAnimationID() {
        return this.animationID;
    }

    public final double getCurrent() {
        return this.current;
    }

    public final double getFps() {
        return this.fps;
    }

    public final int getLoopIndex() {
        return this.loopIndex;
    }

    public final double getMaxDropRate() {
        return this.maxDropRate;
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

    public final void setFps(double r100) {
        this.fps = r100;
    }

    public final void setLoopIndex(int r100) {
        this.loopIndex = r100;
    }

    public final void setMaxDropRate(double r100) {
        this.maxDropRate = r100;
    }

    public final void setTotal(double r100) {
        this.total = r100;
    }

    public AnimaxEventFPSDetail(double r100, double r101, String r102, double r103, double r104, int r110) {
        Intrinsics.checkNotNullParameter(r102, "animationID");
        this.fps = r100;
        this.maxDropRate = r101;
        this.animationID = r102;
        this.current = r103;
        this.total = r104;
        this.loopIndex = r110;
    }
}
