package me6;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class e<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<T> f513499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<T> f513500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f513501c;

    @Override // me6.f
    public final a<T> a() {
        if ((!this.f513499a.isEmpty()) == false) goto L7;
        return new a("PERMIT", this.f513499a);
    L7:
        if (this.f513501c <= 0) goto L11;
        return new a("INDETERMINATE", null);
    L11:
        if ((!this.f513500b.isEmpty()) == false) goto L15;
        return new a("DENY", this.f513500b);
    L15:
        return new a("NOT_APPLICABLE", null);
    }

    @Override // me6.f
    public final boolean b() {
        return !this.f513499a.isEmpty();
    }

    public e() {
        this.f513499a = new ArrayList();
        this.f513500b = new ArrayList();
    }

    @Override // me6.f
    public final void c(T r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "effect");
        if (b() == false) goto L5;
        return;
    L5:
        int r102 = r101.hashCode();
        if (r102 == (-1938393061)) goto L21;
        if (r102 == (-545586021)) goto L17;
        if (r102 == 2094604) goto L13;
        return;
    L13:
        if (r101.equals("DENY") == false) goto L28;
        ((ArrayList) this.f513500b).add(r100);
        return;
    L28:
        return;
    L17:
        if (r101.equals("INDETERMINATE") == false) goto L29;
        this.f513501c++;
        return;
    L29:
        return;
    L21:
        if (r101.equals("PERMIT") == false) goto L26;
        ((ArrayList) this.f513499a).add(r100);
        return;
    }
}
