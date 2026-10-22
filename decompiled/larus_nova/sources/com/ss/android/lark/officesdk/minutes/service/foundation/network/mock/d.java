package com.ss.android.lark.officesdk.minutes.service.foundation.network.mock;

import com.squareup.wire.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f433947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f433948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f433949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Message<?, ?> f433950d;

    public d() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f433947a, r101.f433947a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f433948b, r101.f433948b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f433949c, r101.f433949c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f433950d, r101.f433950d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f433947a.hashCode() * 31) + this.f433948b.hashCode()) * 31;
        c r101 = this.f433949c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Message<?, ?> r105 = this.f433950d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmMockRequestContext(type=" + this.f433947a + ", key=" + this.f433948b + ", http=" + this.f433949c + ", pbInput=" + this.f433950d + ')';
    }

    public final String getType() {
        return this.f433947a;
    }

    public d(String r100, String r101, c r102, Message r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "key");
        this.f433947a = r100;
        this.f433948b = r101;
        this.f433949c = r102;
        this.f433950d = r103;
    }
}
