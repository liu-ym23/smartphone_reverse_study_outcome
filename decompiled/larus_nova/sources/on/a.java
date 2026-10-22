package on;

import android.graphics.Rect;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.store.utils.playable.controller.RestrictMarginAreaProcessor;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ln.c;
import ln.d;

/* JADX INFO: loaded from: classes44.dex */
public class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f524327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f524328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f524329c;

    /* JADX INFO: renamed from: on.a$a, reason: collision with other inner class name */
    public static final class C7073a {
    }

    static {
    }

    public void d() {
        throw null;
    }

    public a(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f524329c = r100;
        this.f524327a = new int[]{-1, -1};
        this.f524328b = new Rect();
    }

    @Override // ln.d
    public final List<c> a(RestrictMarginAreaProcessor r100) {
        monitor-enter(this);
        this.f524329c.getGlobalVisibleRect(this.f524328b);     // Catch: Throwable -> L25
        Rect r101 = this.f524328b;     // Catch: Throwable -> L25
        r101.bottom = RangesKt.coerceAtMost(r101.bottom, dg4.b.b());     // Catch: Throwable -> L25
        if (r100 == null) goto L7;
        r100.a(this.f524328b);     // Catch: Throwable -> L25
    L7:
        d();     // Catch: Throwable -> L25
        int r102 = b(this.f524329c);     // Catch: Throwable -> L25
        int r103 = c(this.f524329c);     // Catch: Throwable -> L25
        if (r102 == (-1)) goto L22;
        if (r103 == (-1)) goto L22;
        if (r103 < r102) goto L22;
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L25
        dm.a.a("测试播放范围").a("可播放的item范围:" + r102 + " to " + r103);     // Catch: Throwable -> L25
        if (r102 > r103) goto L19;
    L14:
        Object r105 = this.f524329c.findViewHolderForAdapterPosition(r102);     // Catch: Throwable -> L25
        if ((r105 instanceof c) == false) goto L17;
        r104.addAll(((c) r105).L(this.f524328b));     // Catch: Throwable -> L25
    L17:
        if (r102 == r103) goto L19;
        r102 = r102 + 1;     // Catch: Throwable -> L25
    L19:
        dm.a.a("测试播放范围").a("可播放的item个数:" + r104.size());     // Catch: Throwable -> L25
        List<c> r106 = r104;
        monitor-exit(this);
    L24:
        return r106;
    L22:
        r106 = CollectionsKt.emptyList();     // Catch: Throwable -> L25
        monitor-exit(this);
    L25:
        th = move-exception;
        throw th;
    }

    public final synchronized int b(RecyclerView r100) {
        monitor-enter(this);
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();     // Catch: Throwable -> L19
        int r102 = -1;
        if (r101 != null) goto L9;
        monitor-exit(this);
        return -1;
    L9:
        if ((r101 instanceof LinearLayoutManager) == false) goto L12;
        r102 = ((LinearLayoutManager) r101).findFirstVisibleItemPosition();     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return r102;
    L12:
        if ((r101 instanceof GridLayoutManager) == false) goto L15;
        r102 = ((GridLayoutManager) r101).findFirstVisibleItemPosition();     // Catch: Throwable -> L19
        goto L17
    L15:
        if ((r101 instanceof StaggeredGridLayoutManager) == false) goto L17;
        r102 = ArraysKt.first(((StaggeredGridLayoutManager) r101).findFirstVisibleItemPositions(this.f524327a));     // Catch: Throwable -> L19
        ArraysKt.fill$default(this.f524327a, -1, 0, 0, 6, null);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public final synchronized int c(RecyclerView r100) {
        monitor-enter(this);
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();     // Catch: Throwable -> L19
        int r102 = -1;
        if (r101 != null) goto L9;
        monitor-exit(this);
        return -1;
    L9:
        if ((r101 instanceof LinearLayoutManager) == false) goto L12;
        r102 = ((LinearLayoutManager) r101).findLastVisibleItemPosition();     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return r102;
    L12:
        if ((r101 instanceof GridLayoutManager) == false) goto L15;
        r102 = ((GridLayoutManager) r101).findLastVisibleItemPosition();     // Catch: Throwable -> L19
        goto L17
    L15:
        if ((r101 instanceof StaggeredGridLayoutManager) == false) goto L17;
        r102 = ArraysKt.first(((StaggeredGridLayoutManager) r101).findLastVisibleItemPositions(this.f524327a));     // Catch: Throwable -> L19
        ArraysKt.fill$default(this.f524327a, -1, 0, 0, 6, null);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }
}
