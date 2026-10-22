package com.larus.camera.impl.ui.arch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tx8.d;
import tx8.e;
import tx8.f;
import tx8.g;
import tx8.h;
import tx8.i;
import tx8.j;

/* JADX INFO: loaded from: classes26.dex */
public abstract class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f321797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f321798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f321799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f321800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f321801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f321802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f321803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Lifecycle f321804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CoroutineScope f321805i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f321806j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f321807k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f321808l;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewModel f321809a;

        public final <T extends ViewModel> T a() {
            T r100 = (T) this.f321809a;
            if ((r100 instanceof ViewModel) == true) goto L7;
            return null;
        L7:
            return r100;
        }

        public a(BaseCameraViewModel r100) {
            Intrinsics.checkNotNullParameter(r100, "viewModel");
            this.f321809a = r100;
        }
    }

    public b() {
        this(null, 3);
    }

    public abstract View g(LayoutInflater r100, ViewGroup r101);

    public abstract void m();

    public void n() {
    }

    public final Context getContext() {
        return (Context) this.f321802f.getValue();
    }

    public final Lifecycle i() {
        return (Lifecycle) this.f321799c.getValue();
    }

    public final View j() {
        return (View) this.f321803g.getValue();
    }

    public final CoroutineScope k() {
        return (CoroutineScope) this.f321800d.getValue();
    }

    public final void l() {
        View r100 = this.f321807k;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r100 = null;
    L5:
        r100.setVisibility(8);
    }

    public final void o() {
        View r100 = this.f321807k;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r100 = null;
    L5:
        r100.setVisibility(0);
    }

    public final String toString() {
        return getClass().getSimpleName();
    }

    @Override // tx8.d
    public final String getId() {
        return this.f321808l;
    }

    @Override // tx8.d
    public final c getPriority() {
        return this.f321798b;
    }

    public static final a e(b r100) {
        return (a) r100.f321801e.getValue();
    }

    @Override // tx8.d
    public final void a(CameraContainer r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        r100.getClass();
        View r101 = this.f321807k;
        View r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r101 = null;
    L5:
        r100.removeView(r101);
        View r103 = this.f321807k;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L9:
        r100.addView(r102);
        return;
    L8:
        r102 = r103;
        goto L9
    }

    @Override // tx8.d
    public final void c(CameraContainer r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        r100.getClass();
        View r101 = this.f321807k;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r101 = null;
    L5:
        r100.removeView(r101);
        n();
    }

    public CameraContainer.b f(int r100) {
        CameraContainer.b r101 = new CameraContainer.b(-2, -2);
        ((FrameLayout.LayoutParams) r101).gravity = r100;
        return r101;
    }

    public final <T extends View> T h(int r100) {
        View r101 = this.f321807k;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r101 = null;
    L6:
        return (T) r101.findViewById(r100);
    }

    public b(int r100, c r101) {
        Intrinsics.checkNotNullParameter(r101, "priority");
        this.f321797a = r100;
        this.f321798b = r101;
        this.f321799c = LazyKt.lazy(new f(this));
        this.f321800d = LazyKt.lazy(new g(this));
        this.f321801e = LazyKt.lazy(new h(this));
        this.f321802f = LazyKt.lazy(new i(this));
        this.f321803g = LazyKt.lazy(new j(this));
        this.f321808l = getClass().getName();
    }

    public b(c r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        int r102 = 17;
    L7:
        if ((r101 & 2) == 0) goto L9;
        r100 = c.f321811b;
    L9:
        this(r102, r100);
        return;
    L5:
        r102 = 0;
        goto L7
    }

    @Override // tx8.d
    public final void b(BaseCameraViewModel r100, e r101, LifecycleOwner r102) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        this.f321806j = new a(r100);
        this.f321804h = r102.getLifecycle();
        this.f321805i = ViewModelKt.getViewModelScope(r100);
        CameraContainer r103 = r101.asView();
        this.f321807k = g(LayoutInflater.from(r103.getContext()), r103);
        CameraContainer.b r104 = f(this.f321797a);
        View r105 = this.f321807k;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r105 = null;
    L5:
        r103.addView(r105, r104);
        m();
    }
}
