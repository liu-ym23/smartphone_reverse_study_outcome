package com.bytedance.android.window.shop.widget;

import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "p1", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class WindowTypeSeparatedAdapter$preparePreProcessors$2 extends FunctionReferenceImpl implements Function1<Integer, Integer> {
    public WindowTypeSeparatedAdapter$preparePreProcessors$2(WindowTypeSeparatedAdapter r8) {
        super(1, r8, WindowTypeSeparatedAdapter.class, "getBusinessPosition", "getBusinessPosition(I)I", 0);
    }

    public final int invoke(int r8) {
        WindowTypeSeparatedAdapter r0 = (WindowTypeSeparatedAdapter) ((CallableReference) this).receiver;
        if (r8 >= ((ArrayList) r0.h).size()) goto L34;
        int r1 = r8 - 1;
    L6:
        int r3 = 0;
        if (r1 < 0) goto L15;
        com.bytedance.android.window.shop.repository.tab.entity.f r4 = (com.bytedance.android.window.shop.repository.tab.entity.f) CollectionsKt.getOrNull(r0.h, r1);
        if (r4 == null) goto L15;
        int r5 = r4.i;
        Set<Integer> r6 = com.bytedance.android.window.shop.e.b;
        int r7 = com.bytedance.android.window.shop.b.a;
        if (r6.contains(Integer.valueOf(r5 & (-1073741825))) == true) goto L16;
        r1 = r1 - 1;
    L16:
        int r9 = r1 + 1;
    L17:
        if (r9 >= r8) goto L26;
        com.bytedance.android.window.shop.repository.tab.entity.f r10 = (com.bytedance.android.window.shop.repository.tab.entity.f) CollectionsKt.getOrNull(r0.h, r9);
        if (r10 == null) goto L26;
        if ((r10 instanceof com.bytedance.android.window.shop.repository.tab.entity.n) == false) goto L24;
        r3 = r3 + (((com.bytedance.android.window.shop.repository.tab.entity.n) r10).j - 1);
    L24:
        r9 = r9 + 1;
    L26:
        return (r8 - r1) + r3;
    L15:
        r1 = 0;
        goto L16
    L34:
        return -1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Integer.valueOf(invoke(((Number) r1).intValue()));
    }
}
