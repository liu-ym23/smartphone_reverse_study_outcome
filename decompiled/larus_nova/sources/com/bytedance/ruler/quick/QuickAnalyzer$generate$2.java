package com.bytedance.ruler.quick;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import v97.c;
import v97.d;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lv97/c;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lv97/c;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class QuickAnalyzer$generate$2 extends Lambda implements Function1<c, Object> {
    final /* synthetic */ Ref.ObjectRef $getter;

    public QuickAnalyzer$generate$2(Ref.ObjectRef r100) {
        this.$getter = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(c r100) {
        d r101 = (d) this.$getter.element;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getValue();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(c r100) {
        return invoke2(r100);
    }
}
