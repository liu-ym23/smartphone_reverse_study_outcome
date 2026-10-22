package ae5;

import android.content.Context;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment;
import com.bytedance.ee.bear.list.t3;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n extends l {
    @Override // cd5.e
    public final void e(AppBarLayout r2) {
        wc5.f r3 = (wc5.f) r2.findViewById(2131374462);
        this.c = r3;
        r3.setViewDelegate(this);
        wc5.f r4 = (wc5.f) this.a.findViewById(2131372628);
        this.d = r4;
        r4.setViewDelegate(this);
        String r5 = this.b.getString(2131889614);
        this.d.setTitle(r5);
        this.c.setTitle(r5);
        Mj(t3.a);
        this.d.setVisibility(8);
        if (ForsetiHelper.n() == true) goto L5;
    L9:
        boolean r6 = false;
    L10:
        if (r6 == false) goto L13;
        this.c.setVisibility(8);
        return;
    L13:
        return;
    L5:
        if (this.a.getParentFragment() == null) goto L9;
        if ((this.a.getParentFragment() instanceof wc5.h) == false) goto L9;
        r6 = true;
        goto L10
    }

    public n(LazyBaseFragment r1, Context r2, AppBarLayout r3, ce5.a r4) {
        super(r1, r2, r3, r4);
    }
}
