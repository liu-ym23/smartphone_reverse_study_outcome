package ica;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f489265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f489266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f489267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f489268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f489269e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f489265a, r101.f489265a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f489266b, r101.f489266b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f489267c, r101.f489267c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f489268d, r101.f489268d) == true) goto L21;
        return false;
    L21:
        if (this.f489269e == r101.f489269e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f489265a.hashCode() * 31) + this.f489266b.hashCode()) * 31) + this.f489267c.hashCode()) * 31) + this.f489268d.hashCode()) * 31;
        long r101 = this.f489269e;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "CameraAutoSendPayload(requestId=" + this.f489265a + ", text=" + this.f489266b + ", imagePath=" + this.f489267c + ", callerPackage=" + this.f489268d + ", createTime=" + this.f489269e + ')';
    }

    public final void a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Boolean.valueOf(new PolarisFileWrapper(this.f489267c).delete()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public a(String r100, String r101, String r102, String r103) {
        long r104 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r100, "requestId");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "imagePath");
        Intrinsics.checkNotNullParameter(r103, "callerPackage");
        this.f489265a = r100;
        this.f489266b = r101;
        this.f489267c = r102;
        this.f489268d = r103;
        this.f489269e = r104;
    }
}
