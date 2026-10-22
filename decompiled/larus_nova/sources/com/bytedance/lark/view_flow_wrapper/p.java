package com.bytedance.lark.view_flow_wrapper;

import com.vivo.push.PushClientConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class p implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f254451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f254452b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f254451a, r101.f254451a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f254452b, r101.f254452b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f254451a.hashCode() * 31) + this.f254452b.hashCode();
    }

    public final String toString() {
        return "MoltenModuleCreatedInfo(className=" + this.f254451a + ", type=" + this.f254452b + ')';
    }

    public final String getType() {
        return this.f254452b;
    }

    public p(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f254451a = r100;
        this.f254452b = r101;
    }
}
