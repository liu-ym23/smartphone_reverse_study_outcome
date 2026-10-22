package iq5;

import android.app.Application;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e0 implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SelectorScope f495361a;

    @Override // iq5.p
    public final /* synthetic */ float b() {
        return 16.0f;
    }

    @Override // iq5.p
    public final int c() {
        return R.drawable.ud_icon_wiki_colorful;
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
        Application r100 = eu5.b.f474075a;
        int r101 = jq5.a.f500067a;
        return r100.getString(R.string.Doc_Facade_Wiki);
    }

    public e0(SelectorScope r100) {
        Intrinsics.checkNotNullParameter(r100, "selectorScope");
        this.f495361a = r100;
    }

    @Override // iq5.p
    public final boolean a(ce5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentAbility");
        if (r100.f23452g.n1().hasBenefit("common_wiki_node_management") == true) goto L5;
        return false;
    L5:
        SelectorScope r101 = this.f495361a;
        if (r101 != SelectorScope.ALL) goto L8;
    L9:
        return true;
    L8:
        if (r101 == SelectorScope.WIKI_ONLY) goto L9;
        return false;
    }
}
