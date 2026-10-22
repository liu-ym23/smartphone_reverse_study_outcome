package be3;

import android.view.View;
import com.bytedance.android.shopping.feed.widget.BaseCardDetailView;
import com.bytedance.android.shopping.feed.widget.inflowcardtitle.InFlowCardTitleView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements View.OnLongClickListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ InFlowCardTitleView.b b;

    public a(boolean r1, BaseCardDetailView.g r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r1) {
        if (this.a == false) goto L8;
        InFlowCardTitleView.b r2 = this.b;
        if (r2 == null) goto L8;
        r2.a();
    L8:
        return this.a;
    }
}
