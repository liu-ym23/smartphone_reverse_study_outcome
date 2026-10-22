package yo2;

import android.view.KeyEvent;
import android.view.View;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements View.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f568636a;

    public a(d r100) {
        this.f568636a = r100;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r100, int r101, KeyEvent r102) {
        if (r101 != 4) goto L6;
        LivePopupWindow r103 = this.f568636a.f568639a;
        PopupWindowLancet.handleDismissBeforeOrigin(r103);
        r103.dismiss();
        return true;
    L6:
        return false;
    }
}
