package gv4;

import com.bytedance.ee.bear.bitable.uikit.Action;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public abstract class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f482820a;

    public e() {
    }

    public abstract boolean b(Action r100);

    public e(a r100) {
        this.f482820a = r100;
    }

    @Override // gv4.a
    public final void a(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (b(r100) == true) goto L8;
        a r101 = this.f482820a;
        if (r101 == null) goto L9;
        r101.a(r100);
        return;
    L9:
        return;
    }
}
