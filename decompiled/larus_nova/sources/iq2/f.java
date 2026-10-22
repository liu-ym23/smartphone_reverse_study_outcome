package iq2;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KtvMusic f495337a;

    public final long a() {
        return this.f495337a.getId();
    }

    public final g b() {
        OrderInfo r100 = this.f495337a.getOrderInfoFlex();
        if (r100 != null) goto L7;
        return null;
    L7:
        return new g(r100);
    }

    public final String c() {
        return this.f495337a.getTitle();
    }

    public f(KtvMusic r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f495337a = r100;
    }
}
