package com.bytedance.locallife.live.lynx.jsb;

import com.bytedance.locallife.live.util.j0;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class StartShopCartAnimMethod extends a {
    @Override // com.bytedance.locallife.live.lynx.jsb.a
    public final String a() {
        return "showShoppingCartAddAnimation";
    }

    public StartShopCartAnimMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        super(r100);
    }

    @Override // com.bytedance.locallife.live.lynx.jsb.a
    public final void d(final HashMap<String, Object> r100, Function1<? super Map<String, ? extends Object>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "callback");
        j0.h(new StartShopCartAnimMethod$handleMethod$1(this, r100));
    }
}
