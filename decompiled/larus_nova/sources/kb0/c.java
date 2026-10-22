package kb0;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c extends TextView {

    public static final class a {
    }

    static {
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r101 = new ConstraintLayout.LayoutParams(-2, -2);
        r101.topToTop = 0;
        r101.startToStart = 0;
        r101.endToEnd = 0;
        r101.bottomToBottom = 0;
        Unit r102 = Unit.INSTANCE;
        setLayoutParams(r101);
        setVisibility(0);
        setIncludeFontPadding(false);
        setMaxLines(1);
        setGravity(17);
        setTextSize(1, 15.0f);
        a(false);
    }

    public final void a(boolean r100) {
        if (r100 == false) goto L4;
        KtvOrderSongThemeManager.d(this, 10);
        setTypeface(Typeface.defaultFromStyle(1));
        return;
    L4:
        KtvOrderSongThemeManager.d(this, KtvOrderSongThemeManager.f70192a);
        setTypeface(Typeface.defaultFromStyle(0));
    }
}
