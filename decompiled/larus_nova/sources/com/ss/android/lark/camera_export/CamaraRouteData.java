package com.ss.android.lark.camera_export;

import android.content.Intent;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.suite.lark.component.navroute.api.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/camera_export/CamaraRouteData;", "", "intent", "Landroid/content/Intent;", PrefetchTiming.ROUTER, "Lcom/suite/lark/component/navroute/api/NavRouteDirection;", "<init>", "(Landroid/content/Intent;Lcom/suite/lark/component/navroute/api/NavRouteDirection;)V", "getIntent", "()Landroid/content/Intent;", "getRouter", "()Lcom/suite/lark/component/navroute/api/NavRouteDirection;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lark-camera-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CamaraRouteData {
    private final Intent intent;
    private final c<?> router;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CamaraRouteData copy$default(CamaraRouteData r100, Intent r101, c r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.intent;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.router;
    L9:
        return r100.copy(r101, r102);
    }

    public final Intent component1() {
        return this.intent;
    }

    public final c<?> component2() {
        return this.router;
    }

    public final CamaraRouteData copy(Intent r100, c<?> r101) {
        return new CamaraRouteData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CamaraRouteData) == true) goto L8;
        return false;
    L8:
        CamaraRouteData r101 = (CamaraRouteData) r100;
        if (Intrinsics.areEqual(this.intent, r101.intent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.router, r101.router) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Intent r100 = this.intent;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        c<?> r104 = this.router;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CamaraRouteData(intent=" + this.intent + ", router=" + this.router + ')';
    }

    public final Intent getIntent() {
        return this.intent;
    }

    public final c<?> getRouter() {
        return this.router;
    }

    public CamaraRouteData(Intent r100, c<?> r101) {
        this.intent = r100;
        this.router = r101;
    }
}
