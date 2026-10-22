package com.bytedance.ee.bear.list.thumbnail;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class f<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f<T, R> f229794a = null;

    static {
        f229794a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        OfficeThumbnailUrlRepository.ThumbnailUrlResult r101 = (OfficeThumbnailUrlRepository.ThumbnailUrlResult) r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        OfficeThumbnailUrlRepository.ThumbnailUrlInfo r102 = (OfficeThumbnailUrlRepository.ThumbnailUrlInfo) r101.data;
        if (r101.code != 0) goto L9;
        if (r102 == null) goto L9;
        if (StringsKt.isBlank(r102.getUrl()) == true) goto L9;
        return r102;
    L9:
        throw new IllegalStateException("get thumbnail url failed, code=" + r101.code + ", msg=" + r101.msg);
    }
}
