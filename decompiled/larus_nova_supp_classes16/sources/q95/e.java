package q95;

import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public final View a;
    public final List<p95.b> b;
    public a c;
    public Point d;

    public static class a implements ViewTreeObserver.OnPreDrawListener {
        public final WeakReference<e> a;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            tt5.a.h("SizeDeterminer", "OnGlobalLayoutListener called listener=" + this);
            e r0 = this.a.get();
            if (r0 != null) goto L5;
            return true;
        L5:
            if (((ArrayList) r0.b).isEmpty() == true) goto L25;
            int r1 = r0.c();
            int r2 = r0.b();
            if (e.d(r1) == true) goto L10;
            return true;
        L10:
            if (e.d(r2) == false) goto L26;
            Iterator r3 = ((ArrayList) r0.b).iterator();
        L14:
            if (r3.hasNext() == false) goto L16;
            ((p95.b) r3.next()).onSizeReady(r1, r2);
            goto L14
        L16:
            ((ArrayList) r0.b).clear();
            ViewTreeObserver r4 = r0.a.getViewTreeObserver();
            if (r4.isAlive() == false) goto L19;
            r4.removeOnPreDrawListener(r0.c);
        L19:
            r0.c = null;
            return true;
        L26:
            return true;
        L25:
            return true;
        }

        public a(e r2) {
            this.a = new WeakReference(r2);
        }
    }

    public static boolean d(int r1) {
        if (r1 <= 0) goto L4;
    L7:
        return true;
    L4:
        if (r1 == (-2)) goto L7;
        return false;
    }

    public final int b() {
        ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
        if (d(this.a.getHeight()) == true) goto L5;
        if (r0 != null) goto L8;
        return 0;
    L8:
        return a(r0.height, true);
    L5:
        return this.a.getHeight();
    }

    public final int c() {
        ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
        if (d(this.a.getWidth()) == false) goto L7;
        return this.a.getWidth();
    L7:
        if (r0 != null) goto L9;
        return 0;
    L9:
        return a(r0.width, false);
    }

    public e(View r2) {
        this.b = new ArrayList();
        this.a = r2;
    }

    public final int a(int r2, boolean r3) {
        if (r2 != (-2)) goto L12;
        Point r4 = this.d;
        if (r4 != null) goto L8;
        Display r5 = ((WindowManager) this.a.getContext().getSystemService("window")).getDefaultDisplay();
        Point r0 = new Point();
        this.d = r0;
        r5.getSize(r0);
        r4 = this.d;
    L8:
        if (r3 == false) goto L11;
        return r4.y;
    L11:
        return r4.x;
    L12:
        return r2;
    }
}
