package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class m extends l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f505446c;

    @Override // kotlinx.serialization.json.internal.l
    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (this.f505446c == false) goto L5;
        super.j(r100);
        return;
    L5:
        h(r100);
    }

    public m(q r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "writer");
        super(r100);
        this.f505446c = r101;
    }
}
