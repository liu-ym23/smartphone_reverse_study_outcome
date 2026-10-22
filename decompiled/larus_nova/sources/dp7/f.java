package dp7;

import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class f extends cp7.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f469612a = null;

    static {
        f469612a = new f();
    }

    public f() {
    }

    @Override // cp7.c.a
    public final boolean a(cp7.b r210, View r211, int r212, int r213, int r214, int r215, int r216, int r310, cp7.c.a r311) {
        int r110 = 0;
        if ((r211 instanceof ViewGroup) == true) goto L5;
        return false;
    L5:
        if (cp7.c.a.C5565a.a(r211) == false) goto L7;
        return true;
    L7:
        ViewGroup r111 = (ViewGroup) r211;
        r210.a(r214, r215, r216, r310, cp7.c.a.C5565a.b(r111.getBackground()));
        int r100 = r111.getChildCount();
    L8:
        if (r110 >= r100) goto L21;
        View r112 = r111.getChildAt(r110);
        if (r112 == null) goto L20;
        int r113 = ((r212 + r112.getLeft()) - r111.getScrollX()) + ((int) r112.getTranslationX());
        int r101 = ((r213 + r112.getTop()) - r111.getScrollY()) + ((int) r112.getTranslationY());
        int r102 = ((r212 + r112.getRight()) - r111.getScrollX()) + ((int) r112.getTranslationX());
        int r103 = ((r213 + r112.getBottom()) - r111.getScrollY()) + ((int) r112.getTranslationY());
        if (r113 >= r216) goto L20;
        if (r101 >= r310) goto L20;
        if (r102 <= r214) goto L20;
        if (r103 <= r215) goto L20;
        if (r113 >= r102) goto L20;
        if (r101 >= r103) goto L20;
        List<cp7.c.a> r104 = cp7.a.f464706a;
        cp7.a.a(r210, r112, r113, r101, Math.max(r214, r113), Math.max(r215, r101), Math.min(r216, r102), Math.min(r310, r103), r311);
    L20:
        r110 = r110 + 1;
        goto L8
    L21:
        return true;
    }
}
