package com.bytedance.salamander.anniex;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", "isCancelled", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class SLMemoryData$scheduleMemoryCheck$1 extends Lambda implements Function1<Boolean, Object> {
    final /* synthetic */ r6 this$0;

    public SLMemoryData$scheduleMemoryCheck$1(r6 r100) {
        this.this$0 = r100;
        super(1);
    }

    public final Object invoke(boolean r100) {
        r6 r101 = this.this$0;
        if (r101.f268355d == false) goto L7;
        r101.a();
        r6 r102 = this.this$0;
        r102.getClass();
        d8 r103 = d8.f268040b;
        SLMemoryData$scheduleMemoryCheck$1 r104 = new SLMemoryData$scheduleMemoryCheck$1(r102);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "workLoad");
        int r105 = com.bytedance.salamander.adapter.r.f267796a;
        com.bytedance.salamander.adapter.i r106 = r103.f268041a;
        Intrinsics.checkNotNull(r106);
        com.bytedance.salamander.adapter.r.a.a(r104, r106, 3);
        return null;
    L7:
        return null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Boolean r100) {
        return invoke(r100.booleanValue());
    }
}
