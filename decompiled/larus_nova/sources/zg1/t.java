package zg1;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Context, Unit> f571939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Context, Unit> f571940c;

    public t() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t) == false) goto L12;
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f571938a, r101.f571938a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f571939b, r101.f571939b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f571940c, r101.f571940c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f571938a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function1<Context, Unit> r104 = this.f571939b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Function1<Context, Unit> r107 = this.f571940c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CloseLiveRoomEvent(source=" + this.f571938a + ", doBeforeClose=" + this.f571939b + ", doAfterClose=" + this.f571940c + ")";
    }

    public t(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f571938a = r100;
        this.f571939b = null;
        this.f571940c = null;
    }
}
