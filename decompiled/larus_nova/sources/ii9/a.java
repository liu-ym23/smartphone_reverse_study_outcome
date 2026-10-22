package ii9;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.List;
import ji9.f;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f490001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<String> f490002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Float, Unit> f490003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f490004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Integer> f490005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f490006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f490007g;

    @Override // ji9.f
    public final Function0<String> a() {
        return this.f490002b;
    }

    @Override // ji9.f
    public final Function1<Float, Unit> b() {
        return this.f490003c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(View r100, b r101) {
        this.f490001a = new WeakReference(r100);
        Function0<String> r102 = r101.f490008a;
        Function1 r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("id");
        r102 = null;
    L5:
        this.f490002b = r102;
        Function1 r104 = r101.f490009b;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("onExposeCallback");
    L9:
        this.f490003c = r103;
        this.f490004d = r101.f490010c;
        this.f490005e = r101.f490011d;
        this.f490006f = r101.f490012e;
        this.f490007g = r101.f490013f;
        return;
    L8:
        r103 = r104;
        goto L9
    }
}
