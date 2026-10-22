package gz8;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f483423a = 0;

    static {
    }

    public static GradientDrawable a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        GradientDrawable r101 = new GradientDrawable();
        r101.setShape(0);
        boolean r102 = v19.h.f552477a;
        if (v19.h.b(r100) == false) goto L5;
        int r103 = R.color.larus_base_2_night;
    L6:
        r101.setColor(ContextCompat.getColor(r100, r103));
        r101.setCornerRadius(i5.q());
        return r101;
    L5:
        r103 = R.color.larus_base_2_day;
        goto L6
    }

    public static int b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return v19.c.a(R.attr.larus_neutral_100, r100, R.color.larus_neutral_100);
    }

    public static int c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return v19.c.a(R.attr.larus_neutral_50, r100, R.color.larus_neutral_50);
    }

    public static int d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return v19.c.a(R.attr.larus_neutral_transparent_1, r100, R.color.larus_neutral_transparent_1);
    }
}
