package gx4;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.api.toolbar.NavBarBottomInsetCompatEntity;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NavBarBottomInsetCompatEntity f483112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f483113b;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ pcb.a f483114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ocb.a f483115b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            this.f483114a.c(this.f483115b);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            this.f483114a.a(this.f483115b);
        }

        public a(pcb.a r100, gx4.a r101) {
            this.f483114a = r100;
            this.f483115b = r101;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f483116a = null;

        static {
            f483116a = new c();
        }
    }

    public c() {
        this.f483112a = null;
    }

    public final View a(View r100, int r101) {
        tt5.a.h("ToolbarCompatHelper", "doCompat sEntity=" + this.f483112a + " " + this.f483113b);
        return b(r100, r101, false);
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [gx4.a] */
    public final View b(View r110, final int r111, final boolean r112) {
        NavBarBottomInsetCompatEntity r100 = this.f483112a;
        if (r100 != null) goto L5;
    L29:
        return r110;
    L5:
        if (r100.isEnable() == false) goto L29;
        if (this.f483113b <= this.f483112a.getMinLimit()) goto L29;
        if (this.f483113b > this.f483112a.getMinHeight()) goto L29;
        final Context r101 = r110.getContext();
        final FrameLayout r102 = new FrameLayout(r101);
        r102.setId(View.generateViewId());
        r102.setTag("CompatNavBarLayout");
        if (r112 == false) goto L13;
    L15:
        r102.addView(r110);
        final pcb.a r113 = pcb.a.AbstractC7181a.b((Activity) r101);
        if (r112 == true) goto L22;
        r102.setPadding(r102.getPaddingLeft(), r102.getPaddingTop(), r102.getPaddingRight(), this.f483112a.getPadding());
        if (r113.isKeyboardShowing() == false) goto L20;
        ColorDrawable r103 = null;
    L21:
        r102.setBackground(r103);
    L27:
        r102.addOnAttachStateChangeListener(new a(r113, new gx4.a(this, r112, r102, r113, r101, r111)));
        return r102;
    L20:
        r103 = new ColorDrawable(n.h(r101, r111));
        goto L21
    L22:
        int r104 = r102.getPaddingLeft();
        int r105 = r102.getPaddingTop();
        int r106 = r102.getPaddingRight();
        if (r113.isKeyboardShowing() == false) goto L25;
        int r107 = this.f483112a.getPadding();
    L26:
        r102.setPadding(r104, r105, r106, r107);
        goto L27
    L25:
        r107 = 0;
        goto L26
    L13:
        if (r110.getParent() == null) goto L15;
        ((ViewGroup) r110.getParent()).removeView(r110);
        goto L15
    }
}
