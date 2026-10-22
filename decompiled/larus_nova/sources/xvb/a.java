package xvb;

import androidx.core.view.WindowInsetsCompat;
import bwb.b;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f565209a = 0;

    static {
    }

    public static int a(WindowInsetsCompat r100) {
        if (r100 != null) goto L7;
        int r101 = b.f21271a;
        b.d(MmUiLogScene.FOUNDATION, "getNavigationAvoidanceBottom", "insets=null", null);
        return 0;
    L7:
        if (r100.getInsets(WindowInsetsCompat.Type.tappableElement()).bottom > 0) goto L10;
        return 0;
    L10:
        return RangesKt.coerceAtLeast(r100.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom, 0);
    }
}
