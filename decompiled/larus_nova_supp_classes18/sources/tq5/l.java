package tq5;

import android.view.View;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.wikiv2.wikitreev2.move.WikiMovToFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ WikiMovToFragment a;

    public l(WikiMovToFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        gq5.d.l(DocFeed$Value$Result.CANCEL, this.a.Y90().getSpaceId());
    }
}
