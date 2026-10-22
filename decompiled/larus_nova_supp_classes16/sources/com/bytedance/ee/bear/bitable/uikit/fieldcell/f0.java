package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f0 extends c {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[EFieldUIType.values().length];
            r0[EFieldUIType.CHECKBOX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[EFieldUIType.BUTTON.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[EFieldUIType.STAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[EFieldUIType.PROGRESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[EFieldUIType.RATING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public f0() {
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.c, com.bytedance.ee.bear.bitable.uikit.fieldcell.g0
    public final b<h0> a(EFieldUIType r3, iv4.b r4) {
        Intrinsics.checkNotNullParameter(r3, "fieldUIType");
        int r0 = a.a[r3.ordinal()];
        if (r0 != 1) goto L5;
        b<h0> r5 = new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.h(r4);
    L21:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.uikit.fieldcell.AbsUIKitCreator<com.bytedance.ee.bear.bitable.uikit.fieldcell.IFiledUIkitModel>");
        return r5;
    L5:
        if (r0 != 2) goto L7;
        r5 = new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.g(r4);
        goto L21
    L7:
        if (r0 == 3) goto L16;
        if (r0 != 4) goto L11;
        r5 = new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.i(r4);
        goto L21
    L11:
        if (r0 == 5) goto L13;
        r5 = super.a(r3, r4);
        goto L21
    L13:
        r5 = new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.j(r4);
        goto L21
    L16:
        if (com.bytedance.ee.bear.bitable.c.B() == false) goto L18;
        r5 = new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.l(r4);
        goto L21
    L18:
        r5 = new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.k(r4);
        goto L21
    }
}
