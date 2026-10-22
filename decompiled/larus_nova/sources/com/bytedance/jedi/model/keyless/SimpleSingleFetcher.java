package com.bytedance.jedi.model.keyless;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/jedi/model/keyless/SimpleSingleFetcher;", "V", "", "Lcom/bytedance/jedi/model/keyless/AbstractSingleFetcher;", "<init>", "()V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public abstract class SimpleSingleFetcher<V> extends AbstractSingleFetcher<V, V> {
    public SimpleSingleFetcher() {
    }

    @Override // com.bytedance.jedi.model.fetcher.IFetcher
    public final Object e(Unit r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, HiAnalyticsConstant.Direction.REQUEST);
        return r101;
    }
}
