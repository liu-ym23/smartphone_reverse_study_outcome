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

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f565327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f565328b;

    public interface a {
        int XI();

        RecyclerView tA();
    }

    /* JADX INFO: renamed from: xx3.b$b, reason: collision with other inner class name */
    public interface InterfaceC8283b {
        boolean isTop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a() {
        a r100 = this.f565327a;
        if (r100 != null) goto L5;
        RecyclerView r101 = 0;
    L7:
        if (r101 != 0) goto L10;
        return false;
    L10:
        if ((r101 instanceof AdapterView) == false) goto L19;
        AdapterView r102 = (AdapterView) r101;
        int r103 = r102.getFirstVisiblePosition();
        View r104 = r102.getChildAt(0);
        if (r104 == null) goto L16;
        if (r103 == 0) goto L15;
        return false;
    L15:
        if (r104.getTop() == 0) goto L16;
        return false;
    L16:
        return true;
    L19:
        if ((r101 instanceof ScrollView) == false) goto L25;
        if (((ScrollView) r101).getScrollY() > 0) goto L49;
        return true;
    L49:
        return false;
    L25:
        if ((r101 instanceof InterfaceC8283b) == true) goto L27;
        RecyclerView.LayoutManager r105 = r101.getLayoutManager();
        if ((r105 instanceof LinearLayoutManager) == false) goto L38;
        int r106 = ((LinearLayoutManager) r105).findFirstVisibleItemPosition();
        View r107 = r101.getChildAt(0);
        if (r107 == null) goto L45;
        if (r106 == 0) goto L35;
        return false;
    L35:
        if (r107.getTop() >= ((ViewGroup.MarginLayoutParams) r107.getLayoutParams()).topMargin) goto L45;
        return false;
    L45:
        return true;
    L38:
        if ((r105 instanceof StaggeredGridLayoutManager) == false) goto L52;
        int r108 = ((StaggeredGridLayoutManager) r105).findFirstVisibleItemPositions(null)[0];
        View r109 = r101.getChildAt(0);
        if (r109 == null) goto L45;
        if (r108 == 0) goto L44;
        return false;
    L44:
        if (r109.getTop() >= ((ViewGroup.MarginLayoutParams) r109.getLayoutParams()).topMargin) goto L45;
        return false;
    L52:
        return false;
    L27:
        return ((InterfaceC8283b) r101).isTop();
    L5:
        r101 = r100.tA();
        goto L7
    }

    public b() {
        this.f565328b = Build.VERSION.SDK_INT;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(int r100, int r101, int r102) {
        a r103 = this.f565327a;
        if (r103 != null) goto L5;
        RecyclerView r104 = 0;
    L7:
        if ((r104 instanceof AbsListView) == false) goto L13;
        AbsListView r105 = (AbsListView) r104;
        if (this.f565328b < 21) goto L11;
        r105.fling(r100);
        return;
    L11:
        r105.smoothScrollBy(r101, r102);
        return;
    L13:
        if ((r104 instanceof ScrollView) == false) goto L16;
        ((ScrollView) r104).fling(r100);
        return;
    L16:
        if ((r104 instanceof RecyclerView) == false) goto L19;
        r104.fling(0, r100);
        return;
    L19:
        if ((r104 instanceof WebView) == false) goto L26;
        ((WebView) r104).flingScroll(0, r100);
        return;
    L26:
        return;
    L5:
        r104 = r103.tA();
        goto L7
    }
}
