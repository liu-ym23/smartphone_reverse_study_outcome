package z6a;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes32.dex */
public final class p {
    public p() {
    }

    public static StaticLayout a(CharSequence r310, int r311, TextPaint r312, int r313, Layout.Alignment r314, float r315, float r316, boolean r317, TextUtils.TruncateAt r318, int r319, TextDirectionHeuristic r410) {
        int r100 = r319;
        if (r100 == (-1)) goto L5;
    L16:
        Class r101 = Integer.TYPE;     // Catch: Throwable -> L14
        Class r110 = Float.TYPE;     // Catch: Throwable -> L14
        Constructor r102 = StaticLayout.class.getConstructor(new Class[]{CharSequence.class, r101, r101, TextPaint.class, r101, Layout.Alignment.class, TextDirectionHeuristic.class, r110, r110, Boolean.TYPE, TextUtils.TruncateAt.class, r101, r101});     // Catch: Throwable -> L14
        Object[] r103 = new Object[13];     // Catch: Throwable -> L14
        r103[0] = r310;     // Catch: Throwable -> L14
        r103[1] = 0;     // Catch: Throwable -> L14
        r103[2] = Integer.valueOf(r311);     // Catch: Throwable -> L14
        r103[3] = r312;     // Catch: Throwable -> L14
        r103[4] = Integer.valueOf(r313);     // Catch: Throwable -> L14
        r103[5] = r314;     // Catch: Throwable -> L14
        r103[6] = r410;     // Catch: Throwable -> L14
        r103[7] = Float.valueOf(r315);     // Catch: Throwable -> L14
        r103[8] = Float.valueOf(r316);     // Catch: Throwable -> L14
        r103[9] = Boolean.valueOf(r317);     // Catch: Throwable -> L14
        r103[10] = r318;     // Catch: Throwable -> L14
        r103[11] = Integer.valueOf(r313);     // Catch: Throwable -> L14
        if (r100 != (-1)) goto L12;
        r100 = Integer.MAX_VALUE;
    L12:
        r103[12] = Integer.valueOf(r100);     // Catch: Throwable -> L14
        return (StaticLayout) r102.newInstance(r103);
    L15:
        return new StaticLayout(r310, 0, r311, r312, r313, r314, r315, r316, r317);
    L5:
        if (r410 != TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L16;
        return new StaticLayout(r310, 0, r311, r312, r313, r314, r315, r316, r317);
    }
}
