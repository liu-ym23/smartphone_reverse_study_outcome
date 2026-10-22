package wj0;

import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f559929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BehaviorSubject<c> f559930b;

    public final b a() {
        c r100 = this.f559929a;
        if ((r100 instanceof c.d) == false) goto L7;
        return ((c.d) r100).f559927a;
    L7:
        if ((r100 instanceof c.C8119c) == false) goto L11;
        return ((c.C8119c) r100).f559926a;
    L11:
        if ((r100 instanceof c.e) == false) goto L15;
        return ((c.e) r100).f559928a;
    L15:
        if ((r100 instanceof c.a) == true) goto L17;
        return null;
    L17:
        return ((c.a) r100).f559925a;
    }

    public d() {
        c.b r100 = new c.b();
        this.f559929a = r100;
        this.f559930b = BehaviorSubject.createDefault(r100);
    }

    public final void b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if ((r100 instanceof a.d) == false) goto L6;
        c.d r101 = new c.d(((a.d) r100).f559919a);
        this.f559929a = r101;
        this.f559930b.onNext(r101);
        return;
    L6:
        if ((r100 instanceof a.b) == false) goto L9;
        c.C8119c r102 = new c.C8119c(((a.b) r100).f559918a);
        this.f559929a = r102;
        this.f559930b.onNext(r102);
        return;
    L9:
        if ((r100 instanceof a.e) == false) goto L12;
        c.e r103 = new c.e(((a.e) r100).f559920a);
        this.f559929a = r103;
        this.f559930b.onNext(r103);
        return;
    L12:
        if ((r100 instanceof a.C8118a) == false) goto L15;
        c.a r104 = new c.a(((a.C8118a) r100).f559917a);
        this.f559929a = r104;
        this.f559930b.onNext(r104);
        return;
    L15:
        if ((r100 instanceof a.c) == false) goto L22;
        c.b r105 = new c.b();
        this.f559929a = r105;
        this.f559930b.onNext(r105);
        return;
    }
}
