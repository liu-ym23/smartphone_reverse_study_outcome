package j83;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l;

/* JADX INFO: loaded from: classes13.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f497703a;

    public i(a r100) {
        this.f497703a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a r101 = this.f497703a;
        l r102 = r101.f497690r;
        if (r102 == null) goto L6;
        r102.f169328f.setMoreVideoExpanded(!r101.b());
        a r103 = this.f497703a;
        r103.f497690r.f169329g.g(r103.b());
        return;
    }
}
