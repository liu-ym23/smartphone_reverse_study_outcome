package com.larus.bmhome.rc;

import com.larus.platform.model.upload.ResourceUploadError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mr9.k;
import mr9.l;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<l, Unit> f313552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<k, Unit> f313553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<ResourceUploadError, Unit> f313554c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f313552a, r101.f313552a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313553b, r101.f313553b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f313554c, r101.f313554c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f313552a.hashCode() * 31) + this.f313553b.hashCode()) * 31) + this.f313554c.hashCode();
    }

    public final String toString() {
        return "BizResourceUploadCallback(notifySuccess=" + this.f313552a + ", notifyProgress=" + this.f313553b + ", notifyFailed=" + this.f313554c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super l, Unit> r100, Function1<? super k, Unit> r101, Function1<? super ResourceUploadError, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "notifySuccess");
        Intrinsics.checkNotNullParameter(r101, "notifyProgress");
        Intrinsics.checkNotNullParameter(r102, "notifyFailed");
        this.f313552a = r100;
        this.f313553b = r101;
        this.f313554c = r102;
    }
}
