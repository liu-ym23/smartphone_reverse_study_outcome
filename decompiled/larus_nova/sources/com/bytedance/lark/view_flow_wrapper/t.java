package com.bytedance.lark.view_flow_wrapper;

import com.vivo.push.PushClientConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* JADX INFO: loaded from: classes20.dex */
public final class t implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f254460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f254461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f254462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f254463d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f254460a, r101.f254460a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f254461b, r101.f254461b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f254462c, r101.f254462c) == true) goto L18;
        return false;
    L18:
        if (Duration.m10798equalsimpl0(this.f254463d, r101.f254463d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f254460a.hashCode() * 31) + this.f254461b.hashCode()) * 31) + this.f254462c.hashCode()) * 31) + Duration.m10821hashCodeimpl(this.f254463d);
    }

    public final String toString() {
        return "SubscriptionReceivedInfo(className=" + this.f254460a + ", subscriptionName=" + this.f254461b + ", type=" + this.f254462c + ", interval=" + Duration.m10842toStringimpl(this.f254463d) + ')';
    }

    public final u getType() {
        return this.f254462c;
    }

    public t(String r100, String r101, u r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        Intrinsics.checkNotNullParameter(r101, "subscriptionName");
        Intrinsics.checkNotNullParameter(r102, "type");
        this.f254460a = r100;
        this.f254461b = r101;
        this.f254462c = r102;
        this.f254463d = r103;
    }
}
