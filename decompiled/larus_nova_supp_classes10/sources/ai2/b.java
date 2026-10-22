package ai2;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public b() {
    }

    static {
    }

    public static final void a(RecyclerView r13, a r14) {
        if (r13.getVisibility() == 0) goto L5;
        return;
    L5:
        if (r13.isShown() == true) goto L7;
        return;
    L7:
        if (r13.getGlobalVisibleRect(new Rect()) == true) goto L81;
        return;
    L81:
        int[] r1 = new int[2];     // Catch: Exception -> L80
        LinearLayoutManager r15 = r13.getLayoutManager();     // Catch: Exception -> L80
        if ((r15 instanceof LinearLayoutManager) == false) goto L18;
        if (r15 == null) goto L16;
        LinearLayoutManager r2 = r15;     // Catch: Exception -> L80
        int[] r3 = {r2.findFirstVisibleItemPosition(), r2.findLastVisibleItemPosition()};     // Catch: Exception -> L80
        int r4 = r2.getOrientation();     // Catch: Exception -> L80
    L14:
        int[] r12 = r3;
        int r5 = r4;
        r1 = r12;
    L43:
        if (r1.length < 2) goto L90;
        r14.b(new Pair(Integer.valueOf(r1[0]), Integer.valueOf(r1[1])));     // Catch: Exception -> L80
        int r0 = r1[0];     // Catch: Exception -> L80
        int r6 = r1[1];     // Catch: Exception -> L80
        if (r0 > r6) goto L91;
    L47:
        if (r15 == null) goto L49;
        View r7 = r15.findViewByPosition(r0);     // Catch: Exception -> L80
    L50:
        if (r7 != null) goto L52;
    L77:
        if (r0 == r6) goto L94;
        r0 = r0 + 1;
        goto L47
    L94:
        return;
    L52:
        if (r7.getVisibility() != 0) goto L77;
        if (r7.isShown() == false) goto L77;
        if (r7.getGlobalVisibleRect(new Rect()) == false) goto L77;
        Rect r8 = new Rect();     // Catch: Exception -> L80
        boolean r9 = r7.getGlobalVisibleRect(r8);     // Catch: Exception -> L80
        if (r5 == 1) goto L61;
    L63:
        boolean r10 = false;
    L64:
        if (r5 == 0) goto L66;
    L68:
        boolean r11 = false;
    L69:
        if (r10 == true) goto L73;
        if (r11 == true) goto L73;
        boolean r16 = false;
    L74:
        if (r9 == false) goto L77;
        if (r16 == false) goto L77;
        r14.a(r0);     // Catch: Exception -> L80
    L73:
        r16 = true;
        goto L74
    L66:
        if (r8.width() < r7.getMeasuredWidth()) goto L68;
        r11 = true;
        goto L69
    L61:
        if (r8.height() < r7.getMeasuredHeight()) goto L63;
        r10 = true;
        goto L64
    L49:
        r7 = null;
        goto L50
    L91:
        return;
    L90:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");     // Catch: Exception -> L80
    L18:
        if ((r15 instanceof GridLayoutManager) == false) goto L24;
        if (r15 == null) goto L22;
        GridLayoutManager r17 = (GridLayoutManager) r15;     // Catch: Exception -> L80
        r3 = new int[]{r17.findFirstVisibleItemPosition(), r17.findLastVisibleItemPosition()};     // Catch: Exception -> L80
        r4 = r17.getOrientation();     // Catch: Exception -> L80
        goto L14
    L22:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");     // Catch: Exception -> L80
    L24:
        if ((r15 instanceof StaggeredGridLayoutManager) == false) goto L41;
        if (r15 == null) goto L40;
        StaggeredGridLayoutManager r18 = (StaggeredGridLayoutManager) r15;     // Catch: Exception -> L80
        int r19 = r18.getSpanCount();     // Catch: Exception -> L80
        int[] r20 = new int[r19];     // Catch: Exception -> L80
        int r21 = r18.getSpanCount();     // Catch: Exception -> L80
        int[] r22 = new int[r21];     // Catch: Exception -> L80
        r18.findFirstVisibleItemPositions(r20);     // Catch: Exception -> L80
        r18.findLastVisibleItemPositions(r22);     // Catch: Exception -> L80
        int r23 = r20[0];     // Catch: Exception -> L80
        int r24 = r22[0];     // Catch: Exception -> L80
        int r110 = 1;
    L27:
        if (r110 >= r19) goto L32;
        int r111 = r20[r110];     // Catch: Exception -> L80
        if (r23 <= r111) goto L31;
        r23 = r111;
    L31:
        r110 = r110 + 1;     // Catch: Exception -> L80
        goto L27
    L32:
        int r25 = 1;
    L33:
        if (r25 >= r21) goto L38;
        int r26 = r22[r25];     // Catch: Exception -> L80
        if (r24 >= r26) goto L37;
        r24 = r26;
    L37:
        r25 = r25 + 1;     // Catch: Exception -> L80
        goto L33
    L38:
        r3 = new int[]{r23, r24};     // Catch: Exception -> L80
        r4 = r18.getOrientation();     // Catch: Exception -> L80
        goto L14
    L40:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager");     // Catch: Exception -> L80
    L41:
        r5 = -1;
        goto L43
    }
}
