package com.bytedance.ee.bear.list.thumbnail;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Function;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T, R> implements Function {
    public final /* synthetic */ OfficeThumbnailUrlRepository a;
    public final /* synthetic */ List<OfficeThumbnailUrlRepository.i> b;

    public d(OfficeThumbnailUrlRepository r1, List<OfficeThumbnailUrlRepository.i> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r4) {
        OfficeThumbnailUrlRepository.DriveCdnBatchUrlResult r5 = (OfficeThumbnailUrlRepository.DriveCdnBatchUrlResult) r4;
        Intrinsics.checkNotNullParameter(r5, "result");
        if (((Result) r5).code != 0) goto L11;
        Map<String, OfficeThumbnailUrlRepository.ThumbnailUrlInfo> r6 = (HashMap) ((Result) r5).data;
        if (r6 != null) goto L9;
        r6 = MapsKt.emptyMap();
    L9:
        return this.a.a(this.b, r6);
    L11:
        throw new IllegalStateException("batch drive cdn url failed, code=" + ((Result) r5).code + ", msg=" + ((Result) r5).msg);
    }
}
