package nk9;

import android.graphics.Rect;
import com.larus.media.focus.CardContextState;
import com.larus.media.focus.OScrollStateHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements f {
    public a() {
    }

    public final c b(OScrollStateHelper r100, m r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerViewScrollStateHelper");
        Intrinsics.checkNotNullParameter(r101, "focusParent");
        Intrinsics.checkNotNullParameter(r102, "focusableCards");
        Rect r103 = r101.a();
        int r104 = r100.f359046m;
        if (r104 != 0) goto L5;
        int r105 = r103.centerX();
    L6:
        Iterator r106 = r102.iterator();
        int r107 = Integer.MAX_VALUE;
        c r108 = null;
    L8:
        if (r106.hasNext() == false) goto L16;
        c r109 = (c) r106.next();
        Rect r110 = r109.j();
        if (r104 != 0) goto L12;
        int r111 = r110.centerX();
    L13:
        int r112 = Math.abs(r111 - r105);
        if (r112 >= r107) goto L8;
        r108 = r109;
        r107 = r112;
        goto L8
    L12:
        r111 = r110.centerY();
        goto L13
    L16:
        return r108;
    L5:
        r105 = r103.centerY();
        goto L6
    }

    @Override // nk9.f
    public final c a(OScrollStateHelper r100, m r101, List r102, CardContextState r103) {
        Intrinsics.checkNotNullParameter(r100, "recyclerViewScrollStateHelper");
        Intrinsics.checkNotNullParameter(r101, "focusParent");
        Intrinsics.checkNotNullParameter(r102, "focusableCards");
        Intrinsics.checkNotNullParameter(r103, "state");
        return b(r100, r101, r102);
    }
}
