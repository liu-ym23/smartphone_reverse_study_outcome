package so;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.window.base.dynamicview.virtualview.k;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f542694a;

    public static final class a {
    }

    static {
    }

    public d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        this.f542694a = r100;
    }

    public final <V extends View> V a(to.e r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueId");
        k.a r101 = k.f49316i;
        View r102 = this.f542694a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "view");
        Intrinsics.checkNotNullParameter(r100, "uniqueId");
        if (Intrinsics.areEqual(r102.getTag(k.f49313f), r100) == true) goto L37;
        if ((r100 instanceof to.e.a) == false) goto L9;
        r102 = k.a.a(r102, ((to.e.a) r100).f546891b);
        goto L37
    L9:
        if ((r100 instanceof to.e.c) == false) goto L42;
        List<String> r103 = ((to.e.c) r100).f546892b;
        if (r103.isEmpty() == true) goto L35;
        Iterator<String> r104 = r103.iterator();
    L15:
        if (r104.hasNext() == false) goto L37;
        String r105 = r104.next();
        if ((r102 instanceof ViewGroup) == false) goto L19;
        ViewGroup r106 = (ViewGroup) r102;
        int r107 = r106.getChildCount();
        int r108 = 0;
    L22:
        if (r108 >= r107) goto L31;
        View r109 = r106.getChildAt(r108);
        if (r109 == null) goto L29;
        if (Intrinsics.areEqual(r109.getTag(k.f49313f), r105) == false) goto L29;
        r102 = r109;
    L34:
        if (r102 != null) goto L15;
    L29:
        r108 = r108 + 1;
        goto L22
    L31:
        if (Intrinsics.areEqual(r102.getTag(k.f49313f), r105) == true) goto L34;
    L33:
        r102 = null;
        goto L34
    L19:
        if (Intrinsics.areEqual(r102.getTag(k.f49313f), r105) == false) goto L33;
    L35:
        r102 = null;
        goto L37
    L42:
        throw new NoWhenBranchMatchedException();
    L37:
        if ((r102 instanceof View) == true) goto L40;
        return null;
    L40:
        return (V) r102;
    }
}
