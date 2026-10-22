package me6;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class g<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a<T> f513502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f513503b;

    public g() {
    }

    @Override // me6.f
    public final boolean b() {
        return false;
    }

    @Override // me6.f
    public final a<T> a() {
        a<T> r100 = this.f513502a;
        if (r100 == null) goto L5;
    L9:
        return r100;
    L5:
        if (this.f513503b <= 0) goto L7;
        String r101 = "INDETERMINATE";
    L8:
        r100 = new a(r101, null);
        goto L9
    L7:
        r101 = "NOT_APPLICABLE";
        goto L8
    }

    @Override // me6.f
    public final void c(T r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "effect");
        int r102 = r101.hashCode();
        if (r102 == (-1938393061)) goto L17;
        if (r102 == (-545586021)) goto L13;
        if (r102 == 2094604) goto L10;
        return;
    L10:
        if (r101.equals("DENY") == true) goto L19;
        return;
    L19:
        if (this.f513502a != null) goto L21;
        a<T> r103 = new a(r101, CollectionsKt.listOf(r100));
    L22:
        this.f513502a = r103;
        return;
    L21:
        r103 = new a("INDETERMINATE", null);
        goto L22
    L13:
        if (r101.equals("INDETERMINATE") == false) goto L28;
        this.f513503b++;
        return;
    L28:
        return;
    L17:
        if (r101.equals("PERMIT") == true) goto L19;
    }
}
