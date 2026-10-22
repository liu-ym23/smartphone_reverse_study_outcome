package com.bytedance.ee.bear.bitable.homepage.list.workspace;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/list/workspace/RustRequestDataException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "errorCode", "", "<init>", "(Ljava/lang/String;J)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RustRequestDataException extends Exception {
    public RustRequestDataException(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        super("errorCode:" + r101 + ", msg:" + r100);
    }
}
