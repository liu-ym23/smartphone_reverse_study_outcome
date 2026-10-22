package com.relax.relaxreact;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<no name provided>", "", "event", "", "", "", "Lcom/relax/relaxreact/PerformanceRuntimeEvent;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class PerformanceObserver$2 extends Lambda implements Function1<Map<String, Object>, Unit> {
    final /* synthetic */ com.bytedance.rts.kmp.foundation.p<u0> $weakThis;

    public PerformanceObserver$2(com.bytedance.rts.kmp.foundation.p<u0> r100) {
        this.$weakThis = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (((u0) com.bytedance.rts.kmp.foundation.q.a(this.$weakThis)) != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r100, "event");
        ArrayList r101 = (ArrayList) com.bytedance.rts.kmp.foundation.h.c(r100, "data", 2);
        if (r101 == null) goto L14;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if (r101.size() == 0) goto L14;
        Object r102 = ListProtector.get(r101, 0);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.util.ArrayList<kotlin.collections.MutableMap<kotlin.String, kotlin.Any>>{ com.relax.relaxreact.PerformanceKt.PerformanceRuntimeEventArguments }");
        ArrayList r103 = (ArrayList) r102;
        if (com.bytedance.rts.kmp.foundation.i.a(r103) <= 0) goto L13;
        Object r104 = ListProtector.get(r103, 0);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>{ com.relax.relaxreact.PerformanceKt.PerformanceEntry }");
        Map r105 = TypeIntrinsics.asMutableMap(r104);
    L15:
        Intrinsics.checkNotNullParameter(r105, "entry");
        return;
    L13:
        r105 = TypeIntrinsics.asMutableMap(r100);
    L14:
        r105 = TypeIntrinsics.asMutableMap(r100);
        goto L15
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, Object> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
