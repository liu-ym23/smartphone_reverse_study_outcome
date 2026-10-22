package jqa;

import android.graphics.Point;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d {
    public static final /* synthetic */ Point a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int[] r101 = {0, 0};
        r100.getLocationOnScreen(r101);
        return new Point(r101[0], r101[1]);
    }
}
