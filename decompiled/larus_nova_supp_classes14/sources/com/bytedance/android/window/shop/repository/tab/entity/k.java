package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k extends f {
    public static final /* synthetic */ int t = 0;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final e o;
    public final com.bytedance.android.window.shop.repository.dto.f p;
    public final com.bytedance.android.window.shop.repository.dto.f q;
    public final com.bytedance.android.window.shop.repository.dto.f r;
    public final tq3.c s;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.f
    public final WindowV2ProductItemVO c() {
        return this.s;
    }

    public k(String r2, String r3, String r4, String r5, String r6, ProductVideoVO r7, com.bytedance.android.window.shop.repository.dto.f r8, com.bytedance.android.window.shop.repository.dto.f r9, com.bytedance.android.window.shop.repository.dto.f r10, tq3.c r11) {
        Intrinsics.checkNotNullParameter(r2, "mainTitleSingle");
        Intrinsics.checkNotNullParameter(r3, "subTitleSingle");
        Intrinsics.checkNotNullParameter(r4, "mainTitleDouble");
        Intrinsics.checkNotNullParameter(r5, "subTitleDouble");
        Intrinsics.checkNotNullParameter(r6, "jumpUrl");
        super(209);
        this.j = r2;
        this.k = r3;
        this.l = r4;
        this.m = r5;
        this.n = r6;
        this.o = r7;
        this.p = r8;
        this.q = r9;
        this.r = r10;
        this.s = r11;
    }
}
