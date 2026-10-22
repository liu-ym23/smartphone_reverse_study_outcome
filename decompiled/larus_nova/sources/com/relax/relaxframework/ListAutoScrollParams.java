package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/relax/relaxframework/ListAutoScrollParams;", "", "start", "", "rate", "", "autoStop", "(ZDZ)V", "getAutoStop", "()Z", "setAutoStop", "(Z)V", "getRate", "()D", "setRate", "(D)V", "getStart", "setStart", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ListAutoScrollParams {
    private boolean autoStop;
    private double rate;
    private boolean start;

    public final boolean getAutoStop() {
        return this.autoStop;
    }

    public final double getRate() {
        return this.rate;
    }

    public final boolean getStart() {
        return this.start;
    }

    public final void setAutoStop(boolean r100) {
        this.autoStop = r100;
    }

    public final void setRate(double r100) {
        this.rate = r100;
    }

    public final void setStart(boolean r100) {
        this.start = r100;
    }

    public ListAutoScrollParams(boolean r100, double r101, boolean r102) {
        this.start = r100;
        this.rate = r101;
        this.autoStop = r102;
    }
}
