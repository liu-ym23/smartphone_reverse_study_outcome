package i3b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {
    public static final void a(View r100, g r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "ctx");
        b r103 = (b) r101.f410652c.a(b.class);
        if (r103 != null) goto L5;
        return;
    L5:
        int r104 = UIUtils.dp2px(r101.getContext(), r103.f(r102));
        ViewGroup.LayoutParams r105 = r100.getLayoutParams();
        r105.width = r104;
        r105.height = r104;
        r100.setLayoutParams(r105);
    }

    public static final void b(TextView r100, g r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "ctx");
        b r103 = (b) r101.f410652c.a(b.class);
        if (r103 != null) goto L5;
        return;
    L5:
        r100.setTextSize(1, r103.f(r102));
    }
}
