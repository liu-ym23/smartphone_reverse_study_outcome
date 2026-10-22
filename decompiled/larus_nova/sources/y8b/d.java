package y8b;

import android.view.View;
import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import com.ss.android.lark.statistics.Statistics;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f566935a = null;

    static {
        f566935a = new d();
    }

    public d() {
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        if (r101 == false) goto L5;
        Statistics.sendEvent("addressbook_search_click", InvHitPoint.a());
        return;
    }
}
