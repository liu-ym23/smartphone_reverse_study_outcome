package com.bytedance.lark.view_flow_wrapper;

import com.vivo.push.PushClientConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class e0 implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f254427a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f254427a, ((e0) r100).f254427a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f254427a.hashCode();
    }

    public final String toString() {
        return "ViewFlowServiceCreatedInfo(className=" + this.f254427a + ')';
    }

    public e0(String r100) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        this.f254427a = r100;
    }
}
