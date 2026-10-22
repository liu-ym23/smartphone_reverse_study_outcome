package q20;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.browser.debug.mock.HybridHistoryListAdapter;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HybridHistoryListAdapter f531344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r20.a f531345b;

    public g(HybridHistoryListAdapter r100, r20.a r101) {
        this.f531344a = r100;
        this.f531345b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        FragmentActivity r101 = this.f531344a.getContext();
        if (r101 == null) goto L6;
        int r102 = a.f531331a;
        a.a(r101, this.f531345b.f535711c.toString());
        return;
    }
}
