package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/relax/relaxframework/ListEventSnapDetail;", "", "position", "", "currentScrollLeft", "", "currentScrollTop", "targetScrollLeft", "targetScrollTop", "(IDDDD)V", "getCurrentScrollLeft", "()D", "setCurrentScrollLeft", "(D)V", "getCurrentScrollTop", "setCurrentScrollTop", "getPosition", "()I", "setPosition", "(I)V", "getTargetScrollLeft", "setTargetScrollLeft", "getTargetScrollTop", "setTargetScrollTop", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ListEventSnapDetail {
    private double currentScrollLeft;
    private double currentScrollTop;
    private int position;
    private double targetScrollLeft;
    private double targetScrollTop;

    public final double getCurrentScrollLeft() {
        return this.currentScrollLeft;
    }

    public final double getCurrentScrollTop() {
        return this.currentScrollTop;
    }

    public final int getPosition() {
        return this.position;
    }

    public final double getTargetScrollLeft() {
        return this.targetScrollLeft;
    }

    public final double getTargetScrollTop() {
        return this.targetScrollTop;
    }

    public final void setCurrentScrollLeft(double r100) {
        this.currentScrollLeft = r100;
    }

    public final void setCurrentScrollTop(double r100) {
        this.currentScrollTop = r100;
    }

    public final void setPosition(int r100) {
        this.position = r100;
    }

    public final void setTargetScrollLeft(double r100) {
        this.targetScrollLeft = r100;
    }

    public final void setTargetScrollTop(double r100) {
        this.targetScrollTop = r100;
    }

    public ListEventSnapDetail(int r100, double r101, double r102, double r103, double r104) {
        this.position = r100;
        this.currentScrollLeft = r101;
        this.currentScrollTop = r102;
        this.targetScrollLeft = r103;
        this.targetScrollTop = r104;
    }
}
