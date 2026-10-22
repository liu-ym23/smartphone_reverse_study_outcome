package jm3;

import android.view.View;
import com.bytedance.android.uicomponent.input.view.InputView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements View.OnFocusChangeListener {
    public final /* synthetic */ InputView a;

    public c(InputView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r2, boolean r3) {
        View.OnFocusChangeListener r0 = this.a.getMOnFocusChangeListener();
        if (r0 == null) goto L6;
        r0.onFocusChange(r2, r3);
        return;
    }
}
