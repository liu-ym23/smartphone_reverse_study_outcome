package com.bytedance.livesdk.preview.msg;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import vlc.l;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/livesdk/preview/msg/e;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/livesdk/preview/msg/e;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class LivePreviewMessageManagerWrapper$addWRDSMessageListener$1 extends Lambda implements Function1<e, Boolean> {
    final /* synthetic */ l $listener;
    final /* synthetic */ int $messageType;

    public LivePreviewMessageManagerWrapper$addWRDSMessageListener$1(l r100, int r101) {
        this.$listener = r100;
        this.$messageType = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(e r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r100.getClass();
        Integer r101 = 0;
        if (r101.equals(Integer.valueOf(this.$messageType)) == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(null, this.$listener) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(e r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}
