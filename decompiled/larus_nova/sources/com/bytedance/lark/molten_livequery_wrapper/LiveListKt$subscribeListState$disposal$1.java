package com.bytedance.lark.molten_livequery_wrapper;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Item", "KeyChange", "it", "Lcom/bytedance/lark/molten_livequery_wrapper/LiveList;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class LiveListKt$subscribeListState$disposal$1 extends Lambda implements Function1<h<Object, Object>, Unit> {
    final /* synthetic */ z0<h<Object, Object>> $flow;

    public LiveListKt$subscribeListState$disposal$1(z0<h<Object, Object>> r100) {
        this.$flow = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(h<Object, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.$flow.setValue(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(h<Object, Object> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
