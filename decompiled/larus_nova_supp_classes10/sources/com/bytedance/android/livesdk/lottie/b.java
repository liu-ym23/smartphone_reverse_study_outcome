package com.bytedance.android.livesdk.lottie;

import com.bytedance.android.livesdk.utils.j3;
import com.bytedance.android.livesdk.utils.n4;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b<T, R> implements Function {
    public final /* synthetic */ n4 a;

    public b(e r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        String r4 = (String) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        n4 r0 = this.a;
        Intrinsics.checkNotNullParameter(r4, "assetRoot");
        Intrinsics.checkNotNullParameter(r0, "res");
        return Single.create(new j3(r4, r0)).subscribeOn(Schedulers.io());
    }
}
