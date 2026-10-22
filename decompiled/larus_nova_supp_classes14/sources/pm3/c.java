package pm3;

import android.view.View;
import com.bytedance.android.uicomponent.search.SearchView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ SearchView a;

    public c(SearchView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        SearchView r3 = this.a;
        View.OnClickListener r0 = r3.c;
        if (r0 == null) goto L6;
        r0.onClick(r3);
        return;
    }
}
