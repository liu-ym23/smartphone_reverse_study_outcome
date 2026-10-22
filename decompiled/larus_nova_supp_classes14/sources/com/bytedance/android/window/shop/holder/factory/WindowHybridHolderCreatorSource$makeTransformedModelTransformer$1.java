package com.bytedance.android.window.shop.holder.factory;

import com.bytedance.android.ec.hybrid.list.ability.n0;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.repository.dto.v0;
import com.bytedance.android.window.shop.repository.tab.datasource.mapping.WindowDataMapper;
import com.bytedance.android.window.shop.repository.tab.entity.v;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowHybridHolderCreatorSource$makeTransformedModelTransformer$1 implements n0 {
    public final Gson a;
    public final /* synthetic */ Class b;
    public final /* synthetic */ Function1 c;

    public final Object a(final String r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (((Boolean) WindowConstDef.c.getValue()).booleanValue() == false) goto L10;
        return new mp3.c(new WindowHybridHolderCreatorSource$makeTransformedModelTransformer$1$modelTransform$1(this, r3));
    L10:
        return b(r3);
    }

    public final com.bytedance.android.window.shop.repository.tab.entity.f b(String r4) {
        com.bytedance.android.window.shop.repository.dto.c r5 = (com.bytedance.android.window.shop.repository.dto.c) GsonProtectorUtils.fromJson(this.a, r4, com.bytedance.android.window.shop.repository.dto.c.class);
        if (r5 != null) goto L5;
        return null;
    L5:
        Object r1 = r5.b(this.b);
        if (r1 != null) goto L8;
        return null;
    L8:
        com.bytedance.android.window.shop.repository.tab.entity.f r2 = (com.bytedance.android.window.shop.repository.tab.entity.f) this.c.invoke(r1);
        if (r2 == null) goto L20;
        WindowDataMapper.d(r5, r2);
        v0 r6 = r5.d();
        if (r6 == null) goto L19;
        int r0 = v.n;
        Integer r3 = r6.c();
        if (r3 == null) goto L16;
        int r7 = r3.intValue();
    L17:
        r2.a = v.a.a(r6, r7);
        goto L19
    L16:
        r7 = 0;
    L19:
        return r2;
    L20:
        return null;
    }

    public WindowHybridHolderCreatorSource$makeTransformedModelTransformer$1(Class r1, Function1 r2) {
        this.b = r1;
        this.c = r2;
        this.a = new Gson();
    }
}
