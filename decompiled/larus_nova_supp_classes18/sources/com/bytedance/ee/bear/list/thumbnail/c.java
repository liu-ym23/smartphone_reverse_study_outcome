package com.bytedance.ee.bear.list.thumbnail;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T, R> implements Function {
    public static final c<T, R> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final Object apply(Object r4) {
        OfficeThumbnailUrlRepository.DriveCdnUrlResult r5 = (OfficeThumbnailUrlRepository.DriveCdnUrlResult) r4;
        Intrinsics.checkNotNullParameter(r5, "result");
        OfficeThumbnailUrlRepository.ThumbnailUrlInfo r0 = (OfficeThumbnailUrlRepository.ThumbnailUrlInfo) ((Result) r5).data;
        if (((Result) r5).code != 0) goto L9;
        if (r0 == null) goto L9;
        if (StringsKt.isBlank(r0.getUrl()) == true) goto L9;
        return r0;
    L9:
        throw new IllegalStateException("get drive cdn url failed, code=" + ((Result) r5).code + ", msg=" + ((Result) r5).msg);
    }
}
