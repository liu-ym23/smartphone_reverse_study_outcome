package iq5;

import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d0 implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SelectorScope f495352a;

    @Override // iq5.p
    public final /* synthetic */ float b() {
        return 16.0f;
    }

    @Override // iq5.p
    public final int c() {
        return R.drawable.ud_icon_sharedspace_colorful;
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
        return eu5.b.f474075a.getString(jq5.a.a());
    }

    public d0(SelectorScope r100) {
        Intrinsics.checkNotNullParameter(r100, "selectorScope");
        this.f495352a = r100;
    }

    @Override // iq5.p
    public final boolean a(ce5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentAbility");
        SelectorScope r101 = this.f495352a;
        if (r101 != SelectorScope.ALL) goto L5;
    L8:
        return true;
    L5:
        if (r101 == SelectorScope.SPACE_ONLY) goto L8;
        return false;
    }
}
