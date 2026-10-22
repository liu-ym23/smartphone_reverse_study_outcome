package com.obric.assistant.bootprotector;

import android.content.Context;
import com.larus.bootprotector.IBootProtectorProcessDiff;
import com.obric.assistant.common.utils.l;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/assistant/bootprotector/ObricBootProtectorProcessDiffImpl;", "Lcom/larus/bootprotector/IBootProtectorProcessDiff;", "<init>", "()V", "isMainProcess", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricBootProtectorProcessDiffImpl implements IBootProtectorProcessDiff {
    public ObricBootProtectorProcessDiffImpl() {
    }

    @Override // com.larus.bootprotector.IBootProtectorProcessDiff
    public final boolean isMainProcess(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return l.a(r100);
    }
}
