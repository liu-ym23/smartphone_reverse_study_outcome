package com.bytedance.ee.bear.list.thumbnail;

import io.reactivex.functions.Function;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeThumbnailUrlRepository f229790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<OfficeThumbnailUrlRepository.i> f229791b;

    public d(OfficeThumbnailUrlRepository r100, List<OfficeThumbnailUrlRepository.i> r101) {
        this.f229790a = r100;
        this.f229791b = r101;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        OfficeThumbnailUrlRepository.DriveCdnBatchUrlResult r101 = (OfficeThumbnailUrlRepository.DriveCdnBatchUrlResult) r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        if (r101.code != 0) goto L11;
        Map<String, OfficeThumbnailUrlRepository.ThumbnailUrlInfo> r102 = (HashMap) r101.data;
        if (r102 != null) goto L9;
        r102 = MapsKt.emptyMap();
    L9:
        return this.f229790a.a(this.f229791b, r102);
    L11:
        throw new IllegalStateException("batch drive cdn url failed, code=" + r101.code + ", msg=" + r101.msg);
    }
}
