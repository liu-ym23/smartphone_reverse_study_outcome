package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.retrofit2.client.Header;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/retrofit2/client/Header;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/retrofit2/client/Header;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class FallbackWebMainFrameInterceptStrategyProvider$removeHeader$1 extends Lambda implements Function1<Header, Boolean> {
    final /* synthetic */ String $headerName;

    public FallbackWebMainFrameInterceptStrategyProvider$removeHeader$1(String r100) {
        this.$headerName = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(Header r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return Boolean.valueOf(StringsKt.equals(r100.getName(), this.$headerName, true));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Header r100) {
        return invoke2(r100);
    }
}
