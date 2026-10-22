package pm3;

import android.view.View;
import com.bytedance.android.uicomponent.search.SearchView;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f529825a;

    public c(SearchView r100) {
        this.f529825a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        SearchView r101 = this.f529825a;
        View.OnClickListener r102 = r101.f187740c;
        if (r102 == null) goto L6;
        r102.onClick(r101);
        return;
    }
}
