package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.action.ActionContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v0 {
    public SlcContext a;
    public com.bytedance.android.ecom.slice.ext.template.gecko.c b;
    public final com.bytedance.android.ecom.arch.slice.action.j c;
    public final com.bytedance.android.ecom.arch.slice.action.p d;
    public final ng3.a e;
    public final FragmentActivity f;
    public final l0 g;
    public final ActionContext h;
    public final l i;

    public final FragmentActivity getActivity() {
        return this.f;
    }

    public v0(FragmentActivity r2, GalleryFragment.k r3, ActionContext r4, l r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.c = r3.c(r2);
        this.d = r3.b(r2);
        this.e = r3.e();
    }
}
