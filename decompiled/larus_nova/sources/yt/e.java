package yt;

import android.text.TextPaint;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f569004a = 0;

    static {
    }

    public static String a(TextView r100, String r110, String r111, String r112, float r113, int r114, int r115) {
        Intrinsics.checkNotNullParameter(r110, "prefixText");
        Intrinsics.checkNotNullParameter(r111, "postfixText");
        Intrinsics.checkNotNullParameter(r112, "labelText");
        String r101 = r110 + r112 + r111;
        if (r100 != null) goto L5;
        return r101;
    L5:
        int r102 = r100.getMeasuredWidth();
        if (r102 > 0) goto L8;
        return r101;
    L8:
        TextPaint r103 = r100.getPaint();
        float r104 = r103.measureText(r110);
        float r105 = r103.measureText(r111);
        float r106 = r103.getTextSize();
        r103.setTextSize(r113);
        float r116 = r103.measureText(r112);
        r103.setTextSize(r106);
        float r107 = r104 + r116;
        float r117 = r114 * 2;
        float r118 = r115 * 2;
        float r108 = ((r105 + r107) + r117) + r118;
        float r119 = r102 * r100.getMaxLines();
        if (r108 > r119) goto L12;
        return r101;
    L12:
        return r110 + r112 + (r111.substring(0, r103.breakText(r111, 0, r111.length(), true, r119 - ((r107 + r117) + r118), null) - 3) + "...");
    }
}
