package com.bytedance.android.shopping.card_list.container;

import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CollectPersonAdapter {
    public final Lazy a;
    public final Lazy b;
    public final CardListObjectContainer c;

    public CollectPersonAdapter(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.c = r2;
        this.a = LazyKt.lazy(new CollectPersonAdapter$trackerComponent$2(this));
        this.b = LazyKt.lazy(new CollectPersonAdapter$bodyComponent$2(this));
    }
}
