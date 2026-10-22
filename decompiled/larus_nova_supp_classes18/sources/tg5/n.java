package tg5;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n extends t {
    public final /* synthetic */ b c;

    public n(b r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r2) {
        Context r3 = this.c.a;
        Toast.showText(r3, r3.getString(2131889102));
    }
}
