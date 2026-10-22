package com.bytedance.ee.bear.office.common.screenmenu;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements lk5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f235226a = null;

    static {
        f235226a = new i();
    }

    public i() {
    }

    @Override // lk5.b
    public final OfficeAnchoredMenuImpl a(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return new OfficeAnchoredMenuImpl(r100);
    }
}
