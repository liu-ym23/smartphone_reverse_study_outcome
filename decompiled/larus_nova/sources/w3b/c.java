package w3b;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c<S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d<S> f558219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super Result<? extends S>, Unit> f558220c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f558218a, r101.f558218a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558219b, r101.f558219b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f558220c, r101.f558220c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f558218a.hashCode() * 31) + this.f558219b.hashCode()) * 31;
        Function1<? super Result<? extends S>, Unit> r101 = this.f558220c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DataPreloaderJob(taskKey=" + this.f558218a + ", task=" + this.f558219b + ", callback=" + this.f558220c + ')';
    }

    public c(String r100, d<S> r101, Function1<? super Result<? extends S>, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "taskKey");
        Intrinsics.checkNotNullParameter(r101, "task");
        this.f558218a = r100;
        this.f558219b = r101;
        this.f558220c = r102;
    }
}
