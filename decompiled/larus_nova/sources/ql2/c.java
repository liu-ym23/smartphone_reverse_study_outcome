package ql2;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f533724a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f533724a.d().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        d r100 = this.f533724a;
        r100.f533729e = r100.d().getWidth();
        d r101 = this.f533724a;
        r101.f533730f = r101.d().getHeight();
        this.f533724a.getClass();
        d r102 = this.f533724a;
        boolean r103 = false;
        r102.f533738n = false;
        PopupWindow r104 = r102.f533725a;
        if (r104 != null) goto L5;
    L7:
        if (r103 == false) goto L23;
        d r105 = this.f533724a;
        if (r105.f533739o == false) goto L24;
        int r106 = r105.f533729e;
        int r107 = r105.f533730f;
        View r108 = r105.f533733i;
        int r109 = r105.f533734j;
        int r110 = r105.f533735k;
        int r111 = r105.f533736l;
        int r112 = r105.f533737m;
        if (r105.f533725a == null) goto L26;
        int r113 = d.b(r108, r110, r106, r111);
        int r114 = d.c(r108, r109, r107, r112);
        PopupWindow r115 = r105.f533725a;
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
        this.f533724a = r100;
    }
}
