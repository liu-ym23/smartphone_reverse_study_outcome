package nc0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements gy.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.revenuelink.rtc.f f518606a;

    @Override // gy.c
    public final gy.f getRtcManager() {
        com.bytedance.android.live.revenuelink.rtc.i r100 = this.f518606a.getRtcManager();
        if (r100 != null) goto L7;
        return null;
    L7:
        return new e(r100);
    }

    public c(com.bytedance.android.live.revenuelink.rtc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f518606a = r100;
    }
}
