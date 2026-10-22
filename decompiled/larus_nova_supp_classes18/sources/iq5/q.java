package iq5;

import android.app.Application;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q implements p {
    public final SelectorScope a;

    @Override // iq5.p
    public final /* synthetic */ float b() {
        return 16.0f;
    }

    @Override // iq5.p
    public final /* synthetic */ int d() {
        return 0;
    }

    @Override // iq5.p
    public final int height() {
        return com.bytedance.ee.util.ui.n.d(48);
    }

    @Override // iq5.p
    public final String title() {
        Application r0 = eu5.b.a;
        int r1 = jq5.a.a;
        if (qc5.a.h() == false) goto L5;
        int r2 = 2131887934;
    L7:
        return r0.getString(r2);
    L5:
        r2 = 2131887935;
        goto L7
    }

    @Override // iq5.p
    public final int c() {
        return kac.a.b(2131254455);
    }

    public q(SelectorScope r2) {
        Intrinsics.checkNotNullParameter(r2, "selectorScope");
        this.a = r2;
    }

    @Override // iq5.p
    public final boolean a(ce5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        SelectorScope r3 = this.a;
        if (r3 != SelectorScope.ALL) goto L5;
    L8:
        return true;
    L5:
        if (r3 == SelectorScope.SPACE_ONLY) goto L8;
        return false;
    }
}
