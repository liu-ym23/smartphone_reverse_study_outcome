package u28;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements b {
    public a() {
    }

    public final int a(RecyclerView r100) {
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if ((r101 instanceof LinearLayoutManager) == false) goto L7;
        return ((LinearLayoutManager) r101).getOrientation();
    L7:
        throw new IllegalStateException("StickyListHeadersDecoration can only be used with a LinearLayoutManager.");
    }

    public final boolean b(RecyclerView r100) {
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if ((r101 instanceof LinearLayoutManager) == false) goto L7;
        return ((LinearLayoutManager) r101).getReverseLayout();
    L7:
        throw new IllegalStateException("StickyListHeadersDecoration can only be used with a LinearLayoutManager.");
    }
}
