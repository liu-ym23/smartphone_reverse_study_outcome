package com.bytedance.android.shopping.buynow.slice.counter;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.EditText;
import com.bytedance.android.shopping.extensions.k;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public static WeakReference<EditText> a;
    public static boolean b;
    public static Function1<? super Integer, Unit> c;

    public static Integer a() {
        WeakReference<EditText> r0 = a;
        if (r0 == null) goto L9;
        EditText r1 = r0.get();
        if (r1 != null) goto L8;
        return null;
    L8:
        return Integer.valueOf(k.r(r1.getText().toString(), 0));
    L9:
        return null;
    }

    static {
    }

    public static boolean b(Context r7, MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "ev");
        WeakReference<EditText> r9 = a;
        if (r9 == null) goto L16;
        EditText r10 = r9.get();
        if (r10 == null) goto L16;
        int[] r2 = new int[2];
        r10.getLocationInWindow(r2);
        int[] r3 = {r2[0], r2[1], r2[0] + r10.getWidth(), r2[1] + r10.getHeight()};
        r10.getWindowToken();
        if (r8.getX() <= r3[0]) goto L16;
        if (r8.getX() >= r3[2]) goto L16;
        if (r8.getY() <= r3[1]) goto L16;
        if (r8.getY() >= r3[3]) goto L16;
        return true;
    L16:
        return false;
    }
}
