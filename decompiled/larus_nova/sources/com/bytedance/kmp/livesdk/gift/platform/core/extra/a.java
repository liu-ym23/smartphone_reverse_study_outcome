package com.bytedance.kmp.livesdk.gift.platform.core.extra;

import com.bytedance.android.livesdk.gift.model.w1;
import io.reactivex.functions.Function;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes19.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f252247a = null;

    static {
        f252247a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        w1 r101 = (w1) r100;
        Intrinsics.checkNotNullParameter(r101, "page");
        return SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(r101.getGifts()), GiftExtraRepository$refreshGiftExtra$2$1$1.INSTANCE), GiftExtraRepository$refreshGiftExtra$2$1$2.INSTANCE);
    }
}
