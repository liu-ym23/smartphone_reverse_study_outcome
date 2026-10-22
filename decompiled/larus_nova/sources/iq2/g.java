package iq2;

import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.b8;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OrderInfo f495338a;

    public final c a() {
        OrderInfo r100 = this.f495338a;
        Intrinsics.checkNotNullParameter(r100, "$this$topUserFlex");
        b8 r101 = r100.getTopUser();
        if (r101 != null) goto L7;
        return null;
    L7:
        return new c(r101);
    }

    public g(OrderInfo r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f495338a = r100;
    }
}
