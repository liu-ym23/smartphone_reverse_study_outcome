package x8b;

import android.view.View;
import com.ss.android.lark.contact.base.contact_list.page.ExternalContactFragment2;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExternalContactFragment2 f562955a;

    public b(ExternalContactFragment2 r100) {
        this.f562955a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        g r101 = f.b(this.f562955a);
        if (r101 == null) goto L5;
        r101.g(null);
        return;
    L5:
        this.f562955a.finish();
    }
}
