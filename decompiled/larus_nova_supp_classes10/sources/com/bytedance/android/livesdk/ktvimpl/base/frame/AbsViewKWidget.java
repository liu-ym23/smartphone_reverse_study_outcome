package com.bytedance.android.livesdk.ktvimpl.base.frame;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsViewKWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsKWidgetViewModel;", "T", "Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsLifeCycleKWidget;", "", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class AbsViewKWidget<T extends AbsKWidgetViewModel> extends AbsLifeCycleKWidget<T> {
    public final ViewModelStore b;
    public ViewGroup c;
    public final T d;
    public ViewGroup e;
    public c f;

    public void c() {
    }

    public int d() {
        return -1;
    }

    public abstract View e();

    public void f() {
    }

    public void h() {
        f();
        c();
    }

    public final ViewModelStore tf() {
        return this.b;
    }

    public final void g(ViewGroup.LayoutParams r4) {
        View r0 = e();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof ViewGroup) == true) goto L7;
        View r1 = null;
    L8:
        this.c = (ViewGroup) r1;
        if (r4 == null) goto L11;
        this.e.addView(r0, d(), r4);
    L12:
        h();
        return;
    L11:
        this.e.addView(r0, d());
        goto L12
    L7:
        r1 = r0;
        goto L8
    }

    public AbsViewKWidget(LifecycleOwner r2, ViewGroup r3, c r4) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        super(r2);
        this.e = r3;
        this.f = r4;
        this.b = new ViewModelStore();
        T r5 = (T) IKWidget.a.a(this);
        if (r5 == null) goto L5;
        r5.setMDataCenter(r5.getMDataCenter());
    L6:
        this.d = r5;
        new CompositeDisposable();
        return;
    L5:
        r5 = null;
        goto L6
    }
}
