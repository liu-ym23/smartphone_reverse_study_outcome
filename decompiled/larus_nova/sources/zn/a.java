package zn;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.window.shop.home.presenter.ECWindowLinkageHeaderLivePresenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class a<T> implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f572891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c<T> f572892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<T, Unit> f572893c;

    @Override // zn.c
    public final T getValue() {
        return f().getValue();
    }

    public c<T> f() {
        return this.f572892b;
    }

    @Override // zn.c
    public final void b(Observer<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        f().b(r100);
    }

    @Override // zn.c
    public final void c(T r100) {
        this.f572891a = r100;
        Function1<T, Unit> r101 = this.f572893c;
        if (r101 == null) goto L5;
        Unit r102 = r101.invoke(r100);
    L5:
        f().c(r100);
    }

    @Override // zn.c
    public final void d(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        f().d(r100);
    }

    @Override // zn.c
    public final void setValue(T r100) {
        this.f572891a = r100;
        Function1<T, Unit> r101 = this.f572893c;
        if (r101 == null) goto L5;
        Unit r102 = r101.invoke(r100);
    L5:
        f().setValue(r100);
    }

    public a(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = false;
    L5:
        this.f572893c = null;
        if (r100 == true) goto L8;
        c<T> r102 = new f();
    L9:
        this.f572892b = r102;
        return;
    L8:
        r102 = new d();
        goto L9
    }

    @Override // zn.c
    public final void e(LifecycleOwner r100, ECWindowLinkageHeaderLivePresenter.c r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        f().e(r100, r101);
    }

    @Override // zn.c
    public final void a(LifecycleOwner r100, Observer<T> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        f().a(r100, r101, r102);
    }
}
