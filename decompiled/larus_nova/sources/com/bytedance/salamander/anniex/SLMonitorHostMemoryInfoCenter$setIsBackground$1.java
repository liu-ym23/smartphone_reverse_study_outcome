package com.bytedance.salamander.anniex;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", "isCancelled", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class SLMonitorHostMemoryInfoCenter$setIsBackground$1 extends Lambda implements Function1<Boolean, Object> {
    final /* synthetic */ boolean $isBackground;
    final /* synthetic */ c7 this$0;

    public SLMonitorHostMemoryInfoCenter$setIsBackground$1(c7 r100, boolean r101) {
        this.this$0 = r100;
        this.$isBackground = r101;
        super(1);
    }

    public final Object invoke(boolean r100) {
        c7 r101 = this.this$0;
        boolean r102 = this.$isBackground;
        r101.f268001a = r102;
        if (r102 == true) goto L7;
        int r103 = w7.f268497a;
        int r104 = com.bytedance.rts.foundation.c.f267576a;
        int r105 = com.bytedance.rts.foundation.b.f267575a;
        r101.f268002b = System.currentTimeMillis();
        return null;
    L7:
        return null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Boolean r100) {
        return invoke(r100.booleanValue());
    }
}
