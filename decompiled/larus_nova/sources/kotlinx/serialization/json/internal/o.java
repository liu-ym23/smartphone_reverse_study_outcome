package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class o extends l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ouc.a f505449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f505450d;

    @Override // kotlinx.serialization.json.internal.l
    public final void a() {
        this.f505444b = true;
        this.f505450d++;
    }

    @Override // kotlinx.serialization.json.internal.l
    public final void b() {
        int r100 = 0;
        this.f505444b = false;
        h("\n");
        int r101 = this.f505450d;
    L3:
        if (r100 >= r101) goto L5;
        h(this.f505449c.f526799a.f526838g);
        r100 = r100 + 1;
        goto L3
    }

    @Override // kotlinx.serialization.json.internal.l
    public final void c() {
        if (this.f505444b == false) goto L5;
        this.f505444b = false;
        return;
    L5:
        b();
    }

    @Override // kotlinx.serialization.json.internal.l
    public final void k() {
        e(' ');
    }

    @Override // kotlinx.serialization.json.internal.l
    public final void l() {
        this.f505450d--;
    }

    public o(z r100, ouc.a r101) {
        Intrinsics.checkNotNullParameter(r100, "writer");
        Intrinsics.checkNotNullParameter(r101, "json");
        super(r100);
        this.f505449c = r101;
    }
}
