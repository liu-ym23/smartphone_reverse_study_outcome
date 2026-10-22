package com.ss.android.lark.watermark.userscope;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class WatermarkImplV3 implements com.ss.android.lark.watermark.v2.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WatermarkViewModelV3 f445349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SubprocessWatermarkViewModelV3 f445350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f445351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Application f445352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Disposable f445353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WeakHashMap<Object, com.ss.android.lark.watermark.v2.t> f445354f;

    public final com.ss.android.lark.watermark.v2.k f() {
        return (com.ss.android.lark.watermark.v2.k) this.f445351c.getValue();
    }

    public final boolean g() {
        return qyb.a.a(f().i().getText());
    }

    @Override // com.ss.android.lark.watermark.v2.o
    public final int s() {
        return f().s();
    }

    @Override // com.ss.android.lark.watermark.v2.o
    public final void b(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        com.ss.android.lark.watermark.v2.t r101 = this.f445354f.remove(r100);
        if (r101 == null) goto L9;
        Observer<com.ss.android.lark.watermark.v2.v> r102 = r101.f445554a.get();
        if (r102 == null) goto L7;
        f().b().removeObserver(r102);
        f().f().removeObserver(r102);
    L7:
        com.ss.android.lark.watermark.v2.q<?> r103 = r101.f445555b;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        r103.a(r100);
        return;
    }

    @Inject
    public WatermarkImplV3(WatermarkViewModelV3 r100, SubprocessWatermarkViewModelV3 r101) {
        Intrinsics.checkNotNullParameter(r100, "watermarkViewModelV3");
        Intrinsics.checkNotNullParameter(r101, "subprocessWatermarkViewModelV3");
        this.f445349a = r100;
        this.f445350b = r101;
        this.f445351c = LazyKt.lazy(new WatermarkImplV3$viewModel$2(this));
        this.f445352d = LarkContext.getApplication();
        this.f445354f = new WeakHashMap();
    }

    @Override // com.ss.android.lark.watermark.v2.o
    public final void a(Dialog r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == true) goto L9;
        if (r101 == null) goto L6;
    L8:
        d(f().b(), r100);
        return;
    L6:
        if (g() == false) goto L8;
    L9:
        d(f().f(), r100);
    }

    public final void d(final LiveData<com.ss.android.lark.watermark.v2.v> r100, Dialog r101) {
        final WeakReference r102 = new WeakReference(r101);
        final com.ss.android.lark.watermark.v2.q r103 = com.ss.android.lark.watermark.v2.r.a(r101);
        Observer<com.ss.android.lark.watermark.v2.v> r104 = new WatermarkImplV3$bindWatermarkToViewModel$observer$1(r102, r103, r100);
        r100.observeForever(r104);
        this.f445354f.put(r101, new com.ss.android.lark.watermark.v2.t(new WeakReference(r104), r103));
    }

    public final void e(LiveData<com.ss.android.lark.watermark.v2.v> r100, Fragment r101) {
        if (r101.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        com.ss.android.lark.watermark.v2.t r102 = this.f445354f.get(r101);
        if (r102 == null) goto L10;
        Observer<com.ss.android.lark.watermark.v2.v> r103 = r102.f445554a.get();
        if (r103 == null) goto L11;
        r100.removeObserver(r103);
    L11:
        com.ss.android.lark.watermark.v2.q r104 = com.ss.android.lark.watermark.v2.r.a(r101);
        WatermarkInternalFragmentObserver r105 = new WatermarkInternalFragmentObserver(r101, r104);
        r100.observe(r101, r105);
        this.f445354f.put(r101, new com.ss.android.lark.watermark.v2.t(new WeakReference(r105), r104));
        return;
    L10:
        r101.getLifecycle().addObserver(new WatermarkLifecycleEventObserver(this.f445354f));
        goto L11
    }

    public static final void c(WatermarkImplV3 r100, LiveData r101, Activity r102, LifecycleOwner r103) {
        r100.getClass();
        if (r103.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L13;
        com.ss.android.lark.watermark.v2.t r104 = r100.f445354f.get(r102);
        if (r104 == null) goto L10;
        Observer<com.ss.android.lark.watermark.v2.v> r105 = r104.f445554a.get();
        if (r105 == null) goto L11;
        r101.removeObserver(r105);
    L11:
        com.ss.android.lark.watermark.v2.q r106 = com.ss.android.lark.watermark.v2.r.a(r102);
        WatermarkInternalActivityObserver r107 = new WatermarkInternalActivityObserver(r102, r106);
        r101.observe(r103, r107);
        r100.f445354f.put(r102, new com.ss.android.lark.watermark.v2.t(new WeakReference(r107), r106));
        return;
    L10:
        r103.getLifecycle().addObserver(new WatermarkLifecycleEventObserver(r100.f445354f));
        goto L11
    }
}
