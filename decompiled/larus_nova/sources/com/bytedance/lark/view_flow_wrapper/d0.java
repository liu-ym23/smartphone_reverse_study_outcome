package com.bytedance.lark.view_flow_wrapper;

import com.vivo.push.PushClientConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class d0 implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f254426a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f254426a, ((d0) r100).f254426a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f254426a.hashCode();
    }

    public final String toString() {
        return "ViewFlowServiceClosedInfo(className=" + this.f254426a + ')';
    }

    public d0(String r100) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        this.f254426a = r100;
    }
}
