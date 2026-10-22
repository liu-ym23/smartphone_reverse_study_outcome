package com.bytedance.android.shopping.anchorv4.voavhs;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements com.bytedance.android.shopping.anchorv4.voavhs.car.f {
    public final AnchorV4VM a;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final CommonMeta a() {
        return this.a.commonMeta();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final LinkedTreeMap<String, Object> b() {
        return this.a.trackMeta();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final String f() {
        return this.a.shareParams().b;
    }

    public k(AnchorV4VM r2) {
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");
        this.a = r2;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final void g(String r8, Map<String, ? extends Object> r9, boolean r10, boolean r11, String r12, PageFinder r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r8, "eventName");
        int r0 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r1 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.a);
        if (r1 == null) goto L22;
        if (r15 == null) goto L6;
        r1 = r1.e(r15);
    L6:
        AnchorV4TrackerImpl r2 = r1;
        if (r9 == null) goto L10;
        if (r2 == null) goto L10;
        r2.c = r9;
    L10:
        if (r12 != null) goto L12;
    L15:
        boolean r16 = true;
    L16:
        if (r16 == true) goto L19;
        if (r2 == null) goto L19;
        Intrinsics.checkNotNull(r12);
        r2.d(r12, r13);
    L19:
        if (r2 == null) goto L23;
        r2.a(r8, r11, r14, r10, r13);
        return;
    L23:
        return;
    L12:
        if (r12.length() == 0) goto L15;
        r16 = false;
        goto L16
    }
}
