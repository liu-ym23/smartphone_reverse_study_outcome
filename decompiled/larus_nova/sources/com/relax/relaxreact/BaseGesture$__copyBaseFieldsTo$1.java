package com.relax.relaxreact;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<no name provided>", "", "value", "", "key", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class BaseGesture$__copyBaseFieldsTo$1 extends Lambda implements Function2<Object, String, Unit> {
    final /* synthetic */ Map<String, Object> $clonedConfig;

    public BaseGesture$__copyBaseFieldsTo$1(Map<String, Object> r100) {
        this.$clonedConfig = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, "key");
        com.bytedance.rts.kmp.foundation.j.e(this.$clonedConfig, r101, r100);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Object r100, String r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
