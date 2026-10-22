package com.bytedance.salamander.anniex;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/salamander/anniex/f4;", "value", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/salamander/anniex/f4;)Ljava/lang/Boolean;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
final class SLAnnieXMonitorManager$unregisterSettingsListener$i$1 extends Lambda implements Function1<f4, Boolean> {
    final /* synthetic */ f4 $listener;

    public SLAnnieXMonitorManager$unregisterSettingsListener$i$1(f4 r100) {
        this.$listener = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(f4 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (r100 != this.$listener) goto L5;
        boolean r101 = true;
    L7:
        return Boolean.valueOf(r101);
    L5:
        r101 = false;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(f4 r100) {
        return invoke2(r100);
    }
}
