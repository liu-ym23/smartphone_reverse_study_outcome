package jm3;

import android.view.KeyEvent;
import android.widget.TextView;
import com.bytedance.android.uicomponent.input.view.InputView;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InputView f499634a;

    public b(InputView r100) {
        this.f499634a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        TextView.OnEditorActionListener r103 = this.f499634a.getMOnEditorActionListener();
        if (r103 != null) goto L5;
        return false;
    L5:
        return r103.onEditorAction(r100, r101, r102);
    }
}
