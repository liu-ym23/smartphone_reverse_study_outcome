package jm3;

import android.view.KeyEvent;
import android.widget.TextView;
import com.bytedance.android.uicomponent.input.view.InputView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements TextView.OnEditorActionListener {
    public final /* synthetic */ InputView a;

    public b(InputView r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r2, int r3, KeyEvent r4) {
        TextView.OnEditorActionListener r0 = this.a.getMOnEditorActionListener();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.onEditorAction(r2, r3, r4);
    }
}
