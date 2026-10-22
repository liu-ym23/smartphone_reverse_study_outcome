package com.larus.common_ui.view;

import android.view.View;
import android.view.ViewStub;
import androidx.viewbinding.ViewBinding;
import com.larus.utils.e1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b0<T extends ViewBinding> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewStub f328319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<View, T> f328320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f328321c;

    public final void a() {
        T r100 = this.f328321c;
        if (r100 == null) goto L8;
        View r101 = r100.getRoot();
        if (r101 == null) goto L9;
        e1.o(r101);
        return;
    L9:
        return;
    }

    public final T b() {
        if (this.f328321c != null) goto L11;
        ViewStub r100 = this.f328319a;
        if (r100 == null) goto L9;
        View r101 = r100.inflate();
        if (r101 == null) goto L9;
        T r102 = this.f328320b.invoke(r101);
    L10:
        this.f328321c = r102;
    L9:
        r102 = null;
    L11:
        T r103 = this.f328321c;
        if (r103 == null) goto L15;
        e1.x(r103.getRoot());
        return r103;
    L15:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b0(ViewStub r100, Function1<? super View, ? extends T> r101) {
        Intrinsics.checkNotNullParameter(r101, "viewBinder");
        this.f328319a = r100;
        this.f328320b = r101;
    }
}
