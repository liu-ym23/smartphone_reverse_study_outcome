package w08;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.widget.TextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {
    public static final void b(TextView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != 0) goto L5;
        int r102 = e.f483540a;
        Typeface r103 = e.a(r100.getContext());
    L6:
        r100.setTypeface(r103);
        return;
    L5:
        int r104 = e.f483540a;
        r103 = e.b(r100.getContext(), r101);
        goto L6
    }

    public static final void a(Paint r100, Context r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r102 != 0) goto L5;
        Typeface r103 = e.a(r101);
    L6:
        r100.setTypeface(r103);
        return;
    L5:
        r103 = e.b(r101, r102);
        goto L6
    }
}
