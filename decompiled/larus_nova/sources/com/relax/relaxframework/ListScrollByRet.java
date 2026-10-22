package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/relax/relaxframework/ListScrollByRet;", "", "consumedX", "", "consumedY", "unconsumedX", "unconsumedY", "(DDDD)V", "getConsumedX", "()D", "setConsumedX", "(D)V", "getConsumedY", "setConsumedY", "getUnconsumedX", "setUnconsumedX", "getUnconsumedY", "setUnconsumedY", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ListScrollByRet {
    private double consumedX;
    private double consumedY;
    private double unconsumedX;
    private double unconsumedY;

    public final double getConsumedX() {
        return this.consumedX;
    }

    public final double getConsumedY() {
        return this.consumedY;
    }

    public final double getUnconsumedX() {
        return this.unconsumedX;
    }

    public final double getUnconsumedY() {
        return this.unconsumedY;
    }

    public final void setConsumedX(double r100) {
        this.consumedX = r100;
    }

    public final void setConsumedY(double r100) {
        this.consumedY = r100;
    }

    public final void setUnconsumedX(double r100) {
        this.unconsumedX = r100;
    }

    public final void setUnconsumedY(double r100) {
        this.unconsumedY = r100;
    }

    public ListScrollByRet(double r100, double r101, double r102, double r103) {
        this.consumedX = r100;
        this.consumedY = r101;
        this.unconsumedX = r102;
        this.unconsumedY = r103;
    }
}
