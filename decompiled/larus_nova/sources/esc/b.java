package esc;

import android.graphics.Shader;
import io.github.alexzhirkevich.compottie.c0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0<Shader> f473827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<Shader> f473828b;

    public b() {
        this.f473827a = new c0(0);
        this.f473828b = new c0(0);
    }

    public final Shader a(int r100, boolean r101, Function0<? extends Shader> r102) {
        Intrinsics.checkNotNullParameter(r102, "factory");
        if (r101 == false) goto L5;
        c0 r103 = this.f473827a;
    L6:
        Integer r104 = Integer.valueOf(r100);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "put");
        if (r104 != null) goto L9;
        Object r105 = r102.invoke();
    L17:
        return (Shader) r105;
    L9:
        Object r106 = r103.f490734a.remove(r104);
        if (r106 != null) goto L12;
        r106 = null;
    L13:
        if (r106 != null) goto L15;
        Shader r107 = r102.invoke();
        r103.a(r104, r107);
        r105 = r107;
        goto L17
    L15:
        r105 = r106;
        goto L17
    L12:
        r103.a(r104, r106);
        goto L13
    L5:
        r103 = this.f473828b;
        goto L6
    }
}
