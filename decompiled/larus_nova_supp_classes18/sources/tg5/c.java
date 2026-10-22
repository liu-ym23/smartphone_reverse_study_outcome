package tg5;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends t {
    public final /* synthetic */ b c;

    public c(b r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r1) {
        p.a r2 = this.c.d;
        if (r2 == null) goto L6;
        r2.onBack();
        return;
    }
}
