package rw0;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f539559a;

    public d(c r100) {
        Intrinsics.checkNotNullParameter(r100, "fastPayLog");
        this.f539559a = r100;
    }

    @Override // rw0.a
    public final void a(HashMap<String, String> r100, com.bytedance.android.live.recharge.model.d r101) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        Intrinsics.checkNotNullParameter(r101, "entranceParams");
        c r102 = this.f539559a;
        r100.put("is_fast_pay", r102.f539557a);
        r100.put("open_fast_pay_opt", r102.f539558b);
    }
}
