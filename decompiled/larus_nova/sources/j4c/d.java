package j4c;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements m {
    public d() {
    }

    @Override // j4c.m
    public final void a(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        LinearLayout r102 = new LinearLayout(r100);
        r102.setVisibility(8);
        r102.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r101.addView(r102);
    }
}
