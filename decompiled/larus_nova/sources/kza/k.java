package kza;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Continuation<? super String>, Object> f506766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Continuation<? super String>, Object> f506767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f506768c;

    public k() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f506766a, r101.f506766a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506767b, r101.f506767b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506768c, r101.f506768c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Function1<Continuation<? super String>, Object> r100 = this.f506766a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function1<Continuation<? super String>, Object> r104 = this.f506767b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        o r107 = this.f506768c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "OpenFeishuAvatarPreviewRequest(imageProvider=" + this.f506766a + ", thumbProvider=" + this.f506767b + ", securityContext=" + this.f506768c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(Function1<? super Continuation<? super String>, ? extends Object> r100, Function1<? super Continuation<? super String>, ? extends Object> r101, o r102) {
        this.f506766a = r100;
        this.f506767b = r101;
        this.f506768c = r102;
    }
}
