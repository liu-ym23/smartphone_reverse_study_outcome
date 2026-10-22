package com.bytedance.ee.bear.list.thumbnail;

import io.reactivex.functions.Function;
import java.util.List;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T, R> implements Function {
    public final /* synthetic */ List<OfficeThumbnailUrlRepository.i> a;
    public final /* synthetic */ OfficeThumbnailUrlRepository b;

    public e(List<OfficeThumbnailUrlRepository.i> r1, OfficeThumbnailUrlRepository r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r3) {
        Throwable r4 = (Throwable) r3;
        Intrinsics.checkNotNullParameter(r4, "throwable");
        tt5.a.l("OfficeThumbnailUrlRepo", "batch drive cdn thumbnail failed, fallback cover, count=" + this.a.size(), r4);
        return this.b.a(this.a, MapsKt.emptyMap());
    }
}
