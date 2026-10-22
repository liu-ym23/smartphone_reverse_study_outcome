package com.bytedance.android.shopping.anchorv4.voavhs.car;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements e, f {
    public boolean a;
    public final /* synthetic */ f b;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final CommonMeta a() {
        return this.b.a();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final LinkedTreeMap<String, Object> b() {
        return this.b.b();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.e
    public final void e() {
        this.a = true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final String f() {
        return this.b.f();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final void g(String r11, Map<String, ? extends Object> r12, boolean r13, boolean r14, String r15, PageFinder r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r11, "eventName");
        this.b.g(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.e
    public final boolean i() {
        return this.a;
    }

    public d(f r2) {
        Intrinsics.checkNotNullParameter(r2, "trackDepend");
        this.b = r2;
        this.a = false;
    }
}
