package tq5;

import android.view.View;
import com.bytedance.ee.bear.wikiv2.wikitreev2.move.WikiMovToFragment;

/* JADX INFO: loaded from: classes18.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiMovToFragment f547161a;

    public l(WikiMovToFragment r100) {
        this.f547161a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        gq5.d.l("cancel", this.f547161a.Y90().getSpaceId());
    }
}
