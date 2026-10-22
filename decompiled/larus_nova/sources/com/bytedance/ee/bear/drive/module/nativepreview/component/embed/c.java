package com.bytedance.ee.bear.drive.module.nativepreview.component.embed;

import androidx.fragment.app.FragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import js5.f;
import kotlin.jvm.internal.Intrinsics;
import ts5.e;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements js5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f224508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pxb.a f224509b;

    @Override // js5.d
    public final void b() {
    }

    @Override // js5.d
    public final List<Class<? extends f>> getServices() {
        return new ArrayList();
    }

    public final FragmentActivity getActivity() {
        return this.f224508a;
    }

    @Override // js5.d
    public final DriveEmbedNativeRenderComponent a(e r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        return new DriveEmbedNativeRenderComponent(new WeakReference(this.f224508a), this.f224509b);
    }

    public c(FragmentActivity r100, pxb.a r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "webView");
        this.f224508a = r100;
        this.f224509b = r101;
    }
}
