package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveToSpaceStatusPuller;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x<T, R> implements Function {
    public final /* synthetic */ t a;
    public final /* synthetic */ String b;

    public x(t r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r3) {
        Intrinsics.checkNotNullParameter((Boolean) r3, "it");
        return new MoveToSpaceStatusPuller(this.a.g).d(new MoveToSpaceStatusPuller.Params(this.b));
    }
}
