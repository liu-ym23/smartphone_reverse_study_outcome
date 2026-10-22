package com.ss.android.ugc.aweme.live.alphaplayer;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/live/alphaplayer/TouchEvent;", "", "alpha_player_release"}, k = 1, mv = {1, 4, 0})
public final class TouchEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f451057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f451058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f451059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f451060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f451061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f451062f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TouchEvent) == false) goto L14;
        TouchEvent r101 = (TouchEvent) r100;
        if (this.f451059c == r101.f451059c) goto L8;
        return false;
    L8:
        if (this.f451060d == r101.f451060d) goto L10;
        return false;
    L10:
        if (this.f451061e == r101.f451061e) goto L12;
        return false;
    L12:
        if (this.f451062f == r101.f451062f) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f451059c * 31) + this.f451060d) * 31) + this.f451061e) * 31) + this.f451062f;
    }

    public final String toString() {
        return "TouchEvent(x=" + this.f451059c + ", y=" + this.f451060d + ", width=" + this.f451061e + ", height=" + this.f451062f + ")";
    }

    public TouchEvent(int r100, int r101, int r102, int r110) {
        this.f451059c = r100;
        this.f451060d = r101;
        this.f451061e = r102;
        this.f451062f = r110;
        double r103 = 2;
        this.f451057a = (((double) (r100 / r102)) - 0.5d) * r103;
        this.f451058b = (((double) (1 - (r101 / r110))) - 0.5d) * r103;
    }
}
