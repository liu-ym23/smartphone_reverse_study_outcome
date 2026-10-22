package j83;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ a a;

    public i(a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        a r3 = this.a;
        l r0 = r3.r;
        if (r0 == null) goto L6;
        r0.f.setMoreVideoExpanded(!r3.b());
        a r4 = this.a;
        r4.r.g.g(r4.b());
        return;
    }
}
