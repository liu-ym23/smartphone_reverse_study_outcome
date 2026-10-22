package com.bytedance.salamander.bridge;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.salamander.anniex.m3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lyd7/b$c;", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/salamander/anniex/m3;", AbsMethodDelegate.TAG_INVOKE, "(Lyd7/b$c;)Lcom/bytedance/salamander/anniex/m3;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class ChooseAndUploadImplKt$createCompletionBlockProxy$1$onSuccess$1 extends Lambda implements Function1<yd7.b.c, m3> {
    public static final ChooseAndUploadImplKt$createCompletionBlockProxy$1$onSuccess$1 INSTANCE = null;

    static {
        INSTANCE = new ChooseAndUploadImplKt$createCompletionBlockProxy$1$onSuccess$1();
    }

    public ChooseAndUploadImplKt$createCompletionBlockProxy$1$onSuccess$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final m3 invoke2(yd7.b.c r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        r100.getUrl();
        r100.getPath();
        Number r101 = r100.getSize();
        if (r101 == null) goto L5;
        r101.doubleValue();
    L5:
        r100.getMimeType();
        r100.getBase64Data();
        r100.getMediaType();
        return new m3();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ m3 invoke(yd7.b.c r100) {
        return invoke2(r100);
    }
}
