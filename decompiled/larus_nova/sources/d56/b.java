package d56;

import android.view.View;
import android.view.WindowInsets;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f467053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f467054b;

    public b(a r100, View r101) {
        this.f467054b = r100;
        this.f467053a = r101;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View r100, WindowInsets r101) {
        if (r101.isRound() == false) goto L6;
        int r102 = this.f467054b.f467036a.getResources().getDimensionPixelOffset(R.dimen.alert_dialog_round_padding);
        this.f467053a.setPadding(r102, r102, r102, r102);
    L6:
        return r101.consumeSystemWindowInsets();
    }
}
