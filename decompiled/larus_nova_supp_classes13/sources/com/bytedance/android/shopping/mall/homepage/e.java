package com.bytedance.android.shopping.mall.homepage;

import com.bytedance.android.shopping.api.mall.IECNativeHomeArgument;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import com.bytedance.android.shopping.mall.homepage.tools.MallNetApplier;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements MallNetApplier.a.d {
    public final /* synthetic */ ECMallFragment a;

    @Override // com.bytedance.android.shopping.mall.homepage.tools.MallNetApplier.a.d
    public final MallNetApplier.a.c a() {
        ECMallFragment r0 = this.a;
        ECMallFeed r1 = r0.f;
        if (r1 == null) goto L5;
        int r2 = r1.M;
    L6:
        Integer r3 = StringsKt.toIntOrNull(r0.d.j());
        IECNativeHomeArgument r4 = this.a.ma0();
        if (r4 == null) goto L9;
        Map<String, String> r5 = r4.getGrassParams();
    L11:
        return new MallNetApplier.a.c(r2, r3, r5, this.a.ia0().t, this.a.O2);
    L9:
        r5 = null;
        goto L11
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.bytedance.android.shopping.mall.homepage.tools.MallNetApplier.a.d
    public final MallNetApplier.a.e b() {
        return new MallNetApplier.a.e(this.a.getContext());
    }

    @Override // com.bytedance.android.shopping.mall.homepage.tools.MallNetApplier.a.d
    public final DataEngineWrapper c() {
        return this.a.L0;
    }

    @Override // com.bytedance.android.shopping.mall.homepage.tools.MallNetApplier.a.d
    public final MallNetApplier.a.C0110a d() {
        ECMallFragment r1 = this.a;
        int r2 = ECMallFragment.h4;
        r1.getClass();
        return new MallNetApplier.a.C0110a(this.a);
    }

    @Override // com.bytedance.android.shopping.mall.homepage.tools.MallNetApplier.a.d
    public final MallNetApplier.a.b e() {
        return new MallNetApplier.a.b(this.a.d.u);
    }

    public e(ECMallFragment r1) {
        this.a = r1;
    }
}
