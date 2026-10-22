package com.bytedance.ee.bear.document.alert;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements gp5.a.a {
    public final /* synthetic */ e a;
    public final /* synthetic */ AlertModel b;
    public final /* synthetic */ tb5.m c;

    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "text");
        e.e(this.a, ((AlertModel.ButtonsBean) ListProtector.get(this.b.getButtons(), 1)).getId(), r10, this.c, ((AlertModel.ButtonsBean) ListProtector.get(this.b.getButtons(), 1)).isAutoDismiss(), null, null, 48);
    }

    public h(e r1, AlertModel r2, tb5.m r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
