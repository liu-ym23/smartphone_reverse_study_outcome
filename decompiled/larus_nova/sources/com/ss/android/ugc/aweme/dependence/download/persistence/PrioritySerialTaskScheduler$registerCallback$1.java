package com.ss.android.ugc.aweme.dependence.download.persistence;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.aweme.dependence.download.persistence.callback.ISerialTaskCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Param", "Target", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 1})
final class PrioritySerialTaskScheduler$registerCallback$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ ISerialTaskCallback $callback;
    final /* synthetic */ Function0 $finallyBlock;
    final /* synthetic */ Object $param;
    final /* synthetic */ PrioritySerialTaskScheduler this$0;

    public PrioritySerialTaskScheduler$registerCallback$1(PrioritySerialTaskScheduler r100, Object r101, ISerialTaskCallback r102, Function0 r103) {
        this.$param = r101;
        this.$callback = r102;
        this.$finallyBlock = r103;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        if (this.$param != null) goto L5;
    L9:
        Function0 r100 = this.$finallyBlock;
        if (r100 == null) goto L13;
        r100.invoke();
        return r100;
    L13:
        return null;
    L5:
        if (this.$callback == null) goto L9;
        int r101 = PrioritySerialTaskScheduler.f450010a;
        throw null;
    }
}
