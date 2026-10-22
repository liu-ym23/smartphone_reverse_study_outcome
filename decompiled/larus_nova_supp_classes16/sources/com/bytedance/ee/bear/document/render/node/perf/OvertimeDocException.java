package com.bytedance.ee.bear.document.render.node.perf;

import com.bytedance.ee.bear.document.fail.DocException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/document/render/node/perf/OvertimeDocException;", "Lcom/bytedance/ee/bear/document/fail/DocException;", "code", "", "message", "", "<init>", "(ILjava/lang/String;)V", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OvertimeDocException extends DocException {
    public OvertimeDocException(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        super(r2, r3);
    }
}
