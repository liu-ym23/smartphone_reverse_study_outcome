package com.relax.relaxframework;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0019\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/relax/relaxframework/TouchEventDetailTouches;", "", LocationMonitorConst.IDENTIFIER, "", "x", "", "y", "clientX", "clientY", "pageX", "pageY", "(IDDDDDD)V", "getClientX", "()D", "setClientX", "(D)V", "getClientY", "setClientY", "getIdentifier", "()I", "setIdentifier", "(I)V", "getPageX", "setPageX", "getPageY", "setPageY", "getX", "setX", "getY", "setY", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TouchEventDetailTouches {
    private double clientX;
    private double clientY;
    private int identifier;
    private double pageX;
    private double pageY;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private double f404978x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private double f404979y;

    public final double getClientX() {
        return this.clientX;
    }

    public final double getClientY() {
        return this.clientY;
    }

    public final int getIdentifier() {
        return this.identifier;
    }

    public final double getPageX() {
        return this.pageX;
    }

    public final double getPageY() {
        return this.pageY;
    }

    public final double getX() {
        return this.f404978x;
    }

    public final double getY() {
        return this.f404979y;
    }

    public final void setClientX(double r100) {
        this.clientX = r100;
    }

    public final void setClientY(double r100) {
        this.clientY = r100;
    }

    public final void setIdentifier(int r100) {
        this.identifier = r100;
    }

    public final void setPageX(double r100) {
        this.pageX = r100;
    }

    public final void setPageY(double r100) {
        this.pageY = r100;
    }

    public final void setX(double r100) {
        this.f404978x = r100;
    }

    public final void setY(double r100) {
        this.f404979y = r100;
    }

    public TouchEventDetailTouches(int r100, double r101, double r102, double r103, double r104, double r110, double r111) {
        this.identifier = r100;
        this.f404978x = r101;
        this.f404979y = r102;
        this.clientX = r103;
        this.clientY = r104;
        this.pageX = r110;
        this.pageY = r111;
    }
}
