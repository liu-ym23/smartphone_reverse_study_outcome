package com.ss.android.lark.officesdk.minutes.service.foundation.network.core.error;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpErrorMsg;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmHttpErrorMsg f433923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f433924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f433925c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f433923a, r101.f433923a) == true) goto L12;
        return false;
    L12:
        if (this.f433924b == r101.f433924b) goto L15;
        return false;
    L15:
        if (this.f433925c == r101.f433925c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        MmHttpErrorMsg r100 = this.f433923a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        int r103 = 1231;
        if (this.f433924b == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f433925c == true) goto L15;
        r103 = 1237;
    L15:
        return r105 + r103;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmHttpCommonErrorProcessResult(commonError=" + this.f433923a + ", displayed=" + this.f433924b + ", suppressLocalFallback=" + this.f433925c + ')';
    }

    public b(MmHttpErrorMsg r100, boolean r101, boolean r102) {
        this.f433923a = r100;
        this.f433924b = r101;
        this.f433925c = r102;
    }
}
