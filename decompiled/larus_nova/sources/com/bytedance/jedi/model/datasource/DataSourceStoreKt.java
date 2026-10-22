package com.bytedance.jedi.model.datasource;

import com.amap.api.col.s.ce;
import com.bytedance.jedi.model.traceable.ITracePoint;
import com.bytedance.jedi.model.util.ValueReference;
import com.bytedance.jedi.model.util.WeakRefStore;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"model_release"}, k = 2, mv = {1, 7, 1})
public final class DataSourceStoreKt {
    public static final void a(ITracePoint r100, AbstractDataSource r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "ds");
        DataSourceStore r102 = DataSourceStore.f251063b;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        StringBuilder r103 = new StringBuilder();
        r103.append(r100.getClass());
        r103.append('_');
        r103.append(r100.hashCode());
        String r104 = r103.toString();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, ce.f26396k);
        Intrinsics.checkNotNullParameter(r101, BaseSwitches.V);
        WeakRefStore<IDataSource<?, ?>> r105 = r102.f251064a;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r104, ce.f26396k);
        Intrinsics.checkNotNullParameter(r101, BaseSwitches.V);
        r105.f251215a.put(r104, new ValueReference(r104, r101, r105.f251216b));
    }
}
