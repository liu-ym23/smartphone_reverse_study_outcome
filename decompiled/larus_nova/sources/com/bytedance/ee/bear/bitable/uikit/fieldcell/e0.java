package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e0 extends c {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f216196a = null;

        static {
            int[] r100 = new int[EFieldUIType.values().length];
            r100[EFieldUIType.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[EFieldUIType.URL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f216196a = r100;
        }
    }

    public e0() {
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.c, com.bytedance.ee.bear.bitable.uikit.fieldcell.g0
    public final b<h0> a(EFieldUIType r100, iv4.b r101) {
        Intrinsics.checkNotNullParameter(r100, "fieldUIType");
        int r102 = a.f216196a[r100.ordinal()];
        if (r102 != 1) goto L5;
        b<h0> r103 = new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.f(r101);
    L9:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.uikit.fieldcell.AbsUIKitCreator<com.bytedance.ee.bear.bitable.uikit.fieldcell.IFiledUIkitModel>");
        return r103;
    L5:
        if (r102 == 2) goto L7;
        r103 = super.a(r100, r101);
        goto L9
    L7:
        r103 = new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.u(r101, Boolean.TRUE);
        goto L9
    }
}
