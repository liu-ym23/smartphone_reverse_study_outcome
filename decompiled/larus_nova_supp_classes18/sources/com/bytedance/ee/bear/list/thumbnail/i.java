package com.bytedance.ee.bear.list.thumbnail;

import com.bytedance.ee.bear.list.dto.Document;
import io.reactivex.functions.Function;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T, R> implements Function {
    public final /* synthetic */ OfficeThumbnailUrlRepository a;
    public final /* synthetic */ Document b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public i(OfficeThumbnailUrlRepository r1, Document r2, int r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object apply(Object r4) {
        Throwable r5 = (Throwable) r4;
        Intrinsics.checkNotNullParameter(r5, "throwable");
        StringBuilder r0 = new StringBuilder("drive cdn thumbnail failed, fallback cover, tokenHash=");
        OfficeThumbnailUrlRepository r1 = this.a;
        Document r2 = this.b;
        r1.getClass();
        Set<String> r3 = OfficeThumbnailUrlRepository.c;
        r0.append(OfficeThumbnailUrlRepository.c.b(r2).hashCode());
        tt5.a.l("OfficeThumbnailUrlRepo", r0.toString(), r5);
        return this.a.b(this.b, this.c, this.d);
    }
}
