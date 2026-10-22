package ub0;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f549328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f549329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.bytedance.component.lyric.model.b> f549330c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (this.f549328a == r101.f549328a) goto L8;
        return false;
    L8:
        if (this.f549329b == r101.f549329b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f549330c, r101.f549330c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f549328a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f549329b) * 31;
        List<com.bytedance.component.lyric.model.b> r102 = this.f549330c;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public final String toString() {
        return "LyricsParseResult(mId=" + this.f549328a + ", type=" + this.f549329b + ", info=" + this.f549330c + ")";
    }

    public final int getType() {
        return this.f549329b;
    }

    public d(long r100, int r101, List<com.bytedance.component.lyric.model.b> r102) {
        Intrinsics.checkNotNullParameter(r102, "info");
        this.f549328a = r100;
        this.f549329b = r101;
        this.f549330c = r102;
    }
}
