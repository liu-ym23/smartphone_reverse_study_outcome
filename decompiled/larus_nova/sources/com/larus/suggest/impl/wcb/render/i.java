package com.larus.suggest.impl.wcb.render;

import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.bmhome.chat.bean.WcbRenderStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f370049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NexPulseResponseData f370050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f370051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f370052d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f370049a == r101.f370049a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f370050b, r101.f370050b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f370051c, r101.f370051c) == true) goto L18;
        return false;
    L18:
        if (this.f370052d == r101.f370052d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f370049a * 31) + this.f370050b.hashCode()) * 31;
        String r101 = this.f370051c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f370052d == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "WcbPresentation(scene=" + this.f370049a + ", response=" + this.f370050b + ", renderStatus=" + this.f370051c + ", isInTaskMode=" + this.f370052d + ')';
    }

    public i(int r100, NexPulseResponseData r101, @WcbRenderStatus String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "response");
        this.f370049a = r100;
        this.f370050b = r101;
        this.f370051c = r102;
        this.f370052d = r103;
    }
}
