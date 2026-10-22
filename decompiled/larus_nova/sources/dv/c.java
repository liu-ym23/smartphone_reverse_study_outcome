package dv;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.bytedance.android.gamecp.common.ui.popup.manager.LivePopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f470086a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f470086a.d().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        d r100 = this.f470086a;
        r100.f470092f = r100.d().getWidth();
        d r101 = this.f470086a;
        r101.f470093g = r101.d().getHeight();
        this.f470086a.getClass();
        d r102 = this.f470086a;
        boolean r103 = false;
        r102.f470102p = false;
        LivePopupWindow r104 = r102.f470087a;
        if (r104 != null) goto L5;
    L7:
        if (r103 == false) goto L23;
        d r105 = this.f470086a;
        if (r105.f470103q == false) goto L24;
        int r106 = r105.f470092f;
        int r107 = r105.f470093g;
        View r108 = r105.f470097k;
        int r109 = r105.f470098l;
        int r110 = r105.f470099m;
        int r111 = r105.f470100n;
        int r112 = r105.f470101o;
        if (r105.f470087a == null) goto L26;
        int r113 = d.b(r108, r110, r106, r111);
        int r114 = d.c(r108, r109, r107, r112);
        LivePopupWindow r115 = r105.f470087a;
        if ((r115 instanceof PopupWindow) == false) goto L19;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r115) == false) goto L19;
        r115.update(r108, r113, r114, r106, r107);
        return;
    L19:
        if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r115, r108, r113, r114, r106, r107) == true) goto L27;
        r115.update(r108, r113, r114, r106, r107);
        return;
    L27:
        return;
    L26:
        return;
    L24:
        return;
    L23:
        return;
    L5:
        if (r104.isShowing() == false) goto L7;
        r103 = true;
        goto L7
    }

    public c(d r100) {
        this.f470086a = r100;
    }
}
