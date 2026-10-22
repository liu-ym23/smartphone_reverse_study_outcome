package hi6;

import com.bytedance.live.livelink.kmp.api.base.interceptor.InterceptModule;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterceptModule f485346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f485347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, Object> f485348c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L12;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f485346a, r101.f485346a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f485347b, r101.f485347b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f485348c, r101.f485348c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        InterceptModule r100 = this.f485346a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        d r104 = this.f485347b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        HashMap<String, Object> r107 = this.f485348c;
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
        return "LinkInterceptorCall(intcModule=" + this.f485346a + ", intcStep=" + this.f485347b + ", intcFunParam=" + this.f485348c + ")";
    }

    public e(InterceptModule r100, d r101, HashMap<String, Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "intcModule");
        Intrinsics.checkNotNullParameter(r101, "intcStep");
        Intrinsics.checkNotNullParameter(r102, "intcFunParam");
        this.f485346a = r100;
        this.f485347b = r101;
        this.f485348c = r102;
    }
}
