package j4c;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f {
    public f() {
    }

    public final void a(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        r101.removeAllViews();
        LinearLayout r102 = new LinearLayout(r100);
        r102.setId(R.id.avatar_item_rightItemWrapper);
        r102.setOrientation(0);
        RelativeLayout.LayoutParams r103 = new RelativeLayout.LayoutParams(-2, -2);
        r103.addRule(15);
        r103.setMarginStart(a0.a(12.0f, r100));
        r102.setLayoutParams(r103);
        r102.setVisibility(8);
        r101.addView(r102);
        r102.addView(new FrameLayout(r100), new LinearLayout.LayoutParams(-2, -2));
    }
}
