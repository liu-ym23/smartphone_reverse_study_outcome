package com.bytedance.jedi.model.combine;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u0006\"\u0004\b\u0005\u0010\u0007* \u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\t0\bH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "K", "V", "REQ", "RESP", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "Lcom/bytedance/jedi/model/combine/Combine$Mapper;", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class CombineExtensionsKt$withCache$2 extends Lambda implements Function1 {
    public static final CombineExtensionsKt$withCache$2 INSTANCE = null;

    static {
        INSTANCE = new CombineExtensionsKt$withCache$2();
    }

    public CombineExtensionsKt$withCache$2() {
        super(1);
    }

    public final void invoke(Combine.Mapper r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$null");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r100) {
        invoke((Combine.Mapper) r100);
        return Unit.INSTANCE;
    }
}
