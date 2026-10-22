package com.bytedance.lark.view_flow_wrapper;

import com.vivo.push.PushClientConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class c0 implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f254420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f254421b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.f254420a, r101.f254420a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f254421b, r101.f254421b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f254420a.hashCode() * 31) + this.f254421b.hashCode();
    }

    public final String toString() {
        return "ViewFlowServiceAccessFailedInfo(className=" + this.f254420a + ", exception=" + this.f254421b + ')';
    }

    public c0(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        this.f254420a = r100;
        this.f254421b = r101;
    }
}
