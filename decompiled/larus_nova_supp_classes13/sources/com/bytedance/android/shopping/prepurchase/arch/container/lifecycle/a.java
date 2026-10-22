package com.bytedance.android.shopping.prepurchase.arch.container.lifecycle;

import android.content.res.Configuration;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements com.bytedance.android.shopping.prepurchase.arch.container.intf.f, com.bytedance.android.shopping.prepurchase.arch.container.intf.b {
    public final LifecycleRegistry a;
    public final List<b> b;
    public final List<Function1<Configuration, Unit>> c;
    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.f d;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public final void H() {
        this.d.H();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public final void e(boolean r2) {
        this.d.e(r2);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public final Window f7() {
        return this.d.f7();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public final FragmentManager g7() {
        return this.d.g7();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public final ViewGroup getContainerView() {
        return this.d.getContainerView();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    /* JADX INFO: renamed from: getContext */
    public FragmentActivity mo2525getContext() {
        return this.d.mo2525getContext();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.a i7() {
        return this.d.i7();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public final Object k7() {
        return this.d.k7();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.g
    public final void a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        ((ArrayList) this.b).add(r2);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.g
    public final void b(Function1<? super Configuration, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.c).add(r2);
    }

    public final void c(Lifecycle.Event r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.a.f(r2);
    }

    public a(e r2, com.bytedance.android.shopping.prepurchase.arch.container.intf.f r3) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        Intrinsics.checkNotNullParameter(r3, "containerAbility");
        this.d = r3;
        this.a = new LifecycleRegistry(r2);
        this.b = new ArrayList();
        this.c = new ArrayList();
    }
}
