package com.bytedance.lark.view_flow_wrapper;

import com.vivo.push.PushClientConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* JADX INFO: loaded from: classes20.dex */
public final class s implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f254456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f254457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f254458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f254459d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f254456a, r101.f254456a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f254457b, r101.f254457b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f254458c, r101.f254458c) == true) goto L18;
        return false;
    L18:
        if (Duration.m10798equalsimpl0(this.f254459d, r101.f254459d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f254456a.hashCode() * 31) + this.f254457b.hashCode()) * 31) + this.f254458c.hashCode()) * 31) + Duration.m10821hashCodeimpl(this.f254459d);
    }

    public final String toString() {
        return "SubscriptionCalledInfo(className=" + this.f254456a + ", subscriptionName=" + this.f254457b + ", type=" + this.f254458c + ", interval=" + Duration.m10842toStringimpl(this.f254459d) + ')';
    }

    public final u getType() {
        return this.f254458c;
    }

    public s(String r100, String r101, u r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        Intrinsics.checkNotNullParameter(r101, "subscriptionName");
        Intrinsics.checkNotNullParameter(r102, "type");
        this.f254456a = r100;
        this.f254457b = r101;
        this.f254458c = r102;
        this.f254459d = r103;
    }
}
