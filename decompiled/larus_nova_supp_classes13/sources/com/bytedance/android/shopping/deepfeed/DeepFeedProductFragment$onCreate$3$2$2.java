package com.bytedance.android.shopping.deepfeed;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0015\u0010\u0007\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0015\u0010\t\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0015\u0010\u000b\u001a\u00110\f¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r¢\u0006\u0002\b\u000e"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "cardPosition", "p2", "selectedIndex", "p3", "previousIndex", "p4", "", "byUser", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class DeepFeedProductFragment$onCreate$3$2$2 extends FunctionReferenceImpl implements Function4<Integer, Integer, Integer, Boolean, Unit> {
    public DeepFeedProductFragment$onCreate$3$2$2(com.bytedance.android.shopping.deepfeed.event.a r8) {
        super(4, r8, com.bytedance.android.shopping.deepfeed.event.a.class, "onImageSelected", "onImageSelected(IIIZ)V", 0);
    }

    public final void invoke(int r4, int r5, int r6, boolean r7) {
        com.bytedance.android.shopping.deepfeed.event.a r0 = (com.bytedance.android.shopping.deepfeed.event.a) ((CallableReference) this).receiver;
        if (r0.o == false) goto L23;
        if (r7 == false) goto L21;
        if (r5 == r6) goto L24;
        com.bytedance.android.shopping.deepfeed.event.a.d r8 = r0.c;
        if (r8 != null) goto L12;
        return;
    L12:
        if (r8.c == r4) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(r8.n, "enter_detail") == true) goto L27;
        r8.n = "switch_image";
        if (r8.m == false) goto L22;
        r0.b();
        com.bytedance.android.shopping.deepfeed.event.b r9 = new com.bytedance.android.shopping.deepfeed.event.b(r0, r8.a);
        r0.h.postDelayed(r9, 500);
        Unit r10 = Unit.INSTANCE;
        r0.k = r9;
        return;
    L22:
        return;
    L27:
        return;
    L24:
        return;
    L21:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        invoke(((Number) r1).intValue(), ((Number) r2).intValue(), ((Number) r3).intValue(), ((Boolean) r4).booleanValue());
        return Unit.INSTANCE;
    }
}
