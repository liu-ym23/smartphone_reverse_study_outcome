package l3b;

import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.s;
import com.ss.android.lark.blueprint.t;
import com.ss.android.lark.chat.base.view.vo.message.f;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {
    public static final BubbleStyle a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getVisibility() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L9;
        return null;
    L9:
        k3b.a r102 = b(r100);
        if (r102 != null) goto L12;
        return null;
    L12:
        return r102.e();
    L5:
        r101 = false;
        goto L7
    }

    public static final k3b.a b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = 0;
        if (r100.getVisibility() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L9;
        return null;
    L9:
        int r103 = r100.getChildCount();
    L10:
        if (r101 >= r103) goto L29;
        View r104 = r100.getChildAt(r101);
        Intrinsics.checkNotNullParameter(r104, "<this>");
        Object r105 = r104.getTag(R.id.blueprint_block_view);
        if ((r105 instanceof k) == false) goto L14;
        k r106 = (k) r105;
    L16:
        if ((r106 instanceof t) == false) goto L18;
        t r107 = (t) r106;
    L19:
        if (r107 == null) goto L21;
        s r108 = r107.a();
    L23:
        if ((r108 instanceof k3b.a) == false) goto L25;
        k3b.a r109 = (k3b.a) r108;
    L26:
        if (r109 != null) goto L28;
        r101 = r101 + 1;
        goto L10
    L28:
        return r109;
    L25:
        r109 = null;
        goto L26
    L21:
        r108 = null;
        goto L23
    L18:
        r107 = null;
        goto L19
    L14:
        r106 = null;
        goto L16
    L29:
        return null;
    L5:
        r102 = false;
        goto L7
    }

    public static final u5b.c c(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getVisibility() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L9;
        return null;
    L9:
        k3b.a r102 = b(r100);
        if (r102 != null) goto L12;
        return null;
    L12:
        return r102.d();
    L5:
        r101 = false;
        goto L7
    }

    public static final boolean e(y6b.a<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.b();
        if ((r101 instanceof f) == false) goto L5;
        f r102 = (f) r101;
    L6:
        if (r102 != null) goto L8;
    L12:
        return false;
    L8:
        if (r102.f411956f != 3) goto L12;
        if (r102.f411957g == null) goto L12;
        return true;
    L5:
        r102 = null;
        goto L6
    }

    public static final void d(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r101 == false) goto L5;
        int r103 = -1;
    L6:
        r102.width = r103;
        r100.setLayoutParams(r102);
        return;
    L5:
        r103 = -2;
        goto L6
    }
}
