package wp9;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i {
    public static final Pair<Rect, Rect> b(View r100) {
        if (ViewCompat.isAttachedToWindow(r100) == false) goto L7;
        Rect r101 = new Rect();
        r100.getGlobalVisibleRect(r101);
        int[] r102 = new int[2];
        r100.getLocationOnScreen(r102);
        int r103 = r102[0];
        int r104 = r102[1];
        Rect r105 = new Rect(r103, r104, (int) (r103 + (r100.getWidth() * r100.getScaleX())), (int) (r104 + (r100.getHeight() * r100.getScaleY())));
        int r106 = f.f560626a;
        f.f560626a = r101.width();
        f.f560627b = r101.height();
        return TuplesKt.to(r101, r105);
    L7:
        return TuplesKt.to(null, null);
    }

    public static final void c(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == true) goto L5;
    L7:
        if (r101 == false) goto L9;
        return;
    L9:
        if (r100.getVisibility() == 8) goto L14;
        r100.setVisibility(8);
        return;
    L14:
        return;
    L5:
        if (r100.getVisibility() == 0) goto L7;
        r100.setVisibility(0);
    }

    public static final String a(Context r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Intrinsics.areEqual(r101, "ai_space_list") == false) goto L5;
        int r103 = R.string.larus_drive_empty_btn_upload;
    L6:
        String r104 = r100.getString(r103);
        if (r102 > 1) goto L9;
        return r104;
    L9:
        return r104 + '(' + r102 + ')';
    L5:
        r103 = R.string.larus_album_next_btn;
        goto L6
    }
}
