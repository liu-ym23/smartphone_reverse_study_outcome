package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m extends f {
    public static final /* synthetic */ int k = 0;
    public final rq3.a j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.f
    public final String b() {
        return ((WindowV2ProductItemVO) this.j).a;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.f
    public final void d() {
        Integer r0 = this.b;
        if (r0 == null) goto L6;
        int r1 = r0.intValue();
        fo.b r2 = ((WindowV2ProductItemVO) this.j).C;
        fo.a r3 = wn.a.a;
        r2.b(wn.a.C, Integer.valueOf(r1));
        return;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.f
    public final WindowV2ProductItemVO c() {
        return this.j;
    }

    public m(rq3.a r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        super(402);
        this.j = r4;
        fo.b r5 = ((WindowV2ProductItemVO) r4).C;
        fo.a r1 = wn.a.f;
        int r2 = com.bytedance.android.window.shop.b.a;
        r5.b(r1, 402);
    }
}
