package com.bytedance.livesdk.ktvimpl.base.download;

import com.bytedance.livesdk.ktvcommon.download.c;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "batchId", "Lcom/bytedance/livesdk/ktvimpl/base/download/a$a;", "wrapper", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/String;Lcom/bytedance/livesdk/ktvimpl/base/download/a$a;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class KtvDownloadHelper$createBatchCallbackWrapper$1 extends Lambda implements Function2<String, a.C3640a, Unit> {
    public static final KtvDownloadHelper$createBatchCallbackWrapper$1 INSTANCE = null;

    static {
        INSTANCE = new KtvDownloadHelper$createBatchCallbackWrapper$1();
    }

    public KtvDownloadHelper$createBatchCallbackWrapper$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, a.C3640a r101) {
        Intrinsics.checkNotNullParameter(r100, "batchId");
        Intrinsics.checkNotNullParameter(r101, "wrapper");
        c r102 = a.f256303a;
        a.f256303a.b(r100, r101);
        a.f256304b.remove(r100);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, a.C3640a r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
