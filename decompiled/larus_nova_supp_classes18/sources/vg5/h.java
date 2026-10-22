package vg5;

import android.view.View;
import com.bytedance.ee.bear.share.export.UserInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ g a;
    public final /* synthetic */ UserInfo b;

    public h(g r1, UserInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.V0(this.b);
    }
}
