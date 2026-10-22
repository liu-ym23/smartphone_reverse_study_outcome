package com.bytedance.ee.bear.document.export.net.exportV2;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d<T> implements Predicate {
    public static final d<T> a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final boolean test(Object r3) {
        Result r4 = (Result) r3;
        Intrinsics.checkNotNullParameter(r4, "exportResult");
        tt5.a.h("DocumentExportExecutorImplV2", "filter，status = " + ((GetExportResultParserV2.ExportResultV2) r4.data).getJob_status());
        if (((GetExportResultParserV2.ExportResultV2) r4.data).getJob_status() != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
