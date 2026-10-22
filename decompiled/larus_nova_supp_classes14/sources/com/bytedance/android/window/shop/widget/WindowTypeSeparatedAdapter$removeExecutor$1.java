package com.bytedance.android.window.shop.widget;

import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowTypeSeparatedAdapter$removeExecutor$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public WindowTypeSeparatedAdapter$removeExecutor$1(WindowTypeSeparatedAdapter r8) {
        super(1, r8, WindowTypeSeparatedAdapter.class, "updateRangeOnRemove", "updateRangeOnRemove(I)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Number) r1).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r2) {
        WindowTypeSeparatedAdapter r3 = (WindowTypeSeparatedAdapter) ((CallableReference) this).receiver;
        fo.a<WindowLayoutType> r0 = WindowTypeSeparatedAdapter.t;
        r3.getClass();
    }
}
