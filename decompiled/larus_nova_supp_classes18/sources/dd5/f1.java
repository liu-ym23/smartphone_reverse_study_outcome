package dd5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f1 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void c(Fragment r3) {
        if ((r3 instanceof wc5.e) == true) goto L10;
        StringBuilder r0 = new StringBuilder("notify page selected skipped, fragment=");
        if (r3 == null) goto L7;
        String r4 = r3.getClass().getSimpleName();
    L8:
        r0.append(r4);
        r0.append(", reason=not IHomeSubFragment");
        tt5.a.h("OfficeRefreshHelper", r0.toString());
        return;
    L7:
        r4 = null;
        goto L8
    L10:
        tt5.a.h("OfficeRefreshHelper", "notify page selected, fragment=".concat(r3.getClass().getSimpleName()));
        ((wc5.e) r3).onPageSelected();
    }

    public static boolean e(View r5) {
        if ((r5 instanceof RecyclerView) == false) goto L9;
        RecyclerView r6 = (RecyclerView) r5;
        r6.stopScroll();
        LinearLayoutManager r0 = r6.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == false) goto L7;
        r0.scrollToPositionWithOffset(0, 0);
        return true;
    L7:
        r6.scrollToPosition(0);
        return true;
    L9:
        if ((r5 instanceof ViewGroup) == false) goto L16;
        ViewGroup r7 = (ViewGroup) r5;
        int r1 = r7.getChildCount();
        int r3 = 0;
    L11:
        if (r3 >= r1) goto L16;
        if (e(r7.getChildAt(r3)) == true) goto L14;
        r3 = r3 + 1;
        goto L11
    L14:
        return true;
    L16:
        return false;
    }

    public static void a(Fragment r7, View r8) {
        boolean r1 = false;
        String r2 = null;
        if ((r7 instanceof wc5.e) == true) goto L12;
        StringBuilder r0 = new StringBuilder("bind refresh layout skipped, fragment=");
        if (r7 == null) goto L7;
        r2 = r7.getClass().getSimpleName();
    L7:
        r0.append(r2);
        r0.append(", hasRefreshHost=");
        if (r8 == null) goto L10;
        r1 = true;
    L10:
        r0.append(r1);
        r0.append(", reason=not IHomeSubFragment");
        tt5.a.h("OfficeRefreshHelper", r0.toString());
        return;
    L12:
        StringBuilder r3 = new StringBuilder("bind refresh layout, fragment=");
        r3.append(r7.getClass().getSimpleName());
        r3.append(", hasRefreshHost=");
        if (r8 == null) goto L15;
        r1 = true;
    L15:
        r3.append(r1);
        tt5.a.h("OfficeRefreshHelper", r3.toString());
        wc5.e r9 = (wc5.e) r7;
        if ((r8 instanceof SmartRefreshLayout) == false) goto L18;
        r2 = (SmartRefreshLayout) r8;
    L18:
        r9.Co(r2);
    }

    public static SmartRefreshLayout b(Context r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        tt5.a.h("OfficeRefreshHelper", "create refresh host, contentContainerId=" + r5);
        SmartRefreshLayout r0 = new SmartRefreshLayout(r4);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r0.A = true;
        r0.g(false);
        r0.I = false;
        r0.J = false;
        r0.E = false;
        r0.V = true;
        r0.l = 0.5f;
        r0.H1 = 0.5f;
        r0.C(1.0f);
        r0.f = 200;
        r0.G(new b1(r4), com.bytedance.ee.util.ui.n.d(128));
        FrameLayout r1 = new FrameLayout(r4);
        r1.setId(r5);
        r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r0.addView(r1);
        return r0;
    }

    public static boolean d(Fragment r4, View r5) {
        SmartRefreshLayout r1 = null;
        if ((r4 instanceof wc5.e) == true) goto L9;
        StringBuilder r6 = new StringBuilder("notify tab reselected skipped, fragment=");
        if (r4 == null) goto L7;
        r1 = r4.getClass().getSimpleName();
    L7:
        r6.append(r1);
        r6.append(", reason=not IHomeSubFragment");
        tt5.a.h("OfficeRefreshHelper", r6.toString());
        return false;
    L9:
        if (r4 != null) goto L12;
        tt5.a.h("OfficeRefreshHelper", "notify tab reselected skipped, fragment is null");
        return false;
    L12:
        if ((r5 instanceof SmartRefreshLayout) == false) goto L14;
        r1 = (SmartRefreshLayout) r5;
    L14:
        if (r1 != null) goto L17;
        tt5.a.k("OfficeRefreshHelper", "notify tab reselected failed, refresh host missing, fragment=".concat(r4.getClass().getSimpleName()));
        return false;
    L17:
        if (e(r4.getView()) == true) goto L19;
        tt5.a.k("OfficeRefreshHelper", "notify tab reselected failed, recycler missing, fragment=".concat(r4.getClass().getSimpleName()));
        return false;
    L19:
        r1.post(new e1(r1));
        tt5.a.h("OfficeRefreshHelper", "notify tab reselected, fragment=".concat(r4.getClass().getSimpleName()));
        return true;
    }
}
