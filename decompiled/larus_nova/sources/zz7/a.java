package zz7;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {
    public static final void a(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r102 = b.g(r100.getContext(), r101);
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        r103.width = r102;
        r103.height = r102;
        r100.setLayoutParams(r103);
    }

    public static final void c(TextView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setTextSize(0, b.h(r100.getContext(), r101));
    }

    public static final void d(TextView r100, LarkFont r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "larkFont");
        r100.setTextSize(0, b.i(r100.getContext(), r101));
    }

    public static final void b(View r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r103 = b.g(r100.getContext(), r101);
        int r104 = b.g(r100.getContext(), r102);
        ViewGroup.LayoutParams r105 = r100.getLayoutParams();
        r105.width = r103;
        r105.height = r104;
        r100.setLayoutParams(r105);
    }
}
