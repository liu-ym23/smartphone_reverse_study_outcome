package com.larksuite.component.card.service;

import androidx.lifecycle.Lifecycle;
import com.larksuite.component.card.service.bridge.CardBridgeService;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lifecycle f283929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ILarkLynxContainer f283930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larksuite.component.card.service.bridge.a f283931c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f283929a, r101.f283929a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f283930b, r101.f283930b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f283931c, r101.f283931c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Lifecycle r100 = this.f283929a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ILarkLynxContainer r104 = this.f283930b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.f283931c.hashCode();
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CardServiceContext(lifecycle=" + this.f283929a + ", lynxContainer=" + this.f283930b + ", bridgeService=" + this.f283931c + ')';
    }

    public b(Lifecycle r100, ILarkLynxContainer r101, CardBridgeService r102) {
        Intrinsics.checkNotNullParameter(r102, "bridgeService");
        this.f283929a = r100;
        this.f283930b = r101;
        this.f283931c = r102;
    }
}
