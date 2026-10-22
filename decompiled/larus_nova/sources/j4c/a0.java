package j4c;

import android.content.Context;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a0 {
    public static final int a(float r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return (int) j08.b.a(r101, r100);
    }

    public static final int b(TextView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (int) ((((double) (r101 / r100.getPaint().measureText(r100.getContext().getResources().getText(R.string.measure_unit).toString()))) * 0.9d) * ((double) 2));
    }
}
