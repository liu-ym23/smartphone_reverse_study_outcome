package com.bytedance.android.shopping.store.tabkit;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "config", "", "key", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class TabKitViewModel$Companion$checkAbilityConfigInLocalTest$2 extends Lambda implements Function2<Object, String, Boolean> {
    public static final TabKitViewModel$Companion$checkAbilityConfigInLocalTest$2 INSTANCE = null;

    static {
        INSTANCE = new TabKitViewModel$Companion$checkAbilityConfigInLocalTest$2();
    }

    public TabKitViewModel$Companion$checkAbilityConfigInLocalTest$2() {
        super(2);
    }

    public final boolean invoke(Object r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "key");
        if ((r2 instanceof TabKitAbilityConfig) == true) goto L5;
        r2 = null;
    L5:
        TabKitAbilityConfig r4 = (TabKitAbilityConfig) r2;
        if (r4 != null) goto L10;
        return false;
    L10:
        return r4.b(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return Boolean.valueOf(invoke(r1, (String) r2));
    }
}
