package v19;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class f6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f6 f552473a = null;

    static {
        f552473a = new f6();
    }

    public f6() {
    }

    public static int a(RecyclerView r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if ((r101 instanceof GridLayoutManager) == false) goto L9;
        View r102 = ((GridLayoutManager) r101).findViewByPosition(r110);
        if (r102 != null) goto L7;
        FLogger.f375446a.w("RecyclerViewDistanceHelper", "[calculateGridLayoutItemBottomDistance] Item view not found at position: " + r110);
    L19:
        return -1;
    L7:
        int r103 = r100.getHeight();
        int r104 = r102.getBottom();
        int r105 = r103 - r104;
        FLogger.f375446a.i("RecyclerViewDistanceHelper", "[calculateGridLayoutItemBottomDistance] Position: " + r110 + ", RecyclerView height: " + r103 + ", Item bottom: " + r104 + ", Distance from bottom: " + r105);
        return r105;
    L9:
        if ((r101 instanceof LinearLayoutManager) == false) goto L14;
        View r106 = ((LinearLayoutManager) r101).findViewByPosition(r110);
        if (r106 != null) goto L13;
        FLogger.f375446a.w("RecyclerViewDistanceHelper", "[calculateLinearLayoutItemBottomDistance] Item view not found at position: " + r110);
        goto L19
    L13:
        int r107 = r100.getHeight();
        int r108 = r106.getBottom();
        int r109 = r107 - r108;
        FLogger.f375446a.i("RecyclerViewDistanceHelper", "[calculateLinearLayoutItemBottomDistance] Position: " + r110 + ", RecyclerView height: " + r107 + ", Item bottom: " + r108 + ", Distance from bottom: " + r109);
        return r109;
    L14:
        FLogger r111 = FLogger.f375446a;
        StringBuilder r112 = new StringBuilder("[calculateItemBottomDistanceFromRecyclerViewBottom] Unsupported layout manager: ");
        if (r101 == null) goto L17;
        String r113 = r101.getClass().getSimpleName();
    L18:
        r112.append(r113);
        r111.w("RecyclerViewDistanceHelper", r112.toString());
        goto L19
    L17:
        r113 = null;
        goto L18
    }
}
