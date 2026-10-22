package com.bytedance.ee.bear.drive.module.nativepreview.component.embed;

import androidx.fragment.app.FragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import js5.f;
import kotlin.jvm.internal.Intrinsics;
import ts5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements js5.d {
    public final FragmentActivity a;
    public final pxb.a b;

    public final void b() {
    }

    public final List<Class<? extends f>> getServices() {
        return new ArrayList();
    }

    public final FragmentActivity getActivity() {
        return this.a;
    }

    public final DriveEmbedNativeRenderComponent a(e r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        return new DriveEmbedNativeRenderComponent(new WeakReference(this.a), this.b);
    }

    public c(FragmentActivity r2, pxb.a r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "webView");
        this.a = r2;
        this.b = r3;
    }
}
