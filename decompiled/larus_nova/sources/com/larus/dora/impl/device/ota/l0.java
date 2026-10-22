package com.larus.dora.impl.device.ota;

import com.bytedance.ee.plugin.common.ttreader.ITTReaderViewWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f334217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f334218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f334219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f334220d;

    public l0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r101 = (l0) r100;
        if (this.f334217a == r101.f334217a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f334218b, r101.f334218b) == true) goto L15;
        return false;
    L15:
        if (this.f334219c == r101.f334219c) goto L18;
        return false;
    L18:
        if (this.f334220d == r101.f334220d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f334217a * 31) + this.f334218b.hashCode()) * 31) + this.f334219c) * 31) + this.f334220d;
    }

    public final String toString() {
        return "Property(errcode=" + this.f334217a + ", errmsg=" + this.f334218b + ", retryCount=" + this.f334219c + ", status=" + this.f334220d + ')';
    }

    public l0(int r100) {
        int r101 = EventTypeOTAErrorCode.SUCCESS.getCode();
        Intrinsics.checkNotNullParameter("", ITTReaderViewWrapper.ERROR_MSG_KEY);
        this.f334217a = 0;
        this.f334218b = "";
        this.f334219c = 0;
        this.f334220d = r101;
    }
}
