package com.larus.bmhome.interactionpanel;

import com.larus.im.internal.protocol.bean.GeneralInteractionAskNotifyDownlinkBody;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GeneralInteractionAskNotifyDownlinkBody f312344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f312345b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f312344a, r101.f312344a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f312345b, r101.f312345b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f312344a.hashCode() * 31;
        w r101 = this.f312345b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "GeneralInteractionAskNotifyPayload(notify=" + this.f312344a + ", trackContext=" + this.f312345b + ')';
    }

    public f(GeneralInteractionAskNotifyDownlinkBody r100) {
        Intrinsics.checkNotNullParameter(r100, "notify");
        this.f312344a = r100;
        this.f312345b = null;
    }
}
