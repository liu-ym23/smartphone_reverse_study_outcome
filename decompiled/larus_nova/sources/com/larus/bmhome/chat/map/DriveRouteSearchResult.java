package com.larus.bmhome.chat.map;

import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/map/DriveRouteSearchResult;", "", CloudControlInf.ROUTE, "Lcom/larus/bmhome/chat/map/DriveRoute;", "<init>", "(Lcom/larus/bmhome/chat/map/DriveRoute;)V", "getRoute", "()Lcom/larus/bmhome/chat/map/DriveRoute;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveRouteSearchResult {
    private final DriveRoute route;

    public static /* synthetic */ DriveRouteSearchResult copy$default(DriveRouteSearchResult r100, DriveRoute r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.route;
    L6:
        return r100.copy(r101);
    }

    public final DriveRoute component1() {
        return this.route;
    }

    public final DriveRouteSearchResult copy(DriveRoute r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
        return new DriveRouteSearchResult(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DriveRouteSearchResult) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.route, ((DriveRouteSearchResult) r100).route) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.route.hashCode();
    }

    public String toString() {
        return "DriveRouteSearchResult(route=" + this.route + ')';
    }

    public final DriveRoute getRoute() {
        return this.route;
    }

    public DriveRouteSearchResult(DriveRoute r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
        this.route = r100;
    }
}
