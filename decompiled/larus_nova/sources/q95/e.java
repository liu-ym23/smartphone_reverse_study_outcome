package q95;

import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f532106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<p95.b> f532107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f532108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Point f532109d;

    public static class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<e> f532110a;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            tt5.a.h("SizeDeterminer", "OnGlobalLayoutListener called listener=" + this);
            e r100 = this.f532110a.get();
            if (r100 != null) goto L5;
            return true;
        L5:
            if (((ArrayList) r100.f532107b).isEmpty() == true) goto L25;
            int r101 = r100.c();
            int r102 = r100.b();
            if (e.d(r101) == true) goto L10;
            return true;
        L10:
            if (e.d(r102) == false) goto L26;
            Iterator r103 = ((ArrayList) r100.f532107b).iterator();
        L14:
            if (r103.hasNext() == false) goto L16;
            ((p95.b) r103.next()).onSizeReady(r101, r102);
            goto L14
        L16:
            ((ArrayList) r100.f532107b).clear();
            ViewTreeObserver r104 = r100.f532106a.getViewTreeObserver();
            if (r104.isAlive() == false) goto L19;
            r104.removeOnPreDrawListener(r100.f532108c);
        L19:
            r100.f532108c = null;
            return true;
        L26:
            return true;
        L25:
            return true;
        }

        public a(e r100) {
            this.f532110a = new WeakReference(r100);
        }
    }

    public static boolean d(int r100) {
        if (r100 <= 0) goto L4;
    L7:
        return true;
    L4:
        if (r100 == (-2)) goto L7;
        return false;
    }

    public final int b() {
        ViewGroup.LayoutParams r100 = this.f532106a.getLayoutParams();
        if (d(this.f532106a.getHeight()) == true) goto L5;
        if (r100 != null) goto L8;
        return 0;
    L8:
        return a(r100.height, true);
    L5:
        return this.f532106a.getHeight();
    }

    public final int c() {
        ViewGroup.LayoutParams r100 = this.f532106a.getLayoutParams();
        if (d(this.f532106a.getWidth()) == false) goto L7;
        return this.f532106a.getWidth();
    L7:
        if (r100 != null) goto L9;
        return 0;
    L9:
        return a(r100.width, false);
    }

    public e(View r100) {
        this.f532107b = new ArrayList();
        this.f532106a = r100;
    }

    public final int a(int r100, boolean r101) {
        if (r100 != (-2)) goto L12;
        Point r102 = this.f532109d;
        if (r102 != null) goto L8;
        Display r103 = ((WindowManager) this.f532106a.getContext().getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
        Point r104 = new Point();
        this.f532109d = r104;
        r103.getSize(r104);
        r102 = this.f532109d;
    L8:
        if (r101 == false) goto L11;
        return r102.y;
    L11:
        return r102.x;
    L12:
        return r100;
    }
}
