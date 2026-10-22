package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r0<T, R> implements Function {
    public final /* synthetic */ WikiInfo a;

    public r0(WikiInfo r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((String) r2, "it");
        tt5.a.b("WikiRepository", "readParamsWikiInfoFlow success:" + this.a);
        WikiInfo r3 = this.a;
        r3.from_cache = true;
        return new up5.b(r3);
    }
}
