package com.bytedance.lark.view_flow_wrapper;

import com.vivo.push.PushClientConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class o implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f254449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f254450b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f254449a, r101.f254449a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f254450b, r101.f254450b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f254449a.hashCode() * 31) + this.f254450b.hashCode();
    }

    public final String toString() {
        return "MoltenModuleClosedInfo(className=" + this.f254449a + ", type=" + this.f254450b + ')';
    }

    public final String getType() {
        return this.f254450b;
    }

    public o(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f254449a = r100;
        this.f254450b = r101;
    }
}
