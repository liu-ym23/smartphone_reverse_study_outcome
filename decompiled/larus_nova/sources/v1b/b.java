package v1b;

import com.ss.android.lark.chameleonv2.container.webcontainer.ChameleonWebViewManager;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChameleonWebViewManager f552655a;

    @Override // v1b.a
    public final void destroyAll() {
        this.f552655a.b();
    }

    @Inject
    public b() {
        this.f552655a = new ChameleonWebViewManager();
    }

    @Override // v1b.a
    public final ChameleonWebViewManager F2() {
        return this.f552655a;
    }
}
