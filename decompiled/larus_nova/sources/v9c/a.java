package v9c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public abstract class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o9c.c f553910a;

    @Override // v9c.e
    public abstract /* synthetic */ String update(q9c.a r100);

    public a(o9c.c r100) {
        Intrinsics.checkNotNullParameter(r100, "storage");
        this.f553910a = r100;
    }

    @Override // v9c.e
    public String a(q9c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "reachPointAction");
        Object r101 = this.f553910a.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.toString();
    }
}
