package rw0;

import com.bytedance.android.live.recharge.utils.p;
import com.bytedance.android.live.revlink.api.ILinkService;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f539555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f539556b;

    public b() {
        this.f539555a = p.a();
        Long r100 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getPkService().J();
        if (r100 == null) goto L5;
        long r101 = r100.longValue();
    L6:
        this.f539556b = r101;
        return;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // rw0.a
    public final void a(HashMap<String, String> r100, com.bytedance.android.live.recharge.model.d r101) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        Intrinsics.checkNotNullParameter(r101, "entranceParams");
        ew0.e.a(r101, r100);
        if (this.f539555a == false) goto L5;
        String r102 = "1";
    L6:
        r100.put("is_in_pk", r102);
        r100.put("pk_left_time", String.valueOf(this.f539556b));
        return;
    L5:
        r102 = "0";
        goto L6
    }
}
