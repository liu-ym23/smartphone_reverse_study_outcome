package y11;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.global.c f565617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x11.a f565618b;

    public final int a() {
        com.bytedance.android.live.revlink.impl.global.c r100 = this.f565617a;
        if (r100 == null) goto L5;
        com.bytedance.android.live.revlink.impl.service.internal.a r101 = r100.Do();
    L6:
        if (r101 != null) goto L10;
        return 0;
    L10:
        return r101.getCurrentMode();
    L5:
        r101 = null;
        goto L6
    }

    public g(com.bytedance.android.live.revlink.impl.global.c r100, x11.a r101) {
        Intrinsics.checkNotNullParameter(r101, "internalLinkService");
        this.f565617a = r100;
        this.f565618b = r101;
    }
}
