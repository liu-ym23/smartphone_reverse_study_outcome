package ql2;

import android.view.KeyEvent;
import android.view.View;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements View.OnKeyListener {
    public final /* synthetic */ d a;

    public a(d r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r1, int r2, KeyEvent r3) {
        if (r2 != 4) goto L6;
        PopupWindow r4 = this.a.a;
        PopupWindowLancet.handleDismissBeforeOrigin(r4);
        r4.dismiss();
        return true;
    L6:
        return false;
    }
}
