package xx3;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public a a;
    public final int b;

    public interface a {
        int XI();

        RecyclerView tA();
    }

    /* JADX INFO: renamed from: xx3.b$b, reason: collision with other inner class name */
    public interface InterfaceC0188b {
        boolean isTop();
    }

    public final boolean a() {
        a r0 = this.a;
        if (r0 != null) goto L5;
        RecyclerView r1 = null;
    L7:
        if (r1 != null) goto L10;
        return false;
    L10:
        if ((r1 instanceof AdapterView) == false) goto L19;
        AdapterView r2 = (AdapterView) r1;
        int r3 = r2.getFirstVisiblePosition();
        View r4 = r2.getChildAt(0);
        if (r4 == null) goto L16;
        if (r3 == 0) goto L15;
        return false;
    L15:
        if (r4.getTop() == 0) goto L16;
        return false;
    L16:
        return true;
    L19:
        if ((r1 instanceof ScrollView) == false) goto L25;
        if (((ScrollView) r1).getScrollY() > 0) goto L49;
        return true;
    L49:
        return false;
    L25:
        if ((r1 instanceof InterfaceC0188b) == true) goto L27;
        LinearLayoutManager r5 = r1.getLayoutManager();
        if ((r5 instanceof LinearLayoutManager) == false) goto L38;
        int r6 = r5.findFirstVisibleItemPosition();
        View r7 = r1.getChildAt(0);
        if (r7 == null) goto L45;
        if (r6 == 0) goto L35;
        return false;
    L35:
        if (r7.getTop() >= ((ViewGroup.MarginLayoutParams) r7.getLayoutParams()).topMargin) goto L45;
        return false;
    L45:
        return true;
    L38:
        if ((r5 instanceof StaggeredGridLayoutManager) == false) goto L52;
        int r8 = ((StaggeredGridLayoutManager) r5).findFirstVisibleItemPositions(null)[0];
        View r9 = r1.getChildAt(0);
        if (r9 == null) goto L45;
        if (r8 == 0) goto L44;
        return false;
    L44:
        if (r9.getTop() >= ((ViewGroup.MarginLayoutParams) r9.getLayoutParams()).topMargin) goto L45;
        return false;
    L52:
        return false;
    L27:
        return ((InterfaceC0188b) r1).isTop();
    L5:
        r1 = r0.tA();
        goto L7
    }

    public b() {
        this.b = Build.VERSION.SDK_INT;
    }

    public final void b(int r4, int r5, int r6) {
        a r0 = this.a;
        if (r0 != null) goto L5;
        RecyclerView r1 = null;
    L7:
        if ((r1 instanceof AbsListView) == false) goto L13;
        AbsListView r2 = (AbsListView) r1;
        if (this.b < 21) goto L11;
        r2.fling(r4);
        return;
    L11:
        r2.smoothScrollBy(r5, r6);
        return;
    L13:
        if ((r1 instanceof ScrollView) == false) goto L16;
        ((ScrollView) r1).fling(r4);
        return;
    L16:
        if ((r1 instanceof RecyclerView) == false) goto L19;
        r1.fling(0, r4);
        return;
    L19:
        if ((r1 instanceof WebView) == false) goto L26;
        ((WebView) r1).flingScroll(0, r4);
        return;
    L26:
        return;
    L5:
        r1 = r0.tA();
        goto L7
    }
}
