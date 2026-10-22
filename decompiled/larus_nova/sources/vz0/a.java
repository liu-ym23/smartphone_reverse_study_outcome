package vz0;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.livesdk.revenue.network.d;
import com.bytedance.android.livesdk.revenue.network.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends com.bytedance.android.livesdk.revenue.network.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.network.a f557631a;

    public a(com.bytedance.android.livesdk.revenue.service.network.a r100) {
        Intrinsics.checkNotNullParameter(r100, "revNetworkService");
        this.f557631a = r100;
    }

    @Override // com.bytedance.android.livesdk.revenue.network.a
    public final e A(String r110, d r111, int r112, e r113, Extra r114) {
        Intrinsics.checkNotNullParameter(r110, "path");
        Intrinsics.checkNotNullParameter(r111, "request");
        Intrinsics.checkNotNullParameter(r113, "error");
        Intrinsics.checkNotNullParameter(r114, "extra");
        RequestError r115 = new RequestError();
        r115.message = r113.f157211a;
        r115.prompts = r113.f157212b;
        r115.alert = r113.f157213c;
        r115.setBlockNotice(r113.f157214d);
        r115.url = r113.f157215e;
        this.f557631a.yf(r110, r112, r115, r114);
        return new e(r115.message, r115.prompts, r115.alert, r115.isBlockNotice(), r113.f157215e, r113.f157216f, r113.f157217g);
    }
}
