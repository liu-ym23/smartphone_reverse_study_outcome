package pwb;

import android.graphics.Bitmap;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements owb.b {
    public b() {
    }

    @Override // owb.b
    public final void N0(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // owb.b
    public final Bitmap q1(String r100, owb.c r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "config");
        return null;
    }
}
