package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.GetThreadsByPositionsResponse;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/chat/entity/response/ChannelThreadResponse;", "it", "Lcom/bytedance/lark/pb/im/v1/GetThreadsByPositionsResponse;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ThreadRepositoryV2$getThreadByPositions$1 extends Lambda implements Function1<GetThreadsByPositionsResponse, l5b.b> {
    final /* synthetic */ Function1<GetThreadsByPositionsResponse, l5b.b> $respMap;

    /* JADX WARN: Multi-variable type inference failed */
    public ThreadRepositoryV2$getThreadByPositions$1(Function1<? super GetThreadsByPositionsResponse, ? extends l5b.b> r100) {
        this.$respMap = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final l5b.b invoke2(GetThreadsByPositionsResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return this.$respMap.invoke(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ l5b.b invoke(GetThreadsByPositionsResponse r100) {
        return invoke2(r100);
    }
}
