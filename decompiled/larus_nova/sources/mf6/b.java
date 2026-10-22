package mf6;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes45.dex */
public abstract class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<a> f513641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f513642e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f513643f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f513644g;

    @Override // mf6.a
    public final void e() {
        this.f513642e = true;
    }

    @Override // mf6.a
    public final void c() {
        Function0<Unit> r100 = this.f513643f;
        if (r100 == null) goto L6;
        Unit r101 = r100.invoke();
        return;
    }

    @Override // mf6.a
    public final boolean b() {
        return this.f513642e;
    }

    public b(long r100, Function0 r101) {
        super(r100);
        this.f513643f = r101;
        this.f513644g = null;
        this.f513641d = new ArrayList();
    }
}
