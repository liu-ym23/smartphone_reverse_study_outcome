package dw7;

import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter;
import wv7.d;

/* JADX INFO: loaded from: classes23.dex */
public final class c {
    public static <T> T a(RecyclerView.Adapter r100, Class<T> r101) {
        if (r101.isInstance(r100) == false) goto L7;
        return r101.cast(r100);
    L7:
        if ((r100 instanceof SimpleWrapperAdapter) == true) goto L9;
        return null;
    L9:
        return (T) a(((SimpleWrapperAdapter) r100).f276015a, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.recyclerview.widget.RecyclerView$Adapter] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.recyclerview.widget.RecyclerView$Adapter] */
    public static int b(RecyclerView.Adapter r100, SimpleWrapperAdapter r101, int r102) {
        wv7.b r103 = new wv7.b();
        if (r100 == 0) goto L25;
    L5:
        if (r102 == (-1)) goto L15;
        if (r100 == r101) goto L15;
        if ((r100 instanceof d) == false) goto L11;
        r103.f561598a = null;
        r103.f561599b = -1;
        ((d) r100).w1(r103, r102);
        r102 = r103.f561599b;
        r100 = r103.f561598a;
        if (r100 != 0) goto L5;
    L11:
        if (r101 == null) goto L15;
        r102 = -1;
    L15:
        if (r101 == null) goto L19;
        if (r100 == r101) goto L19;
        return -1;
    L19:
        return r102;
    L25:
        return -1;
    }
}
