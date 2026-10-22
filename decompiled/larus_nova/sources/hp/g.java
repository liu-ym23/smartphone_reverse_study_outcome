package hp;

import android.view.View;
import com.bytedance.android.ec.window.base.search.history.WindowHistoryBanner;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowHistoryBanner f486357a;

    public g(WindowHistoryBanner r100) {
        this.f486357a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        WindowHistoryBanner.b r101 = this.f486357a.getActionPerformListener();
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}
