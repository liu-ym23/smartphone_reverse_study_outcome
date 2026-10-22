package com.larksuite.component.card.action;

import com.larksuite.component.card.monitor.UniversalCardMonitorData;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dz7.b f283196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dz7.a f283197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f283198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Object> f283199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final UniversalCardMonitorData f283200e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f283196a, r101.f283196a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f283197b, r101.f283197b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f283198c, r101.f283198c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f283199d, r101.f283199d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f283200e, r101.f283200e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f283196a.hashCode() * 31) + this.f283197b.hashCode()) * 31) + this.f283198c.hashCode()) * 31;
        HashMap<String, Object> r101 = this.f283199d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f283200e.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "UniversalCardActionRequestEntity(cardActionRequestParams=" + this.f283196a + ", cardActionContext=" + this.f283197b + ", callbackEventName=" + this.f283198c + ", sendLynxParams=" + this.f283199d + ", monitorData=" + this.f283200e + ')';
    }

    public f(dz7.b r100, dz7.a r101, HashMap r102, UniversalCardMonitorData r103) {
        Intrinsics.checkNotNullParameter(r100, "cardActionRequestParams");
        Intrinsics.checkNotNullParameter(r101, "cardActionContext");
        Intrinsics.checkNotNullParameter("updateCardState", "callbackEventName");
        Intrinsics.checkNotNullParameter(r103, "monitorData");
        this.f283196a = r100;
        this.f283197b = r101;
        this.f283198c = "updateCardState";
        this.f283199d = r102;
        this.f283200e = r103;
    }
}
