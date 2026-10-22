package me6;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class h<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<T> f513504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<T> f513505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f513506c;

    @Override // me6.f
    public final boolean b() {
        return false;
    }

    @Override // me6.f
    public final a<T> a() {
        if ((!this.f513504a.isEmpty()) == false) goto L7;
        return new a("PERMIT", this.f513504a);
    L7:
        if (this.f513506c <= 0) goto L11;
        return new a("INDETERMINATE", null);
    L11:
        if ((!this.f513505b.isEmpty()) == false) goto L15;
        return new a("DENY", this.f513505b);
    L15:
        return new a("NOT_APPLICABLE", null);
    }

    public h() {
        this.f513504a = new ArrayList();
        this.f513505b = new ArrayList();
    }

    @Override // me6.f
    public final void c(T r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "effect");
        int r102 = r101.hashCode();
        if (r102 == (-1938393061)) goto L18;
        if (r102 == (-545586021)) goto L14;
        if (r102 == 2094604) goto L10;
        return;
    L10:
        if (r101.equals("DENY") == false) goto L25;
        ((ArrayList) this.f513505b).add(r100);
        return;
    L25:
        return;
    L14:
        if (r101.equals("INDETERMINATE") == false) goto L26;
        this.f513506c++;
        return;
    L26:
        return;
    L18:
        if (r101.equals("PERMIT") == false) goto L23;
        ((ArrayList) this.f513504a).add(r100);
        return;
    }
}
