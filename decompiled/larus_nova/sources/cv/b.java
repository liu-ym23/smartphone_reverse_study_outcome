package cv;

import android.view.View;
import android.view.WindowInsets;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f465473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f465474b;

    public b(a r100, View r101) {
        this.f465474b = r100;
        this.f465473a = r101;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View r100, WindowInsets r101) {
        if (r101.isRound() == false) goto L6;
        int r102 = this.f465474b.f465449a.getResources().getDimensionPixelOffset(R.dimen.gamecp_alert_dialog_round_padding);
        this.f465473a.setPadding(r102, r102, r102, r102);
    L6:
        return r101.consumeSystemWindowInsets();
    }
}
