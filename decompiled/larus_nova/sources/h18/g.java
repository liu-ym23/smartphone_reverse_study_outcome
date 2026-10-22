package h18;

import android.content.Context;
import android.graphics.Point;
import android.util.Size;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f483541a = 0;

    static {
    }

    @JvmStatic
    public static final Size a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.WindowManager");
        Display r102 = ((WindowManager) r101).getDefaultDisplay();
        Point r103 = new Point();
        r102.getSize(r103);
        return new Size(r103.x, r103.y);
    }
}
