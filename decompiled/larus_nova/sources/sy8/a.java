package sy8;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {
    public static final View a(ViewStub r100, int r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "inflatedView");
        r102.setId(r101);
        ViewParent r103 = r100.getParent();
        if ((r103 instanceof ViewGroup) == false) goto L5;
        ViewGroup r104 = (ViewGroup) r103;
    L6:
        if (r104 != null) goto L8;
        return null;
    L8:
        int r105 = r104.indexOfChild(r100);
        r104.removeViewInLayout(r100);
        ViewGroup.LayoutParams r106 = r100.getLayoutParams();
        if (r106 == null) goto L11;
        r104.addView(r102, r105, r106);
    L12:
        return r102;
    L11:
        r104.addView(r102, r105);
        goto L12
    L5:
        r104 = null;
        goto L6
    }
}
