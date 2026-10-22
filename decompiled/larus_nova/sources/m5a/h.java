package m5a;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h f512176e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f512177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Integer, q> f512178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a> f512179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f512180d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f512181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f512182b;

        public a(String r100, g r101) {
            this.f512181a = r100;
            this.f512182b = r101;
        }
    }

    public final void c() {
        int r100 = 0;
    L4:
        if (r100 >= ((ArrayList) this.f512179c).size()) goto L21;
        q r101 = ((a) ListProtector.get(this.f512179c, r100)).f512182b.f512171a;
        if (r101.f512196f.isShowing() == false) goto L20;
        Window r102 = r101.f512196f.getWindow();
        if (r102 == null) goto L20;
        View r103 = q.a(r102);
        if (r103 == null) goto L20;
        r103.bringToFront();
        WindowManager r104 = (WindowManager) r101.getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r104 == null) goto L20;
        if (r103.getWindowToken() == null) goto L20;
        r104.updateViewLayout(r103, r102.getAttributes());     // Catch: IllegalArgumentException -> L22
    L20:
        r100 = r100 + 1;
        goto L4
    }

    static {
        f512176e = new h();
    }

    public final void b() {
        Iterator r100 = ((ArrayList) this.f512179c).iterator();
    L4:
        if (r100.hasNext() == false) goto L20;
        final q r101 = ((a) r100.next()).f512182b.f512171a;
        if (r101.f512191a == true) goto L8;
    L16:
        boolean r102 = false;
    L17:
        if (r102 == false) goto L4;
        r101.postOnAnimation(new m(r101));
        goto L4
    L8:
        if (r101.f512203m == true) goto L16;
        if (r101.f512196f.isShowing() == false) goto L16;
        if (r101.f512206p == null) goto L16;
        if (r101.f512208r == false) goto L16;
        r102 = true;
        goto L17
    }

    public h() {
        this.f512178b = new HashMap();
        new HashSet();
        this.f512179c = new ArrayList();
        this.f512180d = 0;
    }

    public final void a(a r100) {
        int r101 = ((ArrayList) this.f512179c).size();
        int r102 = 0;
    L4:
        if (r102 >= ((ArrayList) this.f512179c).size()) goto L9;
        if (r100.f512182b.f512173c > ((a) ListProtector.get(this.f512179c, r102)).f512182b.f512173c) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        r101 = r102;
    L9:
        ListProtector.add(this.f512179c, r101, r100);
    }
}
