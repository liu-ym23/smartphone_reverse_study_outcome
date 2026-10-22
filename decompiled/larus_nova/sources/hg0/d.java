package hg0;

import androidx.recyclerview.widget.RecyclerView;
import jg0.g;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f485002a;

    public static final class a {
    }

    static {
    }

    public d(RecyclerView r100) {
        this.f485002a = r100;
    }

    public final bd0.c a(int r100) {
        RecyclerView r101 = this.f485002a;
        if (r101 == null) goto L5;
        Object r102 = r101.findViewHolderForAdapterPosition(r100);
    L7:
        if ((r102 instanceof b) == false) goto L12;
        g r103 = ((b) r102).l();
        if (r103 != null) goto L11;
        return null;
    L11:
        return r103.f();
    L12:
        return null;
    L5:
        r102 = null;
        goto L7
    }
}
