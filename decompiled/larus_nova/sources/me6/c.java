package me6;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class c<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a<T> f513494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f513495b;

    public c() {
    }

    @Override // me6.f
    public final a<T> a() {
        a<T> r100 = this.f513494a;
        if (r100 == null) goto L5;
    L9:
        return r100;
    L5:
        if (this.f513495b <= 0) goto L7;
        String r101 = "INDETERMINATE";
    L8:
        r100 = new a(r101, null);
        goto L9
    L7:
        r101 = "NOT_APPLICABLE";
        goto L8
    }

    @Override // me6.f
    public final boolean b() {
        if (this.f513494a == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // me6.f
    public final void c(T r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "effect");
        if (b() == false) goto L5;
        return;
    L5:
        int r102 = r101.hashCode();
        if (r102 == (-1938393061)) goto L20;
        if (r102 == (-545586021)) goto L16;
        if (r102 == 2094604) goto L13;
        return;
    L13:
        if (r101.equals("DENY") == false) goto L26;
    L21:
        this.f513494a = new a(r101, CollectionsKt.listOf(r100));
        return;
    L26:
        return;
    L16:
        if (r101.equals("INDETERMINATE") == false) goto L27;
        this.f513495b++;
        return;
    L27:
        return;
    L20:
        if (r101.equals("PERMIT") == true) goto L21;
    }
}
