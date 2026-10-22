package vp8;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f556658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f556659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f556660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f556661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f556662e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f556663f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Fragment f556664g;

    public void d() {
    }

    public boolean f(z0 r100) {
        return false;
    }

    public void i() {
    }

    public void l() {
    }

    public void n() {
    }

    public void o() {
    }

    public void p() {
    }

    public boolean q(r r100) {
        return false;
    }

    public void r(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
    }

    public void t(com.larus.bmhome.view.actionbar.edit.c r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
    }

    public void u(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
    }

    public final ICoreInputAbility c() {
        return (ICoreInputAbility) this.f556658a.getValue();
    }

    public g(final ComponentFeature r100) {
        Intrinsics.checkNotNullParameter(r100, "component");
        this.f556658a = LazyKt.lazy(new a(r100));
        this.f556659b = LazyKt.lazy(new b(r100));
        this.f556660c = LazyKt.lazy(new c(r100));
        this.f556661d = LazyKt.lazy(new d(r100));
        this.f556662e = LazyKt.lazy(new e(r100));
        this.f556663f = LazyKt.lazy(new f(r100));
        Intrinsics.checkNotNullParameter(r100, "<this>");
        this.f556664g = com.larus.ui.arch.component.internal.attach.a.b(r100, r100);
    }
}
