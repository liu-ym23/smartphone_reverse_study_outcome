package iq5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements p {
    public final p a;
    public final p b;

    @Override // iq5.p
    public final float b() {
        return 14.0f;
    }

    @Override // iq5.p
    public final int c() {
        return -1;
    }

    @Override // iq5.p
    public final /* synthetic */ int d() {
        return 0;
    }

    @Override // iq5.p
    public final int height() {
        return com.bytedance.ee.util.ui.n.d(44);
    }

    @Override // iq5.p
    public final String title() {
        return eu5.b.a.getString(2131888777);
    }

    @Override // iq5.p
    public final boolean a(ce5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        if (this.a.a(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.b.a(r2) == true) goto L8;
        return false;
    }

    public a(q r2, d0 r3) {
        Intrinsics.checkNotNullParameter(r2, "myFolder");
        Intrinsics.checkNotNullParameter(r3, "shareFolder");
        this.a = r2;
        this.b = r3;
    }
}
