package com.ss.android.ugc.aweme.discover.lynx.delegate;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/lynx/delegate/LynxDataCenter;", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxDataCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f450471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f450472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f450473c;

    public LynxDataCenter() {
        this(-1, -1, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LynxDataCenter) == false) goto L12;
        LynxDataCenter r101 = (LynxDataCenter) r100;
        if (this.f450471a == r101.f450471a) goto L8;
        return false;
    L8:
        if (this.f450472b == r101.f450472b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f450473c, r101.f450473c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.f450471a * 31) + this.f450472b) * 31;
        String r101 = this.f450473c;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "LynxDataCenter(position=" + this.f450471a + ", sessionId=" + this.f450472b + ", scene=" + this.f450473c + ")";
    }

    public LynxDataCenter(int r100, int r101, String r102) {
        this.f450471a = r100;
        this.f450472b = r101;
        this.f450473c = r102;
    }
}
