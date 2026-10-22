package com.bytedance.salamander.bridge.common;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class IdlCallbackKt$createCallback$1$invoke$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Map<String, ? extends Object>, Unit> $callback;
    final /* synthetic */ Map<String, Object> $nonNullData;

    /* JADX WARN: Multi-variable type inference failed */
    public IdlCallbackKt$createCallback$1$invoke$1(Function1<? super Map<String, ? extends Object>, Unit> r100, Map<String, ? extends Object> r101) {
        this.$callback = r100;
        this.$nonNullData = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Function1<Map<String, ? extends Object>, Unit> r100 = this.$callback;
        if (r100 == null) goto L6;
        Unit r101 = r100.invoke(this.$nonNullData);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
