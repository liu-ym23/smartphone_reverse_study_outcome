package com.bytedance.android.shopping.anchorv4.voavhs.head.holder;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h extends com.bytedance.android.shopping.anchorv4.voavhs.head.base.b<h83.b> {
    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.j
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.base.m g(com.bytedance.android.shopping.anchorv4.voavhs.head.c r8) {
        Intrinsics.checkNotNullParameter(r8, "nodeVO");
        ECUrlModel r2 = r8.b;
        int r3 = this.b;
        String r5 = r8.u;
        return new h83.b(r2, r3, r8.q, r5, r8.f);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b
    public final /* bridge */ /* synthetic */ View w(com.bytedance.android.shopping.anchorv4.voavhs.head.base.m r1) {
        h83.b r2 = (h83.b) r1;
        return null;
    }

    public h(Context r2, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b
    public final List v(com.bytedance.android.shopping.anchorv4.voavhs.head.base.m r13, Function0 r14) {
        h83.b r15 = (h83.b) r13;
        Intrinsics.checkNotNullParameter(r14, "rootView");
        if (r15 == null) goto L5;
        ECUrlModel r3 = r15.a;
    L7:
        if (r15 == null) goto L9;
        String r6 = r15.c;
    L10:
        if (r15 == null) goto L12;
        String r7 = r15.d;
    L14:
        return CollectionsKt.listOf(new com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f(null, r3, null, null, r6, r7, false, null, null, 1949));
    L12:
        r7 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b
    public final void z(Context r4, View r5, com.bytedance.android.shopping.anchorv4.voavhs.head.base.m r6, int r7) {
        h83.b r8 = (h83.b) r6;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "rootView");
        Intrinsics.checkNotNullParameter(r8, "headNodeVO");
        boolean r0 = true;
        if (com.bytedance.android.ec.core.utils.a.c() == false) goto L12;
        r5.setContentDescription(com.bytedance.android.shopping.extensions.j.d(2131913862, Integer.valueOf(r8.b + 1)));
        int r9 = com.bytedance.android.shopping.anchorv4.data.h.a;
        ArrayList r10 = new ArrayList();
        ECUrlModel r1 = r8.a;
        if (r1 == null) goto L11;
        List r2 = r1.getUrlList();
        if (r2 == null) goto L11;
        String r3 = (String) CollectionsKt.firstOrNull(r2);
        if (r3 == null) goto L11;
        r10.add(r3);
    L11:
        Unit r11 = Unit.INSTANCE;
        com.bytedance.android.shopping.anchorv4.data.h.a(r10).subscribe(new f(r5, r8), new g(r5));
    L12:
        Integer r12 = Integer.valueOf(r7);
        if (r12.intValue() == 0) goto L16;
        r0 = false;
    L16:
        if (r0 == true) goto L19;
        r12 = null;
    L19:
        if (r12 == null) goto L26;
        r12.intValue();
        ECDraweeView r13 = r5.findViewById(2131362814);
        if (r13 == null) goto L27;
        GenericDraweeHierarchy r14 = r13.getHierarchy();
        if (r14 == null) goto L28;
        r14.setPlaceholderImage(r8.e);
        return;
    L28:
        return;
    L27:
        return;
    }
}
