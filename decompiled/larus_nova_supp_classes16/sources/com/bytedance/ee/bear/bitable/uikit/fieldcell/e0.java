package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e0 extends c {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[EFieldUIType.values().length];
            r0[EFieldUIType.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[EFieldUIType.URL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public e0() {
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.c, com.bytedance.ee.bear.bitable.uikit.fieldcell.g0
    public final b<h0> a(EFieldUIType r3, iv4.b r4) {
        Intrinsics.checkNotNullParameter(r3, "fieldUIType");
        int r0 = a.a[r3.ordinal()];
        if (r0 != 1) goto L5;
        b<h0> r5 = new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.f(r4);
    L9:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.uikit.fieldcell.AbsUIKitCreator<com.bytedance.ee.bear.bitable.uikit.fieldcell.IFiledUIkitModel>");
        return r5;
    L5:
        if (r0 == 2) goto L7;
        r5 = super.a(r3, r4);
        goto L9
    L7:
        r5 = new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.u(r4, Boolean.TRUE);
        goto L9
    }
}
