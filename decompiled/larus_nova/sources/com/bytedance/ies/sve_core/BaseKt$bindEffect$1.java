package com.bytedance.ies.sve_core;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/ies/sve_core/i;", "it", "Lcom/bytedance/ies/sve_core/a;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/ies/sve_core/i;)Lcom/bytedance/ies/sve_core/a;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class BaseKt$bindEffect$1 extends Lambda implements Function1<i, a> {
    public static final BaseKt$bindEffect$1 INSTANCE = null;

    static {
        INSTANCE = new BaseKt$bindEffect$1();
    }

    public BaseKt$bindEffect$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ a invoke(i r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final a invoke2(i r100) {
        if ((r100 instanceof y) == true) goto L5;
        return r100;
    L5:
        return ((y) r100).f248708a;
    }
}
