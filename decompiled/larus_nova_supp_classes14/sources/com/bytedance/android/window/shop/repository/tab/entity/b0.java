package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b0 extends f {
    public static final /* synthetic */ int k = 0;
    public final tq3.c j;

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
        if (r0 == null) goto L10;
        int r1 = r0.intValue();
        tq3.c r2 = this.j;
        if (r2 == null) goto L11;
        fo.b r3 = ((WindowV2ProductItemVO) r2).C;
        if (r3 == null) goto L12;
        fo.a r4 = wn.a.a;
        Integer r5 = (Integer) r3.b(wn.a.C, Integer.valueOf(r1));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.f
    public final WindowV2ProductItemVO c() {
        return this.j;
    }

    public b0(tq3.c r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        super(101);
        this.j = r3;
        ((WindowV2ProductItemVO) r3).C.b(wn.a.f, 101);
    }
}
