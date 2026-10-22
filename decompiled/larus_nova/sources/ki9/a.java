package ki9;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import li9.g;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f503650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<String> f503651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f503652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f503653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Integer> f503654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f503655f;

    @Override // li9.g
    public final void e() {
    }

    @Override // li9.g
    public final Function0<String> a() {
        return this.f503651b;
    }

    @Override // li9.g
    public final Function0<Unit> b() {
        return this.f503652c;
    }

    @Override // li9.g
    public final WeakReference<View> c() {
        return this.f503650a;
    }

    @Override // li9.g
    public final float d() {
        return this.f503653d;
    }

    @Override // li9.g
    public final List<Integer> f() {
        return this.f503654e;
    }

    public a(View r100, b r101) {
        this.f503650a = new WeakReference(r100);
        Function0<String> r102 = r101.f503656a;
        Function0<Unit> r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("id");
        r102 = null;
    L5:
        this.f503651b = r102;
        Function0<Unit> r104 = r101.f503657b;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("onExposeCallback");
    L9:
        this.f503652c = r103;
        this.f503653d = r101.f503658c;
        this.f503654e = r101.f503659d;
        this.f503655f = r101.f503660e;
        return;
    L8:
        r103 = r104;
        goto L9
    }
}
