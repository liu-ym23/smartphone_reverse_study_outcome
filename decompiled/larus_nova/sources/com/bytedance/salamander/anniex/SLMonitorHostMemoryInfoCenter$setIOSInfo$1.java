package com.bytedance.salamander.anniex;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", "isCancelled", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class SLMonitorHostMemoryInfoCenter$setIOSInfo$1 extends Lambda implements Function1<Boolean, Object> {
    final /* synthetic */ Map<String, Object> $iosInfo;
    final /* synthetic */ c7 this$0;

    public SLMonitorHostMemoryInfoCenter$setIOSInfo$1(c7 r100, Map<String, Object> r101) {
        this.this$0 = r100;
        this.$iosInfo = r101;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Boolean r100) {
        return invoke(r100.booleanValue());
    }

    public final Object invoke(boolean r100) {
        c7 r101 = this.this$0;
        r101.f268004d = this.$iosInfo;
        return null;
    }
}
