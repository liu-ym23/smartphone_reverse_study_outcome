package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f0 extends c {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f216197a = null;

        static {
            int[] r100 = new int[EFieldUIType.values().length];
            r100[EFieldUIType.CHECKBOX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[EFieldUIType.BUTTON.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[EFieldUIType.STAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[EFieldUIType.PROGRESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[EFieldUIType.RATING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f216197a = r100;
        }
    }

    public f0() {
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.c, com.bytedance.ee.bear.bitable.uikit.fieldcell.g0
    public final b<h0> a(EFieldUIType r100, iv4.b r101) {
        Intrinsics.checkNotNullParameter(r100, "fieldUIType");
        int r102 = a.f216197a[r100.ordinal()];
        if (r102 != 1) goto L5;
        b<h0> r103 = new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.h(r101);
    L21:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.uikit.fieldcell.AbsUIKitCreator<com.bytedance.ee.bear.bitable.uikit.fieldcell.IFiledUIkitModel>");
        return r103;
    L5:
        if (r102 != 2) goto L7;
        r103 = new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.g(r101);
        goto L21
    L7:
        if (r102 == 3) goto L16;
        if (r102 != 4) goto L11;
        r103 = new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.i(r101);
        goto L21
    L11:
        if (r102 == 5) goto L13;
        r103 = super.a(r100, r101);
        goto L21
    L13:
        r103 = new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.j(r101);
        goto L21
    L16:
        if (com.bytedance.ee.bear.bitable.c.B() == false) goto L18;
        r103 = new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.l(r101);
        goto L21
    L18:
        r103 = new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.k(r101);
        goto L21
    }
}
