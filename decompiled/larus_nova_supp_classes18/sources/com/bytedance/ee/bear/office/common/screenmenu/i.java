package com.bytedance.ee.bear.office.common.screenmenu;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements lk5.b {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    @Override // lk5.b
    public final OfficeAnchoredMenuImpl a(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return new OfficeAnchoredMenuImpl(r2);
    }
}
