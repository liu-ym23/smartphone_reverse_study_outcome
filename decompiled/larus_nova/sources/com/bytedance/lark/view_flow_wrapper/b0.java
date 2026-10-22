package com.bytedance.lark.view_flow_wrapper;

import com.vivo.push.PushClientConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b0 implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f254416a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f254416a, ((b0) r100).f254416a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f254416a.hashCode();
    }

    public final String toString() {
        return "ViewFlowCreatedInfo(className=" + this.f254416a + ')';
    }

    public b0(String r100) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        this.f254416a = r100;
    }
}
