package com.bytedance.locallife.poi.memory;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/poi/memory/PoiMemoryRecycleLifecycleObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiMemoryRecycleLifecycleObserver implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f262932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f262933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f262934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f262935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LifecycleOwner f262936e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f262937f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f262938g;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f262939a = null;

        static {
            int[] r100 = new int[Lifecycle.Event.values().length];
            r100[Lifecycle.Event.ON_RESUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Lifecycle.Event.ON_STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f262939a = r100;
        }
    }

    public final void a(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        this.f262936e = r100;
        r100.getLifecycle().addObserver(this);
        this.f262932a.a(r100, new PoiMemoryRecycleLifecycleObserver$attach$1(this));
        if (r100.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L6;
        this.f262937f = false;
        return;
    }

    public PoiMemoryRecycleLifecycleObserver(Function0 r100, com.bytedance.locallife.poi.memory.a r101) {
        c r102 = c.f262947a;
        Intrinsics.checkNotNullParameter(r102, "signalProvider");
        Intrinsics.checkNotNullParameter(r100, "isEnabled");
        Intrinsics.checkNotNullParameter(r101, "handler");
        this.f262932a = r102;
        this.f262933b = r100;
        this.f262934c = r101;
        this.f262935d = new Handler(Looper.getMainLooper());
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        int r102 = a.f262939a[r101.ordinal()];
        if (r102 != 1) goto L5;
        this.f262937f = false;
        if (this.f262938g == false) goto L19;
        this.f262938g = false;
        this.f262934c.restore();
        return;
    L19:
        return;
    L5:
        if (r102 != 2) goto L7;
        this.f262937f = true;
        return;
    L7:
        if (r102 != 3) goto L18;
        this.f262935d.removeCallbacksAndMessages(null);
        r100.getLifecycle().removeObserver(this);
        return;
    }
}
