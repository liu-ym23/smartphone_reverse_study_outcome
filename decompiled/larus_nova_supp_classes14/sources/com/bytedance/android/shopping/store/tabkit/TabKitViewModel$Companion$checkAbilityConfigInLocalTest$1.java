package com.bytedance.android.shopping.store.tabkit;

import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class TabKitViewModel$Companion$checkAbilityConfigInLocalTest$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ TabKitRouterParams $routerParams;

    public TabKitViewModel$Companion$checkAbilityConfigInLocalTest$1(TabKitRouterParams r1) {
        this.$routerParams = r1;
        super(0);
    }

    public final Object invoke() {
        return new TabKitAbilityConfig(this.$routerParams);
    }
}
