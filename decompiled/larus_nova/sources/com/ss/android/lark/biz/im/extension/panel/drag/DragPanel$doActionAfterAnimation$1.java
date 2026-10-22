package com.ss.android.lark.biz.im.extension.panel.drag;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class DragPanel$doActionAfterAnimation$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $action;
    final /* synthetic */ DragPanel this$0;

    public DragPanel$doActionAfterAnimation$1(Function0<Unit> r100, DragPanel r101) {
        this.$action = r100;
        this.this$0 = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$action.invoke();
        DragPanel r100 = this.this$0;
        r100.f410514l = AnonymousClass1.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
