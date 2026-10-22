package com.bytedance.lark.molten_livequery_wrapper;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<unused var>", "Lcom/bytedance/lark/molten_livequery_wrapper/DiffResult;", WsConstants.KEY_PAYLOAD, "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class LiveListKt$subscribeListMap$1 extends Lambda implements Function2<a, Object, Unit> {
    final /* synthetic */ Function1<h<Object, Object>, Unit> $callback;
    final /* synthetic */ f<Object> $listWrapper;

    /* JADX WARN: Multi-variable type inference failed */
    public LiveListKt$subscribeListMap$1(Function1<? super h<Object, Object>, Unit> r100, f<Object> r101) {
        this.$callback = r100;
        this.$listWrapper = r101;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a r100, Object r101) {
        Function1<h<Object, Object>, Unit> r102 = this.$callback;
        List<Object> r103 = this.$listWrapper.h();
        if (r103 != null) goto L5;
        r103 = CollectionsKt.emptyList();
    L5:
        if (r101 != null) goto L7;
        r101 = null;
    L7:
        r102.invoke(new h(r103, r101, this.$listWrapper));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(a r100, Object r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
