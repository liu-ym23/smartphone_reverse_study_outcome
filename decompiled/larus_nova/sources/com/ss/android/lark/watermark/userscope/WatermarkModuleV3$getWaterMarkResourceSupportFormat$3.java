package com.ss.android.lark.watermark.userscope;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.watermark.core.IGetWaterMarkResourceSupportFormatCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class WatermarkModuleV3$getWaterMarkResourceSupportFormat$3 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ IGetWaterMarkResourceSupportFormatCallback $callback;

    public WatermarkModuleV3$getWaterMarkResourceSupportFormat$3(IGetWaterMarkResourceSupportFormatCallback r100) {
        this.$callback = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Log.i("watermarkV3", "getWaterMarkResourceSupportFormat: failed, error: " + r100.getMessage());
        this.$callback.onSupportFormat(CollectionsKt.emptyList());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
