package hda;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.assistant.cocreationreview.c4;
import com.obric.assistant.cocreationreview.j5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f484640a = 0;

    static {
    }

    public c() {
    }

    public static View a(j5 r100, e1 r101) {
        Intrinsics.checkNotNullParameter(r100, "buildContext");
        Intrinsics.checkNotNullParameter(r101, "uiModel");
        Context r102 = r100.getContext();
        LinearLayout r103 = c4.k(r102);
        View r104 = new View(r102);
        r104.setBackgroundColor(-1512723);
        r104.setMinimumHeight(c4.c(r102, 1));
        c4.b(r103, r104, c4.c(r102, 1), 0, c4.c(r102, 8), 4);
        int r105 = b1.f484639a;
        String r106 = r101.f484659e;
        if (StringsKt.isBlank(r106) == false) goto L5;
        r106 = r101.f484658d;
    L5:
        TextView r107 = c4.f(r102, b1.a(r106), 13.5f, -11908796, 0);
        r107.setMaxLines(RangesKt.coerceAtLeast(3, 1));
        r107.setEllipsize(TextUtils.TruncateAt.END);
        r107.setLineSpacing(c4.c(r102, 2), 1.0f);
        c4.b(r103, r107, 0, 0, 0, 14);
        return r103;
    }
}
