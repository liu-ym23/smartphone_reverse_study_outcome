package tg5;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f545871c;

    public c(b r100) {
        this.f545871c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        p.a r101 = this.f545871c.f545854d;
        if (r101 == null) goto L6;
        r101.onBack();
        return;
    }
}
