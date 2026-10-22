package com.bytedance.salamander.anniex;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/salamander/anniex/p4;", "listener", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/salamander/anniex/p4;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class EventEmitter$off$1 extends Lambda implements Function1<p4, Boolean> {
    final /* synthetic */ b8 $subscriber;

    public EventEmitter$off$1(b8 r100) {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(p4 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        r100.getClass();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(p4 r100) {
        return invoke2(r100);
    }
}
