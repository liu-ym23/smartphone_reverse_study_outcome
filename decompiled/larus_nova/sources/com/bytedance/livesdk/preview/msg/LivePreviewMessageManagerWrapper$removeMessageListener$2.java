package com.bytedance.livesdk.preview.msg;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import vlc.l;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/livesdk/preview/msg/c;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/livesdk/preview/msg/c;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class LivePreviewMessageManagerWrapper$removeMessageListener$2 extends Lambda implements Function1<c, Boolean> {
    final /* synthetic */ l $listener;
    final /* synthetic */ String $method;

    public LivePreviewMessageManagerWrapper$removeMessageListener$2(l r100, String r101) {
        this.$listener = r100;
        this.$method = r101;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(c r100) {
        return Boolean.valueOf(invoke2(r100));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(c r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r100.getClass();
        throw null;
    }
}
