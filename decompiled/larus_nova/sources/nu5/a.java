package nu5;

import a08.b;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.util.ui.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static final void a(View r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Context r103 = r100.getContext();
        if (r103 == null) goto L8;
        ViewGroup.LayoutParams r104 = r100.getLayoutParams();
        if ((r104 instanceof ViewGroup.LayoutParams) == false) goto L9;
        r104.width = b.b(n.d(r101), r103);
        r104.height = b.b(n.d(r102), r103);
        r100.setLayoutParams(r104);
        return;
    L9:
        return;
    }
}
