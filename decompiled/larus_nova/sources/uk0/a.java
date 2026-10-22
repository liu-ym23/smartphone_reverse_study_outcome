package uk0;

import com.bytedance.android.live.pushstream.d;
import fr2.g0;
import fr2.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import uf2.d0;
import uf2.z;
import xh6.c;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f550482a;

    public final k b() {
        d0 r100 = this.f550482a.getLiveCore();
        if (r100 == null) goto L12;
        z r101 = r100.C();
        if (r101 == null) goto L14;
        KClass r102 = Reflection.getOrCreateKotlinClass(k.class);
        c r103 = ((g0) vh6.c.b(g0.class)).o6().e(r102, r101);
        if (r103 == null) goto L11;
        return (k) r103;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type T");
    L14:
        return null;
    L12:
        return null;
    }

    public final boolean c() {
        return this.f550482a.a();
    }

    public a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "liveStream");
        this.f550482a = r100;
    }

    public final void a(boolean r100) {
        this.f550482a.t(r100);
    }
}
