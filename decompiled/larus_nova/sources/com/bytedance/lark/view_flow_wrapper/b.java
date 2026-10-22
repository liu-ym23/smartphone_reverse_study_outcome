package com.bytedance.lark.view_flow_wrapper;

import com.vivo.push.PushClientConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* JADX INFO: loaded from: classes20.dex */
public final class b implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f254413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f254414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f254415c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f254413a, r101.f254413a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f254414b, r101.f254414b) == true) goto L15;
        return false;
    L15:
        if (Duration.m10798equalsimpl0(this.f254415c, r101.f254415c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f254413a.hashCode() * 31;
        String r101 = this.f254414b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + Duration.m10821hashCodeimpl(this.f254415c);
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ActionCallbackReceivedInfo(className=" + this.f254413a + ", actionName=" + this.f254414b + ", interval=" + Duration.m10842toStringimpl(this.f254415c) + ')';
    }

    public b(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        this.f254413a = r100;
        this.f254414b = r101;
        this.f254415c = r102;
    }
}
