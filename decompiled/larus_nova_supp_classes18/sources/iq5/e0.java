package iq5;

import android.app.Application;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e0 implements p {
    public final SelectorScope a;

    @Override // iq5.p
    public final /* synthetic */ float b() {
        return 16.0f;
    }

    @Override // iq5.p
    public final int c() {
        return 2131256223;
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
        return r0.getString(2131887849);
    }

    public e0(SelectorScope r2) {
        Intrinsics.checkNotNullParameter(r2, "selectorScope");
        this.a = r2;
    }

    @Override // iq5.p
    public final boolean a(ce5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
        if (r3.g.n1().hasBenefit("common_wiki_node_management") == true) goto L5;
        return false;
    L5:
        SelectorScope r4 = this.a;
        if (r4 != SelectorScope.ALL) goto L8;
    L9:
        return true;
    L8:
        if (r4 == SelectorScope.WIKI_ONLY) goto L9;
        return false;
    }
}
