package ql2;

import android.view.KeyEvent;
import android.view.View;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements View.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f533722a;

    public a(d r100) {
        this.f533722a = r100;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r100, int r101, KeyEvent r102) {
        if (r101 != 4) goto L6;
        PopupWindow r103 = this.f533722a.f533725a;
        PopupWindowLancet.handleDismissBeforeOrigin(r103);
        r103.dismiss();
        return true;
    L6:
        return false;
    }
}
