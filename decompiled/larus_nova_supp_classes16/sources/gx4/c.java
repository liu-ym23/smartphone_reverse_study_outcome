package gx4;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.api.toolbar.NavBarBottomInsetCompatEntity;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public NavBarBottomInsetCompatEntity a;
    public int b;

    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ pcb.a a;
        public final /* synthetic */ ocb.a b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            this.a.c(this.b);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            this.a.a(this.b);
        }

        public a(pcb.a r1, gx4.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static class b {
        public static final c a = null;

        static {
            a = new c();
        }
    }

    public c() {
        this.a = null;
    }

    public final View a(View r3, int r4) {
        tt5.a.h("ToolbarCompatHelper", "doCompat sEntity=" + this.a + " " + this.b);
        return b(r3, r4, false);
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [gx4.a] */
    public final View b(View r10, final int r11, final boolean r12) {
        NavBarBottomInsetCompatEntity r0 = this.a;
        if (r0 != null) goto L5;
    L29:
        return r10;
    L5:
        if (r0.isEnable() == false) goto L29;
        if (this.b <= this.a.getMinLimit()) goto L29;
        if (this.b > this.a.getMinHeight()) goto L29;
        final Context r7 = r10.getContext();
        final FrameLayout r1 = new FrameLayout(r7);
        r1.setId(View.generateViewId());
        r1.setTag("CompatNavBarLayout");
        if (r12 == false) goto L13;
    L15:
        r1.addView(r10);
        final pcb.a r13 = pcb.a.a.b((Activity) r7);
        if (r12 == true) goto L22;
        r1.setPadding(r1.getPaddingLeft(), r1.getPaddingTop(), r1.getPaddingRight(), this.a.getPadding());
        if (r13.isKeyboardShowing() == false) goto L20;
        ColorDrawable r2 = null;
    L21:
        r1.setBackground(r2);
    L27:
        r1.addOnAttachStateChangeListener(new a(r13, new gx4.a(this, r12, r1, r13, r7, r11)));
        return r1;
    L20:
        r2 = new ColorDrawable(n.h(r7, r11));
        goto L21
    L22:
        int r3 = r1.getPaddingLeft();
        int r4 = r1.getPaddingTop();
        int r5 = r1.getPaddingRight();
        if (r13.isKeyboardShowing() == false) goto L25;
        int r6 = this.a.getPadding();
    L26:
        r1.setPadding(r3, r4, r5, r6);
        goto L27
    L25:
        r6 = 0;
        goto L26
    L13:
        if (r10.getParent() == null) goto L15;
        ((ViewGroup) r10.getParent()).removeView(r10);
        goto L15
    }
}
