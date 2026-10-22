package com.bytedance.lark.view_flow_wrapper;

import com.vivo.push.PushClientConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* JADX INFO: loaded from: classes20.dex */
public final class c implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f254417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f254418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f254419c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f254417a, r101.f254417a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f254418b, r101.f254418b) == true) goto L15;
        return false;
    L15:
        if (Duration.m10798equalsimpl0(this.f254419c, r101.f254419c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f254417a.hashCode() * 31;
        String r101 = this.f254418b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + Duration.m10821hashCodeimpl(this.f254419c);
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ActionCalledInfo(className=" + this.f254417a + ", actionName=" + this.f254418b + ", interval=" + Duration.m10842toStringimpl(this.f254419c) + ')';
    }

    public c(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        this.f254417a = r100;
        this.f254418b = r101;
        this.f254419c = r102;
    }
}
