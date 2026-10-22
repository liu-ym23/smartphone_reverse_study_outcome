package jm3;

import android.view.View;
import com.bytedance.android.uicomponent.input.view.InputView;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InputView f499635a;

    public c(InputView r100) {
        this.f499635a = r100;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        View.OnFocusChangeListener r102 = this.f499635a.getMOnFocusChangeListener();
        if (r102 == null) goto L6;
        r102.onFocusChange(r100, r101);
        return;
    }
}
