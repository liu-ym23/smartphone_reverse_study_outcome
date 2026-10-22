package com.bytedance.android.shopping.anchorv4.voavhs.guess;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv3.guessulike.model.GULFeedbackDislikeReq;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.k;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements h, com.bytedance.android.shopping.anchorv4.voavhs.car.f {
    public final AnchorV4VM a;
    public final /* synthetic */ k b;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final CommonMeta a() {
        return this.b.a();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final LinkedTreeMap<String, Object> b() {
        return this.b.b();
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

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.h
    public final int C() {
        return this.a.getGulSize();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.h
    public final void B(int r2) {
        this.a.removeSpecificGUL(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.h
    public final void p(GULFeedbackDislikeReq r2) {
        Intrinsics.checkNotNullParameter(r2, "req");
        this.a.postGULFeedbackDislike(r2);
    }

    public e(AnchorV4VM r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");
        Intrinsics.checkNotNullParameter(r3, "eventService");
        this.b = r3;
        this.a = r2;
    }
}
