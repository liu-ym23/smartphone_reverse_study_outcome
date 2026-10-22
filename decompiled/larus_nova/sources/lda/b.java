package lda;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.assistant.cocreationreview.c4;
import com.obric.assistant.cocreationreview.j5;
import com.obric.assistant.cocreationreview.k5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements k5<b0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f508787a = null;

    static {
        f508787a = new b();
    }

    public b() {
    }

    @Override // com.obric.assistant.cocreationreview.k5
    public final View a(j5 r100, com.obric.assistant.cocreationreview.a r101) {
        b0 r102 = (b0) r101;
        Intrinsics.checkNotNullParameter(r100, "buildContext");
        Intrinsics.checkNotNullParameter(r102, "record");
        Context r103 = r100.getContext();
        LinearLayout r104 = c4.e(r103);
        r104.setGravity(16);
        r104.setPadding(c4.c(r103, 12), c4.c(r103, 12), c4.c(r103, 12), c4.c(r103, 12));
        r104.setBackground(c4.h(r103, -262657, 16, -1512723, 1));
        r104.addView(c4.f(r103, "豆包回复", 12.5f, e.f508808a.f387362e, 1));
        TextView r105 = c4.f(r103, r102.f508793f, 13.5f, -13418155, 0);
        r105.setMaxLines(5);
        r105.setEllipsize(TextUtils.TruncateAt.END);
        r105.setPadding(c4.c(r103, 12), 0, c4.c(r103, 8), 0);
        r104.addView(r105, new LinearLayout.LayoutParams(0, -2, 1.0f));
        return r104;
    }
}
