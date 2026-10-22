package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.ItemMediaLayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class HeadMultiPreview$bindMediaLayer$1 implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.j {
    public final /* synthetic */ HeadMultiPreview a;
    public final /* synthetic */ ItemMediaLayer b;
    public final /* synthetic */ HeaderContentModel c;
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.headv2.k d;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.j
    public final void a(final Function0<Unit> r20) {
        final HeadMultiPreview$bindMediaLayer$1 r0 = this;
        Intrinsics.checkNotNullParameter(r20, "endCallback");
        ViewGroup r2 = r0.b.b;
        if (r0.a.h.wq() == false) goto L5;
        r20.invoke();
    L10:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.k r1 = r0.d;
        if (r1 == null) goto L16;
        IAction r3 = r1.b();
        if (r3 == null) goto L17;
        r0.a.h.yd().d(r3, r0.a, null);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        HeadMultiPreview r15 = r0.a;
        HeaderContentModel r4 = r0.c;
        Function0<Unit> r14 = new HeadMultiPreview$bindMediaLayer$1$onStartPlay$$inlined$let$lambda$1(r0, r20);
        r15.getClass();
        Intrinsics.checkNotNullParameter(r2, "targetView");
        Intrinsics.checkNotNullParameter(r4, "item");
        int r6 = r15.getHeight();
        float r5 = r15.i.n();
        Float r7 = r4.getWHScale(!r15.h.isExpanded());
        if (r7 == null) goto L8;
        float r8 = r7.floatValue();
    L9:
        float r9 = r5 / r8;
        int r10 = r2.getHeight();
        int r11 = r2.getWidth();
        int r12 = r15.i.n();
        int r13 = r15.getPaddingLeft();
        int r16 = r15.getPaddingRight();
        int r17 = r15.getPaddingTop();
        int r18 = r15.getPaddingBottom();
        ValueAnimator r19 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r19.setDuration(400);
        r19.addUpdateListener(new c(r19, r15, r6, r9, r10, r9, r11, r12, r13, r17, r16, r18, r2, r14));
        r19.addListener(new d(r15, r2, r14));
        r19.start();
        r0 = this;
        goto L10
    L8:
        r8 = 1.0f;
        goto L9
    }

    public HeadMultiPreview$bindMediaLayer$1(HeadMultiPreview r1, ItemMediaLayer r2, HeaderContentModel r3, com.bytedance.android.shopping.anchorv4.voavhs.headv2.k r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
