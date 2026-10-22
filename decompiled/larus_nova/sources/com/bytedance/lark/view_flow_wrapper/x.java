package com.bytedance.lark.view_flow_wrapper;

import com.vivo.push.PushClientConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class x implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f254471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f254472b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f254471a, r101.f254471a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f254472b, r101.f254472b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f254471a.hashCode() * 31) + this.f254472b.hashCode();
    }

    public final String toString() {
        return "ViewFlowAccessFailedInfo(className=" + this.f254471a + ", exception=" + this.f254472b + ')';
    }

    public x(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        this.f254471a = r100;
        this.f254472b = r101;
    }
}
