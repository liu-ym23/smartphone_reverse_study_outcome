package gx1;

import com.bytedance.android.live.user.IMiddlewareUserService;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f483087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f483088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f483089c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f483088b == r101.f483088b) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f483089c, r101.f483089c) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f483088b;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f483089c;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public final String toString() {
        return "FeedbackSession(roomId=" + this.f483088b + ", roomOwnerId=" + this.f483089c + ")";
    }

    public a() {
        this(0, "0");
    }

    public a(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "roomOwnerId");
        this.f483088b = r100;
        this.f483089c = r101;
        this.f483087a = Intrinsics.areEqual(((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user().n(), r101);
    }
}
