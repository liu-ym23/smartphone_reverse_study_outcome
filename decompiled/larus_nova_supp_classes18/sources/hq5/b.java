package hq5;

import android.view.View;
import com.bytedance.ee.bear.wikiv2.searchv2.enh.WikiSearchbar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ WikiSearchbar a;

    public b(WikiSearchbar r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        WikiSearchbar r3 = this.a;
        int r0 = WikiSearchbar.i;
        r3.a();
    }
}
