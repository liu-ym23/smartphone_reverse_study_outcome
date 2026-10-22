package ub1;

import android.view.View;
import android.view.WindowInsets;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f549331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.uikit.dialog.a f549332b;

    public a(com.bytedance.android.live.uikit.dialog.a r100, View r101) {
        this.f549332b = r100;
        this.f549331a = r101;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View r100, WindowInsets r101) {
        if (r101.isRound() == false) goto L6;
        int r102 = this.f549332b.f102120a.getResources().getDimensionPixelOffset(R.dimen.alert_dialog_round_padding);
        this.f549331a.setPadding(r102, r102, r102, r102);
    L6:
        return r101.consumeSystemWindowInsets();
    }
}
