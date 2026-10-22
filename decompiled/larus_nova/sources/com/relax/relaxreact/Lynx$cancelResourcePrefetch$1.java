package com.relax.relaxreact;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", "result", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class Lynx$cancelResourcePrefetch$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Function1<Map<String, Object>, Unit> $callback;

    /* JADX WARN: Multi-variable type inference failed */
    public Lynx$cancelResourcePrefetch$1(Function1<? super Map<String, Object>, Unit> r100) {
        this.$callback = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Function1<Map<String, Object>, Unit> r101 = this.$callback;
        Map<String, Object> r102 = n1.b(r100);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>{ com.relax.relaxreact.LynxKt.ResourcePrefetchResult }");
        r101.invoke(TypeIntrinsics.asMutableMap(r102));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
