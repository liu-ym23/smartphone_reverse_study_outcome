package yg0;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {
    public f() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void b(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        ln0.a r101 = h.f567472a;
        ALogger.d("LayoutConfigGeckoRes", "refreshLayoutConfig onFailed");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r100, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "response");
        ln0.a r102 = h.f567472a;
        ALogger.d("LayoutConfigGeckoRes", "refreshLayoutConfig onSuccess");
    }
}
