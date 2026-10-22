package com.bytedance.applet.aibridge;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/applet/aibridge/NaviPoi;", "", "name", "", "lng", "", "lat", "<init>", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)V", "getName", "()Ljava/lang/String;", "getLng", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLat", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)Lcom/bytedance/applet/aibridge/NaviPoi;", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NaviPoi {
    private final Double lat;
    private final Double lng;
    private final String name;

    public static /* synthetic */ NaviPoi copy$default(NaviPoi r0, String r1, Double r2, Double r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.name;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.lng;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.lat;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.name;
    }

    public final Double component2() {
        return this.lng;
    }

    public final Double component3() {
        return this.lat;
    }

    public final NaviPoi copy(String r2, Double r3, Double r4) {
        return new NaviPoi(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof NaviPoi) == true) goto L8;
        return false;
    L8:
        NaviPoi r6 = (NaviPoi) r5;
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lng, r6.lng) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lat, r6.lat) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Double r4 = this.lng;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Double r7 = this.lat;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "NaviPoi(name=" + this.name + ", lng=" + this.lng + ", lat=" + this.lat + ')';
    }

    public final Double getLat() {
        return this.lat;
    }

    public final Double getLng() {
        return this.lng;
    }

    public final String getName() {
        return this.name;
    }

    public NaviPoi(String r1, Double r2, Double r3) {
        this.name = r1;
        this.lng = r2;
        this.lat = r3;
    }
}
