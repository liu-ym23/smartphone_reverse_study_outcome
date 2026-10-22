package com.ss.android.lark.watermark.userscope;

import com.bytedance.lark.pb.basic.v1.LarkError;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/lark/rustclient/api/RustClientError;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class WatermarkModuleV3$getWaterMarkResourceSupportFormat$2 extends Lambda implements Function1<com.bytedance.lark.rustclient.api.p, Unit> {
    final /* synthetic */ IGetWaterMarkResourceSupportFormatCallback $callback;

    public WatermarkModuleV3$getWaterMarkResourceSupportFormat$2(IGetWaterMarkResourceSupportFormatCallback r100) {
        this.$callback = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.lark.rustclient.api.p r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        StringBuilder r101 = new StringBuilder("getWaterMarkResourceSupportFormat: failed, result: ");
        LarkError r102 = r100.f253922b;
        if (r102 == null) goto L5;
        Integer r103 = r102.code;
    L6:
        r101.append(r103);
        Log.e("watermarkV3", r101.toString());
        this.$callback.onSupportFormat(CollectionsKt.emptyList());
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.lark.rustclient.api.p r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
