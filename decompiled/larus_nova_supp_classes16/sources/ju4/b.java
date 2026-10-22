package ju4;

import android.view.View;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ String a;

    public b(String r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ((com.bytedance.ee.bear.route.h) k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class)).u5(this.a);
    }
}
