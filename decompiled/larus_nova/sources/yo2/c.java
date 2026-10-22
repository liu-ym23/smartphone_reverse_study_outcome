package yo2;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f568638a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f568638a.e().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        d r100 = this.f568638a;
        r100.f568646h = r100.e().getWidth();
        d r101 = this.f568638a;
        r101.f568647i = r101.e().getHeight();
        this.f568638a.getClass();
        d r102 = this.f568638a;
        r102.f568660v = false;
        if (r102.h() == false) goto L19;
        d r103 = this.f568638a;
        if (r103.f568661w == false) goto L20;
        int r104 = r103.f568646h;
        int r105 = r103.f568647i;
        View r106 = r103.f568654p;
        int r107 = r103.f568655q;
        int r108 = r103.f568656r;
        int r109 = r103.f568657s;
        int r110 = r103.f568658t;
        if (r103.f568639a == null) goto L22;
        int r111 = d.b(r106, r108, r104, r109);
        int r112 = d.c(r106, r107, r105, r110);
        LivePopupWindow r113 = r103.f568639a;
        if ((r113 instanceof PopupWindow) == false) goto L15;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r113) == false) goto L15;
        r113.update(r106, r111, r112, r104, r105);
        return;
    L15:
        if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r113, r106, r111, r112, r104, r105) == true) goto L23;
        r113.update(r106, r111, r112, r104, r105);
        return;
    L23:
        return;
    L22:
        return;
    L20:
        return;
    }

    public c(d r100) {
        this.f568638a = r100;
    }
}
