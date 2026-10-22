package com.ss.android.lark.widget.span;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class DotLoadingDrawable$prepareAnimators$checkAndInvalidate$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.IntRef $invalidateRequest;
    final /* synthetic */ d this$0;

    public DotLoadingDrawable$prepareAnimators$checkAndInvalidate$1(Ref.IntRef r100, d r101) {
        this.$invalidateRequest = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Ref.IntRef r100 = this.$invalidateRequest;
        int r101 = (r100.element + 1) % 3;
        r100.element = r101;
        if (r101 == 0) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
